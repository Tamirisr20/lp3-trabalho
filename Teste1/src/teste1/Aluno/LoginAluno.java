
package teste1.Aluno;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public final class LoginAluno extends javax.swing.JFrame {

    String login = "tatasolar";
    String senha = "200605";

    BufferedImage fundo = null;
    JLabel label = new JLabel();
    
    public LoginAluno() throws Exception {
        initComponents();
        setTitle("Login Aluno");
        Tela();
    }
    
    public void Tela(){
        setLayout(new BorderLayout());
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(screenSize);
        
        try {
            fundo = ImageIO.read(new File("/home/solar/NetBeansProjects/Biblioteca/Teste1/src/teste1/biblioteca.png"));
        } 
        catch (IOException e) {
            System.err.println("Erro com a imagem" + e.getMessage());
        }  
                
        
        
        label.setSize((int) (this.getLarguraTela() * 0.5), (this.getAlturaTela()));
        Image dimg = fundo.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon1 = new ImageIcon(dimg);
        label.setIcon(icon1);
        // label.setAlignmentX(JLabel.LEFT);
        //jPanel1.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        jPanel1.add(label);
        
        icon.setSize(label.getWidth(), (this.getAlturaTela()));
        icon.setHorizontalAlignment(JLabel.CENTER);
        icon.setVerticalAlignment(JLabel.CENTER);
        icon.setBorder(new EmptyBorder(10, 10, 10, 10));
        icon.setLayout(new BorderLayout(0, 0));
        // icon.setBorder((new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true)));
        
        jPanel1.setSize((int) (this.getLarguraTela() * 0.5), this.getAlturaTela());
        jPanel2.setSize((int) (this.getLarguraTela() * 0.65), this.getAlturaTela());
        
        jPanel2.setAlignmentX(CENTER_ALIGNMENT);
        jPanel2.setAlignmentY(CENTER_ALIGNMENT);
        
        jPanel1.setVisible(true);
        jPanel2.setVisible(true);
        
    }
    
    //altura da tela
             private int getAlturaTela(){
		int alt = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		return alt;
	}

    //largura da tela
            private int getLarguraTela(){
		int larg = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		return larg;
	}
            
    
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        icon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        textLogin = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        Senha = new javax.swing.JPasswordField();
        Cadastro = new javax.swing.JButton();
        Entrada = new javax.swing.JButton();
        EsqueciSenha = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        MostrarSenha = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela");

        icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/teste1/logo.png"))); // NOI18N
        icon.setAlignmentY(0.0F);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(201, 201, 201))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(icon, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(272, 272, 272))
        );

        jPanel2.setBackground(new java.awt.Color(255, 71, 184));
        jPanel2.setForeground(new java.awt.Color(255, 71, 184));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setText("Matrícula/Email");

        textLogin.setBackground(new java.awt.Color(0, 0, 0));
        textLogin.setForeground(new java.awt.Color(255, 255, 255));
        textLogin.setText("123456789");
        textLogin.setToolTipText("");
        textLogin.setCaretColor(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("Senha");
        jLabel2.setMaximumSize(new java.awt.Dimension(175, 33));
        jLabel2.setMinimumSize(new java.awt.Dimension(175, 33));
        jLabel2.setPreferredSize(new java.awt.Dimension(175, 33));

        Senha.setBackground(new java.awt.Color(0, 0, 0));
        Senha.setForeground(new java.awt.Color(255, 255, 255));
        Senha.setText("123456");
        Senha.setActionCommand("<Not Set>");

        Cadastro.setBackground(new java.awt.Color(167, 30, 188));
        Cadastro.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        Cadastro.setForeground(new java.awt.Color(255, 255, 255));
        Cadastro.setText("Não tem conta? Faça seu cadastro aqui");
        Cadastro.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Cadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroActionPerformed(evt);
            }
        });

        Entrada.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        Entrada.setText("Entrar");
        Entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradaActionPerformed(evt);
            }
        });

        EsqueciSenha.setBackground(new java.awt.Color(255, 71, 184));
        EsqueciSenha.setFont(new java.awt.Font("sansserif", 2, 18)); // NOI18N
        EsqueciSenha.setText("Esqueci senha");
        EsqueciSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        EsqueciSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EsqueciSenhaActionPerformed(evt);
            }
        });

        Titulo.setFont(new java.awt.Font("Noto Serif CJK JP ExtraLight", 1, 48)); // NOI18N
        Titulo.setText("Login Aluno");
        Titulo.setAlignmentY(1.0F);

        MostrarSenha.setBackground(new java.awt.Color(255, 71, 184));
        MostrarSenha.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        MostrarSenha.setText("Mostrar senha");
        MostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MostrarSenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MostrarSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Senha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Entrada, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Cadastro, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLogin, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Titulo, javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(EsqueciSenha, javax.swing.GroupLayout.Alignment.CENTER))
                .addGap(355, 355, 355))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Cadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MostrarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EsqueciSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MostrarSenhaActionPerformed

        if(MostrarSenha.isSelected()){
            Senha.setEchoChar((char)0);
        } else{
            Senha.setEchoChar('*');
        }
    }//GEN-LAST:event_MostrarSenhaActionPerformed

    private void EsqueciSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EsqueciSenhaActionPerformed

    }//GEN-LAST:event_EsqueciSenhaActionPerformed

    private void EntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradaActionPerformed

        if(textLogin.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Insira seu usuário");
        }    if(Senha.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Insira sua senha");
        }
        if(textLogin.getText().equals(login) && (Senha.getText().equals(senha))){
            JOptionPane.showMessageDialog(null, "Correto");
        } else {
            JOptionPane.showMessageDialog(null, "Algo está errado, tente novamente");
        }
    }//GEN-LAST:event_EntradaActionPerformed

    private void CadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroActionPerformed

        CadastroAluno tela;
        try {
            tela = new CadastroAluno();
            tela.setVisible(true);
            tela.pack();
            tela.setLocationRelativeTo(null);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro");
        }

    }//GEN-LAST:event_CadastroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cadastro;
    private javax.swing.JButton Entrada;
    private javax.swing.JButton EsqueciSenha;
    private javax.swing.JCheckBox MostrarSenha;
    private javax.swing.JPasswordField Senha;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JFormattedTextField textLogin;
    // End of variables declaration//GEN-END:variables
}