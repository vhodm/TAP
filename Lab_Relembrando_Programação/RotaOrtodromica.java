import java.util.Scanner;

public class RotaOrtodromica {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double t1 = scan.nextDouble();
        double g1 = scan.nextDouble();
        double t2 = scan.nextDouble();
        double g2 = scan.nextDouble();

        double t1Radianos = Math.toRadians(t1);
        double g1Radianos = Math.toRadians(g1);
        double t2Radianos = Math.toRadians(t2);
        double g2Radianos = Math.toRadians(g2);

        double distancia = 6371 * Math.acos(Math.sin(t1Radianos) * Math.sin(t2Radianos) + Math.cos(t1Radianos) * Math.cos(t2Radianos) * Math.cos(g1Radianos - g2Radianos));

        System.out.printf("A distancia entre os pontos (%f, %f) e (%f, %f) e de %.2f km%n", t1, g1, t2, g2, distancia);
    }
}
