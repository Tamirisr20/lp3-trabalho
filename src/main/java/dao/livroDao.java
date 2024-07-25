/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import codigo.livro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author solar
 */
public class livroDao {
    
    private Conexao conn;
    private Connection con;
    
    public livroDao (){
        this.conn = new Conexao();
        this.con = this.conn.getConexao();
    }
    
    public void cadastrarLivro(){
        String sql = "INSERT INTO livro (titulo, autor, editora, area, id, estadoLivro, dataPublicacao, disponibilidade) values (?, ?, ?, ?, ?, ?, ?, ?)";
        livro l = null;
        
        try(PreparedStatement stmt = this.con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setString(3, l.getEditora());
            stmt.setString(4, l.getArea());
            stmt.setInt(5, l.getId());
            stmt.setString(6, l.getEstadoLivro());
            stmt.setDate(7, l.getDataPublicacao());
            stmt.setInt(8, l.getDisponibilidade());
            stmt.executeUpdate();
            
            }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
                  
    }
    
    public void adicionarObra() throws SQLException{
        String sql = "update livro set disponibilidade = disponibilidade + 1";
        try(PreparedStatement stmt = this.con.prepareStatement(sql)){
            stmt.executeUpdate();
        }
    }
    
    public void removerObra() throws SQLException{
        String sql = "update livro set disponibilidade = disponibilidade - 1";
        try(PreparedStatement stmt = this.con.prepareStatement(sql)){
            stmt.executeUpdate();
        }
        
    }
    
    public boolean mudancaDadosLivro(int id, String titulo, String autor, String editora, String area, String estadoLivro) throws SQLException{
        
        StringBuilder sql = new StringBuilder("UPDATE livro SET ");
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        
        if (titulo != null && !titulo.isEmpty()) {
        fields.add("titulo = ?, ");
        values.add(titulo);
    }
    if (autor != null && !autor.isEmpty()) {
    fields.add("autor = ?, ");
    values.add(autor);
    }

    if (editora != null && !editora.isEmpty()) {
        fields.add("editora = ?, ");
        values.add(editora);
    }
    if (area != null && !area.isEmpty()) {
        fields.add("area = ?, ");
        values.add(area);
    }
    if (estadoLivro != null && !estadoLivro.isEmpty()) {
        fields.add("estadoLivro = ?, ");
        values.add(estadoLivro);
    }
    
    sql.append(" WHERE id = ?");
    values.add(id);
    
    try(PreparedStatement stmt = this.con.prepareStatement(new String(sql))){
            stmt.executeUpdate();
        }
    
    return false;
    }   
}
