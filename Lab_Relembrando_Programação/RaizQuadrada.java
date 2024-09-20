import java.util.Scanner;

public class RaizQuadrada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();
        n = Math.sqrt(n);
        System.out.printf("%.4f", n);
    }
}