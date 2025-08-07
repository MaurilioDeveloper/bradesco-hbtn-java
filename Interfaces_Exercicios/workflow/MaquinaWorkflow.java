import atividades.Atividade;

public class MaquinaWorkflow {
    public void executar(Workflow workflow) {
        if (workflow == null) return;
        for (Atividade atividade : workflow.obterAtividades()) {
            if (atividade != null) {
                atividade.executar();
            }
        }
    }
}
