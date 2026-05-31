# Sistema Audiovisual

Sistema de gestion de contenido audiovisual desarrollado en Java, que permite administrar peliculas, series y documentales.

## Estructura del Proyecto

```
sistema-audiovisual/
├── src/
│   ├── Main.java
│   ├── model/
│   │   ├── ContenidoAudiovisual.java
│   │   ├── Pelicula.java
│   │   ├── Serie.java
│   │   ├── Documental.java
│   │   ├── Actor.java
│   │   ├── Temporada.java
│   │   └── Investigador.java
│   ├── view/
│   │   └── ContenidoView.java
│   ├── controller/
│   │   └── ContenidoController.java
│   └── util/
│       └── ArchivoUtil.java
├── test/
│   └── ContenidoAudiovisualTest.java
├── data/
│   └── contenidos.csv
└── README.md
```

## Descripcion

Este proyecto implementa un sistema MVC (Modelo-Vista-Controlador) para la gestion de contenido audiovisual. Permite:

- Gestionar peliculas, series y documentales
- - Registrar actores e investigadores
  - - Administrar temporadas de series
    - - Guardar y cargar datos desde archivos CSV
      - - Buscar contenido por titulo o genero
       
        - ## Tecnologias
       
        - - **Lenguaje:** Java 8+
          - - **Patron:** MVC (Modelo-Vista-Controlador)
            - - **Tests:** JUnit 5
              - - **Almacenamiento:** Archivos CSV
               
                - ## Clases Principales
               
                - ### Modelo
                - - `ContenidoAudiovisual`: Clase abstracta base para todo el contenido
                  - - `Pelicula`: Extiende ContenidoAudiovisual, incluye duracion y director
                    - - `Serie`: Extiende ContenidoAudiovisual, incluye temporadas y estado
                      - - `Documental`: Extiende ContenidoAudiovisual, incluye tematica e investigadores
                        - - `Actor`: Representa a un actor con sus datos personales
                          - - `Temporada`: Representa una temporada de una serie
                            - - `Investigador`: Representa a un investigador de un documental
                             
                              - ### Vista
                              - - `ContenidoView`: Interfaz de usuario en consola
                               
                                - ### Controlador
                                - - `ContenidoController`: Logica de negocio y gestion de datos
                                 
                                  - ### Utilidades
                                  - - `ArchivoUtil`: Lectura y escritura de archivos CSV
                                   
                                    - ## Ejecucion
                                   
                                    - ```bash
                                      javac -d bin src/*.java src/**/*.java
                                      java -cp bin Main
                                      ```

                                      ## Tests

                                      ```bash
                                      javac -cp .:junit-5.jar -d bin test/*.java src/**/*.java
                                      java -cp .:junit-5.jar:bin org.junit.platform.console.ConsoleLauncher --scan-classpath
                                      ```
