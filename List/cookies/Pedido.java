import java.util.ArrayList;

public class Pedido {
    private ArrayList<PedidoCookie> cookies;

    public Pedido() {
        this.cookies = new ArrayList<>();
    }

    public void adicionarPedidoCookie(PedidoCookie pc) {
        cookies.add(pc);
    }

    public int obterTotalCaixas() {
        int total = 0;
        for (PedidoCookie pc : cookies) {
            total += pc.getQuantidadeCaixas();
        }
        return total;
    }

    public int removerSabor(String sabor) {
        int removidas = 0;
        ArrayList<PedidoCookie> restantes = new ArrayList<>();
        for (PedidoCookie pc : cookies) {
            if (pc.getSabor().equals(sabor)) {
                removidas += pc.getQuantidadeCaixas();
            } else {
                restantes.add(pc);
            }
        }
        cookies = restantes;
        return removidas;
    }
}
