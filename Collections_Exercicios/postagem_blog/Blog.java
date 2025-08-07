import java.util.*;

public class Blog {
    private List<Post> post;

    public Blog() {
        this.post = new ArrayList<>();
    }

    public void adicionarPostagem(Post postagem) {
        // Verifica duplicidade: mesmo autor e mesmo título
        for (Post p : post) {
            if (p.equals(postagem)) {
                throw new IllegalArgumentException("Postagem jah existente");
            }
        }
        post.add(postagem);
    }

    // Deve retornar Set<Autor> (ordenado)
    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : post) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    // Deve retornar Map<Categorias, Integer> (não precisa ordenar pelos nomes, mas EnumMap mantém ordem natural do enum)
    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new EnumMap<>(Categorias.class);
        for (Post p : post) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    // Posts por autor (ordenados pelo título)
    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> result = new TreeSet<>();
        for (Post p : post) {
            if (p.getAutor().equals(autor)) {
                result.add(p);
            }
        }
        return result;
    }

    // Posts por categoria (ordenados pelo título)
    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> result = new TreeSet<>();
        for (Post p : post) {
            if (p.getCategoria() == categoria) {
                result.add(p);
            }
        }
        return result;
    }

    // Mapa: categoria -> Set de posts daquela categoria
    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new EnumMap<>(Categorias.class);
        for (Post p : post) {
            mapa.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>()).add(p);
        }
        return mapa;
    }

    // Mapa: autor -> Set de posts daquele autor
    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post p : post) {
            mapa.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return mapa;
    }
}
