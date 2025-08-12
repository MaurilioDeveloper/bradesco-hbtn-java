import java.util.LinkedList;

public class Fila {
    private final LinkedList<Integer> fila = new LinkedList<>();
    private final int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
    }

    public synchronized void adicionar(int item) throws InterruptedException {
        while (fila.size() == capacidade) {
            wait(); // fila cheia -> produtor espera
        }
        fila.addLast(item);
        System.out.println(Thread.currentThread().getName()
                + " produziu: " + item + " (tam=" + fila.size() + ")");
        notifyAll(); // acorda consumidores e/ou produtores bloqueados
    }

    public synchronized int retirar() throws InterruptedException {
        while (fila.isEmpty()) {
            wait(); // fila vazia -> consumidor espera
        }
        int item = fila.removeFirst();
        System.out.println(Thread.currentThread().getName()
                + " consumiu: " + item + " (tam=" + fila.size() + ")");
        notifyAll(); // acorda produtores e/ou consumidores
        return item;
    }
}
