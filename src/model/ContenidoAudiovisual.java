package model;

import java.util.ArrayList;
import java.util.List;

public abstract class ContenidoAudiovisual {
      private int id;
      private String titulo;
      private int anio;
      private String genero;
      private String idioma;
      private double calificacion;
      private List<Actor> actores;

    public ContenidoAudiovisual(int id, String titulo, int anio, String genero, String idioma) {
              this.id = id;
              this.titulo = titulo;
              this.anio = anio;
              this.genero = genero;
              this.idioma = idioma;
              this.actores = new ArrayList<>();
    }

    public int getId() { return id; }
      public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
      public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getAnio() { return anio; }
      public void setAnio(int anio) { this.anio = anio; }

    public String getGenero() { return genero; }
      public void setGenero(String genero) { this.genero = genero; }

    public String getIdioma() { return idioma; }
      public void setIdioma(String idioma) { this.idioma = idioma; }

    public double getCalificacion() { return calificacion; }
      public void setCalificacion(double calificacion) { this.calificacion = calificacion; }

    public List<Actor> getActores() { return actores; }
      public void setActores(List<Actor> actores) { this.actores = actores; }

    public void agregarActor(Actor actor) {
              this.actores.add(actor);
    }

    public abstract String getTipo();

    @Override
      public String toString() {
                return "[" + getTipo() + "] " + titulo + " (" + anio + ") - Genero: " + genero + " - Calificacion: " + calificacion;
      }
}
