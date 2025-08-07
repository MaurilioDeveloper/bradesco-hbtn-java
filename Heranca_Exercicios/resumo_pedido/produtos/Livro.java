package produtos;

public class Livro extends Produto {
    private int numPaginas;
    private String autor;
    private int edicao;

    public Livro(String titulo, int ano, String pais, double preco, int numPaginas, String autor, int edicao) {
        super(titulo, ano, pais, preco);
        this.numPaginas = numPaginas;
        this.autor = autor;
        this.edicao = edicao;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public String getAutor() {
        return autor;
    }

    public int getEdicao() {
        return edicao;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}
