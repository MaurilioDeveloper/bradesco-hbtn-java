public class PersonagemGame {
    private int saudeAtual;
    private String nome;
    private String status;

    public PersonagemGame(int saudeInicial, String nomeInicial) {
        setNome(nomeInicial);
        setSaudeAtual(saudeInicial); // garante que o status seja ajustado
    }

    public int getSaudeAtual() {
        return saudeAtual;
    }

    public void setSaudeAtual(int saudeAtual) {
        if (saudeAtual < 0) {
            saudeAtual = 0;
        } else if (saudeAtual > 100) {
            saudeAtual = 100;
        }

        this.saudeAtual = saudeAtual;
        this.status = (this.saudeAtual == 0) ? "morto" : "vivo";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getStatus() {
        return status;
    }

    public void tomarDano(int quantidadeDeDano) {
        setSaudeAtual(this.saudeAtual - quantidadeDeDano);
    }

    public void receberCura(int quantidadeDeCura) {
        setSaudeAtual(this.saudeAtual + quantidadeDeCura);
    }
}
