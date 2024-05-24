package com.collins.trustedmethods.matrics.soar.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSoarLexer extends Lexer {
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

    // $ANTLR start "HyphenMinusHyphenMinusGreaterThanSign"
    public final void mHyphenMinusHyphenMinusGreaterThanSign() throws RecognitionException {
        try {
            int _type = HyphenMinusHyphenMinusGreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:52:39: ( '-' '-' '>' )
            // InternalSoarLexer.g:52:41: '-' '-' '>'
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
            // InternalSoarLexer.g:54:39: ( '<' '=' '>' )
            // InternalSoarLexer.g:54:41: '<' '=' '>'
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
            // InternalSoarLexer.g:56:26: ( '<' '<' )
            // InternalSoarLexer.g:56:28: '<' '<'
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
            // InternalSoarLexer.g:58:24: ( '<' '=' )
            // InternalSoarLexer.g:58:26: '<' '='
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
            // InternalSoarLexer.g:60:29: ( '<' '>' )
            // InternalSoarLexer.g:60:31: '<' '>'
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
            // InternalSoarLexer.g:62:22: ( '=' '=' )
            // InternalSoarLexer.g:62:24: '=' '='
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
            // InternalSoarLexer.g:64:27: ( '>' '=' )
            // InternalSoarLexer.g:64:29: '>' '='
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
            // InternalSoarLexer.g:66:32: ( '>' '>' )
            // InternalSoarLexer.g:66:34: '>' '>'
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
            // InternalSoarLexer.g:68:4: ( ( 'G' | 'g' ) ( 'P' | 'p' ) )
            // InternalSoarLexer.g:68:6: ( 'G' | 'g' ) ( 'P' | 'p' )
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
            // InternalSoarLexer.g:70:4: ( ( 'S' | 's' ) ( 'P' | 'p' ) )
            // InternalSoarLexer.g:70:6: ( 'S' | 's' ) ( 'P' | 'p' )
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
            // InternalSoarLexer.g:72:17: ( '!' )
            // InternalSoarLexer.g:72:19: '!'
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
            // InternalSoarLexer.g:74:11: ( '&' )
            // InternalSoarLexer.g:74:13: '&'
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
            // InternalSoarLexer.g:76:17: ( '(' )
            // InternalSoarLexer.g:76:19: '('
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
            // InternalSoarLexer.g:78:18: ( ')' )
            // InternalSoarLexer.g:78:20: ')'
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

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:80:10: ( '+' )
            // InternalSoarLexer.g:80:12: '+'
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
            // InternalSoarLexer.g:82:7: ( ',' )
            // InternalSoarLexer.g:82:9: ','
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
            // InternalSoarLexer.g:84:13: ( '-' )
            // InternalSoarLexer.g:84:15: '-'
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
            // InternalSoarLexer.g:86:10: ( '.' )
            // InternalSoarLexer.g:86:12: '.'
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

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:88:7: ( ':' )
            // InternalSoarLexer.g:88:9: ':'
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
            // InternalSoarLexer.g:90:14: ( '<' )
            // InternalSoarLexer.g:90:16: '<'
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
            // InternalSoarLexer.g:92:12: ( '=' )
            // InternalSoarLexer.g:92:14: '='
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
            // InternalSoarLexer.g:94:17: ( '>' )
            // InternalSoarLexer.g:94:19: '>'
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
            // InternalSoarLexer.g:96:14: ( '@' )
            // InternalSoarLexer.g:96:16: '@'
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
            // InternalSoarLexer.g:98:19: ( '[' )
            // InternalSoarLexer.g:98:21: '['
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
            // InternalSoarLexer.g:100:20: ( ']' )
            // InternalSoarLexer.g:100:22: ']'
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
            // InternalSoarLexer.g:102:18: ( '^' )
            // InternalSoarLexer.g:102:20: '^'
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
            // InternalSoarLexer.g:104:18: ( '{' )
            // InternalSoarLexer.g:104:20: '{'
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
            // InternalSoarLexer.g:106:19: ( '}' )
            // InternalSoarLexer.g:106:21: '}'
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
            // InternalSoarLexer.g:108:7: ( '~' )
            // InternalSoarLexer.g:108:9: '~'
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
            // InternalSoarLexer.g:110:26: ( ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )* )
            // InternalSoarLexer.g:110:28: ( 'a' .. 'z' | 'A' .. 'Z' ) ( ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalSoarLexer.g:110:48: ( ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='*'||LA4_0=='-'||(LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalSoarLexer.g:110:49: ( '_' )? ( '*' )? ( '-' )? ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )
            	    {
            	    // InternalSoarLexer.g:110:49: ( '_' )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0=='_') ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalSoarLexer.g:110:49: '_'
            	            {
            	            match('_'); 

            	            }
            	            break;

            	    }

            	    // InternalSoarLexer.g:110:54: ( '*' )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0=='*') ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // InternalSoarLexer.g:110:54: '*'
            	            {
            	            match('*'); 

            	            }
            	            break;

            	    }

            	    // InternalSoarLexer.g:110:59: ( '-' )?
            	    int alt3=2;
            	    int LA3_0 = input.LA(1);

            	    if ( (LA3_0=='-') ) {
            	        alt3=1;
            	    }
            	    switch (alt3) {
            	        case 1 :
            	            // InternalSoarLexer.g:110:59: '-'
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

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:112:13: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' )
            // InternalSoarLexer.g:112:15: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
            {
            match('\"'); 
            // InternalSoarLexer.g:112:19: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
            loop5:
            do {
                int alt5=3;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\\') ) {
                    alt5=1;
                }
                else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                    alt5=2;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalSoarLexer.g:112:20: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // InternalSoarLexer.g:112:65: ~ ( ( '\\\\' | '\"' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
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

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_PIPE_STRING"
    public final void mRULE_PIPE_STRING() throws RecognitionException {
        try {
            int _type = RULE_PIPE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:114:18: ( '|' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '|' ) ) )* '|' )
            // InternalSoarLexer.g:114:20: '|' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '|' ) ) )* '|'
            {
            match('|'); 
            // InternalSoarLexer.g:114:24: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '|' ) ) )*
            loop6:
            do {
                int alt6=3;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\\') ) {
                    alt6=1;
                }
                else if ( ((LA6_0>='\u0000' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='{')||(LA6_0>='}' && LA6_0<='\uFFFF')) ) {
                    alt6=2;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalSoarLexer.g:114:25: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
            	    {
            	    match('\\'); 
            	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;
            	case 2 :
            	    // InternalSoarLexer.g:114:70: ~ ( ( '\\\\' | '|' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='{')||(input.LA(1)>='}' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop6;
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
    // $ANTLR end "RULE_PIPE_STRING"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:116:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalSoarLexer.g:116:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalSoarLexer.g:116:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\t' && LA7_0<='\n')||LA7_0=='\r'||LA7_0==' ') ) {
                    alt7=1;
                }


                switch (alt7) {
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
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalSoarLexer.g:118:17: ( '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalSoarLexer.g:118:19: '#' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match('#'); 
            // InternalSoarLexer.g:118:23: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalSoarLexer.g:118:23: ~ ( ( '\\n' | '\\r' ) )
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
            	    break loop8;
                }
            } while (true);

            // InternalSoarLexer.g:118:39: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalSoarLexer.g:118:40: ( '\\r' )? '\\n'
                    {
                    // InternalSoarLexer.g:118:40: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalSoarLexer.g:118:40: '\\r'
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
        // InternalSoarLexer.g:1:8: ( ISupport | OSupport | Template | Default | Impasse | Crlf | Chunk | State | Write | HyphenMinusHyphenMinusGreaterThanSign | LessThanSignEqualsSignGreaterThanSign | LessThanSignLessThanSign | LessThanSignEqualsSign | LessThanSignGreaterThanSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | GreaterThanSignGreaterThanSign | Gp | Sp | ExclamationMark | Ampersand | LeftParenthesis | RightParenthesis | PlusSign | Comma | HyphenMinus | FullStop | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | RightCurlyBracket | Tilde | RULE_SYM_CONSTANT_STRING | RULE_STRING | RULE_PIPE_STRING | RULE_WS | RULE_SL_COMMENT )
        int alt11=43;
        alt11 = dfa11.predict(input);
        switch (alt11) {
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
                // InternalSoarLexer.g:1:76: HyphenMinusHyphenMinusGreaterThanSign
                {
                mHyphenMinusHyphenMinusGreaterThanSign(); 

                }
                break;
            case 11 :
                // InternalSoarLexer.g:1:114: LessThanSignEqualsSignGreaterThanSign
                {
                mLessThanSignEqualsSignGreaterThanSign(); 

                }
                break;
            case 12 :
                // InternalSoarLexer.g:1:152: LessThanSignLessThanSign
                {
                mLessThanSignLessThanSign(); 

                }
                break;
            case 13 :
                // InternalSoarLexer.g:1:177: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 14 :
                // InternalSoarLexer.g:1:200: LessThanSignGreaterThanSign
                {
                mLessThanSignGreaterThanSign(); 

                }
                break;
            case 15 :
                // InternalSoarLexer.g:1:228: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 16 :
                // InternalSoarLexer.g:1:249: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 17 :
                // InternalSoarLexer.g:1:275: GreaterThanSignGreaterThanSign
                {
                mGreaterThanSignGreaterThanSign(); 

                }
                break;
            case 18 :
                // InternalSoarLexer.g:1:306: Gp
                {
                mGp(); 

                }
                break;
            case 19 :
                // InternalSoarLexer.g:1:309: Sp
                {
                mSp(); 

                }
                break;
            case 20 :
                // InternalSoarLexer.g:1:312: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 21 :
                // InternalSoarLexer.g:1:328: Ampersand
                {
                mAmpersand(); 

                }
                break;
            case 22 :
                // InternalSoarLexer.g:1:338: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 23 :
                // InternalSoarLexer.g:1:354: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 24 :
                // InternalSoarLexer.g:1:371: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 25 :
                // InternalSoarLexer.g:1:380: Comma
                {
                mComma(); 

                }
                break;
            case 26 :
                // InternalSoarLexer.g:1:386: HyphenMinus
                {
                mHyphenMinus(); 

                }
                break;
            case 27 :
                // InternalSoarLexer.g:1:398: FullStop
                {
                mFullStop(); 

                }
                break;
            case 28 :
                // InternalSoarLexer.g:1:407: Colon
                {
                mColon(); 

                }
                break;
            case 29 :
                // InternalSoarLexer.g:1:413: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 30 :
                // InternalSoarLexer.g:1:426: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 31 :
                // InternalSoarLexer.g:1:437: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 32 :
                // InternalSoarLexer.g:1:453: CommercialAt
                {
                mCommercialAt(); 

                }
                break;
            case 33 :
                // InternalSoarLexer.g:1:466: LeftSquareBracket
                {
                mLeftSquareBracket(); 

                }
                break;
            case 34 :
                // InternalSoarLexer.g:1:484: RightSquareBracket
                {
                mRightSquareBracket(); 

                }
                break;
            case 35 :
                // InternalSoarLexer.g:1:503: CircumflexAccent
                {
                mCircumflexAccent(); 

                }
                break;
            case 36 :
                // InternalSoarLexer.g:1:520: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 37 :
                // InternalSoarLexer.g:1:537: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 38 :
                // InternalSoarLexer.g:1:555: Tilde
                {
                mTilde(); 

                }
                break;
            case 39 :
                // InternalSoarLexer.g:1:561: RULE_SYM_CONSTANT_STRING
                {
                mRULE_SYM_CONSTANT_STRING(); 

                }
                break;
            case 40 :
                // InternalSoarLexer.g:1:586: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 41 :
                // InternalSoarLexer.g:1:598: RULE_PIPE_STRING
                {
                mRULE_PIPE_STRING(); 

                }
                break;
            case 42 :
                // InternalSoarLexer.g:1:615: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 43 :
                // InternalSoarLexer.g:1:623: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\1\uffff\4\34\1\47\3\34\1\55\1\61\1\63\1\66\1\34\24\uffff\1\34\1\uffff\2\34\2\uffff\2\34\1\77\1\34\2\uffff\1\102\10\uffff\1\103\7\34\1\uffff\1\34\3\uffff\15\34\1\131\1\132\1\133\5\34\3\uffff\1\34\1\142\2\34\1\145\1\34\1\uffff\1\34\1\150\1\uffff\1\151\1\152\3\uffff";
    static final String DFA11_eofS =
        "\153\uffff";
    static final String DFA11_minS =
        "\1\11\2\55\2\105\1\103\1\110\1\120\1\122\1\55\1\74\2\75\1\120\23\uffff\1\60\1\120\1\60\1\115\1\106\2\uffff\1\125\1\101\1\52\1\111\2\uffff\1\76\10\uffff\1\52\1\125\1\101\1\125\1\120\1\101\1\116\1\124\1\uffff\1\124\3\uffff\1\120\1\123\1\120\1\114\1\125\1\113\2\105\1\120\1\123\1\120\1\101\1\114\3\52\1\117\1\105\1\117\2\124\3\uffff\1\122\1\52\1\122\1\105\1\52\1\124\1\uffff\1\124\1\52\1\uffff\2\52\3\uffff";
    static final String DFA11_maxS =
        "\1\176\1\155\1\55\2\145\1\143\1\150\1\164\1\162\1\55\1\76\1\75\1\76\1\160\23\uffff\1\172\1\160\1\172\1\155\1\146\2\uffff\1\165\1\141\1\172\1\151\2\uffff\1\76\10\uffff\1\172\1\165\1\141\1\165\1\160\1\141\1\156\1\164\1\uffff\1\164\3\uffff\1\160\1\163\1\160\1\154\1\165\1\153\2\145\1\160\1\163\1\160\1\141\1\154\3\172\1\157\1\145\1\157\2\164\3\uffff\1\162\1\172\1\162\1\145\1\172\1\164\1\uffff\1\164\1\172\1\uffff\2\172\3\uffff";
    static final String DFA11_acceptS =
        "\16\uffff\1\24\1\25\1\27\1\30\1\31\1\33\1\34\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51\1\52\1\53\5\uffff\1\6\1\26\4\uffff\1\12\1\32\1\uffff\1\14\1\16\1\35\1\17\1\36\1\20\1\21\1\37\10\uffff\1\23\1\uffff\1\13\1\15\1\22\25\uffff\1\7\1\10\1\11\6\uffff\1\5\2\uffff\1\4\2\uffff\1\3\1\1\1\2";
    static final String DFA11_specialS =
        "\153\uffff}>";
    static final String[] DFA11_transitionS = DFA11_transitionS_.DFA11_transitionS;
    private static final class DFA11_transitionS_ {
        static final String[] DFA11_transitionS = {
                "\2\37\2\uffff\1\37\22\uffff\1\37\1\16\1\35\1\40\2\uffff\1\17\1\uffff\1\5\1\20\1\uffff\1\21\1\22\1\11\1\23\13\uffff\1\24\1\uffff\1\12\1\13\1\14\1\uffff\1\25\2\34\1\6\1\4\2\34\1\15\1\34\1\1\5\34\1\2\3\34\1\7\1\3\2\34\1\10\3\34\1\26\1\uffff\1\27\1\30\2\uffff\2\34\1\6\1\4\2\34\1\15\1\34\1\1\5\34\1\2\3\34\1\7\1\3\2\34\1\10\3\34\1\31\1\36\1\32\1\33",
                "\1\41\37\uffff\1\42\37\uffff\1\42",
                "\1\43",
                "\1\44\37\uffff\1\44",
                "\1\45\37\uffff\1\45",
                "\1\46\37\uffff\1\46",
                "\1\50\37\uffff\1\50",
                "\1\52\3\uffff\1\51\33\uffff\1\52\3\uffff\1\51",
                "\1\53\37\uffff\1\53",
                "\1\54",
                "\1\57\1\56\1\60",
                "\1\62",
                "\1\64\1\65",
                "\1\67\37\uffff\1\67",
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
                "",
                "\12\34\7\uffff\22\34\1\70\7\34\6\uffff\22\34\1\70\7\34",
                "\1\71\37\uffff\1\71",
                "\12\34\7\uffff\22\34\1\72\7\34\6\uffff\22\34\1\72\7\34",
                "\1\73\37\uffff\1\73",
                "\1\74\37\uffff\1\74",
                "",
                "",
                "\1\75\37\uffff\1\75",
                "\1\76\37\uffff\1\76",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\100\37\uffff\1\100",
                "",
                "",
                "\1\101",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\104\37\uffff\1\104",
                "\1\105\37\uffff\1\105",
                "\1\106\37\uffff\1\106",
                "\1\107\37\uffff\1\107",
                "\1\110\37\uffff\1\110",
                "\1\111\37\uffff\1\111",
                "\1\112\37\uffff\1\112",
                "",
                "\1\113\37\uffff\1\113",
                "",
                "",
                "",
                "\1\114\37\uffff\1\114",
                "\1\115\37\uffff\1\115",
                "\1\116\37\uffff\1\116",
                "\1\117\37\uffff\1\117",
                "\1\120\37\uffff\1\120",
                "\1\121\37\uffff\1\121",
                "\1\122\37\uffff\1\122",
                "\1\123\37\uffff\1\123",
                "\1\124\37\uffff\1\124",
                "\1\125\37\uffff\1\125",
                "\1\126\37\uffff\1\126",
                "\1\127\37\uffff\1\127",
                "\1\130\37\uffff\1\130",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\134\37\uffff\1\134",
                "\1\135\37\uffff\1\135",
                "\1\136\37\uffff\1\136",
                "\1\137\37\uffff\1\137",
                "\1\140\37\uffff\1\140",
                "",
                "",
                "",
                "\1\141\37\uffff\1\141",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\143\37\uffff\1\143",
                "\1\144\37\uffff\1\144",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\146\37\uffff\1\146",
                "",
                "\1\147\37\uffff\1\147",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "\1\34\2\uffff\1\34\2\uffff\12\34\7\uffff\32\34\4\uffff\1\34\1\uffff\32\34",
                "",
                "",
                ""
        };
    }

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( ISupport | OSupport | Template | Default | Impasse | Crlf | Chunk | State | Write | HyphenMinusHyphenMinusGreaterThanSign | LessThanSignEqualsSignGreaterThanSign | LessThanSignLessThanSign | LessThanSignEqualsSign | LessThanSignGreaterThanSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | GreaterThanSignGreaterThanSign | Gp | Sp | ExclamationMark | Ampersand | LeftParenthesis | RightParenthesis | PlusSign | Comma | HyphenMinus | FullStop | Colon | LessThanSign | EqualsSign | GreaterThanSign | CommercialAt | LeftSquareBracket | RightSquareBracket | CircumflexAccent | LeftCurlyBracket | RightCurlyBracket | Tilde | RULE_SYM_CONSTANT_STRING | RULE_STRING | RULE_PIPE_STRING | RULE_WS | RULE_SL_COMMENT );";
        }
    }
 

}