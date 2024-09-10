package com.collins.trustedmethods.matrics.soar.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSoarLexer extends Lexer {
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

    public InternalSoarLexer() {;} 
    public InternalSoarLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalSoarLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalSoarLexer.g"; }

    // $ANTLR start "ISupport"
    public final void mISupport() throws RecognitionException {
        try {
            int _type = ISupport;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:34:10: ( ( 'I' | 'i' ) '-' ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // InternalSoarLexer.g:34:12: ( 'I' | 'i' ) '-' ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ISupport"

    // $ANTLR start "OSupport"
    public final void mOSupport() throws RecognitionException {
        try {
            int _type = OSupport;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:36:10: ( ( 'O' | 'o' ) '-' ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // InternalSoarLexer.g:36:12: ( 'O' | 'o' ) '-' ( 'S' | 's' ) ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match('-'); 
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OSupport"

    // $ANTLR start "Template"
    public final void mTemplate() throws RecognitionException {
        try {
            int _type = Template;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:38:10: ( ( 'T' | 't' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // InternalSoarLexer.g:38:12: ( 'T' | 't' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Template"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:40:9: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // InternalSoarLexer.g:40:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "Impasse"
    public final void mImpasse() throws RecognitionException {
        try {
            int _type = Impasse;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:42:9: ( ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // InternalSoarLexer.g:42:11: ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Impasse"

    // $ANTLR start "Crlf"
    public final void mCrlf() throws RecognitionException {
        try {
            int _type = Crlf;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:44:6: ( '(' ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'L' | 'l' ) ( 'F' | 'f' ) ')' )
            // InternalSoarLexer.g:44:8: '(' ( 'C' | 'c' ) ( 'R' | 'r' ) ( 'L' | 'l' ) ( 'F' | 'f' ) ')'
            {
            match('('); 
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Crlf"

    // $ANTLR start "Chunk"
    public final void mChunk() throws RecognitionException {
        try {
            int _type = Chunk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:46:7: ( ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'K' | 'k' ) )
            // InternalSoarLexer.g:46:9: ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'K' | 'k' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Chunk"

    // $ANTLR start "State"
    public final void mState() throws RecognitionException {
        try {
            int _type = State;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:48:7: ( ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // InternalSoarLexer.g:48:9: ( 'S' | 's' ) ( 'T' | 't' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "State"

    // $ANTLR start "Write"
    public final void mWrite() throws RecognitionException {
        try {
            int _type = Write;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:50:7: ( ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // InternalSoarLexer.g:50:9: ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Write"

    // $ANTLR start "QuotationMarkQuotationMarkQuotationMark"
    public final void mQuotationMarkQuotationMarkQuotationMark() throws RecognitionException {
        try {
            int _type = QuotationMarkQuotationMarkQuotationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:52:41: ( '\"' '\"' '\"' )
            // InternalSoarLexer.g:52:43: '\"' '\"' '\"'
            {
            match('\"'); 
            match('\"'); 
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QuotationMarkQuotationMarkQuotationMark"

    // $ANTLR start "HyphenMinusHyphenMinusGreaterThanSign"
    public final void mHyphenMinusHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusHyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:54:39: ( '-' '-' '>' )
            // InternalSoarLexer.g:54:41: '-' '-' '>'
            {
            match('-'); 
            match('-'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinusHyphenMinusGreaterThanSign"

    // $ANTLR start "LessThanSignEqualsSignGreaterThanSign"
    public final void mLessThanSignEqualsSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:56:39: ( '<' '=' '>' )
            // InternalSoarLexer.g:56:41: '<' '=' '>'
            {
            match('<'); 
            match('='); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSignGreaterThanSign"

    // $ANTLR start "LessThanSignLessThanSign"
    public final void mLessThanSignLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignLessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:58:26: ( '<' '<' )
            // InternalSoarLexer.g:58:28: '<' '<'
            {
            match('<'); 
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignLessThanSign"

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:60:24: ( '<' '=' )
            // InternalSoarLexer.g:60:26: '<' '='
            {
            match('<'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "LessThanSignGreaterThanSign"
    public final void mLessThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = LessThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:62:29: ( '<' '>' )
            // InternalSoarLexer.g:62:31: '<' '>'
            {
            match('<'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignGreaterThanSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:64:22: ( '=' '=' )
            // InternalSoarLexer.g:64:24: '=' '='
            {
            match('='); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:66:27: ( '>' '=' )
            // InternalSoarLexer.g:66:29: '>' '='
            {
            match('>'); 
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "GreaterThanSignGreaterThanSign"
    public final void mGreaterThanSignGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:68:32: ( '>' '>' )
            // InternalSoarLexer.g:68:34: '>' '>'
            {
            match('>'); 
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignGreaterThanSign"

    // $ANTLR start "Gp"
    public final void mGp() throws RecognitionException {
        try {
            int _type = Gp;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:70:4: ( ( 'G' | 'g' ) ( 'P' | 'p' ) )
            // InternalSoarLexer.g:70:6: ( 'G' | 'g' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Gp"

    // $ANTLR start "Sp"
    public final void mSp() throws RecognitionException {
        try {
            int _type = Sp;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:72:4: ( ( 'S' | 's' ) ( 'P' | 'p' ) )
            // InternalSoarLexer.g:72:6: ( 'S' | 's' ) ( 'P' | 'p' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Sp"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:74:17: ( '!' )
            // InternalSoarLexer.g:74:19: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMark"

    // $ANTLR start "Ampersand"
    public final void mAmpersand() throws RecognitionException {
        try {
            int _type = Ampersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:76:11: ( '&' )
            // InternalSoarLexer.g:76:13: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Ampersand"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:78:17: ( '(' )
            // InternalSoarLexer.g:78:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:80:18: ( ')' )
            // InternalSoarLexer.g:80:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Asterisk"
    public final void mAsterisk() throws RecognitionException {
        try {
            int _type = Asterisk;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:82:10: ( '*' )
            // InternalSoarLexer.g:82:12: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Asterisk"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:84:10: ( '+' )
            // InternalSoarLexer.g:84:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:86:7: ( ',' )
            // InternalSoarLexer.g:86:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "HyphenMinus"
    public final void mHyphenMinus() throws RecognitionException {
        try {
            int _type = HyphenMinus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:88:13: ( '-' )
            // InternalSoarLexer.g:88:15: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HyphenMinus"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:90:10: ( '.' )
            // InternalSoarLexer.g:90:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Solidus"
    public final void mSolidus() throws RecognitionException {
        try {
            int _type = Solidus;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:92:9: ( '/' )
            // InternalSoarLexer.g:92:11: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Solidus"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:94:7: ( ':' )
            // InternalSoarLexer.g:94:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:96:14: ( '<' )
            // InternalSoarLexer.g:96:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:98:12: ( '=' )
            // InternalSoarLexer.g:98:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:100:17: ( '>' )
            // InternalSoarLexer.g:100:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "CommercialAt"
    public final void mCommercialAt() throws RecognitionException {
        try {
            int _type = CommercialAt;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:102:14: ( '@' )
            // InternalSoarLexer.g:102:16: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CommercialAt"

    // $ANTLR start "LeftSquareBracket"
    public final void mLeftSquareBracket() throws RecognitionException {
        try {
            int _type = LeftSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:104:19: ( '[' )
            // InternalSoarLexer.g:104:21: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftSquareBracket"

    // $ANTLR start "RightSquareBracket"
    public final void mRightSquareBracket() throws RecognitionException {
        try {
            int _type = RightSquareBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:106:20: ( ']' )
            // InternalSoarLexer.g:106:22: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightSquareBracket"

    // $ANTLR start "CircumflexAccent"
    public final void mCircumflexAccent() throws RecognitionException {
        try {
            int _type = CircumflexAccent;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:108:18: ( '^' )
            // InternalSoarLexer.g:108:20: '^'
            {
            match('^'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CircumflexAccent"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:110:18: ( '{' )
            // InternalSoarLexer.g:110:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:112:19: ( '}' )
            // InternalSoarLexer.g:112:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "Tilde"
    public final void mTilde() throws RecognitionException {
        try {
            int _type = Tilde;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:114:7: ( '~' )
            // InternalSoarLexer.g:114:9: '~'
            {
            match('~'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Tilde"

    // $ANTLR start "RULE_SYM_CONSTANT_STRING"
    public final void mRULE_SYM_CONSTANT_STRING() throws RecognitionException {
        try {
            int _type = RULE_SYM_CONSTANT_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:116:26: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // InternalSoarLexer.g:116:28: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSoarLexer.g:116:48: ( ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*'||LA4_0=='-'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSoarLexer.g:116:49: ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // InternalSoarLexer.g:116:49: ( '_' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='_') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalSoarLexer.g:116:49: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    // InternalSoarLexer.g:116:54: ( '*' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0=='*') ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalSoarLexer.g:116:54: '*'
            	            {
            	            match('*'); 

            	            }
            	            break;

            	    }

            	    // InternalSoarLexer.g:116:59: ( '-' )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0=='-') ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalSoarLexer.g:116:59: '-'
            	            {
            	            match('-'); 

            	            }
            	            break;

            	    }

            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SYM_CONSTANT_STRING"

    // $ANTLR start "RULE_PRINT_STRING"
    public final void mRULE_PRINT_STRING() throws RecognitionException {
        try {
            int _type = RULE_PRINT_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:118:19: ( '|' ( '\\\\|' | ~ ( '|' ) )* '|' )
            // InternalSoarLexer.g:118:21: '|' ( '\\\\|' | ~ ( '|' ) )* '|'
            {
            match('|'); 
            // InternalSoarLexer.g:118:25: ( '\\\\|' | ~ ( '|' ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    int LA5_2 = input.LA(2);

                    if ( (LA5_2=='|') ) {
                        int LA5_4 = input.LA(3);

                        if ( ((LA5_4>='\u0000' && LA5_4<='\uFFFF')) ) {
                            alt5=1;
                        }

                        else {
                            alt5=2;
                        }

                    }
                    else if ( ((LA5_2>='\u0000' && LA5_2<='{')||(LA5_2>='}' && LA5_2<='\uFFFF')) ) {
                        alt5=2;
                    }


                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='{')||(LA5_0>='}' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSoarLexer.g:118:26: '\\\\|'
            	    {
            	    match("\\|"); 


            	    }
            	    break;
            	case 2 :
            	    // InternalSoarLexer.g:118:32: ~ ( '|' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='{')||(input.LA(1)>='}' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_PRINT_STRING"

    // $ANTLR start "RULE_FLOAT"
    public final void mRULE_FLOAT() throws RecognitionException {
        try {
            int _type = RULE_FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:120:12: ( ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // InternalSoarLexer.g:120:14: ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // InternalSoarLexer.g:120:14: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSoarLexer.g:120:15: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);

            match('.'); 
            // InternalSoarLexer.g:120:30: ( '0' .. '9' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='0' && LA7_0<='9')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalSoarLexer.g:120:31: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_FLOAT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:122:10: ( ( '0' .. '9' )+ )
            // InternalSoarLexer.g:122:12: ( '0' .. '9' )+
            {
            // InternalSoarLexer.g:122:12: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSoarLexer.g:122:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:124:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalSoarLexer.g:124:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalSoarLexer.g:124:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\t' && LA9_0<='\n')||LA9_0=='\r'||LA9_0==' ') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalSoarLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:126:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalSoarLexer.g:126:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('#'); 
            // InternalSoarLexer.g:126:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalSoarLexer.g:126:23: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalSoarLexer.g:126:39: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSoarLexer.g:126:40: ( '\\r' )? '\\n'
                    {
                    // InternalSoarLexer.g:126:40: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSoarLexer.g:126:40: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    public void mTokens() throws RecognitionException {
        // InternalSoarLexer.g:1:8: ( ISupport | OSupport | Template | Default | Impasse | Crlf | Chunk | State | Write | QuotationMarkQuotationMarkQuotationMark | HyphenMinusHyphenMinusGreaterThanSign | LessThanSignEqualsSignGreaterThanSign | LessThanSignLessThanSign | LessThanSignEqualsSign | LessThanSignGreaterThanSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | GreaterThanSignGreaterThanSign | Gp | Sp | ExclamationMark | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | RightCurlyBracket | Tilde | RULE_SYM_CONSTANT_STRING | RULE_PRINT_STRING | RULE_FLOAT | RULE_INT | RULE_WS | RULE_SL_COMMENT )
        int alt13=47;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // InternalSoarLexer.g:1:10: ISupport
                {
                mISupport(); 

                }
                break;
            case 2 :
                // InternalSoarLexer.g:1:19: OSupport
                {
                mOSupport(); 

                }
                break;
            case 3 :
                // InternalSoarLexer.g:1:28: Template
                {
                mTemplate(); 

                }
                break;
            case 4 :
                // InternalSoarLexer.g:1:37: Default
                {
                mDefault(); 

                }
                break;
            case 5 :
                // InternalSoarLexer.g:1:45: Impasse
                {
                mImpasse(); 

                }
                break;
            case 6 :
                // InternalSoarLexer.g:1:53: Crlf
                {
                mCrlf(); 

                }
                break;
            case 7 :
                // InternalSoarLexer.g:1:58: Chunk
                {
                mChunk(); 

                }
                break;
            case 8 :
                // InternalSoarLexer.g:1:64: State
                {
                mState(); 

                }
                break;
            case 9 :
                // InternalSoarLexer.g:1:70: Write
                {
                mWrite(); 

                }
                break;
            case 10 :
                // InternalSoarLexer.g:1:76: QuotationMarkQuotationMarkQuotationMark
                {
                mQuotationMarkQuotationMarkQuotationMark(); 

                }
                break;
            case 11 :
                // InternalSoarLexer.g:1:116: HyphenMinusHyphenMinusGreaterThanSign
                {
                mHyphenMinusHyphenMinusGreaterThanSign(); 

                }
                break;
            case 12 :
                // InternalSoarLexer.g:1:154: LessThanSignEqualsSignGreaterThanSign
                {
                mLessThanSignEqualsSignGreaterThanSign(); 

                }
                break;
            case 13 :
                // InternalSoarLexer.g:1:192: LessThanSignLessThanSign
                {
                mLessThanSignLessThanSign(); 

                }
                break;
            case 14 :
                // InternalSoarLexer.g:1:217: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 15 :
                // InternalSoarLexer.g:1:240: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 16 :
                // InternalSoarLexer.g:1:268: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 17 :
                // InternalSoarLexer.g:1:289: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 18 :
                // InternalSoarLexer.g:1:315: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 19 :
                // InternalSoarLexer.g:1:346: Gp
                {
                mGp(); 

                }
                break;
            case 20 :
                // InternalSoarLexer.g:1:349: Sp
                {
                mSp(); 

                }
                break;
            case 21 :
                // InternalSoarLexer.g:1:352: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 22 :
                // InternalSoarLexer.g:1:368: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 23 :
                // InternalSoarLexer.g:1:378: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 24 :
                // InternalSoarLexer.g:1:394: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 25 :
                // InternalSoarLexer.g:1:411: Asterisk
                {
                mAsterisk(); 

                }
                break;
            case 26 :
                // InternalSoarLexer.g:1:420: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 27 :
                // InternalSoarLexer.g:1:429: Comma
                {
                mComma(); 

                }
                break;
            case 28 :
                // InternalSoarLexer.g:1:435: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 29 :
                // InternalSoarLexer.g:1:447: FullStop
                {
                mFullStop(); 

                }
                break;
            case 30 :
                // InternalSoarLexer.g:1:456: Solidus
                {
                mSolidus(); 

                }
                break;
            case 31 :
                // InternalSoarLexer.g:1:464: Colon
                {
                mColon(); 

                }
                break;
            case 32 :
                // InternalSoarLexer.g:1:470: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 33 :
                // InternalSoarLexer.g:1:483: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 34 :
                // InternalSoarLexer.g:1:494: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 35 :
                // InternalSoarLexer.g:1:510: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 36 :
                // InternalSoarLexer.g:1:523: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 37 :
                // InternalSoarLexer.g:1:541: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 38 :
                // InternalSoarLexer.g:1:560: CircumflexAccent
                {
                mCircumflexAccent(); 

                }
                break;
            case 39 :
                // InternalSoarLexer.g:1:577: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 40 :
                // InternalSoarLexer.g:1:594: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 41 :
                // InternalSoarLexer.g:1:612: Tilde
                {
                mTilde(); 

                }
                break;
            case 42 :
                // InternalSoarLexer.g:1:618: RULE_SYM_CONSTANT_STRING
                {
                mRULE_SYM_CONSTANT_STRING(); 

                }
                break;
            case 43 :
                // InternalSoarLexer.g:1:643: RULE_PRINT_STRING
                {
                mRULE_PRINT_STRING(); 

                }
                break;
            case 44 :
                // InternalSoarLexer.g:1:661: RULE_FLOAT
                {
                mRULE_FLOAT(); 

                }
                break;
            case 45 :
                // InternalSoarLexer.g:1:672: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 46 :
                // InternalSoarLexer.g:1:681: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 47 :
                // InternalSoarLexer.g:1:689: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\4\37\1\52\3\37\1\uffff\1\60\1\64\1\66\1\71\1\37\22\uffff\1\74\3\uffff\1\37\1\uffff\2\37\2\uffff\2\37\1\104\1\37\2\uffff\1\107\10\uffff\1\110\2\uffff\7\37\1\uffff\1\37\3\uffff\15\37\1\136\1\137\1\140\5\37\3\uffff\1\37\1\147\2\37\1\152\1\37\1\uffff\1\37\1\155\1\uffff\1\156\1\157\3\uffff";
    static final String DFA13_eofS =
        "\160\uffff";
    static final String DFA13_minS =
        "\1\11\2\55\2\105\1\103\1\110\1\120\1\122\1\uffff\1\55\1\74\2\75\1\120\22\uffff\1\56\2\uffff\1\60\1\120\1\60\1\115\1\106\2\uffff\1\125\1\101\1\52\1\111\2\uffff\1\76\10\uffff\1\52\2\uffff\1\125\1\101\1\125\1\120\1\101\1\116\1\124\1\uffff\1\124\3\uffff\1\120\1\123\1\120\1\114\1\125\1\113\2\105\1\120\1\123\1\120\1\101\1\114\3\52\1\117\1\105\1\117\2\124\3\uffff\1\122\1\52\1\122\1\105\1\52\1\124\1\uffff\1\124\1\52\1\uffff\2\52\3\uffff";
    static final String DFA13_maxS =
        "\1\176\1\155\1\55\2\145\1\143\1\150\1\164\1\162\1\uffff\1\55\1\76\1\75\1\76\1\160\22\uffff\1\71\2\uffff\1\172\1\160\1\172\1\155\1\146\2\uffff\1\165\1\141\1\172\1\151\2\uffff\1\76\10\uffff\1\172\2\uffff\1\165\1\141\1\165\1\160\1\141\1\156\1\164\1\uffff\1\164\3\uffff\1\160\1\163\1\160\1\154\1\165\1\153\2\145\1\160\1\163\1\160\1\141\1\154\3\172\1\157\1\145\1\157\2\164\3\uffff\1\162\1\172\1\162\1\145\1\172\1\164\1\uffff\1\164\1\172\1\uffff\2\172\3\uffff";
    static final String DFA13_acceptS =
        "\11\uffff\1\12\5\uffff\1\25\1\26\1\30\1\31\1\32\1\33\1\35\1\36\1\37\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\1\uffff\1\56\1\57\5\uffff\1\6\1\27\4\uffff\1\13\1\34\1\uffff\1\15\1\17\1\40\1\20\1\41\1\21\1\22\1\42\1\uffff\1\54\1\55\7\uffff\1\24\1\uffff\1\14\1\16\1\23\25\uffff\1\7\1\10\1\11\6\uffff\1\5\2\uffff\1\4\2\uffff\1\3\1\1\1\2";
    static final String DFA13_specialS =
        "\160\uffff}>";
    static final String[] DFA13_transitionS = DFA13_transitionS_.DFA13_transitionS;
    private static final class DFA13_transitionS_ {
        static final String[] DFA13_transitionS = {
                "\2\42\2\uffff\1\42\22\uffff\1\42\1\17\1\11\1\43\2\uffff\1\20\1\uffff\1\5\1\21\1\22\1\23\1\24\1\12\1\25\1\26\12\41\1\27\1\uffff\1\13\1\14\1\15\1\uffff\1\30\2\37\1\6\1\4\2\37\1\16\1\37\1\1\5\37\1\2\3\37\1\7\1\3\2\37\1\10\3\37\1\31\1\uffff\1\32\1\33\2\uffff\2\37\1\6\1\4\2\37\1\16\1\37\1\1\5\37\1\2\3\37\1\7\1\3\2\37\1\10\3\37\1\34\1\40\1\35\1\36",
                "\1\44\37\uffff\1\45\37\uffff\1\45",
                "\1\46",
                "\1\47\37\uffff\1\47",
                "\1\50\37\uffff\1\50",
                "\1\51\37\uffff\1\51",
                "\1\53\37\uffff\1\53",
                "\1\55\3\uffff\1\54\33\uffff\1\55\3\uffff\1\54",
                "\1\56\37\uffff\1\56",
                "",
                "\1\57",
                "\1\62\1\61\1\63",
                "\1\65",
                "\1\67\1\70",
                "\1\72\37\uffff\1\72",
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
                "\1\73\1\uffff\12\41",
                "",
                "",
                "\12\37\7\uffff\22\37\1\75\7\37\6\uffff\22\37\1\75\7\37",
                "\1\76\37\uffff\1\76",
                "\12\37\7\uffff\22\37\1\77\7\37\6\uffff\22\37\1\77\7\37",
                "\1\100\37\uffff\1\100",
                "\1\101\37\uffff\1\101",
                "",
                "",
                "\1\102\37\uffff\1\102",
                "\1\103\37\uffff\1\103",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\105\37\uffff\1\105",
                "",
                "",
                "\1\106",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "",
                "",
                "\1\111\37\uffff\1\111",
                "\1\112\37\uffff\1\112",
                "\1\113\37\uffff\1\113",
                "\1\114\37\uffff\1\114",
                "\1\115\37\uffff\1\115",
                "\1\116\37\uffff\1\116",
                "\1\117\37\uffff\1\117",
                "",
                "\1\120\37\uffff\1\120",
                "",
                "",
                "",
                "\1\121\37\uffff\1\121",
                "\1\122\37\uffff\1\122",
                "\1\123\37\uffff\1\123",
                "\1\124\37\uffff\1\124",
                "\1\125\37\uffff\1\125",
                "\1\126\37\uffff\1\126",
                "\1\127\37\uffff\1\127",
                "\1\130\37\uffff\1\130",
                "\1\131\37\uffff\1\131",
                "\1\132\37\uffff\1\132",
                "\1\133\37\uffff\1\133",
                "\1\134\37\uffff\1\134",
                "\1\135\37\uffff\1\135",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\141\37\uffff\1\141",
                "\1\142\37\uffff\1\142",
                "\1\143\37\uffff\1\143",
                "\1\144\37\uffff\1\144",
                "\1\145\37\uffff\1\145",
                "",
                "",
                "",
                "\1\146\37\uffff\1\146",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\150\37\uffff\1\150",
                "\1\151\37\uffff\1\151",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\153\37\uffff\1\153",
                "",
                "\1\154\37\uffff\1\154",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "\1\37\2\uffff\1\37\2\uffff\12\37\7\uffff\32\37\4\uffff\1\37\1\uffff\32\37",
                "",
                "",
                ""
        };
    }

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ISupport | OSupport | Template | Default | Impasse | Crlf | Chunk | State | Write | QuotationMarkQuotationMarkQuotationMark | HyphenMinusHyphenMinusGreaterThanSign | LessThanSignEqualsSignGreaterThanSign | LessThanSignLessThanSign | LessThanSignEqualsSign | LessThanSignGreaterThanSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | GreaterThanSignGreaterThanSign | Gp | Sp | ExclamationMark | Ampersand | LeftParenthesis | RightParenthesis | Asterisk | PlusSign | Comma | HyphenMinus | FullStop | Solidus | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | RightCurlyBracket | Tilde | RULE_SYM_CONSTANT_STRING | RULE_PRINT_STRING | RULE_FLOAT | RULE_INT | RULE_WS | RULE_SL_COMMENT );";
        }
    }
 

}