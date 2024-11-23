public class Mesa {
    private int id;
    private int capacidade;
    private boolean disponivel;
    private int idGarcom; // ID do garçom responsável (chave estrangeira)

    // Construtor
    public Mesa(int id, int capacidade, boolean disponivel, int idGarcom) {
        this.id = id;
        this.capacidade = capacidade;
        this.disponivel = disponivel;
        this.idGarcom = idGarcom;
    }

    // Getters e setters
    public int getId() { return id; }
    public int getCapacidade() { return capacidade; }
    public boolean isDisponivel() { return disponivel; }
    public int getIdGarcom() { return idGarcom; }

    public void setIdGarcom(int idGarcom) { this.idGarcom = idGarcom; }

    @Override
    public String toString() {
        return "Mesa [id=" + id + ", capacidade=" + capacidade + ", disponivel=" + disponivel + ", idGarcom=" + idGarcom + "]";
    }
}
