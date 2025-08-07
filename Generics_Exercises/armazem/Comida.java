public class Comida {
    private String nome;
    private int calorias;
    private double preco;

    public Comida(String nome, int calorias, double preco) {
        this.nome = nome;
        this.calorias = calorias;
        this.preco = preco;
    }

    public String getNome() { return nome; }
    public int getCalorias() { return calorias; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return String.format("[%s] %.6f R$ %.6f", nome, (double) calorias, preco);
    }
}
