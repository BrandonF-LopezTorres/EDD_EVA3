/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_1_ordenamientos;

/**
 *
 * @author moviles
 */
public class EVA3_1_ORDENAMIENTOS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[]array = new int[15];
        llenar(array);
        System.out.println("Arreglo a ordenar:");
        imprimir(array);
        
        System.out.println("");
        System.out.println("");
        System.out.println("arreglo ordenado con SELECTION SORT:");
        double ini = System.nanoTime();
        selectionSort(array);
        double fin = System.nanoTime();
        imprimir(array);
        System.out.println("");
        System.out.println("Tiempo de ejecuccion: " + (fin-ini));
                
        System.out.println("");
        System.out.println("arreglo ordenado con INSERTION SORT:");
        ini = System.nanoTime();
        insertionSort(array);
        fin = System.nanoTime();
        imprimir(array);
        System.out.println("");
        System.out.println("Tiempo de ejecuccion: " + (fin-ini));
        
        System.out.println("");
        System.out.println("arreglo ordenado con QUICK SORT:");
        ini = System.nanoTime();
        quickSort(array);
        fin = System.nanoTime();
        imprimir(array);
        System.out.println("");
        System.out.println("Tiempo de ejecuccion: " + (fin-ini));
        
        /*
        int[] arregloDatos = new int[15];  
        System.out.println("ARREGLO ORIGINAL:");
        llenar(arregloDatos);
        imprimir(arregloDatos);
        System.out.println("");
        
        int[]arreglosel = new int [arregloDatos.length];
        System.out.println("");
        System.out.println("SELECTION SORT:");
        copiar(arregloDatos, arreglosel);
                               
        double ini = System.nanoTime();
        System.out.println("Arreglo Ordenado:");
        selectionSort(arreglosel);
        double fin = System.nanoTime();
        imprimir(arreglosel);
        System.out.println("");
        System.out.println("Nanosegundos que le toma ordenar: " + (fin - ini));
        
        System.out.println("INSERTION SORT:");
        copiar(arregloDatos, arreglosel);
        System.out.println("Arreglo a ordenar: ");
        imprimir(arreglosel);
        ini = System.nanoTime();
        insertionSort(arreglosel);
        fin = System.nanoTime();
        System.out.println("");
        System.out.println("Arreglo ordenado: ");
        imprimir(arreglosel);
        System.out.println("");
        System.out.println("Tiempo que toma el algoritmo: " + (fin - ini));
        
        System.out.println("");
        System.out.println("QUICK SORT:");
        int[] arregloGrande = new int[15]; 
        llenar(arregloGrande);        
        System.out.println("Arreglo a ordenar: ");
        imprimir(arregloGrande);
        ini = System.nanoTime();
        quickSort(arregloGrande);
        fin = System.nanoTime();
        System.out.println("");
        System.out.println("Arreglo ordenado: ");
        imprimir(arregloGrande);
        System.out.println("");
        System.out.println("Tiempo que toma el algoritmo: " + (fin - ini));
        */
        
    }
    
    //llenar arreglo
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
    
    //copiar arreglo
    public static void copiar(int[]arreglo, int[]copia){
        for (int i = 0; i < arreglo.length; i++) {
            copia[i] = arreglo[i];
        }
    }
    
    //Selection Sort: comparaciones e intercambios 
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
    
    public static void insertionSort(int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int temp = arreglo[i]; //Es el valor que se va a ordenar
            int insP = i;
            // En que punto debe de quedar temp, esa posicion queda almacenada en insP
            for (int prev = i-1; prev >= 0; prev--) { //Comparar
                if(arreglo[prev] > temp){
                    //Swap intercambio parcial
                    arreglo[insP] = arreglo[prev];
                    insP--;                    
                } else {
                    break;
                }
                arreglo[insP] = temp;
            }
        }
    }
    
    //BubbleSort no lo vamos a programar
    
    //QuickSort
    public static void quickSort(int[]arreglo){
        quickSortRec(arreglo, 0, arreglo.length - 1);
    }
    
    private static void quickSortRec(int[]arreglo, int ini, int fin){
        // Pivote --> posicion
        // 2 Indices
        // ind_gran --> busca los mayores al pivote
        // ind_peq --> busca los menores al pivote
        // si se cruzan, se intercambia pivote con ind_peq
        // QuickSort a cada lado del pivote
        
        int pivot, ind_gran, ind_peq, temp;
        pivot = ini;
        ind_gran = ini;
        ind_peq = fin;
        if(ini < fin){
            while(ind_gran < ind_peq){ //Los indices se cruzaron
            //Mover los indices               
            while(arreglo[ind_gran] <= arreglo[pivot] && (ind_gran < ind_peq)){ //Buscar los elementos mas grandes que el pivote
                ind_gran++;
            }
            while(arreglo[ind_peq] > arreglo[pivot]){ // unicamente menor que?
                ind_peq--;
            }
        
            //Swap
            if(ind_gran < ind_peq){
                temp = arreglo[ind_gran];
                arreglo[ind_gran] = arreglo[ind_peq];
                arreglo[ind_peq] = temp;
            }     
        }
        
        
        
        //swap pivote con small
        temp = arreglo[pivot];
        arreglo[pivot] = arreglo[ind_peq];
        arreglo[ind_peq] = temp;
        pivot = ind_peq;
        
        //Llamada recursiva
        quickSortRec(arreglo, ini, pivot-1);
        quickSortRec(arreglo, pivot+1, fin);
        }
    }    
        
}