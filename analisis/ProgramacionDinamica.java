package es.etsii.ull.DAA.Practica3;

public class ProgramacionDinamica {
  private int numeroCiudades;
  private int posibilidades;
  private final int CIUDAD_INICIAL = 0;
  
  public ProgramacionDinamica() {}

  public Solucion resolverConProgramacionDinamica(Problema problema) {
    Solucion solucion = new Solucion();
    setNumeroCiudades(problema.getNumeroCiudades());
    setPosibilidades((int) Math.pow(2, getNumeroCiudades()));
    int tabla[][] = new int[getNumeroCiudades()][getPosibilidades()];
    int tablaConLasRutas[][] = new int[getNumeroCiudades()][getPosibilidades()];

    for (int i = 0; i < getNumeroCiudades(); i++) {
      for (int j = 0; j < getPosibilidades(); j++) {
        tabla[i][j] = -1;
        tablaConLasRutas[i][j] = -1;
      }
    }

    for (int i = 0; i < getNumeroCiudades(); i++) {
      tabla[i][0] = problema.getCoste(i, getCIUDAD_INICIAL());
    }

    solucion.añadirCiudad(getCIUDAD_INICIAL());
    solucion.setDistanciaMinima(algoritmoDinámico(0, getPosibilidades() - 2, tabla, tablaConLasRutas, problema));
    obtenerRuta(getCIUDAD_INICIAL(), getPosibilidades() - 2, tablaConLasRutas, solucion);
    solucion.añadirCiudad(getCIUDAD_INICIAL());

    return solucion;
  }



  private void obtenerRuta(int comienzo, int set,int[][] tablaConLasRutas, Solucion solucion) {
    if (tablaConLasRutas[comienzo][set] == -1)
      return;
    int x = tablaConLasRutas[comienzo][set];
    int mask = getPosibilidades() - 1 - (int)Math.pow(2, x);
    int masked = set & mask;
    solucion.añadirCiudad(x);
    obtenerRuta(x, mask, tablaConLasRutas, solucion);
  }

  private int algoritmoDinámico(int comienzo, int set, int[][] tabla, int[][] tablaConLasRutas, Problema problema) {
    int mask, masked, resultado = -1, temporal;
    
    if (tabla[comienzo][set] != -1) {
      return tabla[comienzo][set];
    } else {
      for (int i = 0; i < getNumeroCiudades(); i++) {
        mask = getPosibilidades() -1 - (int) Math.pow(2, i);
        masked = set & mask;
        if (masked != set) {
          temporal = problema.getCoste(comienzo, i) + algoritmoDinámico(i, masked, tabla, tablaConLasRutas, problema);
          if (resultado == -1 || resultado > temporal) {
            resultado = temporal;
            tablaConLasRutas[comienzo][set] = i;
          }
        }
      }
    }
    tabla[comienzo][set] = resultado;
    return resultado;
  }

  private int getNumeroCiudades() {
    return numeroCiudades;
  }

  private void setNumeroCiudades(int numeroCiudades) {
    this.numeroCiudades = numeroCiudades;
  }

  private int getPosibilidades() {
    return posibilidades;
  }

  private void setPosibilidades(int posibilidades) {
    this.posibilidades = posibilidades;
  }

  private int getCIUDAD_INICIAL() {
    return CIUDAD_INICIAL;
  }

  
}
