import java.util.ArrayList;

public class Turma {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios;

    Turma(){
        this.nome = "";
        this.professor = "";
        this.numAlunos = 0;
        this.acessivel = false;
        this.horarios = new ArrayList<>();
    }

    Turma(String nome, String professor, int numAlunos, boolean acessivel){
        this.nome = nome;
        this.professor = professor;
        this.numAlunos = numAlunos;
        this.acessivel = acessivel;
        this.horarios = new ArrayList<>();
    }

    void addHorario(int horario) {
        horarios.add(horario);
    }

    String tratarBooleano(){
        if (this.acessivel == true){
            return "sim";
        }

        else {
            return "não";
        }
    }

    public String getHorariosString() {
        // Definindo os dias da semana
        String[] diasSemana = {"segunda", "terça", "quarta", "quinta", "sexta"};

        // StringBuilder para construir a string final
        StringBuilder horariosString = new StringBuilder();

        // Percorrer os horários e adicionar à string
        for (int i = 0; i < horarios.size(); i++) {
            Integer horario = horarios.get(i);

            // Calcular o índice do dia da semana
            int diaIndice = (horario - 1) / 7;

            // Calcular a hora (incrementos de 2h começando às 8h)
            int hora = 8 + ((horario - 1) % 7) * 2;

            // Adicionar o dia e hora à string
            horariosString.append(diasSemana[diaIndice]).append(" ").append(hora).append("hs");

            // Adicionar vírgula e espaço, exceto após o último horário
            if (i < horarios.size() - 1) {
                horariosString.append(", ");
            }
        }

        return horariosString.toString();
    }


    String getDescricao(){
        StringBuilder descricao = new StringBuilder();

        descricao.append("Turma: ").append(nome).append("\n");
        descricao.append("Professor: ").append(professor).append("\n");
        descricao.append("Número de Alunos: ").append(numAlunos).append("\n");
        descricao.append("Horário: ").append(getHorariosString()).append("\n");
        descricao.append("Acessível: ").append(tratarBooleano()).append("\n");

        return descricao.toString();
    }
}
