package es.etsii.ull.DAA.Practica3;

import java.util.ArrayList;

public class FuerzaBruta {
  private Solucion solucionActual;
  
  public FuerzaBruta() {
    solucionActual = null;
  }
  
  public Solucion resolver(Problema problema, Solucion solucionInicial) {
    setSolucionActual(solucionInicial);
    ArrayList<Integer> rutaInicial = new ArrayList<Integer>();
    rutaInicial.add(getCIUDAD_INICIAL());
    Solucion subSolucion = new Solucion(0, rutaInicial);
    resolverPorFuerzaBruta(problema, subSolucion);
    return getSolucionActual();
  }

  private void resolverPorFuerzaBruta(Problema problema, Solucion subSolucion) {
    if (subSolucion.getRuta().size() == problema.getNumeroCiudades()) {
      subSolucion.incrementarDistancia(problema.getCoste(subSolucion.obtenerUltimaCiudad(), 0));
      if (subSolucion.getDistanciaMinima() < solucionActual.getDistanciaMinima()) {
        solucionActual.añadirCiudad(0);
        setSolucionActual(subSolucion);
      }
    } else {
        for (int i = 0; i < problema.getNumeroCiudades(); i++) {
          if (!subSolucion.getRuta().contains(i)) {
            int incremento = subSolucion.getDistanciaMinima() + problema.getCoste(subSolucion.obtenerUltimaCiudad(), i);
            ArrayList<Integer> rutaIncrementada = (ArrayList<Integer>) subSolucion.getRuta().clone();
            rutaIncrementada.add(i);
            Solucion solucionIncrementada = new Solucion(incremento, rutaIncrementada);
            resolverPorFuerzaBruta(problema, solucionIncrementada);
          }
        }
    }
  }

  private Solucion getSolucionActual() {
    return solucionActual;
  }

  private void setSolucionActual(Solucion solucionActual) {
    this.solucionActual = solucionActual;
  }

  public int getCIUDAD_INICIAL() {
    return getCIUDAD_INICIAL();
  }
  
}
