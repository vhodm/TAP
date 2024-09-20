import java.util.Scanner;

public class AnimaisCedulas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cedula = scan.nextInt();
		
		switch (cedula) {
		case 2:
			System.out.println("Tartaruga");
		case 5:
			System.out.println("Garça");
		case 10:
			System.out.println("Arara");
		case 20:
			System.out.println("Mico-leão-dourado");
		case 50:
			System.out.println("Onça-pintada");
		case 100:
			System.out.println("Garoupa");
		default:
			System.out.println("erro");
		}
		
		scan.close();

	}

}
