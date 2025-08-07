import java.text.DecimalFormat;

public class Pedido {
    private int percentualDesconto;
    private ItemPedido[] itens;

    public Pedido(int percentualDesconto, ItemPedido[] itens) {
        this.percentualDesconto = percentualDesconto;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("------- RESUMO PEDIDO -------");
        double totalProdutos = 0;

        for (ItemPedido item : itens) {
            String tipo = item.getProduto().getTipo();
            String titulo = item.getProduto().getTitulo();
            double preco = item.getProduto().getPreco();
            int quantidade = item.getQuantidade();
            double totalItem = item.getTotal();
            totalProdutos += totalItem;

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f\n",
                tipo, titulo, preco, quantidade, totalItem);
        }

        System.out.println("----------------------------");
        double desconto = totalProdutos * percentualDesconto / 100.0;
        double totalPedido = totalProdutos - desconto;

        System.out.printf("DESCONTO: %.2f\n", desconto);
        System.out.printf("TOTAL PRODUTOS: %.2f\n", totalProdutos);
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f\n", totalPedido);
        System.out.println("----------------------------");
    }
}
