/*
 * Se agrego esta clase en la fase de codificacion de PSP y se encuentra a partir de la version 1.4 de github
 * Se agregaron 1 linea de codigo ya existente
 */
package carrodecompras;

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
public class Archivos {
    private String nombreArchivo;
    private String direccionDelArchivo;
    private File Ffichero;

    public Archivos(String nombreArchivo, String direccionDelArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.direccionDelArchivo = direccionDelArchivo;
        this.Ffichero = new File(this.direccionDelArchivo + this.nombreArchivo + ".txt");
    }
    
    public boolean escribirPelicula(Pelicula pelicula) { 
        boolean escrito = true;
        String codigoDeBarras = String.valueOf(pelicula.getCodigoDeBarras());
        String titulo = pelicula.getTitulo();
        String actorPrincipal = pelicula.getActorPrincipal();
        String genero = pelicula.getGenero();
        String precio = String.valueOf(pelicula.getPrecio());
        
        try {
            //si no existe el archivo, entonces lo crea
            if(!Ffichero.exists()){
                Ffichero.createNewFile();
            }
            /*Abre un Flujo de escritura,sobre el fichero con codificacion utf-8. 
             *Además  en el pedazo de sentencia "FileOutputStream(Ffichero,true)",
             *true es por si existe el fichero seguir añadiendo texto y no borrar lo que tenia
            */
            BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Ffichero, true), "utf-8"));
            /*Escribe en el fichero la cadena que recibe la función.*/
            Fescribe.write("°" + codigoDeBarras + "|" + titulo + "¬" + actorPrincipal + "¨" + genero+ "~" + precio + "^" + "\r\n");
            //Cierra el flujo de escritura
            Fescribe.close();
        } catch (Exception ex) {
            //Captura un posible error le imprime en pantalla 
            System.out.println("Error en escritura!!!\nMensaje: " + ex.getMessage());
            escrito = false;
        }
        return escrito;
    }
    
    public ArrayList<Pelicula> leerPeliculas() {
        ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
        String infoPelicula, cadena;
        int inicio, fin, indice = 0;
        
        try {
            /*Si existe el fichero*/
            if(Ffichero.exists()){
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                System.out.println("**********Leyendo Fichero***********");
                /*Lee el fichero linea a linea hasta llegar a la ultima*/
                while((Slinea = Flee.readLine()) != null) {
                    Pelicula pelicula = new Pelicula();
                    infoPelicula = Slinea;

                    inicio = infoPelicula.indexOf("°");
                    fin = infoPelicula.lastIndexOf("|");
                    cadena = Slinea.substring(inicio + 1, fin);
                    pelicula.setCodigoDeBarras(Integer.valueOf(cadena));

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

                    peliculas.add(indice, pelicula);
                    /*Imprime la linea leida*/    
                    System.out.println(infoPelicula);    
                    indice++;
                }
                System.out.println("*********Fin Leer Fichero**********");
                /*Cierra el flujo*/
                Flee.close();
                
                
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
            System.out.println("Error en escritura!!!\nMensaje: " + ex.getMessage());
        }
        return peliculas;
    }
    
    public boolean borrarPelicula(int codigoDeBarras) {
        String codigo = String.valueOf(codigoDeBarras);
        boolean borrada = true;
        String nombreFicheroInicial;
        File nuevo = new File(Ffichero.getParent() + "temporal.txt");
        
        try {
            /*Si existe el fichero*/
            if(Ffichero.exists()){
                if(!nuevo.exists()){
                nuevo.createNewFile();
                }
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                BufferedWriter Fescribe = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(nuevo, true), "utf-8"));
                String Slinea;
                System.out.println("**********Leyendo Fichero***********");
                /*Lee el fichero linea a linea hasta llegar a la ultima*/
                while((Slinea = Flee.readLine()) != null) {
                    //busca linea por linea el codigo de barras correspondiente
                    if (Slinea.contains(codigo) == false) {
                        Fescribe.write(Slinea);
                    }
                    /*Imprime la linea leida*/    
                    System.out.println(Slinea);              
                }
                System.out.println("*********Fin Leer Fichero**********");
                /*Cierra el flujo*/
                Flee.close();
                Fescribe.close();
                nombreFicheroInicial = Ffichero.getName();
                Ffichero.delete();
                nuevo.renameTo(Ffichero);
                borrada = true;
                
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            borrada = false;
            /*Captura un posible error y le imprime en pantalla*/ 
            System.out.println("Error en escritura!!!\nMensaje: " + ex.getMessage());
        }
        
        return borrada;
    }
    
    /**
     * Se busca la pelicula por codigo de barras. 
     * @param pelicula
     * @return Pelicula que se encontro
     */
    public Pelicula buscarPelicula(int codigoDeBarras) {
        String codigo = String.valueOf(codigoDeBarras);
        String infoPelicula, cadena;
        int inicio, fin;
        Pelicula peliculaABuscar = new Pelicula();
        
        try {
            /*Si existe el fichero*/
            if(Ffichero.exists()){
                /*Abre un flujo de lectura a el fichero*/
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                System.out.println("**********Leyendo Fichero***********");
                /*Lee el fichero linea a linea hasta llegar a la ultima*/
                while((Slinea = Flee.readLine()) != null) {
                    //busca linea por linea el codigo de barras correspondiente
                    if (Slinea.contains(codigo) == true) {
                        infoPelicula = Slinea;
                        peliculaABuscar.setCodigoDeBarras(Integer.valueOf(codigo));
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
                        
                        break;
                    }
                    /*Imprime la linea leida*/    
                    System.out.println(Slinea);              
                }
                System.out.println("*********Fin Leer Fichero**********");
                /*Cierra el flujo*/
                Flee.close();
                
                
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
            System.out.println("Error en escritura!!!\nMensaje: " + ex.getMessage());
        }
        
        return peliculaABuscar;
    }
    
    /*public boolean modificarPelicula(Pelicula pelicula) {
        boolean modificada = true;
        
        return modificada;
    }*/
}
