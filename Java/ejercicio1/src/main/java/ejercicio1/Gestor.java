package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private List<ViajeroFrecuente> viajeros;
    private Integer cantidad;

    /*Constructor */

    public Gestor(Integer cantidad){
        viajeros = new ArrayList<ViajeroFrecuente>();
        this.cantidad = cantidad;
    }

    public void agregarViajero(ViajeroFrecuente viajero){
        if (viajeros.size() < cantidad){
            viajeros.add(viajero);
        }
        else{
            System.out.println("No se pueden agregar más viajeros");
        }
    }
    
    public void mostrarViajero(Integer numero){
        for(ViajeroFrecuente viajero : viajeros){
            if(viajero.getNumero().equals(numero)){
                System.out.println("Viajero: " + viajero);
            }
            else{
                System.out.println("No se encontró el viajero");
            }
        }
        
    }

    public int consultarMillas(String dni){
        for(ViajeroFrecuente viajero : viajeros){
            if(viajero.getDni().equals(dni)){
                return (viajero.getMillas());
            }
        }
        return -1;
    }

    public void acumularMillas(String dni, Integer millas){
        for(ViajeroFrecuente viajero : viajeros){
            if(viajero.getDni().equals(dni)){
                viajero.acumularMillas(millas);
                System.out.println("Millas actualizadas: " + viajero.getMillas());
            }
            else{
                System.out.println("No se encontró el viajero");
            }
        }
    }

    public void canjearMillas(String dni, Integer millas){
        for(ViajeroFrecuente viajero : viajeros){
            if(viajero.getDni().equals(dni)){
                if(viajero.getMillas() >= millas){
                    viajero.canjearMillas(millas);;
                    System.out.println("Millas actualizadas: " + viajero.getMillas());
                }
                else{
                    System.out.println("No tiene suficientes millas");
                }
            }
            else{
                System.out.println("No se encontró el viajero");
            }
        }
    }

    public void mejorViajero(){
        ViajeroFrecuente mejorViajero = viajeros.get(0);
        for(ViajeroFrecuente viajero : viajeros){
            if(viajero.getMillas() > mejorViajero.getMillas()){
                mejorViajero = viajero;
            }
        }
        System.out.println("El mejor viajero es: " + mejorViajero);
    }

}
