package model;

import java.time.LocalDate;

public class Consulta {
    private final String id;
    private final Paciente paciente;
    private LocalDate data_hora;

    private Administrativo adm;
    private Profissional profissional;
    private String anotacoes;

    private AClinica anamnese_clinica;
    private Prescricao prescricao;
    private ANutricional anamnese_nutricional;
    private PlanoAlimentar plano_alimentar;

    public Consulta(
            String id,
            Paciente paciente,
            LocalDate data_hora,
            Administrativo adm,
            Profissional profissional,
            String anotacoes,
            AClinica anamnese_clinica,
            Prescricao prescricao,
            ANutricional anamnese_nutricional,
            PlanoAlimentar plano_alimentar
    ){
        this.id = id;
        this.paciente = paciente;
        this.data_hora = data_hora;
        this.adm = adm;
        this.profissional = profissional;
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
    public Administrativo getAdm() { return adm; }
    public Profissional getProfissional() { return profissional; }
    public String getAnotacoes() { return anotacoes; }
    public AClinica getAnamnese_clinica() { return anamnese_clinica; }
    public Prescricao getPrescricao() { return prescricao; }
    public ANutricional getAnamnese_nutricional() { return anamnese_nutricional; }
    public PlanoAlimentar getPlano_alimentar() { return plano_alimentar; }

    public void setData_hora(LocalDate data_hora) { this.data_hora = data_hora; }
    public void setAdm(Administrativo adm) { this.adm = adm; }
    public void setProfissional(Profissional profissional) { this.profissional = profissional; }
    public void setAnotacoes(String anotacoes) { this.anotacoes = anotacoes; }
    public void setAnamnese_clinica(AClinica anamnese_clinica) { this.anamnese_clinica = anamnese_clinica; }
    public void setPrescricao(Prescricao prescricao) { this.prescricao = prescricao; }
    public void setAnamnese_nutricional(ANutricional anamnese_nutricional) { this.anamnese_nutricional = anamnese_nutricional; }
    public void setPlano_alimentar(PlanoAlimentar plano_alimentar) { this.plano_alimentar = plano_alimentar;

    }
}
