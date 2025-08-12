public class Pessoa {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public int getIdade() { return idade; }
    public double getSalario() { return salario; }

    @Override
    public String toString() {
        // Mantém o formato visto no exemplo, com vírgula decimal e 6 casas
        String salarioStr = String.format(java.util.Locale.US, "%.6f", salario).replace('.', ',');
        return String.format("[%d] %s %s %d R$ %s", codigo, nome, cargo, idade, salarioStr);
    }
}
