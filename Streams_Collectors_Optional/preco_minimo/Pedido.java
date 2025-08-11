import java.util.List;

public class Pedido {
    private int id;
    private List<Produto> produtos;
    private Cliente cliente;

    public Pedido(int id, List<Produto> produtos, Cliente cliente) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
    }

    public int getId() { return id; }
    public List<Produto> getProdutos() { return produtos; }
    public Cliente getCliente() { return cliente; }
}
