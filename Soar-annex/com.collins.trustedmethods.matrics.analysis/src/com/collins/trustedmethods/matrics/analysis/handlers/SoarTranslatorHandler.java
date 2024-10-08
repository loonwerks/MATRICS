package com.collins.trustedmethods.matrics.analysis.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.ui.dialogs.Dialog;

import com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause;

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

		translate(soarAnnex);

		return Status.OK_STATUS;
	}

	private void translate(SoarAnnexSubclause soarAnnex) {

		Dialog.showInfo(getJobName(), "Translation Complete!");

	}

}
