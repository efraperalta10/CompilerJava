/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 * @author efrap
 */
public class Compiler {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        String ruta1="C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/Lexer.flex";
        String ruta2="C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/Sintax.cup"};
        //generarLexer(ruta1, ruta2, rutaS);
        //generarLexerCmd(ruta1, ruta2, rutaS);
        /*IDE ide = new IDE();
        ide.setVisible(true);*/
        if(args.length > 0){
            generarLexerCmd(ruta1, ruta2, rutaS);
            /*File archivo = new File(args[0]);
            System.out.println("\n***Analizador Lexicografico***\nArgumento: "+args[0]);
            try{
                Reader lector = new BufferedReader(new FileReader(args[0]));
                Lexer lexer = new Lexer(lector);
                String resultado = "";
                while(true){
                    Tokens tokens = lexer.yylex();
                    if(tokens ==null){
                        resultado +="FIN";
                        //txtResultado.setText(resultado);
                        System.out.println(resultado);
                        return;
                    }
                    switch (tokens) {
                        case Error:
                            resultado += "Simbolo no definido\n";
                            break;
                        case Identificador: case Numero: case Decimal:
                            resultado += lexer.lexeme + ": Es un " + tokens + "\n";
                            break;
                        default:
                            resultado += "Token: " + tokens + "\n";
                            break;
                    }
                }
            }catch(FileNotFoundException ex){
                System.out.println("Error leer archivo.txt" + ex);
            } catch (IOException ex) {
                Logger.getLogger(IDE.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            mostrarSintacticoCmd(args);
            mostrarLexicoCmd(args);
            System.out.println("-->ANALISIS COMPLETADOS");
        }else{
            generarLexer(ruta1, ruta2, rutaS);
            System.out.println("\nNo argumentos. Abriendo IDE...");
            IDE ide = new IDE();
            ide.setVisible(true);
        }
    }

    public static void generarLexer(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

        Path rutaSym = Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/sym.java"),
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/Sintax.java"),
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/Sintax.java")
        );
    }

    public static void generarLexerCmd(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaS);

        Path rutaSym = Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/dist/sym.java"),
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/dist/Sintax.java"),
            Paths.get("C:/Users/moy_r/OneDrive/Escritorio/CompilerJava/src/compiler/Sintax.java")
        );
    }

    public static void mostrarSintacticoCmd(String[] args) throws FileNotFoundException{
        //SINTACTICO CMD
        Reader lector = new BufferedReader(new FileReader(args[0]));
        Sintax s = new Sintax(new compiler.LexerCup(lector));
        System.out.println("\n***Analizador Sintactico***\nArgumento: " + args[0]);
        try {
            s.parse();
            System.out.println("Analisis realizado OK\n");
            //txtAnalizarSin.setText("Analisis realizado OK");
            //txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            System.out.println("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"\n");
            //txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            //txtAnalizarSin.setForeground(Color.red);
        }
    }
    
    public static void mostrarLexicoCmd(String[] args) throws FileNotFoundException, IOException{
        //LEXICO CMD
        int cont = 1;
        Reader lector = new BufferedReader(new FileReader(args[0]));
        Lexer lexer = new Lexer(lector);

        /*String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));*/
        System.out.println("\n***Analizador Lexicografico***\nArgumento: "+args[0]);
        String resultado = "LINEA " + cont + "\t\t\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                //txtAnalizarLex.setText(resultado);
                System.out.println(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Program:
                    resultado += "  <Reservada program>\t\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t\t" + lexer.lexeme + "\n";
                    break;
                case Fi:
                    resultado += "  <Reservada fi>\t\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t\t" + lexer.lexeme + "\n";
                    break;
                case Until:
                    resultado += "  <Reservada until>\t\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t\t" + lexer.lexeme + "\n";
                    break;
                case Read:
                    resultado += "  <Reservada read>\t\t" + lexer.lexeme + "\n";
                    break;
                case Write:
                    resultado += "  <Reservada write>\t\t" + lexer.lexeme + "\n";
                    break;
                case Float:
                    resultado += "  <Reservada float>\t\t" + lexer.lexeme + "\n";
                    break;
                case Int:
                    resultado += "  <Reservada int>\t\t" + lexer.lexeme + "\n";
                    break;
                case Bool:
                    resultado += "  <Reservada booleano>\t\t" + lexer.lexeme + "\n";
                    break;
                case Not:
                    resultado += "  <Reservada not>\t\t" + lexer.lexeme + "\n";
                    break;
                case And:
                    resultado += "  <Reservada and>\t\t" + lexer.lexeme + "\n";
                    break;
                case Or:
                    resultado += "  <Reservada or>\t\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t\t" + lexer.lexeme + "\n";
                    break;
                case Potencia:
                    resultado += "  <Operador potencia>\t\t" + lexer.lexeme + "\n";
                    break;
                case Menor:
                    resultado += "  <Operador menor>\t\t" + lexer.lexeme + "\n";
                    break;
                case Menor_igual:
                    resultado += "  <Operador menor_igual>\t" + lexer.lexeme + "\n";
                    break;
                case Mayor:
                    resultado += "  <Operador mayor>\t\t" + lexer.lexeme + "\n";
                    break;
                case Mayor_igual:
                    resultado += "  <Operador mayor_igual>\t" + lexer.lexeme + "\n";
                    break;
                case Asignacion:
                    resultado += "  <Operador asignacion>\t\t" + lexer.lexeme + "\n";
                    break;
                case Diferente:
                    resultado += "  <Operador diferente>\t\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t\t" + lexer.lexeme + "\n";
                    break;
                case Punto_coma:
                    resultado += "  <Operador punto_coma>\t\t" + lexer.lexeme + "\n";
                    break;
                case Coma:
                    resultado += "  <Operador coma>\t\t" + lexer.lexeme + "\n";
                    break;
                /*case Punto:
                    resultado += "  <Operador punto>\t\t" + lexer.lexeme + "\n";
                    break;*/
                case Par_abre:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Par_cierre:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_abre:
                    resultado += "  <Llave de apertura>\t\t" + lexer.lexeme + "\n";
                    break;
                case Llave_cierre:
                    resultado += "  <Llave de cierre>\t\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                /*case Decimal:
                    resultado += "  <Decimal>\t\t" + lexer.lexeme + "\n";
                    break;*/
                case Error:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }
}