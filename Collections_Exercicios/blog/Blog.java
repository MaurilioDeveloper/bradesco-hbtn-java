import java.util.*;

public class Blog {
    private List<Post> post;

    public Blog() {
        this.post = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        post.add(postagem);
    }

    // Retorna autores únicos, ordenados
    public Set<String> obterTodosAutores() {
        Set<String> autores = new TreeSet<>();
        for (Post p : post) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    // Retorna contagem por categoria, ordenada por nome da categoria
    public Map<String, Integer> obterContagemPorCategoria() {
        Map<String, Integer> contagem = new TreeMap<>();
        for (Post p : post) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }
}
