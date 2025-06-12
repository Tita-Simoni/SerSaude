package model;

import java.time.LocalDate;

public class Administrativo extends Pessoa {
    private String funcao;

    public Administrativo (
            String id,
            LocalDate dt_cadastro,
            String nome,
            String cpf,
            String email,
            String celular,
            boolean ativo,
            String funcao
    ){
        super(id, dt_cadastro, nome, cpf, email, celular, ativo);
        this.funcao = funcao;
    }

    // Get e Set
    public String getFuncao() { return funcao; }
    public void setFuncao(String funcao) { this.funcao = funcao; }

}
