package agendamento.database;

import agendamento.jdbc.FabricaDeConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDeConexao {

    private static Connection connection;

    public static void main(String[] args) throws SQLException {
//        final String URL = "jdbc:mysql://localhost?useSSL=false";
//        final String USERNAME = "root";
//        final String PASSWORD = "Camila1006";
//
//        Connection conexao = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        Connection conexao = FabricaDeConexao.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS project_agendamento");


        System.out.println("Conexão efetuada com sucesso");
        connection.close();

    }

}