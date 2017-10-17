package carrodecompras;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Catalogo {
    private ArrayList<Pelicula> peliculas;
    
    //se agrego el constructor vacio Catalogo en la version 1.2 del proyecto.
    public Catalogo() {
        Pelicula pelicula = new Pelicula(-1, null, null, null, 0);
        this.peliculas.add(pelicula);
    }
    
    public Catalogo(ArrayList<Pelicula> Peliculas) {
        this.peliculas = Peliculas;
    }
    
    public void agregarPrelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }
    
    public boolean eliminarPelicula(Pelicula pelicula) {
        int indice;
        int tamanoDelArregloPeliculas = peliculas.size();
        boolean eliminado = false;
        for (indice = 0; indice <= tamanoDelArregloPeliculas; indice++) {
            if(pelicula.equals(peliculas.get(indice)) == true) {
                peliculas.remove(indice);
                eliminado = true;
            }
        }
        return eliminado;
    }
    
    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
    
    /**
     * 
     * @param codigoDeBarras
     * @return Objeto pelicula con la pelicula que se busco por el codigo de barras. En caso de que no exista la pelicula entonces 
     *         se regresara un objeto Pelicula con codigo de barras igual a -1.
     */
    public Pelicula getPelicula(int codigoDeBarras) {
        int indice;
        Pelicula peliculaARegresar = new Pelicula(-1, null, null, null, 0);
        int tamanoDelArregloPeliculas = peliculas.size();
        for (indice = 0; indice <= tamanoDelArregloPeliculas; indice++) {
            if(codigoDeBarras == peliculas.get(indice).getCodigoDeBarras()) {
                peliculaARegresar = peliculas.get(indice);
            }
        }
        return peliculaARegresar;
    }
}
