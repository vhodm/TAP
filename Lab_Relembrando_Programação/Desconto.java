import java.util.Scanner;

public class Desconto {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double preco = scan.nextDouble();

        if (preco > 200){
            double novoPreco = preco - (preco * 0.05);
            System.out.printf("%.2f%n", novoPreco);
        }

        else {
            System.out.printf("%.2f%n", preco);
        }
    }
}