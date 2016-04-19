package es.etsii.ull.DAA.Practica3;

public class Temporizador {
  private long inicio = 0;
  private long fin = 0;
  
  public Temporizador() {}
  
  public void start() {
    setInicio(System.currentTimeMillis());
  }

  public void stop() {
    setFin(System.currentTimeMillis());
  }
  
  public long tiempoTranscurrido() {
    return getFin() - getInicio();
  }
  private long getInicio() {
    return inicio;
  }

  private void setInicio(long inicio) {
    this.inicio = inicio;
  }

  private long getFin() {
    return fin;
  }

  private void setFin(long fin) {
    this.fin = fin;
  }
  
  
}
