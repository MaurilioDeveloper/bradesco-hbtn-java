import java.math.BigDecimal;
import java.math.RoundingMode;
import produtos.Produto;

public class Pedido {
    private double descontoPercentual;
    private ItemPedido[] itens;

    public Pedido(double descontoPercentual, ItemPedido[] itens) {
        this.descontoPercentual = descontoPercentual;
        this.itens = itens;
    }

    public void apresentarResumoPedido() {
        System.out.println("------- RESUMO PEDIDO -------");

        BigDecimal totalProdutos = BigDecimal.ZERO;

        for (ItemPedido item : itens) {
            Produto produto = item.getProduto();
            String tipo = produto.getTipo();
            String titulo = produto.getTitulo();

            BigDecimal precoOriginal = BigDecimal.valueOf(produto.getPreco());
            BigDecimal precoComAcrescimo = precoOriginal.multiply(BigDecimal.valueOf(1.15));
            precoComAcrescimo = precoComAcrescimo.setScale(2, RoundingMode.HALF_UP);

            int quantidade = item.getQuantidade();
            BigDecimal totalItem = precoComAcrescimo.multiply(BigDecimal.valueOf(quantidade));

            totalProdutos = totalProdutos.add(totalItem);

            System.out.printf("Tipo: %s  Titulo: %s  Preco: %.2f  Quant: %d  Total: %.2f%n",
                    tipo, titulo, precoComAcrescimo.doubleValue(), quantidade, totalItem.doubleValue());
        }

        BigDecimal desconto = totalProdutos.multiply(BigDecimal.valueOf(descontoPercentual / 100.0));
        desconto = desconto.setScale(2, RoundingMode.HALF_UP);

        totalProdutos = totalProdutos.setScale(2, RoundingMode.HALF_UP);

        BigDecimal totalFinal = totalProdutos.subtract(desconto).setScale(2, RoundingMode.HALF_UP);

        System.out.println("----------------------------");
        System.out.printf("DESCONTO: %.2f%n", desconto.doubleValue());
        System.out.printf("TOTAL PRODUTOS: %.2f%n", totalProdutos.doubleValue());
        System.out.println("----------------------------");
        System.out.printf("TOTAL PEDIDO: %.2f%n", totalFinal.doubleValue());
        System.out.println("----------------------------");
    }
}
