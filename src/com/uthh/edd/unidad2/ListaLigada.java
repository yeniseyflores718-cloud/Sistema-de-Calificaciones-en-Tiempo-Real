/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2;

/**
 *
 * @author Ariadna Yenisey
 */
public class ListaLigada {
    private nodo cabeza;   // primer nodo de la lista
    private int tamanio;
    public ListaLigada() {
        this.cabeza = null;
        this.tamanio = 0;
    }
    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamanio() {
        return tamanio;
    }
    public void insertarInicio(int valor) {
        nodo nuevo = new nodo(valor);
        nuevo.siguiente = cabeza;   // el nuevo apunta al antiguo primero
        cabeza = nuevo;             // el nuevo pasa a ser la cabeza
        tamanio++;
    }
     public void insertarOrdenado(int dato){
         if(estaVacia()){
            insertarInicio(dato);
            return;
        }
         //caso b) el nuevo dato es menor o igual al inicio
         if (dato<=cabeza.getDato()){
             insertarInicio(dato);
             return;
         }
       //caso c) el nuevo dato es mayor que todos igual se resuelve el caso d) de insertar en medio
         else {
            nodo nuevo= new nodo(dato);
            nodo aux = cabeza;
            while (aux.getsiguiente()!= null && aux.getsiguiente().getDato()< dato ) {
                aux = aux.getsiguiente();   // avanzar hasta el último nodo
            }
            nuevo.setsiguiente(aux.getsiguiente());
            aux.setsiguiente(nuevo);
        }
        tamanio++;     
    }
     //buscar un valor
     public boolean buscar(int valor) {
        nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato == valor) {
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
      public int obtenerNodo(int pocision){
        //buscar un nodo que este fuera del rango(menos que 0 mayor que el tamaño)
        if(pocision<=0 || pocision>tamanio){
            throw new IllegalStateException("El valor que estás insertando está fuera de rango");
        }
        //
        nodo aux=cabeza;
        for(int i=1;i<pocision; i++){
            aux=aux.getsiguiente();
        }
        return aux.getDato();
    }
      public int obtenerMinima(){
          return obtenerNodo(1);
      }
      public int obtenerMaxima(){
          return obtenerNodo(tamanio);
      }
      public double obtenerMediana(){
          if(tamanio%2==0){
              double num1= obtenerNodo(tamanio/2);
              double num2= obtenerNodo((tamanio / 2) + 1);
              double res=(num1 + num2)/2;
              return res;
          }else{
              return obtenerNodo((tamanio / 2) + 1);
          }
      }
      //eliminar calificaciones invalidas
      public boolean eliminarPorValor(int valor){
        //validamos si la lista esta vacia
        if(estaVacia()){
           return false; 
        }
         //caso 2 el valor esta justo al inicio de la lista
         if(cabeza.getDato()==valor){
             cabeza=cabeza.getsiguiente();
             tamanio--;
             return true;
         }
         nodo aux=cabeza;
         while(aux.getsiguiente()!=null){
             if (aux.getsiguiente().getDato()==valor){
                 aux.setsiguiente(aux.getsiguiente().getsiguiente());
                 tamanio--;
                 return true;  
                 
             }
             aux=aux.getsiguiente();
         }   
         return false;
    }
      public boolean corregirCalificacion(int calificacionVieja, int calificacionNueva){
         if (eliminarPorValor(calificacionVieja)) {
        insertarOrdenado(calificacionNueva);
        return true;
    }
    return false;
      }
      public void mostrar() {
        if (estaVacia()) {
            System.out.println("(lista vacía)");
            return;
        }
        nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato);
            if (actual.siguiente != null) {
                System.out.print(" -> ");
            }
            actual = actual.siguiente;
        }
        System.out.println();
    }
}
