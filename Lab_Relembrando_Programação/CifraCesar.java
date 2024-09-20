import java.util.Scanner;

public class CifraCesar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int deslocamento = scan.nextInt();
        String texto = scan.nextLine();
        texto = texto.toUpperCase();

        StringBuilder textoCifrado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caractere = texto.charAt(i);

            if (caractere >= 'A' && caractere <= 'Z') {
                char caractereCifrado = (char) ((caractere - 'A' + deslocamento) % 26 + 'A');
                textoCifrado.append(caractereCifrado);
            } else {
                textoCifrado.append(caractere);
            }
        }

        System.out.println(textoCifrado.toString().trim());
        scan.close();
    }
}
