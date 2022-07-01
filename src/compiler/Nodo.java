package compiler;

import java.util.ArrayList;

/**
 *
 * @author Moisés
 */
public class Nodo {
    public String etiqueta;
    public ArrayList<Nodo> hijos = new ArrayList<>();
    public String valor;
    public int idNod;

    public void addHijos(Nodo hijo){
        hijos.add(hijo);
    }

    public ArrayList<Nodo> getHijos(){
        return hijos;
    }

    public void setEtiqueta(String etiqueta){
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta(){
        return etiqueta;
    }

    public void setId(int idNod){
        this.idNod = idNod;
    }

    public int getId(){
        return idNod;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    public String getValor(){
        return valor;
    }
}
