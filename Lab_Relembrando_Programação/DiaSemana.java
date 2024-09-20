import java.util.Scanner;

public class DiaSemana {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] matriz = new int[100][7];
        int N = 0;

        while (true){
            int[] horas = new int[7];
            boolean fim_leitura = false;

            for (int i = 0; i < 7; i++) {
                horas[i] = scan.nextInt();
                if (horas[i] == -1) {
                    fim_leitura = true;
                    break;
                }
            }

            if (fim_leitura){
                break;
            }

            matriz[N] = horas;
            N++;
        }

        int[] soma_dia = new int[7];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 7; j++) {
                soma_dia[j] += matriz[i][j];
            }
        }

        // Encontrando o(s) dia(s) com o maior número de horas trabalhadas
        int max_horas = 0;
        for (int i = 0; i < 7; i++) {
            if (soma_dia[i] > max_horas) {
                max_horas = soma_dia[i];
            }
        }

        for (int i = 0; i < 7; i++) {
            if (soma_dia[i] == max_horas) {
                System.out.println(i+1);
            }
        }

        scan.close();
    }
}
