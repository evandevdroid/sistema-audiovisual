package model;

public class Pelicula extends ContenidoAudiovisual {
      private int duracion; // en minutos
    private String director;
      private String clasificacion;

    public Pelicula(int id, String titulo, int anio, String genero, String idioma, int duracion, String director) {
              super(id, titulo, anio, genero, idioma);
              this.duracion = duracion;
              this.director = director;
    }

    public int getDuracion() { return duracion; }
      public void setDuracion(int duracion) { this.duracion = duracion; }

    public String getDirector() { return director; }
      public void setDirector(String director) { this.director = director; }

    public String getClasificacion() { return clasificacion; }
      public void setClasificacion(String clasificacion) { this.clasificacion = clasificacion; }

    @Override
      public String getTipo() {
                return "Pelicula";
      }

    @Override
      public String toString() {
                return super.toString() + " - Duracion: " + duracion + " min - Director: " + director;
      }
}
