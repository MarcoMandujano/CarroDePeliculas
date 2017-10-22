//se modificaron los metodos de la clase en la version 1.4

package clases;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Catalogo {
    /**
     * peliculas tipo ArrayList de Pelicula, se guardaran aqui todas las películas que se encuentran disponibles para el usuario.
     */
    private ArrayList<Pelicula> peliculas;
    /**
     * catalogo tipo Archivo, Objeto para agregar, eliminar y obtener una película.
     */
    private Archivo catalogo;
    /**
     * Constructor vacio.
     */
    public Catalogo() {
        this.peliculas = new ArrayList<Pelicula>();
        this.catalogo = new Archivo("catalogo");
    }
    /**
     * Metodo que agrega una pelicula al catalogo.
     * Regresa true si la pelicula fue agregada al catalogo y
     *  false si no lo fue.
     * @param pelicula Pelicula
     * @return boolean
     */
    public boolean agregarPrelicula(Pelicula pelicula) {
        boolean agregada;
        this.peliculas.add(pelicula);
        int ultPelicula = peliculas.size() - 1;
        agregada = catalogo.escribirPelicula(peliculas.get(ultPelicula));
        return agregada;
    }
    /**
     * Metodo que elimina una pelicula del catalogo.
     * Regresa true si la pelicula fue eliminada del catalogo y
     *  false si no lo fue.
     * @param pelicula Pelicula
     * @return boolean
     */
    public boolean eliminarPelicula(Pelicula pelicula) {
        int indice;
        int tamanoDelArregloPeliculas = peliculas.size();
        boolean elim = false;
        String codgBarras;
        for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            codgBarras = this.peliculas.get(indice).getCodigoDeBarras();
            if (pelicula.getCodigoDeBarras().contains(codgBarras)) {
                elim = catalogo.borrarPelicula(pelicula.getCodigoDeBarras());
                peliculas.remove(indice);
                tamanoDelArregloPeliculas = peliculas.size();
                break;
            }
        }
        return elim;
    }
    /**
     * Metodo que regresa un ArrayList con todas las peliculas disponibles en
     *  el catalogo.
     * @return ArrayList
     */
    public ArrayList<Pelicula> getPeliculas() {
        this.peliculas = catalogo.leerPeliculas();
        return this.peliculas;
    }
    /**
     * Metodo que regresa una pelicula especificada por el codigo de barras.
     * @param codigoDeBarras String
     * @return Pelicula
     */
    public Pelicula getPelicula(String codigoDeBarras) {
        int indice;
        Pelicula peliculaARegresar;
        peliculaARegresar = catalogo.buscarPelicula(codigoDeBarras);
        int tamanoDelArregloPeliculas = peliculas.size();
        String codBarras = codigoDeBarras;
        for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            if (peliculas.get(indice).getCodigoDeBarras().contains(codBarras)) {
                peliculaARegresar = catalogo.buscarPelicula(codigoDeBarras);
            }
        }
        return peliculaARegresar;
    }
}
