package compiler;
import static compiler.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
program |
if |
else |
fi |
do |
until |
read |
write |
float |
int |
bool |
not |
and |
or |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"/*".*"*/" {/*Ignore*/}
"=" {return ASIGNACION;}
"+" {return Suma;}
"-" {return Resta;}
"*" {return Multiplicacion;}
"/" {return Division;}
"^" {return Potencia;}
"<" {return MENOR;}
"<=" {return MENORIGUAL;}
">" {return MAYOR;}
">=" {return MAYORIGUAL;}
"!=" {return DIFERENTE;}
"==" {return Igual;}
";" {return PUNTOCOMA;}
"." {return PUNTO;}
"," {return COMA;}
"(" {return PAR_ABRE;}
")" {return PAR_CIERRE;}
"{" {return LLAV_ABRE;}
"}" {return LLAV_CIERRE;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
{D}+"."{D} {lexeme=yytext(); return Decimal;}
 . {return ERROR;}
