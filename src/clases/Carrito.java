/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Carrito {
    /**
     * peliculas tipo ArrayList de Pelicula, se guardaran aqui todas las películas que se encuentran disponibles para el usuario.
     */
    private ArrayList<Pelicula> peliculas;
    /**
     * Constructor vacio.
     */
    public Carrito() {
        this.peliculas = new ArrayList<Pelicula>();
    }
    /**
     * Cosntructor que recibe como parametros un ArrayList lleno de objetos
     * tipo Pelicula.
     * @param peliculas ArrayList de tipo Pelicula
     */
    public Carrito(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    /**
     * Metodo para agregar una pelicula al ArrayList de catalogo.
     * @param pelicula Pelicula
     */
    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }
    /**
     * Metodo para agregar un Arraylist de tipo Peliculas al carrito.
     * Nota: Se borrara el viejo ArrayList de Peliculas.
     * @param peliculas ArrayList de tipo Pelicula
     */
    public void agregarPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    /**
     * Metodo para regresar todas las peliculas del Carrito.
     * @return ArrayList
     */
    public ArrayList<Pelicula> regresaPeliculas() {
        return this.peliculas;
    }
    /**
     * Metodo para eliminar una pelicula del ArrayList de tipo peliculas,
     * el metodo borrara la pelicula del carrito.
     * Regresa true si la pelicula fue eliminada y false si la pelicula no
     * fue eliminada.
     * @param pelicula Pelicula
     * @return boolean.
     */
    public boolean eliminarPelicula(Pelicula pelicula) {
        int indice;
        int tamanoDelArregloPeliculas = this.peliculas.size();
        boolean eliminado = false;
        String codBarras, coBarr;
        double cantidad, cant;
        for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            coBarr = pelicula.getCodigoDeBarras();
            codBarras = this.peliculas.get(indice).getCodigoDeBarras();
            cantidad = pelicula.getCantidad();
            cant = this.peliculas.get(indice).getCantidad();
            if (codBarras.contains(coBarr) && cant == cantidad) {
                this.peliculas.remove(indice);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    /**
     * Metodo que calcula el subtoral de una pelicula.
     * Regresa 0 si no se calculo el subtotal.
     * Regresa un numero mayor a 0 correspondiente al susbtotal
     * de la pelicula solicitada.
     * @param indice int
     * @return double.
     */
    public double subTotal(int indice) {
        double subtotal, precio, cantidad;
        precio = this.peliculas.get(indice).getPrecio();
        cantidad = this.peliculas.get(indice).getCantidad();
        subtotal = precio * cantidad;
        return subtotal;
    }
    /**
     * Metodo que calcula el precio total de las peliculas que fueron agregadas
     * al carro de compras.
     * Regresa la cantidad total que lleva acumulado el carro de compras.
     * @return double
     */
    public double total() {
        double total = 0;
        int indice;
        int tamanoDelArregloPeli = this.peliculas.size();
        double precio, cantidad;
        for (indice = 0; indice < tamanoDelArregloPeli; indice++) {
            precio = this.peliculas.get(indice).getPrecio();
            cantidad = this.peliculas.get(indice).getCantidad();
            total += precio * cantidad;
        }
        return total;
    }
}
