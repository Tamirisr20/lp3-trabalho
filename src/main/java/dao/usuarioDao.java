/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import codigo.livro;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import codigo.usuario;
import java.sql.Date;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author solar
 */
public class usuarioDao {
    
    private Conexao conexao;
    private Connection conn;
    String matriculaLogada = null;
    int idLivro = 0;
    
    public usuarioDao () throws SQLException{
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }
    
    public boolean cadastrarAluno(usuario user){
    String sql = "INSERT INTO usuario (matricula, nome, email, senha, curso, dataNascimento, telefone) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    PreparedStatement stmt = null;
    
    try{
        stmt = this.conn.prepareStatement(sql);
        
        stmt.setString(1, user.getMatricula());
        stmt.setString(2, user.getNome());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, user.getSenha());
        stmt.setString(5, user.getCurso());
        stmt.setString(6, user.getDataNasc());
        stmt.setString(7, user.getTelefone());
        
        int rowsInserted = stmt.executeUpdate();
        
        if (rowsInserted > 0) {
            System.out.println("Usuário cadastrado com sucesso!");
            return true;
        }
    } catch (SQLException e) {
        System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
    } finally {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar statement: " + e.getMessage());
        }
    }
    
    return false;
}
  
    
    public void cadastrarProf(){
        String sql = "INSERT INTO usuario (matricula, nome, email, senha, departamento, cargo) values (?, ?, ?, ?, ?, ?, ?)";
        usuario user = new usuario();
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){      
            stmt.setString(1, user.getMatricula());
            stmt.setString(2, user.getNome());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getSenha());
            stmt.setString(5, user.getDepartamento());
            stmt.setString(5, user.getCargo()); 
            
            stmt.executeUpdate();
           System.out.println("Professor cadastrado com sucesso!");
    }
    catch(SQLException e){
        System.out.println("Erro ao cadastrar professor: " + e.getMessage());
    }
                  
    }
    
    public boolean login(String login, String senha) throws SQLException{
        String sql = "SELECT * FROM usuario WHERE matricula = ? AND senha = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            try (ResultSet rs = stmt.executeQuery()){
                if (rs.next()){
                    String senhaBd = rs.getString("senha");
                    
                    if (senhaBd.equals(senha)){
                        matriculaLogada = rs.getString("matricula");
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

    
    public boolean esqueciSenha(String login, String senha) throws SQLException{
        String sql = "update usuario set senha = ? where matricula = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)){
            stmt.setString(1, login);
            stmt.setString(2, senha);
            stmt.executeUpdate();
        }
        
        catch (SQLException e){
            System.out.println("Erro na alteração da senha " + e.getMessage());
        }
        
        return false;
    }
    
    public boolean mudancaDadosAluno(String email, String senha, String telefone, String curso, String nome){
        
        StringBuilder sql = new StringBuilder("UPDATE usuario SET ");
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        
        if (email != null && !email.isEmpty()) {
        fields.add("email = ?");
        values.add(email);
    }
    if (telefone != null && !telefone.isEmpty()) {
    fields.add("telefone = ?");
    values.add(telefone);
    }

    if (senha != null && !senha.isEmpty()) {
        fields.add("senha = ?");
        values.add(senha);
    }
    if (curso != null && !curso.isEmpty()) {
        fields.add("curso = ?");
        values.add(curso);
    }
    if (nome != null && !nome.isEmpty()) {
        fields.add("nome = ?");
        values.add(nome);
    }

    if (fields.isEmpty()) {
        return false; 
    }
    
    sql.append(String.join(", ", fields));
    sql.append(" WHERE matricula = ?");
    values.add(matriculaLogada);
    
    try (PreparedStatement stmt = this.conn.prepareStatement(new String(sql))) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao fazer doação: " + e.getMessage());
        }
    return false;
    }   
    
    public boolean mudancaDadosProf(String email, String senha, String telefone, String departamento, String cargo, String nome){
        
        StringBuilder sql = new StringBuilder("UPDATE usuario SET ");
        List<String> fields = new ArrayList<>();
        List<Object> values = new ArrayList<>();
        
        if (email != null && !email.isEmpty()) {
        fields.add("email = ?");
        values.add(email);
    }
    if (telefone != null && !telefone.isEmpty()) {
    fields.add("telefone = ?");
    values.add(telefone);
    }

    if (senha != null && !senha.isEmpty()) {
        fields.add("senha = ?");
        values.add(senha);
    }
    if (departamento != null && !departamento.isEmpty()) {
        fields.add("departamento = ?");
        values.add(departamento);
    }
    
    if (cargo != null && !cargo.isEmpty()) {
        fields.add("cargo = ?");
        values.add(cargo);
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
    values.add(matriculaLogada);
    
    try (PreparedStatement stmt = this.conn.prepareStatement(new String(sql))) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao fazer doação: " + e.getMessage());
        }
    return false;
    }
    
    public void fazDoacao() throws SQLException{
        String sql = "insert into doacao (id) values (FLOOR(1 + RAND() * 100))";
        
        livroDao l = new livroDao();
        l.cadastrarLivro();
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao fazer doação: " + e.getMessage());
        }
    }
    
    public List<livro> verificarEmprestimo(){
        String sql = "select * from emprestimo where idUsuario = ?";
        List<livro> livros = new ArrayList<>();
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, matriculaLogada);
            
            try (ResultSet rs = stmt.executeQuery()){
                while (rs.next()){
                    int i = 1;
                    idLivro = rs.getInt("idLivro");
                    Date vencimento = rs.getDate("vencimento");
                    Date dataEmp = rs.getDate("dataEmprestimo");
                    float multa = calcularMulta();
                    String status = verificarStatus();
                    
                    String sql1 = "select * from livro where idLivro = ?";
                
                    try (PreparedStatement stmt1 = this.conn.prepareStatement(sql1)){
                        stmt1.setInt(1, idLivro);
                        
                        try(ResultSet rs1 = stmt1.executeQuery()){
                            if (rs1.next()){
                                String titulo = rs1.getString("titulo");
                                String autor = rs1.getString("autor");
                                String editora = rs1.getString("editora");
                                
                                 livro l = new livro(i, titulo, autor, editora, vencimento, dataEmp, multa, status);
                                livros.add(l);
                                
                               }
                        }
                    i++;    
                }                     
            }
          }
            
        } catch (SQLException e) {
            System.err.println("Erro ao verificar emprestimos: " + e.getMessage());
        }
        
        return livros;
    }

    private String verificarStatus() throws SQLException {
        String status = "indefinido";
        
            String sql = "select vencimento, dataEmprestimo from emprestimo where idUsuario = ? and idLivro = ?";
        
            try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
                stmt.setString(1, matriculaLogada);
                stmt.setInt(2, idLivro);
            
                try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    LocalDate hoje = LocalDate.now();
                    LocalDate vencimento = rs.getDate("vencimento").toLocalDate();
                    boolean devolvido = rs.getBoolean("devolvido");
                    
                    if (hoje.isAfter(vencimento) && !devolvido) {
                        status = "Atrasado";
                    } else if (devolvido) {
                        status = "Devolvido";
                    } else {
                        status = "Em andamento";
                    }
                } else {
                    status = "Não encontrado";
                }
            }
       
        }
                
                return status;
    }

    public float calcularMulta() throws SQLException {
        LocalDate hoje = LocalDate.now();
        String sql = "select vencimento from emprestimo where idUsuario = ?";
        
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setString(1, matriculaLogada);
            
            try (ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    Date vencimento = rs.getDate("vencimento");
                    LocalDate dataVenc = vencimento.toLocalDate();
                
                    if(hoje.isAfter(dataVenc)){
                    long diasAtraso = ChronoUnit.DAYS.between(dataVenc, hoje);
            
                    float multa = (float) (diasAtraso * 0.5);
            
                    return multa;
                
                } else
                    return (float) 0.0;
            }
                    
        }
            
        catch (SQLException e) {
            System.err.println("Erro ao verificar emprestimos: " + e.getMessage());
            
        }
            
            return 0.0f;
            
    }
        
    }
    
    public boolean extenderEmprestimo() throws SQLException{
        LocalDate hoje = LocalDate.now();
        
        String sql = "update emprestimo set vencimento = ? where matricula = ?";
        
        if (verificarStatus().equals("Em andamento")){
            LocalDate novaDataVenci = hoje.plusDays(7);
            
            try(PreparedStatement stmt = this.conn.prepareStatement(sql)){
                stmt.setDate(1, java.sql.Date.valueOf(novaDataVenci));
                stmt.setString(2, matriculaLogada);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("Erro ao estender empréstimo: " + e.getMessage());
                return false;
            }
            
        }
        else {
            System.out.println("Não é possível estender o empréstimo neste momento.");
            return false;
        }
        return false;

    }
    
}
     

    
    