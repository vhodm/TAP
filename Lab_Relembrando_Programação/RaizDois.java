import java.util.Scanner;

public class RaizDois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        double semente = 1.0;

        // Calcula a fração contínua de baixo para cima
        double resultado = semente;
        for (int i = 1; i < N; i++) {
            resultado = 2.0 + resultado;
            resultado = 1.0 / resultado;
        }
        resultado = 1.0 + resultado;

        // Variável auxiliar para armazenar os resultados intermediários
        double tempResultado;

        // Para calcular e imprimir cada passo intermediário
        for (int i = 1; i <= N; i++) {
            tempResultado = semente;

            // Recalcula o resultado até o i-ésimo passo para o print intermediário
            for (int j = 0; j < i; j++) {
                tempResultado = 2.0 + tempResultado;
                tempResultado = 1.0 / tempResultado;
            }
            tempResultado = 1.0 + tempResultado;

            System.out.printf("%.14f\n", tempResultado);
        }

        scanner.close();
    }
}
