import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;

public class ConsultaPessoas {
    public static Map<String, Map<Integer, Long>> obterContagemPessoasPorCargoEIdade(List<Pessoa> pessoas) {
        if (pessoas == null) return Collections.emptyMap();

        return pessoas.stream()
            .collect(Collectors.groupingBy(
                Pessoa::getCargo,
                Collectors.groupingBy(
                    Pessoa::getIdade,
                    Collectors.counting()
                )
            ));
    }
}
