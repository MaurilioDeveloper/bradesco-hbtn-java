public class Cliente {
    private int id;
    private String nome;
    private boolean especial;

    public Cliente(int id, String nome, boolean especial) {
        this.id = id;
        this.nome = nome;
        this.especial = especial;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isEspecial() { return especial; }
}
