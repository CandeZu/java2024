package ejercicio2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ejercicio_3_excepciones.excepcionesDeportista;
import ejercicio_3_excepciones.excepcionesEquipo;

import ejercicio2.modelos.Deportista;
import ejercicio2.modelos.Equipo;
import ejercicio2.modelos.Pareja;
import ejercicio2.interfaces_java.IDeporte;



public class Campeonato {
    public static final String SEPARADOR = ",";
	
    public static List<Deportista>leerArchivo(String nombreArchivo)throws IOException, excepcionesDeportista{
        BufferedReader bufferLectura = null;
        List<Deportista> datos = new ArrayList<>();
        try {
            bufferLectura = new BufferedReader(new FileReader(nombreArchivo));
            String linea;                  

            while ((linea=bufferLectura.readLine()) != null) {
             // Sepapar la linea leída con el separador definido previamente
            String[] campos = linea.split(SEPARADOR); 
            Deportista d = new Deportista(campos[0],campos[1],0);
            datos.add(d);           
            }
        } 
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
         // Cierro el buffer de lectura
        if (bufferLectura != null) {
            bufferLectura.close();
        }
        }
        return datos;
    }
    /**
    * Crea los equipos con los datos pasados como parámetro
    * @param datos lista con todos los deportistas inscriptos
     * @param cantidadJugadores cantidad de jugadores que conforman un equipo
     * @return una lista de equipos
    */
        
    public static List<IDeporte> creaEquipos(List<Deportista> datos, int cantidadJugadores) throws excepcionesDeportista, excepcionesEquipo {
        List<IDeporte> equipos = new ArrayList<>();
        ArrayList<Deportista> equipoActual = new ArrayList<>();
        List<String> dniAsignados = new ArrayList<>();
    
        for (Deportista d : datos) {
            if (!dniAsignados.contains(d.getDni())) {
                equipoActual.add(d);
                dniAsignados.add(d.getDni());
                if (equipoActual.size() == cantidadJugadores) {
                    try {
                        Equipo e = new Equipo(new ArrayList<>(equipoActual));
                        equipos.add(e);
                        equipoActual.clear();
                    } catch (excepcionesEquipo ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        }

        return equipos;
    }

        
    

    /**
    Crea los equipos con los datos pasados como parámetro
     * @param datos es una lista con todos los deportitas inscriptos
     * @return una lista de Parejas formadas
    */
    public static List<IDeporte> creaParejas(List<Deportista> datos) throws excepcionesDeportista, excepcionesEquipo {
        List<IDeporte> parejas = new ArrayList<>();
        Deportista deportista1 = null;
        Deportista deportista2 = null;
        List<String> dniAsignados = new ArrayList<>();
    
        for (Deportista d : datos) {
            if (!dniAsignados.contains(d.getDni())) {
                if (deportista1 == null) {
                    deportista1 = d;
                } else if (deportista2 == null) {
                    deportista2 = d;
                }
                dniAsignados.add(d.getDni());
                if (deportista1 != null && deportista2 != null) {
                    try {
                        Pareja p = new Pareja(deportista1, deportista2);
                        parejas.add(p);
                        deportista1 = null;
                        deportista2 = null;
                    } catch (excepcionesEquipo p) {
                        System.out.println(p.getMessage());
                    }
                }
            }
        }
        return parejas;
    }

/**
    * Numera cada integrante del equipo o de la pareja
     * @param datos 
    */
    public static void numerar(List<IDeporte> datos){
        int contador = 1;
        for (IDeporte d : datos) {
            System.out.println("Equipo " + contador + ":");
            d.numeroDeportista();
            System.out.println("------------------------");
            contador++;
        }
    }

    /**
    * Muestra los datos de cada equipo o de cada pareja
     * @param datos
    */
    public static void mostrar(List<IDeporte> datos){
        int contador = 1;
        for (IDeporte d : datos) {
            System.out.println("Equipo " + contador + ":");
            d.mostrar();
            System.out.println("------------------------");
            contador++;
        }
    }
     
}