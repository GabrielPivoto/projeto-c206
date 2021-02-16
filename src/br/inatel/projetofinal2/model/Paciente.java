package br.inatel.projetofinal2.model;


public class Paciente {

    private String cpf;
    private String nome;
    private int idade;
    private String endereco;
    private String telefone;
    private String email;
    
    
    public Paciente(String cpf, String nome, int idade, String endereco, String telefone, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
}
