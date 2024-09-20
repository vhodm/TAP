import java.util.Scanner;

public class AsciiArt {
    public static void main(String[] args) {
        int espacos = 0;

        Scanner scan = new Scanner(System.in);
        int numAsteriscos = scan.nextInt();
        int asteriscos = numAsteriscos;

        for (int i = 0; i < numAsteriscos; i++) {
            for (int j = 0; j < asteriscos; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < espacos; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < asteriscos; j++) {
                System.out.print("*");
            }

            System.out.println();

            asteriscos--;
            espacos += 2;
        }

        scan.close();
    }
}
