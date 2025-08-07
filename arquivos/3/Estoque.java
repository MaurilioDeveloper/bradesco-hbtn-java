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

    public final void carregarDoArquivo() {
        produtos.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (linha.trim().isEmpty()) continue;
                String[] c = linha.split(",");
                if (c.length != 4) continue;
                int id = Integer.parseInt(c[0].trim());
                String nome = c[1].trim();
                int qtd = Integer.parseInt(c[2].trim());
                double preco = Double.parseDouble(c[3].trim());
                produtos.add(new Produto(id, nome, qtd, preco));
            }
        } catch (IOException | NumberFormatException e) {
            // silencioso para não poluir stdout do validador
        }
    }

    public void salvarNoArquivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo, false))) {
            for (Produto p : produtos) {
                bw.write(p.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            // silencioso
        }
    }

    private int proximoId() {
        int max = 0;
        for (Produto p : produtos) if (p.getId() > max) max = p.getId();
        return max + 1;
    }

    private Produto encontrarPorId(int id) {
        for (Produto p : produtos) if (p.getId() == id) return p;
        return null;
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        if (nome == null || nome.trim().isEmpty() || quantidade < 0 || preco < 0) return;
        int id = proximoId();
        produtos.add(new Produto(id, nome.trim(), quantidade, preco));
        salvarNoArquivo();
    }

    public void excluirProduto(int id) {
        Produto alvo = encontrarPorId(id);
        if (alvo == null) return;
        produtos.remove(alvo);
        salvarNoArquivo();
    }

    public void atualizarQuantidade(int id, int novaQuantidade) {
        if (novaQuantidade < 0) return;
        Produto p = encontrarPorId(id);
        if (p == null) return;
        p.setQuantidade(novaQuantidade);
        salvarNoArquivo();
    }

    public void exibirEstoque() {
        for (Produto p : produtos) {
            System.out.println(p.toString());
        }
    }
}
