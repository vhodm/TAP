import java.util.Scanner;

public class VolumeCombustivel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int altura_tanque = scan.nextInt();
        int nivel_combustivel = scan.nextInt();
        int raio_bojos = scan.nextInt();

        if (altura_tanque < 0 || nivel_combustivel < 0 || raio_bojos < 0) {
            System.out.print(-1.000);
            scan.close();
        }

        else {
            double volumeCombustivel = 0.0;

            if (nivel_combustivel <= raio_bojos) {
                // Nível de combustível está no bojo inferior (calota esférica)
                volumeCombustivel = (Math.PI / 3.0) * Math.pow(nivel_combustivel, 2) * (3 * raio_bojos - nivel_combustivel);
            }

            else if (nivel_combustivel <= altura_tanque - raio_bojos) {
                // Nível de combustível está na parte cilíndrica
                double volumeBojo = (2.0 / 3.0) * Math.PI * Math.pow(raio_bojos, 3);
                double alturaCilindro = nivel_combustivel - raio_bojos;
                double volumeCilindro = Math.PI * Math.pow(raio_bojos, 2) * alturaCilindro;
                volumeCombustivel = volumeBojo + volumeCilindro;
            }

            else {
                // Nível de combustível está no bojo superior (calota esférica)
                double volumeBojoInferior = (2.0 / 3.0) * Math.PI * Math.pow(raio_bojos, 3); // Volume do bojo inferior completo
                double alturaCalotaSuperior = nivel_combustivel - (altura_tanque - raio_bojos);
                double volumeCalotaSuperior = (Math.PI / 3.0) * Math.pow(alturaCalotaSuperior, 2) * (3 * raio_bojos - alturaCalotaSuperior);
                volumeCombustivel = volumeBojoInferior + Math.PI * Math.pow(raio_bojos, 2) * (altura_tanque - 2 * raio_bojos) + volumeCalotaSuperior;
            }

            System.out.printf("%.3f%n", volumeCombustivel);
            scan.close();
        }
    }
}
