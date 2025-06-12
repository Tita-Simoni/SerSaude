package model;
import java.time.LocalDate;

public abstract class Pessoa {
    private final String id;
    private final LocalDate dt_cadastro;
    private final String nome;
    private final String cpf;
    private String email;
    private String celular;
    private boolean ativo;

    public Pessoa (
            String id,
            LocalDate dt_cadastro,
            String nome,
            String cpf,
            String email,
            String celular,
            boolean ativo
    ){
        this.id = id;
        this.dt_cadastro = dt_cadastro;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        this.ativo = ativo;
    }

    // Getters
    public String getId() { return id; }
    public LocalDate getDt_cadastro() { return dt_cadastro; }
    public String getNome() { return nome; }
    public String getCpf(){ return cpf; }
    public String getEmail() { return email; }
    public String getCelular() { return celular; }
    public boolean getAtivo() { return ativo; }

    // Setters
    public void setEmail(String email) { this.email = email; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }



}

