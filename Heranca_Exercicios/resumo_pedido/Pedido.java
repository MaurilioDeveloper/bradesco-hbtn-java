public class Pedido {
    private double percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(double percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public ItemPedido[] getItens() {
        return itens;
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getQuantidade() * item.getProduto().obterPrecoLiquido();
        }
        return total * (1.0 - (percentualDesconto / 100.0));
    }

    public void apresentarResumoPedido() {
        double totalProdutos = 0.0;

        System.out.println("------- RESUMO PEDIDO -------");

        for (ItemPedido item : itens) {
            produtos.Produto p = item.getProduto();
            double precoUnit = p.obterPrecoLiquido();
            double totalItem = precoUnit * item.getQuantidade();
            totalProdutos += totalItem;

            String tipo = (p instanceof produtos.Livro) ? "Livro" : "Dvd";

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                    tipo, p.getTitulo(), precoUnit, item.getQuantidade(), totalItem);
        }

        System.out.println("----------------------------");

        double descontoValor = totalProdutos * (percentualDesconto / 100.0);

        System.out.printf("DESCONTO: %.2f\n", descontoValor);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalProdutos - descontoValor);
        System.out.println("----------------------------");
    }
}
