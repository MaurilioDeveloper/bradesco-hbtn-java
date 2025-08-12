public class Consumidor extends Thread {
    private final Buffer buffer;

    public Consumidor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consumir();     // O consumidor retira os itens do buffer
                Thread.sleep(1500);    // Simula o tempo para consumir um item
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
