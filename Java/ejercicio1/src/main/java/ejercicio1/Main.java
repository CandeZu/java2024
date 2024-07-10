package ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestorViajero = new Gestor(10);
        Scanner op = new Scanner(System.in);

        int opc = -1;
        while (opc != 0) {
            System.out.println("1. Agregar viajero");
            System.out.println("2. Mostrar viajero");
            System.out.println("3. Consultar cantidad de millas");
            System.out.println("4. Acumular millas");
            System.out.println("5. Canjear millas");
            System.out.println("6. Mostrar mejor viajero");
            System.out.println("0. Salir");

            if(op.hasNextInt()) {
                opc = op.nextInt();
            } else {
                System.out.println("Ingrese un número válido");
                op.next();
                continue;
            }

            switch (opc) {
                case 1: 
                System.out.println("Ingrese el número de viajero");
                int numero = op.nextInt();
                System.out.println("Ingrese el DNI");
                String dni = op.next();
                System.out.println("Ingrese el nombre");
                String nombre = op.next();
                System.out.println("Ingrese el apellido");
                String apellido = op.next();
                System.out.println("Ingrese la cantidad de millas");
                int millas = op.nextInt();
                ViajeroFrecuente viajero = new ViajeroFrecuente(numero, dni, nombre, apellido, millas);
                gestorViajero.agregarViajero(viajero);
                break;
                
                case 2:
                System.out.println("Ingrese el número de viajero");
                numero = op.nextInt();
                gestorViajero.mostrarViajero(numero);
                break;

                case 3:
                System.out.println("Ingrese el dni de viajero");
                dni = op.next();
                int mil = gestorViajero.consultarMillas(dni);
                if (mil != -1) {
                    System.out.println("Las millas del viajero son: " + mil);
                } else {
                    System.out.println("No se encontró el viajero");
                    
                }
                break;

                case 4:
                System.out.println("Ingrese el dni de viajero");
                dni = op.next();
                System.out.println("Ingrese la cantidad de millas a acumular");
                int millasAcumular = op.nextInt();
                gestorViajero.acumularMillas(dni, millasAcumular);
                break;

                case 5:
                System.out.println("Ingrese el dni de viajero");
                dni = op.next();
                System.out.println("Ingrese la cantidad de millas a canjear");
                int millasCanjear = op.nextInt();
                gestorViajero.canjearMillas(dni, millasCanjear);
                break;

                case 6:
                gestorViajero.mejorViajero();
                break;

                case 0:
                System.out.println("Saliendo...");
                break;

                default:
                System.out.println("Ingrese una opción válida");
                break;
            }

        }
        op.close();
    }
}