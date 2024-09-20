
import java.util.Scanner;

public class Mediana {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] vet = new int[100];
        int tam_max = 0;

        for (int i = 0; i < vet.length; i++) {
            vet[i] = scan.nextInt();
            if (vet[i] == -1) {
                break;
            }
            tam_max++;
        }

        if (tam_max % 2 != 0){
            int indice = tam_max / 2;
            double mediana = vet[indice];
            System.out.printf("%.1f%n", mediana);
            scan.close();
        }

        else {
            int indice = tam_max / 2;
            double mediana = (vet[indice - 1] + vet[indice]) / 2.0;
            System.out.printf("%.1f%n", mediana);
            scan.close();
        }
    }
}
