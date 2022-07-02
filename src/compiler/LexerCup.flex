package compiler;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
program {return new Symbol(sym.Program, yychar, yyline, yytext());}
if {return new Symbol(sym.If, yychar, yyline, yytext());}
else {return new Symbol(sym.Else, yychar, yyline, yytext());}
fi {return new Symbol(sym.Fi, yychar, yyline, yytext());}
do {return new Symbol(sym.Do, yychar, yyline, yytext());}
until {return new Symbol(sym.Until, yychar, yyline, yytext());}
read {return new Symbol(sym.Read, yychar, yyline, yytext());}
write {return new Symbol(sym.Write, yychar, yyline, yytext());}
float {return new Symbol(sym.Float, yychar, yyline, yytext());}
int {return new Symbol(sym.Int, yychar, yyline, yytext());}
bool {return new Symbol(sym.Bool, yychar, yyline, yytext());}
not {return new Symbol(sym.Not, yychar, yyline, yytext());}
and {return new Symbol(sym.And, yychar, yyline, yytext());}
or {return new Symbol(sym.Or, yychar, yyline, yytext());}
while {return new Symbol(sym.While, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"/*".*"*/" {/*Ignore*/}
"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"^" {return new Symbol(sym.Potencia, yychar, yyline, yytext());}
"<" {return new Symbol(sym.Menor, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.Menor_igual, yychar, yyline, yytext());}
">" {return new Symbol(sym.Mayor, yychar, yyline, yytext());}
">=" {return new Symbol(sym.Mayor_igual, yychar, yyline, yytext());}
"!=" {return new Symbol(sym.Diferente, yychar, yyline, yytext());}
"==" {return new Symbol(sym.Asignacion, yychar, yyline, yytext());}
";" {return new Symbol(sym.Punto_coma, yychar, yyline, yytext());}
"." {return new Symbol(sym.Punto, yychar, yyline, yytext());}
":" {return new Symbol(sym.Coma, yychar, yyline, yytext());}
"(" {return new Symbol(sym.Par_abre, yychar, yyline, yytext());}
")" {return new Symbol(sym.Par_cierre, yychar, yyline, yytext());}
"{" {return new Symbol(sym.Llave_abre, yychar, yyline, yytext());}
"}" {return new Symbol(sym.Llave_cierre, yychar, yyline, yytext());}
"main" {return new Symbol(sym.Main, yychar, yyline, yytext());}
then {return new Symbol(sym.Then, yychar, yyline, yytext());}
( true | false ) {return new Symbol(sym.Op_booleano, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
{D}+"."{D} {return new Symbol(sym.Decimal, yychar, yyline, yytext());}
 . {return new Symbol(sym.Error, yychar, yyline, yytext());}