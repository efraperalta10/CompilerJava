/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String ruta1="C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/Lexer.flex";
        String ruta2="C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/Sintax.cup"};
        generarLexer(ruta1, ruta2, rutaS);
        /*IDE ide = new IDE();
        ide.setVisible(true);*/
        if(args.length > 0){
            File archivo = new File(args[0]);
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
            }
        }else{
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

        Path rutaSym = Paths.get("C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }
        Files.move(
            Paths.get("C:/Users/moy_r_000/Desktop/CompilerJava/sym.java"),
            Paths.get("C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
            Paths.get("C:/Users/moy_r_000/Desktop/CompilerJava/Sintax.java"),
            Paths.get("C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/Sintax.java")
        );
    }
}