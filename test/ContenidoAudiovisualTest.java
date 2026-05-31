import model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ContenidoAudiovisualTest {

    private Pelicula pelicula;
      private Serie serie;
      private Documental documental;
      private Actor actor;

    @BeforeEach
      public void setUp() {
                pelicula = new Pelicula(1, "Inception", 2010, "Ciencia Ficcion", "Ingles", 148, "Christopher Nolan");
                serie = new Serie(2, "Breaking Bad", 2008, "Drama", "Ingles", "Finalizada");
                documental = new Documental(3, "Planet Earth", 2006, "Naturaleza", "Ingles", "Medio Ambiente", 50);
                actor = new Actor(1, "Leonardo", "DiCaprio", "Estadounidense", 1974);
      }

    @Test
      public void testPeliculaGetTipo() {
                assertEquals("Pelicula", pelicula.getTipo());
      }

    @Test
      public void testSerieGetTipo() {
                assertEquals("Serie", serie.getTipo());
      }

    @Test
      public void testDocumentalGetTipo() {
                assertEquals("Documental", documental.getTipo());
      }

    @Test
      public void testPeliculaTitulo() {
                assertEquals("Inception", pelicula.getTitulo());
      }

    @Test
      public void testPeliculaDirector() {
                assertEquals("Christopher Nolan", pelicula.getDirector());
      }

    @Test
      public void testPeliculaDuracion() {
                assertEquals(148, pelicula.getDuracion());
      }

    @Test
      public void testSerieEstado() {
                assertEquals("Finalizada", serie.getEstado());
      }

    @Test
      public void testDocumentalTematica() {
                assertEquals("Medio Ambiente", documental.getTematica());
      }

    @Test
      public void testActorNombreCompleto() {
                assertEquals("Leonardo DiCaprio", actor.getNombreCompleto());
      }

    @Test
      public void testAgregarActorAPelicula() {
                pelicula.agregarActor(actor);
                List<Actor> actores = pelicula.getActores();
                assertEquals(1, actores.size());
                assertEquals("Leonardo DiCaprio", actores.get(0).getNombreCompleto());
      }

    @Test
      public void testAgregarTemporadaASerie() {
                Temporada temporada = new Temporada(1, 2008, 7);
                serie.agregarTemporada(temporada);
                assertEquals(1, serie.getNumeroTemporadas());
                assertEquals(1, serie.getTemporadas().size());
      }

    @Test
      public void testCalificacion() {
                pelicula.setCalificacion(8.8);
                assertEquals(8.8, pelicula.getCalificacion(), 0.01);
      }

    @Test
      public void testPeliculaAnio() {
                assertEquals(2010, pelicula.getAnio());
      }

    @Test
      public void testSerieGenero() {
                assertEquals("Drama", serie.getGenero());
      }
}
