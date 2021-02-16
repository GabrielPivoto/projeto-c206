package br.inatel.projetofinal2.modelDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EntidadeDAO {

    
    Connection cnt;
    PreparedStatement ps;
    Statement s;
    ResultSet rs;
    
    String database = "Projeto2";
    String url = "jdbc:mysql://localhost:3306/" + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false";
    String user = "root";
    String password = "senhamysql123@";
    
    public void cntDB(){
        
        try{
            
            cnt = DriverManager.getConnection(url, user, password);
            System.out.println("Conexão bem sucedida!");
            
        }catch(SQLException e){
            
            System.out.println("Erro: " + e.getMessage());
            
        }
    }
    
  
}
