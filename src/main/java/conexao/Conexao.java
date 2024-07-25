/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author solar
 */
public class Conexao {
    
    public Connection getConexao() throws SQLException{
    
            Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/bd_biblioteca?serverTimezone=UTC",
            "root",
            "2006052781");
        }
        catch (Exception e){
            System.out.println("Erro ao conectar" + e.getMessage());
            
        } finally {
            if (conn != null){
            conn.close();
            }
        }
        return null;
    }
    
}

