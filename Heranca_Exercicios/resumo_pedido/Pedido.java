import java.util.Locale;

public class Pedido {
    private double descontoPercentual;
    private ItemPedido[] itens;

    public Pedido(double descontoPercentual, ItemPedido[] itens) {
        this.descontoPercentual = descontoPercentual;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        Locale.setDefault(new Locale("pt", "BR"));
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0.0;

        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();
            String tipo = produto.getTipo();
            String titulo = produto.getTitulo();

            // Aplica acréscimo de 15%
            double precoComAcrescimo = produto.getPreco() * 1.15;
            precoComAcrescimo = Math.round(precoComAcrescimo * 100.0) / 100.0;

            int quantidade = item.getQuantidade();
            double totalItem = precoComAcrescimo * quantidade;

            totalProdutos += totalItem;

            System.out.printf(Locale.forLanguageTag("pt-BR"),
                "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                tipo, titulo, precoComAcrescimo, quantidade, totalItem);
        }

        // Calcula desconto e arredonda
        double desconto = totalProdutos * (descontoPercentual / 100.0);
        desconto = Math.round(desconto * 100.0) / 100.0;

        totalProdutos = Math.round(totalProdutos * 100.0) / 100.0;

        double totalFinal = totalProdutos - desconto;
        totalFinal = Math.round(totalFinal * 100.0) / 100.0;

        System.out.println("----------------------------");
        System.out.printf(Locale.forLanguageTag("pt-BR"), "DESCONTO: %.2f%n", desconto);
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PEDIDO: %.2f%n", totalFinal);
        System.out.println("----------------------------");
    }
}
