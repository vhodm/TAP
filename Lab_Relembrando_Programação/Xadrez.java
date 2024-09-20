import java.util.Scanner;

public class Xadrez {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();

        for (int i = 0; i < x; i++) { // for para as linhas
            if (i % 2 == 0) {
                for (int j = 0; j < x; j++) {
                    System.out.print("* ");
                }
            } else {
                System.out.print(" ");
                for (int j = 1; j < x+1; j++) {
                    System.out.print("* ");
                }
            }
        System.out.println();
        }
    }
}
