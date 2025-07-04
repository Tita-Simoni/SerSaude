package model;

import java.time.LocalDate;

public class Consulta {
    private final String id;
    private final Paciente paciente;
    private LocalDate data_hora;

    private Profissional profissional;
    private boolean atendimentoRealizado;

    private String anotacoes;
    private AClinica anamnese_clinica;
    private Prescricao prescricao;
    private ANutricional anamnese_nutricional;
    private PlanoAlimentar plano_alimentar;

    public Consulta(
            String id,
            Paciente paciente,
            LocalDate data_hora,
            Profissional profissional,
            boolean atendimentoRealizado,
            String anotacoes,
            AClinica anamnese_clinica,
            Prescricao prescricao,
            ANutricional anamnese_nutricional,
            PlanoAlimentar plano_alimentar
    ){
        this.id = id;
        this.paciente = paciente;
        this.data_hora = data_hora;
        this.profissional = profissional;
        this.atendimentoRealizado = atendimentoRealizado;
        this.anotacoes = anotacoes;
        this.anamnese_clinica = anamnese_clinica;
        this.prescricao = prescricao;
        this.anamnese_nutricional = anamnese_nutricional;
        this.plano_alimentar = plano_alimentar;
    }

    // Getters
    public String getId() { return id; }
    public Paciente getPaciente() { return paciente; }
    public LocalDate getData_hora() { return data_hora; }
    public Profissional getProfissional() { return profissional; }
    public boolean isAtendimentoRealizado() { return atendimentoRealizado; }
    public String getAnotacoes() { return anotacoes; }
    public AClinica getAnamnese_clinica() { return anamnese_clinica; }
    public Prescricao getPrescricao() { return prescricao; }
    public ANutricional getAnamnese_nutricional() { return anamnese_nutricional; }
    public PlanoAlimentar getPlano_alimentar() { return plano_alimentar; }

    public void setData_hora(LocalDate data_hora) { this.data_hora = data_hora; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }
    public void setAtendimentoRealizado(boolean atendimentoRealizado) { this.atendimentoRealizado = atendimentoRealizado; }
    public void setAnotacoes(String anotacoes) { this.anotacoes = anotacoes; }
    public void setAnamnese_clinica(AClinica anamnese_clinica) { this.anamnese_clinica = anamnese_clinica; }
    public void setPrescricao(Prescricao prescricao) { this.prescricao = prescricao; }
    public void setAnamnese_nutricional(ANutricional anamnese_nutricional) { this.anamnese_nutricional = anamnese_nutricional; }
    public void setPlano_alimentar(PlanoAlimentar plano_alimentar) { this.plano_alimentar = plano_alimentar; }

    public String toString() {
        return "Consulta ID: " + id +
                "\nPaciente: " + paciente.getNome() +
                "\nData: " + data_hora +
                "\nProfissional: " + profissional.getNome() +
                "\nClasse profissional: " + profissional.getTipo_profissao() +
                "\nAnamnese clínica: " + (anamnese_clinica != null ? "Sim" : "Não") +
                "\nPrescrição: " + (prescricao != null ? "Sim" : "Não") +
                "\nAnamnese nutricional: " + (anamnese_nutricional != null ? "Sim" : "Não") +
                "\nPlano alimentar: " + (plano_alimentar != null ? "Sim" : "Não");
    }

    public void exibirConsulta() {
        System.out.println("===== Registro de Consulta =====");
        System.out.println("ID: " + id);
        System.out.println("Paciente: " + paciente.getNome());
        System.out.println("Data: " + data_hora);
        System.out.println("Profissional: " + profissional.getNome());
        System.out.println("Tipo profissional: " + profissional.getTipo_profissao());
        System.out.println("----------------------------------");

        if (anamnese_clinica != null) {
            System.out.println(anamnese_clinica);
            System.out.println();
        }

        if (prescricao != null) {
            System.out.println(prescricao);
            System.out.println();
        }

        if (anamnese_nutricional != null) {
            System.out.println(anamnese_nutricional);
            System.out.println();
        }

        if (plano_alimentar != null) {
            System.out.println(plano_alimentar);
            System.out.println();
        }

        if (anotacoes != null) {
            System.out.println("Anotações: " + anotacoes);
        }
    }


}
