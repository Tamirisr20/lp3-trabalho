package teste1;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CadastroAluno extends javax.swing.JFrame {

    BufferedImage img = null;
    
    public CadastroAluno() throws Exception {
        initComponents();
        setTitle("Cadastro Aluno");
        /*setLayout(new BorderLayout());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setPreferredSize(screenSize);*/
        
        try {
            img = ImageIO.read(new File("/home/solar/NetBeansProjects/Biblioteca/Teste1/src/teste1/cadastro.png"));
        } 
        catch (IOException e) {
            System.err.println("Erro com a imagem" + e.getMessage());
        }
        
        Image dimg = img.getScaledInstance(1280,800, Image.SCALE_SMOOTH);

        ImageIcon icon = new ImageIcon(dimg);
        JLabel label = new JLabel(icon);
        label.setSize(1280,800);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        
        this.add(label);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1308, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) throws IOException, Exception {
        
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(){
            new CadastroAluno().setVisible(true);
            }
        });*/
        new CadastroAluno().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
