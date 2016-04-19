package es.etsii.ull.DAA.Practica3;

import es.etsii.ull.DAA.Practica3.*;
import java.io.*;
import java.util.*;

public class Main {
  
  private static Scanner scanner;
  public static void main(String[] args) throws Exception {
    titulo();
    String fichero = pedirFichero();
    Ciudades ciudades = new Ciudades(fichero);
    
    Problema tsp = new Problema(ciudades.getNumeroCiudades(), ciudades.getDistancias());
    System.out.println("Información del problema");
    System.out.println("________________________");
    String informacion = tsp.toString();
    System.out.println(informacion);
    
    // Creamos las distintas técnicas y la solucion.
    FuerzaBruta fuerzaBruta = new FuerzaBruta();
    Voraz voraz = new Voraz();
    ProgramacionDinamica pd = new ProgramacionDinamica();
    Solucion solucion = new Solucion();
    boolean ejecutar = true;
    Temporizador temporizador = new Temporizador();
    while(ejecutar) {
      menu();
      scanner = new Scanner(System.in);
      int opcion = scanner.nextInt();
      switch (opcion) {
      case 1:
        System.out.println("\nNo exacto: ");
        temporizador.start();
        solucion = voraz.resolverVorazmente(tsp);
        System.out.println(solucion.toString());
        temporizador.stop();
        System.out.println("Han transcurrido " + temporizador.tiempoTranscurrido() + "milisegundos.");
        break;
      case 2:
        System.out.println("\nFuerza bruta: ");
        temporizador.start();
        solucion = voraz.resolverVorazmente(tsp);
        solucion = fuerzaBruta.resolver(tsp, solucion);
        System.out.println(solucion.toString());
        temporizador.stop();
        System.out.println("Han transcurrido " + temporizador.tiempoTranscurrido() + "milisegundos.");
        break;
      case 3:
        System.out.println("\nProgramación dinámica: ");
        temporizador.start();
        solucion = pd.resolverConProgramacionDinamica(tsp);
        System.out.println(solucion.toString());
        
        temporizador.stop();
        System.out.println("Han transcurrido " + temporizador.tiempoTranscurrido() + "milisegundos.");
        break;
      case 4:
        temporizador.start();
        System.out.println("\nNo exacto: ");
        solucion = voraz.resolverVorazmente(tsp);
        System.out.println(solucion.toString());
        System.out.println("\nFuerza Bruta: ");
        solucion = fuerzaBruta.resolver(tsp, solucion);
        System.out.println(solucion.toString());
        System.out.println("\nProgramación dinámmica: ");
        solucion = pd.resolverConProgramacionDinamica(tsp);
        System.out.println(solucion.toString());
        temporizador.stop();
        System.out.println("Han transcurrido " + temporizador.tiempoTranscurrido() + "milisegundos.");
        break;
      case 5:
        ejecutar = false;
        break;
      default:
        System.out.println("Revise las opciones, introduzca una opción válida.");
        break;
      }
    }
  }      
  private static void menu() {
    System.out.println("********");
    System.out.println("OPCIONES");
    System.out.println("********");
    System.out.println("1) Resolver con el algoritmo voraz.");
    System.out.println("2) Resolver mediante programación dinámica.");
    System.out.println("3) Resolver mediante fuerza bruta.");
    System.out.println("4) Resolver con los tres algoritmos.");
    System.out.println("5) Salir.");
    System.out.println("Introducir una opción: ");
  }
  private static String pedirFichero() throws Exception {
    Scanner entradaUsuario = null;
    String ficheroEntrada = null;
    System.out.println("Introducir la ruta del fichero: ");
    try {
      entradaUsuario = new Scanner(System.in);
      ficheroEntrada = entradaUsuario.nextLine();
      return ficheroEntrada;
    } catch (Exception e) {
       throw new FileNotFoundException("Operación fallida, revisa la ruta.");
    }
    
  }
  private static void titulo() {
    System.out.println("PRÁCTICA 3");
    System.out.println("");
    System.out.println("Resolución del Problema del viajante de comercio.");
    System.out.println("Se resuelve mediante tres técnicas distintas");
    System.out.println("1) Búsqueda Exhaustiva.");
    System.out.println("2) Programación Dinámica.");
    System.out.println("3) Método no exacto.");
  }
}
