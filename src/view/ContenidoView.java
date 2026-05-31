package view;

import controller.ContenidoController;
import model.ContenidoAudiovisual;

import java.util.List;
import java.util.Scanner;

public class ContenidoView {
      private ContenidoController controller;
      private Scanner scanner;

    public ContenidoView(ContenidoController controller) {
              this.controller = controller;
              this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
              int opcion;
              do {
                            mostrarMenu();
                            opcion = leerOpcion();
                            procesarOpcion(opcion);
              } while (opcion != 0);
              System.out.println("Saliendo del sistema...");
              scanner.close();
    }

    private void mostrarMenu() {
              System.out.println("\n===== SISTEMA AUDIOVISUAL =====");
              System.out.println("1. Listar todos los contenidos");
              System.out.println("2. Buscar contenido por titulo");
              System.out.println("3. Agregar nueva pelicula");
              System.out.println("4. Agregar nueva serie");
              System.out.println("5. Agregar nuevo documental");
              System.out.println("6. Eliminar contenido por ID");
              System.out.println("7. Guardar contenidos en archivo");
              System.out.println("0. Salir");
              System.out.print("Seleccione una opcion: ");
    }

    private int leerOpcion() {
              try {
                            return Integer.parseInt(scanner.nextLine().trim());
              } catch (NumberFormatException e) {
                            return -1;
              }
    }

    private void procesarOpcion(int opcion) {
              switch (opcion) {
                case 1:
                                  listarContenidos();
                                  break;
                case 2:
                                  buscarContenido();
                                  break;
                case 3:
                                  System.out.println("Funcion agregar pelicula - implementar");
                                  break;
                case 4:
                                  System.out.println("Funcion agregar serie - implementar");
                                  break;
                case 5:
                                  System.out.println("Funcion agregar documental - implementar");
                                  break;
                case 6:
                                  eliminarContenido();
                                  break;
                case 7:
                                  controller.guardarContenidos();
                                  System.out.println("Contenidos guardados exitosamente.");
                                  break;
                case 0:
                                  break;
                default:
                                  System.out.println("Opcion invalida. Intente de nuevo.");
              }
    }

    private void listarContenidos() {
              List<ContenidoAudiovisual> contenidos = controller.obtenerTodos();
              if (contenidos.isEmpty()) {
                            System.out.println("No hay contenidos registrados.");
              } else {
                            System.out.println("\n--- LISTA DE CONTENIDOS ---");
                            for (ContenidoAudiovisual c : contenidos) {
                                              System.out.println(c);
                            }
              }
    }

    private void buscarContenido() {
              System.out.print("Ingrese el titulo a buscar: ");
              String titulo = scanner.nextLine();
              List<ContenidoAudiovisual> resultados = controller.buscarPorTitulo(titulo);
              if (resultados.isEmpty()) {
                            System.out.println("No se encontraron resultados para: " + titulo);
              } else {
                            for (ContenidoAudiovisual c : resultados) {
                                              System.out.println(c);
                            }
              }
    }

    private void eliminarContenido() {
              System.out.print("Ingrese el ID del contenido a eliminar: ");
              try {
                            int id = Integer.parseInt(scanner.nextLine().trim());
                            boolean eliminado = controller.eliminarPorId(id);
                            System.out.println(eliminado ? "Contenido eliminado." : "No se encontro contenido con ese ID.");
              } catch (NumberFormatException e) {
                            System.out.println("ID invalido.");
              }
    }
}
