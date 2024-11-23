import java.util.*;
import java.time.*;

public class Pedido {
    private Mesa mesa;
    private Garcom garcomResponsavel;
    private ArrayList<Cardapio> itens;
    private LocalDateTime timestamp; // Data e hora do pedido

    public Pedido(Mesa mesa, Garcom garcomResponsavel) {
        this.mesa = mesa;
        this.garcomResponsavel = garcomResponsavel;
        this.itens = new ArrayList<>();
        this.timestamp = LocalDateTime.now(); // Marca o momento da criação
    }

    // Métodos para adicionar e remover itens do pedido
    public void adicionarItem(Cardapio item) {
        itens.add(item);
    }

    public void removerItem(Cardapio item) {
        itens.remove(item);
    }

    // Getters e Setters
    public Mesa getMesa() { return mesa; }
    public Garcom getGarcomResponsavel() { return garcomResponsavel; }
    public ArrayList<Cardapio> getItens() { return itens; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // Representação em String para fácil visualização
    @Override
    public String toString() {
        return "Pedido para Mesa " + mesa.getId() + " | Garçom: " + garcomResponsavel.getNome() +
                " | Itens: " + itens + " | Criado em: " + timestamp;
    }
}