package model;

import java.util.ArrayList;
import java.util.List;

public class Serie extends ContenidoAudiovisual {
      private int numeroTemporadas;
      private String estado; // En emisión, Finalizada, Cancelada
    private List<Temporada> temporadas;

    public Serie(int id, String titulo, int anio, String genero, String idioma, String estado) {
              super(id, titulo, anio, genero, idioma);
              this.estado = estado;
              this.temporadas = new ArrayList<>();
    }

    public int getNumeroTemporadas() { return numeroTemporadas; }
      public void setNumeroTemporadas(int numeroTemporadas) { this.numeroTemporadas = numeroTemporadas; }

    public String getEstado() { return estado; }
      public void setEstado(String estado) { this.estado = estado; }

    public List<Temporada> getTemporadas() { return temporadas; }
      public void setTemporadas(List<Temporada> temporadas) { this.temporadas = temporadas; }

    public void agregarTemporada(Temporada temporada) {
              this.temporadas.add(temporada);
              this.numeroTemporadas = this.temporadas.size();
    }

    @Override
      public String getTipo() {
                return "Serie";
      }

    @Override
      public String toString() {
                return super.toString() + " - Temporadas: " + numeroTemporadas + " - Estado: " + estado;
      }
}
