import java.sql.*;
import java.util.*;

public class CardapioDAO {
    private Connection conexao;

    public CardapioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Metodo para adicionar um item ao cardápio
    public void adicionarItem(String nome, double preco, boolean disponivel) {
        String sql = "INSERT INTO cardapio (nome, preco, disponivel) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setDouble(2, preco);
            ps.setBoolean(3, disponivel);
            ps.executeUpdate();
            System.out.println("Item adicionado ao cardápio com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar item: " + e.getMessage());
        }
    }

    // Metodo para atualizar um item do cardápio
    public void atualizarItem(int id, String nome, double preco, boolean disponivel) {
        String sql = "UPDATE cardapio SET nome = ?, preco = ?, disponivel = ? WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setDouble(2, preco);
            ps.setBoolean(3, disponivel);
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Item atualizado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar item: " + e.getMessage());
        }
    }

    // Metodo para remover um item do cardápio
    public void removerItem(int id) {
        String sql = "DELETE FROM cardapio WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Item removido com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao remover item: " + e.getMessage());
        }
    }

    // Metodo para buscar todos os itens do cardápio
    public List<String> listarItens() {
        String sql = "SELECT * FROM cardapio";
        List<String> itens = new ArrayList<>();
        try (Statement st = conexao.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");
                boolean disponivel = rs.getBoolean("disponivel");
                itens.add("ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Disponível: " + (disponivel ? "Sim" : "Não"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar itens: " + e.getMessage());
        }
        return itens;
    }

    // Metodo para buscar um item pelo ID
    public String buscarItemPorId(int id) {
        String sql = "SELECT * FROM cardapio WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    double preco = rs.getDouble("preco");
                    boolean disponivel = rs.getBoolean("disponivel");
                    return "ID: " + id + ", Nome: " + nome + ", Preço: " + preco + ", Disponível: " + (disponivel ? "Sim" : "Não");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar item: " + e.getMessage());
        }
        return "Item não encontrado.";
    }
}