// Clase que representa la cuenta bancaria
class CuentaBancaria {

    // Variable compartida entre los hilos
    private int saldo = 1000; // saldo inicial

    // Método sincronizado para retirar dinero
    // synchronized evita que dos hilos entren al mismo tiempo
    public synchronized void retirar(String cliente, int monto) {

        // Verifica si hay suficiente dinero
        if (saldo >= monto) {

            System.out.println(cliente + " intenta retirar " + monto);

            // Simula un pequeño retraso para evidenciar la concurrencia
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Se descuenta el dinero
            saldo = saldo - monto;

            System.out.println(cliente + " retiro exitoso. Saldo restante: " + saldo);

        } else {
            // Si no hay suficiente saldo
            System.out.println(cliente + " no pudo retirar. Saldo insuficiente: " + saldo);
        }
    }
}


// Clase que representa a cada cliente (hilo)
class Cliente extends Thread {

    private CuentaBancaria cuenta; // referencia a la cuenta compartida
    private String nombre;

    // Constructor
    public Cliente(CuentaBancaria cuenta, String nombre) {
        this.cuenta = cuenta;
        this.nombre = nombre;
    }

    // Método que ejecuta el hilo
    public void run() {

        // Cada cliente intenta retirar 400
        cuenta.retirar(nombre, 400);

    }
}


// Clase principal donde se ejecuta el programa
public class Banco {

    public static void main(String[] args) {

        // Se crea una sola cuenta compartida
        CuentaBancaria cuenta = new CuentaBancaria();

        // Se crean 3 clientes (3 hilos)
        Cliente c1 = new Cliente(cuenta, "Cliente 1");
        Cliente c2 = new Cliente(cuenta, "Cliente 2");
        Cliente c3 = new Cliente(cuenta, "Cliente 3");

        // Se inician los hilos
        c1.start();
        c2.start();
        c3.start();
    }
}