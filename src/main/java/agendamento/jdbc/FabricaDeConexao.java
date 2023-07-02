package agendamento.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FabricaDeConexao {

    public static Connection getConexao(){
        try {

            final String URL = "jdbc:mysql://localhost/project_agendamento?useSSL=false";

            final String USERNAME = "root";
            final String PASSWORD = "Camila1006";

            return DriverManager.getConnection(URL, USERNAME, PASSWORD);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
