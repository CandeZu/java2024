package parcial32024;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Agregar Agente");
            System.out.println("3. Mostrar Morosos");
            System.out.println("4. Mostrar Total de Socios");
            System.out.println("5. Mostrar Socios Exceptuados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre del alumno: ");
                    String nombreAlumno = scanner.nextLine();
                    System.out.print("Ingrese cuota del alumno: ");
                    float cuotaAlumno = scanner.nextFloat();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese registro del alumno: ");
                    String registro = scanner.nextLine();
                    System.out.print("Ingrese carrera del alumno: ");
                    String carrera = scanner.nextLine();
                    biblioteca.addSocio(new Alumno(nombreAlumno, cuotaAlumno, registro, carrera));
                    System.out.println("Alumno agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese nombre del agente: ");
                    String nombreAgente = scanner.nextLine();
                    System.out.print("Ingrese cuota del agente: ");
                    float cuotaAgente = scanner.nextFloat();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.print("Ingrese CUIL del agente: ");
                    String cuil = scanner.nextLine();
                    System.out.print("Ingrese domicilio del agente: ");
                    String domicilio = scanner.nextLine();
                    biblioteca.addSocio(new Agente(nombreAgente, cuotaAgente, cuil, domicilio));
                    System.out.println("Agente agregado.");
                    break;
                case 3:
                    // List<String> morosos = biblioteca.morosos();
                    // System.out.println("Morosos:");
                    // morosos.forEach(System.out::println);
                    biblioteca.morosos();
                    break;
                case 4:
                    int totalSocios = biblioteca.totalSocios();
                    System.out.println("Total de Socios: " + totalSocios);
                    break;
                case 5:
                    List<String> exceptuados = biblioteca.exceptuados();
                    System.out.println("Socios Exceptuados:");
                    exceptuados.forEach(System.out::println);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
