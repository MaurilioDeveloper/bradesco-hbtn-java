import java.util.List;
import java.util.stream.Collectors;

public class Consulta {
    public static List<Pedido> obterPedidosComEletronicos(List<Pedido> pedidos) {
        if (pedidos == null) return java.util.List.of();

        return pedidos.stream()
            .filter(pedido ->
                pedido.getProdutos().stream()
                      .anyMatch(produto -> produto.getCategoria() == CategoriaProduto.ELETRONICO)
            )
            .collect(Collectors.toList());
    }
}
