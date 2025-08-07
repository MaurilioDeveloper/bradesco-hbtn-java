public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        total = total * (1 - percentualDesconto / 100);
        return total;
    }
    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        double totalProdutos = 0;
        for (ItemPedido item : itens) {
            double precoUnitario = item.getProduto().obterPrecoLiquido();
            int quantidade = item.getQuantidade();
            double totalItem = precoUnitario * quantidade;

            totalProdutos += totalItem;

            // Tipo: Livro ou Dvd
            String tipo = item.getProduto().getClass().getSimpleName();

            // Titulo (do produto)
            String titulo = item.getProduto().getTitulo();

            // Preço unitário formatado (locale pt-BR usa vírgula)
            System.out.printf(Locale.forLanguageTag("pt-BR"),
                "Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                tipo, titulo, precoUnitario, quantidade, totalItem);
        }

        System.out.println("----------------------------");

        double descontoValor = totalProdutos * percentualDesconto / 100;

        System.out.printf(Locale.forLanguageTag("pt-BR"), "DESCONTO: %.2f\n", descontoValor);
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf(Locale.forLanguageTag("pt-BR"), "TOTAL PEDIDO: %.2f\n", totalProdutos - descontoValor);
        System.out.println("----------------------------");
    }
  }
}
