/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.uthh.edd.unidad2;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Ariadna Yenisey
 */
public class SistemaDeCalificaciones {

    /**
     * @param args the command line arguments
     */
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ListaLigada lista = new ListaLigada();
        int[] valores = {7, 4, 8, 1, 3, 2, 2};
        int opcion;

        do {
            System.out.println("\n===== MENÚ DE CALIFICACIONES =====");
            System.out.println("1. Insertar calificación (ordenada)");
            System.out.println("2. Consultar calificación mínima");
            System.out.println("3. Consultar calificación máxima");
            System.out.println("4. Consultar calificación mediana");
            System.out.println("5. Consultar calificación en cualquier posición");
            System.out.println("6. Corregir una calificación");
            System.out.println("7. Eliminar calificación inválida");
            System.out.println("8. Buscar si alguien sacó una calificación");
            System.out.println("9. Ver total de estudiantes (tamaño)");
            System.out.println("10. Ver todas las calificaciones");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la calificación: ");
                    lista.insertarOrdenado(teclado.nextInt());
                    System.out.println("Calificación agregada.");
                    break;
                case 2:
                    System.out.println("Calificación mínima: " + lista.obtenerMinima());
                    break;
                case 3:
                    System.out.println("Calificación máxima: " + lista.obtenerMaxima());
                    break;
                case 4:
                    System.out.println("Calificación mediana: " + lista.obtenerMediana());
                    break;
                case 5:
                    System.out.print("Ingresa la posición (empezando en 1): ");
                    int pos = teclado.nextInt();
                    System.out.println("Calificación en posición " + pos + ": " + lista.obtenerNodo(pos));
                    break;
                case 6:
                    System.out.print("Calificación errónea a corregir: ");
                    int vieja = teclado.nextInt();
                    System.out.print("Nueva calificación correcta: ");
                    int nueva = teclado.nextInt();
                    System.out.println(lista.corregirCalificacion(vieja, nueva)
                            ? "Calificación corregida."
                            : "No se encontró la calificación a corregir.");
                    break;
                case 7:
                    System.out.print("Calificación a eliminar: ");
                    int eliminado = teclado.nextInt();
                    System.out.println(lista.eliminarPorValor(eliminado)
                            ? "Calificación eliminada."
                            : "No encontrada.");
                    break;
                case 8:
                    System.out.print("Calificación a buscar: ");
                    int buscado = teclado.nextInt();
                    System.out.println(lista.buscar(buscado)
                            ? "Sí está en la lista."
                            : "No está en la lista.");
                    break;
                case 9:
                    System.out.println("Total de estudiantes: " + lista.getTamanio());
                    break;
                case 10:
                    lista.mostrar();
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 0);

        teclado.close();
    }
    
}

