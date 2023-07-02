package agendamento.model;

public class Agendamento {
    private int id;
    private String horario;
    private String cliente;
    private String profissional;

    public Agendamento() {
    }

    public Agendamento(String horario, String cliente, String profissional) {
        this.horario = horario;
        this.cliente = cliente;
        this.profissional = profissional;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getProfissional() {
        return profissional;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }
}
