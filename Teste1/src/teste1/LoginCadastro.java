package teste1;

import teste1.Aluno.LoginAluno;
import teste1.Funcionario.LoginFunc;
import teste1.Professor.LoginProf;


public class LoginCadastro {
    
    public static void main (String[] args) throws Exception{
        
        LoginAluno Tela = new LoginAluno();
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