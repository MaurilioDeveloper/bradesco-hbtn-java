import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class ProcessamentoDePagamentos {

    // Logger SLF4j
    private static final Logger logger = LoggerFactory.getLogger(ProcessamentoDePagamentos.class);
    private static final Random RNG = new Random();

    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            logger.info("Iniciando o processamento do pagamento {}", i);

            int status = RNG.nextInt(3); // 0=sucesso, 1=falha, 2=pendente
            switch (status) {
                case 0:
                    logger.info("Pagamento {} processado com sucesso.", i);
                    break;
                case 1:
                    logger.error("Erro ao processar o pagamento {}: Falha na transação.", i);
                    break;
                default:
                    logger.warn("Pagamento {} está pendente. Aguardando confirmação.", i);
                    break;
            }

            try {
                Thread.sleep(1000); // simula 1s de processamento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.warn("Thread interrompida durante o processamento do pagamento {}.", i);
                break;
            }
        }

        logger.info("Processamento de pagamentos concluído.");
    }
}
