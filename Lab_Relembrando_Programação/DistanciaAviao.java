import java.util.Scanner;

public class DistanciaAviao {
    public static void main(String[] args) {
        // Inicializando a matriz com os tempos de viagem entre as cidades
        int[][] matriz_cidades = {
                {0, 2, 11, 6, 15, 11, 1},
                {2, 0, 7, 12, 4, 2, 15},
                {11, 7, 0, 11, 8, 3, 13},
                {6, 12, 11, 0, 10, 2, 1},
                {15, 4, 8, 10, 0, 5, 13},
                {11, 2, 3, 2, 5, 0, 14},
                {1, 15, 13, 1, 13, 14, 0}
        };

        // Vetor para armazenar os destinos
        int[] vetor_destinos = new int[100];
        int tam_max = 0;
        Scanner scan = new Scanner(System.in);

        // Lendo a entrada dos destinos até encontrar -1
        for (int i = 0; i < vetor_destinos.length; i++) {
            int destino = scan.nextInt();
            if (destino == -1) {
                break;
            } else {
                vetor_destinos[i] = destino;
                tam_max++;
            }
        }

        // Calculando o tempo total percorrido
        int tempo_total = 0;
        for (int i = 0; i < tam_max - 1; i++) {
            int origem = vetor_destinos[i];
            int destino = vetor_destinos[i + 1];

            // Ajustando o índice para as cidades (111 -> 0, 222 -> 1, etc.)
            tempo_total += matriz_cidades[(origem / 111) - 1][(destino / 111) - 1];
        }

        // Exibindo o tempo total percorrido
        System.out.printf("%d%n", tempo_total);
    }
}