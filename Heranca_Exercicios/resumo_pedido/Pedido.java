import java.util.Locale;

public class Pedido {
    private double descontoPercentual;
    private ItemPedido[] itens;

    public Pedido(double descontoPercentual, ItemPedido[] itens) {
        this.descontoPercentual = descontoPercentual;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0.0;
        for (ItemPedido item : itens) {
            produtos.Produto produto = item.getProduto();
            String tipo = produto.getTipo();
            String titulo = produto.getTitulo();
            double precoUnitario = produto.getPreco() * 1.15; // +15%
            int quantidade = item.getQuantidade();
            double totalItem = precoUnitario * quantidade;

            System.out.printf(Locale.forLanguageTag("pt-BR"),
                "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                tipo, titulo, precoUnitario, quantidade, totalItem);

            totalProdutos += totalItem;
        }

        System.out.println("----------------------------");

        double desconto = totalProdutos * (descontoPercentual / 100.0);
        System.out.printf(Locale.forLanguageTag("pt-BR"), "DESCONTO: %.2f%n", desconto);
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PRODUTOS: %.2f%n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PEDIDO: %.2f%n", totalProdutos - desconto);
        System.out.println("----------------------------");
    }
}
