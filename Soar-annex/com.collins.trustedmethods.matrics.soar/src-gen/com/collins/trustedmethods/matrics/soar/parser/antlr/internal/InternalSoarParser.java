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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ISupport", "OSupport", "Template", "Default", "Impasse", "Crlf", "Chunk", "State", "Write", "HyphenMinusHyphenMinusGreaterThanSign", "LessThanSignEqualsSignGreaterThanSign", "LessThanSignLessThanSign", "LessThanSignEqualsSign", "LessThanSignGreaterThanSign", "EqualsSignEqualsSign", "GreaterThanSignEqualsSign", "GreaterThanSignGreaterThanSign", "Gp", "Sp", "ExclamationMark", "Ampersand", "LeftParenthesis", "RightParenthesis", "PlusSign", "Comma", "HyphenMinus", "FullStop", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "CommercialAt", "LeftSquareBracket", "RightSquareBracket", "CircumflexAccent", "LeftCurlyBracket", "RightCurlyBracket", "Tilde", "RULE_SYM_CONSTANT_STRING", "RULE_STRING", "RULE_PIPE_STRING", "RULE_WS", "RULE_SL_COMMENT"
    };
    public static final int LessThanSignGreaterThanSign=17;
    public static final int RULE_PIPE_STRING=44;
    public static final int Gp=21;
    public static final int LessThanSign=32;
    public static final int Template=6;
    public static final int LeftParenthesis=25;
    public static final int Ampersand=24;
    public static final int RightSquareBracket=37;
    public static final int ExclamationMark=23;
    public static final int GreaterThanSign=34;
    public static final int ISupport=4;
    public static final int OSupport=5;
    public static final int RightParenthesis=26;
    public static final int Chunk=10;
    public static final int GreaterThanSignEqualsSign=19;
    public static final int EqualsSignEqualsSign=18;
    public static final int State=11;
    public static final int PlusSign=27;
    public static final int LeftSquareBracket=36;
    public static final int LessThanSignLessThanSign=15;
    public static final int Write=12;
    public static final int LessThanSignEqualsSignGreaterThanSign=14;
    public static final int RULE_STRING=43;
    public static final int Impasse=8;
    public static final int RULE_SL_COMMENT=46;
    public static final int Comma=28;
    public static final int EqualsSign=33;
    public static final int HyphenMinus=29;
    public static final int LessThanSignEqualsSign=16;
    public static final int Colon=31;
    public static final int RightCurlyBracket=40;
    public static final int EOF=-1;
    public static final int FullStop=30;
    public static final int RULE_WS=45;
    public static final int LeftCurlyBracket=39;
    public static final int Crlf=9;
    public static final int Tilde=41;
    public static final int GreaterThanSignGreaterThanSign=20;
    public static final int Default=7;
    public static final int CircumflexAccent=38;
    public static final int CommercialAt=35;
    public static final int HyphenMinusHyphenMinusGreaterThanSign=13;
    public static final int RULE_SYM_CONSTANT_STRING=42;
    public static final int Sp=22;

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
    // InternalSoarParser.g:77:1: entryRuleAnnexLibrary returns [EObject current=null] : iv_ruleAnnexLibrary= ruleAnnexLibrary EOF ;
    public final EObject entryRuleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnexLibrary = null;


        try {
            // InternalSoarParser.g:77:53: (iv_ruleAnnexLibrary= ruleAnnexLibrary EOF )
            // InternalSoarParser.g:78:2: iv_ruleAnnexLibrary= ruleAnnexLibrary EOF
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
    // InternalSoarParser.g:84:1: ruleAnnexLibrary returns [EObject current=null] : this_SoarAnnexLibrary_0= ruleSoarAnnexLibrary ;
    public final EObject ruleAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject this_SoarAnnexLibrary_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:90:2: (this_SoarAnnexLibrary_0= ruleSoarAnnexLibrary )
            // InternalSoarParser.g:91:2: this_SoarAnnexLibrary_0= ruleSoarAnnexLibrary
            {
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
    // InternalSoarParser.g:102:1: entryRuleSoarAnnexLibrary returns [EObject current=null] : iv_ruleSoarAnnexLibrary= ruleSoarAnnexLibrary EOF ;
    public final EObject entryRuleSoarAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoarAnnexLibrary = null;


        try {
            // InternalSoarParser.g:102:57: (iv_ruleSoarAnnexLibrary= ruleSoarAnnexLibrary EOF )
            // InternalSoarParser.g:103:2: iv_ruleSoarAnnexLibrary= ruleSoarAnnexLibrary EOF
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
    // InternalSoarParser.g:109:1: ruleSoarAnnexLibrary returns [EObject current=null] : ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) ;
    public final EObject ruleSoarAnnexLibrary() throws RecognitionException {
        EObject current = null;

        EObject lv_soarAnnexProductions_1_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:115:2: ( ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) )
            // InternalSoarParser.g:116:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            {
            // InternalSoarParser.g:116:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            // InternalSoarParser.g:117:3: () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            {
            // InternalSoarParser.g:117:3: ()
            // InternalSoarParser.g:118:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSoarAnnexLibraryAccess().getSoarAnnexLibraryAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:124:3: ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=Gp && LA1_0<=Sp)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalSoarParser.g:125:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    {
            	    // InternalSoarParser.g:125:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    // InternalSoarParser.g:126:5: lv_soarAnnexProductions_1_0= ruleSoarProduction
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
    // InternalSoarParser.g:147:1: entryRuleSoarAnnexSubclause returns [EObject current=null] : iv_ruleSoarAnnexSubclause= ruleSoarAnnexSubclause EOF ;
    public final EObject entryRuleSoarAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoarAnnexSubclause = null;


        try {
            // InternalSoarParser.g:147:59: (iv_ruleSoarAnnexSubclause= ruleSoarAnnexSubclause EOF )
            // InternalSoarParser.g:148:2: iv_ruleSoarAnnexSubclause= ruleSoarAnnexSubclause EOF
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
    // InternalSoarParser.g:154:1: ruleSoarAnnexSubclause returns [EObject current=null] : ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) ;
    public final EObject ruleSoarAnnexSubclause() throws RecognitionException {
        EObject current = null;

        EObject lv_soarAnnexProductions_1_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:160:2: ( ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* ) )
            // InternalSoarParser.g:161:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            {
            // InternalSoarParser.g:161:2: ( () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )* )
            // InternalSoarParser.g:162:3: () ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            {
            // InternalSoarParser.g:162:3: ()
            // InternalSoarParser.g:163:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSoarAnnexSubclauseAccess().getSoarAnnexSubclauseAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:169:3: ( (lv_soarAnnexProductions_1_0= ruleSoarProduction ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=Gp && LA2_0<=Sp)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalSoarParser.g:170:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    {
            	    // InternalSoarParser.g:170:4: (lv_soarAnnexProductions_1_0= ruleSoarProduction )
            	    // InternalSoarParser.g:171:5: lv_soarAnnexProductions_1_0= ruleSoarProduction
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
    // InternalSoarParser.g:192:1: entryRuleSoarProduction returns [EObject current=null] : iv_ruleSoarProduction= ruleSoarProduction EOF ;
    public final EObject entryRuleSoarProduction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoarProduction = null;


        try {
            // InternalSoarParser.g:192:55: (iv_ruleSoarProduction= ruleSoarProduction EOF )
            // InternalSoarParser.g:193:2: iv_ruleSoarProduction= ruleSoarProduction EOF
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
    // InternalSoarParser.g:199:1: ruleSoarProduction returns [EObject current=null] : ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleStateImpCondition ) )* otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSideExpr ) )+ otherlv_10= RightCurlyBracket ) ;
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
            // InternalSoarParser.g:205:2: ( ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleStateImpCondition ) )* otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSideExpr ) )+ otherlv_10= RightCurlyBracket ) )
            // InternalSoarParser.g:206:2: ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleStateImpCondition ) )* otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSideExpr ) )+ otherlv_10= RightCurlyBracket )
            {
            // InternalSoarParser.g:206:2: ( () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleStateImpCondition ) )* otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSideExpr ) )+ otherlv_10= RightCurlyBracket )
            // InternalSoarParser.g:207:3: () (otherlv_1= Sp | otherlv_2= Gp ) otherlv_3= LeftCurlyBracket ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_doc_5_0= ruleDocumentation ) )? ( (lv_flag_6_0= ruleFlags ) )? ( (lv_conditions_7_0= ruleStateImpCondition ) )* otherlv_8= HyphenMinusHyphenMinusGreaterThanSign ( (lv_actions_9_0= ruleActionSideExpr ) )+ otherlv_10= RightCurlyBracket
            {
            // InternalSoarParser.g:207:3: ()
            // InternalSoarParser.g:208:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSoarProductionAccess().getSoarProductionAction_0(),
              					current);
              			
            }

            }

            // InternalSoarParser.g:214:3: (otherlv_1= Sp | otherlv_2= Gp )
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
                    // InternalSoarParser.g:215:4: otherlv_1= Sp
                    {
                    otherlv_1=(Token)match(input,Sp,FollowSets000.FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSoarProductionAccess().getSpKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:220:4: otherlv_2= Gp
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
            // InternalSoarParser.g:229:3: ( (lv_name_4_0= RULE_SYM_CONSTANT_STRING ) )
            // InternalSoarParser.g:230:4: (lv_name_4_0= RULE_SYM_CONSTANT_STRING )
            {
            // InternalSoarParser.g:230:4: (lv_name_4_0= RULE_SYM_CONSTANT_STRING )
            // InternalSoarParser.g:231:5: lv_name_4_0= RULE_SYM_CONSTANT_STRING
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

            // InternalSoarParser.g:247:3: ( (lv_doc_5_0= ruleDocumentation ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalSoarParser.g:248:4: (lv_doc_5_0= ruleDocumentation )
                    {
                    // InternalSoarParser.g:248:4: (lv_doc_5_0= ruleDocumentation )
                    // InternalSoarParser.g:249:5: lv_doc_5_0= ruleDocumentation
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSoarProductionAccess().getDocDocumentationParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_7);
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

            // InternalSoarParser.g:266:3: ( (lv_flag_6_0= ruleFlags ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==Colon) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalSoarParser.g:267:4: (lv_flag_6_0= ruleFlags )
                    {
                    // InternalSoarParser.g:267:4: (lv_flag_6_0= ruleFlags )
                    // InternalSoarParser.g:268:5: lv_flag_6_0= ruleFlags
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSoarProductionAccess().getFlagFlagsParserRuleCall_5_0());
                      				
                    }
                    pushFollow(FollowSets000.FOLLOW_8);
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

            // InternalSoarParser.g:285:3: ( (lv_conditions_7_0= ruleStateImpCondition ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==LeftParenthesis) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSoarParser.g:286:4: (lv_conditions_7_0= ruleStateImpCondition )
            	    {
            	    // InternalSoarParser.g:286:4: (lv_conditions_7_0= ruleStateImpCondition )
            	    // InternalSoarParser.g:287:5: lv_conditions_7_0= ruleStateImpCondition
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSoarProductionAccess().getConditionsStateImpConditionParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_8);
            	    lv_conditions_7_0=ruleStateImpCondition();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSoarProductionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"conditions",
            	      						lv_conditions_7_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.StateImpCondition");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,HyphenMinusHyphenMinusGreaterThanSign,FollowSets000.FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getSoarProductionAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_7());
              		
            }
            // InternalSoarParser.g:308:3: ( (lv_actions_9_0= ruleActionSideExpr ) )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==LeftParenthesis) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSoarParser.g:309:4: (lv_actions_9_0= ruleActionSideExpr )
            	    {
            	    // InternalSoarParser.g:309:4: (lv_actions_9_0= ruleActionSideExpr )
            	    // InternalSoarParser.g:310:5: lv_actions_9_0= ruleActionSideExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSoarProductionAccess().getActionsActionSideExprParserRuleCall_8_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_10);
            	    lv_actions_9_0=ruleActionSideExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSoarProductionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"actions",
            	      						lv_actions_9_0,
            	      						"com.collins.trustedmethods.matrics.soar.Soar.ActionSideExpr");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

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
    // InternalSoarParser.g:335:1: entryRuleDocumentation returns [String current=null] : iv_ruleDocumentation= ruleDocumentation EOF ;
    public final String entryRuleDocumentation() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDocumentation = null;


        try {
            // InternalSoarParser.g:335:53: (iv_ruleDocumentation= ruleDocumentation EOF )
            // InternalSoarParser.g:336:2: iv_ruleDocumentation= ruleDocumentation EOF
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
    // InternalSoarParser.g:342:1: ruleDocumentation returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleDocumentation() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalSoarParser.g:348:2: (this_STRING_0= RULE_STRING )
            // InternalSoarParser.g:349:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_STRING_0);
              	
            }
            if ( state.backtracking==0 ) {

              		newLeafNode(this_STRING_0, grammarAccess.getDocumentationAccess().getSTRINGTerminalRuleCall());
              	
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
    // InternalSoarParser.g:359:1: entryRuleFlags returns [String current=null] : iv_ruleFlags= ruleFlags EOF ;
    public final String entryRuleFlags() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFlags = null;


        try {
            // InternalSoarParser.g:359:45: (iv_ruleFlags= ruleFlags EOF )
            // InternalSoarParser.g:360:2: iv_ruleFlags= ruleFlags EOF
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
    // InternalSoarParser.g:366:1: ruleFlags returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) ) ;
    public final AntlrDatatypeRuleToken ruleFlags() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:372:2: ( (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) ) )
            // InternalSoarParser.g:373:2: (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) )
            {
            // InternalSoarParser.g:373:2: (kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template ) )
            // InternalSoarParser.g:374:3: kw= Colon (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template )
            {
            kw=(Token)match(input,Colon,FollowSets000.FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getFlagsAccess().getColonKeyword_0());
              		
            }
            // InternalSoarParser.g:379:3: (kw= OSupport | kw= ISupport | kw= Chunk | kw= Default | kw= Template )
            int alt8=5;
            switch ( input.LA(1) ) {
            case OSupport:
                {
                alt8=1;
                }
                break;
            case ISupport:
                {
                alt8=2;
                }
                break;
            case Chunk:
                {
                alt8=3;
                }
                break;
            case Default:
                {
                alt8=4;
                }
                break;
            case Template:
                {
                alt8=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalSoarParser.g:380:4: kw= OSupport
                    {
                    kw=(Token)match(input,OSupport,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getOSupportKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:386:4: kw= ISupport
                    {
                    kw=(Token)match(input,ISupport,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getISupportKeyword_1_1());
                      			
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:392:4: kw= Chunk
                    {
                    kw=(Token)match(input,Chunk,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getChunkKeyword_1_2());
                      			
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:398:4: kw= Default
                    {
                    kw=(Token)match(input,Default,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getFlagsAccess().getDefaultKeyword_1_3());
                      			
                    }

                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:404:4: kw= Template
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


    // $ANTLR start "entryRuleStateImpCondition"
    // InternalSoarParser.g:414:1: entryRuleStateImpCondition returns [EObject current=null] : iv_ruleStateImpCondition= ruleStateImpCondition EOF ;
    public final EObject entryRuleStateImpCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStateImpCondition = null;


        try {
            // InternalSoarParser.g:414:58: (iv_ruleStateImpCondition= ruleStateImpCondition EOF )
            // InternalSoarParser.g:415:2: iv_ruleStateImpCondition= ruleStateImpCondition EOF
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
    // InternalSoarParser.g:421:1: ruleStateImpCondition returns [EObject current=null] : ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_id_4_0= ruleSymConstant ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis ) ;
    public final EObject ruleStateImpCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_id_4_0 = null;

        EObject lv_attrValueTest_5_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:427:2: ( ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_id_4_0= ruleSymConstant ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis ) )
            // InternalSoarParser.g:428:2: ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_id_4_0= ruleSymConstant ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis )
            {
            // InternalSoarParser.g:428:2: ( () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_id_4_0= ruleSymConstant ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis )
            // InternalSoarParser.g:429:3: () otherlv_1= LeftParenthesis ( ruleSTATE | ruleIMPASSE )? ( (lv_id_4_0= ruleSymConstant ) ) ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+ otherlv_6= RightParenthesis
            {
            // InternalSoarParser.g:429:3: ()
            // InternalSoarParser.g:430:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStateImpConditionAccess().getStateImpCondAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStateImpConditionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalSoarParser.g:440:3: ( ruleSTATE | ruleIMPASSE )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==State) ) {
                alt9=1;
            }
            else if ( (LA9_0==Impasse) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // InternalSoarParser.g:441:4: ruleSTATE
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStateImpConditionAccess().getSTATEParserRuleCall_2_0());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    ruleSTATE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:449:4: ruleIMPASSE
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStateImpConditionAccess().getIMPASSEParserRuleCall_2_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_12);
                    ruleIMPASSE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalSoarParser.g:457:3: ( (lv_id_4_0= ruleSymConstant ) )
            // InternalSoarParser.g:458:4: (lv_id_4_0= ruleSymConstant )
            {
            // InternalSoarParser.g:458:4: (lv_id_4_0= ruleSymConstant )
            // InternalSoarParser.g:459:5: lv_id_4_0= ruleSymConstant
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStateImpConditionAccess().getIdSymConstantParserRuleCall_3_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_13);
            lv_id_4_0=ruleSymConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStateImpConditionRule());
              					}
              					set(
              						current,
              						"id",
              						lv_id_4_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.SymConstant");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalSoarParser.g:476:3: ( (lv_attrValueTest_5_0= ruleAttrValueTest ) )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==CircumflexAccent) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSoarParser.g:477:4: (lv_attrValueTest_5_0= ruleAttrValueTest )
            	    {
            	    // InternalSoarParser.g:477:4: (lv_attrValueTest_5_0= ruleAttrValueTest )
            	    // InternalSoarParser.g:478:5: lv_attrValueTest_5_0= ruleAttrValueTest
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStateImpConditionAccess().getAttrValueTestAttrValueTestParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FollowSets000.FOLLOW_14);
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


    // $ANTLR start "entryRuleAttrValueTest"
    // InternalSoarParser.g:503:1: entryRuleAttrValueTest returns [EObject current=null] : iv_ruleAttrValueTest= ruleAttrValueTest EOF ;
    public final EObject entryRuleAttrValueTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttrValueTest = null;


        try {
            // InternalSoarParser.g:503:54: (iv_ruleAttrValueTest= ruleAttrValueTest EOF )
            // InternalSoarParser.g:504:2: iv_ruleAttrValueTest= ruleAttrValueTest EOF
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
    // InternalSoarParser.g:510:1: ruleAttrValueTest returns [EObject current=null] : ( () otherlv_1= CircumflexAccent ( (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_test_5_0= ruleConditionExpr ) ) ) ;
    public final EObject ruleAttrValueTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_attrTest_2_0=null;
        Token otherlv_3=null;
        Token lv_attrTest_4_0=null;
        EObject lv_test_5_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:516:2: ( ( () otherlv_1= CircumflexAccent ( (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_test_5_0= ruleConditionExpr ) ) ) )
            // InternalSoarParser.g:517:2: ( () otherlv_1= CircumflexAccent ( (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_test_5_0= ruleConditionExpr ) ) )
            {
            // InternalSoarParser.g:517:2: ( () otherlv_1= CircumflexAccent ( (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_test_5_0= ruleConditionExpr ) ) )
            // InternalSoarParser.g:518:3: () otherlv_1= CircumflexAccent ( (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING ) ) (otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) ) )* ( (lv_test_5_0= ruleConditionExpr ) )
            {
            // InternalSoarParser.g:518:3: ()
            // InternalSoarParser.g:519:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAttrValueTestAccess().getAttrValueTestAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttrValueTestAccess().getCircumflexAccentKeyword_1());
              		
            }
            // InternalSoarParser.g:529:3: ( (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING ) )
            // InternalSoarParser.g:530:4: (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING )
            {
            // InternalSoarParser.g:530:4: (lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING )
            // InternalSoarParser.g:531:5: lv_attrTest_2_0= RULE_SYM_CONSTANT_STRING
            {
            lv_attrTest_2_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_attrTest_2_0, grammarAccess.getAttrValueTestAccess().getAttrTestSYM_CONSTANT_STRINGTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAttrValueTestRule());
              					}
              					addWithLastConsumed(
              						current,
              						"attrTest",
              						lv_attrTest_2_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
              				
            }

            }


            }

            // InternalSoarParser.g:547:3: (otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==FullStop) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalSoarParser.g:548:4: otherlv_3= FullStop ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) )
            	    {
            	    otherlv_3=(Token)match(input,FullStop,FollowSets000.FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_3, grammarAccess.getAttrValueTestAccess().getFullStopKeyword_3_0());
            	      			
            	    }
            	    // InternalSoarParser.g:552:4: ( (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING ) )
            	    // InternalSoarParser.g:553:5: (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING )
            	    {
            	    // InternalSoarParser.g:553:5: (lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING )
            	    // InternalSoarParser.g:554:6: lv_attrTest_4_0= RULE_SYM_CONSTANT_STRING
            	    {
            	    lv_attrTest_4_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_attrTest_4_0, grammarAccess.getAttrValueTestAccess().getAttrTestSYM_CONSTANT_STRINGTerminalRuleCall_3_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getAttrValueTestRule());
            	      						}
            	      						addWithLastConsumed(
            	      							current,
            	      							"attrTest",
            	      							lv_attrTest_4_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // InternalSoarParser.g:571:3: ( (lv_test_5_0= ruleConditionExpr ) )
            // InternalSoarParser.g:572:4: (lv_test_5_0= ruleConditionExpr )
            {
            // InternalSoarParser.g:572:4: (lv_test_5_0= ruleConditionExpr )
            // InternalSoarParser.g:573:5: lv_test_5_0= ruleConditionExpr
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttrValueTestAccess().getTestConditionExprParserRuleCall_4_0());
              				
            }
            pushFollow(FollowSets000.FOLLOW_2);
            lv_test_5_0=ruleConditionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttrValueTestRule());
              					}
              					set(
              						current,
              						"test",
              						lv_test_5_0,
              						"com.collins.trustedmethods.matrics.soar.Soar.ConditionExpr");
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
    // $ANTLR end "ruleAttrValueTest"


    // $ANTLR start "entryRuleRelationalOp"
    // InternalSoarParser.g:594:1: entryRuleRelationalOp returns [String current=null] : iv_ruleRelationalOp= ruleRelationalOp EOF ;
    public final String entryRuleRelationalOp() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleRelationalOp = null;


        try {
            // InternalSoarParser.g:594:52: (iv_ruleRelationalOp= ruleRelationalOp EOF )
            // InternalSoarParser.g:595:2: iv_ruleRelationalOp= ruleRelationalOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalOpRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalOp=ruleRelationalOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalOp.getText(); 
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
    // $ANTLR end "entryRuleRelationalOp"


    // $ANTLR start "ruleRelationalOp"
    // InternalSoarParser.g:601:1: ruleRelationalOp returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LessThanSignGreaterThanSign | kw= LessThanSign | kw= GreaterThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= EqualsSignEqualsSign | kw= LessThanSignEqualsSignGreaterThanSign | kw= EqualsSign ) ;
    public final AntlrDatatypeRuleToken ruleRelationalOp() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:607:2: ( (kw= LessThanSignGreaterThanSign | kw= LessThanSign | kw= GreaterThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= EqualsSignEqualsSign | kw= LessThanSignEqualsSignGreaterThanSign | kw= EqualsSign ) )
            // InternalSoarParser.g:608:2: (kw= LessThanSignGreaterThanSign | kw= LessThanSign | kw= GreaterThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= EqualsSignEqualsSign | kw= LessThanSignEqualsSignGreaterThanSign | kw= EqualsSign )
            {
            // InternalSoarParser.g:608:2: (kw= LessThanSignGreaterThanSign | kw= LessThanSign | kw= GreaterThanSign | kw= LessThanSignEqualsSign | kw= GreaterThanSignEqualsSign | kw= EqualsSignEqualsSign | kw= LessThanSignEqualsSignGreaterThanSign | kw= EqualsSign )
            int alt12=8;
            switch ( input.LA(1) ) {
            case LessThanSignGreaterThanSign:
                {
                alt12=1;
                }
                break;
            case LessThanSign:
                {
                alt12=2;
                }
                break;
            case GreaterThanSign:
                {
                alt12=3;
                }
                break;
            case LessThanSignEqualsSign:
                {
                alt12=4;
                }
                break;
            case GreaterThanSignEqualsSign:
                {
                alt12=5;
                }
                break;
            case EqualsSignEqualsSign:
                {
                alt12=6;
                }
                break;
            case LessThanSignEqualsSignGreaterThanSign:
                {
                alt12=7;
                }
                break;
            case EqualsSign:
                {
                alt12=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // InternalSoarParser.g:609:3: kw= LessThanSignGreaterThanSign
                    {
                    kw=(Token)match(input,LessThanSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:615:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:621:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:627:3: kw= LessThanSignEqualsSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:633:3: kw= GreaterThanSignEqualsSign
                    {
                    kw=(Token)match(input,GreaterThanSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getGreaterThanSignEqualsSignKeyword_4());
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalSoarParser.g:639:3: kw= EqualsSignEqualsSign
                    {
                    kw=(Token)match(input,EqualsSignEqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignEqualsSignKeyword_5());
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalSoarParser.g:645:3: kw= LessThanSignEqualsSignGreaterThanSign
                    {
                    kw=(Token)match(input,LessThanSignEqualsSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getLessThanSignEqualsSignGreaterThanSignKeyword_6());
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalSoarParser.g:651:3: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getRelationalOpAccess().getEqualsSignKeyword_7());
                      		
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
    // $ANTLR end "ruleRelationalOp"


    // $ANTLR start "entryRuleConditionExpr"
    // InternalSoarParser.g:660:1: entryRuleConditionExpr returns [EObject current=null] : iv_ruleConditionExpr= ruleConditionExpr EOF ;
    public final EObject entryRuleConditionExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionExpr = null;


        try {
            // InternalSoarParser.g:660:54: (iv_ruleConditionExpr= ruleConditionExpr EOF )
            // InternalSoarParser.g:661:2: iv_ruleConditionExpr= ruleConditionExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConditionExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleConditionExpr=ruleConditionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConditionExpr; 
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
    // $ANTLR end "entryRuleConditionExpr"


    // $ANTLR start "ruleConditionExpr"
    // InternalSoarParser.g:667:1: ruleConditionExpr returns [EObject current=null] : this_PlusExpr_0= rulePlusExpr ;
    public final EObject ruleConditionExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PlusExpr_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:673:2: (this_PlusExpr_0= rulePlusExpr )
            // InternalSoarParser.g:674:2: this_PlusExpr_0= rulePlusExpr
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getConditionExprAccess().getPlusExprParserRuleCall());
              	
            }
            pushFollow(FollowSets000.FOLLOW_2);
            this_PlusExpr_0=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_PlusExpr_0;
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
    // $ANTLR end "ruleConditionExpr"


    // $ANTLR start "entryRulePlusExpr"
    // InternalSoarParser.g:685:1: entryRulePlusExpr returns [EObject current=null] : iv_rulePlusExpr= rulePlusExpr EOF ;
    public final EObject entryRulePlusExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePlusExpr = null;


        try {
            // InternalSoarParser.g:685:49: (iv_rulePlusExpr= rulePlusExpr EOF )
            // InternalSoarParser.g:686:2: iv_rulePlusExpr= rulePlusExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPlusExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePlusExpr=rulePlusExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePlusExpr; 
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
    // $ANTLR end "entryRulePlusExpr"


    // $ANTLR start "rulePlusExpr"
    // InternalSoarParser.g:692:1: rulePlusExpr returns [EObject current=null] : (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )* ) ;
    public final EObject rulePlusExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_RelationalExpr_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:698:2: ( (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )* ) )
            // InternalSoarParser.g:699:2: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )* )
            {
            // InternalSoarParser.g:699:2: (this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )* )
            // InternalSoarParser.g:700:3: this_RelationalExpr_0= ruleRelationalExpr ( ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getPlusExprAccess().getRelationalExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_16);
            this_RelationalExpr_0=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSoarParser.g:708:3: ( ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==PlusSign) && (synpred1_InternalSoarParser())) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalSoarParser.g:709:4: ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) ) ( (lv_right_3_0= ruleRelationalExpr ) )
            	    {
            	    // InternalSoarParser.g:709:4: ( ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) ) )
            	    // InternalSoarParser.g:710:5: ( ( () ( ( PlusSign ) ) ) )=> ( () ( (lv_op_2_0= PlusSign ) ) )
            	    {
            	    // InternalSoarParser.g:720:5: ( () ( (lv_op_2_0= PlusSign ) ) )
            	    // InternalSoarParser.g:721:6: () ( (lv_op_2_0= PlusSign ) )
            	    {
            	    // InternalSoarParser.g:721:6: ()
            	    // InternalSoarParser.g:722:7: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      							current = forceCreateModelElementAndSet(
            	      								grammarAccess.getPlusExprAccess().getBinaryExprLeftAction_1_0_0_0(),
            	      								current);
            	      						
            	    }

            	    }

            	    // InternalSoarParser.g:728:6: ( (lv_op_2_0= PlusSign ) )
            	    // InternalSoarParser.g:729:7: (lv_op_2_0= PlusSign )
            	    {
            	    // InternalSoarParser.g:729:7: (lv_op_2_0= PlusSign )
            	    // InternalSoarParser.g:730:8: lv_op_2_0= PlusSign
            	    {
            	    lv_op_2_0=(Token)match(input,PlusSign,FollowSets000.FOLLOW_15); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      								newLeafNode(lv_op_2_0, grammarAccess.getPlusExprAccess().getOpPlusSignKeyword_1_0_0_1_0());
            	      							
            	    }
            	    if ( state.backtracking==0 ) {

            	      								if (current==null) {
            	      									current = createModelElement(grammarAccess.getPlusExprRule());
            	      								}
            	      								setWithLastConsumed(current, "op", lv_op_2_0, "+");
            	      							
            	    }

            	    }


            	    }


            	    }


            	    }

            	    // InternalSoarParser.g:744:4: ( (lv_right_3_0= ruleRelationalExpr ) )
            	    // InternalSoarParser.g:745:5: (lv_right_3_0= ruleRelationalExpr )
            	    {
            	    // InternalSoarParser.g:745:5: (lv_right_3_0= ruleRelationalExpr )
            	    // InternalSoarParser.g:746:6: lv_right_3_0= ruleRelationalExpr
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getPlusExprAccess().getRightRelationalExprParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FollowSets000.FOLLOW_16);
            	    lv_right_3_0=ruleRelationalExpr();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getPlusExprRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"com.collins.trustedmethods.matrics.soar.Soar.RelationalExpr");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // $ANTLR end "rulePlusExpr"


    // $ANTLR start "entryRuleRelationalExpr"
    // InternalSoarParser.g:768:1: entryRuleRelationalExpr returns [EObject current=null] : iv_ruleRelationalExpr= ruleRelationalExpr EOF ;
    public final EObject entryRuleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalExpr = null;


        try {
            // InternalSoarParser.g:768:55: (iv_ruleRelationalExpr= ruleRelationalExpr EOF )
            // InternalSoarParser.g:769:2: iv_ruleRelationalExpr= ruleRelationalExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleRelationalExpr=ruleRelationalExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalExpr; 
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
    // $ANTLR end "entryRuleRelationalExpr"


    // $ANTLR start "ruleRelationalExpr"
    // InternalSoarParser.g:775:1: ruleRelationalExpr returns [EObject current=null] : (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )? ) ;
    public final EObject ruleRelationalExpr() throws RecognitionException {
        EObject current = null;

        EObject this_PrefixExpr_0 = null;

        AntlrDatatypeRuleToken lv_op_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:781:2: ( (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )? ) )
            // InternalSoarParser.g:782:2: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )? )
            {
            // InternalSoarParser.g:782:2: (this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )? )
            // InternalSoarParser.g:783:3: this_PrefixExpr_0= rulePrefixExpr ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )?
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getRelationalExprAccess().getPrefixExprParserRuleCall_0());
              		
            }
            pushFollow(FollowSets000.FOLLOW_17);
            this_PrefixExpr_0=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrefixExpr_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalSoarParser.g:791:3: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )?
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalSoarParser.g:792:4: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) )
                    {
                    // InternalSoarParser.g:792:4: ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) )
                    // InternalSoarParser.g:793:5: ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    {
                    // InternalSoarParser.g:803:5: ( () ( (lv_op_2_0= ruleRelationalOp ) ) )
                    // InternalSoarParser.g:804:6: () ( (lv_op_2_0= ruleRelationalOp ) )
                    {
                    // InternalSoarParser.g:804:6: ()
                    // InternalSoarParser.g:805:7: 
                    {
                    if ( state.backtracking==0 ) {

                      							current = forceCreateModelElementAndSet(
                      								grammarAccess.getRelationalExprAccess().getBinaryExprLeftAction_1_0_0_0(),
                      								current);
                      						
                    }

                    }

                    // InternalSoarParser.g:811:6: ( (lv_op_2_0= ruleRelationalOp ) )
                    // InternalSoarParser.g:812:7: (lv_op_2_0= ruleRelationalOp )
                    {
                    // InternalSoarParser.g:812:7: (lv_op_2_0= ruleRelationalOp )
                    // InternalSoarParser.g:813:8: lv_op_2_0= ruleRelationalOp
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getRelationalExprAccess().getOpRelationalOpParserRuleCall_1_0_0_1_0());
                      							
                    }
                    pushFollow(FollowSets000.FOLLOW_15);
                    lv_op_2_0=ruleRelationalOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      								}
                      								set(
                      									current,
                      									"op",
                      									lv_op_2_0,
                      									"com.collins.trustedmethods.matrics.soar.Soar.RelationalOp");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }


                    }


                    }

                    // InternalSoarParser.g:832:4: ( (lv_right_3_0= rulePrefixExpr ) )
                    // InternalSoarParser.g:833:5: (lv_right_3_0= rulePrefixExpr )
                    {
                    // InternalSoarParser.g:833:5: (lv_right_3_0= rulePrefixExpr )
                    // InternalSoarParser.g:834:6: lv_right_3_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalExprAccess().getRightPrefixExprParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_right_3_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalExprRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_3_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.PrefixExpr");
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
    // $ANTLR end "ruleRelationalExpr"


    // $ANTLR start "entryRulePrefixExpr"
    // InternalSoarParser.g:856:1: entryRulePrefixExpr returns [EObject current=null] : iv_rulePrefixExpr= rulePrefixExpr EOF ;
    public final EObject entryRulePrefixExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixExpr = null;


        try {
            // InternalSoarParser.g:856:51: (iv_rulePrefixExpr= rulePrefixExpr EOF )
            // InternalSoarParser.g:857:2: iv_rulePrefixExpr= rulePrefixExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrefixExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_rulePrefixExpr=rulePrefixExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrefixExpr; 
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
    // $ANTLR end "entryRulePrefixExpr"


    // $ANTLR start "rulePrefixExpr"
    // InternalSoarParser.g:863:1: rulePrefixExpr returns [EObject current=null] : ( ( () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AtomicConditionExpr_3= ruleAtomicConditionExpr ) ;
    public final EObject rulePrefixExpr() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_0=null;
        EObject lv_expr_2_0 = null;

        EObject this_AtomicConditionExpr_3 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:869:2: ( ( ( () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AtomicConditionExpr_3= ruleAtomicConditionExpr ) )
            // InternalSoarParser.g:870:2: ( ( () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AtomicConditionExpr_3= ruleAtomicConditionExpr )
            {
            // InternalSoarParser.g:870:2: ( ( () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) ) | this_AtomicConditionExpr_3= ruleAtomicConditionExpr )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==HyphenMinus) ) {
                alt15=1;
            }
            else if ( (LA15_0==LessThanSignLessThanSign||LA15_0==LessThanSign||LA15_0==LeftSquareBracket||LA15_0==LeftCurlyBracket||LA15_0==RULE_SYM_CONSTANT_STRING) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // InternalSoarParser.g:871:3: ( () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    {
                    // InternalSoarParser.g:871:3: ( () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) ) )
                    // InternalSoarParser.g:872:4: () ( (lv_op_1_0= HyphenMinus ) ) ( (lv_expr_2_0= rulePrefixExpr ) )
                    {
                    // InternalSoarParser.g:872:4: ()
                    // InternalSoarParser.g:873:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrefixExprAccess().getUnaryExprAction_0_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:879:4: ( (lv_op_1_0= HyphenMinus ) )
                    // InternalSoarParser.g:880:5: (lv_op_1_0= HyphenMinus )
                    {
                    // InternalSoarParser.g:880:5: (lv_op_1_0= HyphenMinus )
                    // InternalSoarParser.g:881:6: lv_op_1_0= HyphenMinus
                    {
                    lv_op_1_0=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_0, grammarAccess.getPrefixExprAccess().getOpHyphenMinusKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrefixExprRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_1_0, "-");
                      					
                    }

                    }


                    }

                    // InternalSoarParser.g:893:4: ( (lv_expr_2_0= rulePrefixExpr ) )
                    // InternalSoarParser.g:894:5: (lv_expr_2_0= rulePrefixExpr )
                    {
                    // InternalSoarParser.g:894:5: (lv_expr_2_0= rulePrefixExpr )
                    // InternalSoarParser.g:895:6: lv_expr_2_0= rulePrefixExpr
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrefixExprAccess().getExprPrefixExprParserRuleCall_0_2_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_expr_2_0=rulePrefixExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrefixExprRule());
                      						}
                      						set(
                      							current,
                      							"expr",
                      							lv_expr_2_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.PrefixExpr");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:914:3: this_AtomicConditionExpr_3= ruleAtomicConditionExpr
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrefixExprAccess().getAtomicConditionExprParserRuleCall_1());
                      		
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    this_AtomicConditionExpr_3=ruleAtomicConditionExpr();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AtomicConditionExpr_3;
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
    // $ANTLR end "rulePrefixExpr"


    // $ANTLR start "entryRuleAtomicConditionExpr"
    // InternalSoarParser.g:926:1: entryRuleAtomicConditionExpr returns [EObject current=null] : iv_ruleAtomicConditionExpr= ruleAtomicConditionExpr EOF ;
    public final EObject entryRuleAtomicConditionExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicConditionExpr = null;


        try {
            // InternalSoarParser.g:926:60: (iv_ruleAtomicConditionExpr= ruleAtomicConditionExpr EOF )
            // InternalSoarParser.g:927:2: iv_ruleAtomicConditionExpr= ruleAtomicConditionExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicConditionExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleAtomicConditionExpr=ruleAtomicConditionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicConditionExpr; 
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
    // $ANTLR end "entryRuleAtomicConditionExpr"


    // $ANTLR start "ruleAtomicConditionExpr"
    // InternalSoarParser.g:933:1: ruleAtomicConditionExpr returns [EObject current=null] : ( ( () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket ) | ( () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket ) | ( () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign ) | ( () ( (lv_val_13_0= ruleSymConstant ) ) ) | ( () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) ) ) ) ;
    public final EObject ruleAtomicConditionExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_val_15_0=null;
        EObject lv_tests_2_0 = null;

        EObject lv_tests_6_0 = null;

        EObject lv_consts_10_0 = null;

        AntlrDatatypeRuleToken lv_val_13_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:939:2: ( ( ( () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket ) | ( () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket ) | ( () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign ) | ( () ( (lv_val_13_0= ruleSymConstant ) ) ) | ( () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) ) ) ) )
            // InternalSoarParser.g:940:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket ) | ( () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket ) | ( () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign ) | ( () ( (lv_val_13_0= ruleSymConstant ) ) ) | ( () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) ) ) )
            {
            // InternalSoarParser.g:940:2: ( ( () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket ) | ( () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket ) | ( () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign ) | ( () ( (lv_val_13_0= ruleSymConstant ) ) ) | ( () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) ) ) )
            int alt19=5;
            switch ( input.LA(1) ) {
            case LeftCurlyBracket:
                {
                alt19=1;
                }
                break;
            case LeftSquareBracket:
                {
                alt19=2;
                }
                break;
            case LessThanSignLessThanSign:
                {
                alt19=3;
                }
                break;
            case LessThanSign:
                {
                alt19=4;
                }
                break;
            case RULE_SYM_CONSTANT_STRING:
                {
                alt19=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalSoarParser.g:941:3: ( () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket )
                    {
                    // InternalSoarParser.g:941:3: ( () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket )
                    // InternalSoarParser.g:942:4: () otherlv_1= LeftCurlyBracket ( (lv_tests_2_0= ruleConditionExpr ) )* otherlv_3= RightCurlyBracket
                    {
                    // InternalSoarParser.g:942:4: ()
                    // InternalSoarParser.g:943:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicConditionExprAccess().getConjunctTestExprAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,LeftCurlyBracket,FollowSets000.FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAtomicConditionExprAccess().getLeftCurlyBracketKeyword_0_1());
                      			
                    }
                    // InternalSoarParser.g:953:4: ( (lv_tests_2_0= ruleConditionExpr ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==LessThanSignLessThanSign||LA16_0==HyphenMinus||LA16_0==LessThanSign||LA16_0==LeftSquareBracket||LA16_0==LeftCurlyBracket||LA16_0==RULE_SYM_CONSTANT_STRING) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalSoarParser.g:954:5: (lv_tests_2_0= ruleConditionExpr )
                    	    {
                    	    // InternalSoarParser.g:954:5: (lv_tests_2_0= ruleConditionExpr )
                    	    // InternalSoarParser.g:955:6: lv_tests_2_0= ruleConditionExpr
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getAtomicConditionExprAccess().getTestsConditionExprParserRuleCall_0_2_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_18);
                    	    lv_tests_2_0=ruleConditionExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getAtomicConditionExprRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"tests",
                    	      							lv_tests_2_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.ConditionExpr");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_3=(Token)match(input,RightCurlyBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAtomicConditionExprAccess().getRightCurlyBracketKeyword_0_3());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:978:3: ( () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket )
                    {
                    // InternalSoarParser.g:978:3: ( () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket )
                    // InternalSoarParser.g:979:4: () otherlv_5= LeftSquareBracket ( (lv_tests_6_0= ruleConditionExpr ) )+ otherlv_7= RightSquareBracket
                    {
                    // InternalSoarParser.g:979:4: ()
                    // InternalSoarParser.g:980:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicConditionExprAccess().getMultiValTestExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_5=(Token)match(input,LeftSquareBracket,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getAtomicConditionExprAccess().getLeftSquareBracketKeyword_1_1());
                      			
                    }
                    // InternalSoarParser.g:990:4: ( (lv_tests_6_0= ruleConditionExpr ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==LessThanSignLessThanSign||LA17_0==HyphenMinus||LA17_0==LessThanSign||LA17_0==LeftSquareBracket||LA17_0==LeftCurlyBracket||LA17_0==RULE_SYM_CONSTANT_STRING) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalSoarParser.g:991:5: (lv_tests_6_0= ruleConditionExpr )
                    	    {
                    	    // InternalSoarParser.g:991:5: (lv_tests_6_0= ruleConditionExpr )
                    	    // InternalSoarParser.g:992:6: lv_tests_6_0= ruleConditionExpr
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getAtomicConditionExprAccess().getTestsConditionExprParserRuleCall_1_2_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_19);
                    	    lv_tests_6_0=ruleConditionExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getAtomicConditionExprRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"tests",
                    	      							lv_tests_6_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.ConditionExpr");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);

                    otherlv_7=(Token)match(input,RightSquareBracket,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getAtomicConditionExprAccess().getRightSquareBracketKeyword_1_3());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1015:3: ( () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign )
                    {
                    // InternalSoarParser.g:1015:3: ( () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign )
                    // InternalSoarParser.g:1016:4: () otherlv_9= LessThanSignLessThanSign ( (lv_consts_10_0= ruleConditionExpr ) )+ otherlv_11= GreaterThanSignGreaterThanSign
                    {
                    // InternalSoarParser.g:1016:4: ()
                    // InternalSoarParser.g:1017:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicConditionExprAccess().getDisjunctTestExprAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_9=(Token)match(input,LessThanSignLessThanSign,FollowSets000.FOLLOW_15); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getAtomicConditionExprAccess().getLessThanSignLessThanSignKeyword_2_1());
                      			
                    }
                    // InternalSoarParser.g:1027:4: ( (lv_consts_10_0= ruleConditionExpr ) )+
                    int cnt18=0;
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==LessThanSignLessThanSign||LA18_0==HyphenMinus||LA18_0==LessThanSign||LA18_0==LeftSquareBracket||LA18_0==LeftCurlyBracket||LA18_0==RULE_SYM_CONSTANT_STRING) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalSoarParser.g:1028:5: (lv_consts_10_0= ruleConditionExpr )
                    	    {
                    	    // InternalSoarParser.g:1028:5: (lv_consts_10_0= ruleConditionExpr )
                    	    // InternalSoarParser.g:1029:6: lv_consts_10_0= ruleConditionExpr
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getAtomicConditionExprAccess().getConstsConditionExprParserRuleCall_2_2_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_20);
                    	    lv_consts_10_0=ruleConditionExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getAtomicConditionExprRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"consts",
                    	      							lv_consts_10_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.ConditionExpr");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt18 >= 1 ) break loop18;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(18, input);
                                throw eee;
                        }
                        cnt18++;
                    } while (true);

                    otherlv_11=(Token)match(input,GreaterThanSignGreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getAtomicConditionExprAccess().getGreaterThanSignGreaterThanSignKeyword_2_3());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:1052:3: ( () ( (lv_val_13_0= ruleSymConstant ) ) )
                    {
                    // InternalSoarParser.g:1052:3: ( () ( (lv_val_13_0= ruleSymConstant ) ) )
                    // InternalSoarParser.g:1053:4: () ( (lv_val_13_0= ruleSymConstant ) )
                    {
                    // InternalSoarParser.g:1053:4: ()
                    // InternalSoarParser.g:1054:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicConditionExprAccess().getSymConstExprAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1060:4: ( (lv_val_13_0= ruleSymConstant ) )
                    // InternalSoarParser.g:1061:5: (lv_val_13_0= ruleSymConstant )
                    {
                    // InternalSoarParser.g:1061:5: (lv_val_13_0= ruleSymConstant )
                    // InternalSoarParser.g:1062:6: lv_val_13_0= ruleSymConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicConditionExprAccess().getValSymConstantParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_13_0=ruleSymConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicConditionExprRule());
                      						}
                      						set(
                      							current,
                      							"val",
                      							lv_val_13_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SymConstant");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:1081:3: ( () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) ) )
                    {
                    // InternalSoarParser.g:1081:3: ( () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) ) )
                    // InternalSoarParser.g:1082:4: () ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) )
                    {
                    // InternalSoarParser.g:1082:4: ()
                    // InternalSoarParser.g:1083:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicConditionExprAccess().getConstStringExprAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1089:4: ( (lv_val_15_0= RULE_SYM_CONSTANT_STRING ) )
                    // InternalSoarParser.g:1090:5: (lv_val_15_0= RULE_SYM_CONSTANT_STRING )
                    {
                    // InternalSoarParser.g:1090:5: (lv_val_15_0= RULE_SYM_CONSTANT_STRING )
                    // InternalSoarParser.g:1091:6: lv_val_15_0= RULE_SYM_CONSTANT_STRING
                    {
                    lv_val_15_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_val_15_0, grammarAccess.getAtomicConditionExprAccess().getValSYM_CONSTANT_STRINGTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicConditionExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"val",
                      							lv_val_15_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
                      					
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
    // $ANTLR end "ruleAtomicConditionExpr"


    // $ANTLR start "entryRuleActionSideExpr"
    // InternalSoarParser.g:1112:1: entryRuleActionSideExpr returns [EObject current=null] : iv_ruleActionSideExpr= ruleActionSideExpr EOF ;
    public final EObject entryRuleActionSideExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionSideExpr = null;


        try {
            // InternalSoarParser.g:1112:55: (iv_ruleActionSideExpr= ruleActionSideExpr EOF )
            // InternalSoarParser.g:1113:2: iv_ruleActionSideExpr= ruleActionSideExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionSideExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionSideExpr=ruleActionSideExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionSideExpr; 
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
    // $ANTLR end "entryRuleActionSideExpr"


    // $ANTLR start "ruleActionSideExpr"
    // InternalSoarParser.g:1119:1: ruleActionSideExpr returns [EObject current=null] : ( (otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis ) | (otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis ) ) ;
    public final EObject ruleActionSideExpr() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_makeId_3_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_id_1_0 = null;

        EObject lv_attrValMakes_4_0 = null;

        EObject lv_text_8_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1125:2: ( ( (otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis ) | (otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis ) ) )
            // InternalSoarParser.g:1126:2: ( (otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis ) | (otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis ) )
            {
            // InternalSoarParser.g:1126:2: ( (otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis ) | (otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LeftParenthesis) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==LessThanSign) ) {
                    alt22=1;
                }
                else if ( (LA22_1==Write) ) {
                    alt22=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalSoarParser.g:1127:3: (otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis )
                    {
                    // InternalSoarParser.g:1127:3: (otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis )
                    // InternalSoarParser.g:1128:4: otherlv_0= LeftParenthesis ( (lv_id_1_0= ruleSymConstant ) ) otherlv_2= CircumflexAccent ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) ) ( (lv_attrValMakes_4_0= ruleActionExpr ) )+ otherlv_5= RightParenthesis
                    {
                    otherlv_0=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_12); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getActionSideExprAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    // InternalSoarParser.g:1132:4: ( (lv_id_1_0= ruleSymConstant ) )
                    // InternalSoarParser.g:1133:5: (lv_id_1_0= ruleSymConstant )
                    {
                    // InternalSoarParser.g:1133:5: (lv_id_1_0= ruleSymConstant )
                    // InternalSoarParser.g:1134:6: lv_id_1_0= ruleSymConstant
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getActionSideExprAccess().getIdSymConstantParserRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FollowSets000.FOLLOW_13);
                    lv_id_1_0=ruleSymConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getActionSideExprRule());
                      						}
                      						set(
                      							current,
                      							"id",
                      							lv_id_1_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SymConstant");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,CircumflexAccent,FollowSets000.FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getActionSideExprAccess().getCircumflexAccentKeyword_0_2());
                      			
                    }
                    // InternalSoarParser.g:1155:4: ( (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING ) )
                    // InternalSoarParser.g:1156:5: (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING )
                    {
                    // InternalSoarParser.g:1156:5: (lv_makeId_3_0= RULE_SYM_CONSTANT_STRING )
                    // InternalSoarParser.g:1157:6: lv_makeId_3_0= RULE_SYM_CONSTANT_STRING
                    {
                    lv_makeId_3_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_makeId_3_0, grammarAccess.getActionSideExprAccess().getMakeIdSYM_CONSTANT_STRINGTerminalRuleCall_0_3_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getActionSideExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"makeId",
                      							lv_makeId_3_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
                      					
                    }

                    }


                    }

                    // InternalSoarParser.g:1173:4: ( (lv_attrValMakes_4_0= ruleActionExpr ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==Crlf||(LA20_0>=ExclamationMark && LA20_0<=LeftParenthesis)||(LA20_0>=PlusSign && LA20_0<=HyphenMinus)||(LA20_0>=LessThanSign && LA20_0<=CommercialAt)||(LA20_0>=Tilde && LA20_0<=RULE_SYM_CONSTANT_STRING)||LA20_0==RULE_PIPE_STRING) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalSoarParser.g:1174:5: (lv_attrValMakes_4_0= ruleActionExpr )
                    	    {
                    	    // InternalSoarParser.g:1174:5: (lv_attrValMakes_4_0= ruleActionExpr )
                    	    // InternalSoarParser.g:1175:6: lv_attrValMakes_4_0= ruleActionExpr
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getActionSideExprAccess().getAttrValMakesActionExprParserRuleCall_0_4_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_attrValMakes_4_0=ruleActionExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getActionSideExprRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"attrValMakes",
                    	      							lv_attrValMakes_4_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.ActionExpr");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_5=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getActionSideExprAccess().getRightParenthesisKeyword_0_5());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1198:3: (otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis )
                    {
                    // InternalSoarParser.g:1198:3: (otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis )
                    // InternalSoarParser.g:1199:4: otherlv_6= LeftParenthesis otherlv_7= Write ( (lv_text_8_0= ruleActionExpr ) )+ otherlv_9= RightParenthesis
                    {
                    otherlv_6=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_23); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getActionSideExprAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    otherlv_7=(Token)match(input,Write,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getActionSideExprAccess().getWriteKeyword_1_1());
                      			
                    }
                    // InternalSoarParser.g:1207:4: ( (lv_text_8_0= ruleActionExpr ) )+
                    int cnt21=0;
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==Crlf||(LA21_0>=ExclamationMark && LA21_0<=LeftParenthesis)||(LA21_0>=PlusSign && LA21_0<=HyphenMinus)||(LA21_0>=LessThanSign && LA21_0<=CommercialAt)||(LA21_0>=Tilde && LA21_0<=RULE_SYM_CONSTANT_STRING)||LA21_0==RULE_PIPE_STRING) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalSoarParser.g:1208:5: (lv_text_8_0= ruleActionExpr )
                    	    {
                    	    // InternalSoarParser.g:1208:5: (lv_text_8_0= ruleActionExpr )
                    	    // InternalSoarParser.g:1209:6: lv_text_8_0= ruleActionExpr
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getActionSideExprAccess().getTextActionExprParserRuleCall_1_2_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_text_8_0=ruleActionExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getActionSideExprRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"text",
                    	      							lv_text_8_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.ActionExpr");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt21 >= 1 ) break loop21;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(21, input);
                                throw eee;
                        }
                        cnt21++;
                    } while (true);

                    otherlv_9=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getActionSideExprAccess().getRightParenthesisKeyword_1_3());
                      			
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
    // $ANTLR end "ruleActionSideExpr"


    // $ANTLR start "entryRuleUnaryPref"
    // InternalSoarParser.g:1235:1: entryRuleUnaryPref returns [String current=null] : iv_ruleUnaryPref= ruleUnaryPref EOF ;
    public final String entryRuleUnaryPref() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryPref = null;


        try {
            // InternalSoarParser.g:1235:49: (iv_ruleUnaryPref= ruleUnaryPref EOF )
            // InternalSoarParser.g:1236:2: iv_ruleUnaryPref= ruleUnaryPref EOF
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
    // InternalSoarParser.g:1242:1: ruleUnaryPref returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt ) ;
    public final AntlrDatatypeRuleToken ruleUnaryPref() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:1248:2: ( (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt ) )
            // InternalSoarParser.g:1249:2: (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt )
            {
            // InternalSoarParser.g:1249:2: (kw= PlusSign | kw= HyphenMinus | kw= ExclamationMark | kw= Tilde | kw= CommercialAt )
            int alt23=5;
            switch ( input.LA(1) ) {
            case PlusSign:
                {
                alt23=1;
                }
                break;
            case HyphenMinus:
                {
                alt23=2;
                }
                break;
            case ExclamationMark:
                {
                alt23=3;
                }
                break;
            case Tilde:
                {
                alt23=4;
                }
                break;
            case CommercialAt:
                {
                alt23=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalSoarParser.g:1250:3: kw= PlusSign
                    {
                    kw=(Token)match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getPlusSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1256:3: kw= HyphenMinus
                    {
                    kw=(Token)match(input,HyphenMinus,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getHyphenMinusKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1262:3: kw= ExclamationMark
                    {
                    kw=(Token)match(input,ExclamationMark,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getExclamationMarkKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:1268:3: kw= Tilde
                    {
                    kw=(Token)match(input,Tilde,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryPrefAccess().getTildeKeyword_3());
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:1274:3: kw= CommercialAt
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
    // InternalSoarParser.g:1283:1: entryRuleUnaryOrBinaryPref returns [String current=null] : iv_ruleUnaryOrBinaryPref= ruleUnaryOrBinaryPref EOF ;
    public final String entryRuleUnaryOrBinaryPref() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnaryOrBinaryPref = null;


        try {
            // InternalSoarParser.g:1283:57: (iv_ruleUnaryOrBinaryPref= ruleUnaryOrBinaryPref EOF )
            // InternalSoarParser.g:1284:2: iv_ruleUnaryOrBinaryPref= ruleUnaryOrBinaryPref EOF
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
    // InternalSoarParser.g:1290:1: ruleUnaryOrBinaryPref returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand ) ;
    public final AntlrDatatypeRuleToken ruleUnaryOrBinaryPref() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:1296:2: ( (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand ) )
            // InternalSoarParser.g:1297:2: (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand )
            {
            // InternalSoarParser.g:1297:2: (kw= GreaterThanSign | kw= EqualsSign | kw= LessThanSign | kw= Ampersand )
            int alt24=4;
            switch ( input.LA(1) ) {
            case GreaterThanSign:
                {
                alt24=1;
                }
                break;
            case EqualsSign:
                {
                alt24=2;
                }
                break;
            case LessThanSign:
                {
                alt24=3;
                }
                break;
            case Ampersand:
                {
                alt24=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // InternalSoarParser.g:1298:3: kw= GreaterThanSign
                    {
                    kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getGreaterThanSignKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1304:3: kw= EqualsSign
                    {
                    kw=(Token)match(input,EqualsSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getEqualsSignKeyword_1());
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1310:3: kw= LessThanSign
                    {
                    kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getUnaryOrBinaryPrefAccess().getLessThanSignKeyword_2());
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:1316:3: kw= Ampersand
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


    // $ANTLR start "entryRuleActionExpr"
    // InternalSoarParser.g:1325:1: entryRuleActionExpr returns [EObject current=null] : iv_ruleActionExpr= ruleActionExpr EOF ;
    public final EObject entryRuleActionExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionExpr = null;


        try {
            // InternalSoarParser.g:1325:51: (iv_ruleActionExpr= ruleActionExpr EOF )
            // InternalSoarParser.g:1326:2: iv_ruleActionExpr= ruleActionExpr EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getActionExprRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleActionExpr=ruleActionExpr();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleActionExpr; 
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
    // $ANTLR end "entryRuleActionExpr"


    // $ANTLR start "ruleActionExpr"
    // InternalSoarParser.g:1332:1: ruleActionExpr returns [EObject current=null] : ( ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) ) | ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) ) | ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) ) | ( () otherlv_8= Crlf ) | ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) ) | ( () otherlv_12= Comma ) | ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis ) ) ;
    public final EObject ruleActionExpr() throws RecognitionException {
        EObject current = null;

        Token lv_val_3_0=null;
        Token otherlv_8=null;
        Token lv_expr_10_0=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_val_1_0 = null;

        EObject lv_exprs_15_0 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1338:2: ( ( ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) ) | ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) ) | ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) ) | ( () otherlv_8= Crlf ) | ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) ) | ( () otherlv_12= Comma ) | ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis ) ) )
            // InternalSoarParser.g:1339:2: ( ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) ) | ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) ) | ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) ) | ( () otherlv_8= Crlf ) | ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) ) | ( () otherlv_12= Comma ) | ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis ) )
            {
            // InternalSoarParser.g:1339:2: ( ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) ) | ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) ) | ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) ) | ( () otherlv_8= Crlf ) | ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) ) | ( () otherlv_12= Comma ) | ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis ) )
            int alt27=7;
            alt27 = dfa27.predict(input);
            switch (alt27) {
                case 1 :
                    // InternalSoarParser.g:1340:3: ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) )
                    {
                    // InternalSoarParser.g:1340:3: ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) )
                    // InternalSoarParser.g:1341:4: ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) )
                    {
                    // InternalSoarParser.g:1351:4: ( () ( (lv_val_1_0= ruleSymConstant ) ) )
                    // InternalSoarParser.g:1352:5: () ( (lv_val_1_0= ruleSymConstant ) )
                    {
                    // InternalSoarParser.g:1352:5: ()
                    // InternalSoarParser.g:1353:6: 
                    {
                    if ( state.backtracking==0 ) {

                      						current = forceCreateModelElement(
                      							grammarAccess.getActionExprAccess().getSymConstExprAction_0_0_0(),
                      							current);
                      					
                    }

                    }

                    // InternalSoarParser.g:1359:5: ( (lv_val_1_0= ruleSymConstant ) )
                    // InternalSoarParser.g:1360:6: (lv_val_1_0= ruleSymConstant )
                    {
                    // InternalSoarParser.g:1360:6: (lv_val_1_0= ruleSymConstant )
                    // InternalSoarParser.g:1361:7: lv_val_1_0= ruleSymConstant
                    {
                    if ( state.backtracking==0 ) {

                      							newCompositeNode(grammarAccess.getActionExprAccess().getValSymConstantParserRuleCall_0_0_1_0());
                      						
                    }
                    pushFollow(FollowSets000.FOLLOW_2);
                    lv_val_1_0=ruleSymConstant();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElementForParent(grammarAccess.getActionExprRule());
                      							}
                      							set(
                      								current,
                      								"val",
                      								lv_val_1_0,
                      								"com.collins.trustedmethods.matrics.soar.Soar.SymConstant");
                      							afterParserOrEnumRuleCall();
                      						
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1381:3: ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) )
                    {
                    // InternalSoarParser.g:1381:3: ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) )
                    // InternalSoarParser.g:1382:4: () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) )
                    {
                    // InternalSoarParser.g:1382:4: ()
                    // InternalSoarParser.g:1383:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getActionExprAccess().getStringExprAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1389:4: ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) )
                    // InternalSoarParser.g:1390:5: (lv_val_3_0= RULE_SYM_CONSTANT_STRING )
                    {
                    // InternalSoarParser.g:1390:5: (lv_val_3_0= RULE_SYM_CONSTANT_STRING )
                    // InternalSoarParser.g:1391:6: lv_val_3_0= RULE_SYM_CONSTANT_STRING
                    {
                    lv_val_3_0=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_val_3_0, grammarAccess.getActionExprAccess().getValSYM_CONSTANT_STRINGTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getActionExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"val",
                      							lv_val_3_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.SYM_CONSTANT_STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalSoarParser.g:1409:3: ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) )
                    {
                    // InternalSoarParser.g:1409:3: ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) )
                    // InternalSoarParser.g:1410:4: () ( ruleUnaryPref | ruleUnaryOrBinaryPref )
                    {
                    // InternalSoarParser.g:1410:4: ()
                    // InternalSoarParser.g:1411:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getActionExprAccess().getPrefSpecifierExprAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1417:4: ( ruleUnaryPref | ruleUnaryOrBinaryPref )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==ExclamationMark||LA25_0==PlusSign||LA25_0==HyphenMinus||LA25_0==CommercialAt||LA25_0==Tilde) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==Ampersand||(LA25_0>=LessThanSign && LA25_0<=GreaterThanSign)) ) {
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
                            // InternalSoarParser.g:1418:5: ruleUnaryPref
                            {
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getActionExprAccess().getUnaryPrefParserRuleCall_2_1_0());
                              				
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleUnaryPref();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;
                        case 2 :
                            // InternalSoarParser.g:1426:5: ruleUnaryOrBinaryPref
                            {
                            if ( state.backtracking==0 ) {

                              					newCompositeNode(grammarAccess.getActionExprAccess().getUnaryOrBinaryPrefParserRuleCall_2_1_1());
                              				
                            }
                            pushFollow(FollowSets000.FOLLOW_2);
                            ruleUnaryOrBinaryPref();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					afterParserOrEnumRuleCall();
                              				
                            }

                            }
                            break;

                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalSoarParser.g:1436:3: ( () otherlv_8= Crlf )
                    {
                    // InternalSoarParser.g:1436:3: ( () otherlv_8= Crlf )
                    // InternalSoarParser.g:1437:4: () otherlv_8= Crlf
                    {
                    // InternalSoarParser.g:1437:4: ()
                    // InternalSoarParser.g:1438:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getActionExprAccess().getCrlfExprAction_3_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_8=(Token)match(input,Crlf,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getActionExprAccess().getCrlfKeyword_3_1());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalSoarParser.g:1450:3: ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) )
                    {
                    // InternalSoarParser.g:1450:3: ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) )
                    // InternalSoarParser.g:1451:4: () ( (lv_expr_10_0= RULE_PIPE_STRING ) )
                    {
                    // InternalSoarParser.g:1451:4: ()
                    // InternalSoarParser.g:1452:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getActionExprAccess().getStringExprAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalSoarParser.g:1458:4: ( (lv_expr_10_0= RULE_PIPE_STRING ) )
                    // InternalSoarParser.g:1459:5: (lv_expr_10_0= RULE_PIPE_STRING )
                    {
                    // InternalSoarParser.g:1459:5: (lv_expr_10_0= RULE_PIPE_STRING )
                    // InternalSoarParser.g:1460:6: lv_expr_10_0= RULE_PIPE_STRING
                    {
                    lv_expr_10_0=(Token)match(input,RULE_PIPE_STRING,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_expr_10_0, grammarAccess.getActionExprAccess().getExprPIPE_STRINGTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getActionExprRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"expr",
                      							lv_expr_10_0,
                      							"com.collins.trustedmethods.matrics.soar.Soar.PIPE_STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalSoarParser.g:1478:3: ( () otherlv_12= Comma )
                    {
                    // InternalSoarParser.g:1478:3: ( () otherlv_12= Comma )
                    // InternalSoarParser.g:1479:4: () otherlv_12= Comma
                    {
                    // InternalSoarParser.g:1479:4: ()
                    // InternalSoarParser.g:1480:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getActionExprAccess().getCommaExprAction_5_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_12=(Token)match(input,Comma,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getActionExprAccess().getCommaKeyword_5_1());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalSoarParser.g:1492:3: ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis )
                    {
                    // InternalSoarParser.g:1492:3: ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis )
                    // InternalSoarParser.g:1493:4: () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis
                    {
                    // InternalSoarParser.g:1493:4: ()
                    // InternalSoarParser.g:1494:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getActionExprAccess().getParenExprAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_14=(Token)match(input,LeftParenthesis,FollowSets000.FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_14, grammarAccess.getActionExprAccess().getLeftParenthesisKeyword_6_1());
                      			
                    }
                    // InternalSoarParser.g:1504:4: ( (lv_exprs_15_0= ruleActionExpr ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==Crlf||(LA26_0>=ExclamationMark && LA26_0<=LeftParenthesis)||(LA26_0>=PlusSign && LA26_0<=HyphenMinus)||(LA26_0>=LessThanSign && LA26_0<=CommercialAt)||(LA26_0>=Tilde && LA26_0<=RULE_SYM_CONSTANT_STRING)||LA26_0==RULE_PIPE_STRING) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalSoarParser.g:1505:5: (lv_exprs_15_0= ruleActionExpr )
                    	    {
                    	    // InternalSoarParser.g:1505:5: (lv_exprs_15_0= ruleActionExpr )
                    	    // InternalSoarParser.g:1506:6: lv_exprs_15_0= ruleActionExpr
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getActionExprAccess().getExprsActionExprParserRuleCall_6_2_0());
                    	      					
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_22);
                    	    lv_exprs_15_0=ruleActionExpr();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getActionExprRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"exprs",
                    	      							lv_exprs_15_0,
                    	      							"com.collins.trustedmethods.matrics.soar.Soar.ActionExpr");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);

                    otherlv_16=(Token)match(input,RightParenthesis,FollowSets000.FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getActionExprAccess().getRightParenthesisKeyword_6_3());
                      			
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
    // $ANTLR end "ruleActionExpr"


    // $ANTLR start "entryRuleSymConstant"
    // InternalSoarParser.g:1532:1: entryRuleSymConstant returns [String current=null] : iv_ruleSymConstant= ruleSymConstant EOF ;
    public final String entryRuleSymConstant() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSymConstant = null;


        try {
            // InternalSoarParser.g:1532:51: (iv_ruleSymConstant= ruleSymConstant EOF )
            // InternalSoarParser.g:1533:2: iv_ruleSymConstant= ruleSymConstant EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSymConstantRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_1);
            iv_ruleSymConstant=ruleSymConstant();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSymConstant.getText(); 
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
    // $ANTLR end "entryRuleSymConstant"


    // $ANTLR start "ruleSymConstant"
    // InternalSoarParser.g:1539:1: ruleSymConstant returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= LessThanSign (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | this_STATE_2= ruleSTATE ) kw= GreaterThanSign ) ;
    public final AntlrDatatypeRuleToken ruleSymConstant() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_SYM_CONSTANT_STRING_1=null;
        AntlrDatatypeRuleToken this_STATE_2 = null;



        	enterRule();

        try {
            // InternalSoarParser.g:1545:2: ( (kw= LessThanSign (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | this_STATE_2= ruleSTATE ) kw= GreaterThanSign ) )
            // InternalSoarParser.g:1546:2: (kw= LessThanSign (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | this_STATE_2= ruleSTATE ) kw= GreaterThanSign )
            {
            // InternalSoarParser.g:1546:2: (kw= LessThanSign (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | this_STATE_2= ruleSTATE ) kw= GreaterThanSign )
            // InternalSoarParser.g:1547:3: kw= LessThanSign (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | this_STATE_2= ruleSTATE ) kw= GreaterThanSign
            {
            kw=(Token)match(input,LessThanSign,FollowSets000.FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getSymConstantAccess().getLessThanSignKeyword_0());
              		
            }
            // InternalSoarParser.g:1552:3: (this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING | this_STATE_2= ruleSTATE )
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
                    // InternalSoarParser.g:1553:4: this_SYM_CONSTANT_STRING_1= RULE_SYM_CONSTANT_STRING
                    {
                    this_SYM_CONSTANT_STRING_1=(Token)match(input,RULE_SYM_CONSTANT_STRING,FollowSets000.FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_SYM_CONSTANT_STRING_1);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_SYM_CONSTANT_STRING_1, grammarAccess.getSymConstantAccess().getSYM_CONSTANT_STRINGTerminalRuleCall_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalSoarParser.g:1561:4: this_STATE_2= ruleSTATE
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getSymConstantAccess().getSTATEParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FollowSets000.FOLLOW_25);
                    this_STATE_2=ruleSTATE();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_STATE_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            kw=(Token)match(input,GreaterThanSign,FollowSets000.FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getSymConstantAccess().getGreaterThanSignKeyword_2());
              		
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
    // $ANTLR end "ruleSymConstant"


    // $ANTLR start "entryRuleSTATE"
    // InternalSoarParser.g:1581:1: entryRuleSTATE returns [String current=null] : iv_ruleSTATE= ruleSTATE EOF ;
    public final String entryRuleSTATE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSTATE = null;


        try {
            // InternalSoarParser.g:1581:45: (iv_ruleSTATE= ruleSTATE EOF )
            // InternalSoarParser.g:1582:2: iv_ruleSTATE= ruleSTATE EOF
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
    // InternalSoarParser.g:1588:1: ruleSTATE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= State ;
    public final AntlrDatatypeRuleToken ruleSTATE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:1594:2: (kw= State )
            // InternalSoarParser.g:1595:2: kw= State
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
    // InternalSoarParser.g:1603:1: entryRuleIMPASSE returns [String current=null] : iv_ruleIMPASSE= ruleIMPASSE EOF ;
    public final String entryRuleIMPASSE() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIMPASSE = null;


        try {
            // InternalSoarParser.g:1603:47: (iv_ruleIMPASSE= ruleIMPASSE EOF )
            // InternalSoarParser.g:1604:2: iv_ruleIMPASSE= ruleIMPASSE EOF
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
    // InternalSoarParser.g:1610:1: ruleIMPASSE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= Impasse ;
    public final AntlrDatatypeRuleToken ruleIMPASSE() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSoarParser.g:1616:2: (kw= Impasse )
            // InternalSoarParser.g:1617:2: kw= Impasse
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

    // $ANTLR start synpred1_InternalSoarParser
    public final void synpred1_InternalSoarParser_fragment() throws RecognitionException {   
        // InternalSoarParser.g:710:5: ( ( () ( ( PlusSign ) ) ) )
        // InternalSoarParser.g:710:6: ( () ( ( PlusSign ) ) )
        {
        // InternalSoarParser.g:710:6: ( () ( ( PlusSign ) ) )
        // InternalSoarParser.g:711:6: () ( ( PlusSign ) )
        {
        // InternalSoarParser.g:711:6: ()
        // InternalSoarParser.g:712:6: 
        {
        }

        // InternalSoarParser.g:713:6: ( ( PlusSign ) )
        // InternalSoarParser.g:714:7: ( PlusSign )
        {
        // InternalSoarParser.g:714:7: ( PlusSign )
        // InternalSoarParser.g:715:8: PlusSign
        {
        match(input,PlusSign,FollowSets000.FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalSoarParser

    // $ANTLR start synpred2_InternalSoarParser
    public final void synpred2_InternalSoarParser_fragment() throws RecognitionException {   
        // InternalSoarParser.g:793:5: ( ( () ( ( ruleRelationalOp ) ) ) )
        // InternalSoarParser.g:793:6: ( () ( ( ruleRelationalOp ) ) )
        {
        // InternalSoarParser.g:793:6: ( () ( ( ruleRelationalOp ) ) )
        // InternalSoarParser.g:794:6: () ( ( ruleRelationalOp ) )
        {
        // InternalSoarParser.g:794:6: ()
        // InternalSoarParser.g:795:6: 
        {
        }

        // InternalSoarParser.g:796:6: ( ( ruleRelationalOp ) )
        // InternalSoarParser.g:797:7: ( ruleRelationalOp )
        {
        // InternalSoarParser.g:797:7: ( ruleRelationalOp )
        // InternalSoarParser.g:798:8: ruleRelationalOp
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleRelationalOp();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalSoarParser

    // $ANTLR start synpred3_InternalSoarParser
    public final void synpred3_InternalSoarParser_fragment() throws RecognitionException {   
        // InternalSoarParser.g:1341:4: ( ( () ( ( ruleSymConstant ) ) ) )
        // InternalSoarParser.g:1341:5: ( () ( ( ruleSymConstant ) ) )
        {
        // InternalSoarParser.g:1341:5: ( () ( ( ruleSymConstant ) ) )
        // InternalSoarParser.g:1342:5: () ( ( ruleSymConstant ) )
        {
        // InternalSoarParser.g:1342:5: ()
        // InternalSoarParser.g:1343:5: 
        {
        }

        // InternalSoarParser.g:1344:5: ( ( ruleSymConstant ) )
        // InternalSoarParser.g:1345:6: ( ruleSymConstant )
        {
        // InternalSoarParser.g:1345:6: ( ruleSymConstant )
        // InternalSoarParser.g:1346:7: ruleSymConstant
        {
        pushFollow(FollowSets000.FOLLOW_2);
        ruleSymConstant();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred3_InternalSoarParser

    // Delegated rules

    public final boolean synpred3_InternalSoarParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalSoarParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalSoarParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalSoarParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalSoarParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalSoarParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA14 dfa14 = new DFA14(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String dfa_1s = "\35\uffff";
    static final String dfa_2s = "\1\11\11\uffff\1\23\22\uffff";
    static final String dfa_3s = "\1\16\1\uffff\1\13\7\uffff\1\17\22\uffff";
    static final String dfa_4s = "\1\52\1\uffff\1\52\7\uffff\1\52\22\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\6\1\1\2\1\uffff\22\1";
    static final String dfa_6s = "\1\0\1\uffff\1\1\7\uffff\1\2\22\uffff}>";
    static final String[] dfa_7s = {
            "\1\7\1\11\1\4\1\1\1\6\1\5\1\11\5\uffff\2\11\1\uffff\1\11\2\uffff\1\2\1\10\1\3\1\uffff\5\11\1\uffff\1\11",
            "",
            "\1\11\3\uffff\1\16\15\uffff\1\13\2\uffff\1\17\3\uffff\1\15\2\uffff\1\14\2\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\30\4\uffff\1\34\5\uffff\1\21\1\20\1\uffff\1\25\2\uffff\1\31\1\uffff\1\11\1\uffff\1\27\1\33\1\22\1\26\1\24\1\uffff\1\32",
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

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "791:3: ( ( ( ( () ( ( ruleRelationalOp ) ) ) )=> ( () ( (lv_op_2_0= ruleRelationalOp ) ) ) ) ( (lv_right_3_0= rulePrefixExpr ) ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                         
                        int index14_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA14_0==LessThanSignGreaterThanSign) && (synpred2_InternalSoarParser())) {s = 1;}

                        else if ( (LA14_0==LessThanSign) ) {s = 2;}

                        else if ( (LA14_0==GreaterThanSign) && (synpred2_InternalSoarParser())) {s = 3;}

                        else if ( (LA14_0==LessThanSignEqualsSign) && (synpred2_InternalSoarParser())) {s = 4;}

                        else if ( (LA14_0==GreaterThanSignEqualsSign) && (synpred2_InternalSoarParser())) {s = 5;}

                        else if ( (LA14_0==EqualsSignEqualsSign) && (synpred2_InternalSoarParser())) {s = 6;}

                        else if ( (LA14_0==LessThanSignEqualsSignGreaterThanSign) && (synpred2_InternalSoarParser())) {s = 7;}

                        else if ( (LA14_0==EqualsSign) && (synpred2_InternalSoarParser())) {s = 8;}

                        else if ( (LA14_0==EOF||LA14_0==LessThanSignLessThanSign||LA14_0==GreaterThanSignGreaterThanSign||(LA14_0>=RightParenthesis && LA14_0<=PlusSign)||LA14_0==HyphenMinus||(LA14_0>=LeftSquareBracket && LA14_0<=RightCurlyBracket)||LA14_0==RULE_SYM_CONSTANT_STRING) ) {s = 9;}

                         
                        input.seek(index14_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_2 = input.LA(1);

                         
                        int index14_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA14_2==RULE_SYM_CONSTANT_STRING) ) {s = 10;}

                        else if ( (LA14_2==State) ) {s = 9;}

                        else if ( (LA14_2==HyphenMinus) && (synpred2_InternalSoarParser())) {s = 11;}

                        else if ( (LA14_2==LeftCurlyBracket) && (synpred2_InternalSoarParser())) {s = 12;}

                        else if ( (LA14_2==LeftSquareBracket) && (synpred2_InternalSoarParser())) {s = 13;}

                        else if ( (LA14_2==LessThanSignLessThanSign) && (synpred2_InternalSoarParser())) {s = 14;}

                        else if ( (LA14_2==LessThanSign) && (synpred2_InternalSoarParser())) {s = 15;}

                         
                        input.seek(index14_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_10 = input.LA(1);

                         
                        int index14_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA14_10==GreaterThanSign) ) {s = 9;}

                        else if ( (LA14_10==PlusSign) && (synpred2_InternalSoarParser())) {s = 16;}

                        else if ( (LA14_10==RightParenthesis) && (synpred2_InternalSoarParser())) {s = 17;}

                        else if ( (LA14_10==CircumflexAccent) && (synpred2_InternalSoarParser())) {s = 18;}

                        else if ( (LA14_10==EOF) && (synpred2_InternalSoarParser())) {s = 19;}

                        else if ( (LA14_10==RightCurlyBracket) && (synpred2_InternalSoarParser())) {s = 20;}

                        else if ( (LA14_10==HyphenMinus) && (synpred2_InternalSoarParser())) {s = 21;}

                        else if ( (LA14_10==LeftCurlyBracket) && (synpred2_InternalSoarParser())) {s = 22;}

                        else if ( (LA14_10==LeftSquareBracket) && (synpred2_InternalSoarParser())) {s = 23;}

                        else if ( (LA14_10==LessThanSignLessThanSign) && (synpred2_InternalSoarParser())) {s = 24;}

                        else if ( (LA14_10==LessThanSign) && (synpred2_InternalSoarParser())) {s = 25;}

                        else if ( (LA14_10==RULE_SYM_CONSTANT_STRING) && (synpred2_InternalSoarParser())) {s = 26;}

                        else if ( (LA14_10==RightSquareBracket) && (synpred2_InternalSoarParser())) {s = 27;}

                        else if ( (LA14_10==GreaterThanSignGreaterThanSign) && (synpred2_InternalSoarParser())) {s = 28;}

                         
                        input.seek(index14_10);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\13\uffff";
    static final String dfa_9s = "\1\uffff\1\3\11\uffff";
    static final String dfa_10s = "\2\11\6\uffff\1\11\1\uffff\1\0";
    static final String dfa_11s = "\2\54\6\uffff\1\54\1\uffff\1\0";
    static final String dfa_12s = "\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\1\1\uffff";
    static final String dfa_13s = "\1\uffff\1\0\10\uffff\1\1}>";
    static final String[] dfa_14s = {
            "\1\4\15\uffff\2\3\1\7\1\uffff\1\3\1\6\1\3\2\uffff\1\1\3\3\5\uffff\1\3\1\2\1\uffff\1\5",
            "\1\3\1\uffff\1\11\13\uffff\7\3\2\uffff\4\3\5\uffff\1\3\1\10\1\uffff\1\3",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\3\15\uffff\7\3\2\uffff\2\3\1\12\1\3\5\uffff\2\3\1\uffff\1\3",
            "",
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
            return "1339:2: ( ( ( ( () ( ( ruleSymConstant ) ) ) )=> ( () ( (lv_val_1_0= ruleSymConstant ) ) ) ) | ( () ( (lv_val_3_0= RULE_SYM_CONSTANT_STRING ) ) ) | ( () ( ruleUnaryPref | ruleUnaryOrBinaryPref ) ) | ( () otherlv_8= Crlf ) | ( () ( (lv_expr_10_0= RULE_PIPE_STRING ) ) ) | ( () otherlv_12= Comma ) | ( () otherlv_14= LeftParenthesis ( (lv_exprs_15_0= ruleActionExpr ) )+ otherlv_16= RightParenthesis ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_1 = input.LA(1);

                         
                        int index27_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA27_1==EOF||LA27_1==Crlf||(LA27_1>=ExclamationMark && LA27_1<=HyphenMinus)||(LA27_1>=LessThanSign && LA27_1<=CommercialAt)||LA27_1==Tilde||LA27_1==RULE_PIPE_STRING) ) {s = 3;}

                        else if ( (LA27_1==RULE_SYM_CONSTANT_STRING) ) {s = 8;}

                        else if ( (LA27_1==State) && (synpred3_InternalSoarParser())) {s = 9;}

                         
                        input.seek(index27_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_10 = input.LA(1);

                         
                        int index27_10 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred3_InternalSoarParser()) ) {s = 9;}

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
 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000600002L});
        public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000008000000000L});
        public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000080082002000L});
        public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000082002000L});
        public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000002002000L});
        public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000010002000000L});
        public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000000004F0L});
        public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000100000900L});
        public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000004000000000L});
        public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000004004000000L});
        public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000049160008900L});
        public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000007000F4002L});
        public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000059160008900L});
        public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x000004B160008900L});
        public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000049160108900L});
        public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000160F3B800B00L});
        public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000160F3F800B00L});
        public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000040000000800L});
        public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000400000000L});
    }


}