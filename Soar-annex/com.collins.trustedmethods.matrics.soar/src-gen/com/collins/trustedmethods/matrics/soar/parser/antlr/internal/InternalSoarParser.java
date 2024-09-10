package com.collins.trustedmethods.matrics.soar.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.collins.trustedmethods.matrics.soar.services.SoarGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSoarParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ISupport", "OSupport", "Template", "Default", "Impasse", "Crlf", "Chunk", "State", "Write", "QuotationMarkQuotationMarkQuotationMark", "HyphenMinusHyphenMinusGreaterThanSign", "LessThanSignEqualsSignGreaterThanSign", "LessThanSignLessThanSign", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "EqualsSignEqualsSign", "GreaterThanSignEqualsSign", "GreaterThanSignGreaterThanSign", "Gp", "Sp", "ExclamationMark", "Ampersand", "LeftParenthesis", "RightParenthesis", "Asterisk", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Solidus", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "RightCurlyBracket", "Tilde", "RULE_SYM_CONSTANT_STRING", "RULE_PRINT_STRING", "RULE_FLOAT", "RULE_INT", "RULE_WS", "RULE_SL_COMMENT"
    };
    public static final int LessThanSignGreaterThanSign=18;
    public static final int Gp=22;
    public static final int LessThanSign=35;
    public static final int Template=6;
    public static final int LeftParenthesis=26;
    public static final int Ampersand=25;
    public static final int RightSquareBracket=40;
    public static final int ExclamationMark=24;
    public static final int GreaterThanSign=37;
    public static final int ISupport=4;
    public static final int OSupport=5;
    public static final int RightParenthesis=27;
    public static final int Chunk=10;
    public static final int GreaterThanSignEqualsSign=20;
    public static final int EqualsSignEqualsSign=19;
    public static final int State=11;
    public static final int PlusSign=29;
    public static final int RULE_INT=48;
    public static final int LeftSquareBracket=39;
    public static final int LessThanSignLessThanSign=16;
    public static final int Write=12;
    public static final int LessThanSignEqualsSignGreaterThanSign=15;
    public static final int RULE_PRINT_STRING=46;
    public static final int Impasse=8;
    public static final int RULE_SL_COMMENT=50;
    public static final int Comma=30;
    public static final int EqualsSign=36;
    public static final int HyphenMinus=31;
    public static final int LessThanSignEqualsSign=17;
    public static final int Solidus=33;
    public static final int Colon=34;
    public static final int RightCurlyBracket=43;
    public static final int EOF=-1;
    public static final int Asterisk=28;
    public static final int FullStop=32;
    public static final int RULE_WS=49;
    public static final int QuotationMarkQuotationMarkQuotationMark=13;
    public static final int LeftCurlyBracket=42;
    public static final int Crlf=9;
    public static final int Tilde=44;
    public static final int GreaterThanSignGreaterThanSign=21;
    public static final int Default=7;
    public static final int CircumflexAccent=41;
    public static final int CommercialAt=38;
    public static final int HyphenMinusHyphenMinusGreaterThanSign=14;
    public static final int RULE_FLOAT=47;
    public static final int RULE_SYM_CONSTANT_STRING=45;
    public static final int Sp=23;

    // delegates
    // delegators


        public InternalSoarParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSoarParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSoarParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSoarParser.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */

     	private SoarGrammarAccess grammarAccess;

        public InternalSoarParser(TokenStream input, SoarGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "AnnexLibrary";
       	}

       	@Override
       	protected SoarGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAnnexLibrary"
    // InternalSoarParser.g:83:1: entryRuleAnnexLibrary returns [EObject current=null] : iv_ruleAnnexLibrary= ruleAnnexLibrary EOF ;
    public final EObject entryRuleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexLibrary = null;


        try {
            // InternalSoarParser.g:83:53: (iv_ruleAnnexLibrary= ruleAnnexLibrary EOF )
            // InternalSoarParser.g:84:2: iv_ruleAnnexLibrary= ruleAnnexLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnexLibraryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAnnexLibrary=ruleAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnexLibrary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnexLibrary"


    // $ANTLR start "ruleAnnexLibrary"
    // InternalSoarParser.g:90:1: ruleAnnexLibrary returns [EObject current=null] : this_SoarAnnexLibrary_0= ruleSoarAnnexLibrary ;
    public final EObject ruleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_SoarAnnexLibrary_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:96:2: (this_SoarAnnexLibrary_0= ruleSoarAnnexLibrary )
            // InternalSoarParser.g:97:2: this_SoarAnnexLibrary_0= ruleSoarAnnexLibrary
            {
            if ( state.backtracking==0 ) {

              		/* */
              	
            }
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getAnnexLibraryAccess().getSoarAnnexLibraryParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_SoarAnnexLibrary_0=ruleSoarAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_SoarAnnexLibrary_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnexLibrary"


    // $ANTLR start "entryRuleSoarAnnexLibrary"
    // InternalSoarParser.g:111:1: entryRuleSoarAnnexLibrary returns [EObject current=null] : iv_ruleSoarAnnexLibrary= ruleSoarAnnexLibrary EOF ;
    public final EObject entryRuleSoarAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoarAnnexLibrary = null;


        try {
            // InternalSoarParser.g:111:57: (iv_ruleSoarAnnexLibrary= ruleSoarAnnexLibrary EOF )
            // InternalSoarParser.g:112:2: iv_ruleSoarAnnexLibrary= ruleSoarAnnexLibrary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSoarAnnexLibraryRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSoarAnnexLibrary=ruleSoarAnnexLibrary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSoarAnnexLibrary; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoarAnnexLibrary"


    // $ANTLR start "ruleSoarAnnexLibrary"
    // InternalSoarParser.g:118:1: ruleSoarAnnexLibrary returns [EObject current=null] : ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) ;
    public final EObject ruleSoarAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_soarAnnexProductions_1_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:124:2: ( ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) )
            // InternalSoarParser.g:125:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            {
            // InternalSoarParser.g:125:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            // InternalSoarParser.g:126:3: () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            {
            // InternalSoarParser.g:126:3: ()
            // InternalSoarParser.g:127:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSoarAnnexLibraryAccess().getSoarAnnexLibraryAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:136:3: ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Gp && LA1_0<=Sp)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSoarParser.g:137:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    {
            	    // InternalSoarParser.g:137:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    // InternalSoarParser.g:138:5: lv_soarAnnexProductions_1_0= ruleSoarProduction
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSoarAnnexLibraryAccess().getSoarAnnexProductionsSoarProductionParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_soarAnnexProductions_1_0=ruleSoarProduction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSoarAnnexLibraryRule());
            	      					}
            	      					add(
            	      						current,
            	      						"soarAnnexProductions",
            	      						lv_soarAnnexProductions_1_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.SoarProduction");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoarAnnexLibrary"


    // $ANTLR start "entryRuleSoarAnnexSubclause"
    // InternalSoarParser.g:159:1: entryRuleSoarAnnexSubclause returns [EObject current=null] : iv_ruleSoarAnnexSubclause= ruleSoarAnnexSubclause EOF ;
    public final EObject entryRuleSoarAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoarAnnexSubclause = null;


        try {
            // InternalSoarParser.g:159:59: (iv_ruleSoarAnnexSubclause= ruleSoarAnnexSubclause EOF )
            // InternalSoarParser.g:160:2: iv_ruleSoarAnnexSubclause= ruleSoarAnnexSubclause EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSoarAnnexSubclauseRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSoarAnnexSubclause=ruleSoarAnnexSubclause();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSoarAnnexSubclause; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoarAnnexSubclause"


    // $ANTLR start "ruleSoarAnnexSubclause"
    // InternalSoarParser.g:166:1: ruleSoarAnnexSubclause returns [EObject current=null] : ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) ;
    public final EObject ruleSoarAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_soarAnnexProductions_1_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:172:2: ( ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) )
            // InternalSoarParser.g:173:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            {
            // InternalSoarParser.g:173:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            // InternalSoarParser.g:174:3: () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            {
            // InternalSoarParser.g:174:3: ()
            // InternalSoarParser.g:175:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSoarAnnexSubclauseAccess().getSoarAnnexSubclauseAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:184:3: ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=Gp && LA2_0<=Sp)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSoarParser.g:185:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    {
            	    // InternalSoarParser.g:185:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    // InternalSoarParser.g:186:5: lv_soarAnnexProductions_1_0= ruleSoarProduction
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSoarAnnexSubclauseAccess().getSoarAnnexProductionsSoarProductionParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_3);
            	    lv_soarAnnexProductions_1_0=ruleSoarProduction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSoarAnnexSubclauseRule());
            	      					}
            	      					add(
            	      						current,
            	      						"soarAnnexProductions",
            	      						lv_soarAnnexProductions_1_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.SoarProduction");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoarAnnexSubclause"


    // $ANTLR start "entryRuleSoarProduction"
    // InternalSoarParser.g:207:1: entryRuleSoarProduction returns [EObject current=null] : iv_ruleSoarProduction= ruleSoarProduction EOF ;
    public final EObject entryRuleSoarProduction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoarProduction = null;


        try {
            // InternalSoarParser.g:207:55: (iv_ruleSoarProduction= ruleSoarProduction EOF )
            // InternalSoarParser.g:208:2: iv_ruleSoarProduction= ruleSoarProduction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSoarProductionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSoarProduction=ruleSoarProduction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSoarProduction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSoarProduction"


    // $ANTLR start "ruleSoarProduction"
    // InternalSoarParser.g:214:1: ruleSoarProduction returns [EObject current=null] : ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleConditionSide ) ) otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSide ) ) otherlv_10= RightCurlyBracket ) ;
    public final EObject ruleSoarProduction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_doc_5_0 = null;

        AntlrDatatypeRuleToken lv_flag_6_0 = null;

        EObject lv_conditions_7_0 = null;

        EObject lv_actions_9_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:220:2: ( ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleConditionSide ) ) otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSide ) ) otherlv_10= RightCurlyBracket ) )
            // InternalSoarParser.g:221:2: ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleConditionSide ) ) otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSide ) ) otherlv_10= RightCurlyBracket )
            {
            // InternalSoarParser.g:221:2: ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleConditionSide ) ) otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSide ) ) otherlv_10= RightCurlyBracket )
            // InternalSoarParser.g:222:3: () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleConditionSide ) ) otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSide ) ) otherlv_10= RightCurlyBracket
            {
            // InternalSoarParser.g:222:3: ()
            // InternalSoarParser.g:223:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSoarProductionAccess().getSoarProductionAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:232:3: (otherlv_1= Sp | otherlv_2= Gp )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Sp) ) {
                alt3=1;
            }
            else if ( (LA3_0==Gp) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalSoarParser.g:233:4: otherlv_1= Sp
                    {
                    otherlv_1=(Token)match(input,Sp,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSoarProductionAccess().getSpKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:238:4: otherlv_2= Gp
                    {
                    otherlv_2=(Token)match(input,Gp,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getSoarProductionAccess().getGpKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            otherlv_3=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSoarProductionAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalSoarParser.g:247:3: ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) )
            // InternalSoarParser.g:248:4: (lv_name_4_0= RULE_SYM_CONSTANT_STRING )
            {
            // InternalSoarParser.g:248:4: (lv_name_4_0= RULE_SYM_CONSTANT_STRING )
            // InternalSoarParser.g:249:5: lv_name_4_0= RULE_SYM_CONSTANT_STRING
            {
            lv_name_4_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getSoarProductionAccess().getNameSYM_CONSTANT_STRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSoarProductionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
              				
            }

            }


            }

            // InternalSoarParser.g:265:3: ( (lv_doc_5_0= ruleDocumentation ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==QuotationMarkQuotationMarkQuotationMark) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSoarParser.g:266:4: (lv_doc_5_0= ruleDocumentation )
                    {
                    // InternalSoarParser.g:266:4: (lv_doc_5_0= ruleDocumentation )
                    // InternalSoarParser.g:267:5: lv_doc_5_0= ruleDocumentation
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSoarProductionAccess().getDocDocumentationParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_doc_5_0=ruleDocumentation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSoarProductionRule());
                      					}
                      					set(
                      						current,
                      						"doc",
                      						lv_doc_5_0,
                      						"com.collins.trustedmethods.matrics.soar.Soar.Documentation");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSoarParser.g:284:3: ( (lv_flag_6_0= ruleFlags ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Colon) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSoarParser.g:285:4: (lv_flag_6_0= ruleFlags )
                    {
                    // InternalSoarParser.g:285:4: (lv_flag_6_0= ruleFlags )
                    // InternalSoarParser.g:286:5: lv_flag_6_0= ruleFlags
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSoarProductionAccess().getFlagFlagsParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_6);
                    lv_flag_6_0=ruleFlags();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSoarProductionRule());
                      					}
                      					set(
                      						current,
                      						"flag",
                      						lv_flag_6_0,
                      						"com.collins.trustedmethods.matrics.soar.Soar.Flags");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSoarParser.g:303:3: ( (lv_conditions_7_0= ruleConditionSide ) )
            // InternalSoarParser.g:304:4: (lv_conditions_7_0= ruleConditionSide )
            {
            // InternalSoarParser.g:304:4: (lv_conditions_7_0= ruleConditionSide )
            // InternalSoarParser.g:305:5: lv_conditions_7_0= ruleConditionSide
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSoarProductionAccess().getConditionsConditionSideParserRuleCall_6_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_7);
            lv_conditions_7_0=ruleConditionSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSoarProductionRule());
              					}
              					set(
              						current,
              						"conditions",
              						lv_conditions_7_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.ConditionSide");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_8=(Token)match(input,HyphenMinusHyphenMinusGreaterThanSign,FollowSets000.FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getSoarProductionAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_7());
              		
            }
            // InternalSoarParser.g:326:3: ( (lv_actions_9_0= ruleActionSide ) )
            // InternalSoarParser.g:327:4: (lv_actions_9_0= ruleActionSide )
            {
            // InternalSoarParser.g:327:4: (lv_actions_9_0= ruleActionSide )
            // InternalSoarParser.g:328:5: lv_actions_9_0= ruleActionSide
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSoarProductionAccess().getActionsActionSideParserRuleCall_8_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_9);
            lv_actions_9_0=ruleActionSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSoarProductionRule());
              					}
              					set(
              						current,
              						"actions",
              						lv_actions_9_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.ActionSide");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_10=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getSoarProductionAccess().getRightCurlyBracketKeyword_9());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSoarProduction"


    // $ANTLR start "entryRuleDocumentation"
    // InternalSoarParser.g:353:1: entryRuleDocumentation returns [String current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final String entryRuleDocumentation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDocumentation = null;


        try {
            // InternalSoarParser.g:353:53: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalSoarParser.g:354:2: iv_ruleDocumentation= ruleDocumentation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDocumentationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDocumentation=ruleDocumentation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDocumentation.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDocumentation"


    // $ANTLR start "ruleDocumentation"
    // InternalSoarParser.g:360:1: ruleDocumentation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= QuotationMarkQuotationMarkQuotationMark this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING kw= QuotationMarkQuotationMarkQuotationMark ) ;
    public final AntlrDatatypeRuleToken ruleDocumentation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_SYM_CONSTANT_STRING_1=null;


        	enterRule();

        try {
            // InternalSoarParser.g:366:2: ( (kw= QuotationMarkQuotationMarkQuotationMark this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING kw= QuotationMarkQuotationMarkQuotationMark ) )
            // InternalSoarParser.g:367:2: (kw= QuotationMarkQuotationMarkQuotationMark this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING kw= QuotationMarkQuotationMarkQuotationMark )
            {
            // InternalSoarParser.g:367:2: (kw= QuotationMarkQuotationMarkQuotationMark this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING kw= QuotationMarkQuotationMarkQuotationMark )
            // InternalSoarParser.g:368:3: kw= QuotationMarkQuotationMarkQuotationMark this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING kw= QuotationMarkQuotationMarkQuotationMark
            {
            kw=(Token)match(input,QuotationMarkQuotationMarkQuotationMark,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getDocumentationAccess().getQuotationMarkQuotationMarkQuotationMarkKeyword_0());
              		
            }
            this_SYM_CONSTANT_STRING_1=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_SYM_CONSTANT_STRING_1);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_SYM_CONSTANT_STRING_1, grammarAccess.getDocumentationAccess().getSYM_CONSTANT_STRINGTerminalRuleCall_1());
              		
            }
            kw=(Token)match(input,QuotationMarkQuotationMarkQuotationMark,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getDocumentationAccess().getQuotationMarkQuotationMarkQuotationMarkKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDocumentation"


    // $ANTLR start "entryRuleFlags"
    // InternalSoarParser.g:389:1: entryRuleFlags returns [String current=null] : iv_ruleFlags= ruleFlags EOF ;
    public final String entryRuleFlags() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlags = null;


        try {
            // InternalSoarParser.g:389:45: (iv_ruleFlags= ruleFlags EOF )
            // InternalSoarParser.g:390:2: iv_ruleFlags= ruleFlags EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFlagsRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFlags=ruleFlags();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFlags.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFlags"


    // $ANTLR start "ruleFlags"
    // InternalSoarParser.g:396:1: ruleFlags returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) ) ;
    public final AntlrDatatypeRuleToken ruleFlags() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:402:2: ( (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) ) )
            // InternalSoarParser.g:403:2: (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) )
            {
            // InternalSoarParser.g:403:2: (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) )
            // InternalSoarParser.g:404:3: kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template )
            {
            kw=(Token)match(input,Colon,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getFlagsAccess().getColonKeyword_0());
              		
            }
            // InternalSoarParser.g:409:3: (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template )
            int alt6=5;
            switch ( input.LA(1) ) {
            case OSupport:
                {
                alt6=1;
                }
                break;
            case ISupport:
                {
                alt6=2;
                }
                break;
            case Chunk:
                {
                alt6=3;
                }
                break;
            case Default:
                {
                alt6=4;
                }
                break;
            case Template:
                {
                alt6=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalSoarParser.g:410:4: kw= OSupport
                    {
                    kw=(Token)match(input,OSupport,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getOSupportKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:416:4: kw= ISupport
                    {
                    kw=(Token)match(input,ISupport,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getISupportKeyword_1_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:422:4: kw= Chunk
                    {
                    kw=(Token)match(input,Chunk,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getChunkKeyword_1_2());
                      			
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:428:4: kw= Default
                    {
                    kw=(Token)match(input,Default,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getDefaultKeyword_1_3());
                      			
                    }

                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:434:4: kw= Template
                    {
                    kw=(Token)match(input,Template,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getTemplateKeyword_1_4());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFlags"


    // $ANTLR start "entryRuleConditionSide"
    // InternalSoarParser.g:444:1: entryRuleConditionSide returns [EObject current=null] : iv_ruleConditionSide= ruleConditionSide EOF ;
    public final EObject entryRuleConditionSide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionSide = null;


        try {
            // InternalSoarParser.g:444:54: (iv_ruleConditionSide= ruleConditionSide EOF )
            // InternalSoarParser.g:445:2: iv_ruleConditionSide= ruleConditionSide EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionSideRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConditionSide=ruleConditionSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionSide; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionSide"


    // $ANTLR start "ruleConditionSide"
    // InternalSoarParser.g:451:1: ruleConditionSide returns [EObject current=null] : ( () ( (lv_stateImpCondition_1_0= ruleStateImpCondition ) ) ( (lv_cond_2_0= ruleCond ) )* ) ;
    public final EObject ruleConditionSide() throws RecognitionException {
        EObject current = null;

        EObject lv_stateImpCondition_1_0 = null;

        EObject lv_cond_2_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:457:2: ( ( () ( (lv_stateImpCondition_1_0= ruleStateImpCondition ) ) ( (lv_cond_2_0= ruleCond ) )* ) )
            // InternalSoarParser.g:458:2: ( () ( (lv_stateImpCondition_1_0= ruleStateImpCondition ) ) ( (lv_cond_2_0= ruleCond ) )* )
            {
            // InternalSoarParser.g:458:2: ( () ( (lv_stateImpCondition_1_0= ruleStateImpCondition ) ) ( (lv_cond_2_0= ruleCond ) )* )
            // InternalSoarParser.g:459:3: () ( (lv_stateImpCondition_1_0= ruleStateImpCondition ) ) ( (lv_cond_2_0= ruleCond ) )*
            {
            // InternalSoarParser.g:459:3: ()
            // InternalSoarParser.g:460:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getConditionSideAccess().getConditionSideAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:469:3: ( (lv_stateImpCondition_1_0= ruleStateImpCondition ) )
            // InternalSoarParser.g:470:4: (lv_stateImpCondition_1_0= ruleStateImpCondition )
            {
            // InternalSoarParser.g:470:4: (lv_stateImpCondition_1_0= ruleStateImpCondition )
            // InternalSoarParser.g:471:5: lv_stateImpCondition_1_0= ruleStateImpCondition
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConditionSideAccess().getStateImpConditionStateImpConditionParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_12);
            lv_stateImpCondition_1_0=ruleStateImpCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConditionSideRule());
              					}
              					set(
              						current,
              						"stateImpCondition",
              						lv_stateImpCondition_1_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.StateImpCondition");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSoarParser.g:488:3: ( (lv_cond_2_0= ruleCond ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==LeftParenthesis||LA7_0==HyphenMinus||LA7_0==LeftCurlyBracket) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSoarParser.g:489:4: (lv_cond_2_0= ruleCond )
            	    {
            	    // InternalSoarParser.g:489:4: (lv_cond_2_0= ruleCond )
            	    // InternalSoarParser.g:490:5: lv_cond_2_0= ruleCond
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getConditionSideAccess().getCondCondParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_12);
            	    lv_cond_2_0=ruleCond();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getConditionSideRule());
            	      					}
            	      					add(
            	      						current,
            	      						"cond",
            	      						lv_cond_2_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.Cond");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionSide"


    // $ANTLR start "entryRuleStateImpCondition"
    // InternalSoarParser.g:511:1: entryRuleStateImpCondition returns [EObject current=null] : iv_ruleStateImpCondition= ruleStateImpCondition EOF ;
    public final EObject entryRuleStateImpCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateImpCondition = null;


        try {
            // InternalSoarParser.g:511:58: (iv_ruleStateImpCondition= ruleStateImpCondition EOF )
            // InternalSoarParser.g:512:2: iv_ruleStateImpCondition= ruleStateImpCondition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateImpConditionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleStateImpCondition=ruleStateImpCondition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStateImpCondition; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStateImpCondition"


    // $ANTLR start "ruleStateImpCondition"
    // InternalSoarParser.g:518:1: ruleStateImpCondition returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE ) ( (lv_idTest_4_0= ruleVariable ) )? ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis ) ;
    public final EObject ruleStateImpCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_idTest_4_0 = null;

        EObject lv_attrValueTest_5_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:524:2: ( ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE ) ( (lv_idTest_4_0= ruleVariable ) )? ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis ) )
            // InternalSoarParser.g:525:2: ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE ) ( (lv_idTest_4_0= ruleVariable ) )? ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis )
            {
            // InternalSoarParser.g:525:2: ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE ) ( (lv_idTest_4_0= ruleVariable ) )? ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis )
            // InternalSoarParser.g:526:3: () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE ) ( (lv_idTest_4_0= ruleVariable ) )? ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis
            {
            // InternalSoarParser.g:526:3: ()
            // InternalSoarParser.g:527:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStateImpConditionAccess().getStateImpCondAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStateImpConditionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalSoarParser.g:540:3: ( ruleSTATE | ruleIMPASSE )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==State) ) {
                alt8=1;
            }
            else if ( (LA8_0==Impasse) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalSoarParser.g:541:4: ruleSTATE
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStateImpConditionAccess().getSTATEParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleSTATE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:552:4: ruleIMPASSE
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStateImpConditionAccess().getIMPASSEParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    ruleIMPASSE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalSoarParser.g:563:3: ( (lv_idTest_4_0= ruleVariable ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LessThanSign) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalSoarParser.g:564:4: (lv_idTest_4_0= ruleVariable )
                    {
                    // InternalSoarParser.g:564:4: (lv_idTest_4_0= ruleVariable )
                    // InternalSoarParser.g:565:5: lv_idTest_4_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateImpConditionAccess().getIdTestVariableParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_14);
                    lv_idTest_4_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateImpConditionRule());
                      					}
                      					set(
                      						current,
                      						"idTest",
                      						lv_idTest_4_0,
                      						"com.collins.trustedmethods.matrics.soar.Soar.Variable");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalSoarParser.g:582:3: ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==HyphenMinus||LA10_0==CircumflexAccent) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSoarParser.g:583:4: (lv_attrValueTest_5_0= ruleAttrValueTest )
            	    {
            	    // InternalSoarParser.g:583:4: (lv_attrValueTest_5_0= ruleAttrValueTest )
            	    // InternalSoarParser.g:584:5: lv_attrValueTest_5_0= ruleAttrValueTest
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStateImpConditionAccess().getAttrValueTestAttrValueTestParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    lv_attrValueTest_5_0=ruleAttrValueTest();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStateImpConditionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attrValueTest",
            	      						lv_attrValueTest_5_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.AttrValueTest");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);

            otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getStateImpConditionAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateImpCondition"


    // $ANTLR start "entryRuleCond"
    // InternalSoarParser.g:609:1: entryRuleCond returns [EObject current=null] : iv_ruleCond= ruleCond EOF ;
    public final EObject entryRuleCond() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCond = null;


        try {
            // InternalSoarParser.g:609:45: (iv_ruleCond= ruleCond EOF )
            // InternalSoarParser.g:610:2: iv_ruleCond= ruleCond EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCond=ruleCond();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCond; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCond"


    // $ANTLR start "ruleCond"
    // InternalSoarParser.g:616:1: ruleCond returns [EObject current=null] : ( () (otherlv_1= HyphenMinus )? ( (lv_cond_2_0= rulePositiveCond ) ) ) ;
    public final EObject ruleCond() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_cond_2_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:622:2: ( ( () (otherlv_1= HyphenMinus )? ( (lv_cond_2_0= rulePositiveCond ) ) ) )
            // InternalSoarParser.g:623:2: ( () (otherlv_1= HyphenMinus )? ( (lv_cond_2_0= rulePositiveCond ) ) )
            {
            // InternalSoarParser.g:623:2: ( () (otherlv_1= HyphenMinus )? ( (lv_cond_2_0= rulePositiveCond ) ) )
            // InternalSoarParser.g:624:3: () (otherlv_1= HyphenMinus )? ( (lv_cond_2_0= rulePositiveCond ) )
            {
            // InternalSoarParser.g:624:3: ()
            // InternalSoarParser.g:625:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCondAccess().getCondAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:634:3: (otherlv_1= HyphenMinus )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==HyphenMinus) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalSoarParser.g:635:4: otherlv_1= HyphenMinus
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCondAccess().getHyphenMinusKeyword_1());
                      			
                    }

                    }
                    break;

            }

            // InternalSoarParser.g:640:3: ( (lv_cond_2_0= rulePositiveCond ) )
            // InternalSoarParser.g:641:4: (lv_cond_2_0= rulePositiveCond )
            {
            // InternalSoarParser.g:641:4: (lv_cond_2_0= rulePositiveCond )
            // InternalSoarParser.g:642:5: lv_cond_2_0= rulePositiveCond
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCondAccess().getCondPositiveCondParserRuleCall_2_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_cond_2_0=rulePositiveCond();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCondRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.PositiveCond");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCond"


    // $ANTLR start "entryRulePositiveCond"
    // InternalSoarParser.g:663:1: entryRulePositiveCond returns [EObject current=null] : iv_rulePositiveCond= rulePositiveCond EOF ;
    public final EObject entryRulePositiveCond() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePositiveCond = null;


        try {
            // InternalSoarParser.g:663:53: (iv_rulePositiveCond= rulePositiveCond EOF )
            // InternalSoarParser.g:664:2: iv_rulePositiveCond= rulePositiveCond EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPositiveCondRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePositiveCond=rulePositiveCond();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePositiveCond; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePositiveCond"


    // $ANTLR start "rulePositiveCond"
    // InternalSoarParser.g:670:1: rulePositiveCond returns [EObject current=null] : ( ( () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) ) ) | (otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket ) ) ;
    public final EObject rulePositiveCond() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_condForOneId_1_0 = null;

        EObject lv_cond_3_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:676:2: ( ( ( () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) ) ) | (otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket ) ) )
            // InternalSoarParser.g:677:2: ( ( () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) ) ) | (otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket ) )
            {
            // InternalSoarParser.g:677:2: ( ( () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) ) ) | (otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==LeftParenthesis) ) {
                alt13=1;
            }
            else if ( (LA13_0==LeftCurlyBracket) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSoarParser.g:678:3: ( () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) ) )
                    {
                    // InternalSoarParser.g:678:3: ( () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) ) )
                    // InternalSoarParser.g:679:4: () ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) )
                    {
                    // InternalSoarParser.g:679:4: ()
                    // InternalSoarParser.g:680:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPositiveCondAccess().getPositiveCondAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:689:4: ( ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) ) )
                    // InternalSoarParser.g:690:5: ( ( ( ruleCondForOneId ) ) )=> ( (lv_condForOneId_1_0= ruleCondForOneId ) )
                    {
                    // InternalSoarParser.g:696:5: ( (lv_condForOneId_1_0= ruleCondForOneId ) )
                    // InternalSoarParser.g:697:6: (lv_condForOneId_1_0= ruleCondForOneId )
                    {
                    // InternalSoarParser.g:697:6: (lv_condForOneId_1_0= ruleCondForOneId )
                    // InternalSoarParser.g:698:7: lv_condForOneId_1_0= ruleCondForOneId
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPositiveCondAccess().getCondForOneIdCondForOneIdParserRuleCall_0_1_0_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_condForOneId_1_0=ruleCondForOneId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPositiveCondRule());
                      							}
                      							set(
                      								current,
                      								"condForOneId",
                      								lv_condForOneId_1_0,
                      								"com.collins.trustedmethods.matrics.soar.Soar.CondForOneId");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:718:3: (otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket )
                    {
                    // InternalSoarParser.g:718:3: (otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket )
                    // InternalSoarParser.g:719:4: otherlv_2= LeftCurlyBracket ( (lv_cond_3_0= ruleCond ) )+ otherlv_4= RightCurlyBracket
                    {
                    otherlv_2=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getPositiveCondAccess().getLeftCurlyBracketKeyword_1_0());
                      			
                    }
                    // InternalSoarParser.g:723:4: ( (lv_cond_3_0= ruleCond ) )+
                    int cnt12=0;
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==LeftParenthesis||LA12_0==HyphenMinus||LA12_0==LeftCurlyBracket) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // InternalSoarParser.g:724:5: (lv_cond_3_0= ruleCond )
                    	    {
                    	    // InternalSoarParser.g:724:5: (lv_cond_3_0= ruleCond )
                    	    // InternalSoarParser.g:725:6: lv_cond_3_0= ruleCond
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getPositiveCondAccess().getCondCondParserRuleCall_1_1_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_17);
                    	    lv_cond_3_0=ruleCond();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getPositiveCondRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"cond",
                    	      							lv_cond_3_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.Cond");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt12 >= 1 ) break loop12;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(12, input);
                                throw eee;
                        }
                        cnt12++;
                    } while (true);

                    otherlv_4=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getPositiveCondAccess().getRightCurlyBracketKeyword_1_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositiveCond"


    // $ANTLR start "entryRuleCondForOneId"
    // InternalSoarParser.g:751:1: entryRuleCondForOneId returns [EObject current=null] : iv_ruleCondForOneId= ruleCondForOneId EOF ;
    public final EObject entryRuleCondForOneId() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondForOneId = null;


        try {
            // InternalSoarParser.g:751:53: (iv_ruleCondForOneId= ruleCondForOneId EOF )
            // InternalSoarParser.g:752:2: iv_ruleCondForOneId= ruleCondForOneId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCondForOneIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleCondForOneId=ruleCondForOneId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCondForOneId; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondForOneId"


    // $ANTLR start "ruleCondForOneId"
    // InternalSoarParser.g:758:1: ruleCondForOneId returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_idTest_4_0= ruleVariable ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis ) ;
    public final EObject ruleCondForOneId() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        EObject lv_idTest_4_0 = null;

        EObject lv_attrValueTest_5_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:764:2: ( ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_idTest_4_0= ruleVariable ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis ) )
            // InternalSoarParser.g:765:2: ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_idTest_4_0= ruleVariable ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis )
            {
            // InternalSoarParser.g:765:2: ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_idTest_4_0= ruleVariable ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis )
            // InternalSoarParser.g:766:3: () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_idTest_4_0= ruleVariable ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis
            {
            // InternalSoarParser.g:766:3: ()
            // InternalSoarParser.g:767:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCondForOneIdAccess().getCondForOneIdAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCondForOneIdAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalSoarParser.g:780:3: ( ruleSTATE | ruleIMPASSE )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==State) ) {
                alt14=1;
            }
            else if ( (LA14_0==Impasse) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // InternalSoarParser.g:781:4: ruleSTATE
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCondForOneIdAccess().getSTATEParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    ruleSTATE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:792:4: ruleIMPASSE
                    {
                    if ( state.backtracking==0 ) {

                      				/* */
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCondForOneIdAccess().getIMPASSEParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_19);
                    ruleIMPASSE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalSoarParser.g:803:3: ( (lv_idTest_4_0= ruleVariable ) )
            // InternalSoarParser.g:804:4: (lv_idTest_4_0= ruleVariable )
            {
            // InternalSoarParser.g:804:4: (lv_idTest_4_0= ruleVariable )
            // InternalSoarParser.g:805:5: lv_idTest_4_0= ruleVariable
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCondForOneIdAccess().getIdTestVariableParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_14);
            lv_idTest_4_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCondForOneIdRule());
              					}
              					set(
              						current,
              						"idTest",
              						lv_idTest_4_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.Variable");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSoarParser.g:822:3: ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==HyphenMinus||LA15_0==CircumflexAccent) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSoarParser.g:823:4: (lv_attrValueTest_5_0= ruleAttrValueTest )
            	    {
            	    // InternalSoarParser.g:823:4: (lv_attrValueTest_5_0= ruleAttrValueTest )
            	    // InternalSoarParser.g:824:5: lv_attrValueTest_5_0= ruleAttrValueTest
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCondForOneIdAccess().getAttrValueTestAttrValueTestParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_15);
            	    lv_attrValueTest_5_0=ruleAttrValueTest();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCondForOneIdRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attrValueTest",
            	      						lv_attrValueTest_5_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.AttrValueTest");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
            } while (true);

            otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getCondForOneIdAccess().getRightParenthesisKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondForOneId"


    // $ANTLR start "entryRuleAttrValueTest"
    // InternalSoarParser.g:849:1: entryRuleAttrValueTest returns [EObject current=null] : iv_ruleAttrValueTest= ruleAttrValueTest EOF ;
    public final EObject entryRuleAttrValueTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrValueTest = null;


        try {
            // InternalSoarParser.g:849:54: (iv_ruleAttrValueTest= ruleAttrValueTest EOF )
            // InternalSoarParser.g:850:2: iv_ruleAttrValueTest= ruleAttrValueTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrValueTestRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttrValueTest=ruleAttrValueTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrValueTest; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrValueTest"


    // $ANTLR start "ruleAttrValueTest"
    // InternalSoarParser.g:856:1: ruleAttrValueTest returns [EObject current=null] : ( () (otherlv_1= HyphenMinus )? otherlv_2= CircumflexAccent ( (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_valueTest_6_0= ruleValueTest ) )* ) ;
    public final EObject ruleAttrValueTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_attrTest_3_0=null;
        Token otherlv_4=null;
        Token lv_attrTest_5_0=null;
        EObject lv_valueTest_6_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:862:2: ( ( () (otherlv_1= HyphenMinus )? otherlv_2= CircumflexAccent ( (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_valueTest_6_0= ruleValueTest ) )* ) )
            // InternalSoarParser.g:863:2: ( () (otherlv_1= HyphenMinus )? otherlv_2= CircumflexAccent ( (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_valueTest_6_0= ruleValueTest ) )* )
            {
            // InternalSoarParser.g:863:2: ( () (otherlv_1= HyphenMinus )? otherlv_2= CircumflexAccent ( (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_valueTest_6_0= ruleValueTest ) )* )
            // InternalSoarParser.g:864:3: () (otherlv_1= HyphenMinus )? otherlv_2= CircumflexAccent ( (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_valueTest_6_0= ruleValueTest ) )*
            {
            // InternalSoarParser.g:864:3: ()
            // InternalSoarParser.g:865:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAttrValueTestAccess().getAttrValueTestAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:874:3: (otherlv_1= HyphenMinus )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==HyphenMinus) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalSoarParser.g:875:4: otherlv_1= HyphenMinus
                    {
                    otherlv_1=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAttrValueTestAccess().getHyphenMinusKeyword_1());
                      			
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAttrValueTestAccess().getCircumflexAccentKeyword_2());
              		
            }
            // InternalSoarParser.g:884:3: ( (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING ) )
            // InternalSoarParser.g:885:4: (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING )
            {
            // InternalSoarParser.g:885:4: (lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING )
            // InternalSoarParser.g:886:5: lv_attrTest_3_0= RULE_SYM_CONSTANT_STRING
            {
            lv_attrTest_3_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_attrTest_3_0, grammarAccess.getAttrValueTestAccess().getAttrTestSYM_CONSTANT_STRINGTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAttrValueTestRule());
              					}
              					addWithLastConsumed(
              						current,
              						"attrTest",
              						lv_attrTest_3_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
              				
            }

            }


            }

            // InternalSoarParser.g:902:3: (otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==FullStop) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalSoarParser.g:903:4: otherlv_4= FullStop ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) )
            	    {
            	    otherlv_4=(Token)match(input,FullStop,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getAttrValueTestAccess().getFullStopKeyword_4_0());
            	      			
            	    }
            	    // InternalSoarParser.g:907:4: ( (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING ) )
            	    // InternalSoarParser.g:908:5: (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING )
            	    {
            	    // InternalSoarParser.g:908:5: (lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING )
            	    // InternalSoarParser.g:909:6: lv_attrTest_5_0= RULE_SYM_CONSTANT_STRING
            	    {
            	    lv_attrTest_5_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_21); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_attrTest_5_0, grammarAccess.getAttrValueTestAccess().getAttrTestSYM_CONSTANT_STRINGTerminalRuleCall_4_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getAttrValueTestRule());
            	      						}
            	      						addWithLastConsumed(
            	      							current,
            	      							"attrTest",
            	      							lv_attrTest_5_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            // InternalSoarParser.g:926:3: ( (lv_valueTest_6_0= ruleValueTest ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==State||(LA18_0>=LessThanSignEqualsSignGreaterThanSign && LA18_0<=GreaterThanSignEqualsSign)||LA18_0==LeftParenthesis||(LA18_0>=LessThanSign && LA18_0<=GreaterThanSign)||LA18_0==LeftSquareBracket||LA18_0==LeftCurlyBracket||(LA18_0>=RULE_SYM_CONSTANT_STRING && LA18_0<=RULE_INT)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSoarParser.g:927:4: (lv_valueTest_6_0= ruleValueTest )
            	    {
            	    // InternalSoarParser.g:927:4: (lv_valueTest_6_0= ruleValueTest )
            	    // InternalSoarParser.g:928:5: lv_valueTest_6_0= ruleValueTest
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getAttrValueTestAccess().getValueTestValueTestParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_22);
            	    lv_valueTest_6_0=ruleValueTest();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getAttrValueTestRule());
            	      					}
            	      					add(
            	      						current,
            	      						"valueTest",
            	      						lv_valueTest_6_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.ValueTest");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttrValueTest"


    // $ANTLR start "entryRuleValueTest"
    // InternalSoarParser.g:949:1: entryRuleValueTest returns [EObject current=null] : iv_ruleValueTest= ruleValueTest EOF ;
    public final EObject entryRuleValueTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueTest = null;


        try {
            // InternalSoarParser.g:949:50: (iv_ruleValueTest= ruleValueTest EOF )
            // InternalSoarParser.g:950:2: iv_ruleValueTest= ruleValueTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueTestRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueTest=ruleValueTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueTest; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueTest"


    // $ANTLR start "ruleValueTest"
    // InternalSoarParser.g:956:1: ruleValueTest returns [EObject current=null] : ( ( () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? ) ) | ( ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )? ) ) ;
    public final EObject ruleValueTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_test_1_0 = null;

        EObject lv_condForOneId_3_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:962:2: ( ( ( () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? ) ) | ( ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )? ) ) )
            // InternalSoarParser.g:963:2: ( ( () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? ) ) | ( ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )? ) )
            {
            // InternalSoarParser.g:963:2: ( ( () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? ) ) | ( ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )? ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==State||(LA21_0>=LessThanSignEqualsSignGreaterThanSign && LA21_0<=GreaterThanSignEqualsSign)||(LA21_0>=LessThanSign && LA21_0<=GreaterThanSign)||LA21_0==LeftSquareBracket||LA21_0==LeftCurlyBracket||(LA21_0>=RULE_SYM_CONSTANT_STRING && LA21_0<=RULE_INT)) ) {
                alt21=1;
            }
            else if ( (LA21_0==LeftParenthesis) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalSoarParser.g:964:3: ( () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? ) )
                    {
                    // InternalSoarParser.g:964:3: ( () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? ) )
                    // InternalSoarParser.g:965:4: () ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? )
                    {
                    // InternalSoarParser.g:965:4: ()
                    // InternalSoarParser.g:966:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getValueTestAccess().getValueTestAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:975:4: ( ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )? )
                    // InternalSoarParser.g:976:5: ( (lv_test_1_0= ruleTest ) ) (otherlv_2= PlusSign )?
                    {
                    // InternalSoarParser.g:976:5: ( (lv_test_1_0= ruleTest ) )
                    // InternalSoarParser.g:977:6: (lv_test_1_0= ruleTest )
                    {
                    // InternalSoarParser.g:977:6: (lv_test_1_0= ruleTest )
                    // InternalSoarParser.g:978:7: lv_test_1_0= ruleTest
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getValueTestAccess().getTestTestParserRuleCall_0_1_0_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_test_1_0=ruleTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getValueTestRule());
                      							}
                      							set(
                      								current,
                      								"test",
                      								lv_test_1_0,
                      								"com.collins.trustedmethods.matrics.soar.Soar.Test");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSoarParser.g:995:5: (otherlv_2= PlusSign )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==PlusSign) ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalSoarParser.g:996:6: otherlv_2= PlusSign
                            {
                            otherlv_2=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getValueTestAccess().getPlusSignKeyword_0_1_1());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1004:3: ( ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )? )
                    {
                    // InternalSoarParser.g:1004:3: ( ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )? )
                    // InternalSoarParser.g:1005:4: ( (lv_condForOneId_3_0= ruleCondForOneId ) ) (otherlv_4= PlusSign )?
                    {
                    // InternalSoarParser.g:1005:4: ( (lv_condForOneId_3_0= ruleCondForOneId ) )
                    // InternalSoarParser.g:1006:5: (lv_condForOneId_3_0= ruleCondForOneId )
                    {
                    // InternalSoarParser.g:1006:5: (lv_condForOneId_3_0= ruleCondForOneId )
                    // InternalSoarParser.g:1007:6: lv_condForOneId_3_0= ruleCondForOneId
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getValueTestAccess().getCondForOneIdCondForOneIdParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_23);
                    lv_condForOneId_3_0=ruleCondForOneId();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getValueTestRule());
                      						}
                      						set(
                      							current,
                      							"condForOneId",
                      							lv_condForOneId_3_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.CondForOneId");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalSoarParser.g:1024:4: (otherlv_4= PlusSign )?
                    int alt20=2;
                    int LA20_0 = input.LA(1);

                    if ( (LA20_0==PlusSign) ) {
                        alt20=1;
                    }
                    switch (alt20) {
                        case 1 :
                            // InternalSoarParser.g:1025:5: otherlv_4= PlusSign
                            {
                            otherlv_4=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getValueTestAccess().getPlusSignKeyword_1_1());
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueTest"


    // $ANTLR start "entryRuleTest"
    // InternalSoarParser.g:1035:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalSoarParser.g:1035:45: (iv_ruleTest= ruleTest EOF )
            // InternalSoarParser.g:1036:2: iv_ruleTest= ruleTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTestRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleTest=ruleTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTest; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // InternalSoarParser.g:1042:1: ruleTest returns [EObject current=null] : ( ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) ) | ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket ) | ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) ) | ( (lv_relationalTest_7_0= ruleRelationalTest ) ) | ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket ) ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_9=null;
        Token this_INT_10=null;
        Token otherlv_11=null;
        EObject lv_disjunctionTest_2_0 = null;

        EObject lv_relationalTest_3_0 = null;

        EObject lv_disjunctionTest_6_0 = null;

        EObject lv_relationalTest_7_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1048:2: ( ( ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) ) | ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket ) | ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) ) | ( (lv_relationalTest_7_0= ruleRelationalTest ) ) | ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket ) ) )
            // InternalSoarParser.g:1049:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) ) | ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket ) | ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) ) | ( (lv_relationalTest_7_0= ruleRelationalTest ) ) | ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket ) )
            {
            // InternalSoarParser.g:1049:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) ) | ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket ) | ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) ) | ( (lv_relationalTest_7_0= ruleRelationalTest ) ) | ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket ) )
            int alt23=5;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalSoarParser.g:1050:3: ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) )
                    {
                    // InternalSoarParser.g:1050:3: ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) )
                    // InternalSoarParser.g:1051:4: () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) )
                    {
                    // InternalSoarParser.g:1051:4: ()
                    // InternalSoarParser.g:1052:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTestAccess().getConjuctiveTestAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTestAccess().getLeftCurlyBracketKeyword_0_1());
                      			
                    }
                    // InternalSoarParser.g:1065:4: ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) )
                    // InternalSoarParser.g:1066:5: (lv_disjunctionTest_2_0= ruleDisjunctionTest )
                    {
                    // InternalSoarParser.g:1066:5: (lv_disjunctionTest_2_0= ruleDisjunctionTest )
                    // InternalSoarParser.g:1067:6: lv_disjunctionTest_2_0= ruleDisjunctionTest
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTestAccess().getDisjunctionTestDisjunctionTestParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_disjunctionTest_2_0=ruleDisjunctionTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTestRule());
                      						}
                      						set(
                      							current,
                      							"disjunctionTest",
                      							lv_disjunctionTest_2_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.DisjunctionTest");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1086:3: ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket )
                    {
                    // InternalSoarParser.g:1086:3: ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket )
                    // InternalSoarParser.g:1087:4: ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket
                    {
                    // InternalSoarParser.g:1087:4: ( (lv_relationalTest_3_0= ruleRelationalTest ) )
                    // InternalSoarParser.g:1088:5: (lv_relationalTest_3_0= ruleRelationalTest )
                    {
                    // InternalSoarParser.g:1088:5: (lv_relationalTest_3_0= ruleRelationalTest )
                    // InternalSoarParser.g:1089:6: lv_relationalTest_3_0= ruleRelationalTest
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTestAccess().getRelationalTestRelationalTestParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_9);
                    lv_relationalTest_3_0=ruleRelationalTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTestRule());
                      						}
                      						set(
                      							current,
                      							"relationalTest",
                      							lv_relationalTest_3_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.RelationalTest");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_4=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getTestAccess().getRightCurlyBracketKeyword_1_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1112:3: ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) )
                    {
                    // InternalSoarParser.g:1112:3: ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) )
                    // InternalSoarParser.g:1113:4: () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) )
                    {
                    // InternalSoarParser.g:1113:4: ()
                    // InternalSoarParser.g:1114:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTestAccess().getSimpleTestAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1123:4: ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) )
                    // InternalSoarParser.g:1124:5: (lv_disjunctionTest_6_0= ruleDisjunctionTest )
                    {
                    // InternalSoarParser.g:1124:5: (lv_disjunctionTest_6_0= ruleDisjunctionTest )
                    // InternalSoarParser.g:1125:6: lv_disjunctionTest_6_0= ruleDisjunctionTest
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTestAccess().getDisjunctionTestDisjunctionTestParserRuleCall_2_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_disjunctionTest_6_0=ruleDisjunctionTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTestRule());
                      						}
                      						set(
                      							current,
                      							"disjunctionTest",
                      							lv_disjunctionTest_6_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.DisjunctionTest");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:1144:3: ( (lv_relationalTest_7_0= ruleRelationalTest ) )
                    {
                    // InternalSoarParser.g:1144:3: ( (lv_relationalTest_7_0= ruleRelationalTest ) )
                    // InternalSoarParser.g:1145:4: (lv_relationalTest_7_0= ruleRelationalTest )
                    {
                    // InternalSoarParser.g:1145:4: (lv_relationalTest_7_0= ruleRelationalTest )
                    // InternalSoarParser.g:1146:5: lv_relationalTest_7_0= ruleRelationalTest
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTestAccess().getRelationalTestRelationalTestParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_relationalTest_7_0=ruleRelationalTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTestRule());
                      					}
                      					set(
                      						current,
                      						"relationalTest",
                      						lv_relationalTest_7_0,
                      						"com.collins.trustedmethods.matrics.soar.Soar.RelationalTest");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:1164:3: ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket )
                    {
                    // InternalSoarParser.g:1164:3: ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket )
                    // InternalSoarParser.g:1165:4: () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket
                    {
                    // InternalSoarParser.g:1165:4: ()
                    // InternalSoarParser.g:1166:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getTestAccess().getMultiValueTestAction_4_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_9=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getTestAccess().getLeftSquareBracketKeyword_4_1());
                      			
                    }
                    // InternalSoarParser.g:1179:4: (this_INT_10= RULE_INT )+
                    int cnt22=0;
                    loop22:
                    do {
                        int alt22=2;
                        int LA22_0 = input.LA(1);

                        if ( (LA22_0==RULE_INT) ) {
                            alt22=1;
                        }


                        switch (alt22) {
                    	case 1 :
                    	    // InternalSoarParser.g:1180:5: this_INT_10= RULE_INT
                    	    {
                    	    this_INT_10=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_26); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(this_INT_10, grammarAccess.getTestAccess().getINTTerminalRuleCall_4_2());
                    	      				
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt22 >= 1 ) break loop22;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(22, input);
                                throw eee;
                        }
                        cnt22++;
                    } while (true);

                    otherlv_11=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getTestAccess().getRightSquareBracketKeyword_4_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleDisjunctionTest"
    // InternalSoarParser.g:1194:1: entryRuleDisjunctionTest returns [EObject current=null] : iv_ruleDisjunctionTest= ruleDisjunctionTest EOF ;
    public final EObject entryRuleDisjunctionTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDisjunctionTest = null;


        try {
            // InternalSoarParser.g:1194:56: (iv_ruleDisjunctionTest= ruleDisjunctionTest EOF )
            // InternalSoarParser.g:1195:2: iv_ruleDisjunctionTest= ruleDisjunctionTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDisjunctionTestRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleDisjunctionTest=ruleDisjunctionTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDisjunctionTest; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDisjunctionTest"


    // $ANTLR start "ruleDisjunctionTest"
    // InternalSoarParser.g:1201:1: ruleDisjunctionTest returns [EObject current=null] : ( () otherlv_1= LessThanSignLessThanSign ( (lv_constant_2_0= ruleConstant ) )+ otherlv_3= GreaterThanSignGreaterThanSign ) ;
    public final EObject ruleDisjunctionTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_constant_2_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1207:2: ( ( () otherlv_1= LessThanSignLessThanSign ( (lv_constant_2_0= ruleConstant ) )+ otherlv_3= GreaterThanSignGreaterThanSign ) )
            // InternalSoarParser.g:1208:2: ( () otherlv_1= LessThanSignLessThanSign ( (lv_constant_2_0= ruleConstant ) )+ otherlv_3= GreaterThanSignGreaterThanSign )
            {
            // InternalSoarParser.g:1208:2: ( () otherlv_1= LessThanSignLessThanSign ( (lv_constant_2_0= ruleConstant ) )+ otherlv_3= GreaterThanSignGreaterThanSign )
            // InternalSoarParser.g:1209:3: () otherlv_1= LessThanSignLessThanSign ( (lv_constant_2_0= ruleConstant ) )+ otherlv_3= GreaterThanSignGreaterThanSign
            {
            // InternalSoarParser.g:1209:3: ()
            // InternalSoarParser.g:1210:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDisjunctionTestAccess().getDisjunctionTestAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LessThanSignLessThanSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDisjunctionTestAccess().getLessThanSignLessThanSignKeyword_1());
              		
            }
            // InternalSoarParser.g:1223:3: ( (lv_constant_2_0= ruleConstant ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==State||(LA24_0>=RULE_SYM_CONSTANT_STRING && LA24_0<=RULE_INT)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalSoarParser.g:1224:4: (lv_constant_2_0= ruleConstant )
            	    {
            	    // InternalSoarParser.g:1224:4: (lv_constant_2_0= ruleConstant )
            	    // InternalSoarParser.g:1225:5: lv_constant_2_0= ruleConstant
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getDisjunctionTestAccess().getConstantConstantParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_28);
            	    lv_constant_2_0=ruleConstant();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getDisjunctionTestRule());
            	      					}
            	      					add(
            	      						current,
            	      						"constant",
            	      						lv_constant_2_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.Constant");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            otherlv_3=(Token)match(input,GreaterThanSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getDisjunctionTestAccess().getGreaterThanSignGreaterThanSignKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDisjunctionTest"


    // $ANTLR start "entryRuleSingleTest"
    // InternalSoarParser.g:1250:1: entryRuleSingleTest returns [EObject current=null] : iv_ruleSingleTest= ruleSingleTest EOF ;
    public final EObject entryRuleSingleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleTest = null;


        try {
            // InternalSoarParser.g:1250:51: (iv_ruleSingleTest= ruleSingleTest EOF )
            // InternalSoarParser.g:1251:2: iv_ruleSingleTest= ruleSingleTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSingleTestRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSingleTest=ruleSingleTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSingleTest; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleTest"


    // $ANTLR start "ruleSingleTest"
    // InternalSoarParser.g:1257:1: ruleSingleTest returns [EObject current=null] : ( () ( ( (lv_variable_1_0= ruleVariable ) ) | ( (lv_constant_2_0= ruleConstant ) ) ) ) ;
    public final EObject ruleSingleTest() throws RecognitionException {
        EObject current = null;

        EObject lv_variable_1_0 = null;

        EObject lv_constant_2_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1263:2: ( ( () ( ( (lv_variable_1_0= ruleVariable ) ) | ( (lv_constant_2_0= ruleConstant ) ) ) ) )
            // InternalSoarParser.g:1264:2: ( () ( ( (lv_variable_1_0= ruleVariable ) ) | ( (lv_constant_2_0= ruleConstant ) ) ) )
            {
            // InternalSoarParser.g:1264:2: ( () ( ( (lv_variable_1_0= ruleVariable ) ) | ( (lv_constant_2_0= ruleConstant ) ) ) )
            // InternalSoarParser.g:1265:3: () ( ( (lv_variable_1_0= ruleVariable ) ) | ( (lv_constant_2_0= ruleConstant ) ) )
            {
            // InternalSoarParser.g:1265:3: ()
            // InternalSoarParser.g:1266:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSingleTestAccess().getSingleTestAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:1275:3: ( ( (lv_variable_1_0= ruleVariable ) ) | ( (lv_constant_2_0= ruleConstant ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==LessThanSign) ) {
                alt25=1;
            }
            else if ( (LA25_0==State||(LA25_0>=RULE_SYM_CONSTANT_STRING && LA25_0<=RULE_INT)) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalSoarParser.g:1276:4: ( (lv_variable_1_0= ruleVariable ) )
                    {
                    // InternalSoarParser.g:1276:4: ( (lv_variable_1_0= ruleVariable ) )
                    // InternalSoarParser.g:1277:5: (lv_variable_1_0= ruleVariable )
                    {
                    // InternalSoarParser.g:1277:5: (lv_variable_1_0= ruleVariable )
                    // InternalSoarParser.g:1278:6: lv_variable_1_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSingleTestAccess().getVariableVariableParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_variable_1_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSingleTestRule());
                      						}
                      						set(
                      							current,
                      							"variable",
                      							lv_variable_1_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.Variable");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1296:4: ( (lv_constant_2_0= ruleConstant ) )
                    {
                    // InternalSoarParser.g:1296:4: ( (lv_constant_2_0= ruleConstant ) )
                    // InternalSoarParser.g:1297:5: (lv_constant_2_0= ruleConstant )
                    {
                    // InternalSoarParser.g:1297:5: (lv_constant_2_0= ruleConstant )
                    // InternalSoarParser.g:1298:6: lv_constant_2_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSingleTestAccess().getConstantConstantParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_constant_2_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSingleTestRule());
                      						}
                      						set(
                      							current,
                      							"constant",
                      							lv_constant_2_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.Constant");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleTest"


    // $ANTLR start "entryRuleRelationalTest"
    // InternalSoarParser.g:1320:1: entryRuleRelationalTest returns [EObject current=null] : iv_ruleRelationalTest= ruleRelationalTest EOF ;
    public final EObject entryRuleRelationalTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalTest = null;


        try {
            // InternalSoarParser.g:1320:55: (iv_ruleRelationalTest= ruleRelationalTest EOF )
            // InternalSoarParser.g:1321:2: iv_ruleRelationalTest= ruleRelationalTest EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalTestRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalTest=ruleRelationalTest();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalTest; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRelationalTest"


    // $ANTLR start "ruleRelationalTest"
    // InternalSoarParser.g:1327:1: ruleRelationalTest returns [EObject current=null] : ( ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) ) | ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) ) ) ;
    public final EObject ruleRelationalTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_singleTest_9_0 = null;

        EObject lv_singleTest_11_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1333:2: ( ( ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) ) | ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) ) ) )
            // InternalSoarParser.g:1334:2: ( ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) ) | ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) ) )
            {
            // InternalSoarParser.g:1334:2: ( ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) ) | ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) ) )
            int alt27=2;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalSoarParser.g:1335:3: ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) )
                    {
                    // InternalSoarParser.g:1335:3: ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) )
                    // InternalSoarParser.g:1336:4: () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) )
                    {
                    // InternalSoarParser.g:1336:4: ()
                    // InternalSoarParser.g:1337:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRelationalTestAccess().getRelationalTestAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1346:4: (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign )
                    int alt26=8;
                    switch ( input.LA(1) ) {
                    case LessThanSignGreaterThanSign:
                        {
                        alt26=1;
                        }
                        break;
                    case LessThanSign:
                        {
                        alt26=2;
                        }
                        break;
                    case GreaterThanSign:
                        {
                        alt26=3;
                        }
                        break;
                    case LessThanSignEqualsSign:
                        {
                        alt26=4;
                        }
                        break;
                    case GreaterThanSignEqualsSign:
                        {
                        alt26=5;
                        }
                        break;
                    case EqualsSignEqualsSign:
                        {
                        alt26=6;
                        }
                        break;
                    case LessThanSignEqualsSignGreaterThanSign:
                        {
                        alt26=7;
                        }
                        break;
                    case EqualsSign:
                        {
                        alt26=8;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }

                    switch (alt26) {
                        case 1 :
                            // InternalSoarParser.g:1347:5: otherlv_1= LessThanSignGreaterThanSign
                            {
                            otherlv_1=(Token)match(input,LessThanSignGreaterThanSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_1, grammarAccess.getRelationalTestAccess().getLessThanSignGreaterThanSignKeyword_0_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSoarParser.g:1352:5: otherlv_2= LessThanSign
                            {
                            otherlv_2=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_2, grammarAccess.getRelationalTestAccess().getLessThanSignKeyword_0_1_1());
                              				
                            }

                            }
                            break;
                        case 3 :
                            // InternalSoarParser.g:1357:5: otherlv_3= GreaterThanSign
                            {
                            otherlv_3=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_3, grammarAccess.getRelationalTestAccess().getGreaterThanSignKeyword_0_1_2());
                              				
                            }

                            }
                            break;
                        case 4 :
                            // InternalSoarParser.g:1362:5: otherlv_4= LessThanSignEqualsSign
                            {
                            otherlv_4=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_4, grammarAccess.getRelationalTestAccess().getLessThanSignEqualsSignKeyword_0_1_3());
                              				
                            }

                            }
                            break;
                        case 5 :
                            // InternalSoarParser.g:1367:5: otherlv_5= GreaterThanSignEqualsSign
                            {
                            otherlv_5=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_5, grammarAccess.getRelationalTestAccess().getGreaterThanSignEqualsSignKeyword_0_1_4());
                              				
                            }

                            }
                            break;
                        case 6 :
                            // InternalSoarParser.g:1372:5: otherlv_6= EqualsSignEqualsSign
                            {
                            otherlv_6=(Token)match(input,EqualsSignEqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_6, grammarAccess.getRelationalTestAccess().getEqualsSignEqualsSignKeyword_0_1_5());
                              				
                            }

                            }
                            break;
                        case 7 :
                            // InternalSoarParser.g:1377:5: otherlv_7= LessThanSignEqualsSignGreaterThanSign
                            {
                            otherlv_7=(Token)match(input,LessThanSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_7, grammarAccess.getRelationalTestAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_0_1_6());
                              				
                            }

                            }
                            break;
                        case 8 :
                            // InternalSoarParser.g:1382:5: otherlv_8= EqualsSign
                            {
                            otherlv_8=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_8, grammarAccess.getRelationalTestAccess().getEqualsSignKeyword_0_1_7());
                              				
                            }

                            }
                            break;

                    }

                    // InternalSoarParser.g:1387:4: ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) )
                    // InternalSoarParser.g:1388:5: ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest )
                    {
                    // InternalSoarParser.g:1392:5: (lv_singleTest_9_0= ruleSingleTest )
                    // InternalSoarParser.g:1393:6: lv_singleTest_9_0= ruleSingleTest
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalTestAccess().getSingleTestSingleTestParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_singleTest_9_0=ruleSingleTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalTestRule());
                      						}
                      						set(
                      							current,
                      							"singleTest",
                      							lv_singleTest_9_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SingleTest");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1412:3: ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) )
                    {
                    // InternalSoarParser.g:1412:3: ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) )
                    // InternalSoarParser.g:1413:4: () ( (lv_singleTest_11_0= ruleSingleTest ) )
                    {
                    // InternalSoarParser.g:1413:4: ()
                    // InternalSoarParser.g:1414:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRelationalTestAccess().getRelationalTestAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1423:4: ( (lv_singleTest_11_0= ruleSingleTest ) )
                    // InternalSoarParser.g:1424:5: (lv_singleTest_11_0= ruleSingleTest )
                    {
                    // InternalSoarParser.g:1424:5: (lv_singleTest_11_0= ruleSingleTest )
                    // InternalSoarParser.g:1425:6: lv_singleTest_11_0= ruleSingleTest
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalTestAccess().getSingleTestSingleTestParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_singleTest_11_0=ruleSingleTest();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalTestRule());
                      						}
                      						set(
                      							current,
                      							"singleTest",
                      							lv_singleTest_11_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SingleTest");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRelationalTest"


    // $ANTLR start "entryRuleVariable"
    // InternalSoarParser.g:1447:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalSoarParser.g:1447:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalSoarParser.g:1448:2: iv_ruleVariable= ruleVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariable; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalSoarParser.g:1454:1: ruleVariable returns [EObject current=null] : ( () (otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_SYM_CONSTANT_STRING_2=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalSoarParser.g:1460:2: ( ( () (otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign ) ) )
            // InternalSoarParser.g:1461:2: ( () (otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign ) )
            {
            // InternalSoarParser.g:1461:2: ( () (otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign ) )
            // InternalSoarParser.g:1462:3: () (otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign )
            {
            // InternalSoarParser.g:1462:3: ()
            // InternalSoarParser.g:1463:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableAccess().getVariableAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:1472:3: (otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign )
            // InternalSoarParser.g:1473:4: otherlv_1= LessThanSign (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) otherlv_4= GreaterThanSign
            {
            otherlv_1=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getLessThanSignKeyword_1_0());
              			
            }
            // InternalSoarParser.g:1477:4: (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_SYM_CONSTANT_STRING) ) {
                alt28=1;
            }
            else if ( (LA28_0==State) ) {
                alt28=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // InternalSoarParser.g:1478:5: this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING
                    {
                    this_SYM_CONSTANT_STRING_2=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(this_SYM_CONSTANT_STRING_2, grammarAccess.getVariableAccess().getSYM_CONSTANT_STRINGTerminalRuleCall_1_1_0());
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1483:5: ruleSTATE
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getVariableAccess().getSTATEParserRuleCall_1_1_1());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_30);
                    ruleSTATE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }
                    break;

            }

            otherlv_4=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getVariableAccess().getGreaterThanSignKeyword_1_2());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleActionSide"
    // InternalSoarParser.g:1503:1: entryRuleActionSide returns [EObject current=null] : iv_ruleActionSide= ruleActionSide EOF ;
    public final EObject entryRuleActionSide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSide = null;


        try {
            // InternalSoarParser.g:1503:51: (iv_ruleActionSide= ruleActionSide EOF )
            // InternalSoarParser.g:1504:2: iv_ruleActionSide= ruleActionSide EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionSideRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionSide=ruleActionSide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionSide; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActionSide"


    // $ANTLR start "ruleActionSide"
    // InternalSoarParser.g:1510:1: ruleActionSide returns [EObject current=null] : ( () ( ( (lv_action_1_0= ruleAction ) ) | ( (lv_funcCall_2_0= ruleFuncCall ) ) | ( (lv_print_3_0= rulePrint ) ) )* ) ;
    public final EObject ruleActionSide() throws RecognitionException {
        EObject current = null;

        EObject lv_action_1_0 = null;

        EObject lv_funcCall_2_0 = null;

        EObject lv_print_3_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1516:2: ( ( () ( ( (lv_action_1_0= ruleAction ) ) | ( (lv_funcCall_2_0= ruleFuncCall ) ) | ( (lv_print_3_0= rulePrint ) ) )* ) )
            // InternalSoarParser.g:1517:2: ( () ( ( (lv_action_1_0= ruleAction ) ) | ( (lv_funcCall_2_0= ruleFuncCall ) ) | ( (lv_print_3_0= rulePrint ) ) )* )
            {
            // InternalSoarParser.g:1517:2: ( () ( ( (lv_action_1_0= ruleAction ) ) | ( (lv_funcCall_2_0= ruleFuncCall ) ) | ( (lv_print_3_0= rulePrint ) ) )* )
            // InternalSoarParser.g:1518:3: () ( ( (lv_action_1_0= ruleAction ) ) | ( (lv_funcCall_2_0= ruleFuncCall ) ) | ( (lv_print_3_0= rulePrint ) ) )*
            {
            // InternalSoarParser.g:1518:3: ()
            // InternalSoarParser.g:1519:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getActionSideAccess().getActionSideAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:1528:3: ( ( (lv_action_1_0= ruleAction ) ) | ( (lv_funcCall_2_0= ruleFuncCall ) ) | ( (lv_print_3_0= rulePrint ) ) )*
            loop29:
            do {
                int alt29=4;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==LeftParenthesis) ) {
                    switch ( input.LA(2) ) {
                    case LessThanSign:
                        {
                        alt29=1;
                        }
                        break;
                    case State:
                    case Asterisk:
                    case PlusSign:
                    case HyphenMinus:
                    case Solidus:
                    case RULE_SYM_CONSTANT_STRING:
                        {
                        alt29=2;
                        }
                        break;
                    case Write:
                        {
                        alt29=3;
                        }
                        break;

                    }

                }


                switch (alt29) {
            	case 1 :
            	    // InternalSoarParser.g:1529:4: ( (lv_action_1_0= ruleAction ) )
            	    {
            	    // InternalSoarParser.g:1529:4: ( (lv_action_1_0= ruleAction ) )
            	    // InternalSoarParser.g:1530:5: (lv_action_1_0= ruleAction )
            	    {
            	    // InternalSoarParser.g:1530:5: (lv_action_1_0= ruleAction )
            	    // InternalSoarParser.g:1531:6: lv_action_1_0= ruleAction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getActionSideAccess().getActionActionParserRuleCall_1_0_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    lv_action_1_0=ruleAction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getActionSideRule());
            	      						}
            	      						add(
            	      							current,
            	      							"action",
            	      							lv_action_1_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.Action");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalSoarParser.g:1549:4: ( (lv_funcCall_2_0= ruleFuncCall ) )
            	    {
            	    // InternalSoarParser.g:1549:4: ( (lv_funcCall_2_0= ruleFuncCall ) )
            	    // InternalSoarParser.g:1550:5: (lv_funcCall_2_0= ruleFuncCall )
            	    {
            	    // InternalSoarParser.g:1550:5: (lv_funcCall_2_0= ruleFuncCall )
            	    // InternalSoarParser.g:1551:6: lv_funcCall_2_0= ruleFuncCall
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getActionSideAccess().getFuncCallFuncCallParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    lv_funcCall_2_0=ruleFuncCall();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getActionSideRule());
            	      						}
            	      						add(
            	      							current,
            	      							"funcCall",
            	      							lv_funcCall_2_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.FuncCall");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSoarParser.g:1569:4: ( (lv_print_3_0= rulePrint ) )
            	    {
            	    // InternalSoarParser.g:1569:4: ( (lv_print_3_0= rulePrint ) )
            	    // InternalSoarParser.g:1570:5: (lv_print_3_0= rulePrint )
            	    {
            	    // InternalSoarParser.g:1570:5: (lv_print_3_0= rulePrint )
            	    // InternalSoarParser.g:1571:6: lv_print_3_0= rulePrint
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getActionSideAccess().getPrintPrintParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_31);
            	    lv_print_3_0=rulePrint();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getActionSideRule());
            	      						}
            	      						add(
            	      							current,
            	      							"print",
            	      							lv_print_3_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.Print");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActionSide"


    // $ANTLR start "entryRuleAction"
    // InternalSoarParser.g:1593:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalSoarParser.g:1593:47: (iv_ruleAction= ruleAction EOF )
            // InternalSoarParser.g:1594:2: iv_ruleAction= ruleAction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAction; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalSoarParser.g:1600:1: ruleAction returns [EObject current=null] : ( () (otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_variable_2_0 = null;

        EObject lv_attrValMake_3_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1606:2: ( ( () (otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis ) ) )
            // InternalSoarParser.g:1607:2: ( () (otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis ) )
            {
            // InternalSoarParser.g:1607:2: ( () (otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis ) )
            // InternalSoarParser.g:1608:3: () (otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis )
            {
            // InternalSoarParser.g:1608:3: ()
            // InternalSoarParser.g:1609:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getActionAccess().getActionAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:1618:3: (otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis )
            // InternalSoarParser.g:1619:4: otherlv_1= LeftParenthesis ( (lv_variable_2_0= ruleVariable ) ) ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+ otherlv_4= RightParenthesis
            {
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_1, grammarAccess.getActionAccess().getLeftParenthesisKeyword_1_0());
              			
            }
            // InternalSoarParser.g:1623:4: ( (lv_variable_2_0= ruleVariable ) )
            // InternalSoarParser.g:1624:5: (lv_variable_2_0= ruleVariable )
            {
            // InternalSoarParser.g:1624:5: (lv_variable_2_0= ruleVariable )
            // InternalSoarParser.g:1625:6: lv_variable_2_0= ruleVariable
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getActionAccess().getVariableVariableParserRuleCall_1_1_0());
              					
            }
            pushFollow(FollowSets000.FOLLOW_20);
            lv_variable_2_0=ruleVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getActionRule());
              						}
              						set(
              							current,
              							"variable",
              							lv_variable_2_0,
              							"com.collins.trustedmethods.matrics.soar.Soar.Variable");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalSoarParser.g:1642:4: ( (lv_attrValMake_3_0= ruleAttrValueMake ) )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==CircumflexAccent) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSoarParser.g:1643:5: (lv_attrValMake_3_0= ruleAttrValueMake )
            	    {
            	    // InternalSoarParser.g:1643:5: (lv_attrValMake_3_0= ruleAttrValueMake )
            	    // InternalSoarParser.g:1644:6: lv_attrValMake_3_0= ruleAttrValueMake
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getActionAccess().getAttrValMakeAttrValueMakeParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_32);
            	    lv_attrValMake_3_0=ruleAttrValueMake();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getActionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"attrValMake",
            	      							lv_attrValMake_3_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.AttrValueMake");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

            otherlv_4=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getRightParenthesisKeyword_1_3());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRulePrint"
    // InternalSoarParser.g:1670:1: entryRulePrint returns [EObject current=null] : iv_rulePrint= rulePrint EOF ;
    public final EObject entryRulePrint() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrint = null;


        try {
            // InternalSoarParser.g:1670:46: (iv_rulePrint= rulePrint EOF )
            // InternalSoarParser.g:1671:2: iv_rulePrint= rulePrint EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrintRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrint=rulePrint();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrint; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrint"


    // $ANTLR start "rulePrint"
    // InternalSoarParser.g:1677:1: rulePrint returns [EObject current=null] : ( () (otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis ) ) ;
    public final EObject rulePrint() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token this_PRINT_STRING_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_variable_4_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1683:2: ( ( () (otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis ) ) )
            // InternalSoarParser.g:1684:2: ( () (otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis ) )
            {
            // InternalSoarParser.g:1684:2: ( () (otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis ) )
            // InternalSoarParser.g:1685:3: () (otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis )
            {
            // InternalSoarParser.g:1685:3: ()
            // InternalSoarParser.g:1686:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPrintAccess().getPrintAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:1695:3: (otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis )
            // InternalSoarParser.g:1696:4: otherlv_1= LeftParenthesis otherlv_2= Write (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+ otherlv_6= RightParenthesis
            {
            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_1, grammarAccess.getPrintAccess().getLeftParenthesisKeyword_1_0());
              			
            }
            otherlv_2=(Token)match(input,Write,FollowSets000.FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_2, grammarAccess.getPrintAccess().getWriteKeyword_1_1());
              			
            }
            // InternalSoarParser.g:1704:4: (this_PRINT_STRING_3= RULE_PRINT_STRING | ( (lv_variable_4_0= ruleVariable ) ) | otherlv_5= Crlf )+
            int cnt31=0;
            loop31:
            do {
                int alt31=4;
                switch ( input.LA(1) ) {
                case RULE_PRINT_STRING:
                    {
                    alt31=1;
                    }
                    break;
                case LessThanSign:
                    {
                    alt31=2;
                    }
                    break;
                case Crlf:
                    {
                    alt31=3;
                    }
                    break;

                }

                switch (alt31) {
            	case 1 :
            	    // InternalSoarParser.g:1705:5: this_PRINT_STRING_3= RULE_PRINT_STRING
            	    {
            	    this_PRINT_STRING_3=(Token)match(input,RULE_PRINT_STRING,FollowSets000.FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(this_PRINT_STRING_3, grammarAccess.getPrintAccess().getPRINT_STRINGTerminalRuleCall_1_2_0());
            	      				
            	    }

            	    }
            	    break;
            	case 2 :
            	    // InternalSoarParser.g:1710:5: ( (lv_variable_4_0= ruleVariable ) )
            	    {
            	    // InternalSoarParser.g:1710:5: ( (lv_variable_4_0= ruleVariable ) )
            	    // InternalSoarParser.g:1711:6: (lv_variable_4_0= ruleVariable )
            	    {
            	    // InternalSoarParser.g:1711:6: (lv_variable_4_0= ruleVariable )
            	    // InternalSoarParser.g:1712:7: lv_variable_4_0= ruleVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getPrintAccess().getVariableVariableParserRuleCall_1_2_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_35);
            	    lv_variable_4_0=ruleVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getPrintRule());
            	      							}
            	      							add(
            	      								current,
            	      								"variable",
            	      								lv_variable_4_0,
            	      								"com.collins.trustedmethods.matrics.soar.Soar.Variable");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalSoarParser.g:1730:5: otherlv_5= Crlf
            	    {
            	    otherlv_5=(Token)match(input,Crlf,FollowSets000.FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_5, grammarAccess.getPrintAccess().getCrlfKeyword_1_2_2());
            	      				
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt31 >= 1 ) break loop31;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
            } while (true);

            otherlv_6=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_6, grammarAccess.getPrintAccess().getRightParenthesisKeyword_1_3());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrint"


    // $ANTLR start "entryRuleFuncCall"
    // InternalSoarParser.g:1744:1: entryRuleFuncCall returns [EObject current=null] : iv_ruleFuncCall= ruleFuncCall EOF ;
    public final EObject entryRuleFuncCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFuncCall = null;


        try {
            // InternalSoarParser.g:1744:49: (iv_ruleFuncCall= ruleFuncCall EOF )
            // InternalSoarParser.g:1745:2: iv_ruleFuncCall= ruleFuncCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFuncCallRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleFuncCall=ruleFuncCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFuncCall; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFuncCall"


    // $ANTLR start "ruleFuncCall"
    // InternalSoarParser.g:1751:1: ruleFuncCall returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | otherlv_4= PlusSign | otherlv_5= HyphenMinus | otherlv_6= Asterisk | otherlv_7= Solidus ) ( (lv_value_8_0= ruleValue ) )* otherlv_9= RightParenthesis ) ;
    public final EObject ruleFuncCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token this_SYM_CONSTANT_STRING_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_value_8_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1757:2: ( ( () otherlv_1= LeftParenthesis ( (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | otherlv_4= PlusSign | otherlv_5= HyphenMinus | otherlv_6= Asterisk | otherlv_7= Solidus ) ( (lv_value_8_0= ruleValue ) )* otherlv_9= RightParenthesis ) )
            // InternalSoarParser.g:1758:2: ( () otherlv_1= LeftParenthesis ( (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | otherlv_4= PlusSign | otherlv_5= HyphenMinus | otherlv_6= Asterisk | otherlv_7= Solidus ) ( (lv_value_8_0= ruleValue ) )* otherlv_9= RightParenthesis )
            {
            // InternalSoarParser.g:1758:2: ( () otherlv_1= LeftParenthesis ( (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | otherlv_4= PlusSign | otherlv_5= HyphenMinus | otherlv_6= Asterisk | otherlv_7= Solidus ) ( (lv_value_8_0= ruleValue ) )* otherlv_9= RightParenthesis )
            // InternalSoarParser.g:1759:3: () otherlv_1= LeftParenthesis ( (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | otherlv_4= PlusSign | otherlv_5= HyphenMinus | otherlv_6= Asterisk | otherlv_7= Solidus ) ( (lv_value_8_0= ruleValue ) )* otherlv_9= RightParenthesis
            {
            // InternalSoarParser.g:1759:3: ()
            // InternalSoarParser.g:1760:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getFuncCallAccess().getFuncCallAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFuncCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalSoarParser.g:1773:3: ( (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | otherlv_4= PlusSign | otherlv_5= HyphenMinus | otherlv_6= Asterisk | otherlv_7= Solidus )
            int alt33=5;
            switch ( input.LA(1) ) {
            case State:
            case RULE_SYM_CONSTANT_STRING:
                {
                alt33=1;
                }
                break;
            case PlusSign:
                {
                alt33=2;
                }
                break;
            case HyphenMinus:
                {
                alt33=3;
                }
                break;
            case Asterisk:
                {
                alt33=4;
                }
                break;
            case Solidus:
                {
                alt33=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalSoarParser.g:1774:4: (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE )
                    {
                    // InternalSoarParser.g:1774:4: (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE )
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0==RULE_SYM_CONSTANT_STRING) ) {
                        alt32=1;
                    }
                    else if ( (LA32_0==State) ) {
                        alt32=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 32, 0, input);

                        throw nvae;
                    }
                    switch (alt32) {
                        case 1 :
                            // InternalSoarParser.g:1775:5: this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING
                            {
                            this_SYM_CONSTANT_STRING_2=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_37); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SYM_CONSTANT_STRING_2, grammarAccess.getFuncCallAccess().getSYM_CONSTANT_STRINGTerminalRuleCall_2_0_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSoarParser.g:1780:5: ruleSTATE
                            {
                            if ( state.backtracking==0 ) {

                              					/* */
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getFuncCallAccess().getSTATEParserRuleCall_2_0_1());
                              				
                            }
                            pushFollow(FollowSets000.FOLLOW_37);
                            ruleSTATE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1792:4: otherlv_4= PlusSign
                    {
                    otherlv_4=(Token)match(input,PlusSign,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getFuncCallAccess().getPlusSignKeyword_2_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1797:4: otherlv_5= HyphenMinus
                    {
                    otherlv_5=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getFuncCallAccess().getHyphenMinusKeyword_2_2());
                      			
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:1802:4: otherlv_6= Asterisk
                    {
                    otherlv_6=(Token)match(input,Asterisk,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getFuncCallAccess().getAsteriskKeyword_2_3());
                      			
                    }

                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:1807:4: otherlv_7= Solidus
                    {
                    otherlv_7=(Token)match(input,Solidus,FollowSets000.FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getFuncCallAccess().getSolidusKeyword_2_4());
                      			
                    }

                    }
                    break;

            }

            // InternalSoarParser.g:1812:3: ( (lv_value_8_0= ruleValue ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==State||LA34_0==LeftParenthesis||LA34_0==LessThanSign||(LA34_0>=RULE_SYM_CONSTANT_STRING && LA34_0<=RULE_INT)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalSoarParser.g:1813:4: (lv_value_8_0= ruleValue )
            	    {
            	    // InternalSoarParser.g:1813:4: (lv_value_8_0= ruleValue )
            	    // InternalSoarParser.g:1814:5: lv_value_8_0= ruleValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getFuncCallAccess().getValueValueParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_37);
            	    lv_value_8_0=ruleValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getFuncCallRule());
            	      					}
            	      					add(
            	      						current,
            	      						"value",
            	      						lv_value_8_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.Value");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            otherlv_9=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getFuncCallAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFuncCall"


    // $ANTLR start "entryRuleValue"
    // InternalSoarParser.g:1839:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalSoarParser.g:1839:46: (iv_ruleValue= ruleValue EOF )
            // InternalSoarParser.g:1840:2: iv_ruleValue= ruleValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalSoarParser.g:1846:1: ruleValue returns [EObject current=null] : (this_Constant_0= ruleConstant | this_FuncCall_1= ruleFuncCall | this_Variable_2= ruleVariable ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_Constant_0 = null;

        EObject this_FuncCall_1 = null;

        EObject this_Variable_2 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1852:2: ( (this_Constant_0= ruleConstant | this_FuncCall_1= ruleFuncCall | this_Variable_2= ruleVariable ) )
            // InternalSoarParser.g:1853:2: (this_Constant_0= ruleConstant | this_FuncCall_1= ruleFuncCall | this_Variable_2= ruleVariable )
            {
            // InternalSoarParser.g:1853:2: (this_Constant_0= ruleConstant | this_FuncCall_1= ruleFuncCall | this_Variable_2= ruleVariable )
            int alt35=3;
            switch ( input.LA(1) ) {
            case State:
            case RULE_SYM_CONSTANT_STRING:
            case RULE_PRINT_STRING:
            case RULE_FLOAT:
            case RULE_INT:
                {
                alt35=1;
                }
                break;
            case LeftParenthesis:
                {
                alt35=2;
                }
                break;
            case LessThanSign:
                {
                alt35=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalSoarParser.g:1854:3: this_Constant_0= ruleConstant
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueAccess().getConstantParserRuleCall_0());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Constant_0=ruleConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Constant_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1866:3: this_FuncCall_1= ruleFuncCall
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueAccess().getFuncCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_FuncCall_1=ruleFuncCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FuncCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1878:3: this_Variable_2= ruleVariable
                    {
                    if ( state.backtracking==0 ) {

                      			/* */
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_2());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_Variable_2=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Variable_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleAttrValueMake"
    // InternalSoarParser.g:1893:1: entryRuleAttrValueMake returns [EObject current=null] : iv_ruleAttrValueMake= ruleAttrValueMake EOF ;
    public final EObject entryRuleAttrValueMake() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrValueMake = null;


        try {
            // InternalSoarParser.g:1893:54: (iv_ruleAttrValueMake= ruleAttrValueMake EOF )
            // InternalSoarParser.g:1894:2: iv_ruleAttrValueMake= ruleAttrValueMake EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttrValueMakeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAttrValueMake=ruleAttrValueMake();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttrValueMake; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAttrValueMake"


    // $ANTLR start "ruleAttrValueMake"
    // InternalSoarParser.g:1900:1: ruleAttrValueMake returns [EObject current=null] : ( () (otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )* ) ) ;
    public final EObject ruleAttrValueMake() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_variableOrSymConstant_2_0 = null;

        EObject lv_variableOrSymConstant_4_0 = null;

        EObject lv_valueMake_5_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1906:2: ( ( () (otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )* ) ) )
            // InternalSoarParser.g:1907:2: ( () (otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )* ) )
            {
            // InternalSoarParser.g:1907:2: ( () (otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )* ) )
            // InternalSoarParser.g:1908:3: () (otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )* )
            {
            // InternalSoarParser.g:1908:3: ()
            // InternalSoarParser.g:1909:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAttrValueMakeAccess().getAttrValueMakeAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:1918:3: (otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )* )
            // InternalSoarParser.g:1919:4: otherlv_1= CircumflexAccent ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) ) (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )* ( (lv_valueMake_5_0= ruleValueMake ) )*
            {
            otherlv_1=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_1, grammarAccess.getAttrValueMakeAccess().getCircumflexAccentKeyword_1_0());
              			
            }
            // InternalSoarParser.g:1923:4: ( (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant ) )
            // InternalSoarParser.g:1924:5: (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant )
            {
            // InternalSoarParser.g:1924:5: (lv_variableOrSymConstant_2_0= ruleVariableorSymConstant )
            // InternalSoarParser.g:1925:6: lv_variableOrSymConstant_2_0= ruleVariableorSymConstant
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getAttrValueMakeAccess().getVariableOrSymConstantVariableorSymConstantParserRuleCall_1_1_0());
              					
            }
            pushFollow(FollowSets000.FOLLOW_39);
            lv_variableOrSymConstant_2_0=ruleVariableorSymConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getAttrValueMakeRule());
              						}
              						add(
              							current,
              							"variableOrSymConstant",
              							lv_variableOrSymConstant_2_0,
              							"com.collins.trustedmethods.matrics.soar.Soar.VariableorSymConstant");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalSoarParser.g:1942:4: (otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==FullStop) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSoarParser.g:1943:5: otherlv_3= FullStop ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) )
            	    {
            	    otherlv_3=(Token)match(input,FullStop,FollowSets000.FOLLOW_38); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_3, grammarAccess.getAttrValueMakeAccess().getFullStopKeyword_1_2_0());
            	      				
            	    }
            	    // InternalSoarParser.g:1947:5: ( (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant ) )
            	    // InternalSoarParser.g:1948:6: (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant )
            	    {
            	    // InternalSoarParser.g:1948:6: (lv_variableOrSymConstant_4_0= ruleVariableorSymConstant )
            	    // InternalSoarParser.g:1949:7: lv_variableOrSymConstant_4_0= ruleVariableorSymConstant
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getAttrValueMakeAccess().getVariableOrSymConstantVariableorSymConstantParserRuleCall_1_2_1_0());
            	      						
            	    }
            	    pushFollow(FollowSets000.FOLLOW_39);
            	    lv_variableOrSymConstant_4_0=ruleVariableorSymConstant();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getAttrValueMakeRule());
            	      							}
            	      							add(
            	      								current,
            	      								"variableOrSymConstant",
            	      								lv_variableOrSymConstant_4_0,
            	      								"com.collins.trustedmethods.matrics.soar.Soar.VariableorSymConstant");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // InternalSoarParser.g:1967:4: ( (lv_valueMake_5_0= ruleValueMake ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==State||LA37_0==LeftParenthesis||LA37_0==LessThanSign||(LA37_0>=RULE_SYM_CONSTANT_STRING && LA37_0<=RULE_INT)) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalSoarParser.g:1968:5: (lv_valueMake_5_0= ruleValueMake )
            	    {
            	    // InternalSoarParser.g:1968:5: (lv_valueMake_5_0= ruleValueMake )
            	    // InternalSoarParser.g:1969:6: lv_valueMake_5_0= ruleValueMake
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAttrValueMakeAccess().getValueMakeValueMakeParserRuleCall_1_3_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_40);
            	    lv_valueMake_5_0=ruleValueMake();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAttrValueMakeRule());
            	      						}
            	      						add(
            	      							current,
            	      							"valueMake",
            	      							lv_valueMake_5_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.ValueMake");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAttrValueMake"


    // $ANTLR start "entryRuleVariableorSymConstant"
    // InternalSoarParser.g:1991:1: entryRuleVariableorSymConstant returns [EObject current=null] : iv_ruleVariableorSymConstant= ruleVariableorSymConstant EOF ;
    public final EObject entryRuleVariableorSymConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableorSymConstant = null;


        try {
            // InternalSoarParser.g:1991:62: (iv_ruleVariableorSymConstant= ruleVariableorSymConstant EOF )
            // InternalSoarParser.g:1992:2: iv_ruleVariableorSymConstant= ruleVariableorSymConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableorSymConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleVariableorSymConstant=ruleVariableorSymConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableorSymConstant; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableorSymConstant"


    // $ANTLR start "ruleVariableorSymConstant"
    // InternalSoarParser.g:1998:1: ruleVariableorSymConstant returns [EObject current=null] : ( () ( ( (lv_variable_1_0= ruleVariable ) ) | (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) ) ) ;
    public final EObject ruleVariableorSymConstant() throws RecognitionException {
        EObject current = null;

        Token this_SYM_CONSTANT_STRING_2=null;
        EObject lv_variable_1_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:2004:2: ( ( () ( ( (lv_variable_1_0= ruleVariable ) ) | (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) ) ) )
            // InternalSoarParser.g:2005:2: ( () ( ( (lv_variable_1_0= ruleVariable ) ) | (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) ) )
            {
            // InternalSoarParser.g:2005:2: ( () ( ( (lv_variable_1_0= ruleVariable ) ) | (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) ) )
            // InternalSoarParser.g:2006:3: () ( ( (lv_variable_1_0= ruleVariable ) ) | (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) )
            {
            // InternalSoarParser.g:2006:3: ()
            // InternalSoarParser.g:2007:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableorSymConstantAccess().getVariableorSymConstantAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:2016:3: ( ( (lv_variable_1_0= ruleVariable ) ) | (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE ) )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==LessThanSign) ) {
                alt39=1;
            }
            else if ( (LA39_0==State||LA39_0==RULE_SYM_CONSTANT_STRING) ) {
                alt39=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // InternalSoarParser.g:2017:4: ( (lv_variable_1_0= ruleVariable ) )
                    {
                    // InternalSoarParser.g:2017:4: ( (lv_variable_1_0= ruleVariable ) )
                    // InternalSoarParser.g:2018:5: (lv_variable_1_0= ruleVariable )
                    {
                    // InternalSoarParser.g:2018:5: (lv_variable_1_0= ruleVariable )
                    // InternalSoarParser.g:2019:6: lv_variable_1_0= ruleVariable
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableorSymConstantAccess().getVariableVariableParserRuleCall_1_0_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_variable_1_0=ruleVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVariableorSymConstantRule());
                      						}
                      						set(
                      							current,
                      							"variable",
                      							lv_variable_1_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.Variable");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:2037:4: (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE )
                    {
                    // InternalSoarParser.g:2037:4: (this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING | ruleSTATE )
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( (LA38_0==RULE_SYM_CONSTANT_STRING) ) {
                        alt38=1;
                    }
                    else if ( (LA38_0==State) ) {
                        alt38=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 38, 0, input);

                        throw nvae;
                    }
                    switch (alt38) {
                        case 1 :
                            // InternalSoarParser.g:2038:5: this_SYM_CONSTANT_STRING_2= RULE_SYM_CONSTANT_STRING
                            {
                            this_SYM_CONSTANT_STRING_2=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SYM_CONSTANT_STRING_2, grammarAccess.getVariableorSymConstantAccess().getSYM_CONSTANT_STRINGTerminalRuleCall_1_1_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSoarParser.g:2043:5: ruleSTATE
                            {
                            if ( state.backtracking==0 ) {

                              					/* */
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getVariableorSymConstantAccess().getSTATEParserRuleCall_1_1_1());
                              				
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleSTATE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableorSymConstant"


    // $ANTLR start "entryRuleConstant"
    // InternalSoarParser.g:2059:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalSoarParser.g:2059:49: (iv_ruleConstant= ruleConstant EOF )
            // InternalSoarParser.g:2060:2: iv_ruleConstant= ruleConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConstant; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // InternalSoarParser.g:2066:1: ruleConstant returns [EObject current=null] : ( () ( (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | this_INT_3= RULE_INT | this_FLOAT_4= RULE_FLOAT | this_PRINT_STRING_5= RULE_PRINT_STRING ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

        Token this_SYM_CONSTANT_STRING_1=null;
        Token this_INT_3=null;
        Token this_FLOAT_4=null;
        Token this_PRINT_STRING_5=null;


        	enterRule();

        try {
            // InternalSoarParser.g:2072:2: ( ( () ( (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | this_INT_3= RULE_INT | this_FLOAT_4= RULE_FLOAT | this_PRINT_STRING_5= RULE_PRINT_STRING ) ) )
            // InternalSoarParser.g:2073:2: ( () ( (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | this_INT_3= RULE_INT | this_FLOAT_4= RULE_FLOAT | this_PRINT_STRING_5= RULE_PRINT_STRING ) )
            {
            // InternalSoarParser.g:2073:2: ( () ( (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | this_INT_3= RULE_INT | this_FLOAT_4= RULE_FLOAT | this_PRINT_STRING_5= RULE_PRINT_STRING ) )
            // InternalSoarParser.g:2074:3: () ( (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | this_INT_3= RULE_INT | this_FLOAT_4= RULE_FLOAT | this_PRINT_STRING_5= RULE_PRINT_STRING )
            {
            // InternalSoarParser.g:2074:3: ()
            // InternalSoarParser.g:2075:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getConstantAccess().getConstantAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:2084:3: ( (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE ) | this_INT_3= RULE_INT | this_FLOAT_4= RULE_FLOAT | this_PRINT_STRING_5= RULE_PRINT_STRING )
            int alt41=4;
            switch ( input.LA(1) ) {
            case State:
            case RULE_SYM_CONSTANT_STRING:
                {
                alt41=1;
                }
                break;
            case RULE_INT:
                {
                alt41=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt41=3;
                }
                break;
            case RULE_PRINT_STRING:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalSoarParser.g:2085:4: (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE )
                    {
                    // InternalSoarParser.g:2085:4: (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | ruleSTATE )
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==RULE_SYM_CONSTANT_STRING) ) {
                        alt40=1;
                    }
                    else if ( (LA40_0==State) ) {
                        alt40=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 40, 0, input);

                        throw nvae;
                    }
                    switch (alt40) {
                        case 1 :
                            // InternalSoarParser.g:2086:5: this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING
                            {
                            this_SYM_CONSTANT_STRING_1=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_SYM_CONSTANT_STRING_1, grammarAccess.getConstantAccess().getSYM_CONSTANT_STRINGTerminalRuleCall_1_0_0());
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSoarParser.g:2091:5: ruleSTATE
                            {
                            if ( state.backtracking==0 ) {

                              					/* */
                              				
                            }
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getConstantAccess().getSTATEParserRuleCall_1_0_1());
                              				
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleSTATE();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:2103:4: this_INT_3= RULE_INT
                    {
                    this_INT_3=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_3, grammarAccess.getConstantAccess().getINTTerminalRuleCall_1_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:2108:4: this_FLOAT_4= RULE_FLOAT
                    {
                    this_FLOAT_4=(Token)match(input,RULE_FLOAT,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_FLOAT_4, grammarAccess.getConstantAccess().getFLOATTerminalRuleCall_1_2());
                      			
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:2113:4: this_PRINT_STRING_5= RULE_PRINT_STRING
                    {
                    this_PRINT_STRING_5=(Token)match(input,RULE_PRINT_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_PRINT_STRING_5, grammarAccess.getConstantAccess().getPRINT_STRINGTerminalRuleCall_1_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleValueMake"
    // InternalSoarParser.g:2122:1: entryRuleValueMake returns [EObject current=null] : iv_ruleValueMake= ruleValueMake EOF ;
    public final EObject entryRuleValueMake() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueMake = null;


        try {
            // InternalSoarParser.g:2122:50: (iv_ruleValueMake= ruleValueMake EOF )
            // InternalSoarParser.g:2123:2: iv_ruleValueMake= ruleValueMake EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValueMakeRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleValueMake=ruleValueMake();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValueMake; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueMake"


    // $ANTLR start "ruleValueMake"
    // InternalSoarParser.g:2129:1: ruleValueMake returns [EObject current=null] : ( () ( (lv_value_1_0= ruleValue ) ) ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )* ) ;
    public final EObject ruleValueMake() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;

        EObject lv_prefSpecifier_2_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:2135:2: ( ( () ( (lv_value_1_0= ruleValue ) ) ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )* ) )
            // InternalSoarParser.g:2136:2: ( () ( (lv_value_1_0= ruleValue ) ) ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )* )
            {
            // InternalSoarParser.g:2136:2: ( () ( (lv_value_1_0= ruleValue ) ) ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )* )
            // InternalSoarParser.g:2137:3: () ( (lv_value_1_0= ruleValue ) ) ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )*
            {
            // InternalSoarParser.g:2137:3: ()
            // InternalSoarParser.g:2138:4: 
            {
            if ( state.backtracking==0 ) {

              				/* */
              			
            }
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getValueMakeAccess().getValueMakeAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:2147:3: ( (lv_value_1_0= ruleValue ) )
            // InternalSoarParser.g:2148:4: (lv_value_1_0= ruleValue )
            {
            // InternalSoarParser.g:2148:4: (lv_value_1_0= ruleValue )
            // InternalSoarParser.g:2149:5: lv_value_1_0= ruleValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getValueMakeAccess().getValueValueParserRuleCall_1_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_41);
            lv_value_1_0=ruleValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getValueMakeRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.Value");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSoarParser.g:2166:3: ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==LessThanSign) ) {
                    switch ( input.LA(2) ) {
                    case RULE_SYM_CONSTANT_STRING:
                        {
                        int LA42_4 = input.LA(3);

                        if ( (LA42_4==GreaterThanSign) ) {
                            int LA42_6 = input.LA(4);

                            if ( (synpred67_InternalSoarParser()) ) {
                                alt42=1;
                            }


                        }
                        else if ( (LA42_4==EOF||LA42_4==State||(LA42_4>=ExclamationMark && LA42_4<=RightParenthesis)||LA42_4==PlusSign||LA42_4==HyphenMinus||(LA42_4>=LessThanSign && LA42_4<=EqualsSign)||LA42_4==CommercialAt||LA42_4==CircumflexAccent||(LA42_4>=Tilde && LA42_4<=RULE_INT)) ) {
                            alt42=1;
                        }


                        }
                        break;
                    case State:
                        {
                        int LA42_5 = input.LA(3);

                        if ( (LA42_5==GreaterThanSign) ) {
                            int LA42_6 = input.LA(4);

                            if ( (synpred67_InternalSoarParser()) ) {
                                alt42=1;
                            }


                        }
                        else if ( (LA42_5==EOF||LA42_5==State||(LA42_5>=ExclamationMark && LA42_5<=RightParenthesis)||LA42_5==PlusSign||LA42_5==HyphenMinus||(LA42_5>=LessThanSign && LA42_5<=EqualsSign)||LA42_5==CommercialAt||LA42_5==CircumflexAccent||(LA42_5>=Tilde && LA42_5<=RULE_INT)) ) {
                            alt42=1;
                        }


                        }
                        break;
                    case EOF:
                    case ExclamationMark:
                    case Ampersand:
                    case LeftParenthesis:
                    case RightParenthesis:
                    case PlusSign:
                    case Comma:
                    case HyphenMinus:
                    case LessThanSign:
                    case EqualsSign:
                    case GreaterThanSign:
                    case CommercialAt:
                    case CircumflexAccent:
                    case Tilde:
                    case RULE_PRINT_STRING:
                    case RULE_FLOAT:
                    case RULE_INT:
                        {
                        alt42=1;
                        }
                        break;

                    }

                }
                else if ( ((LA42_0>=ExclamationMark && LA42_0<=Ampersand)||LA42_0==PlusSign||LA42_0==HyphenMinus||(LA42_0>=EqualsSign && LA42_0<=CommercialAt)||LA42_0==Tilde) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSoarParser.g:2167:4: (lv_prefSpecifier_2_0= rulePrefSpecifier )
            	    {
            	    // InternalSoarParser.g:2167:4: (lv_prefSpecifier_2_0= rulePrefSpecifier )
            	    // InternalSoarParser.g:2168:5: lv_prefSpecifier_2_0= rulePrefSpecifier
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getValueMakeAccess().getPrefSpecifierPrefSpecifierParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_41);
            	    lv_prefSpecifier_2_0=rulePrefSpecifier();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getValueMakeRule());
            	      					}
            	      					add(
            	      						current,
            	      						"prefSpecifier",
            	      						lv_prefSpecifier_2_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.PrefSpecifier");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueMake"


    // $ANTLR start "entryRulePrefSpecifier"
    // InternalSoarParser.g:2189:1: entryRulePrefSpecifier returns [EObject current=null] : iv_rulePrefSpecifier= rulePrefSpecifier EOF ;
    public final EObject entryRulePrefSpecifier() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefSpecifier = null;


        try {
            // InternalSoarParser.g:2189:54: (iv_rulePrefSpecifier= rulePrefSpecifier EOF )
            // InternalSoarParser.g:2190:2: iv_rulePrefSpecifier= rulePrefSpecifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefSpecifierRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefSpecifier=rulePrefSpecifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefSpecifier; 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrefSpecifier"


    // $ANTLR start "rulePrefSpecifier"
    // InternalSoarParser.g:2196:1: rulePrefSpecifier returns [EObject current=null] : ( ( () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? ) ) | ( () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? ) ) ) ;
    public final EObject rulePrefSpecifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_unaryPref_1_0 = null;

        AntlrDatatypeRuleToken lv_unaryOrBinaryPref_4_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:2202:2: ( ( ( () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? ) ) | ( () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? ) ) ) )
            // InternalSoarParser.g:2203:2: ( ( () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? ) ) | ( () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? ) ) )
            {
            // InternalSoarParser.g:2203:2: ( ( () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? ) ) | ( () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? ) ) )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==ExclamationMark||LA46_0==PlusSign||LA46_0==HyphenMinus||LA46_0==CommercialAt||LA46_0==Tilde) ) {
                alt46=1;
            }
            else if ( (LA46_0==Ampersand||(LA46_0>=LessThanSign && LA46_0<=GreaterThanSign)) ) {
                alt46=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // InternalSoarParser.g:2204:3: ( () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? ) )
                    {
                    // InternalSoarParser.g:2204:3: ( () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? ) )
                    // InternalSoarParser.g:2205:4: () ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? )
                    {
                    // InternalSoarParser.g:2205:4: ()
                    // InternalSoarParser.g:2206:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefSpecifierAccess().getPrefSpecifierAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:2215:4: ( ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )? )
                    // InternalSoarParser.g:2216:5: ( (lv_unaryPref_1_0= ruleUnaryPref ) ) (otherlv_2= Comma )?
                    {
                    // InternalSoarParser.g:2216:5: ( (lv_unaryPref_1_0= ruleUnaryPref ) )
                    // InternalSoarParser.g:2217:6: (lv_unaryPref_1_0= ruleUnaryPref )
                    {
                    // InternalSoarParser.g:2217:6: (lv_unaryPref_1_0= ruleUnaryPref )
                    // InternalSoarParser.g:2218:7: lv_unaryPref_1_0= ruleUnaryPref
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPrefSpecifierAccess().getUnaryPrefUnaryPrefParserRuleCall_0_1_0_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
                    lv_unaryPref_1_0=ruleUnaryPref();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPrefSpecifierRule());
                      							}
                      							set(
                      								current,
                      								"unaryPref",
                      								lv_unaryPref_1_0,
                      								"com.collins.trustedmethods.matrics.soar.Soar.UnaryPref");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSoarParser.g:2235:5: (otherlv_2= Comma )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==Comma) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // InternalSoarParser.g:2236:6: otherlv_2= Comma
                            {
                            otherlv_2=(Token)match(input,Comma,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_2, grammarAccess.getPrefSpecifierAccess().getCommaKeyword_0_1_1());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:2244:3: ( () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? ) )
                    {
                    // InternalSoarParser.g:2244:3: ( () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? ) )
                    // InternalSoarParser.g:2245:4: () ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? )
                    {
                    // InternalSoarParser.g:2245:4: ()
                    // InternalSoarParser.g:2246:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					/* */
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefSpecifierAccess().getPrefSpecifierAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:2255:4: ( ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )? )
                    // InternalSoarParser.g:2256:5: ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) ) (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )? (otherlv_7= Comma )?
                    {
                    // InternalSoarParser.g:2256:5: ( (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref ) )
                    // InternalSoarParser.g:2257:6: (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref )
                    {
                    // InternalSoarParser.g:2257:6: (lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref )
                    // InternalSoarParser.g:2258:7: lv_unaryOrBinaryPref_4_0= ruleUnaryOrBinaryPref
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getPrefSpecifierAccess().getUnaryOrBinaryPrefUnaryOrBinaryPrefParserRuleCall_1_1_0_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_42);
                    lv_unaryOrBinaryPref_4_0=ruleUnaryOrBinaryPref();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getPrefSpecifierRule());
                      							}
                      							set(
                      								current,
                      								"unaryOrBinaryPref",
                      								lv_unaryOrBinaryPref_4_0,
                      								"com.collins.trustedmethods.matrics.soar.Soar.UnaryOrBinaryPref");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }

                    // InternalSoarParser.g:2275:5: (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )?
                    int alt44=2;
                    alt44 = dfa44.predict(input);
                    switch (alt44) {
                        case 1 :
                            // InternalSoarParser.g:2276:6: otherlv_5= Comma ( (lv_value_6_0= ruleValue ) )
                            {
                            otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_5, grammarAccess.getPrefSpecifierAccess().getCommaKeyword_1_1_1_0());
                              					
                            }
                            // InternalSoarParser.g:2280:6: ( (lv_value_6_0= ruleValue ) )
                            // InternalSoarParser.g:2281:7: (lv_value_6_0= ruleValue )
                            {
                            // InternalSoarParser.g:2281:7: (lv_value_6_0= ruleValue )
                            // InternalSoarParser.g:2282:8: lv_value_6_0= ruleValue
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getPrefSpecifierAccess().getValueValueParserRuleCall_1_1_1_1_0());
                              							
                            }
                            pushFollow(FollowSets000.FOLLOW_42);
                            lv_value_6_0=ruleValue();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getPrefSpecifierRule());
                              								}
                              								set(
                              									current,
                              									"value",
                              									lv_value_6_0,
                              									"com.collins.trustedmethods.matrics.soar.Soar.Value");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }


                            }
                            break;

                    }

                    // InternalSoarParser.g:2300:5: (otherlv_7= Comma )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==Comma) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // InternalSoarParser.g:2301:6: otherlv_7= Comma
                            {
                            otherlv_7=(Token)match(input,Comma,FollowSets000.FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						newLeafNode(otherlv_7, grammarAccess.getPrefSpecifierAccess().getCommaKeyword_1_1_2());
                              					
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrefSpecifier"


    // $ANTLR start "entryRuleUnaryPref"
    // InternalSoarParser.g:2312:1: entryRuleUnaryPref returns [String current=null] : iv_ruleUnaryPref= ruleUnaryPref EOF ;
    public final String entryRuleUnaryPref() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryPref = null;


        try {
            // InternalSoarParser.g:2312:49: (iv_ruleUnaryPref= ruleUnaryPref EOF )
            // InternalSoarParser.g:2313:2: iv_ruleUnaryPref= ruleUnaryPref EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryPrefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryPref=ruleUnaryPref();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryPref.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryPref"


    // $ANTLR start "ruleUnaryPref"
    // InternalSoarParser.g:2319:1: ruleUnaryPref returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt ) ;
    public final AntlrDatatypeRuleToken ruleUnaryPref() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:2325:2: ( (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt ) )
            // InternalSoarParser.g:2326:2: (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt )
            {
            // InternalSoarParser.g:2326:2: (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt )
            int alt47=5;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt47=1;
                }
                break;
            case HyphenMinus:
                {
                alt47=2;
                }
                break;
            case ExclamationMark:
                {
                alt47=3;
                }
                break;
            case Tilde:
                {
                alt47=4;
                }
                break;
            case CommercialAt:
                {
                alt47=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }

            switch (alt47) {
                case 1 :
                    // InternalSoarParser.g:2327:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:2333:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:2339:3: kw= ExclamationMark
                    {
                    kw=(Token)match(input,ExclamationMark,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getExclamationMarkKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:2345:3: kw= Tilde
                    {
                    kw=(Token)match(input,Tilde,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getTildeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:2351:3: kw= CommercialAt
                    {
                    kw=(Token)match(input,CommercialAt,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getCommercialAtKeyword_4());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryPref"


    // $ANTLR start "entryRuleUnaryOrBinaryPref"
    // InternalSoarParser.g:2360:1: entryRuleUnaryOrBinaryPref returns [String current=null] : iv_ruleUnaryOrBinaryPref= ruleUnaryOrBinaryPref EOF ;
    public final String entryRuleUnaryOrBinaryPref() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOrBinaryPref = null;


        try {
            // InternalSoarParser.g:2360:57: (iv_ruleUnaryOrBinaryPref= ruleUnaryOrBinaryPref EOF )
            // InternalSoarParser.g:2361:2: iv_ruleUnaryOrBinaryPref= ruleUnaryOrBinaryPref EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryOrBinaryPrefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleUnaryOrBinaryPref=ruleUnaryOrBinaryPref();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryOrBinaryPref.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryOrBinaryPref"


    // $ANTLR start "ruleUnaryOrBinaryPref"
    // InternalSoarParser.g:2367:1: ruleUnaryOrBinaryPref returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOrBinaryPref() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:2373:2: ( (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand ) )
            // InternalSoarParser.g:2374:2: (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand )
            {
            // InternalSoarParser.g:2374:2: (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand )
            int alt48=4;
            switch ( input.LA(1) ) {
            case GreaterThanSign:
                {
                alt48=1;
                }
                break;
            case EqualsSign:
                {
                alt48=2;
                }
                break;
            case LessThanSign:
                {
                alt48=3;
                }
                break;
            case Ampersand:
                {
                alt48=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }

            switch (alt48) {
                case 1 :
                    // InternalSoarParser.g:2375:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:2381:3: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:2387:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getLessThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:2393:3: kw= Ampersand
                    {
                    kw=(Token)match(input,Ampersand,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getAmpersandKeyword_3());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOrBinaryPref"


    // $ANTLR start "entryRuleSTATE"
    // InternalSoarParser.g:2402:1: entryRuleSTATE returns [String current=null] : iv_ruleSTATE= ruleSTATE EOF ;
    public final String entryRuleSTATE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTATE = null;


        try {
            // InternalSoarParser.g:2402:45: (iv_ruleSTATE= ruleSTATE EOF )
            // InternalSoarParser.g:2403:2: iv_ruleSTATE= ruleSTATE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSTATERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSTATE=ruleSTATE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSTATE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSTATE"


    // $ANTLR start "ruleSTATE"
    // InternalSoarParser.g:2409:1: ruleSTATE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= State ;
    public final AntlrDatatypeRuleToken ruleSTATE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:2415:2: (kw= State )
            // InternalSoarParser.g:2416:2: kw= State
            {
            kw=(Token)match(input,State,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getSTATEAccess().getStateKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSTATE"


    // $ANTLR start "entryRuleIMPASSE"
    // InternalSoarParser.g:2424:1: entryRuleIMPASSE returns [String current=null] : iv_ruleIMPASSE= ruleIMPASSE EOF ;
    public final String entryRuleIMPASSE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMPASSE = null;


        try {
            // InternalSoarParser.g:2424:47: (iv_ruleIMPASSE= ruleIMPASSE EOF )
            // InternalSoarParser.g:2425:2: iv_ruleIMPASSE= ruleIMPASSE EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIMPASSERule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleIMPASSE=ruleIMPASSE();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIMPASSE.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIMPASSE"


    // $ANTLR start "ruleIMPASSE"
    // InternalSoarParser.g:2431:1: ruleIMPASSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Impasse ;
    public final AntlrDatatypeRuleToken ruleIMPASSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:2437:2: (kw= Impasse )
            // InternalSoarParser.g:2438:2: kw= Impasse
            {
            kw=(Token)match(input,Impasse,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getIMPASSEAccess().getImpasseKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIMPASSE"

    // $ANTLR start synpred42_InternalSoarParser
    public final void synpred42_InternalSoarParser_fragment() throws RecognitionException {   
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_singleTest_9_0 = null;


        // InternalSoarParser.g:1335:3: ( ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) ) )
        // InternalSoarParser.g:1335:3: ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) )
        {
        // InternalSoarParser.g:1335:3: ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) )
        // InternalSoarParser.g:1336:4: () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) )
        {
        // InternalSoarParser.g:1336:4: ()
        // InternalSoarParser.g:1337:5: 
        {
        if ( state.backtracking==0 ) {

          					/* */
          				
        }

        }

        // InternalSoarParser.g:1346:4: (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign )
        int alt50=8;
        switch ( input.LA(1) ) {
        case LessThanSignGreaterThanSign:
            {
            alt50=1;
            }
            break;
        case LessThanSign:
            {
            alt50=2;
            }
            break;
        case GreaterThanSign:
            {
            alt50=3;
            }
            break;
        case LessThanSignEqualsSign:
            {
            alt50=4;
            }
            break;
        case GreaterThanSignEqualsSign:
            {
            alt50=5;
            }
            break;
        case EqualsSignEqualsSign:
            {
            alt50=6;
            }
            break;
        case LessThanSignEqualsSignGreaterThanSign:
            {
            alt50=7;
            }
            break;
        case EqualsSign:
            {
            alt50=8;
            }
            break;
        default:
            if (state.backtracking>0) {state.failed=true; return ;}
            NoViableAltException nvae =
                new NoViableAltException("", 50, 0, input);

            throw nvae;
        }

        switch (alt50) {
            case 1 :
                // InternalSoarParser.g:1347:5: otherlv_1= LessThanSignGreaterThanSign
                {
                otherlv_1=(Token)match(input,LessThanSignGreaterThanSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 2 :
                // InternalSoarParser.g:1352:5: otherlv_2= LessThanSign
                {
                otherlv_2=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 3 :
                // InternalSoarParser.g:1357:5: otherlv_3= GreaterThanSign
                {
                otherlv_3=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 4 :
                // InternalSoarParser.g:1362:5: otherlv_4= LessThanSignEqualsSign
                {
                otherlv_4=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 5 :
                // InternalSoarParser.g:1367:5: otherlv_5= GreaterThanSignEqualsSign
                {
                otherlv_5=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 6 :
                // InternalSoarParser.g:1372:5: otherlv_6= EqualsSignEqualsSign
                {
                otherlv_6=(Token)match(input,EqualsSignEqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 7 :
                // InternalSoarParser.g:1377:5: otherlv_7= LessThanSignEqualsSignGreaterThanSign
                {
                otherlv_7=(Token)match(input,LessThanSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;
            case 8 :
                // InternalSoarParser.g:1382:5: otherlv_8= EqualsSign
                {
                otherlv_8=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_27); if (state.failed) return ;

                }
                break;

        }

        // InternalSoarParser.g:1387:4: ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) )
        // InternalSoarParser.g:1388:5: ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest )
        {
        // InternalSoarParser.g:1392:5: (lv_singleTest_9_0= ruleSingleTest )
        // InternalSoarParser.g:1393:6: lv_singleTest_9_0= ruleSingleTest
        {
        if ( state.backtracking==0 ) {

          						newCompositeNode(grammarAccess.getRelationalTestAccess().getSingleTestSingleTestParserRuleCall_0_2_0());
          					
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_singleTest_9_0=ruleSingleTest();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred42_InternalSoarParser

    // $ANTLR start synpred67_InternalSoarParser
    public final void synpred67_InternalSoarParser_fragment() throws RecognitionException {   
        EObject lv_prefSpecifier_2_0 = null;


        // InternalSoarParser.g:2167:4: ( (lv_prefSpecifier_2_0= rulePrefSpecifier ) )
        // InternalSoarParser.g:2167:4: (lv_prefSpecifier_2_0= rulePrefSpecifier )
        {
        // InternalSoarParser.g:2167:4: (lv_prefSpecifier_2_0= rulePrefSpecifier )
        // InternalSoarParser.g:2168:5: lv_prefSpecifier_2_0= rulePrefSpecifier
        {
        if ( state.backtracking==0 ) {

          					newCompositeNode(grammarAccess.getValueMakeAccess().getPrefSpecifierPrefSpecifierParserRuleCall_2_0());
          				
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_prefSpecifier_2_0=rulePrefSpecifier();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred67_InternalSoarParser

    // $ANTLR start synpred70_InternalSoarParser
    public final void synpred70_InternalSoarParser_fragment() throws RecognitionException {   
        Token otherlv_5=null;
        EObject lv_value_6_0 = null;


        // InternalSoarParser.g:2276:6: (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )
        // InternalSoarParser.g:2276:6: otherlv_5= Comma ( (lv_value_6_0= ruleValue ) )
        {
        otherlv_5=(Token)match(input,Comma,FollowSets000.FOLLOW_43); if (state.failed) return ;
        // InternalSoarParser.g:2280:6: ( (lv_value_6_0= ruleValue ) )
        // InternalSoarParser.g:2281:7: (lv_value_6_0= ruleValue )
        {
        // InternalSoarParser.g:2281:7: (lv_value_6_0= ruleValue )
        // InternalSoarParser.g:2282:8: lv_value_6_0= ruleValue
        {
        if ( state.backtracking==0 ) {

          								newCompositeNode(grammarAccess.getPrefSpecifierAccess().getValueValueParserRuleCall_1_1_1_1_0());
          							
        }
        pushFollow(FollowSets000.FOLLOW_2);
        lv_value_6_0=ruleValue();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred70_InternalSoarParser

    // Delegated rules

    public final boolean synpred67_InternalSoarParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_InternalSoarParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred42_InternalSoarParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred42_InternalSoarParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred70_InternalSoarParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred70_InternalSoarParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA23 dfa23 = new DFA23(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA44 dfa44 = new DFA44(this);
    static final String dfa_1s = "\37\uffff";
    static final String dfa_2s = "\12\uffff\5\32\3\uffff\7\32\4\uffff\2\32";
    static final String dfa_3s = "\1\13\1\uffff\15\13\2\uffff\10\13\2\uffff\2\45\2\13";
    static final String dfa_4s = "\1\60\1\uffff\15\60\2\uffff\1\55\7\60\2\uffff\2\45\2\60";
    static final String dfa_5s = "\1\uffff\1\1\15\uffff\1\3\1\5\10\uffff\1\2\1\4\4\uffff";
    static final String dfa_6s = "\37\uffff}>";
    static final String[] dfa_7s = {
            "\1\13\3\uffff\1\10\1\17\1\5\1\2\1\7\1\6\16\uffff\1\3\1\11\1\4\1\uffff\1\20\2\uffff\1\1\2\uffff\1\12\1\16\1\15\1\14",
            "",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\30\27\uffff\1\21\11\uffff\1\27\1\26\1\25\1\24",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\23\27\uffff\1\21\11\uffff\1\22\1\26\1\25\1\24",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "",
            "",
            "\1\34\41\uffff\1\33",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\2\32\1\35\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\2\32\1\35\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "",
            "",
            "\1\36",
            "\1\36",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32",
            "\1\32\3\uffff\6\32\5\uffff\2\32\1\uffff\1\32\1\uffff\1\32\3\uffff\3\32\1\uffff\1\32\1\uffff\2\32\1\31\1\uffff\4\32"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1049:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_disjunctionTest_2_0= ruleDisjunctionTest ) ) ) | ( ( (lv_relationalTest_3_0= ruleRelationalTest ) ) otherlv_4= RightCurlyBracket ) | ( () ( (lv_disjunctionTest_6_0= ruleDisjunctionTest ) ) ) | ( (lv_relationalTest_7_0= ruleRelationalTest ) ) | ( () otherlv_9= LeftSquareBracket (this_INT_10= RULE_INT )+ otherlv_11= RightSquareBracket ) )";
        }
    }
    static final String dfa_8s = "\20\uffff";
    static final String dfa_9s = "\4\uffff\2\1\1\3\6\uffff\2\3\1\uffff";
    static final String dfa_10s = "\1\13\1\uffff\1\13\1\uffff\4\13\5\0\2\13\1\0";
    static final String dfa_11s = "\1\60\1\uffff\1\60\1\uffff\4\60\5\0\2\60\1\0";
    static final String dfa_12s = "\1\uffff\1\1\1\uffff\1\2\14\uffff";
    static final String dfa_13s = "\10\uffff\1\0\1\4\1\5\1\2\1\3\2\uffff\1\1}>";
    static final String[] dfa_14s = {
            "\1\3\3\uffff\1\1\1\uffff\4\1\16\uffff\1\2\2\1\7\uffff\4\3",
            "",
            "\1\5\27\uffff\1\1\11\uffff\1\4\3\1",
            "",
            "\1\1\3\uffff\6\1\5\uffff\2\1\1\uffff\1\1\1\uffff\1\1\3\uffff\2\1\1\6\1\uffff\1\1\1\uffff\3\1\1\uffff\4\1",
            "\1\1\3\uffff\6\1\5\uffff\2\1\1\uffff\1\1\1\uffff\1\1\3\uffff\2\1\1\6\1\uffff\1\1\1\uffff\3\1\1\uffff\4\1",
            "\1\11\3\uffff\6\3\5\uffff\2\3\1\uffff\1\3\1\uffff\1\3\3\uffff\1\7\2\3\1\uffff\1\3\1\uffff\3\3\1\uffff\1\10\1\14\1\13\1\12",
            "\1\16\27\uffff\1\3\11\uffff\1\15\3\3",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\3\3\uffff\6\3\5\uffff\2\3\1\uffff\1\3\1\uffff\1\3\3\uffff\2\3\1\17\1\uffff\1\3\1\uffff\3\3\1\uffff\4\3",
            "\1\3\3\uffff\6\3\5\uffff\2\3\1\uffff\1\3\1\uffff\1\3\3\uffff\2\3\1\17\1\uffff\1\3\1\uffff\3\3\1\uffff\4\3",
            "\1\uffff"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1334:2: ( ( () (otherlv_1= LessThanSignGreaterThanSign | otherlv_2= LessThanSign | otherlv_3= GreaterThanSign | otherlv_4= LessThanSignEqualsSign | otherlv_5= GreaterThanSignEqualsSign | otherlv_6= EqualsSignEqualsSign | otherlv_7= LessThanSignEqualsSignGreaterThanSign | otherlv_8= EqualsSign ) ( ( ( ruleSingleTest ) )=> (lv_singleTest_9_0= ruleSingleTest ) ) ) | ( () ( (lv_singleTest_11_0= ruleSingleTest ) ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_8 = input.LA(1);

                         
                        int index27_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSoarParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index27_8);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_15 = input.LA(1);

                         
                        int index27_15 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSoarParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index27_15);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_11 = input.LA(1);

                         
                        int index27_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSoarParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index27_11);
                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_12 = input.LA(1);

                         
                        int index27_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSoarParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index27_12);
                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_9 = input.LA(1);

                         
                        int index27_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSoarParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index27_9);
                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_10 = input.LA(1);

                         
                        int index27_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred42_InternalSoarParser()) ) {s = 1;}

                        else if ( (true) ) {s = 3;}

                         
                        input.seek(index27_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_15s = "\25\uffff";
    static final String dfa_16s = "\1\2\24\uffff";
    static final String dfa_17s = "\1\13\1\0\23\uffff";
    static final String dfa_18s = "\1\60\1\0\23\uffff";
    static final String dfa_19s = "\2\uffff\1\2\21\uffff\1\1";
    static final String dfa_20s = "\1\uffff\1\0\23\uffff}>";
    static final String[] dfa_21s = {
            "\1\2\14\uffff\4\2\1\uffff\1\2\1\1\1\2\3\uffff\4\2\2\uffff\1\2\2\uffff\5\2",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final short[] dfa_16 = DFA.unpackEncodedString(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final char[] dfa_18 = DFA.unpackEncodedStringToUnsignedChars(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[][] dfa_21 = unpackEncodedStringArray(dfa_21s);

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_15;
            this.eof = dfa_16;
            this.min = dfa_17;
            this.max = dfa_18;
            this.accept = dfa_19;
            this.special = dfa_20;
            this.transition = dfa_21;
        }
        public String getDescription() {
            return "2275:5: (otherlv_5= Comma ( (lv_value_6_0= ruleValue ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA44_1 = input.LA(1);

                         
                        int index44_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred70_InternalSoarParser()) ) {s = 20;}

                        else if ( (true) ) {s = 2;}

                         
                        input.seek(index44_1);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 44, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000C00002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000404002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000080004000000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000080000000000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000004F0L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000040084000002L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000000900L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000020880000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000020888000000L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000040084000000L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000C0084000000L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000800000900L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0001E4B9041F8802L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0001E4B8041F8802L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000002L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0001010000000000L});
        public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0001E038001E8800L});
        public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0001E038003E8800L});
        public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000200000000800L});
        public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000002000000000L});
        public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000020008000000L});
        public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000400800000200L});
        public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000400808000200L});
        public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x00002002B0000800L});
        public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0001E0380C1E8800L});
        public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000200800000800L});
        public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0001E039041E8802L});
        public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0001E038041E8802L});
        public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00001078A3000002L});
        public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0001E038041E8800L});
    }


}