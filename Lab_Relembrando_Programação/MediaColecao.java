import java.util.Scanner;

public class MediaColecao {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int total = 0;
        int qtd = 0;

        while (n != -1) {
            qtd++;
            total = total + n;
            n = scan.nextInt();
        }

        float media = (float) total / qtd;
        System.out.printf("%.2f", media);
    }
}
