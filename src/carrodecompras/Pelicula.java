package carrodecompras;

/**
 *
 * @author Marco
 */
public class Pelicula {
    private int codigoDeBarras;
    private String titulo;
    private String actorPrincipal;
    private String genero;
    private double precio;

    public Pelicula(int codigoDeBarras, String titulo, String actorPrincipal, String genero, double precio) {
        this.codigoDeBarras = codigoDeBarras;
        this.titulo = titulo;
        this.actorPrincipal = actorPrincipal;
        this.genero = genero;
        this.precio = precio;
    }

    public int getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(int codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
