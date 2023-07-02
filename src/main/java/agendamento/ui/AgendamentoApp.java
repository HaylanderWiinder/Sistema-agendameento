package agendamento.ui;

import agendamento.model.Agendamento;
import agendamento.service.AgendamentoService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AgendamentoApp {
    private AgendamentoService agendamentoService;
    private Scanner scanner;
    private List<String> horariosDisponiveis;

    public AgendamentoApp() {
        this.agendamentoService = new AgendamentoService();
        this.scanner = new Scanner(System.in);
        this.horariosDisponiveis = Arrays.asList("10:00", "14:00", "16:00");
    }

    /**
     * Exibe o menu principal e aguarda as entradas do usuário.
     */
    public void exibirMenu() {
        boolean sair = false;

        while (!sair) {
            System.out.println("======= Menu =======");
            System.out.println("1. Realizar agendamento");
            System.out.println("2. Cancelar agendamento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    realizarAgendamento();
                    break;
                case 2:
                    realizarCancelamento();
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }

        System.out.println("Encerrando o programa. Até mais!");
    }

    /**
     * Solicita os detalhes do agendamento (horário, cliente, profissional) e tenta agendar o horário especificado.
     */
    public void realizarAgendamento() {
        System.out.print("Digite o horário do agendamento: ");
        String horario = scanner.nextLine();

        // Verifica se o horário está disponível
        if (agendamentoService.verificarDisponibilidade(horario)) {
            System.out.print("Digite o nome do cliente: ");
            String cliente = scanner.nextLine();

            System.out.print("Digite o nome do profissional: ");
            String profissional = scanner.nextLine();

            try {
                agendamentoService.agendar(horario, cliente, profissional);
                System.out.println("Agendamento realizado com sucesso!");
            } catch (RuntimeException e) {
                System.out.println("Não foi possível agendar o horário: " + e.getMessage());
            }
        } else {
            System.out.println("Horário indisponível. Por favor, escolha outro horário.");
        }
    }


    /**
     * Solicita o ID do agendamento a ser cancelado e executa o cancelamento.
     */
    public void realizarCancelamento() {
        System.out.print("Digite o ID do agendamento a ser cancelado: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner

        Agendamento agendamento = new Agendamento();
        agendamento.setId(id);

        agendamentoService.cancelar(agendamento);
    }

    /**
     * Exibe uma mensagem na tela para o usuário.
     *
     * @param mensagem A mensagem a ser exibida.
     */
    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

