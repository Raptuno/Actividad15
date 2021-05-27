package core;
import java.io.*;
import java.util.LinkedHashMap;

public class Main { //Inicia clase
    
    //Función para Agregar autores
    public static void agregarAutor(LinkedHashMap lhm, String autor){
        lhm.putIfAbsent(lhm.size()+1, autor);
        System.out.println("Autor agregado");
    }
    
    //Función para quitar autores
    public static void quitarAutor(LinkedHashMap lhm, int key, String autor){
        if(lhm.containsKey(key) || lhm.containsValue(autor)) {
            lhm.remove(key, autor);
            System.out.println("Autor quitado");
        } else {
            System.out.println("ERROR: La clave o autor no existen");
        }
    }
    
    //Función para mostrar autores
    public static void mostrarAutor(LinkedHashMap lhm, int key){
        if(lhm.containsKey(key)){
            System.out.println(String.format("Autor %s: %s", key, lhm.get(key)));
        } else {
            System.out.println("ERROR: La clave no existe");
        }
    }
    
    //Función para modificar autores
    public static void modificarAutor(LinkedHashMap lhm, int key, String autorNuevo){
        if(lhm.containsKey(key)){
            lhm.replace(key, lhm.get(key), autorNuevo);
            System.out.println("Autor modificado");
    
        } else {
            System.out.println("ERROR: La clave no existe");
        }
    }
    
    public static void main(String[] args)throws IOException { // Inicia método main
	    LinkedHashMap<Integer, String> autores = new LinkedHashMap<>();
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    boolean exit = false;
	    
	    //Agregar autores (Debido a limitaciones de LinkedHashMap los campos Nombre y Apellido Paterno están fusionados)
        autores.put(1, "Harvey Deitel");
	    autores.put(2, "Paul Deitel");
	    autores.put(3, "Tem Nieto");
	    autores.put(4, "Sean Santry");
	    
	    while(!exit){ //Inicia while
	       
	       System.out.print("¿Qué desea hacer? (Agregar, Eliminar, Mostrar, Modificar o Salir): ");
	       String opt = br.readLine();
	       
	       switch(opt.toLowerCase()){ //Empieza switch case
               case "agregar":
                   System.out.print("Ingrese el nombre y apellido paterno del autor: ");
                   Main.agregarAutor(autores, br.readLine());
                   break;
               case "eliminar":
                   System.out.print(autores+"Ingrese clave y nombre del autor a eliminar: ");
                   Main.quitarAutor(autores, Integer.parseInt(br.readLine()), br.readLine());
                   break;
               case "mostrar":
                   System.out.print(String.format("Ingrese la clave del autor a mostrar (Máximo %s): ", autores.size()));
                   Main.mostrarAutor(autores, Integer.parseInt(br.readLine()));
                   break;
               case "modificar":
                   System.out.print(String.format("Ingrese la clave del autor a modificar (Máximo %s) y posteriormente ingrese el nombre nuevo: ", autores.size()));
                   Main.modificarAutor(autores, Integer.parseInt(br.readLine()), br.readLine());
                   break;
               case "salir":
                   System.out.println("Gracias por utilizar la tabla de autores");
                   exit = true;
                   break;
               default:
                   System.out.println("Opción no válida. Inténtelo de nuevo");
                   break;
           } //Termina switch case
        } //Termina while
    } //Termina método main
} //Termina clase
