package analisador;
import static analisador.Token.*;
%%
%class Lexer
%type Token
ALFABETO = [a-zA-Z_]
NUMEROSS = [0-9]
BRANCO=[ \t\r\n]
%{
public String lexeme;
%}
%%
{BRANCO} {/*Ignore*/}

/* Esta é a lista de palavras reservadas definidas até a versão 7 da linguagem. (JAVA) */
(package | import | new | class | class | interface | enum
 | abstract | final | implements | extends | instanceof | public | private
 | protected | super | this | throw | throws | try | catch | finally
 | if | else | for | do | while | switch | case | default | break
 | continue | return | boolean | byte | short | int | long | double | float
 | char | void | strictfp | transient | volatile | synchronized | native | assert | static 
 | goto | true | false | null ) {lexeme = yytext(); return PALAVRA_RESERVADA;}

(\b | "\t" | "\n" | "\f")   {lexeme = yytext(); return SEQ_ESCAPE;}

( "+" | "-" | "*" | "/" | "%" )    {lexeme = yytext(); return OP_ARITMETICO;}

("&&" | "||" | "!" | "&" | "|" )    {lexeme = yytext(); return OP_LOGICO;}

( "//" | "/*" | "*/")     {lexeme = yytext(); return COMENTAR;}

(">" | "<" | "==" | "!=" | ">=" | "<=" | "<<" | ">>")   {lexeme = yytext(); return OP_RELACIONAL;}

("+=" | "-="  | "*=" | "/=" | "%=" | "++" | "--" | "=")      {lexeme = yytext(); return OP_ATRIBUICAO;}

(true | false)      {lexeme=yytext(); return OP_BOOLEAN;}

("(" | ")" | "{" | "}" | "[" | "]" | ";" | "," |  "." |  "\"")      {lexeme = yytext(); return SEPARADORES;}

{L}({L}|{X})* {lexeme=yytext(); return ID;}

("(-"{X}+")")|{X}+ {lexeme=yytext(); return NUM;}




. {return ERROR;}