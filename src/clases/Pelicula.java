package clases;

/**
 *
 * @author Marco
 */
public class Pelicula {
    /**
     * Atributo Codigo de barras de tipo String.
     */
    private String codigoDeBarras;
    /**
     * Atributo Titulo de tipo String.
     */
    private String titulo;
    /**
     * Atributo Actor principal de tipo String.
     */
    private String actorPrincipal;
    /**
     * Atributo Genero de tipo String.
     */
    private String genero;
    /**
     * Atributo Precio de tipo String.
     */
    private double precio;
    /**
     * Atributo Cantidad de tipo String.
     */
    private double cantidad;
    /**
     * Constructor vacio.(Genera una pelicula con cadenas vacias, precio igual
     *  a 0 y cantidad igua a 0).
     */
    public Pelicula() {
        this.codigoDeBarras = "";
        this.titulo = "";
        this.actorPrincipal = "";
        this.genero = "";
        this.precio = 0;
        this.cantidad = 0;
    }
    /**
     * Constructor que recibe todos los parametros para generar una pelicula.
     * @param codigoDeBarras String
     * @param titulo String
     * @param actorPrincipal String
     * @param genero String
     * @param precio double
     * @param cantidad double
     */
    public Pelicula(String codigoDeBarras, String titulo, String actorPrincipal, String genero, double precio, double cantidad) {
        this.codigoDeBarras = codigoDeBarras;
        this.titulo = titulo;
        this.actorPrincipal = actorPrincipal;
        this.genero = genero;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    /**
     * Metodo que regresa el codigo de barras del objeto pelicula.
     * @return String
     */
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    /**
     * Metodo que recibe un codigo de barras y lo asigna al objeto pelicula.
     * @param codigoDeBarras String
     */
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    /**
     * Metodo que regresa el titulo del objeto pelicula.
     * @return String
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * Metodo que recibe un titulo y lo asigna al objeto pelicula.
     * @param titulo String
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * Metodo que regresa el actor principal del objeto pelicula.
     * @return String
     */
    public String getActorPrincipal() {
        return actorPrincipal;
    }
    /**
     * Metodo que recibe un actor principal y lo asigna al objeto pelicula.
     * @param actorPrincipal  String
     */
    public void setActorPrincipal(String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }
    /**
     * Metodo que regresa el genero del objeto pelicula.
     * @return String
     */
    public String getGenero() {
        return genero;
    }
    /**
     * Metodo que recibe un genero y lo asigna al objeto pelicula.
     * @param genero String
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }
    /**
     * Metodo que regresa el precio del objeto pelicula.
     * @return String
     */
    public double getPrecio() {
        return precio;
    }
    /**
     * Metodo que recibe un precio y lo asigna al objeto pelicula.
     * @param precio String
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    /**
     * Metodo que regresa la cantidad del objeto pelicula.
     * @return String
     */
    public double getCantidad() {
        return cantidad;
    }
    /**
     * Metodo que recibe una cantidad y la asigna al objeto pelicula.
     * @param cantidad String
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
}
