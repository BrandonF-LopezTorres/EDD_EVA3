/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_3_busqueda_bin;

import java.util.Scanner;

/**
 *
 * @author branf
 */
public class EVA3_3_BUSQUEDA_BIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arregloDatos = new int[15];
        llenar(arregloDatos);
        selectionSort(arregloDatos);
        System.out.println("Arreglo:");
        imprimir(arregloDatos);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("Introduce el valor a buscar:");
        int buscar = sc.nextInt();
        System.out.println("");
        System.out.println("El valor esta en " + busquedaBinaria(arregloDatos, buscar));
        
    }
    
    public static void selectionSort(int[] arreglo){        
        for (int i = 0; i < arreglo.length; i++) {
            int minimo = i;
            //Busqueda de posicion del elemento mas pequeño
            for (int j = (i+1); j < arreglo.length; j++) {
                //Buscar el mas pequeño
                if(arreglo[minimo] > arreglo[j]){
                    minimo = j;
                }
            }
            //Swap intercambiar
            if(minimo != i){
                int temp = arreglo[i];
                arreglo[i] = arreglo[minimo];
                arreglo[minimo] = temp;
            }
        }
    }
    
    public static void llenar (int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random() * 100);
        }
    }
    
    //immprimir arreglo
    public static void imprimir (int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            if(arreglo[i] < 10){
                System.out.print("[" + arreglo[i] + "]");
            } else {
                System.out.print("[" + arreglo[i] + "]");
            }            
        }
    }
    
    //Busqueda Binaria
    public static int busquedaBinaria(int[] datos, int valor){
        return busquedaBinRec(datos, 0, datos.length - 1, valor);
    }
    
    private static int busquedaBinRec(int[] datos, int ini, int fin, int valor){
        int mitad = ini + ((fin-ini)/2);
        int resu = -1;
        if(ini<fin){//Aqui hacemos la busqueda binaria
            if(valor == datos[mitad])
                resu = mitad;
                
             else if (valor < datos[mitad])
                resu = busquedaBinRec(datos, ini, mitad-1, valor);
             else 
                resu = busquedaBinRec(datos, mitad+1, fin, valor);
            
        }
        return resu;
    }
    
}