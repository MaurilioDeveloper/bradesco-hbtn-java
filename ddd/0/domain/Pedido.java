package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {

    private final String id;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(Cliente cliente) {
        this.id = UUID.randomUUID().toString();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
        this.status = StatusPedido.PENDENTE;
    }

    public void adicionarProduto(Produto produto) {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Só é possível adicionar produtos em pedidos pendentes.");
        }
        if (produto != null) {
            this.produtos.add(produto);
        }
    }

    public void removerProduto(Produto produto) {
        if (status != StatusPedido.PENDENTE) {
            throw new IllegalStateException("Só é possível remover produtos em pedidos pendentes.");
        }
        this.produtos.remove(produto);
    }

    public void pagar() {
        if (status == StatusPedido.CANCELADO) {
            throw new IllegalStateException("Pedido cancelado não pode ser pago.");
        }
        if (status == StatusPedido.PAGO) {
            return; // idempotente
        }
        this.status = StatusPedido.PAGO;
    }

    public void cancelar() {
        if (status == StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido pago não pode ser cancelado.");
        }
        if (status == StatusPedido.CANCELADO) {
            return; // idempotente
        }
        this.status = StatusPedido.CANCELADO;
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public StatusPedido getStatus() {
        return status;
    }
}
