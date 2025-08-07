import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class GerenciadorEstoque {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US); // garante ponto decimal
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque("estoque.csv");

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Excluir Produto");
            System.out.println("3. Exibir Estoque");
            System.out.println("4. Atualizar Quantidade de Produto");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida!");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();
                    try {
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        System.out.print("Digite o preço: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine();
                        estoque.adicionarProduto(nome, quantidade, preco);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Use números para quantidade e preço.");
                        scanner.nextLine();
                    }
                    break;
                case 2:
                    try {
                        System.out.print("Digite o ID do produto a ser excluído: ");
                        int idExcluir = scanner.nextInt();
                        scanner.nextLine();
                        estoque.excluirProduto(idExcluir);
                    } catch (InputMismatchException e) {
                        System.out.println("ID inválido.");
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("Estoques:");
                    estoque.exibirEstoque();
                    break;
                case 4:
                    try {
                        System.out.print("Digite o ID do produto: ");
                        int idAtualizar = scanner.nextInt();
                        System.out.print("Digite a nova quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        scanner.nextLine();
                        estoque.atualizarQuantidade(idAtualizar, novaQuantidade);
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Use números para ID e quantidade.");
                        scanner.nextLine();
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
