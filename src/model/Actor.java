package model;

public class Actor {
      private int id;
      private String nombre;
      private String apellido;
      private String nacionalidad;
      private int anioNacimiento;

    public Actor(int id, String nombre, String apellido, String nacionalidad, int anioNacimiento) {
              this.id = id;
              this.nombre = nombre;
              this.apellido = apellido;
              this.nacionalidad = nacionalidad;
              this.anioNacimiento = anioNacimiento;
    }

    public int getId() { return id; }
      public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
      public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
      public void setApellido(String apellido) { this.apellido = apellido; }

    public String getNacionalidad() { return nacionalidad; }
      public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    public int getAnioNacimiento() { return anioNacimiento; }
      public void setAnioNacimiento(int anioNacimiento) { this.anioNacimiento = anioNacimiento; }

    public String getNombreCompleto() {
              return nombre + " " + apellido;
    }

    @Override
      public String toString() {
                return "Actor: " + getNombreCompleto() + " (" + nacionalidad + ", " + anioNacimiento + ")";
      }
}
