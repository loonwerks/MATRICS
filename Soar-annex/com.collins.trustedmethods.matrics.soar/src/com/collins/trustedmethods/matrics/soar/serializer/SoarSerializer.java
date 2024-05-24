package com.collins.trustedmethods.matrics.soar.serializer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.impl.Serializer;

import com.collins.trustedmethods.matrics.soar.services.SoarGrammarAccess;
import com.collins.trustedmethods.matrics.soar.soar.SoarAnnexLibrary;
import com.collins.trustedmethods.matrics.soar.soar.SoarAnnexSubclause;
import com.google.inject.Inject;

public class SoarSerializer extends Serializer {
	@Inject
	private SoarGrammarAccess grammarAccess;

	@Override
	protected ISerializationContext getIContext(EObject semanticObject) {
		ISerializationContext result = null;
		if (semanticObject instanceof SoarAnnexLibrary) {
			for (final ISerializationContext o : contextFinder.findByContents(semanticObject, null)) {
				if (o.getParserRule() == grammarAccess.getSoarAnnexLibraryRule()) {
					result = o;
					break;
				}
			}
		} else if (semanticObject instanceof SoarAnnexSubclause) {
			for (final ISerializationContext o : contextFinder.findByContents(semanticObject, null)) {
				if (o.getParserRule() == grammarAccess.getSoarAnnexSubclauseRule()) {
					result = o;
					break;
				}
			}
		} else {
			result = super.getIContext(semanticObject);
		}
		return result;

	}
}
