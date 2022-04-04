/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

import java.io.File;

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
        IDE ide = new IDE();
        ide.setVisible(true);
    }

    public static void generarLexer(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
}