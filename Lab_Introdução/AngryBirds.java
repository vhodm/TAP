import java.util.Scanner;

public class AngryBirds {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int v0 = scan.nextInt();
		int ang = scan.nextInt();
		double dh = scan.nextDouble();
		
		double radianos = Math.toRadians(ang);
		
		double r1 = ((v0 * v0) * Math.sin(2 * radianos)) / 9.8;
		
		if (dh - r1 < 0.1) {
			System.out.println("1");
		}
		
		else {
			System.out.println("0");
		}
		
		scan.close();
	}

}
