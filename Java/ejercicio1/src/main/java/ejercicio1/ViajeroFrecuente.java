package ejercicio1;

public class ViajeroFrecuente {
    private Integer numero;
    private String dni;
    private String nombre;
    private String apellido;
    private Integer millas;

    public ViajeroFrecuente(Integer numero, String dni, String nombre, String apellido, Integer millas) {
        this.numero = numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.millas = millas;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getMillas() {
        return millas;
    }

    public void setMillas(Integer millas) {
        this.millas = millas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void acumularMillas(Integer millas) {
        this.millas += millas;
    }

    public void canjearMillas(Integer millas) {
        this.millas -= millas;
    }

    @Override 

    public String toString() {
        return "Numero: " + this.numero + " DNI: " + this.dni + " Nombre: " + this.nombre + " Apellido: " + this.apellido + " Millas: " + this.millas;
    
    }
}


