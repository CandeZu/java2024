package ejercicio5;

import java.util.HashMap;
import java.util.Map;
import ejercicio5.modelos.Palabra;

public class ConjuntoPalabras {
    private final Map<String, Palabra> palabras;

    public ConjuntoPalabras() {
        palabras = new HashMap<>();
    }

    public synchronized void agregarPalabra(Palabra p) {
        palabras.put(p.getPalabra(), p);
    }

    public Palabra buscarPalabra(String palabraBuscada) {
        return palabras.get(palabraBuscada);
    }

    public void mostrar() {
        System.out.println("-------------------------------");
        System.out.println("Lista de palabras y frecuencias");
        System.out.println("-------------------------------");
        for (Palabra palabra : palabras.values()) {
            System.out.printf("Palabra: %-20s Frecuencia: %d%n", palabra.getPalabra(), palabra.getCantidadVeces());
        }
        System.out.println("-------------------------------");
    }

    public synchronized void incrementar(Palabra p) {
        Palabra palabra = palabras.get(p.getPalabra());
        if (palabra != null) {
            palabra.setCantidadVeces(palabra.getCantidadVeces() + 1);
        }
    }
}

