public class Cardapio {
    private int id; // ID do item no cardápio
    private String nome;
    private double preco;
    private boolean disponivel;

    public Cardapio(int id, String nome, double preco, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    // Representação em String para fácil visualização
    @Override
    public String toString() {
        return "Item: " + nome + " | Preço: R$" + preco + " | Disponível: " + (disponivel ? "Sim" : "Não");
    }
}
