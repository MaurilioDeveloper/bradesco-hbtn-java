import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConsultaPessoas {
    // Requer Java 9+ por causa de Collectors.flatMapping
    public static Map<String, TreeSet<String>> obterHobbiesPorCargo(List<Pessoa> pessoas) {
        if (pessoas == null) return Collections.emptyMap();

        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.flatMapping(
                    p -> {
                        List<String> hs = p.getHobbies();
                        return hs == null ? Stream.<String>empty() : hs.stream();
                    },
                    Collectors.toCollection(TreeSet::new)
                )
            ));
    }
}
