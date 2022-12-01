/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva3_2_comparator;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author branf
 */
public class EVA3_2_COMPARATOR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> milista = new LinkedList();
        milista.add((int)(Math.random() * 100));
        milista.add((int)(Math.random() * 100));
        milista.add((int)(Math.random() * 100));
        milista.add((int)(Math.random() * 100));
        milista.add((int)(Math.random() * 100));
        milista.add((int)(Math.random() * 100));
        milista.add((int)(Math.random() * 100));
        System.out.println(milista);
        //ORDENAR --> COMPARATOR
        //comparator es una interfaz
        Comparator ordenar = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Integer val1 = (Integer)o1;
                Integer val2 = (Integer)o2;
                //ordenar de menor a mayor
                return val1 - val2;
                //ordenar de mayor a menor
                //return val2 - val1;
                
            }
        };
        milista.sort(ordenar);
        System.out.println(milista);
        
        LinkedList<persona> listapersonas = new<persona> LinkedList();
        listapersonas.add(new persona("carlos", "perez", "tintori", 43, 5000));
        listapersonas.add(new persona("martha", "vega", "sandoval", 45, 2500));
        listapersonas.add(new persona("pancho", "martinez", "fernandez", 20, 8000));
        listapersonas.add(new persona("juan", "torrez", "peralta", 19, 5200));
        listapersonas.add(new persona("ricardo", "marquez", "floriano", 56, 4000));
       
        //Comparator : apellido paterno 
        //iteraror
        
        for (Iterator<persona> iterador = listapersonas.iterator();iterador.hasNext();) {
            persona perso = iterador.next();
            System.out.println(perso.getNombre());
        }
        /*
        Comparator  ordenarpaterno = new Comparator(){
            
        }
        */
        //comparator: salario        
    }
    
}

class persona{
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    private double salario;
    
    
    public persona(String nombre, String paterno, String materno, int edad, double salario ){
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
