import java.util.*;

public class Blog {
    private final List<Post> postagens;

    public Blog() {
        this.postagens = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        postagens.add(postagem);
    }

    // Autores únicos e ordenados alfabeticamente
    public Set<String> obterTodosAutores() {
        Set<String> autoresOrdenados = new TreeSet<>();
        for (Post p : postagens) {
            autoresOrdenados.add(p.getAutor());
        }
        return autoresOrdenados;
    }

    // Contagem por categoria com chaves ordenadas alfabeticamente
    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post p : postagens) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }
}
