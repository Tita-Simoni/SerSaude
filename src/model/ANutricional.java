package model;

import java.util.List;

public class ANutricional {
    private final String id;
    private double peso;
    private double altura;
    private double imc;
    private String imc_desc;
    private String restricoes;
    private List<String> comorbidades;
    private String observacoes;

    public ANutricional (
            String id,
            double peso,
            double altura,
            double imc,
            String imc_desc,
            String restricoes,
            List<String> comorbidades,
            String observacoes
    ){
        this.id = id;
        this.peso = peso;
        this.altura = altura;
        this.imc = imc;
        this.imc_desc = imc_desc;
        this.restricoes = restricoes;
        this.comorbidades = comorbidades;
        this.observacoes = observacoes;
    }

    // Get e Set
    public String getId() { return id; }
    public double getPeso() { return peso; }
    public double getAltura() { return altura; }
    public double getImc() { return imc; }
    public String getImc_desc() { return imc_desc; }
    public String getRestricoes() { return restricoes; }
    public List<String> getComorbidades() { return comorbidades; }
    public String getObservacoes() { return observacoes; }

    public void setPeso(double peso) { this.peso = peso; }
    public void setAltura(double altura) { this.altura = altura; }
    public void setImc(double imc) { this.imc = imc; }
    public void setRestricoes(String restricoes) { this.restricoes = restricoes; }
    public void setComorbidades(List<String> comorbidades) { this.comorbidades = comorbidades; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }



}
