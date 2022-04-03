package compiler;

import java.util.Comparator;

/**
 *
 * @author Moisés
 */
//Clase para comparar con lineas de token con 'Comparator'
public class OrdenarLineas implements Comparator<Tokenizer> {

    //Comparamos tokens
    public int compare(Tokenizer token1, Tokenizer token2) {
        //donde si la linea del token1 es menor al token2
        if ((token1.getLine() < token2.getLine())) {
            return -1;
        } else if ((token1.getLine() < token2.getLine())) {
            return 0;
        } else {
            return 1;
        }
    }
}
