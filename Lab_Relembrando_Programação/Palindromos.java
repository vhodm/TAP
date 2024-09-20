import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String linha = scan.nextLine();
        String texto = linha.replace(" ", "").toUpperCase();

        boolean palindromo = true;
        int tam = texto.length();

        for (int i = 0; i < tam/2; i++) {
            if (texto.charAt(i) != texto.charAt(tam - 1 - i)) {
                palindromo = false;
                break;
            }
        }

        System.out.print(texto + " ");
        if (palindromo) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }

        scan.close();
    }
}

