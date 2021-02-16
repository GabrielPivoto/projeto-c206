package br.inatel.projetofinal2.model;


public class Historico {

    private String id;
    private String massa;
    private String altura;
    private String tipoSanguineo;
    private boolean fumante;
    private boolean alcool;
    private String pacienteCpf;

    public Historico(String id, String massa, String altura, String tipoSanguineo,
            boolean fumante, boolean alcool, String pacienteCpf){
        
        this.id = id;
        this.massa = massa;
        this.altura = altura;
        this.tipoSanguineo = tipoSanguineo;
        this.fumante = fumante;
        this.alcool = alcool;
        this.pacienteCpf = pacienteCpf;
        
    }
    
    public String getId() {
        return id;
    }

    public String getMassa() {
        return massa;
    }

    public String getAltura() {
        return altura;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public boolean isFumante() {
        return fumante;
    }

    public boolean isAlcool() {
        return alcool;
    }

    public String getPacienteCpf() {
        return pacienteCpf;
    }
    
    
    
    
}
