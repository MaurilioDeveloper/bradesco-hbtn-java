import java.util.Scanner;

public class ArrayExercicio {

    public static void main(String[] args) {
        // Criando o scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Definindo o tamanho do array
        int tamanhoArray = 10;
        int[] numeros = new int[tamanhoArray];
        int soma = 0;
        int maiorNumero = Integer.MIN_VALUE;

        // Preenchendo o array com números fornecidos pelo usuário
        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < tamanhoArray; i++) {
            System.out.printf("Digite o número %d: ", i + 1);
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
            if (numeros[i] > maiorNumero) {
                maiorNumero = numeros[i];
            }
        }

        // Exibindo o conteúdo do array
        System.out.println("\nConteúdo do array:");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Exibindo a soma e o maior número
        System.out.println("Soma de todos os números: " + soma);
        System.out.println("Maior número no array: " + maiorNumero);

        // Fechando o scanner
        scanner.close();
    }
}
