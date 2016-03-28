package es.etsii.ull.DAA.Practica3;

import es.etsii.ull.DAA.Practica3.*;
import java.io.*;
import java.util.*;

public class Main {
  
  public static void main(String[] args) throws Exception {
    titulo();
    String fichero = pedirFichero();
    Ciudades ciudades = new Ciudades(fichero);
    
    System.out.println("");
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
