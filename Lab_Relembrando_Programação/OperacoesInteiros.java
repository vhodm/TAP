import java.util.Scanner;

public class OperacoesInteiros {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int[] vetor = new int[100];
            int quantidade = 0;
            int pares = 0;
            int impares = 0;
            int soma = 0;
            int maior = Integer.MIN_VALUE;
            int menor = Integer.MAX_VALUE;

            for (int i = 0; i < vetor.length; i++) {
                vetor[i] = scan.nextInt();
                if (vetor[i] == -1) {
                    break;
                }
                quantidade++;
                soma += vetor[i];

                if (vetor[i] % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }

                if (vetor[i] > maior) {
                    maior = vetor[i];
                }
                if (vetor[i] < menor) {
                    menor = vetor[i];
                }
            }

            if (quantidade == 0) {
                break;
            }

            double media = (double) soma / quantidade;

            // Imprimindo os resultados
            System.out.println(quantidade);
            System.out.println(pares);
            System.out.println(impares);
            System.out.println(soma);
            System.out.printf("%.2f%n", media);
            System.out.println(maior);
            System.out.println(menor);
        }

        scan.close();
    }
}
