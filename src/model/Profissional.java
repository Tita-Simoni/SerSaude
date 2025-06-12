package model;

import interfaces.PlanejaAlimentar;
import interfaces.Prescreve;

import java.time.LocalDate;
import java.util.List;

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

    public void gerarPrescricao(){
        if (!pode_prescrever) {
            System.out.println("Este profissional não tem permissão para prescrever medicamentos.");
            return;
        } else {
            System.out.println("Gerar prescrição");
            //ver código...
        }
    }

    public void realizarAnamneseClinica(){
        if (!pode_prescrever) {
            System.out.println("Este profissional não tem permissão para realizar anamnese clínica.");
            return;
        } else {
            System.out.println("Gerar prescrição");
            //ver código...
        }
    }

    public void gerarPlanoAlimentar() {
        if (!plano_alimentar) {
            System.out.println("Este profissional não tem permissão para fazer plano alimentar.");
            return;
        } else {
            System.out.println("Gerar plano alimentar");
            //ver código...
        }
    }

    public void reaclizarAnamneseNutricional() {
        if (!plano_alimentar) {
            System.out.println("Este profissional não tem permissão para realizar anamnese nutricional.");
            return;
        } else {
            System.out.println("Gerar plano alimentar");
            //ver código...
        }
    }

}
