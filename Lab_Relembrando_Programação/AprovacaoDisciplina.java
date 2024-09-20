import java.util.Scanner;

public class AprovacaoDisciplina {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        double[] notas = new double[100];
        int[] presenca = new int[100];
        int tam_max = 0;
        double num_nota = 0;
        int num_presenca = 0;

        for (int i = 0; i < notas.length; i++) {
            num_nota = scan.nextDouble();
            if (num_nota == -1){
                break;
            } else {
                notas[i] = num_nota;
                tam_max++;
            }
        }

        for (int i = 0; i < presenca.length; i++) {
            num_presenca = scan.nextInt();
            if (num_presenca == -1){
                break;
            } else {
                presenca[i] = num_presenca;
            }
        }

        int carga_horaria = scan.nextInt();

        int aprovados = 0;
        int rep_nota = 0;
        int rep_frequencia = 0;

        for (int k = 0; k < tam_max; k++) {
            double porcentagem = (double) presenca[k] / (double) carga_horaria;

            if (notas[k] >= 5.0 && porcentagem >= 0.75) {
                aprovados++;
            }

            else if (porcentagem >= 0.75 && notas[k] < 5.0){
                rep_nota++;
            }

            else {
                rep_frequencia++;
            }
        }

        System.out.printf("%d %d %d%n", aprovados, rep_nota, rep_frequencia);
        scan.close();
    }
}
