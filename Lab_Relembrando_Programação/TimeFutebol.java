import java.util.Scanner;

public class TimeFutebol {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int[] nosso_time = new int[100];
        int[] time_adversario = new int[100];
        int tam_max = 0;

        int vitorias = 0;
        int empates = 0;
        int derrotas = 0;

        for (int i = 0; i < nosso_time.length; i++) {
            nosso_time[i] = scan.nextInt();
            if (nosso_time[i] == -1) {
                break;
            }
            tam_max++;
        }

        for (int i = 0; i < tam_max; i++) {
            time_adversario[i] = scan.nextInt();
            if (time_adversario[i] == -1) {
                break;
            }
        }

        for (int i = 0; i < tam_max; i++) {
            if (nosso_time[i] > time_adversario[i]) {
                vitorias++;
            }

            else if (nosso_time[i] < time_adversario[i]) {
                derrotas++;
            }

            else {
                empates++;
            }
        }

        System.out.printf("%d %d %d", vitorias, empates, derrotas);
        scan.close();
    }
}
