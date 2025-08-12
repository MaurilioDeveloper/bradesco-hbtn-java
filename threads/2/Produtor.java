import java.util.Random;

public class Produtor extends Thread {
    private final Fila fila;
    private final Random random = new Random();

    public Produtor(Fila fila, String nome) {
        super(nome);
        this.fila = fila;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                int numero = random.nextInt(100) + 1; // 1..100
                fila.adicionar(numero);
                Thread.sleep(1000); // produz a cada 1s
            }
        } catch (InterruptedException e) {
            interrupt(); // restaura flag e encerra
        }
    }
}
