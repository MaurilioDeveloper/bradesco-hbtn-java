public class ProdutorConsumidor {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Criar e iniciar as threads do produtor e consumidor
        Thread produtor = new Produtor(buffer);
        Thread consumidor = new Consumidor(buffer);

        produtor.start();
        consumidor.start();

        try {
            produtor.join();
            consumidor.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
