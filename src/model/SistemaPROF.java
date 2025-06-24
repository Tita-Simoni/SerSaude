package model;

import javax.swing.*;
import java.util.*;

public class SistemaPROF {

    public static void listarConsultasEmAberto(List<Consulta> consultas){
        System.out.println("===== Consultas em Aberto: =====");

        for (Consulta consulta : consultas) {
            if (!consulta.isAtendimentoRealizado()) {
                System.out.println("ID: " + consulta.getId() +
                        "| Paciente: " + consulta.getPaciente().getNome() +
                        "| Data: " + consulta.getData_hora() +
                        "| Profissional: " + consulta.getProfissional().getNome());
            }
        }
    }

    public static void realizarAtendimento(List<Consulta> consultas, Scanner sc){
        System.out.println("===== Realizar Atendimentoo: =====");
        System.out.println("Digite o ID da consulta: ");
        String idBusca = sc.nextLine();

        Consulta consultaSelecionada = null;

        while (consultaSelecionada == null) {
            for (Consulta consulta : consultas) {
                if (consulta.getId().equalsIgnoreCase(idBusca) && !consulta.isAtendimentoRealizado()) {
                    consultaSelecionada = consulta;
                    break;
                }
            }

            if (consultaSelecionada == null) {
                System.out.println("Consulta não encontrada ou já realizada. \n");
                listarConsultasEmAberto(consultas);
                return;
            }
        }

        Profissional profissional = consultaSelecionada.getProfissional();

        System.out.println("Iniciando atendimento para o paciente: " + consultaSelecionada.getPaciente().getNome());

        int opc_medico = 0;
        if (profissional.isPode_prescrever()) {
            do {
                System.out.println("===== Selecionar =====");
                System.out.println(" 1 - Inserir Anamnsese Clínica");
                System.out.println(" 2 - Gerar Prescrição");
                System.out.println(" 3 - Inserir Anotação");
                System.out.println(" 4 - Sair");
                opc_medico = sc.nextInt();
                sc.nextLine();

                switch (opc_medico){
                    case 1:
                        profissional.realizarAnamneseClinica(consultaSelecionada, sc);
                        break;
                    case 2:
                        profissional.gerarPrescricao(consultaSelecionada, sc);
                        break;
                    case 3:
                        System.out.println("Descrever anotações: ");
                        String anotacoes = sc.nextLine();
                        consultaSelecionada.setAnotacoes(anotacoes);
                        System.out.println("Anotação registrada com sucesso. \n");
                }
            } while (opc_medico != 4);

        }

        int opc_nutri = 0;
        if (profissional.isPlano_alimentar()) {
            do {
                System.out.println("===== Selecionar =====");
                System.out.println(" 1 - Inserir Anamnsese Nutricional");
                System.out.println(" 2 - Gerar Plano Alimentar");
                System.out.println(" 3 - Inserir Anotação");
                System.out.println(" 4 - Sair");
                opc_nutri = sc.nextInt();
                sc.nextLine();

                switch (opc_nutri){
                    case 1:
                        profissional.realizarAnamneseNutricional(consultaSelecionada, sc);
                        break;
                    case 2:
                        profissional.gerarPlanoAlimentar(consultaSelecionada, sc);
                        break;
                    case 3:
                        System.out.println("Descrever anotações: ");
                        String anotacoes = sc.nextLine();
                        consultaSelecionada.setAnotacoes(anotacoes);
                        System.out.println("Anotação registrada com sucesso. \n");
                }
            } while (opc_nutri != 4);
        }

        consultaSelecionada.setAtendimentoRealizado(true);
        System.out.println("=======================================");
        System.out.println("Atendimento finalizado com sucesso!");
        System.out.println("=======================================");
        System.out.println();
    }

    public static void visualizarConsulta(List<Consulta> consultas, Scanner sc) {
        System.out.println("===== Visualizar Consulta =====");
        System.out.println("Digite o ID da consulta: ");
        String id = sc.nextLine();

        boolean encontrada = false;
        for (Consulta c : consultas) {
            if(c.getId().equalsIgnoreCase(id)) {
                c.exibirConsulta();
                encontrada = true;
                break;
            }
        }

        if (!encontrada) {
            System.out.println("Consulta não encontrada");
            System.out.println("Consultas disponíveis:");
            for (Consulta consulta : consultas) {
                System.out.println("ID: " + consulta.getId() +
                "| Paciente: " + consulta.getPaciente().getNome() +
                "| Data: " + consulta.getData_hora() +
                "| Profissional: " + consulta.getProfissional().getNome());
            }
            System.out.println("Voltando ao menu...\n");
        }

    }


}
