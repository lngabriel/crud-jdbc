package connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.Properties;

public class ConexaoBD {
    private static ConexaoBD instancia;
    private Connection conexao;

    private ConexaoBD() {

        Properties props = new Properties();

        try (FileInputStream in = new FileInputStream("config.properties")) {
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler config.properties", e);
        }

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar com o banco de dados!");
        }
    }

    public static ConexaoBD getInstance() {
        if (Objects.isNull(instancia)) {
            instancia = new ConexaoBD();
        }
        return instancia;
    }

    public Connection conexao() {
        return conexao;
    }
}
