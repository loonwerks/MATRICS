package com.collins.trustedmethods.matrics.soar.ui.highlighting;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexHighlighter;
import org.osate.annexsupport.AnnexHighlighterPositionAcceptor;
import org.osate.annexsupport.AnnexHighlighterRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUtil;

public class SoarSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	private final String ANNEXTEXTKEYWORD = "annex";
	private final String SEMICOLONKEYWORD = ";";

	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null) {
			return;
		}
		final AnnexHighlighterRegistry registry = (AnnexHighlighterRegistry) AnnexRegistry
				.getRegistry(AnnexRegistry.ANNEX_HIGHLIGHTER_EXT_ID);

		for (EObject obj : resource.getContents()) {
			for (DefaultAnnexSubclause subclause : EcoreUtil2.eAllOfType(obj, DefaultAnnexSubclause.class)) {
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(subclause, acceptor);

				if (annexAcceptor != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(subclause.getName());
					if (highlighter != null) {
						highlighter.highlightAnnexSubclause(subclause, annexAcceptor);
					} else {
						addHighlight(subclause, annexAcceptor);
					}
				}
			}

			for (AnnexLibrary library : EcoreUtil2.eAllOfType(obj, AnnexLibrary.class)) {
				AnnexHighlighterPositionAcceptor annexAcceptor = createAcceptor(library, acceptor);

				if (annexAcceptor != null) {
					AnnexHighlighter highlighter = registry.getAnnexHighlighter(library.getName());
					if (highlighter != null) {
						highlighter.highlightAnnexLibrary(library, annexAcceptor);
					} else {
						addHighlight(library, annexAcceptor);
					}
				}
			}
		}
	}

	/**
	 * Creates an AnnexHighlighterPositionAcceptor specific to a annex source block
	 * @param semanticObj the AnnexLibrary or AnnexSubclause to build the acceptor for
	 * @param acceptor the xtext Acceptor that is wraps
	 * @return the new AnnexHighlighterPositionAcceptor or null if one could not be created
	 */
	private AnnexHighlighterPositionAcceptor createAcceptor(EObject semanticObj,
			final IHighlightedPositionAcceptor acceptor) {
		final int annexTextLength = AnnexUtil.getSourceText(semanticObj).length();
		final int annexTextOffset = AnnexUtil.getAnnexOffset(semanticObj);

		return (offset, length, id) -> {
			if (offset < 0) {
				return;// throw new RuntimeException("Offset is less than 0");
			}

			if (offset > annexTextLength) {
				return;// throw new RuntimeException("Offset is greater than source text length");
			}

			// Calculate the absolute offset
			int absOffset = annexTextOffset + offset;
			acceptor.addPosition(absOffset, length, id);
		};
	}

	private void addHighlight(EObject annexObject, AnnexHighlighterPositionAcceptor acceptor) {
		EObject parsedAnnexObject = AnnexUtil.getParsedAnnex(annexObject);
		if (parsedAnnexObject == null) {
			return;
		}
		INode annexnode = NodeModelUtils.getNode(parsedAnnexObject);
		if (annexnode == null) {
			return;
		}
		INode root = annexnode.getRootNode();
		final int annexTextLength = AnnexUtil.getSourceText(annexObject).length();
		final int annexTextOffset = AnnexUtil.getAnnexOffset(annexObject);
		for (INode node : root.getAsTreeIterable()) {
			EObject ge = node.getGrammarElement();
			if (ge instanceof RuleCall) {
				ge = ((RuleCall) ge).getRule();
			}

			if (ge instanceof Keyword) {
				String keywordValue = ((Keyword) ge).getValue();
				int offset = node.getOffset() - annexTextOffset;
				if (offset < 0 && keywordValue.equalsIgnoreCase(ANNEXTEXTKEYWORD)) {
					continue;
				}
				if (offset > annexTextLength && keywordValue.equalsIgnoreCase(SEMICOLONKEYWORD)) {
					continue;
				}
				// adjust for added whitespace in front of annex text
				acceptor.addPosition(offset, node.getLength(), AnnexHighlighterPositionAcceptor.KEYWORD_ID);
			} else if (ge instanceof TerminalRule) {
				if (((TerminalRule) ge).getName().equalsIgnoreCase("SL_COMMENT")) {
					// adjust for added whitespace in front of annex text
					acceptor.addPosition(node.getOffset() - annexTextOffset, node.getLength(),
							AnnexHighlighterPositionAcceptor.COMMENT_ID);
				} else if (((TerminalRule) ge).getName().equalsIgnoreCase("STRING")) {
					// adjust for added whitespace in front of annex text
					acceptor.addPosition(node.getOffset() - annexTextOffset, node.getLength(),
							AnnexHighlighterPositionAcceptor.STRING_ID);
				}
			}
		}
	}

}
