package es.etsii.ull.DAA.Practica3;

import java.util.*;

public class Problema {
  private int numeroCiudades;
  private ArrayList<ArrayList<Integer>> distancias;
  
  public Problema(int numeroCiudades, ArrayList<ArrayList<Integer>> distancias) {
    this.numeroCiudades = numeroCiudades;
    this.distancias = distancias;
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
  
}
