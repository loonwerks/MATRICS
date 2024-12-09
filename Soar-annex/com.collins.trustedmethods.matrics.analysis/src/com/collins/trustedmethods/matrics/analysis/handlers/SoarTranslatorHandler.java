package com.collins.trustedmethods.matrics.analysis.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.ui.dialogs.Dialog;

import com.collins.trustedmethods.matrics.soar.soar.Action;
import com.collins.trustedmethods.matrics.soar.soar.ActionSide;
import com.collins.trustedmethods.matrics.soar.soar.AttrValueMake;
import com.collins.trustedmethods.matrics.soar.soar.Cond;
import com.collins.trustedmethods.matrics.soar.soar.ConditionSide;
import com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause;
import com.collins.trustedmethods.matrics.soar.soar.SoarProduction;
import com.collins.trustedmethods.matrics.soar.soar.StateImpCondition;
import com.collins.trustedmethods.matrics.soar.soar.ValueMake;
import com.collins.trustedmethods.matrics.soar.soar.VariableorSymConstant;

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
	    for (SoarProduction production : soarAnnex.getSoarAnnexProductions()) {
	        System.out.println("Production Name: " + production.getName());
	        processConditions(production.getConditions());
	        processActions(production.getActions());
	    }
	}
	private void processConditions(ConditionSide conditions) {
	    if (conditions.getStateImpCondition() != null) {
			StateImpCondition stateImpCondition = conditions.getStateImpCondition();
//	        System.out.println("State/Impasse: " + stateImpCondition.getIdTest().getName());
//	        for (AttrValueTest attrValueTest : stateImpCondition.getAttrValueTest()) {
//	            System.out.println("Attribute-Value Test: " + attrValueTest.toString());
//	        }
	    }

	    for (Cond cond : conditions.getCond()) {
	        System.out.println("Condition: " + cond.getCond());
	    }
	}
	private void processActions(ActionSide actions) {
	    for (Action action : actions.getAction()) {
	        String variableName = action.getVariable().toString();
	        System.out.println("Action Variable: " + variableName);

	        for (AttrValueMake attrValueMake : action.getAttrValMake()) {
	            String attrValueMakeDetails = formatAttrValueMake(attrValueMake);
	            System.out.println("Attribute-Value Make: " + attrValueMakeDetails);
	        }
	    }
	}

	private String formatAttrValueMake(AttrValueMake attrValueMake) {
	    StringBuilder sb = new StringBuilder();
	    sb.append("^");
	    for (VariableorSymConstant variableOrSymConstant : attrValueMake.getVariableOrSymConstant()) {
			sb.append(variableOrSymConstant).append(" ");
	    }
	    for (ValueMake valueMake : attrValueMake.getValueMake()) {
	        sb.append(valueMake.getValue()).append(" ");
	    }
	    return sb.toString().trim();
	}
	private void debugSoarAnnex(SoarAnnexSubclause soarAnnex) {
	    for (SoarProduction production : soarAnnex.getSoarAnnexProductions()) {
	        System.out.println("Production: " + production.getName());
	        System.out.println("Conditions: " + production.getConditions());
	        System.out.println("Actions: " + production.getActions());
	    }
	}



}
