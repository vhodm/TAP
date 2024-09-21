import java.util.*;

public class TurmaMain {
    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("Emmett L. Brown", 7714, 22);
        System.out.println(aluno1.getDescricao());

        Aluno aluno2 = new Aluno("Egon Spengler", 5907, 20);
        Aluno aluno3 = new Aluno("Peter Weyland", 7734, 19);

        Professor professor1 = new Professor("Dr.", "Horacio Fernandes", 2208);
        System.out.println(professor1.getDescricao());

        Turma turma1 = new Turma("Iniciação Tecnológica e Científica", 2016, 1, professor1);


        turma1.addAluno(aluno1);
        turma1.addAluno(aluno2);
        turma1.addAluno(aluno3);

        System.out.println(turma1.getDescricao());
    }
}
