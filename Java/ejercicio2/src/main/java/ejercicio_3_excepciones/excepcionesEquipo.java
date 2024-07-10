package ejercicio_3_excepciones;

public class excepcionesEquipo extends Exception{
    public excepcionesEquipo(String message) {
        super(message);
    }

    public excepcionesEquipo(String message, Throwable cause) {
        super(message, cause);
    }

    public excepcionesEquipo(Throwable cause) {
        super(cause);
    }
}
