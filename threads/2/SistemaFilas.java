public class SistemaFilas {
    public static void main(String[] args) {
        Fila fila = new Fila(10); // capacidade 10

        Thread p1 = new Produtor(fila, "Produtor-1");
        Thread p2 = new Produtor(fila, "Produtor-2");
        Thread c1 = new Consumidor(fila, "Consumidor-1");
        Thread c2 = new Consumidor(fila, "Consumidor-2");

        p1.start();
        p2.start();
        c1.start();
        c2.start();

        try {
            // roda o sistema por 20 segundos
            Thread.sleep(20_000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // interrompe todas as threads e aguarda um pouco
            p1.interrupt(); p2.interrupt(); c1.interrupt(); c2.interrupt();
            try {
                p1.join(1000); p2.join(1000); c1.join(1000); c2.join(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Encerrando o sistema de filas...");
            System.exit(0);
        }
    }
}
