import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static Map<String, Long> obterContagemPessoasPorCargo(List<Pessoa> pessoas) {
        if (pessoas == null) return Collections.emptyMap();

        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.counting()
            ));
    }
}
