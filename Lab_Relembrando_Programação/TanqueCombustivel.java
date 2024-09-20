import java.util.Scanner;

public class TanqueCombustivel {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int r = scan.nextInt();
        int x = scan.nextInt();
        int opcao = scan.nextInt();

        double volumeEsfera = (4.0/3.0) * Math.PI * Math.pow(r,3);
        double volumeCalota = (Math.PI/3.0) * Math.pow(x,2) * (3*r - x);

        if (opcao == 1){
            System.out.printf("%.4f", volumeCalota);
        }

        else if (opcao == 2){
            System.out.printf("%.4f", volumeEsfera-volumeCalota);
        }

    scan.close();
    }
}
