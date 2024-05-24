package com.collins.trustedmethods.matrics.soar.ui.unparsing;

import org.eclipse.xtext.serializer.ISerializer;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.annexsupport.AnnexUnparser;

import com.collins.trustedmethods.matrics.soar.serializer.SoarSerializer;
import com.collins.trustedmethods.matrics.soar.ui.internal.SoarActivator;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SoarAnnexUnparser implements AnnexUnparser {

	@Inject
	private ISerializer serializer;

	protected ISerializer getSerializer() {
		if (serializer == null) {
			Injector injector = SoarActivator.getInstance()
					.getInjector(SoarActivator.COM_COLLINS_TRUSTEDMETHODS_MATRICS_SOAR_SOAR);
			serializer = injector.getInstance(SoarSerializer.class);
		}
		return serializer;
	}

	@Override
	public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
		library.setName(null);
		return System.lineSeparator() + getSerializer().serialize(library).replaceAll("^\\\n*", "");
	}

	@Override
	public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
		subclause.setName(null);
		return System.lineSeparator() + getSerializer().serialize(subclause).replaceAll("^\\\n*", "");
	}

}
