import java.util.Scanner;

public class TipoTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if (a+b <= c || a+c <= b || b+c <= a) {
            System.out.println("invalido");
            scan.close();
        }

        else {
            if (a == b && b == c){
                System.out.printf("equilatero");
                scan.close();
            }

            else if (a == b || a == c || b == c){
                System.out.println("isosceles");
                scan.close();
            }

            else {
                System.out.println("escaleno");
                scan.close();
            }
        }
    }
}
