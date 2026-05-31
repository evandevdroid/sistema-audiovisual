package controller;

import model.ContenidoAudiovisual;
import model.Pelicula;
import model.Serie;
import model.Documental;
import util.ArchivoUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ContenidoController {
      private List<ContenidoAudiovisual> contenidos;
      private static final String ARCHIVO_CSV = "data/contenidos.csv";

    public ContenidoController() {
              this.contenidos = new ArrayList<>();
              cargarContenidos();
    }

    public void cargarContenidos() {
              List<ContenidoAudiovisual> cargados = ArchivoUtil.leerCSV(ARCHIVO_CSV);
              if (cargados != null) {
                            this.contenidos = cargados;
              }
    }

    public void guardarContenidos() {
              ArchivoUtil.escribirCSV(ARCHIVO_CSV, contenidos);
    }

    public List<ContenidoAudiovisual> obtenerTodos() {
              return new ArrayList<>(contenidos);
    }

    public ContenidoAudiovisual buscarPorId(int id) {
              return contenidos.stream()
                                .filter(c -> c.getId() == id)
                                .findFirst()
                                .orElse(null);
    }

    public List<ContenidoAudiovisual> buscarPorTitulo(String titulo) {
              String tituloLower = titulo.toLowerCase();
              return contenidos.stream()
                                .filter(c -> c.getTitulo().toLowerCase().contains(tituloLower))
                                .collect(Collectors.toList());
    }

    public List<ContenidoAudiovisual> buscarPorGenero(String genero) {
              return contenidos.stream()
                                .filter(c -> c.getGenero().equalsIgnoreCase(genero))
                                .collect(Collectors.toList());
    }

    public void agregarContenido(ContenidoAudiovisual contenido) {
              contenidos.add(contenido);
    }

    public boolean eliminarPorId(int id) {
              return contenidos.removeIf(c -> c.getId() == id);
    }

    public List<Pelicula> obtenerPeliculas() {
              return contenidos.stream()
                                .filter(c -> c instanceof Pelicula)
                                .map(c -> (Pelicula) c)
                                .collect(Collectors.toList());
    }

    public List<Serie> obtenerSeries() {
              return contenidos.stream()
                                .filter(c -> c instanceof Serie)
                                .map(c -> (Serie) c)
                                .collect(Collectors.toList());
    }

    public List<Documental> obtenerDocumentales() {
              return contenidos.stream()
                                .filter(c -> c instanceof Documental)
                                .map(c -> (Documental) c)
                                .collect(Collectors.toList());
    }

    public int generarNuevoId() {
              return contenidos.stream()
                                .mapToInt(ContenidoAudiovisual::getId)
                                .max()
                                .orElse(0) + 1;
    }
}
