package com.collins.trustedmethods.matrics.analysis.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.ui.dialogs.Dialog;

import com.collins.trustedmethods.matrics.soar.soar.Action;
import com.collins.trustedmethods.matrics.soar.soar.ActionSide;
import com.collins.trustedmethods.matrics.soar.soar.AttrValueMake;
import com.collins.trustedmethods.matrics.soar.soar.AttrValueTest;
import com.collins.trustedmethods.matrics.soar.soar.Cond;
import com.collins.trustedmethods.matrics.soar.soar.CondForOneId;
import com.collins.trustedmethods.matrics.soar.soar.ConditionSide;
import com.collins.trustedmethods.matrics.soar.soar.FuncCall;
import com.collins.trustedmethods.matrics.soar.soar.PositiveCond;
import com.collins.trustedmethods.matrics.soar.soar.Print;
import com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause;
import com.collins.trustedmethods.matrics.soar.soar.SoarProduction;
import com.collins.trustedmethods.matrics.soar.soar.StateImpCondition;
import com.collins.trustedmethods.matrics.soar.soar.util.SoarSwitch;

public class SoarTranslatorHandler extends MatricsHandler {

	@Override
	protected String getJobName() {
		return "Soar Translator";
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
		SoarAnnexSubclause soarAnnex = null;
		for (AnnexSubclause annex : compImpl.getOwnedAnnexSubclauses()) {
			final DefaultAnnexSubclause defaultAnnexSubclause = (DefaultAnnexSubclause) annex;
			if ("soar".equalsIgnoreCase(defaultAnnexSubclause.getName())) {
				soarAnnex = (SoarAnnexSubclause) defaultAnnexSubclause.getParsedAnnexSubclause();
				break;
			}
		}
		if (soarAnnex == null) {
			Dialog.showError(getJobName(), "Selected component implementation must contain a Soar annex");
			return Status.CANCEL_STATUS;
		}

		TranslateSoarSwitch<Void> soarSwitch = new TranslateSoarSwitch<>();
		soarSwitch.doSwitch(soarAnnex);

		return Status.OK_STATUS;
	}

	private static class TranslateSoarSwitch<T> extends SoarSwitch<T> {
		@Override
		public T caseSoarAnnexSubclause(SoarAnnexSubclause object) {
			System.out.println("Processing SoarAnnexSubclause...");
			for (SoarProduction production : object.getSoarAnnexProductions()) {
				doSwitch(production); // Process each production
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseSoarProduction(SoarProduction object) {
			System.out.println("Processing SoarProduction: " + object.getName());
			if (object.getConditions() != null) {
				doSwitch(object.getConditions()); // Process ConditionSide
			}
			if (object.getActions() != null) {
				doSwitch(object.getActions()); // Process ActionSide
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseConditionSide(ConditionSide object) {
			System.out.println("Processing ConditionSide...");
			if (object.getStateImpCondition() != null) {
				doSwitch(object.getStateImpCondition()); // Process StateImpCondition
			}
			for (Cond cond : object.getCond()) {
				doSwitch(cond); // Process individual conditions
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseStateImpCondition(StateImpCondition object) {
			System.out.println("Processing StateImpCondition...");
			System.out.println("State/Impasse: " + (object.getIdTest() != null ? object.getIdTest() : "None"));
			for (AttrValueTest attrValueTest : object.getAttrValueTest()) {
				doSwitch(attrValueTest); // Process attribute-value tests
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseCond(Cond object) {
			System.out.println("Processing Cond...");
			if (object.getCond() != null) {
				doSwitch(object.getCond()); // Process PositiveCond
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T casePositiveCond(PositiveCond object) {
			System.out.println("Processing PositiveCond...");
			if (object.getCondForOneId() != null) {
				doSwitch(object.getCondForOneId()); // Process CondForOneId
			}
			for (Cond nestedCond : object.getCond()) {
				doSwitch(nestedCond); // Process nested conditions
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseCondForOneId(CondForOneId object) {
			System.out.println("Processing CondForOneId...");
			System.out.println("ID Test: " + object.getIdTest());
			for (AttrValueTest attrValueTest : object.getAttrValueTest()) {
				doSwitch(attrValueTest); // Process attribute-value tests
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseAttrValueTest(AttrValueTest object) {
			System.out.println("Processing AttrValueTest...");
			System.out.println("Attributes: " + object.getAttrTest());
			System.out.println("Value Tests: " + object.getValueTest());
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseActionSide(ActionSide object) {
			System.out.println("Processing ActionSide...");
			for (Action action : object.getAction()) {
				doSwitch(action); // Process actions
			}
			for (FuncCall funcCall : object.getFuncCall()) {
				doSwitch(funcCall); // Process function calls
			}
			for (Print print : object.getPrint()) {
				doSwitch(print); // Process print statements
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseAction(Action object) {
			System.out.println("Processing Action...");
			System.out.println("Variable: " + object.getVariable());
			for (AttrValueMake attrValueMake : object.getAttrValMake()) {
				doSwitch(attrValueMake); // Process attribute-value makes
			}
			return (T) Boolean.TRUE;
		}

		@Override
		public T caseAttrValueMake(AttrValueMake object) {
			System.out.println("Processing AttrValueMake...");
			System.out.println("Attributes/Values: " + object.getVariableOrSymConstant());
			return (T) Boolean.TRUE;
		}

		@Override
		public T defaultCase(EObject object) {
			System.out.println("Unhandled EObject type: " + object.eClass().getName());
			return null;
		}
	}
}
