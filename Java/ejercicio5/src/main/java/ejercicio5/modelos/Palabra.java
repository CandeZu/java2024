package ejercicio5.modelos;

public class Palabra {
    private String palabra;
    private int cantidadVeces;

    public Palabra(String palabra) {
        this.palabra = palabra;
        this.cantidadVeces = 1;
    }

    public String getPalabra() {
        return palabra;
    }

    public int getCantidadVeces() {
        return cantidadVeces;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public void setCantidadVeces(int cantidadVeces) {
        this.cantidadVeces = cantidadVeces;
    }
    
    @Override
    public String toString(){
        return "- Palabra: " + "'" + palabra + "'" + " -->" + " Cantidad de veces: " + cantidadVeces;
    }
}
