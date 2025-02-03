package com.collins.trustedmethods.matrics.soar.ui.parsing;

import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexParser;

import com.collins.trustedmethods.matrics.soar.parser.antlr.SoarParser;
import com.collins.trustedmethods.matrics.soar.services.SoarGrammarAccess;
import com.collins.trustedmethods.matrics.soar.ui.internal.SoarActivator;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class SoarAnnexParser implements AnnexParser {

	@Inject
	public SoarParser parser;

	protected SoarParser getParser() {
		if (parser == null) {
			Injector injector = SoarActivator.getInstance()
					.getInjector(SoarActivator.COM_COLLINS_TRUSTEDMETHODS_MATRICS_SOAR_SOAR);
			parser = injector.getInstance(SoarParser.class);
		}
		return parser;
	}

	protected SoarGrammarAccess getGrammarAccess() {
		return getParser().getGrammarAccess();
	}

	@Override
	public AnnexLibrary parseAnnexLibrary(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		return (AnnexLibrary) AnnexParseUtil.parse(getParser(), source, getGrammarAccess().getSoarAnnexLibraryRule(),
				filename, line, column, errReporter);
	}

	@Override
	public AnnexSubclause parseAnnexSubclause(String annexName, String source, String filename, int line, int column,
			ParseErrorReporter errReporter) {
		return (AnnexSubclause) AnnexParseUtil.parse(getParser(), source,
				getGrammarAccess().getSoarAnnexSubclauseRule(), filename, line, column, errReporter);
	}

}
