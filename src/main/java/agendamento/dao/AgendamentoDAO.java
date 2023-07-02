package agendamento.dao;

import agendamento.jdbc.FabricaDeConexao;
import agendamento.model.Agendamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AgendamentoDAO {
    private Connection conexao;

    public AgendamentoDAO() {
        this.conexao = FabricaDeConexao.getConexao();
    }

  
    public Agendamento buscarAgendamento(String horario) {
        String query = "SELECT * FROM project_agendamento.agendamento WHERE horario = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, horario);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Agendamento agendamento = new Agendamento();
                agendamento.setId(rs.getInt("id"));
                agendamento.setHorario(rs.getString("horario"));
                agendamento.setCliente(rs.getString("cliente"));
                agendamento.setProfissional(rs.getString("profissional"));
                return agendamento;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar agendamento no banco de dados", e);
        }

        return null;
    }


 
    public void agendarAgendamento(Agendamento agendamento) {
        String query = "INSERT INTO agendamento (horario, cliente, profissional) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setString(1, agendamento.getHorario());
            stmt.setString(2, agendamento.getCliente());
            stmt.setString(3, agendamento.getProfissional());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao agendar o agendamento no banco de dados", e);
        }
    }

   
    public void removerAgendamento(Agendamento agendamento) {
        String query = "DELETE FROM agendamento WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, agendamento.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao remover agendamento do banco de dados", e);
        }
    }
}
