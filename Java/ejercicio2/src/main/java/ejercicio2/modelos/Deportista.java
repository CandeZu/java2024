package ejercicio2.modelos;
import ejercicio_3_excepciones.excepcionesDeportista;

public class Deportista {
    private String nombre;
    private String dni;
    private int numeroJugador;

    public Deportista(String nombre, String dni, int numeroJugador) throws excepcionesDeportista{
        if(dni == null || dni.equals("") || dni.isBlank() || dni.equals("null")){
            throw new excepcionesDeportista("El DNI no puede estar vacio");
        }else{
            this.dni = dni;
        }
        if (nombre == null || nombre.equals("") || nombre.isBlank() || nombre.equals("null")){
            throw new excepcionesDeportista("El nombre no puede estar vacio");
        }else{
            this.nombre = nombre;
        }
        this.numeroJugador = numeroJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public int getNumeroJugador() {
        return numeroJugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }

    @Override 
    public String toString(){
        return "Nombre: " + nombre + " DNI: " + dni + " Numero de Jugador: " + numeroJugador;
    }
}

