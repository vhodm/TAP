import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDRestaurante {
    protected Connection conexao;

    public void conectar() {
        String url = "jdbc:mysql://localhost:3306/TesteBD";
        String usuario = "user_testebd";
        String senha = "Teste123";

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexão com o banco de dados estabelecida!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
                System.out.println("Conexão com o banco de dados encerrada!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao encerrar a conexão com o banco de dados: " + e.getMessage());
        }
    }
}
