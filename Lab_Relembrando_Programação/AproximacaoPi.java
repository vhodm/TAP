import java.util.Scanner;

public class AproximacaoPi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        double pi = 3.0;
        System.out.printf("%.6f%n", pi);

        for (int i = 1; i <= num-1; i++) {
            int denominador = 2*i * (2*i+1) * (2*i+2);

            if (i % 2 == 1) {
                pi += 4.0 / denominador;
                System.out.printf("%.6f%n", pi);
            }

            else {
                pi -= 4.0 / denominador;
                System.out.printf("%.6f%n", pi);
            }
        }
        scan.close();
    }
}
