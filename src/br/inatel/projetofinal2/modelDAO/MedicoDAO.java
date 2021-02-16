package br.inatel.projetofinal2.modelDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.inatel.projetofinal2.model.Medico;

public class MedicoDAO extends EntidadeDAO{

    
    public void inserirMedico(Medico novoMedico){
        
        cntDB();
        String sql = "INSERT INTO Medico(crm,nome,idade,endereco,telefone,email,senha)"
                + " VALUES(?,?,?,?,?,?,?)";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoMedico.getCrm());
            ps.setString(2,novoMedico.getNome());
            ps.setInt(3,novoMedico.getIdade());
            ps.setString(4,novoMedico.getEndereco());
            ps.setString(5,novoMedico.getTelefone());
            ps.setString(6,novoMedico.getEmail());
            ps.setString(7,novoMedico.getSenha());
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
    
    public void alterarNomeMedico(String crm, String novoNome){
        
        cntDB();
        
        String sql = "UPDATE Medico SET nome = ? WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoNome);
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
    
    public void alterarIdadeMedico(String crm, int novaIdade){
        
        cntDB();
        
        String sql = "UPDATE Medico SET idade = ? WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setInt(1,novaIdade);
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
    public void alterarEnderecoMedico(String crm, String novoEndereco){
        
        cntDB();
        
        String sql = "UPDATE Medico SET endereco = ? WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoEndereco);
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
    
    public void alterarEmailMedico(String crm, String novoEmail){
        
        cntDB();
        
        String sql = "UPDATE Medico SET email = ? WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoEmail);
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
    
    public void alterarSenhaMedico(String crm, String novaSenha){
        
        cntDB();
        
        String sql = "UPDATE Medico SET senha = ? WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novaSenha);
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
    
    public void alterarTelefoneMedico(String crm, String novoTelefone){
        
        cntDB();
        
        String sql = "UPDATE Medico SET telefone = ? WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoTelefone);
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
    
    public void excluirMedico(String crm){
        
        cntDB();
        
        String sql = "DELETE FROM Medico WHERE crm = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,crm);
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
    
    public ArrayList<Medico> buscaMedicos(){
        
        ArrayList<Medico> listaMedicos = new ArrayList<>();
        
        cntDB();
        
        String sql = "SELECT * FROM Medico";
        
        try{
            
            s = cnt.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                
                Medico temp = new Medico(rs.getString("crm"),rs.getString("nome")
                , rs.getInt("idade"), rs.getString("endereco"), rs.getString("telefone"),
                rs.getString("email"),rs.getString("senha"));
                
                listaMedicos.add(temp);
                
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
        return listaMedicos;
    }
    
    public boolean buscarLoginMedico(String crm, String senha){
        
        boolean found = false;
        
        cntDB();
        
        String sql = "SELECT senha FROM Medico WHERE crm = ?";
        String aux;
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, crm);
            rs = ps.executeQuery();
            while(rs.next()){
                
                aux = rs.getString("senha");
                if(aux.isEmpty())
                    found = false;
                else if(!aux.equals(senha))
                    found = false;
                else found = true;
                
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
    
    
    public boolean verificaMedico(String crm){
        
        boolean found = false;
        
        cntDB();
        
        String sql = "SELECT 1 FROM Medico WHERE crm = ?";
        int aux;
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, crm);
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
    
    public String retornaNomeMedico(String crm){
        
        cntDB();
        
        String sql = "SELECT nome FROM Medico WHERE crm = ?";
        String aux = "";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, crm);
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
    
}

