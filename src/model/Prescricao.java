package model;

public class Prescricao {
    private final String id;
    private String prescricao;
    private String orientacoes;

    public Prescricao (String id, String prescricao, String orientacoes){
        this.id = id;
        this.prescricao = prescricao;
        this.orientacoes = orientacoes;
    }

    // Get e Set
    public String getId() { return id; }
    public String getPrescricao() { return prescricao; }
    public String getOrientacoes() { return orientacoes; }

    public void setPrescricao(String prescricao) { this.prescricao = prescricao; }
    public void setOrientacoes(String orientacoes) { this.orientacoes = orientacoes; }
}
