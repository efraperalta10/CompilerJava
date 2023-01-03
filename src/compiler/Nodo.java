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
    public String tipo;

    public Nodo(String etiqueta) {
        setEtiqueta(etiqueta);
        hijos = new ArrayList<>();
        setIdNod(0);
    }

    public void addHijos(Nodo hijo) {
        hijos.add(hijo);
    }

    public ArrayList<Nodo> getHijos() {
        return hijos;
    }
    
    public void setHijos(ArrayList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setIdNod(int idNod) {
        this.idNod = idNod;
    }

    public int getIdNod() {
        return idNod;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
