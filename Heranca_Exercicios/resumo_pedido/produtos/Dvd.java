package produtos;

public class Dvd extends Produto {
    private String diretor;
    private String genero;
    private int duracao;

    public Dvd(String titulo, int anoLancamento, String paisOrigem, double preco,
               String diretor, String genero, int duracao) {
        super(titulo, anoLancamento, paisOrigem, preco);
        this.diretor = diretor;
        this.genero = genero;
        this.duracao = duracao;
    }

    @Override
    public String getTipo() {
        return "Dvd";
    }
}
