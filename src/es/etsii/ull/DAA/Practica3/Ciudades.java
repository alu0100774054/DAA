package es.etsii.ull.DAA.Practica3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Ciudades {
  private int numeroCiudades;
  private ArrayList<ArrayList<Integer>> distancias;
  
  public Ciudades(String nombreFichero) {
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(nombreFichero));
      String line = "";
      boolean correctFormat = true;
      parseNumeroCiudades(br.readLine());
      distancias = new ArrayList<>();
      for(int i = 0; i < getNumeroCiudades(); i++) {
        distancias.add(new ArrayList<>());
        for(int j = 0; j < getNumeroCiudades(); j++) {
          distancias.get(i).add(0);          
        }
      }
      while((line = br.readLine()) != null && correctFormat) {
        parseDistancias(line);
      }
      mostrar();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }
  }

  private void parseDistancias(String linea) {
    String[] distancias = linea.split(" ");
    int[] distancia = new int[distancias.length];
    
    for (int i = 0; i < distancia.length; i++) {
      distancia[i] = Integer.parseInt(distancias[i]);
    }
    
    if(distancia.length != 3) {
      System.out.println("Error en los datos de entrada.");
      throw new ArrayIndexOutOfBoundsException();
    } else {
      getDistancias().get(distancia[0] - 1).set(distancia[1] - 1, distancia[2]);
      getDistancias().get(distancia[1] - 1).set(distancia[0] - 1, distancia[2]);
    }
  }

  private void parseNumeroCiudades(String linea) {
    setNumeroCiudades(Integer.parseInt(linea));
  }

  private int getNumeroCiudades() {
    return numeroCiudades;
  }

  private void setNumeroCiudades(int numeroCiudades) {
    this.numeroCiudades = numeroCiudades;
  }

  private ArrayList<ArrayList<Integer>> getDistancias() {
    return distancias;
  }

  private void setDistancias(ArrayList<ArrayList<Integer>> distancias) {
    this.distancias = distancias;
  }
  
  public void mostrar() {
    for (int i = 0; i < getDistancias().size(); i++) {
      System.out.println(" Ciudadad [" + (i + 1) + "] = " + getDistancias().get(i));
    }
  }
}
