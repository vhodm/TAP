import java.util.Scanner;

public class IdadeUfam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int idade = scan.nextInt();
        int idadeUfam = idade - 1909;

        System.out.println("A UFAM tem " + idadeUfam + " anos de fundacao");
    }
}