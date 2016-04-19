package es.esit.ull.DAA.MaxMean;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {
  private int nVertices;
  private ArrayList<Double> distancias;
  private Double[][] matrizAdyacencia;
  
  public Grafo(String nombreFichero) {
    leerFichero(nombreFichero);
    mostrarDatos();
  }

  private void mostrarDatos() {
    System.out.println(getnVertices());
    
    for (int i = 0; i < getMatrizAdyacencia().length; i++) {
      System.out.println("");
      for (int j = 0; j < getMatrizAdyacencia().length; j++) {
        System.out.println(getMatriAdyacenciaItem(i, j));
      }
    }
  }

  private void leerFichero(String nombreFichero) {
    File fichero = new File(nombreFichero);
    Scanner s = null;
    String numeroVertices = "";
    try {
      s = new Scanner(fichero);
      numeroVertices = s.nextLine();
      setnVertices(Integer.parseInt(numeroVertices));
      matrizAdyacencia = new Double[getnVertices()][getnVertices()];
      
      // Guardamos el vector con las distancias.
      while (s.hasNextLine()) {
        String linea = s.nextLine();
        System.out.print("leo" + linea);
        Double valor = Double.parseDouble(linea);
        getDistancias().add(valor);
        System.out.print(valor + ", ");
      }
      
      // Creamos la matriz de adyacencia.
      int k = 0;
      for (int i = 0; i < getMatrizAdyacencia().length; i++) {
        for (int j = 0; j < getMatrizAdyacencia().length; j++) {
          if (i == j) {
            setMatriAdyacenciaItem(i, j, 0.0);
          } else if (i != j && getMatriAdyacenciaItem(i, j) == null) {
            setMatriAdyacenciaItem(i, j, distancias.get(k));
            setMatriAdyacenciaItem(i, j, distancias.get(k));
            k++;
          }
        } 
      }
      for (int i = 0; i < getMatrizAdyacencia().length; i++) {
        System.out.println("");
        for (int j = 0; j < getMatrizAdyacencia().length; j++) {
          System.out.println(getMatriAdyacenciaItem(i, j));
        }
      }
    } catch (Exception ex) {
      System.out.println("Mensaje: " + ex.getMessage());
    } finally {
      try {
        if (s != null)
          s.close();
      } catch (Exception ex2) {
        System.out.println("Mensaje 2: " + ex2.getMessage());
      }
    }
  }
  
  public int getnVertices() {
    return nVertices;
  }

  public void setnVertices(int nVertices) {
    this.nVertices = nVertices;
  }

  public ArrayList<Double> getDistancias() {
    return distancias;
  }

  public void setDistancias(ArrayList<Double> distancias) {
    this.distancias = distancias;
  }

  public Double[][] getMatrizAdyacencia() {
    return matrizAdyacencia;
  }

  public void setMatrizAdyacencia(Double[][] matrizAdyacencia) {
    this.matrizAdyacencia = matrizAdyacencia;
  }
  
  public void setMatriAdyacenciaItem(int i, int j, Double valor) {
    this.matrizAdyacencia[i][j] = valor;
  }
  
  public Double getMatriAdyacenciaItem(int i, int j) {
    return this.matrizAdyacencia[i][j];
  }
  
}
