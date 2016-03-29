package es.etsii.ull.DAA.Practica3;

import java.util.ArrayList;

public class Voraz {
  private final int CIUDAD_INICIAL = 0;
  
  public Voraz() {}
  
  public Solucion resolverVorazmente(Problema problema) {
    //Construimos el caso inicial de partida.
    Solucion solucion = new Solucion();
    ArrayList<Integer> ruta = new ArrayList<Integer>();
    int distanciaTotal = 0;
    int ciudadActual = getCIUDAD_INICIAL();
    ruta.add(ciudadActual);
    int mejorCandidato = ciudadActual;
    int distanciaMinima = Integer.MAX_VALUE;
    
    // Recorremos vorazmente en busca del mejor candidato siempre.
    while (ruta.size() < problema.getNumeroCiudades()) {
      for (int i = 0; i < problema.getNumeroCiudades(); i++) {
        if (i != ciudadActual && !ruta.contains(i)) {
          if (problema.getCoste(ciudadActual, i) < distanciaMinima) {
            distanciaMinima = problema.getCoste(ciudadActual, i);
            mejorCandidato = i;
          }
        }
      }
      
      // Actualiza los valores.
      ruta.add(mejorCandidato);
      distanciaTotal += distanciaMinima;
      ciudadActual = mejorCandidato;
      distanciaMinima = Integer.MAX_VALUE;
    }

    // Cierra la ruta
    distanciaTotal += problema.getCoste(ruta.get(ruta.size() - 1), 0);
    ruta.add(ruta.get(0));
    
    // Construye la solución.
    solucion.setRuta(ruta);
    solucion.setDistanciaMinima(distanciaTotal);
    return solucion;
  }

  private int getCIUDAD_INICIAL() {
    return CIUDAD_INICIAL;
  }
  
  
}
