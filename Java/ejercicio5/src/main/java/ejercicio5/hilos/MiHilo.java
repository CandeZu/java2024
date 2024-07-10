package ejercicio5.hilos;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import ejercicio5.ConjuntoPalabras;
import ejercicio5.modelos.Palabra;

public class MiHilo implements Runnable {
    
    private String rutaArchivo;
    private ConjuntoPalabras datos;

    public MiHilo(String numeroHilo, String rutaArchivo, ConjuntoPalabras datos) {
        
        this.rutaArchivo = rutaArchivo;
        this.datos = datos;
    }

    public String limpiarSignos(String texto) {
        texto = texto.replaceAll("[^a-zA-Z0-9]", " ");
        return texto;
    }
    
    public List<String> limpiarStopWords(List<String> texto) { 
    String[] stopWordsArray = {"a", "el", "la", "los", "las", "y", "o", "u", "de", "del", "al", "en", "con", "por", "para","ni", "pero", "aunque", "sin", "sobre", "tras", "durante", "mientras", "cuando", "donde", "quien", "cual", "cuyo", "cuya", "cuyos", "cuyas", "que", "cual", "cuyas", "cuyos", "cuya", "cuyas", "cuyo", "cuyos"};
    Set<String> stopWordsSet = new HashSet<>(Arrays.asList(stopWordsArray));

    return texto.stream()
        .filter(word -> !stopWordsSet.contains(word))
        .collect(Collectors.toList());
}


    @Override
public void run() {
    String texto = "";
    try {
        texto = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(rutaArchivo)));
    } catch (java.io.IOException e) {
        System.out.println("Error al leer el archivo");
    }
    texto = texto.toLowerCase();
    texto = limpiarSignos(texto);
    List<String> palabras = Arrays.asList(texto.split(""));
    palabras = limpiarStopWords(palabras);

    Palabra p;
    for (String palabra : palabras) {
        if (!palabra.equals("")) {
            synchronized(datos) {
                p = datos.buscarPalabra(palabra);
                if (p == null) {
                    Palabra nuevaPalabra = new Palabra(palabra);
                    datos.agregarPalabra(nuevaPalabra);
                } else {
                    datos.incrementar(p);
                }
            }
        }
    }
}

}
