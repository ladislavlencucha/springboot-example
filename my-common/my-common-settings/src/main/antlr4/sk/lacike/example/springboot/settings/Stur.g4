grammar Stur;

sentence
    : (hardLetterToSoft|brackets|anyChar)* EOF
    ;

brackets
    : '(' (SOFTENED|ANY_CHAR)* ')'
    | '{' (SOFTENED|ANY_CHAR)* '}'
    ;

hardLetterToSoft
    : SOFTENED
    ;

anyChar
    : ANY_CHAR
    ;

ANY_CHAR : [\u0000-\u007F];
SOFTENED : ('de'|'te'|'ne'|'le'|'di'|'ti'|'ni'|'li'|'dí'|'tí'|'ní'|'lí');