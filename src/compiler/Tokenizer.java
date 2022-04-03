package compiler;

/**
 *
 * @author Moisés
 */
//Clase con Tokens, valor, linea, columna
public class Tokenizer {

    private final String valor; //VAR1
    private final Tokens tipo; //IDENTIFICADOR
    private final int line, column;

    public Tokenizer(String valor, Tokens tipo, int line, int column) {
        this.valor = valor;
        this.tipo = tipo;
        this.line = line;
        this.column = column;
    }

    public String getValor() {
        return valor;
    }

    public Tokens getTipo() {
        return tipo;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public String toString() {
        return "Tokenizer ( valor= " + valor + ", tipo= " + tipo + ", linea= " + line + ", columna= " + column + " )";
    }
}
