package carrodecompras;

/**
 *
 * @author Marco
 */
public class Pelicula {
    private String codigoDeBarras;
    private String titulo;
    private String actorPrincipal;
    private String genero;
    private double precio;

    public Pelicula() {
        this.codigoDeBarras = "";
        this.titulo = "";
        this.actorPrincipal = "";
        this.genero = "";
        this.precio = 0;
    }
    
    public Pelicula(String codigoDeBarras, String titulo, String actorPrincipal, String genero, double precio) {
        this.codigoDeBarras = codigoDeBarras;
        this.titulo = titulo;
        this.actorPrincipal = actorPrincipal;
        this.genero = genero;
        this.precio = precio;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
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
