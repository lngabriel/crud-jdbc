import connection.ConexaoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteService {
    public void cadastrarCliente(String nome, String email) {
        String sql = "INSERT INTO clientes (nome, email) VALUES (?, ?)";

        try (PreparedStatement ps = ConexaoBD.getInstance().conexao().prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar cliente no banco de dados!");
        }
    }

    public void buscarPorId(int id) {
        String sql = "SELECT id, nome, email FROM clientes WHERE id = ?";

        try (PreparedStatement ps = ConexaoBD.getInstance().conexao().prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    IO.println(rs.getInt("id") + ", " + rs.getString("nome") + ", " + rs.getString("email"));
                } else {
                    IO.println("ID não encontrado!");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Não foi possível buscar este ID.");
        }
    }
}
