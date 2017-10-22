/*
 * Se agrego esta clase en la fase de codificacion de PSP y se encuentra a
 *  partir de la version 1.4 de github
 * Se agregaron 1 linea de codigo ya existente
 */
package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public class Archivo {
    /**
     * nombreArchivo tipo String, es el nombre del archivo donde se encuentran todas las películas.
     */
    private String nombreArchivo;
    /**
     * Efichero tipo File, Objeto para manipuar el archivo donde se encuentran todas las películas.
     */    
    private File Ffichero;
    /**
     * Constructor que recibe como parametros el nombre del archvio a crear
     *  y su direccion.
     * @param nombreArchivo String
     */
    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.Ffichero = new File(this.nombreArchivo + ".txt");
    }
    /**
     * Metodo que escibe una pelicula en el archivo.
     * Regresa true si la pelicula fue escrita exitosamente en el archivo.
     * Regresa false si la pelicula no fue escrita en el archivo.
     * @param pelicula Pelicula
     * @return boolean
     */
    public boolean escribirPelicula(Pelicula pelicula) { 
        boolean escrito = true;
        String codigoDeBarras = pelicula.getCodigoDeBarras();
        String titulo = pelicula.getTitulo();
        String actorPrincipal = pelicula.getActorPrincipal();
        String genero = pelicula.getGenero();
        String precio = String.valueOf(pelicula.getPrecio());
        try {
            //si no existe el archivo, entonces lo crea
            if (!Ffichero.exists()) {
                Ffichero.createNewFile();
            }
            /*
             *Abre un Flujo de escritura,sobre el fichero con
             *codificacion utf-8.
             *Además  en el pedazo de sentencia
             *"FileOutputStream(Ffichero,true)", true es por si existe el
             *fichero seguir añadiendo texto y no borrar lo que
             *tenia ya escrito.
            */
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función.*/
            Fescribe.write("°" + codigoDeBarras + "|" + titulo + "¬" + actorPrincipal + "¨" + genero+ "~" + precio + "^" + "\r\n");
            /*Cierra el flujo de escritura*/
            Fescribe.close();
        } catch (Exception ex) {
            /*Captura un posible error le imprime en pantalla*/
            System.out.println("Error en escritura!!! " + ex.getMessage());
            escrito = false;
        }
        return escrito;
    }
    /**
     * Metodo que regresa todas las peliculas que contiene el archivo.
     * @return ArrayList
     */
    public ArrayList<Pelicula> leerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        String infoPelicula, cadena;
        int inicio, fin, indice = 0;
        try {
            /*Si existe el fichero*/
            if (Ffichero.exists()) {
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                /*Lee el fichero linea a linea hasta llegar a la ultima*/
                while ((Slinea = Flee.readLine()) != null) {
                    Pelicula pelicula = new Pelicula();
                    infoPelicula = Slinea;

                    inicio = infoPelicula.indexOf("°");
                    fin = infoPelicula.lastIndexOf("|");
                    cadena = Slinea.substring(inicio + 1, fin);
                    pelicula.setCodigoDeBarras(cadena);

                    inicio = infoPelicula.indexOf("|");
                    fin = infoPelicula.lastIndexOf("¬");
                    cadena = Slinea.substring(inicio + 1, fin);
                    pelicula.setTitulo(cadena);

                    inicio = infoPelicula.indexOf("¬");
                    fin = infoPelicula.lastIndexOf("¨");
                    cadena = Slinea.substring(inicio + 1, fin);
                    pelicula.setActorPrincipal(cadena);

                    inicio = infoPelicula.indexOf("¨");
                    fin = infoPelicula.lastIndexOf("~");
                    cadena = Slinea.substring(inicio + 1, fin);
                    pelicula.setGenero(cadena);

                    inicio = infoPelicula.indexOf("~");
                    fin = infoPelicula.lastIndexOf("^");
                    cadena = Slinea.substring(inicio + 1, fin);
                    pelicula.setPrecio(Double.parseDouble(cadena));
                    /*Añade la pelicula al ArrayList que sera devuelto*/
                    peliculas.add(indice, pelicula);
                    indice++;
                }
                /*Cierra el flujo*/
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println("Error en escritura!!! " + ex.getMessage());
        }
        return peliculas;
    }
    /**
     * Metodo que borra una peliucla del archivo.
     * Recibe como parametro el codigo de barras de la pelicula a borrar.
     * @param codigoDeBarras String
     * @return boolean
     */
    public boolean borrarPelicula(String codigoDeBarras) {
        String codigo = codigoDeBarras;
        boolean borrada = true;
        int cont = 0;
        String nombreFicheroInicial;
        File nuevo = new File(Ffichero.getParent() + "temporal.txt");
        try {
            /*Si existe el fichero*/
            if (Ffichero.exists()) {
                if (!nuevo.exists()) {
                nuevo.createNewFile();
                }
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nuevo, true), "utf-8"));
                String Slinea;
                /*Lee el fichero linea a linea hasta llegar a la ultima*/
                while ((Slinea = Flee.readLine()) != null) {
                    //busca linea por linea el codigo de barras correspondiente
                    if (!Slinea.contains(codigo) || cont > 0) {
                        Fescribe.write(Slinea + "\r\n");
                    }
                    if (Slinea.contains(codigo)) {
                        cont++;
                    }
                    /*Imprime la linea leida*/
                    System.out.println(Slinea);
                }
                /*Cierra el flujo*/
                Flee.close();
                Fescribe.close();
                /*Se guarda el nombre del archivo viejo que se va a borrar.*/
                nombreFicheroInicial = Ffichero.getName();
                /*Se borra el archivo viejo*/
                Ffichero.delete();
                /*Se asigna el nombre del archivo ciejo al nuevo*/
                nuevo.renameTo(Ffichero);
                borrada = true;
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            borrada = false;
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println("Error en escritura!!! " + ex.getMessage());
        }
        return borrada;
    }
    /**
     * Metodo que busca la pelicula por codigo de barras.
     * @param codigoDeBarras String
     * @return Pelicula
     */
    public Pelicula buscarPelicula(String codigoDeBarras) {
        String codigo = codigoDeBarras;
        String infoPelicula, cadena;
        int inicio, fin;
        Pelicula peliculaABuscar = new Pelicula();
        try {
            /*Si existe el fichero*/
            if (Ffichero.exists()) {
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                /*Lee el fichero linea a linea hasta llegar a la ultima*/
                while((Slinea = Flee.readLine()) != null) {
                    /*
                     *Busca linea por linea el codigo de barras
                     *correspondiente
                    */
                    if (Slinea.contains(codigo)) {
                        infoPelicula = Slinea;
                        peliculaABuscar.setCodigoDeBarras(codigo);
                        inicio = infoPelicula.indexOf("|");
                        fin = infoPelicula.lastIndexOf("¬");
                        cadena = Slinea.substring(inicio + 1, fin);
                        peliculaABuscar.setTitulo(cadena);
                        inicio = infoPelicula.indexOf("¬");
                        fin = infoPelicula.lastIndexOf("¨");
                        cadena = Slinea.substring(inicio + 1, fin);
                        peliculaABuscar.setActorPrincipal(cadena);
                        inicio = infoPelicula.indexOf("¨");
                        fin = infoPelicula.lastIndexOf("~");
                        cadena = Slinea.substring(inicio + 1, fin);
                        peliculaABuscar.setGenero(cadena);
                        inicio = infoPelicula.indexOf("~");
                        fin = infoPelicula.lastIndexOf("^");
                        cadena = Slinea.substring(inicio + 1, fin);
                        peliculaABuscar.setPrecio(Double.parseDouble(cadena));
                        /*
                         *Cuando encuentra que el codigo de barras buscado
                         *es compatible con uno del archivo, entonces termina
                         *el ciclo.
                        */
                        break;
                    }
                }
                /*Cierra el flujo*/
                Flee.close();
            } else {
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/
            System.out.println("Error en escritura!!! " + ex.getMessage());
        }
        return peliculaABuscar;
    }
}
