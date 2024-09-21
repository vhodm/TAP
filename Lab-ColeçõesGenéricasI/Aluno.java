import java.util.Calendar;

public class Aluno {
    String nome;
    int matricula;
    int anoNascimento;

    Aluno (){
        this ("", 0, 0);
    }

    Aluno(String nome, int matricula, int anoNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.anoNascimento = anoNascimento;
    }

    int getIdade(){
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        return anoAtual - anoNascimento;
    }

    String getDescricao(){
        return (nome + " (mat=" + matricula + ", idade=" + getIdade() + ")");
    }
}
