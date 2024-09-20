import java.util.Scanner;

public class DataExtenso {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int data = scan.nextInt();

        int dia = data / 1000000;
        int mes = (data / 10000) % 100;
        int ano = data % 10000;

        String[] meses = {
                "janeiro", "fevereiro", "março", "abril", "maio", "junho",
                "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
        };

        System.out.printf("%d de %s de %d%n", dia, meses[mes - 1], ano);
        scan.close();
    }
}
