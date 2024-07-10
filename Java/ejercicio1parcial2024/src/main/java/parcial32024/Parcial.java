package parcial32024;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

interface ISocio {
    String getNombre();
    float getCuota();
    String estado();
}

abstract class Socio implements ISocio {
    protected String nombre;
    protected float cuota;

    public Socio(String nombre, float cuota) {
        this.nombre = nombre;
        this.cuota = cuota;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public float getCuota() {
        return cuota;
    }

    @Override
    public String estado() {
        return cuota > 0 ? "DEUDOR" : "PAGADO";
    }
    
    @Override
    public String toString() {
        return nombre + " (" + estado() + ")";
    }

    
}


class Alumno extends Socio {
    private String registro;
    private String carrera;

    public Alumno(String nombre, float cuota, String registro, String carrera) {
        super(nombre, cuota);
        this.registro = registro;
        this.carrera = carrera;
    }

    public String getRegistro() {
        return registro;
    }
    public String getCarrera() {
        return carrera;
    }


}

class Agente extends Socio {
    private String cuil;
    private String domicilio;

    public Agente(String nombre, float cuota, String cuil, String domicilio) {
        super(nombre, cuota);
        this.cuil = cuil;
        this.domicilio = domicilio;
    }

    public String getCuil() {
        return cuil;
    }

    public String getDomicilio() {
        return domicilio;
    }


}

class Biblioteca {
    private List<Socio> socios;

    public Biblioteca() {
        this.socios = new ArrayList<>();
    }

    public void addSocio(Socio socio) {
        socios.add(socio);
    }

    // public List<String> morosos() {
    //     return socios.stream()
    //         .filter(socio -> socio.estado().equals("DEUDOR")) 
    //         .map(Socio::getNombre)
    //         .collect(Collectors.toList());
    // }

    public void morosos() {
        System.out.println("Socios morosos:");
        socios.stream()
                .filter(socio -> socio.estado().equals("DEUDOR")) // Filtrar aquellos con cuota mayor que cero
                .map(Socio::getNombre) // Mapear solo el nombre del socio
                .forEach(System.out::println); // Imprimir cada nombre
    }
    

    public int totalSocios() {
        return socios.size();
    }

    public List<String> exceptuados() {
        return socios.stream()
            .filter(socio -> socio.getCuota() == 0)
            .map(socio -> {
                if (socio instanceof Alumno) {
                    Alumno alumno = (Alumno) socio;
                    return alumno.getNombre() + " - Registro: " + alumno.getRegistro();
                } else if (socio instanceof Agente) {
                    Agente agente = (Agente) socio;
                    return agente.getNombre() + " - CUIL: " + agente.getCuil();
                }
                return ""; // Manejar otro tipo de socio si existiera
            })
            .collect(Collectors.toList());
    }
}
