public class Autor implements Comparable<Autor> {
    private String nome;
    private String sobrenome;

    public Autor(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }

    @Override
    public String toString() {
        return nome + " " + sobrenome;
    }

    @Override
    public int compareTo(Autor o) {
        // Ordena por nome completo (igual esperado na saída)
        int c = this.nome.compareTo(o.nome);
        if (c != 0) return c;
        return this.sobrenome.compareTo(o.sobrenome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Autor)) return false;
        Autor other = (Autor) obj;
        return this.nome.equals(other.nome) && this.sobrenome.equals(other.sobrenome);
    }

    @Override
    public int hashCode() {
        int result = nome.hashCode();
        result = 31 * result + sobrenome.hashCode();
        return result;
    }
}
