package model;

public class PlanoAlimentar {
    private final String id;
    private String descricao;
    private String orientacoes;

    public PlanoAlimentar(String id, String descricao, String orientacoes){
        this.id = id;
        this.descricao = descricao;
        this.orientacoes = orientacoes;
    }

    // Get e Set
    public String getId() { return id; }
    public String getDescricao() { return descricao; }
    public String getOrientacoes() { return orientacoes; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setOrientacoes(String orientacoes) { this.orientacoes = orientacoes; }

    public String toString(){
        return "===== Plano Alimentar =====" +
                "\n | Descrição do Plano: " + descricao +
                "\n | Orientações: "+ orientacoes;
    }

}
