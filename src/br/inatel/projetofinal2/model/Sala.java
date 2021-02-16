package br.inatel.projetofinal2.model;


public class Sala {

    private String numero;
    private int piso;
    private String tamanho;
    private String especialidade;
    private String crmMedico;

    
    public Sala(String numero, int piso, String tamanho, String especialidade, String crmMedico){
        
        this.numero = numero;
        this.piso = piso;
        this.tamanho = tamanho;
        this.especialidade = especialidade;
        this.crmMedico = crmMedico;
        
    }
    
    public String getCrmMedico() {
        return crmMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    private String medicoCrm;

    public String getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getMedicoCrm() {
        return medicoCrm;
    }
    
    
}
