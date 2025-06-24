//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import model.*;

import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Administrativo> administrativos = new ArrayList<>();
        List<Paciente> pacientes = new ArrayList<>();
        List<Profissional> profissionais = new ArrayList<>();
        List<Consulta> consultas = new ArrayList<>();

        // Criando 2 administrativos
        administrativos.add(new Administrativo(
                "ADM1",
                LocalDate.parse("2025-06-06"),
                "Cintia Simoni", "000.000.000-00", "cintia.simoni@ulife.com.br", "5199991111", true, "Administradora"));
        administrativos.add(new Administrativo("ADM2",
                LocalDate.parse("2025-06-06"),
                "Pedro Cruz", "111.111.111-11", "pedro.cruz@ulife.com.br", "51989991212", true, "Administrador"));

        // Criando 4 profissionais
        profissionais.add(new Profissional(
                "PROF1",
                LocalDate.parse("2025-06-06"),
                "Jose Carlos", "000.000.000-00", "jose-carlos@med.com", "51912345678", true,
                "CRM 11110", "Médico", true, false, List.of(""), false));
        profissionais.add(new Profissional(
                "PROF2",
                LocalDate.parse("2025-06-06"),
                "Carla Ferreira", "000.000.000-00", "carla-ferreira@med.com", "51991234567", true,
                "CRM 10203", "Médico", true, false, List.of("Endocrinologista"), false));
        profissionais.add(new Profissional(
                "PROF3",
                LocalDate.parse("2025-06-06"),
                "Paula dos Santos Silveira", "000.000.000-00", "paula-silveira@med.com", "5196325478", true,
                "CRN 12345", "Nutricionista", false, true, List.of(""), true));
        profissionais.add(new Profissional(
                "PROF4",
                LocalDate.parse("2025-06-06"),
                "Diego Andre", "000.000.000-00", "diego-andre@med.com", "51996325874", true,
                "CRN 10111", "Nutricionista", false, true, List.of("Cirurgia bariátrica", "Obesidade"), false));

        // Criando 2 pacientes
        pacientes.add(new Paciente("PACI-01",
                LocalDate.parse("2025-06-06"),
                "Isabel Castro", "000.000.000-00", "isabel-castro@gmail.com", "51998745987", true,
                LocalDate.parse("2020-06-06"),
                "", "Porto Alegre", "Unimed"));
        pacientes.add(new Paciente("PACI-02",
                LocalDate.parse("2025-06-10"),
                "Enzo Castro", "000.000.000-00", "", "", true,
                LocalDate.parse("2022-01-16"),
                "Isabel Castro", "Porto Alegre", "Unimed"));


        // MENU:
        int opcao;
        int opcao_adm;
        int opcao_prof;

        do {
            System.out.println("=======================================================");
            System.out.println("          Sistema de Prontuário Médico     ");
            System.out.println("                   SerSaúde         ");
            System.out.println("=======================================================");
            System.out.println(" 1 - Acessar como Administrador");
            System.out.println(" 2 - Acessar como Profissional");
            System.out.println(" 0 - Sair");
            System.out.println(" Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("=======================================================");
                    System.out.println(" 1 - Cadastrar Paciente");
                    System.out.println(" 2 - Agendar Consulta");
                    System.out.println(" 3 - Visualizar histórico de paciente");
                    System.out.println(" 4 - Voltar pro Menu Inicial");
                    System.out.println(" Escolha uma opção: ");
                    opcao_adm = sc.nextInt();
                    sc.nextLine();

                    switch (opcao_adm) {
                        case 1:
                            SistemaADM.cadastrarPaciente(pacientes, sc);
                            break;
                        case 2:
                            SistemaADM.agendarConsulta(consultas, pacientes, profissionais, sc);
                            break;
                        case 3:
                            SistemaADM.visualizarHistorico(pacientes, consultas, sc);
                        case 4:
                            System.out.println("Voltando ao Menu Inicial...");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("=======================================================");
                    System.out.println(" 1 - Verificar consultas em aberto");
                    System.out.println(" 2 - Realizar atendimento");
                    System.out.println(" 3 - Visualizar histórico de paciente");
                    System.out.println(" 4 - Visualizar consulta");
                    System.out.println(" 5 - Voltar pro Menu Inicial");
                    System.out.println(" Escolha uma opção: ");
                    opcao_prof = sc.nextInt();
                    sc.nextLine();

                    switch (opcao_prof) {
                        case 1:
                            SistemaPROF.listarConsultasEmAberto(consultas);
                            break;
                        case 2:
                            SistemaPROF.realizarAtendimento(consultas, sc);
                            break;
                        case 3:
                            SistemaADM.visualizarHistorico(pacientes, consultas, sc);
                        case 4:
                            SistemaPROF.visualizarConsulta(consultas, sc);
                        case 5:
                            System.out.println("Voltando ao Menu Inicial...");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida");
                    break;
            }

        } while (opcao != 0);


    }
}