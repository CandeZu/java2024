package ejercicio5;

import ejercicio5.hilos.MiHilo;

public class Main {
    public static void main(String[] args) {
        ConjuntoPalabras datos = new ConjuntoPalabras();

        long inicio = System.currentTimeMillis();
        Thread h1 = new Thread(new MiHilo("uno", "C:\\Users\\Cande\\Documents\\Facultad\\java\\Java\\ejercicio5\\src\\main\\java\\ejercicio5\\datos\\texto1.txt", datos));
        Thread h2 = new Thread(new MiHilo("dos", "C:\\Users\\Cande\\Documents\\Facultad\\java\\Java\\ejercicio5\\src\\main\\java\\ejercicio5\\datos\\texto2.txt", datos));
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido");
        }
         // Muestro cada palabra y la cantidad de veces que aparece
        long fin = System.currentTimeMillis();
        datos.mostrar();
        System.out.println();
        System.out.println("Tiempo de ejecucion: " + (fin - inicio) + " milisegundos");
    }
    }
