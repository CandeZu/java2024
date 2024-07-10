package ejercicio_3_excepciones;

public class excepcionesDeportista extends Exception{
    public excepcionesDeportista(String message) {
        super(message);
    }

    public excepcionesDeportista(String message, Throwable cause) {
        super(message, cause);
    }

    public excepcionesDeportista(Throwable cause) {
        super(cause);
    }

}