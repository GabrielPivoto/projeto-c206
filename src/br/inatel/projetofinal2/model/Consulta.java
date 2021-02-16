package br.inatel.projetofinal2.model;


public class Consulta {

    private String crmMedico;
    private String cpfPaciente;
    private String data;
    private String horario;
    
    public Consulta(String crmMedico, String cpfPaciente, String data, String horario){
        
        this.crmMedico = crmMedico;
        this.cpfPaciente = cpfPaciente;
        this.data = data;
        this.horario = horario;
        
    }

    public String getCrmMedico() {
        return crmMedico;
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }
}
