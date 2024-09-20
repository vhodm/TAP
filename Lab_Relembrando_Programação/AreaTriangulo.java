import java.util.Scanner;

public class AreaTriangulo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if (a+b > c && a+c > b && b+c > a){
            double s = (a + b + c) / 2;

            double raiz = s * (s-a) * (s-b) * (s-c);
            double area = Math.sqrt(raiz);
            System.out.printf("%.2f", area);
        }

        else {
            System.out.println("Triangulo invalido");
        }
    }
}
