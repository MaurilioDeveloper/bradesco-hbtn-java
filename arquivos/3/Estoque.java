import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private final String caminhoArquivo;
    private final List<Produto> produtos = new ArrayList<>();

    public Estoque(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        carregarDoArquivo();
    }

    // Carrega produtos do CSV
    public final void carregarDoArquivo() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] campos = linha.split(",");
                if (campos.length != 4) continue;
                int id = Integer.parseInt(campos[0].trim());
                String nome = campos[1].trim();
                int qtd = Integer.parseInt(campos[2].trim());
                double preco = Double.parseDouble(campos[3].trim());
                produtos.add(new Produto(id, nome, qtd, preco));
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro de formato nos dados do arquivo: " + e.getMessage());
        }
    }

    // Salva produtos no CSV
    public void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, false))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    private int proximoId() {
        int max = 0;
        for (Produto p : produtos) {
            if (p.getId() > max) max = p.getId();
        }
        return max + 1;
    }

    private Produto encontrarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome inválido.");
            return;
        }
        if (quantidade < 0) {
            System.out.println("Quantidade deve ser não negativa.");
            return;
        }
        if (preco < 0) {
            System.out.println("Preço deve ser não negativo.");
            return;
        }
        int id = proximoId();
        produtos.add(new Produto(id, nome.trim(), quantidade, preco));
        salvarNoArquivo();
        System.out.println("Produto adicionado com ID: " + id);
    }

    public void excluirProduto(int id) {
        Produto alvo = encontrarPorId(id);
        if (alvo == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        produtos.remove(alvo);
        salvarNoArquivo();
        System.out.println("Produto removido com sucesso.");
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) {
            System.out.println("Quantidade deve ser não negativa.");
            return;
        }
        Produto p = encontrarPorId(id);
        if (p == null) {
            System.out.println("Produto não encontrado.");
            return;
        }
        p.setQuantidade(novaQuantidade);
        salvarNoArquivo();
        System.out.println("Quantidade atualizada com sucesso.");
    }

    public void exibirEstoque() {
        if (produtos.isEmpty()) {
            System.out.println("(estoque vazio)");
            return;
        }
        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }
}
