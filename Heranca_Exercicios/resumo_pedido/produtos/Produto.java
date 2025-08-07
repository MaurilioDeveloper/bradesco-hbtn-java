package produtos;

public abstract class Produto {
    protected String titulo;
    protected int anoLancamento;
    protected String paisOrigem;
    protected double preco;

    public Produto(String titulo, int anoLancamento, String paisOrigem, double preco) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.paisOrigem = paisOrigem;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    public abstract String getTipo();
}
