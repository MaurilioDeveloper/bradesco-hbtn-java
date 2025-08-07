import java.util.HashMap;
import java.util.Map;

public abstract class Armazem<T> implements Armazenavel<T> {
    protected final Map<String, T> itens = new HashMap<>();
    // Os métodos da interface serão implementados nas subclasses específicas
}
