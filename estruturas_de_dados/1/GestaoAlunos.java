import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestaoAlunos {
    private final List<Aluno> alunos = new ArrayList<>();

    // Adiciona um aluno
    public void adicionarAluno(String nome, int idade) {
        Aluno a = new Aluno(nome, idade);
        alunos.add(a);
        System.out.println("Aluno adicionado: " + a);
    }

    // Exclui aluno pelo nome (ignora maiúsculas/minúsculas)
    public boolean excluirAluno(String nome) {
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNome() != null && a.getNome().equalsIgnoreCase(nome)) {
                it.remove();
                System.out.println("Aluno excluído: " + a);
                return true;
            }
        }
        System.out.println("Aluno não encontrado para exclusão: " + nome);
        return false;
    }

    // Busca aluno pelo nome e exibe info
    public Aluno buscarAluno(String nome) {
        for (Aluno a : alunos) {
            if (a.getNome() != null && a.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Aluno encontrado: " + a);
                return a;
            }
        }
        System.out.println("Aluno não encontrado: " + nome);
        return null;
    }

    // Lista todos os alunos
    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("(Nenhum aluno cadastrado)");
            return;
        }
        System.out.println("Lista de alunos:");
        for (Aluno a : alunos) {
            System.out.println(a);
        }
    }

    // Demo das operações solicitadas
    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();

        // 1) Adicionar três alunos
        gestao.adicionarAluno("João", 20);
        gestao.adicionarAluno("Maria", 22);
        gestao.adicionarAluno("Pedro", 19);

        System.out.println();

        // 2) Exibir a lista de alunos
        gestao.listarAlunos();

        System.out.println();

        // 3) Buscar por um aluno
        gestao.buscarAluno("Maria");

        System.out.println();

        // 4) Excluir um aluno
        gestao.excluirAluno("João");

        // 5) Tentar excluir aluno inexistente e buscar outro aluno
        gestao.excluirAluno("Fulano");
        gestao.buscarAluno("Pedro");

        System.out.println();
        System.out.println("Após operações, alunos cadastrados:");
        gestao.listarAlunos();
    }
}
