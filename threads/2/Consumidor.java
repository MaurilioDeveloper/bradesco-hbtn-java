public class Consumidor extends Thread {
    private final Fila fila;

    public Consumidor(Fila fila, String nome) {
        super(nome);
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                int item = fila.retirar();
                // simula processamento
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            interrupt(); // restaura flag e encerra
        }
    }
}
