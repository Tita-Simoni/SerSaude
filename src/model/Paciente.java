package model;

import java.time.LocalDate;

public class Paciente extends Pessoa {
    private final LocalDate dt_nascimento;
    private String nome_responsavel;
    private String endereco;
    private String plano_saude;

    public Paciente (
            String id,
            LocalDate dt_cadastro,
            String nome,
            String cpf,
            String email,
            String celular,
            boolean ativo,
            LocalDate dt_nascimento,
            String nome_responsavel,
            String endereco,
            String plano_saude
    ){
        super(id, dt_cadastro, nome, cpf, email, celular, ativo);
        this.dt_nascimento = dt_nascimento;
        this.nome_responsavel = nome_responsavel;
        this.endereco = endereco;
        this.plano_saude = plano_saude;
    }

    // Getters
    public LocalDate getDt_nascimento() { return dt_nascimento; }
    public String getNome_responsavel() { return nome_responsavel; }
    public String getEndereco() { return endereco; }
    public String getPlano_saude() { return plano_saude; }

    // Setters
    public void setNome_responsavel(String nome_responsavel) { this.nome_responsavel = nome_responsavel; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setPlano_saude(String plano_saude) { this.plano_saude = plano_saude; }


}
