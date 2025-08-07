import java.util.function.Consumer;
import java.util.function.Supplier;

public class Produto {
    private double preco;
    private String nome;
    private double percentualMarkup = 10.0;

    public Supplier<Double> precoComMarkup = () -> preco + (preco * percentualMarkup / 100);

    public Consumer<Double> atualizarMarkup = (novoMarkup) -> this.percentualMarkup = novoMarkup;

    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}
