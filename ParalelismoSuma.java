// Clase que representa un hilo que calcula una parte de la suma
class SumaHilo extends Thread {

    // Variables para definir el rango que cada hilo va a sumar
    private int inicio;
    private int fin;

    // Variable donde cada hilo guarda su resultado
    private long suma = 0;

    // Constructor que recibe el rango de números
    public SumaHilo(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    // Método que ejecuta el hilo
    public void run() {

        // Bucle que suma los números del rango asignado
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }

        // Mensaje para saber qué hilo terminó
        System.out.println("Suma desde " + inicio + " hasta " + fin + " = " + suma);
    }

    // Método para obtener el resultado de cada hilo
    public long getSuma() {
        return suma;
    }
}

public class ParalelismoSuma {

    public static void main(String[] args) throws InterruptedException {

        // Crear los 4 hilos con su respectivo rango
        SumaHilo h1 = new SumaHilo(1, 250000);
        SumaHilo h2 = new SumaHilo(250001, 500000);
        SumaHilo h3 = new SumaHilo(500001, 750000);
        SumaHilo h4 = new SumaHilo(750001, 1000000);

        // Iniciar los hilos
        h1.start();
        h2.start();
        h3.start();
        h4.start();

        // Esperar a que todos los hilos terminen
        h1.join();
        h2.join();
        h3.join();
        h4.join();

        // Sumar los resultados de cada hilo
        long total = h1.getSuma() + h2.getSuma() + h3.getSuma() + h4.getSuma();

        // Mostrar resultado final
        System.out.println("Suma total = " + total);
    }
}