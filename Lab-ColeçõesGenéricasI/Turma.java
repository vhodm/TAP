import java.util.*;

public class Turma {
    String disciplina;
    int ano;
    int semestre;
    Professor professor;
    ArrayList<Aluno> alunos;

    Turma(String disciplina, int ano, int semestre, Professor prof) {
        this.disciplina = disciplina;
        this.ano = ano;
        this.semestre = semestre;
        this.professor = prof;
        this.alunos = new ArrayList<>();
    }

    Aluno getAluno(int matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.matricula == matricula) {
                return aluno;
            }
        }

        return null;
    }

    void addAluno(Aluno aluno) {
        if (getAluno(aluno.matricula) != null) {
            return;
        }

        alunos.add(aluno);
    }

    double getMediaIdade(){
        int tamanho = alunos.size();
        if (tamanho == 0) {
            return 0;
        }
        int soma = 0;

        for (Aluno aluno : alunos) {
            soma += aluno.getIdade();
        }

        return (double) soma / tamanho;
    }

    String getDescricao() {
        StringBuilder descricao = new StringBuilder();

        descricao.append("Turma ").append(disciplina).append(" - ")
                .append(ano).append("/").append(semestre).append(" (")
                .append(professor.getDescricao()).append("):\n");

        int alunoNum = 1;
        for (Aluno aluno : alunos) {
            descricao.append(" - Aluno ").append(alunoNum).append(": ")
                    .append(aluno.nome).append(" (mat=")
                    .append(aluno.matricula).append(", idade=")
                    .append(aluno.getIdade()).append(")\n");
            alunoNum++;
        }

        return descricao.toString();
    }
}
