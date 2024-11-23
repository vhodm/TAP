import java.util.ArrayList;

public class Garcom {
    private int id; // ID único do garçom
    private String nome;
    private boolean ativo; // Status ativo ou inativo
    private ArrayList<Mesa> mesas; // Lista de mesas que o garçom atende

    public Garcom(int id, String nome, boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.ativo = ativo;
        this.mesas = new ArrayList<>();
    }

    // Métodos para adicionar e remover mesas
    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void removerMesa(Mesa mesa) {
        mesas.remove(mesa);
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public boolean isAtivo() { return ativo; }
    public ArrayList<Mesa> getMesas() { return mesas; }

    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    // Representação em String para fácil visualização
    @Override
    public String toString() {
        return "Garçom: " + nome + " | Status: " + (ativo ? "Ativo" : "Inativo") + " | Mesas: " + mesas;
    }
}
