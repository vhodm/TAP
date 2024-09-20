import java.util.Scanner;

public class CaixaEletronico {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int valor = scan.nextInt();
        int notasCinquenta = 0;
        int notasDez = 0;
        int notasDois = 0;

        if ((valor > 0) && (valor % 2 == 0)){
            while (valor > 50){
                notasCinquenta++;
                valor = valor - 50;
            }

            while (valor > 10){
                notasDez++;
                valor = valor - 10;
            }

            while (valor > 0){
                notasDois++;
                valor = valor - 2;
            }

            System.out.println(notasCinquenta + " notas de R$50, " + notasDez + " notas de R$10 e " + notasDois + " notas de R$2");
        }

        else {
            System.out.println("Valor Invalido");
        }
    }
}
