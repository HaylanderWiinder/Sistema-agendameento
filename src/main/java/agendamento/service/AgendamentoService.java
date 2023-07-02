package agendamento.service;

import agendamento.dao.AgendamentoDAO;
import agendamento.model.Agendamento;

public class AgendamentoService {
    private AgendamentoDAO agendamentoDAO;

    public AgendamentoService() {
        this.agendamentoDAO = new AgendamentoDAO();
    }

    /**
     * Verifica se há disponibilidade para agendar um horário específico.
     *
     * @param horario Horário a ser verificado.
     * @return true se houver disponibilidade, false caso contrário.
     */
    public boolean verificarDisponibilidade(String horario) {
        Agendamento agendamento = agendamentoDAO.buscarAgendamento(horario);
        return agendamento == null;
    }

    /**
     * Agenda um horário para um cliente com um profissional específico, se houver disponibilidade.
     *
     * @param horario     Horário a ser agendado.
     * @param cliente     Nome do cliente.
     * @param profissional Nome do profissional.
     */
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

    /**
     * Cancela um agendamento existente.
     *
     * @param agendamento O agendamento a ser cancelado.
     */
    public void cancelar(Agendamento agendamento) {
        agendamentoDAO.removerAgendamento(agendamento);
        System.out.println("Agendamento cancelado com sucesso!");
    }
}

