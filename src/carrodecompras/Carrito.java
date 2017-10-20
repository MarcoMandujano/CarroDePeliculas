/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carrodecompras;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Carrito {
    private ArrayList<Pelicula> peliculas;

    public Carrito() {
        this.peliculas = new ArrayList<Pelicula>();
    }
    
    public Carrito(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    public void agregarPelicula(Pelicula pelicula) {
        this.peliculas.add(pelicula);
    }
    
    public void agregarPeliculas(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    public ArrayList<Pelicula> regresaPeliculas() {
        return this.peliculas;
    }
    
    public boolean eliminarPelicula(Pelicula pelicula) {
        int indice;
        int tamanoDelArregloPeliculas = peliculas.size();
        boolean eliminado = false;
        for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            if (pelicula.equals(peliculas.get(indice)) == true) {
                peliculas.remove(indice);
                eliminado = true;
            }
        }
        return eliminado;
    }
    
    /**
     * Regresa -1 si no se encontro la pelicula.
     * Regresa un numero mayor a 0 correspondiente al susbtotal de la pelicula solicitada.
     * 
     * @param pelicula
     * @param cantidad
     * @return double.
     */
    public double subTotal(int indice) {
        double subtotal = -1, precio, cantidad;
        int tamanoDelArregloPeliculas = peliculas.size();
        //for (indice = 0; indice < tamanoDelArregloPeliculas; indice++) {
            //if(pelicula.equals(peliculas.get(indice)) == true) {
            precio = this.peliculas.get(indice).getPrecio();
            cantidad = this.peliculas.get(indice).getCantidad();
            subtotal = precio * cantidad;
            //}
        //}
        return subtotal;
    }
    
    public double total() {
        double total = -1;
        int indice;
        int tamanoDelArregloPeli = this.peliculas.size();
        for (indice = 0; indice < tamanoDelArregloPeli; indice++) {
            total += this.peliculas.get(indice).getPrecio() * this.peliculas.get(indice).getCantidad();
        }
        return total;
    }
}
