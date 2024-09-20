import java.util.Scanner;

public class NumeroNeperiano {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        double e = 1.0;
        double fat = 1.0;

        for (int i = 1; i < num; i++){
            fat *= i;
            e += 1.0 / fat;
        }

        System.out.printf("%.6f%n", e);
        scan.close();
    }
}
