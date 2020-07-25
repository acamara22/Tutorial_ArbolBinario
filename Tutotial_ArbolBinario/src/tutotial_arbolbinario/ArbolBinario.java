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
public class ArbolBinario {
    NodoArbol raiz;
    //el constructor solo inicializa la raiz en nulo
    public ArbolBinario(){
        raiz = null;
    }
    //metodo para insertar un nodo en el arbol
    public void AgregarNodo(int d, String nom){
        NodoArbol nuevo = new NodoArbol(d, nom);
        if(raiz==null){
            raiz = nuevo;
        }else{
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while(true){
                padre = auxiliar;//en la primera padre apunta a raiz
                if(d<auxiliar.dato){
                auxiliar = auxiliar.hijoIzquierdo;
                if(auxiliar == null){
                    //aca ya llego al final pa insertar
                    padre.hijoIzquierdo =nuevo;
                    return;//Se sale del metodo
                }
            }else{
                    auxiliar = auxiliar.hijoDerecho;
                    if(auxiliar == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    //Metodo para saber cuandoel arbol está vaciío
    public boolean estaVacio(){
        return raiz == null;
    }
    //metodo para recorrerel arbol INORDEN
    public void InOrden(NodoArbol r){
        if(r!=null){
                InOrden(r.hijoIzquierdo);
                System.out.print(r.dato+", ");
                InOrden(r.hijoIzquierdo);
        }
    }
    //metodo para recorrer el arbol PREORDEN
    public void PreOrden(NodoArbol r){
        if(r!=null){
            System.out.print(r.dato+", ");
            PreOrden(r.hijoIzquierdo);
            PreOrden(r.hijoDerecho);
        }
    }
    //metodo para recorrer el arbol POSTORDEN
    public void PostOrden(NodoArbol r){
        if(r!=null){
            PostOrden(r.hijoIzquierdo);
            PostOrden(r.hijoDerecho);
            System.out.print(r.dato+", ");
        }
    }
    
    //metodo para buscar un nodo en el arbol
    public NodoArbol buscarNodo(int d){
        NodoArbol aux = raiz;
        while(aux.dato!=d){
            if(d<aux.dato){
                aux=aux.hijoIzquierdo;
            }else{
                aux=aux.hijoDerecho;
            }
            if(aux == null){
                //llego al final y jamas lo encotró
                return null;
            }
        }
        return aux;
    }
    
    //METODO PARA ELIMINAR UN NODO DEL ARBOL
    public boolean Eliminar(int d){
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean esHijoIzquierdo=true;
        while(auxiliar.dato!=d){
            padre = auxiliar;
            if(d<auxiliar.dato){
                esHijoIzquierdo=true;
                auxiliar = auxiliar.hijoIzquierdo;
            }else{
                esHijoIzquierdo = false;
                auxiliar = auxiliar.hijoDerecho;
            }
            if(auxiliar == null){//llego al final y no lo encontró
                return false;
            }
        }//fin del while
        if(auxiliar.hijoIzquierdo == null && auxiliar.hijoDerecho == null){
            //este nodo es hoja
            if(auxiliar == raiz){//si solo existitiera la raiz
                raiz = null;
            }
            else if(esHijoIzquierdo){
                padre.hijoIzquierdo=null;
            }else{
                padre.hijoDerecho = null; 
            }
        }else if(auxiliar.hijoDerecho == null){ //
            if(auxiliar == raiz){//si solo existitiera la raiz
                raiz = auxiliar.hijoIzquierdo;
            }
            else if(esHijoIzquierdo){
                padre.hijoIzquierdo=auxiliar.hijoIzquierdo;
            }else{
                padre.hijoDerecho = auxiliar.hijoDerecho; 
            }
        }else if(auxiliar.hijoIzquierdo == null){
            if(auxiliar == raiz){//si solo existitiera la raiz
                raiz = auxiliar.hijoDerecho;
            }
            else if(esHijoIzquierdo){
                padre.hijoIzquierdo=auxiliar.hijoDerecho;
            }else{
                padre.hijoDerecho = auxiliar.hijoIzquierdo; 
            }
        }else{//buscamos el nodo reempelazo
            NodoArbol reempleazo = obtenerNodoReempleazo(auxiliar);
            if(auxiliar == raiz){
                raiz = reempleazo;
            }else if(esHijoIzquierdo){
            padre.hijoIzquierdo = reempleazo;
        }else{
                padre.hijoDerecho=reempleazo;
            }
            reempleazo.hijoIzquierdo = auxiliar.hijoIzquierdo;
        }
        return true;
    }
    
    //metodo encargado de devolvernos el nodo reemplazo
    public NodoArbol obtenerNodoReempleazo(NodoArbol nodoReemp){
        NodoArbol reemplazarPadre = nodoReemp;
        NodoArbol reemplazo = nodoReemp;
        NodoArbol auxiliar = nodoReemp.hijoDerecho;
        while(auxiliar != null){
            reemplazarPadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.hijoIzquierdo;
        }
        if(reemplazo != nodoReemp.hijoDerecho){
            reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
            reemplazo.hijoDerecho=nodoReemp.hijoDerecho;
        }
        System.out.println("El nodo reemplazo es "+ reemplazo);
        return reemplazo;
    }
}
