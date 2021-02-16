package br.inatel.projetofinal2.modelDAO;

import br.inatel.projetofinal2.model.Historico;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class HistoricoDAO extends EntidadeDAO{
    
    public void inserirHistorico(Historico novoHistorico){
        
        cntDB();
        String sql = "INSERT INTO Historico VALUES(?,?,?,?,?,?,?)";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novoHistorico.getId());
            ps.setString(2,novoHistorico.getMassa());
            ps.setString(3,novoHistorico.getAltura());
            ps.setString(4,novoHistorico.getTipoSanguineo());
            ps.setBoolean(5,novoHistorico.isFumante());
            ps.setBoolean(6,novoHistorico.isAlcool());
            ps.setString(7,novoHistorico.getPacienteCpf());
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
    
    public boolean verificaCpf(String cpf){
        
        boolean found = false;
        
        cntDB();
        
        String sql = "SELECT 1 FROM Historico WHERE Paciente_cpf = ?";
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
    
    public boolean verificaId(String id){
        
        boolean found = false;
        
        cntDB();
        
        String sql = "SELECT 1 FROM Historico WHERE idHistorico = ?";
        int aux;
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, id);
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
    
    public void excluirHistorico(String id){
        
        cntDB();
        
        String sql = "DELETE FROM Historico WHERE idHistorico = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,id);
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
    
    public ArrayList<Historico> buscaHistoricos(){
        
        ArrayList<Historico> listaHistorico = new ArrayList<>();
        
        cntDB();
        
        String sql = "SELECT * FROM Historico";
        
        try{
            
            s = cnt.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                
                Historico temp = new Historico(rs.getString("idHistorico"),rs.getString("massa")
                , rs.getString("altura"), rs.getString("tipoSanguineo"),rs.getBoolean("fumante"),
                rs.getBoolean("alcool"),rs.getString("Paciente_cpf"));
                
                listaHistorico.add(temp);
                
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
        return listaHistorico;
    }
}
