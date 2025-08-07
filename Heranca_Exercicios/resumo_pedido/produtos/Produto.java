package produtos;

public abstract class Produto {
    private String titulo;
    private int ano;
    private String pais;
    private double preco;

    public Produto(String titulo, int ano, String pais, double preco) {
        this.titulo = titulo;
        this.ano = ano;
        this.pais = pais;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAno() {
        return ano;
    }

    public String getPais() {
        return pais;
    }

    public double getPreco() {
        return preco;
    }

    public abstract String getTipo();
}
