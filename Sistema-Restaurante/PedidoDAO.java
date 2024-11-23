import java.sql.*;
import java.time.*;
import java.time.format.*;

public class PedidoDAO {
    private Connection conexao;

    public PedidoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Metodo para criar um novo pedido
    public int criarPedido(int mesaId, int garcomId) {
        String sql = "INSERT INTO pedido (mesa_id, garcom_id, data_hora, status) VALUES (?, ?, ?, 'pendente')";
        try (PreparedStatement ps = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, mesaId);
            ps.setInt(2, garcomId);
            ps.setString(3, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            ps.executeUpdate();

            // Retorna o ID gerado do pedido
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar pedido: " + e.getMessage());
        }
        return -1;
    }

    // Metodo para adicionar itens ao pedido
    public void adicionarItemAoPedido(int pedidoId, int itemId, int quantidade) {
        String sql = "INSERT INTO pedido_itens (pedido_id, item_id, quantidade) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, pedidoId);
            ps.setInt(2, itemId);
            ps.setInt(3, quantidade);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar item ao pedido: " + e.getMessage());
        }
    }

    // Metodo para listar pedidos pendentes
    public void listarPedidosPendentes() {
        String sql = "SELECT p.id, p.data_hora, m.id AS mesa, g.nome AS garcom " +
                "FROM pedido p " +
                "JOIN mesa m ON p.mesa_id = m.id " +
                "JOIN garcom g ON p.garcom_id = g.id " +
                "WHERE p.status = 'pendente'";
        try (Statement st = conexao.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Pedido ID: " + rs.getInt("id") +
                        ", Mesa: " + rs.getInt("mesa") +
                        ", Garçom: " + rs.getString("garcom") +
                        ", Criado em: " + rs.getString("data_hora"));
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar pedidos pendentes: " + e.getMessage());
        }
    }

    // Metodo para atualizar o status do pedido
    public void atualizarStatusPedido(int pedidoId, String status) {
        String sql = "UPDATE pedido SET status = ? WHERE id = ?";
        try (PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, pedidoId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status do pedido: " + e.getMessage());
        }
    }
}
