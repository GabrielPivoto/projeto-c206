package br.inatel.projetofinal2.modelDAO;

import br.inatel.projetofinal2.model.Sala;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class SalaDAO extends EntidadeDAO{
    
    public void inserirSala(Sala novaSala){
        
        cntDB();
        String sql = "INSERT INTO Sala VALUES(?,?,?,?,?)";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,novaSala.getNumero());
            ps.setInt(2,novaSala.getPiso());
            ps.setString(3,novaSala.getTamanho());
            ps.setString(4,novaSala.getEspecialidade());
            ps.setString(5,novaSala.getCrmMedico());
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
    
    public boolean verificaNumero(String numero){
        
        boolean found = false;
        
        cntDB();
        
        String sql = "SELECT 1 FROM Sala WHERE numero = ?";
        int aux;
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1, numero);
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
    
    public void excluirSala(String numero){
        
        cntDB();
        
        String sql = "DELETE FROM Sala WHERE numero = ?";
        
        try{
            
            ps = cnt.prepareStatement(sql);
            ps.setString(1,numero);
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
    
    public ArrayList<Sala> buscaSala(){
        
        ArrayList<Sala> listaSalas = new ArrayList<>();
        
        cntDB();
        
        String sql = "SELECT * FROM Sala";
        
        try{
            
            s = cnt.createStatement();
            rs = s.executeQuery(sql);
            while(rs.next()){
                
                Sala temp = new Sala(rs.getString("numero"),rs.getInt("piso")
                , rs.getString("tamanho"), rs.getString("especialidade"),
                rs.getString("Medico_crm"));
                
                listaSalas.add(temp);
                
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
        return listaSalas;
    }

}
