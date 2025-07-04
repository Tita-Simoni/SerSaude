package model;

import java.util.*;
import java.time.LocalDate;

public class SistemaADM {

    public static void cadastrarPaciente(List<Paciente> pacientes, Scanner sc) {
        System.out.println("===== Cadastro de Paciente =====");

        String id_paciente = GerarID.gerarIdPaciente(pacientes);
        System.out.println("ID gerado automaticamente: " + id_paciente);

        System.out.print("Nome: ");
        String nome = sc.nextLine();

        System.out.print("CPF: ");
        String cpf = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        System.out.print("Celular: ");
        String celular = sc.nextLine();

        System.out.print("Data de nascimento (aaaa-mm-dd): ");
        String dataNascStr = sc.nextLine();
        LocalDate dataNascimento = LocalDate.parse(dataNascStr);

        System.out.print("Nome do responsável: ");
        String nomeResponsavel = sc.nextLine();

        System.out.print("Endereço: ");
        String endereco = sc.nextLine();

        System.out.print("Plano de saúde: ");
        String planoSaude = sc.nextLine();

        LocalDate dtCadastro = LocalDate.now();
        boolean ativo = true;

        Paciente novoPaciente = new Paciente(
                id_paciente,
                dtCadastro,
                nome,
                cpf,
                email,
                celular,
                ativo,
                dataNascimento,
                nomeResponsavel,
                endereco,
                planoSaude
        );

        pacientes.add(novoPaciente);
        System.out.println("=======================================");
        System.out.println("Paciente cadastrado com sucesso!");
        System.out.println("=======================================");
        System.out.println();

    }

    public static void agendarConsulta(
            List<Consulta> consultas,
            List<Paciente> pacientes,
            List<Profissional> profissionais,
            Scanner sc
    ){
        System.out.println("===== Agendar Consulta =====");

        // Buscar Paciente
        Paciente pacienteSelecionado = null;
        while (pacienteSelecionado == null) {
            System.out.println("Digite o nome completo do paciente:");
            String nomePaciente = sc.nextLine();

            for (Paciente p : pacientes) {
                if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                    pacienteSelecionado = p;
                    break;
                }
            }

            if (pacienteSelecionado == null) {
                System.out.println("Paciente não encontrado.");
                System.out.println("Deseja cadastrar novo paciente? (s/n): ");
                String opc = sc.nextLine();

                if (opc.equalsIgnoreCase("s")) {
                    cadastrarPaciente(pacientes, sc);
                } else {
                    System.out.println("Lista de pacientes cadastrados:");
                    for (Paciente p : pacientes) {
                        System.out.println(p.getId() + "- " + p.getNome() + " | " + p.getDt_nascimento());

                    }
                    boolean subMenuAberto = true;
                    while (subMenuAberto) {
                        System.out.println("\nO que deseja fazer?");
                        System.out.println("1 - Cadastrar novo paciente");
                        System.out.println("2 - Tentar novamente agendar consulta");
                        System.out.println("3 - Voltar ao menu principal");
                        System.out.print("Escolha uma opção: ");
                        opc = sc.nextLine();

                        switch (opc) {
                            case "1":
                                cadastrarPaciente(pacientes, sc);
                                subMenuAberto = false; // volta para o while principal e tenta novamente buscar paciente
                                break;
                            case "2":
                                subMenuAberto = false; // volta pro while principal (tentar buscar paciente de novo)
                                break;
                            case "3":
                                System.out.println("Voltando ao menu principal...");
                                return; // sai do método agendarConsulta
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                }
            }
        }

        // Data da consulta
        System.out.println("Digite a data da consulta (aaaa-mm-dd): ");
        String dataSTR = sc.nextLine();
        LocalDate dataConsulta = LocalDate.parse(dataSTR);

        // Inserir Profissional
        Profissional profissionalSelecionado = null;
        while (profissionalSelecionado == null) {
            System.out.println("Digite o nome completo do profissional de saúde:");
            String nomeProf = sc.nextLine();

            for (Profissional prof : profissionais) {
                if (prof.getNome().equalsIgnoreCase(nomeProf)){
                    profissionalSelecionado = prof;
                    break;
                }
            }

            if (profissionalSelecionado == null) {
                System.out.println("Profissional não encontrado.");
                System.out.println("Lista de profissionais cadastrados na clínica:");
                for (Profissional prof : profissionais){
                    System.out.println("- " + prof.getNome() + ", " + prof.getTipo_profissao());
                }
            }

        }

        // Gerar ID da consulta
        String id_consulta = GerarID.gerarIdConsulta(consultas);
        System.out.println("ID gerado automaticamente: " + id_consulta);

        Consulta nova = new Consulta(id_consulta, pacienteSelecionado, dataConsulta, profissionalSelecionado,
                false, null, null, null, null, null);
        consultas.add(nova);
        System.out.println("=======================================");
        System.out.println("Consulta agendada com sucesso!");
        System.out.println("=======================================");
        System.out.println();
    }

    // Visualizar histórico de paciente
    public static void visualizarHistorico(List<Paciente> pacientes, List<Consulta> consultas, Scanner sc) {
        System.out.println("===== Histórico de Consultas do Paciente =====");

        // Busca paciente
        Paciente pacienteSelecionado = null;
        while (pacienteSelecionado == null) {
            System.out.println("Digite o nome completo do paciente:");
            String nomePaciente = sc.nextLine();

            for (Paciente p : pacientes) {
                if (p.getNome().equalsIgnoreCase(nomePaciente)) {
                    pacienteSelecionado = p;
                    break;
                }
            }

            if (pacienteSelecionado == null) {
                System.out.println("Paciente não encontrado.");
                System.out.println("Lista de pacientes cadastrados:");
                for (Paciente p : pacientes) {
                    System.out.println("- " + p.getNome());
                }
            }
        }

        // Filtra as consultas realizadas para esse paciente
        boolean encontrou = false;
        for (Consulta c : consultas) {
            if (c.getPaciente().equals(pacienteSelecionado) && c.isAtendimentoRealizado()) {
                System.out.println(c);
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma consulta realizada para este paciente.");
        }
    }

}
