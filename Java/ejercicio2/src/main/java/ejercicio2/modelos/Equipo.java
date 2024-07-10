package ejercicio2.modelos;
import ejercicio2.interfaces_java.IDeporte;
import java.util.ArrayList;
import ejercicio_3_excepciones.excepcionesEquipo;


public class Equipo implements IDeporte{
    private ArrayList<Deportista> equipoActual;


    public Equipo(ArrayList<Deportista> equipoActual) throws excepcionesEquipo{ 
        if (!conformar(equipoActual)) {
            throw new excepcionesEquipo("No se pudo conformar el equipo");
        }
        asignarNumerosAJugadores();
    }

    private void asignarNumerosAJugadores(){
        int numeroJugador = 1;
        for (Deportista d : equipoActual) {
            d.setNumeroJugador(numeroJugador);
            numeroJugador++;
        }
    }

    @Override
    public boolean conformar(ArrayList<Deportista> integrantes) {
        if (integrantes == null || integrantes.size() < CANTIDAD_MINIMA) {
            return false;
        }
        
        this.equipoActual = integrantes;
        return true;
    }
    
    @Override
    public void mostrar() {
        for (Deportista d : equipoActual) {
            System.out.println(d);
        }
    }

    @Override
    public void numeroDeportista() {
        for (Deportista d : equipoActual) {
            System.out.println(d.getNumeroJugador());
        }
    }

}