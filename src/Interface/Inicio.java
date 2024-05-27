/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import javax.swing.Timer;

import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author SIS-01
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    Fuentes tipoFuente;
    public Inicio() {
        initComponents();
        putExitbutton();
        this.setLocationRelativeTo(null);
        tipoFuente = new Fuentes();
        txtUsuario.setFont(tipoFuente.fuente(tipoFuente.RIO,0,18));
        txtUsuario.setForeground(Color.GRAY);
        txtPassword.setEchoChar('\0');
        txtPassword.setFont(tipoFuente.fuente(tipoFuente.RIO, 0, 18));
        txtPassword.setForeground(Color.GRAY);
        txtMensaje.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TbtnVisual = new javax.swing.JToggleButton();
        txtUsuario = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        txtMensaje = new javax.swing.JLabel();
        Barra = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnMini = new javax.swing.JButton();
        banner = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbtnVisual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button visual_001.png"))); // NOI18N
        TbtnVisual.setToolTipText("");
        TbtnVisual.setBorder(null);
        TbtnVisual.setBorderPainted(false);
        TbtnVisual.setContentAreaFilled(false);
        TbtnVisual.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TbtnVisual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TbtnVisualActionPerformed(evt);
            }
        });
        jPanel1.add(TbtnVisual, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 240, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(250, 249, 248));
        txtUsuario.setText("Usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseExited(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 410, 40));

        txtPassword.setBackground(new java.awt.Color(250, 249, 248));
        txtPassword.setText("Contraseña");
        txtPassword.setToolTipText("");
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtPasswordMouseExited(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 360, 40));

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button Login_001.png"))); // NOI18N
        btnLogin.setBorder(null);
        btnLogin.setBorderPainted(false);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 320, -1, -1));

        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button Register_001.png"))); // NOI18N
        btnRegister.setBorder(null);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, -1, 60));

        txtMensaje.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(255, 0, 0));
        txtMensaje.setText(" ");
        jPanel1.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 410, 30));

        Barra.setOpaque(false);
        Barra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                BarraMouseDragged(evt);
            }
        });
        Barra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                BarraMousePressed(evt);
            }
        });

        btnExit.setToolTipText("");
        btnExit.setBorder(null);
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnMini.setBorder(null);
        btnMini.setBorderPainted(false);
        btnMini.setContentAreaFilled(false);
        btnMini.setPreferredSize(new java.awt.Dimension(40, 40));

        javax.swing.GroupLayout BarraLayout = new javax.swing.GroupLayout(Barra);
        Barra.setLayout(BarraLayout);
        BarraLayout.setHorizontalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraLayout.createSequentialGroup()
                .addGap(0, 894, Short.MAX_VALUE)
                .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        BarraLayout.setVerticalGroup(
            BarraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BarraLayout.createSequentialGroup()
                .addComponent(btnMini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(Barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 40));

        banner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Starter Login.png"))); // NOI18N
        jPanel1.add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void putExitbutton(){
        ImageIcon exitImage=new ImageIcon(getClass().getResource("/images/Close_Button_01.png"));
        Icon exitIcon =new ImageIcon(exitImage.getImage().getScaledInstance(btnExit.getWidth(),btnExit.getHeight(),Image.SCALE_SMOOTH));
        btnExit.setIcon(exitIcon);
    }
    //BOTÓN DE REGISTRO
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        this.setVisible(false);
        Registro registro = new Registro();
        registro.setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        String ps =new String(txtPassword.getPassword());
        if (txtUsuario.getText().equals("Usuario")){
            txtUsuario.setText("");
            txtUsuario.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
            txtUsuario.setForeground(Color.BLACK);
        }
        if (ps.equals("")){
            txtPassword.setText("Contraseña");
            txtPassword.setEchoChar('\0');
            txtPassword.setFont(tipoFuente.fuente(tipoFuente.RIO,0,18));
            txtPassword.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtUsuarioMouseClicked
    //Este otro método podría ir, funciona cuando sale el mouse de la caja que contiene el textfield
    //Mejor es si clickea en el otro txt y si no hay nada la cambia, ya que si sale de la caja y se cambia se siente extraño
    private void txtUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseExited
        
    }//GEN-LAST:event_txtUsuarioMouseExited

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        String ps =new String(txtPassword.getPassword());
        if (ps.equals("Contraseña")){
            txtPassword.setText("");
            if(TbtnVisual.isSelected()){
                txtPassword.setEchoChar('\0');
            }
            else{
                txtPassword.setEchoChar('\u2022');
            }
            txtPassword.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
            txtPassword.setForeground(Color.BLACK);
        }
        if (txtUsuario.getText().equals("")){
            txtUsuario.setText("Usuario");
            txtUsuario.setFont(tipoFuente.fuente(tipoFuente.RIO,0,18));
            txtUsuario.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtPasswordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseExited
        
    }//GEN-LAST:event_txtPasswordMouseExited

    
    //BOTÓN DE LOGIN
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String u = txtUsuario.getText();
        String c = new String(txtPassword.getPassword());
        
        Timer timer = new Timer(2000, (e) -> {txtMensaje.setText("");});
        
        timer.setRepeats(false);        
        if (u.equals("Usuario") && c.equals("Contraseña")){
            txtMensaje.setText("Hacen falta campos por llenar!!!");
            timer.start();
        }
        else{
            if (u.equals("Usuario")){
                txtMensaje.setText("No se ha digitado ningún usuario!!!");
                timer.start();
            }
            else{
                if (c.equals("Contraseña")){
                    txtMensaje.setText("No se ha escrito una contraseña!!!");
                    timer.start();
                }
                else{
                    this.setVisible(false);
                    Sesion sesion = new Sesion();
                    sesion.setVisible(true);
                }
            }
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed
    
    
    private void TbtnVisualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TbtnVisualActionPerformed
        // TODO add your handling code here:
        
        Icon blindEye,eye;
        
        blindEye = new ImageIcon(getClass().getResource("/Images/Button visual_001.png"));
        eye = new ImageIcon(getClass().getResource("/Images/Button visual_002.png"));
        
        if(TbtnVisual.isSelected()){
            TbtnVisual.setIcon(eye);
            txtPassword.setEchoChar('\0');
        }
        else{
            TbtnVisual.setIcon(blindEye);
            if(new String(txtPassword.getPassword()).equals("Contraseña")){
                
            }
            else{
                txtPassword.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_TbtnVisualActionPerformed
    
    int xMouse,yMouse;
    private void BarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_BarraMousePressed
    
    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void BarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BarraMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_BarraMouseDragged

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        // TODO add your handling code here:
        ImageIcon exitImage=new ImageIcon(getClass().getResource("/images/Close_Button_02.png"));
        Icon exitIcon =new ImageIcon(exitImage.getImage().getScaledInstance(btnExit.getWidth(),btnExit.getHeight(),Image.SCALE_SMOOTH));
        btnExit.setIcon(exitIcon);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        // TODO add your handling code here:
        ImageIcon exitImage=new ImageIcon(getClass().getResource("/images/Close_Button_01.png"));
        Icon exitIcon =new ImageIcon(exitImage.getImage().getScaledInstance(btnExit.getWidth(),btnExit.getHeight(),Image.SCALE_SMOOTH));
        btnExit.setIcon(exitIcon);
    }//GEN-LAST:event_btnExitMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Barra;
    private javax.swing.JToggleButton TbtnVisual;
    private javax.swing.JLabel banner;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnMini;
    private javax.swing.JButton btnRegister;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
