import java.util.Scanner;

public class AproximacaoSeno {
    public static double fatorial(int n) {
        double fat = 1;
        for (int i = 2; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }

    public static double calcular_seno(double x, int k) {
        double sen = 0.0;
        for (int i = 0; i < k; i++) {
            int exp = 2 * i + 1;
            double termo = Math.pow(x, exp) / fatorial(exp);

            if (i % 2 == 0) {
                sen += termo;
            } else {
                sen -= termo;
            }
            System.out.printf("%.10f%n", sen);
        }
        return sen;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double graus = scan.nextDouble();
        int k = scan.nextInt();

        double anguloRadianos = Math.toRadians(graus);
        calcular_seno(anguloRadianos, k);
    }
}
