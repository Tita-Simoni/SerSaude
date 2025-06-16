package model;

import interfaces.PlanejaAlimentar;
import interfaces.Prescreve;

import java.time.LocalDate;
import java.util.*;

public class Profissional extends Pessoa implements Prescreve, PlanejaAlimentar {
    private final String registro;
    private final String tipo_profissao;
    private final boolean pode_prescrever;
    private final boolean plano_alimentar;
    private List<String> especialidade;
    private boolean atende_online;

    public Profissional (
            String id,
            LocalDate dt_cadastro,
            String nome,
            String cpf,
            String email,
            String celular,
            boolean ativo,
            String registro,
            String tipo_profissao,
            boolean pode_prescrever,
            boolean plano_alimentar,
            List<String> especialidade,
            boolean atende_online
    ){
        super(id, dt_cadastro, nome, cpf, email, celular, ativo);
        this.registro = registro;
        this.tipo_profissao = tipo_profissao;
        this.pode_prescrever = pode_prescrever;
        this.plano_alimentar = plano_alimentar;
        this.especialidade = especialidade;
        this.atende_online = atende_online;
    }

    // Getters
    public String getRegistro() { return registro; }
    public String getTipo_profissao() { return tipo_profissao; }
    public boolean isPode_prescrever() { return pode_prescrever; }
    public boolean isPlano_alimentar() { return plano_alimentar; }
    public List<String> getEspecialidade() { return especialidade; }
    public boolean isAtende_online() { return atende_online; }

    // Setters
    public void setEspecialidade(List<String> especialidade) { this.especialidade = especialidade; }
    public void setAtende_online(boolean atende_online) { this.atende_online = atende_online; }


    // MÉTODOS:

    public void gerarPrescricao(Consulta consulta, Scanner sc){
        if (!pode_prescrever) {
            System.out.println("Este profissional não tem permissão para prescrever medicamentos.");
            return;
        } else {
            System.out.println("===== Gerar prescrição =====");

            // Gerar ID automático da prescrição (simples - com base na ID da consulta)
            String idPrescricao = "PRESC-" + consulta.getId();

            System.out.print("Informe os medicamentos ou tratamentos prescritos: ");
            String prescricao = sc.nextLine();

            System.out.print("Informe as orientações complementares: ");
            String orientacoes = sc.nextLine();

            Prescricao novaPrescricao = new Prescricao(idPrescricao, prescricao, orientacoes);
            consulta.setPrescricao(novaPrescricao); // adiciona à consulta

            System.out.println("Prescrição registrada com sucesso.");
        }
    }

    public void realizarAnamneseClinica(Consulta consulta, Scanner sc){
        if (!pode_prescrever) {
            System.out.println("Este profissional não tem permissão para realizar anamnese clínica.");
            return;
        } else {
            System.out.println("===== Anamnese Clínica =====");

            // Gerar ID automático
            String idAClinica = "AClinica-" + consulta.getId();

            System.out.print("Informe o motivo ou descrição da consulta: ");
            String motivo_consulta = sc.nextLine();

            System.out.print("Descreva o histórico médico informado pelo paciente: ");
            String historico = sc.nextLine();

            System.out.println("Informe os medicamentos utilizados pelo paciente: (se mais de um, separar por ',')");
            String medicamentosStr = sc.nextLine();
            List<String> uso_medicamentos = Arrays.asList(medicamentosStr.split(",\\s*"));

            System.out.println("Informe as alergias informadas pelo paciente: (se mais de um, separar por ',')");
            String alergiasStr = sc.nextLine();
            List<String> alergias = Arrays.asList(alergiasStr.split(",\\s*"));

            System.out.print("Observações: ");
            String observacoes = sc.nextLine();

            AClinica novaAClinica = new AClinica(idAClinica, motivo_consulta, historico, uso_medicamentos, alergias, observacoes);
            consulta.setAnamnese_clinica(novaAClinica); // adiciona à consulta

            System.out.println("Anamnese Clínica registrada com sucesso.");
        }
    }

    public void gerarPlanoAlimentar(Consulta consulta, Scanner sc) {
        if (!plano_alimentar) {
            System.out.println("Este profissional não tem permissão para fazer plano alimentar.");
            return;
        } else {
            System.out.println("===== Gerar prescrição =====");

            // Gerar ID automático
            String idPlano = "PLANO-" + consulta.getId();

            System.out.print("Informe a descrição do Plano Alimentar: ");
            String descricao = sc.nextLine();

            System.out.print("Informe as orientações complementares: ");
            String orientacoes = sc.nextLine();

            PlanoAlimentar novoPlanoAlimentar = new PlanoAlimentar(idPlano, descricao, orientacoes);
            consulta.setPlano_alimentar(novoPlanoAlimentar); // adiciona à consulta

            System.out.println("Plano Alimentar registrado com sucesso.");
        }
    }

    public String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 35) {
            return "Obesidade grau I";
        } else if (imc < 40) {
            return "Obesidade grau II";
        } else {
            return "Obesidade grau III";
        }
    }

    public void realizarAnamneseNutricional(Consulta consulta, Scanner sc) {
        if (!plano_alimentar) {
            System.out.println("Este profissional não tem permissão para realizar anamnese nutricional.");
            return;
        } else {
            System.out.println("===== Anamnese Nutricional =====");

            // Gerar ID automático
            String idANutricional = "ANutri-" + consulta.getId();

            System.out.print("Informe o peso: ");
            double peso = sc.nextDouble();

            System.out.print("Informe a altura: ");
            double altura = sc.nextDouble();

            double imc = peso / (altura * altura);
            String imc_desc = classificarIMC(imc);
            System.out.println("IMC: " + String.format("%.2f", imc));
            System.out.println("Classificação: " + imc_desc);

            System.out.print("Informe restrições alimentares descritas pelo paciente: ");
            String restricoes = sc.nextLine();

            System.out.println("Informe as comorbidades informadas pelo paciente: (se mais de um, separar por ',')");
            String comorbidadesStr = sc.nextLine();
            List<String> comorbidades = Arrays.asList(comorbidadesStr.split(",\\s*"));

            System.out.print("Observações: ");
            String observacoes = sc.nextLine();

            ANutricional novaANutricional = new ANutricional(idANutricional, peso, altura, imc, imc_desc, restricoes, comorbidades, observacoes);
            consulta.setAnamnese_nutricional(novaANutricional); // adiciona à consulta

            System.out.println("Anamnese Nutrioncional registrada com sucesso.");
        }
    }

}
