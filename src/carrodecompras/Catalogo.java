//se modificaron los metodos de la clase en la version 1.4

package carrodecompras;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Catalogo {
    private ArrayList<Pelicula> peliculas;
    private Archivos catalogo;
    
    //se agrego el constructor vacio Catalogo en la version 1.2 del proyecto.
//    public Catalogo() {
//        Pelicula pelicula = new Pelicula(-1, null, null, null, 0);
//        this.peliculas.add(pelicula);
//    }    
    public Catalogo() {
        //this.peliculas = peliculas;
        this.peliculas = new ArrayList<Pelicula>();
        this.catalogo = new Archivos("catalogo", "C:\\Users\\Marco\\Desktop");
    }
    
    public boolean agregarPrelicula(Pelicula pelicula) {
        boolean agregada;
        this.peliculas.add(pelicula);
        int ultPelicula = peliculas.size() - 1;
        agregada = catalogo.escribirPelicula(peliculas.get(ultPelicula));
        return agregada;
    }
    
    public boolean eliminarPelicula(Pelicula pelicula) {
        int indice;
        int tamanoDelArregloPeliculas = peliculas.size();
        boolean eliminado = false;
        String codgBarras;
        for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            codgBarras = this.peliculas.get(indice).getCodigoDeBarras();
            if (pelicula.getCodigoDeBarras().contains(codgBarras)) {
                eliminado = catalogo.borrarPelicula(pelicula.getCodigoDeBarras());
                peliculas.remove(indice);
                tamanoDelArregloPeliculas = peliculas.size();
            }
        }
        return eliminado;
    }
    
    public ArrayList<Pelicula> getPeliculas() {
        this.peliculas = catalogo.leerPeliculas();
        return this.peliculas;
    }
    
    /**
     * 
     * @param codigoDeBarras
     * @return Objeto pelicula con la pelicula que se busco por el codigo de barras. En caso de que no exista la pelicula entonces 
     *         se regresara un objeto Pelicula con codigo de barras igual a -1.
     */
    public Pelicula getPelicula(String codigoDeBarras) {
        int indice;
        Pelicula peliculaARegresar;
        peliculaARegresar = catalogo.buscarPelicula(codigoDeBarras);
        int tamanoDelArregloPeliculas = peliculas.size();
        String codBarras = codigoDeBarras;
        for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            if (peliculas.get(indice).getCodigoDeBarras().contains(codBarras)) {
                //peliculaARegresar = peliculas.get(indice);
                peliculaARegresar = catalogo.buscarPelicula(codigoDeBarras);
            }
        }
        return peliculaARegresar;
    }
}
