package br.inatel.projetofinal2.modelDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.inatel.projetofinal2.model.Paciente;

public class PacienteDAO extends EntidadeDAO{

    public void inserirPaciente(Paciente novoPaciente){
        
        cntDB();
        String sql = "INSERT INTO Paciente(cpf,nome,idade,endereco,telefone,email)"
                + " VALUES(?,?,?,?,?,?)";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoPaciente.getCpf());
            ps.setString(2,novoPaciente.getNome());
            ps.setInt(3,novoPaciente.getIdade());
            ps.setString(4,novoPaciente.getEndereco());
            ps.setString(5,novoPaciente.getTelefone());
            ps.setString(6,novoPaciente.getEmail());
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
    
    
    public void alterarNomePaciente(String cpf, String novoNome){
        
        cntDB();
        
        String sql = "UPDATE Paciente SET nome = ? WHERE cpf = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoNome);
            ps.setString(2,cpf);
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
    
    public void alterarIdadePaciente(String cpf, int novaIdade){
        
        cntDB();
        
        String sql = "UPDATE Paciente SET idade = ? WHERE cpf = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setInt(1,novaIdade);
            ps.setString(2,cpf);
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
    public void alterarEnderecoPaciente(String cpf, String novoEndereco){
        
        cntDB();
        
        String sql = "UPDATE Paciente SET endereco = ? WHERE cpf = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoEndereco);
            ps.setString(2,cpf);
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
    
    public void alterarEmailPaciente(String cpf, String novoEmail){
        
        cntDB();
        
        String sql = "UPDATE Paciente SET email = ? WHERE cpf = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoEmail);
            ps.setString(2,cpf);
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
    
    public void alterarTelefonePaciente(String cpf, String novoTelefone){
        
        cntDB();
        
        String sql = "UPDATE Medico SET telefone = ? WHERE cpf = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoTelefone);
            ps.setString(2,cpf);
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
    
    public void excluirPaciente(String cpf){
        
        cntDB();
        
        String sql = "DELETE FROM Paciente WHERE cpf = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,cpf);
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
    
    public boolean verificaPaciente(String cpf){
        
        boolean found = false;
        
        cntDB();
        
        String sql = "SELECT 1 FROM Paciente WHERE cpf = ?";
        int aux;
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            
            
            while(rs.next()){
                
                aux = rs.getRow();
                if(aux != 0)
                    found = true;
                
                else found = false;
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                ps.close();
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        
        
        return found;
        
    }
    
    public String retornaNomePaciente(String cpf){
        
        cntDB();
        
        String sql = "SELECT nome FROM Paciente WHERE cpf = ?";
        String aux = "";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            while(rs.next()){
                
                aux = rs.getString("nome");
                
                
            }
            
        }catch(SQLException ex){
            
            System.out.println("Erro: " + ex.getMessage());
            
        }finally{
            
            try{
                
                cnt.close();
                ps.close();
                
            }catch(SQLException ex){
                
                System.out.println("Erro: " + ex.getMessage());
                
            }
            
        }
        
        
        return aux;
    }
    
    public ArrayList<Paciente> buscaPacientes(){
        
        ArrayList<Paciente> listaPacientes = new ArrayList<>();
        
        cntDB();
        
        String sql = "SELECT * FROM Paciente";
        
        try{
            
            s = cnt.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                
                Paciente temp = new Paciente(rs.getString("cpf"),rs.getString("nome")
                , rs.getInt("idade"), rs.getString("endereco"),rs.getString("telefone"),
                rs.getString("email"));
                
                listaPacientes.add(temp);
                
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
        return listaPacientes;
    }
    
}
