package model;

import java.util.List;
import java.util.ArrayList;

public class Documental extends ContenidoAudiovisual {
      private String tematica;
      private int duracion; // en minutos
    private List<Investigador> investigadores;

    public Documental(int id, String titulo, int anio, String genero, String idioma, String tematica, int duracion) {
              super(id, titulo, anio, genero, idioma);
              this.tematica = tematica;
              this.duracion = duracion;
              this.investigadores = new ArrayList<>();
    }

    public String getTematica() { return tematica; }
      public void setTematica(String tematica) { this.tematica = tematica; }

    public int getDuracion() { return duracion; }
      public void setDuracion(int duracion) { this.duracion = duracion; }

    public List<Investigador> getInvestigadores() { return investigadores; }
      public void setInvestigadores(List<Investigador> investigadores) { this.investigadores = investigadores; }

    public void agregarInvestigador(Investigador investigador) {
              this.investigadores.add(investigador);
    }

    @Override
      public String getTipo() {
                return "Documental";
      }

    @Override
      public String toString() {
                return super.toString() + " - Tematica: " + tematica + " - Duracion: " + duracion + " min";
      }
}
