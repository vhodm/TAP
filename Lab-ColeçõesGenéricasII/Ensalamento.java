import java.util.ArrayList;
import java.util.Collections;

// Cria um array de sala, um array de turmas e um array do par (Sala,Turma)
public class Ensalamento {
    ArrayList<Sala> salas;
    ArrayList<Turma> turmas;
    ArrayList<TurmaEmSala> ensalamento;

    // metodo construtor para inicialização
    Ensalamento() {
        this.salas = new ArrayList<>();
        this.turmas = new ArrayList<>();
        this.ensalamento = new ArrayList<>();
    }

    // Adiciona uma sala ao array de salas
    void addSala(Sala sala) {
        this.salas.add(sala);
    }

    // Adiciona uma turma ao array de turmas
    void addTurma(Turma turma) {
        this.turmas.add(turma);
    }

    // Ordena as salas por capacidade (ordem crescente)
    private void ordenarSalasPorCapacidade() {
        Collections.sort(salas, (sala1, sala2) -> Integer.compare(sala1.capacidade, sala2.capacidade));
    }

    // Restaura a ordem original das salas
    private void restaurarOrdemOriginal(ArrayList<Sala> ordemOriginal) {
        salas.clear(); // Limpa o array atual
        salas.addAll(ordemOriginal); // Reinsere as salas na ordem original
    }

    // Procura em qual sala a turma está usando o array do ensalamento (par Sala,Turma)
    Sala getSala(Turma turma) {
        for (TurmaEmSala turmaEmSala : ensalamento) { // Percorre o array do ensalamento

            // Verifica se a turma no índice I do ensalamento corresponde a turma do parâmetro
            if (turmaEmSala.turma == turma) {
                return turmaEmSala.sala; // Retorna a classe Sala daquela turma
            }
        }
        return null; // Retorna nada caso não esteja
    }

    // Verifica se uma sala X está disponível no horário H
    boolean salaDisponivel(Sala sala, int horario) {
        for (TurmaEmSala turmaEmSala : ensalamento) { // Percorre o array (Sala,Turma)
            if (turmaEmSala.sala == sala) { // Verifica se primeiramente a sala existe

                // Verifica se existe alguma turma T no horário H pretendido
                for (Integer horarioOcupado : turmaEmSala.turma.horarios) {
                    if (horarioOcupado == horario) {
                        return false; // Sala está ocupada no horário
                    }
                }
            }
        }
        // Se passou por todas as verificações, a sala está disponível no horário
        return true;
    }

