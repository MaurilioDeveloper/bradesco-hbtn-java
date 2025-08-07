public class ArmazemDeEletronico extends Armazem<Eletronico> {

    @Override
    public void adicionarAoInventario(String nome, Eletronico valor) {
        itens.put(nome, valor);
    }

    @Override
    public Eletronico obterDoInventario(String nome) {
        return itens.get(nome);
    }
}
