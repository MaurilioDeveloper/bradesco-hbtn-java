public class Produto {
    private int id;
    private String nome;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(int id, String nome, CategoriaProduto categoria, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public CategoriaProduto getCategoria() { return categoria; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        String precoStr = String.format(java.util.Locale.US, "%.2f", preco).replace('.', ',');
        return String.format("[%d] %s %s R$ %s", id, nome, categoria, precoStr);
    }
}
