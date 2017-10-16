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

    public Carrito(ArrayList<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    
    public void agregarPelicula(Pelicula pelicula) {
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
    
    /**
     * Regresa -1 si no se encontro la pelicula.
     * Regresa un numero mayor a 0 correspondiente al susbtotal de la pelicula solicitada.
     * 
     * @param pelicula
     * @param cantidad
     * @return double.
     */
    public double subTotal(Pelicula pelicula, int cantidad) {
        double subtotal = -1;
        int indice;
        int tamanoDelArregloPeliculas = peliculas.size();
        for (indice = 0; indice <= tamanoDelArregloPeliculas; indice++) {
            if(pelicula.equals(peliculas.get(indice)) == true) {
                subtotal = pelicula.getPrecio() * cantidad;
            }
        }
        return subtotal;
    }
    
    public double total(ArrayList<Pelicula> peli) {
        double total = -1;
        int indice;
        int tamanoDelArregloPeli = peli.size();
        for (indice = 0; indice <= tamanoDelArregloPeli; indice++) {
            total =+ peli.get(indice).getPrecio();
        }
        return total;
    }
}