    // Verifica se um conjunto de horários H está disponível na sala S
    boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) {

        // Funcionamento similar a função anterior
        for (TurmaEmSala turmaEmSala : ensalamento) {
            if (turmaEmSala.sala == sala) {

                // A diferença é que percorreremos o vetor horarios passado no parâmetro
                for (Integer horario : horarios) {
                    if (!salaDisponivel(sala, horario)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    // Aloca uma sala no primeiro espaço disponível.
    boolean alocar(Turma turma, Sala sala) {

        // 1. Verifica se a turma é acessível, mas a sala não é, então a alocação falha
        if (turma.acessivel && !sala.acessivel) {
            return false;
        }

        // 2. Verifica se a capacidade da sala é menor que o número de alunos da turma
        if (turma.numAlunos > sala.capacidade) {
            return false;
        }

        // 3. Verifica se a sala está disponível nos horários da turma
        if (!salaDisponivel(sala, turma.horarios)) {
            return false;
        }

        // 4. Se todas as condições foram atendidas, aloca a turma à sala
        TurmaEmSala turmaEmSala = new TurmaEmSala(turma, sala);
        ensalamento.add(turmaEmSala);
        return true; // A alocação foi bem-sucedida
    }

    // Aloca todas as turmas presentes no array de turmas.
    void alocarTodas() {

        ArrayList<Sala> ordemOriginal = new ArrayList<>(salas);

        // Ordena as salas por capacidade
        ordenarSalasPorCapacidade();

        // Tenta alocar cada turma em uma sala disponível
        for (Turma turma : turmas) {
            boolean alocada = false;

            // Tenta encontrar uma sala adequada para a turma
            for (Sala sala : salas) {
                if (salaDisponivel(sala, turma.horarios)) {
                    alocada = alocar(turma, sala); // Tenta alocar a turma na sala
                    if (alocada) {
                        break; // Se foi alocada, para de procurar salas para essa turma
                    }
                }
            }
        }

        // Restaura a ordem original das salas
        restaurarOrdemOriginal(ordemOriginal);
    }

    // Retorna quantas turmas foram alocadas
    int getTotalTurmasAlocadas() {
        int totalTurmasAlocadas = 0; // Inicializa o contador

        // Percorre o array (Sala,Turma) e verifica quantos deles estão com o campo sala não nulo
        for (TurmaEmSala turmaEmSala : ensalamento) {
            if (turmaEmSala.sala != null) {
                totalTurmasAlocadas++;
            }
        }

        return totalTurmasAlocadas; // retorna o contador
    }

    // Verifica quantas cadeiras no somatório sobraram. Quanto menos, melhor
    int getTotalEspacoLivre() {
        int totalEspacoLivre = 0; // inicializa o acumulador

        // Percorre o array (Sala,Turma)
        for (TurmaEmSala turmaEmSala : ensalamento) {
            if (turmaEmSala.sala != null && turmaEmSala.turma != null) {

                // Adiciona ao acumulador a diferença entre capacidade da sala e o tamanho da turma
                totalEspacoLivre += turmaEmSala.sala.capacidade - turmaEmSala.turma.numAlunos;
            }
        }
        return totalEspacoLivre; // retorna o acumulador
    }

    // Retorna uma string com salas, turmas e os resultados das duas funções acima.
    String relatorioResumoEnsalamento() {

        // inicializa a string
        StringBuilder relatorio1 = new StringBuilder();

        // adiciona as informações
        relatorio1.append("Total de Salas: ").append(salas.size()).append("\n");
        relatorio1.append("Total de Turmas: ").append(turmas.size()).append("\n");
        relatorio1.append("Turmas Alocadas: ").append(getTotalTurmasAlocadas()).append("\n");
        relatorio1.append("Espaços Livres: ").append(getTotalEspacoLivre()).append("\n");

        return relatorio1.toString(); // retorna a string
    }

    // retorna o relatorio de ensalamento + a lista de turmas por sala
    String relatorioTurmasPorSala() {

        // Funcionamento similar a anterior
        StringBuilder relatorio2 = new StringBuilder();
        relatorio2.append(relatorioResumoEnsalamento());
        relatorio2.append("\n");

        // A diferença aqui é q percorreremos o vetor de salas
        for (Sala sala : salas) {
            relatorio2.append("--- ").append(sala.getDescricao()).append(" ---").append("\n");
            relatorio2.append("\n");

            // E para cada sala percorreremos o ensalamento de cada turma q bata com o indice do vetor de salas
            for (TurmaEmSala turmaEmSala : ensalamento) {
                if (turmaEmSala.sala == sala) {
                    relatorio2.append(turmaEmSala.turma.getDescricao());
                    relatorio2.append("\n");
                }
            }
        }

        String result = relatorio2.toString();
        return result.substring(0, result.length()-1); // retorna a string
    }

    // Similar com os dois anteriores, mas agora relata inclusive as turmas sem sala
    String relatorioSalasPorTurma() {
        StringBuilder relatorio3 = new StringBuilder();

        // Adiciona o resumo do ensalamento
        relatorio3.append(relatorioResumoEnsalamento());
        relatorio3.append("\n");

        // Percorre as turmas e as descreve normalmente
        for (Turma turma : turmas) {
            relatorio3.append(turma.getDescricao()).append("\n");

            // Busca a sala alocada para a turma usando um metodo criado acima
            Sala salaAlocada = getSala(turma);

            // Se encontrar, chama o metodo getDescrição da classe Sala
            if (salaAlocada != null) {
                relatorio3.append("Sala: ").append(salaAlocada.getDescricao()).append("\n");

            // Se não, escreve apenas SEM SALA
            } else {
                relatorio3.append("Sala: SEM SALA").append("\n");
            }

            relatorio3.append("\n"); // Espaço entre turmas
        }

        return relatorio3.toString(); // retorna a string
    }
}