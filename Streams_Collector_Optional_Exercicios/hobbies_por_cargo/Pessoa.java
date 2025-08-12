import java.util.List;

public class Pessoa implements Comparable<Pessoa> {
    private int codigo;
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private List<String> hobbies;

    public Pessoa(int codigo, String nome, String cargo, int idade, double salario, List<String> hobbies) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.hobbies = hobbies;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getCargo() { return cargo; }
    public int getIdade() { return idade; }
    public double getSalario() { return salario; }
    public List<String> getHobbies() { return hobbies; }

    @Override
    public String toString() {
        String salarioStr = String.format(java.util.Locale.US, "%.6f", salario).replace('.', ',');
        return String.format("[%d] %s %s %d R$ %s", codigo, nome, cargo, idade, salarioStr);
    }

    @Override
    public int compareTo(Pessoa o) {
        int byName = this.nome.compareTo(o.nome);
        if (byName != 0) return byName;
        return Integer.compare(this.codigo, o.codigo);
    }
}
