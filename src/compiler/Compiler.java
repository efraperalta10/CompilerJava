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
    
    public static void main(String[] args) {
        // TODO code application logic here
        String ruta="C:/Users/moy_r_000/Desktop/CompilerJava/src/compiler/Lexer.flex";
        generarLexer(ruta);
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
                        case ERROR:
                            resultado += "Simbolo no definido\n";
                            break;
                        case Identificador: case Numero: case Reservadas:
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

    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}