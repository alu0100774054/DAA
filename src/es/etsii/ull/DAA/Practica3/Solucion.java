package es.etsii.ull.DAA.Practica3;

import java.util.ArrayList;

public class Solucion {
  private int distanciaMinima;
  private ArrayList<Integer> ruta;
  
  Solucion() {
    distanciaMinima = 0;
    ruta = new ArrayList<Integer>();
  }
  
  Solucion(int distanciaMinima, ArrayList<Integer> ruta) {
    this.distanciaMinima = distanciaMinima;
    this.ruta = ruta;
  }
  
  public void incrementarDistancia(int distancia) {
    setDistanciaMinima(getDistanciaMinima() + distancia);
  }
  
  public void añadirCiudad(int ciudad) {
    getRuta().add(ciudad);
  }
  
  public int obtenerUltimaCiudad() {
    return getRuta().get(getRuta().size() -1);
  }
  public int getDistanciaMinima() {
    return distanciaMinima;
  }

  public void setDistanciaMinima(int distanciaMinima) {
    this.distanciaMinima = distanciaMinima;
  }

  public ArrayList<Integer> getRuta() {
    return ruta;
  }

  public void setRuta(ArrayList<Integer> ruta) {
    this.ruta = ruta;
  }

  @Override
  public String toString() {
    String toS = "";
    toS += "Distancia mínima ---> " + getDistanciaMinima();
    toS += "\nRuta";
    toS += "\n____";
    for (int i = 0; i < getRuta().size(); i++) {
      if (i < getRuta().size() - 1) {
        toS += "Ciudad [ " + (getRuta().get(i) + 1 ) + " ]" + " ---> ";
      } else {
        toS += "Ciudad [ " + (getRuta().get(i) + 1 ) + " ]"; 
      }
    }
    
    return toS;
  }
  
  
}
