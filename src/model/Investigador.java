package model;

public class Investigador {
      private int id;
      private String nombre;
      private String apellido;
      private String especialidad;
      private String institucion;

    public Investigador(int id, String nombre, String apellido, String especialidad, String institucion) {
              this.id = id;
              this.nombre = nombre;
              this.apellido = apellido;
              this.especialidad = especialidad;
              this.institucion = institucion;
    }

    public int getId() { return id; }
      public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
      public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
      public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEspecialidad() { return especialidad; }
      public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public String getInstitucion() { return institucion; }
      public void setInstitucion(String institucion) { this.institucion = institucion; }

    public String getNombreCompleto() {
              return nombre + " " + apellido;
    }

    @Override
      public String toString() {
                return "Investigador: " + getNombreCompleto() + " - Especialidad: " + especialidad + " - Institucion: " + institucion;
      }
}
