/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutotial_arbolbinario;

import javax.swing.JOptionPane;

/**
 *
 * @author Andrea Cámara
 */
public class Tutotial_ArbolBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0, elemento;
        String nombre;
        ArbolBinario arbolito = new ArbolBinario();
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar Nodo\n"+
                        "2. Recorrer el árbol InOrden\n"+
                        "3. Recorrer el árbol en PreOrden\n"+
                        "4. Recorrer el árbol en PostOrden\n"+
                        "5. Buscar un nodo en el arbol \n"+
                        "6. Eliminar un nodo del árbol\n"+
                        "7. Salir\n"+
                        "Elige una opcion...",
                        "Arboles Binarios",JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo...","Agregando Nodo"
                                ,JOptionPane.QUESTION_MESSAGE));
                        nombre = JOptionPane.showInputDialog(null, "Ingresa el nombre del nodo...","Agregando Nodo"
                                ,JOptionPane.QUESTION_MESSAGE);
                        arbolito.AgregarNodo(elemento,nombre);
                        break;
                    case 2:
                        if(!arbolito.estaVacio()){
                            System.out.println();
                            arbolito.InOrden(arbolito.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,"El árbol está vacío","Cuidado!"
                                    ,JOptionPane.INFORMATION_MESSAGE); 
                        }
                        break;
                    case 3:
                        if(!arbolito.estaVacio()){
                            System.out.println();
                            arbolito.PreOrden(arbolito.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,"El árbol está vacío","Cuidado!"
                                    ,JOptionPane.INFORMATION_MESSAGE); 
                        }
                        break;
                    case 4:
                         if(!arbolito.estaVacio()){
                             System.out.println();
                            arbolito.PostOrden(arbolito.raiz);
                        }else{
                            JOptionPane.showMessageDialog(null,"El árbol está vacío","Cuidado!"
                                    ,JOptionPane.INFORMATION_MESSAGE); 
                        }
                        break;
                    case 5:
                        if(!arbolito.estaVacio()){
                             elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo buscado...","Buscando Nodo"
                                ,JOptionPane.QUESTION_MESSAGE));
                             //arbolito.buscarNodo(elemento);
                             
                             if(arbolito.buscarNodo(elemento)== null){//aca no lo encontro
                                 JOptionPane.showMessageDialog(null,"Nodo no encontado en árbol","Nodo no econtrado!"
                                    ,JOptionPane.INFORMATION_MESSAGE);
                             }else{//si lo encuentra entonces publico datos
                                 System.out.println("Nodo encontrado, sus datos son: "+arbolito.buscarNodo(elemento));
                             }
                        }else{
                             JOptionPane.showMessageDialog(null,"El árbol está vacío","Cuidado!"
                                    ,JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 6:
                         if(!arbolito.estaVacio()){
                             elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el numero del nodo eliminar...","Eliminando Nodo"
                                ,JOptionPane.QUESTION_MESSAGE));
                             //arbolito.buscarNodo(elemento);
                             
                             if(arbolito.Eliminar(elemento)==false){//aca no lo encontro
                                 JOptionPane.showMessageDialog(null,"Nodo no encontado en árbol","Nodo no econtrado!"
                                    ,JOptionPane.INFORMATION_MESSAGE);
                             }else{//si lo encuentra entonces publico datos
                                 JOptionPane.showMessageDialog(null,"El nodo ha sido eliminado del árbol","Nodo Eliminado!"
                                    ,JOptionPane.INFORMATION_MESSAGE);
                             }
                        }else{
                             JOptionPane.showMessageDialog(null,"El árbol está vacío","Cuidado!"
                                    ,JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Aplicacion finalizada","FIN",JOptionPane.INFORMATION_MESSAGE);
                        break;
                        default:
                            JOptionPane.showMessageDialog(null,"Opcion Incorrecta","Cuidado!",JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null,"Error "+n.getMessage());
            }
        }while(opcion!=2);
    }
    
}
