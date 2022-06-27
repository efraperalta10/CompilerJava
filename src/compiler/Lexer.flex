package compiler;
import static compiler.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
program {lexeme=yytext(); return Program;}
if {lexeme=yytext(); return If;}
else {lexeme=yytext(); return Else;}
fi {lexeme=yytext(); return Fi;}
do {lexeme=yytext(); return Do;}
until {lexeme=yytext(); return Until;}
read {lexeme=yytext(); return Read;}
write {lexeme=yytext(); return Write;}
float {lexeme=yytext(); return Float;}
int {lexeme=yytext(); return Int;}
bool {lexeme=yytext(); return Bool;}
not {lexeme=yytext(); return Not;}
and {lexeme=yytext(); return And;}
or {lexeme=yytext(); return Or;}
while {lexeme=yytext(); return While;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"/*".*"*/" {/*Ignore*/}
"\n" {return Linea;}
"=" {lexeme=yytext(); return Igual;}
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}
"^" {lexeme=yytext(); return Potencia;}
"<" {lexeme=yytext(); return Menor;}
"<=" {lexeme=yytext(); return Menor_igual;}
">" {lexeme=yytext(); return Mayor;}
">=" {lexeme=yytext(); return Mayor_igual;}
"!=" {lexeme=yytext(); return Diferente;}
"==" {lexeme=yytext(); return Asignacion;}
";" {lexeme=yytext(); return Punto_coma;}
"." {lexeme=yytext(); return Punto;}
":" {lexeme=yytext(); return Coma;}
"(" {lexeme=yytext(); return Par_abre;}
")" {lexeme=yytext(); return Par_cierre;}
"{" {lexeme=yytext(); return Llave_abre;}
"}" {lexeme=yytext(); return Llave_cierre;}
"main" {lexeme=yytext(); return Main;}
then {lexeme = yytext(); return Then;}
(true | false) {lexeme = yytext(); return Op_booleano;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
{D}+"."{D} {lexeme=yytext(); return Decimal;}
 . {return Error;}