package produtos;

public class Livro extends Produto {
    private int numeroPaginas;
    private String autor;
    private int edicao;

    public Livro(String titulo, int anoLancamento, String paisOrigem, double preco,
                 int numeroPaginas, String autor, int edicao) {
        super(titulo, anoLancamento, paisOrigem, preco);
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.edicao = edicao;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}
