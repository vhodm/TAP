import java.util.Scanner;

public class PinturaMuro {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int altura = 3;
        int comprimento = 12;

        int area = comprimento * altura;
        int preco_material = 100;

        float valorPintor = scan.nextFloat();

        float precoFinal = (valorPintor * area) + preco_material;

        System.out.printf("%.1f%n", precoFinal);
        scan.close();
    }
}
