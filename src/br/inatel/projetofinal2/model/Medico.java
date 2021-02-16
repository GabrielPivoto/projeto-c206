package br.inatel.projetofinal2.model;


public class Medico {

    private String crm;
    private String nome;
    private int idade;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    
    public Medico(String crm, String nome, int idade, String endereco, String telefone, 
            String email, String senha){
        this.crm = crm;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
    
    Medico(){
        
    }

    public String getCrm() {
        return crm;
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

    public String getSenha() {
        return senha;
    }
}
