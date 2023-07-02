package agendamento.service;

import agendamento.dao.AgendamentoDAO;
import agendamento.model.Agendamento;

public class AgendamentoService {
    private AgendamentoDAO agendamentoDAO;

    public AgendamentoService() {
        this.agendamentoDAO = new AgendamentoDAO();
    }

   
    public boolean verificarDisponibilidade(String horario) {
        Agendamento agendamento = agendamentoDAO.buscarAgendamento(horario);
        return agendamento == null;
    }

   
    public void agendar(String horario, String cliente, String profissional) {
        boolean disponivel = verificarDisponibilidade(horario);
        if (disponivel) {
            Agendamento agendamento = new Agendamento(horario, cliente, profissional);
            agendamentoDAO.agendarAgendamento(agendamento);
            System.out.println("Agendamento realizado com sucesso!");
        } else {
            throw new RuntimeException("Não há disponibilidade para o horário especificado.");
        }
    }

    
    public void cancelar(Agendamento agendamento) {
        agendamentoDAO.removerAgendamento(agendamento);
        System.out.println("Agendamento cancelado com sucesso!");
    }
}

