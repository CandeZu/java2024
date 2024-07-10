package ejercicio2;


import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import ejercicio2.interfaces_java.IDeporte;
import ejercicio2.modelos.Deportista;
import ejercicio_3_excepciones.excepcionesDeportista;
import ejercicio_3_excepciones.excepcionesEquipo;

public class Main {

    public static void main(String[] args) throws IOException, excepcionesDeportista, excepcionesEquipo {
        int cantidadJugadoresFutbol = 5;             
    
        List<Deportista> datosFutbol = Campeonato.leerArchivo("C:\\Users\\Cande\\Documents\\Facultad\\java\\Java\\ejercicio2\\src\\main\\java\\ejercicio2\\datos\\inscriptosFutbol.csv");
        List<IDeporte> ListaEquiposFutbol = Campeonato.creaEquipos(datosFutbol, cantidadJugadoresFutbol);
        List<Deportista> datosPinPon = Campeonato.leerArchivo("C:\\Users\\Cande\\Documents\\Facultad\\java\\Java\\ejercicio2\\src\\main\\java\\ejercicio2\\datos\\inscriptosPinPon.csv");
        List<IDeporte> ListaEquiposPinPon = Campeonato.creaParejas(datosPinPon);

        int opcion;
        Scanner scanner = new Scanner(System.in);
        do {
            // Menu de opciones
            System.out.println("1. Mostrar Equipos de futbol");
            System.out.println("2. Mostrar Equipos de pin pon");
            System.out.println("3. Numerar Equipo de futbol");
            System.out.println("4. Numerar Equipo de pin pon");
            System.out.println("5. Salir");
            System.out.println("Ingrese una opción: ");
            
            // Leer la opción ingresada por el usuario
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println("Equipos de futbol:");
                    System.out.println("------------------------");
                    Campeonato.mostrar(ListaEquiposFutbol);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Equipos de pin pon");
                    System.out.println("------------------------");
                    Campeonato.mostrar(ListaEquiposPinPon);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Numeracion Equipos de futbol");
                    Campeonato.numerar(ListaEquiposFutbol);
                    break;
                case 4:
                    System.out.println("Numeracion Equipos de pin pon");
                    Campeonato.numerar(ListaEquiposPinPon);
                    break;
                case 5:
                    System.exit(0);
                    scanner.close();
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != -1);
    }
}
