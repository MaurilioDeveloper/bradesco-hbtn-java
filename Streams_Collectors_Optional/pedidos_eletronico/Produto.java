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
}
