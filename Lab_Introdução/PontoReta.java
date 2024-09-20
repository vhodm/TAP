import java.util.Scanner;

public class PontoReta {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		float x = scan.nextFloat();
		float y = scan.nextFloat();
		float cof = (2 * x) + y;
		
		if (cof == 3) {
			System.out.println("Ponto (" + x + ", " + y + ") pertence a reta 2x + y = 3.");
		}
		
		else {
			System.out.println("Ponto (" + x + ", " + y + ") nao pertence a reta 2x + y = 3.");

		}
		
		scan.close();
	}

}
