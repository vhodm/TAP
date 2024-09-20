import java.util.Scanner;

public class ContaEnergia {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int consumo_energia = scan.nextInt();
        char tipo = scan.next().charAt(0);

        if (consumo_energia < 0) {
            System.out.printf("-1.00");
            scan.close();
        }

        else if (tipo == 'R') {
            if (consumo_energia < 500){
                double preco = consumo_energia * 0.40;
                System.out.printf("%.2f", preco);
                scan.close();
            }

            else {
                double preco = consumo_energia * 0.65;
                System.out.printf("%.2f", preco);
                scan.close();
            }
        }

        else if (tipo == 'C') {
            if (consumo_energia < 1000){
                double preco = consumo_energia * 0.55;
                System.out.printf("%.2f", preco);
                scan.close();
            }

            else {
                double preco = consumo_energia * 0.60;
                System.out.printf("%.2f", preco);
                scan.close();
            }
        }

        else if (tipo == 'I') {
            if (consumo_energia < 5000) {
                double preco = consumo_energia * 0.55;
                System.out.printf("%.2f", preco);
                scan.close();
            }

            else {
                double preco = consumo_energia * 0.60;
                System.out.printf("%.2f", preco);
                scan.close();
            }
        }

        else {
            System.out.printf("-1.00");
            scan.close();
        }
    }
}
