/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutotial_arbolbinario;

/**
 *
 * @author Andrea Cámara
 */
public class NodoArbol {
    int dato;
    //punteros
    NodoArbol hijoIzquierdo;
    NodoArbol hijoDerecho;
    String nombreNodo;
    
    //contructr
    public NodoArbol(int d, String nom){
        this.dato=d;
        this.nombreNodo = nom;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
    
    public String toString(){
        return nombreNodo + "su dato es "+ dato;
    }
}
