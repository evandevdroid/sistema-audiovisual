package util;

import model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtil {

    public static List<ContenidoAudiovisual> leerCSV(String rutaArchivo) {
              List<ContenidoAudiovisual> contenidos = new ArrayList<>();
              File archivo = new File(rutaArchivo);
              if (!archivo.exists()) {
                            System.out.println("Archivo no encontrado: " + rutaArchivo);
                            return contenidos;
              }
              try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                            String linea;
                            boolean primeraLinea = true;
                            while ((linea = br.readLine()) != null) {
                                              if (primeraLinea) {
                                                                    primeraLinea = false;
                                                                    continue; // Saltar encabezado
                                              }
                                              ContenidoAudiovisual contenido = parsearLinea(linea);
                                              if (contenido != null) {
                                                                    contenidos.add(contenido);
                                              }
                            }
              } catch (IOException e) {
                            System.err.println("Error al leer el archivo: " + e.getMessage());
              }
              return contenidos;
    }

    private static ContenidoAudiovisual parsearLinea(String linea) {
              try {
                            String[] datos = linea.split(",");
                            if (datos.length < 6) return null;
                            int id = Integer.parseInt(datos[0].trim());
                            String tipo = datos[1].trim();
                            String titulo = datos[2].trim();
                            int anio = Integer.parseInt(datos[3].trim());
                            String genero = datos[4].trim();
                            String idioma = datos[5].trim();
                            switch (tipo.toLowerCase()) {
                              case "pelicula":
                                                    int duracion = datos.length > 6 ? Integer.parseInt(datos[6].trim()) : 0;
                                                    String director = datos.length > 7 ? datos[7].trim() : "Desconocido";
                                                    return new Pelicula(id, titulo, anio, genero, idioma, duracion, director);
                              case "serie":
                                                    String estado = datos.length > 6 ? datos[6].trim() : "Desconocida";
                                                    return new Serie(id, titulo, anio, genero, idioma, estado);
                              case "documental":
                                                    String tematica = datos.length > 6 ? datos[6].trim() : "General";
                                                    int dur = datos.length > 7 ? Integer.parseInt(datos[7].trim()) : 0;
                                                    return new Documental(id, titulo, anio, genero, idioma, tematica, dur);
                              default:
                                                    return null;
                            }
              } catch (Exception e) {
                            System.err.println("Error al parsear linea: " + linea);
                            return null;
              }
    }

    public static void escribirCSV(String rutaArchivo, List<ContenidoAudiovisual> contenidos) {
              try {
                            File archivo = new File(rutaArchivo);
                            archivo.getParentFile().mkdirs();
                            try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
                                              pw.println("id,tipo,titulo,anio,genero,idioma,campo_extra1,campo_extra2");
                                              for (ContenidoAudiovisual c : contenidos) {
                                                                    StringBuilder sb = new StringBuilder();
                                                                    sb.append(c.getId()).append(",");
                                                                    sb.append(c.getTipo()).append(",");
                                                                    sb.append(c.getTitulo()).append(",");
                                                                    sb.append(c.getAnio()).append(",");
                                                                    sb.append(c.getGenero()).append(",");
                                                                    sb.append(c.getIdioma());
                                                                    if (c instanceof Pelicula) {
                                                                                              Pelicula p = (Pelicula) c;
                                                                                              sb.append(",").append(p.getDuracion()).append(",").append(p.getDirector());
                                                                    } else if (c instanceof Serie) {
                                                                                              Serie s = (Serie) c;
                                                                                              sb.append(",").append(s.getEstado());
                                                                    } else if (c instanceof Documental) {
                                                                                              Documental d = (Documental) c;
                                                                                              sb.append(",").append(d.getTematica()).append(",").append(d.getDuracion());
                                                                    }
                                                                    pw.println(sb.toString());
                                              }
                            }
              } catch (IOException e) {
                            System.err.println("Error al escribir el archivo: " + e.getMessage());
              }
    }
}
