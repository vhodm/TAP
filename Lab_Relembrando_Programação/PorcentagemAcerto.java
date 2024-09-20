import java.util.Scanner;

public class PorcentagemAcerto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] respostas = new int[100];
        int[] gabarito = new int[100];

        int qtd_questoes = 0;
        int acertos = 0;

        for (int i = 0; i < respostas.length; i++) {
            respostas[i] = scan.nextInt();
            if (respostas[i] == -1) {
                break;
            }
            qtd_questoes++;
        }

        for (int i = 0; i < gabarito.length; i++) {
            gabarito[i] = scan.nextInt();
            if (gabarito[i] == -1) {
                break;
            }
        }

        for (int i = 0; i < qtd_questoes; i++) {
            if (respostas[i] == gabarito[i]) {
                acertos++;
            }
        }

        double porcentagem = (acertos / (double)qtd_questoes) * 100;
        System.out.printf("%.2f%n", porcentagem);
    }
}
