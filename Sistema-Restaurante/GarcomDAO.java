import java.sql.*;
import java.util.*;

public class GarcomDAO extends BDRestaurante {
    public GarcomDAO() {
        this.conectar(); // Inicializa a conexão
    }

    public void atribuirMesaAoGarcom(int idGarcom, int idMesa) {
        String sql = "UPDATE mesa SET id_garcom = ? WHERE id = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idGarcom);
            ps.setInt(2, idMesa);

            int linhasAfetadas = ps.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Mesa atribuída ao garçom com sucesso!");
            } else {
                System.out.println("Falha ao atribuir mesa. Verifique os IDs.");
            }

            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atribuir mesa ao garçom: " + e.getMessage());
        }
    }

    // Metodo para listar mesas de um garçom
    public ArrayList<Mesa> listarMesasPorGarcom(int idGarcom) {
        ArrayList<Mesa> mesas = new ArrayList<>();
        String sql = "SELECT * FROM mesa WHERE id_garcom = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, idGarcom);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa mesa = new Mesa(
                        rs.getInt("id"),
                        rs.getInt("capacidade"),
                        rs.getBoolean("disponivel"),
                        rs.getInt("id_garcom")
                );
                mesas.add(mesa);
            }

            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar mesas: " + e.getMessage());
        }

        return mesas;
    }
}