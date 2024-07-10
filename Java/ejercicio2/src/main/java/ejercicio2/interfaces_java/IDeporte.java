package ejercicio2.interfaces_java;
import ejercicio2.modelos.Deportista;

import java.util.ArrayList;

public interface IDeporte {
    int CANTIDAD_MINIMA=2;
    
    public boolean conformar(ArrayList<Deportista> integrantes);
    public void mostrar();
    public void numeroDeportista();
    
}

