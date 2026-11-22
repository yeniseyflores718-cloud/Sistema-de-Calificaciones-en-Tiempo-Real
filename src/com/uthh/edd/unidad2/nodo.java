/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.uthh.edd.unidad2;

/**
 *
 * @author Ariadna Yenisey
 */
public class nodo {
     int dato;          // valor almacenado en el nodo
    nodo siguiente;     // referencia al siguiente nodo (null si es el último)
    
    
    
  //definimos osmconstrucotres especificos, uno para nsertar al inicio y otro
    //para incertar al final de la fila
    
    //constructor
    
    public nodo(int dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    public nodo(int x, nodo sig){
        dato= x;
        siguiente=sig;
    }
    //Definomos nuestras propiedades de acceso, getter y setters tanto para nodo como para dato
    public void setDato(int x ){
        dato=x;
    }
    public int getDato(){
        return dato;
    }
    public void setsiguiente(nodo sig ){
        siguiente=sig;
    }
    public nodo getsiguiente(){
        return siguiente;
    }
}

