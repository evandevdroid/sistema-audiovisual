package model;

public class Temporada {
      private int numero;
      private int anio;
      private int numeroEpisodios;
      private String descripcion;

    public Temporada(int numero, int anio, int numeroEpisodios) {
              this.numero = numero;
              this.anio = anio;
              this.numeroEpisodios = numeroEpisodios;
    }

    public int getNumero() { return numero; }
      public void setNumero(int numero) { this.numero = numero; }

    public int getAnio() { return anio; }
      public void setAnio(int anio) { this.anio = anio; }

    public int getNumeroEpisodios() { return numeroEpisodios; }
      public void setNumeroEpisodios(int numeroEpisodios) { this.numeroEpisodios = numeroEpisodios; }

    public String getDescripcion() { return descripcion; }
      public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
      public String toString() {
                return "Temporada " + numero + " (" + anio + ") - Episodios: " + numeroEpisodios;
      }
}
