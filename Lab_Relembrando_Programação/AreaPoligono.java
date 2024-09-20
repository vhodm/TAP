import java.util.Scanner;

public class AreaPoligono {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double[] abscissas = new double[100];
        double[] ordenadas = new double[100];
        int tam_max = 0;

       while (tam_max < abscissas.length) {
           abscissas[tam_max] = scan.nextDouble();
           if (abscissas[tam_max] == -1) {
               break;
           }
           tam_max++;
       }

       for (int i = 0; i < tam_max; i++) {
           ordenadas[i] = scan.nextDouble();
           if (ordenadas[i] == -1) {
               break;
           }
       }

       double somatorio = 0.0;

       for (int i = 0; i < tam_max - 1; i++) {
           somatorio += (abscissas[i] * ordenadas[i + 1]) - (ordenadas[i] * abscissas[i + 1]);
       }

       // Fechamento do polígono (conexão do último ponto ao primeiro)
        somatorio += (abscissas[tam_max - 1] * ordenadas[0]) - (ordenadas[tam_max - 1] * abscissas[0]);

        double area = Math.abs(somatorio) / 2.0;

        System.out.printf("%.4f%n", area);
        scan.close();
    }
}
