package com.collins.trustedmethods.matrics.analysis.handlers;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.ui.dialogs.Dialog;

import com.collins.trustedmethods.matrics.analysis.NuXmvRunner;
import com.collins.trustedmethods.matrics.analysis.SoarUtil;

import main.main;

public class SoarTranslatorHandler extends MatricsHandler {

	private final static String NUXMV_FOLDER_NAME = "nuXmv";
	private final static String SOAR_FILE_EXT = "soar";
	private final static String NUXMV_FILE_EXT = "smv";

	@Override
	protected String getJobName() {
		return "Soar Analysis";
	}

	@Override
	protected IStatus runJob(Element selection, IProgressMonitor monitor) {

		// Make sure a component implementation is selected
		if (!(selection instanceof ComponentImplementation)) {
			Dialog.showError(getJobName(), "A component implementation must be selected");
			return Status.CANCEL_STATUS;
		}

		// Make sure component implementation contains a Soar annex
		final ComponentImplementation compImpl = (ComponentImplementation) selection;
		String textSoarAnnex = getSoarAnnex(compImpl);
		for (Subcomponent compSub : compImpl.getOwnedSubcomponents()) {
			textSoarAnnex += getSoarAnnex(compSub.getClassifier());
		}

		textSoarAnnex = textSoarAnnex.replace("{**", "").replace("**}", "");

		if (textSoarAnnex.isBlank()) {
			Dialog.showError(getJobName(), "Selected component does not contain a Soar annex!");
			return Status.OK_STATUS;
		}

		final IProject project = SoarUtil.getProject(compImpl);
		if (project == null) {
			Dialog.showError("MATRICS", "Unable to analyze soar.  AADL project could not be determined.");
			return Status.CANCEL_STATUS;
		}

		// Project folder relative to Eclipse file system
		URI nuXmvFolderUri = URI.createPlatformResourceURI(project.getFullPath().toString(), true);

		// Create folder for nuXmv files
		nuXmvFolderUri = nuXmvFolderUri.appendSegment(NUXMV_FOLDER_NAME);
		final IFolder soarFolder = SoarUtil.makeFolder(nuXmvFolderUri);
		if (soarFolder == null || !soarFolder.exists()) {
			Dialog.showError("MATRICS", "Unable to analyze soar.  Could not create nuXmv folder.");
			return Status.CANCEL_STATUS;
		}

		// Refresh directory
		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Translator input file name
		final URI soarUri = nuXmvFolderUri.appendSegment(compImpl.getTypeName()).appendFileExtension(SOAR_FILE_EXT);

		// Write translator input file
		final IFile soarFile = SoarUtil.createFile(soarUri, textSoarAnnex);
		if (soarFile == null) {
			Dialog.showError("MATRICS", "Unable to analyze soar.  Problem saving soar file.");
			return Status.CANCEL_STATUS;
		}

		// Translator input file path (absolute OS path)
		final String soarFilePath = soarFile.getLocation().toString();

		// Run Translator
		final String args[] = { soarFilePath };
		main.main(args);

		// Create nuXmv command file
		final String commandFileContents = "go_msat" + System.lineSeparator() + "check_ltlspec_ic3"
				+ System.lineSeparator() + "quit";
		final URI cmdUri = nuXmvFolderUri.appendSegment(compImpl.getTypeName() + "_cmd")
				.appendFileExtension(NUXMV_FILE_EXT);
		final IFile commandFile = SoarUtil.createFile(cmdUri, commandFileContents);
		if (commandFile == null) {
			Dialog.showError("MATRICS", "Unable to analyze soar.  Problem saving command file.");
			return Status.CANCEL_STATUS;
		}
		final String commandFilePath = commandFile.getLocation().toString();

		// Can we specify the Translator output file name and path,
		// or can the Translator use the same input file name and path?
		final URI nuXmvUri = nuXmvFolderUri.appendSegment(compImpl.getTypeName()).appendFileExtension(NUXMV_FILE_EXT);
		final IFile nuXmvFile = SoarUtil.getFile(nuXmvUri);
		if (nuXmvFile == null || !nuXmvFile.exists()) {
			Dialog.showError("MATRICS", "Unable to analyze soar.  Problem translating soar.");
			return Status.CANCEL_STATUS;
		}
		final String nuXmvFilePath = nuXmvFile.getLocation().toString();

		// Insert constraints and LTL specs into Translator output
		// Temporary: Constraints and LTL specs will eventually be annotated in the AADL model
		final URI specUri = nuXmvFolderUri.appendSegment(compImpl.getTypeName() + "_spec")
				.appendFileExtension(NUXMV_FILE_EXT);
		final IFile specFile = SoarUtil.getFile(specUri);
		if (specFile != null && specFile.exists()) {
			try {
				String nuXmvContents = SoarUtil.readFile(nuXmvFile);
				final String specContents = SoarUtil.readFile(specFile);
				final String searchString = "";
				int index = nuXmvContents.indexOf(searchString);
				nuXmvContents = SoarUtil.insertString(nuXmvContents, specContents, index);

				if (!SoarUtil.writeFile(nuXmvFile, nuXmvContents)) {
					throw new Exception();
				}
			} catch (Exception e) {
				e.printStackTrace();
				Dialog.showError("MATRICS", "Unable to add constraints and LTL specs to nuXmv input file.");
				return Status.CANCEL_STATUS;
			}
		}

		// Launch nuXmv
		// This needs to be done in a separate process otherwise Eclipse freezes up
		final WorkspaceJob job = new WorkspaceJob("nuXmv") {
			@Override
			public IStatus runInWorkspace(IProgressMonitor monitor) {
				monitor.beginTask("nuXmv", IProgressMonitor.UNKNOWN);

				try {
					new NuXmvRunner(monitor, commandFilePath, nuXmvFilePath);
				} catch (Exception e) {
					Dialog.showError("MATRICS", "Unable to analyze soar.  Problem running nuXmv.");
					e.printStackTrace();
				}

				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setRule(ResourcesPlugin.getWorkspace().getRoot());
		job.schedule();

		return Status.OK_STATUS;
	}

	private String getSoarAnnex(Classifier comp) {

		for (AnnexSubclause annex : comp.getOwnedAnnexSubclauses()) {
			final DefaultAnnexSubclause defaultAnnexSubclause = (DefaultAnnexSubclause) annex;
			if ("soar".equalsIgnoreCase(defaultAnnexSubclause.getName())) {
				return defaultAnnexSubclause.getSourceText() + System.lineSeparator();
			}
		}
		return "";
	}

//	private static class TranslateSoarSwitch<T> extends SoarSwitch<T> {
//		@Override
//		public T caseSoarAnnexSubclause(SoarAnnexSubclause object) {
//			System.out.println("Processing SoarAnnexSubclause...");
//			for (SoarProduction production : object.getSoarAnnexProductions()) {
//				doSwitch(production); // Process each production
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseSoarProduction(SoarProduction object) {
//			System.out.println("Processing SoarProduction: " + object.getName());
//			if (object.getConditions() != null) {
//				doSwitch(object.getConditions()); // Process ConditionSide
//			}
//			if (object.getActions() != null) {
//				doSwitch(object.getActions()); // Process ActionSide
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseConditionSide(ConditionSide object) {
//			System.out.println("Processing ConditionSide...");
//			if (object.getStateImpCondition() != null) {
//				doSwitch(object.getStateImpCondition()); // Process StateImpCondition
//			}
//			for (Cond cond : object.getCond()) {
//				doSwitch(cond); // Process individual conditions
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseStateImpCondition(StateImpCondition object) {
//			System.out.println("Processing StateImpCondition...");
//			System.out.println("State/Impasse: " + (object.getIdTest() != null ? object.getIdTest() : "None"));
//			for (AttrValueTest attrValueTest : object.getAttrValueTest()) {
//				doSwitch(attrValueTest); // Process attribute-value tests
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseCond(Cond object) {
//			System.out.println("Processing Cond...");
//			if (object.getCond() != null) {
//				doSwitch(object.getCond()); // Process PositiveCond
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T casePositiveCond(PositiveCond object) {
//			System.out.println("Processing PositiveCond...");
//			if (object.getCondForOneId() != null) {
//				doSwitch(object.getCondForOneId()); // Process CondForOneId
//			}
//			for (Cond nestedCond : object.getCond()) {
//				doSwitch(nestedCond); // Process nested conditions
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseCondForOneId(CondForOneId object) {
//			System.out.println("Processing CondForOneId...");
//			System.out.println("ID Test: " + object.getIdTest());
//			for (AttrValueTest attrValueTest : object.getAttrValueTest()) {
//				doSwitch(attrValueTest); // Process attribute-value tests
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseAttrValueTest(AttrValueTest object) {
//			System.out.println("Processing AttrValueTest...");
//			System.out.println("Attributes: " + object.getAttrTest());
//			System.out.println("Value Tests: " + object.getValueTest());
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseActionSide(ActionSide object) {
//			System.out.println("Processing ActionSide...");
//			for (Action action : object.getAction()) {
//				doSwitch(action); // Process actions
//			}
//			for (FuncCall funcCall : object.getFuncCall()) {
//				doSwitch(funcCall); // Process function calls
//			}
//			for (Print print : object.getPrint()) {
//				doSwitch(print); // Process print statements
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseAction(Action object) {
//			System.out.println("Processing Action...");
//			System.out.println("Variable: " + object.getVariable());
//			for (AttrValueMake attrValueMake : object.getAttrValMake()) {
//				doSwitch(attrValueMake); // Process attribute-value makes
//			}
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T caseAttrValueMake(AttrValueMake object) {
//			System.out.println("Processing AttrValueMake...");
//			System.out.println("Attributes/Values: " + object.getVariableOrSymConstant());
//			return (T) Boolean.TRUE;
//		}
//
//		@Override
//		public T defaultCase(EObject object) {
//			System.out.println("Unhandled EObject type: " + object.eClass().getName());
//			return null;
//		}
//	}
}
