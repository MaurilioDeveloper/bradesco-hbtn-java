public class Post implements Comparable<Post> {
    private Autor autor;
    private String titulo;
    private String corpo;
    private Categorias categoria;

    public Post(Autor autor, String titulo, String corpo, Categorias categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.corpo = corpo;
        this.categoria = categoria;
    }

    public Autor getAutor() { return autor; }
    public String getTitulo() { return titulo; }
    public String getCorpo() { return corpo; }
    public Categorias getCategoria() { return categoria; }

    @Override
    public String toString() {
        return titulo;
    }

    @Override
    public int compareTo(Post o) {
        return this.titulo.compareTo(o.titulo);
    }

    // Igualdade definida por (autor, titulo) para suporte à regra de duplicidade
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Post)) return false;
        Post other = (Post) obj;
        return this.autor.equals(other.autor) && this.titulo.equals(other.titulo);
    }

    @Override
    public int hashCode() {
        int result = autor.hashCode();
        result = 31 * result + titulo.hashCode();
        return result;
    }
}
