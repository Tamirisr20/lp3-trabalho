package teste1;

import Aluno.CadastroAluno;
import Aluno.LoginAluno;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginCadastro {
    
    private Conexao conn;
    private static Connection con;
    
    public LoginCadastro () throws SQLException{
        this.conn = new Conexao();
        this.con = this.conn.getConexao();
    }
    
    public static void main (String[] args) throws Exception{
       
            
        CadastroAluno Tela;
        Tela = new CadastroAluno(con);
        Tela.setVisible(true);
        Tela.pack();
        Tela.setLocationRelativeTo(null);  
 /*       
        LoginProf Tela2 = new LoginProf();
        Tela2.setVisible(true);
        Tela2.pack();
        Tela2.setLocationRelativeTo(null);
       
        LoginFunc Tela3 = new LoginFunc();
        Tela3.setVisible(true);
        Tela3.pack();
        Tela3.setLocationRelativeTo(null);
*/
        
    }
}