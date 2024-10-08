/*
 * Copyright (c) 2024, Collins Aerospace.
 * Developed with the sponsorship of Defense Advanced Research Projects Agency (DARPA).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this data, 
 * including any software or models in source or binary form, as well as any drawings, specifications, 
 * and documentation (collectively "the Data"), to deal in the Data without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, 
 * and/or sell copies of the Data, and to permit persons to whom the Data is furnished to do so, 
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Data.
 * 
 * THE DATA IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT 
 * LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
 * IN NO EVENT SHALL THE AUTHORS, SPONSORS, DEVELOPERS, CONTRIBUTORS, OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, 
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE DATA OR THE USE OR OTHER DEALINGS IN THE DATA.
 *
 * Generated by Xtext version 2.33.0.
 */

lexer grammar InternalSoarLexer;

@header {
package com.collins.trustedmethods.matrics.soar.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

ISupport : ('I'|'i')'-'('S'|'s')('U'|'u')('P'|'p')('P'|'p')('O'|'o')('R'|'r')('T'|'t');

OSupport : ('O'|'o')'-'('S'|'s')('U'|'u')('P'|'p')('P'|'p')('O'|'o')('R'|'r')('T'|'t');

Template : ('T'|'t')('E'|'e')('M'|'m')('P'|'p')('L'|'l')('A'|'a')('T'|'t')('E'|'e');

Default : ('D'|'d')('E'|'e')('F'|'f')('A'|'a')('U'|'u')('L'|'l')('T'|'t');

Impasse : ('I'|'i')('M'|'m')('P'|'p')('A'|'a')('S'|'s')('S'|'s')('E'|'e');

Crlf : '('('C'|'c')('R'|'r')('L'|'l')('F'|'f')')';

Chunk : ('C'|'c')('H'|'h')('U'|'u')('N'|'n')('K'|'k');

State : ('S'|'s')('T'|'t')('A'|'a')('T'|'t')('E'|'e');

Write : ('W'|'w')('R'|'r')('I'|'i')('T'|'t')('E'|'e');

QuotationMarkQuotationMarkQuotationMark : '"''"''"';

HyphenMinusHyphenMinusGreaterThanSign : '-''-''>';

LessThanSignEqualsSignGreaterThanSign : '<''=''>';

LessThanSignLessThanSign : '<''<';

LessThanSignEqualsSign : '<''=';

LessThanSignGreaterThanSign : '<''>';

EqualsSignEqualsSign : '=''=';

GreaterThanSignEqualsSign : '>''=';

GreaterThanSignGreaterThanSign : '>''>';

Gp : ('G'|'g')('P'|'p');

Sp : ('S'|'s')('P'|'p');

ExclamationMark : '!';

Ampersand : '&';

LeftParenthesis : '(';

RightParenthesis : ')';

Asterisk : '*';

PlusSign : '+';

Comma : ',';

HyphenMinus : '-';

FullStop : '.';

Solidus : '/';

Colon : ':';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

CommercialAt : '@';

LeftSquareBracket : '[';

RightSquareBracket : ']';

CircumflexAccent : '^';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

Tilde : '~';

RULE_SYM_CONSTANT_STRING : ('a'..'z'|'A'..'Z') ('_'? '*'? '-'? ('a'..'z'|'A'..'Z'|'0'..'9'))*;

RULE_PRINT_STRING : '|' ('\\|'|~('|'))* '|';

RULE_FLOAT : ('0'..'9')+ '.' ('0'..'9')+;

RULE_INT : ('0'..'9')+;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_SL_COMMENT : '#' ~(('\n'|'\r'))* ('\r'? '\n')?;
