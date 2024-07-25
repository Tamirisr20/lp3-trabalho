/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import conexao.Conexao;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author solar
 */
public class funcionarioDao {
    
    private Conexao conn;
    private Connection con;
    
     public boolean loginFunc(String login, String senha) throws SQLException{
        String sql = "SELECT * FROM funcionario WHERE id = ? AND senha = ?";
        
        try (PreparedStatement stmt = this.con.prepareStatement(sql)){
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    String senhaBd = rs.getString("senha");
                    
                    if (senhaBd.equals(senha)){
                        return true;
                    }
                    
                }
            }
            
        }
        catch (SQLException e) {
            
            System.err.println("Erro ao tentar logar: " + e.getMessage());
            e.printStackTrace();
            return false;         
        }
        return false;
    }
     
     public void fazerEmprestimo(int idLivro, int idUsuario) throws SQLException{
         
         String sql = "insert into idLivro, idUsuario from emprestimo values (?,?)";
         String sql1 = "select titulo, autor, editora from livro where idLivro = ?";
         String sql2 = "select nome, matricula from usuario where idUsuario = ?";
         
         try (PreparedStatement stmt = this.con.prepareStatement(sql)){      
            stmt.setInt(1, idLivro);
            stmt.setInt(2, idUsuario);
            
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    
                    try(PreparedStatement stmt1 = this.con.prepareStatement(sql1)){
                        stmt.setInt(1, idLivro);
                        
                        try(ResultSet rs1 = stmt.executeQuery()){
                            if(rs1.next()){
                                String titulo = rs1.getString("titulo");
                                String autor = rs1.getString("autor");
                                String editora = rs1.getString("editora");
                                
                                System.out.println("Livro emprestado: " + titulo + " - " + autor + " - " + editora);
                                 } else {
                                    System.out.println("Livro não encontrado.");
                            }
                        }
                    }
                    
                    try (PreparedStatement stmt2 = con.prepareStatement(sql2)) {
                        stmt2.setInt(1, idUsuario);
                
                            try (ResultSet rs2 = stmt2.executeQuery()) {
                                if (rs2.next()) {
                                    String nome = rs2.getString("nome");
                                    String matricula = rs2.getString("matricula");
                        
                                    System.out.println("Empréstimo feito para: " + nome + " - " + matricula);
                                } else {
                                     System.out.println("Usuário não encontrado.");
                                }
                    }
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao fazer empréstimo: " + e.getMessage());
        }
                
            }
     }
     
     public boolean mudancaDadosFunc(String nome, String senha, String id){
        
        StringBuilder sql = new StringBuilder("UPDATE usuario SET ");
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        


    if (senha != null && !senha.isEmpty()) {
        fields.add("senha = ?");
        values.add(senha);
    }
  
    if (nome != null && !nome.isEmpty()) {
        fields.add("nome = ?");
        values.add(nome);
    }

    if (fields.isEmpty()) {
        return false; 
    }
    
    sql.append(String.join(", ", fields));
    sql.append(" WHERE id = ?");
    values.add(id);
    
    try (PreparedStatement stmt = this.con.prepareStatement(new String(sql))) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao fazer doação: " + e.getMessage());
        }
    return false;
    }   
}
