public class ArmazemDeComida extends Armazem<Comida> {

    @Override
    public void adicionarAoInventario(String nome, Comida valor) {
        itens.put(nome, valor);
    }

    @Override
    public Comida obterDoInventario(String nome) {
        return itens.get(nome);
    }
}
