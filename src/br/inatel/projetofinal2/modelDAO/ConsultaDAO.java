package br.inatel.projetofinal2.modelDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.inatel.projetofinal2.model.Consulta;

public class ConsultaDAO extends EntidadeDAO{

    public void inserirConsulta(Consulta novaConsulta){
        
        cntDB();
        String sql = "INSERT INTO Consulta(Medico_crm,Paciente_cpf,dataC,horario)"
                + " VALUES(?,?,?,?)";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novaConsulta.getCrmMedico());
            ps.setString(2,novaConsulta.getCpfPaciente());
            ps.setString(3,novaConsulta.getData());
            ps.setString(4,novaConsulta.getHorario());
            ps.execute();
            
        }catch(SQLException e){
            
            System.out.println("Erro: " + e.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                ps.close();
                
            }catch(SQLException e){
                
                System.out.println("Erro: " + e.getMessage());
               
            }
            
        }
    }
    
    public ArrayList<Consulta> buscaConsultas(){
        
        ArrayList<Consulta> listaConsultas = new ArrayList<>();
        
        cntDB();
        
        String sql = "SELECT * FROM Consulta";
        
        try{
            
            s = cnt.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                
                Consulta temp = new Consulta(rs.getString("Medico_crm"),rs.getString("Paciente_cpf")
                , rs.getString("dataC"), rs.getString("horario"));
                
                listaConsultas.add(temp);
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                s.close();
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        return listaConsultas;
    }
    
    
    public void excluirConsulta(String cpf, String crm){
        
        cntDB();
        
        String sql = "DELETE FROM Consulta WHERE Paciente_cpf = ? AND Medico_crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,cpf);
            ps.setString(2,crm);
            ps.execute();
            
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                ps.close();
                
            }catch(SQLException e){
                
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                
            }
            
        }
    }
    
}
