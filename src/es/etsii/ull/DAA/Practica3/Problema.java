package es.etsii.ull.DAA.Practica3;

import java.util.*;

public class Problema {
  private int numeroCiudades;
  private ArrayList<ArrayList<Integer>> distancias;
  
  public Problema(int numeroCiudades, ArrayList<ArrayList<Integer>> distancias) {
    this.numeroCiudades = numeroCiudades;
    this.distancias = distancias;
  }

  public int getNumeroCiudades() {
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
  
  public int getCoste(int ciudadOrigen, int ciudadDestino) {
    return distancias.get(ciudadOrigen).get(ciudadDestino);
  }
  public String toString() {
    String toS = "";
    toS += "Número de ciudades: " + getNumeroCiudades() + "\nDistancias: ";
    for(int i = 0; i < getDistancias().size(); i++) {
      toS += "\n\n***********";
      toS += "\nEstando en la ciudad [ " + (i + 1) + " ]";
      toS += "\n***********";
      for (int j = 0; j < getDistancias().get(i).size(); j++) {
        toS += "\nEl coste para ir a la ciudad [ " + (j + 1) + " ] = " + getDistancias().get(i).get(j);
      }
    }
    return toS;
  }
  
}
