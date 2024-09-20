import java.util.Scanner;

public class SomaDigitos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numero = scan.nextInt();
        int soma = 0;

        while (numero != 0) {
            int digito = numero % 10;
            soma = soma + digito;
            numero = numero / 10;
        }

        System.out.printf("%d", soma);
    }
}
