import java.util.Scanner;

public class SomaColecoes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int soma = 0;
            boolean colecaoVazia = true;

            while (true) {
                int n = scan.nextInt();

                if (n == -1) {
                    if (colecaoVazia) {
                        return;
                    } else {
                        break;
                    }
                }

                soma += n;
                colecaoVazia = false;
            }

            System.out.println(soma);
        }
    }
}
