package compiler;

/**
 *
 * @author Moisés
 */
//Clase para manejar errores en orden de ejecucion
public class Errors {

    private final String valor, tipe; //VAR1
    private final Tokens tipo; //IDENTIFICADOR
    private final int line, column;

    public Errors(String valor, Tokens tipo, int line, int column, String tipe) {
        this.valor = valor;
        this.tipo = tipo;
        this.line = line;
        this.column = column;
        this.tipe = tipe;//tipo de error generado
    }

    public String getTipe() {
        return tipe;
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
