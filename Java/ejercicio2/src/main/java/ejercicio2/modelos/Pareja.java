package ejercicio2.modelos;

import java.util.ArrayList;
import ejercicio2.interfaces_java.IDeporte;

import ejercicio_3_excepciones.excepcionesEquipo;


public class Pareja implements IDeporte{
    private Deportista deportista1;
    private Deportista deportista2;

    public Pareja(Deportista deportista1, Deportista deportista2) throws excepcionesEquipo{
        if (!conformar(new ArrayList<Deportista>(){{add(deportista1); add(deportista2);}})){
            throw new excepcionesEquipo("Deben haber dos deportistas para conformar una pareja");
        }
        asignarNumerosAJugadores();
    }

    public void asignarNumerosAJugadores(){
        deportista1.setNumeroJugador(1);
        deportista2.setNumeroJugador(2);
    }

    @Override
    public boolean conformar(ArrayList<Deportista> integrantes){
        if (integrantes == null || integrantes.size() < CANTIDAD_MINIMA) {
            return false;
        }
        this.deportista1 = integrantes.get(0);
        this.deportista2 = integrantes.get(1);
        return true;
    }
    
    @Override
    public void mostrar() {
        System.out.println("Deportista 1: " + deportista1);
        System.out.println("Deportista 2: " + deportista2);
    }

    @Override
    public void numeroDeportista() {
        System.out.println("Número deportista 1: " + deportista1.getNumeroJugador());
        System.out.println("Número deportista 2: " + deportista2.getNumeroJugador());
    }
}