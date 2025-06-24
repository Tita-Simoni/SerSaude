package model;
import java.util.List;

public class AClinica {
    private final String id;
    private String motivo_consulta;
    private String historico;
    private List<String> uso_medicamentos;
    private List<String> alergias;
    private String observacoes;

    public AClinica (
            String id,
            String motivo_consulta,
            String historico,
            List<String> uso_medicamentos,
            List<String> alergias,
            String observacoes
    ){
        this.id = id;
        this.motivo_consulta = motivo_consulta;
        this.historico = historico;
        this.uso_medicamentos = uso_medicamentos;
        this.alergias = alergias;
        this.observacoes = observacoes;
    }

    // Get e Set
    public String getId() { return id; }
    public String getMotivo_consulta() { return motivo_consulta; }
    public String getHistorico() { return historico; }
    public List<String> getUso_medicamentos() { return uso_medicamentos; }
    public List<String> getAlergias() { return alergias; }
    public String getObservacoes() { return observacoes; }

    public void setMotivo_consulta(String motivo_consulta) { this.motivo_consulta = motivo_consulta; }
    public void setHistorico(String historico) { this.historico = historico; }
    public void setUso_medicamentos(List<String> uso_medicamentos) { this.uso_medicamentos = uso_medicamentos; }
    public void setAlergias(List<String> alergias) { this.alergias = alergias; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String toString(){
        return "===== Anamnese Clínica =====" +
                "\n | Motivo da consulta: " + motivo_consulta +
                "\n | Histórico do paciente: " + historico +
                "\n | Medicamentos em uso: " + uso_medicamentos +
                "\n | Alergias relatadas: " + alergias +
                "\n | Observações: " + observacoes;
    }

}
