public class EnsalamentoMain {
    public static void main(String[] args) {
        // Criação de um objeto Ensalamento
        Ensalamento e1 = new Ensalamento();

        // Criação de salas
        Sala s1 = new Sala(6, 101, 50, true); // Sala acessível com 50 lugares
        Sala s2 = new Sala(6, 102, 100, true); // Sala acessível com 100 lugares
        Sala s3 = new Sala(6, 203, 50, false); // Sala não acessível com 50 lugares
        Sala s4 = new Sala(6, 204, 100, false); // Sala não acessível com 100 lugares

        // Adiciona salas ao ensalamento
        e1.addSala(s1);
        e1.addSala(s2);
        e1.addSala(s3);
        e1.addSala(s4);

        // Criação de turmas
        Turma t1 = new Turma("Técnicas de Programação", "Horácio Fernandes", 50, false); // Turma não acessível com 50 alunos
        t1.addHorario(11); // Horário: terça-feira às 14hs
        t1.addHorario(25); // Horário: quinta-feira às 14hs
        t1.addHorario(32); // Horário: sexta-feira às 14hs

        Turma t2 = new Turma("Laboratório de Programação C", "Edson Nascimento", 25, true); // Turma acessível com 25 alunos
        t2.addHorario(1); // Horário: segunda-feira às 8hs
        t2.addHorario(15); // Horário: quarta-feira às 8hs
        t2.addHorario(29); // Horário: sexta-feira às 8hs

        Turma t3 = new Turma("Algoritmos e Estrutura de Dados I", "Edleno Silva", 60, false); // Turma não acessível com 60 alunos
        t3.addHorario(1); // Horário: segunda-feira às 8hs
        t3.addHorario(15); // Horário: quarta-feira às 8hs
        t3.addHorario(29); // Horário: sexta-feira às 8hs

        Turma t4 = new Turma("Redes de Computadores", "Edjair Souza", 70, true); // Turma acessível com 70 alunos
        t4.addHorario(2);
        t4.addHorario(16);

        // Adiciona turmas ao ensalamento
        e1.addTurma(t1);
        e1.addTurma(t2);
        e1.addTurma(t3);
        e1.addTurma(t4);

        // Aloca turmas nas salas
        e1.alocar(t1, s1); // Aloca t1 em s1
        e1.alocar(t2, s1); // Aloca t2 em s1
        e1.alocar(t3, s2); // Aloca t3 em s2
        e1.alocar(t4, s3);

        // Imprime o relatório de turmas por sala
        System.out.println(e1.relatorioTurmasPorSala());
    }
}