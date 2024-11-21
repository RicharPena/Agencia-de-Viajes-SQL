/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AgenciaDeViajes.Reserva;
import AgenciaDeViajes.Usuario;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Tipografias.Fuentes;
import javax.swing.JButton;
import Tipografias.Fuentes;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author Systema
 */
public class Registro extends javax.swing.JFrame {

    /**
     * Creates new form Registro
     */    
    public Registro() {
        initComponents();
        putImageinButton("/images/Back_Button_01.png",btnBack);
        setLocationRelativeTo(null);
        cursiveFontinTF(txtName);
        txtName.setForeground(Color.GRAY);
        cursiveFontinTF(txtUserName);
        txtUserName.setForeground(Color.GRAY);
        
        txtContra.setEchoChar('\0');
        cursiveFontinTF(txtContra);
        txtContra.setForeground(Color.GRAY);
        
        txtConfirContra.setEchoChar('\0');
        cursiveFontinTF(txtConfirContra);
        txtConfirContra.setForeground(Color.GRAY);
    }
    
    //Se añaden las imágenes al jframe mediante esta función
    private void putImageinButton(String ruta, JButton btn){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH));
        btn.setIcon(imageIcon);
    }
    
    Fuentes tipoFuente=new Fuentes();
    
    private void titleFont(JLabel jLabel){
        jLabel.setFont(tipoFuente.fuente(tipoFuente.ITROMATRIC,0,18));
    }
    
    private void normalFont(JLabel jLabel){
        jLabel.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
    }
    
    private void cursiveFontinTF(JTextField jtext){
        jtext.setFont(tipoFuente.fuente(tipoFuente.RIO,0,18));
    }
    
    private void normalFontinTF(JTextField jtext){
        jtext.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
    }
    
    private void cursiveFontinPF(JPasswordField jpass){
        jpass.setFont(tipoFuente.fuente(tipoFuente.RIO,0,18));
    }
    
    private void normalFontinPF(JPasswordField jpass){
        jpass.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
    }
    
    //se añaden imágenes a los toggleButton mediante esta función
    private void putImageinTButton(String ruta, JToggleButton Tbtn){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(Tbtn.getWidth(), Tbtn.getHeight(), Image.SCALE_SMOOTH));
        Tbtn.setIcon(imageIcon);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        absolutoPanel = new javax.swing.JPanel();
        btnBack = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        txtConfirContra = new javax.swing.JPasswordField();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        txtMensaje = new javax.swing.JLabel();
        bannerRegister = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        absolutoPanel.setPreferredSize(new java.awt.Dimension(500, 612));
        absolutoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setBorder(null);
        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBack.setPreferredSize(new java.awt.Dimension(60, 60));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        absolutoPanel.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnRegister_001.png"))); // NOI18N
        btnRegister.setToolTipText("");
        btnRegister.setBorder(null);
        btnRegister.setBorderPainted(false);
        btnRegister.setContentAreaFilled(false);
        btnRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegisterMouseClicked(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        absolutoPanel.add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        txtName.setBackground(new java.awt.Color(250, 249, 248));
        txtName.setText("Nombre");
        txtName.setToolTipText("");
        txtName.setActionCommand("<Not Set>");
        txtName.setBorder(null);
        txtName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNameMouseClicked(evt);
            }
        });
        absolutoPanel.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 400, 40));

        txtUserName.setBackground(new java.awt.Color(250, 249, 248));
        txtUserName.setText("User Name");
        txtUserName.setBorder(null);
        txtUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUserNameMouseClicked(evt);
            }
        });
        absolutoPanel.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 212, 400, 50));

        txtContra.setBackground(new java.awt.Color(250, 249, 248));
        txtContra.setText("Contraseña");
        txtContra.setBorder(null);
        txtContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContraMouseClicked(evt);
            }
        });
        absolutoPanel.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 350, 50));

        txtConfirContra.setBackground(new java.awt.Color(250, 249, 248));
        txtConfirContra.setText("Confirmar Contraseña");
        txtConfirContra.setBorder(null);
        txtConfirContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfirContraMouseClicked(evt);
            }
        });
        absolutoPanel.add(txtConfirContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 350, 50));

        jToggleButton1.setBackground(new java.awt.Color(255, 249, 248));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button visual_001.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        absolutoPanel.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 40, 40));

        jToggleButton2.setBackground(new java.awt.Color(255, 244, 243));
        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button visual_001.png"))); // NOI18N
        jToggleButton2.setBorder(null);
        jToggleButton2.setBorderPainted(false);
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton2MouseClicked(evt);
            }
        });
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        absolutoPanel.add(jToggleButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, 40));

        txtMensaje.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(255, 0, 51));
        absolutoPanel.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 420, 20));

        bannerRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Register.png"))); // NOI18N
        absolutoPanel.add(bannerRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 612));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(absolutoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(absolutoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        /*Aquí se verifican todos los campos y guarda en los vectores el nuevo usuario creado
        */
        String n = txtName.getText();
        String u = txtUserName.getText();
        String c1 = new String(txtContra.getPassword());
        String c2 = new String(txtConfirContra.getPassword());
        
        Timer timer = new Timer(2000, (e) -> {txtMensaje.setText("");});
        
        timer.setRepeats(false);
        
        if(u.equals("User Name") || n.equals("Nombre") || c1.equals("Contraseña") || c2.equals("Confirmar Contraseña")){
            txtMensaje.setText("Hacen falta campos por llenar!!!");
            timer.start();
        }else{
            
            boolean aux=false;
            for (Usuario usuario : AgenciaDeViajes.Agencia.listaUsuarios){
                if (usuario.getUserName().equals(u)){
                    txtMensaje.setText("Nombre de Usuario ya Registrado");
                    timer.start();
                    aux=true;
                }
            }
            if(aux){
                
            }else{
                if(c1.equals(c2)){
                    //Aquí se crea el nuevo usuario y se guarda en la base de datos
                    AgenciaDeViajes.Agencia.listaUsuarios.add(new Usuario(n, u, c1));
                    if(!AgenciaDeViajes.Base_de_Datos.usuariosNuevos(AgenciaDeViajes.Agencia.con, n, u, c1)){
                        txtMensaje.setText("No se pudo realizar el registro / Error en la base de Datos");
                        timer.start();
                    }
                    this.dispose();
                    Inicio inicio=new Inicio();
                    inicio.setVisible(true); 
                }
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Si el usuario quiere salir de registro, podrá utilizar el botón y se le devolverá a la pestaña de inicio
        dispose();
        Inicio inicio=new Inicio();
        inicio.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    /*A partir de aquí, se verifican que todos los campos, al momento de darle click en alguno, se elimine lo que tenga
    escrito para que la persona pueda escribir y dependiendo si es passwordField, se programan los botones para ver lo
    escrito dependiendo de las acciones del usuario
    */
    private void txtNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNameMouseClicked
        String ps1 = new String(txtContra.getPassword());
        String ps2 = new String(txtConfirContra.getPassword());
        
        if (txtName.getText().equals("Nombre")){
            txtName.setText("");
            normalFontinTF(txtName);
            txtName.setForeground(Color.BLACK);
        }
        if (txtUserName.getText().equals("")){
            txtUserName.setText("User Name");
            cursiveFontinTF(txtUserName);
            txtUserName.setForeground(Color.GRAY);
        }
        if (ps1.equals("")){
            txtContra.setText("Contraseña");
            txtContra.setEchoChar('\0');
            cursiveFontinPF(txtContra);
            txtContra.setForeground(Color.GRAY);
        }
        if (ps2.equals("")){
            txtConfirContra.setText("Confirmar Contraseña");
            txtConfirContra.setEchoChar('\0');
            cursiveFontinPF(txtConfirContra);
            txtConfirContra.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtNameMouseClicked

    private void txtUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUserNameMouseClicked
        String ps1 = new String(txtContra.getPassword());
        String ps2 = new String(txtConfirContra.getPassword());
        
        if (txtUserName.getText().equals("User Name")){
            txtUserName.setText("");
            normalFontinTF(txtUserName);
            txtUserName.setForeground(Color.BLACK);
        }
        if (txtName.getText().equals("")){
            txtName.setText("Nombre");
            cursiveFontinTF(txtName);
            txtName.setForeground(Color.GRAY);
        }
        if (ps1.equals("")){
            txtContra.setText("Contraseña");
            txtContra.setEchoChar('\0');
            cursiveFontinPF(txtContra);
            txtContra.setForeground(Color.GRAY);
        }
        if (ps2.equals("")){
            txtConfirContra.setText("Confirmar Contraseña");
            txtConfirContra.setEchoChar('\0');
            cursiveFontinPF(txtConfirContra);
            txtConfirContra.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtUserNameMouseClicked

    private void txtContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraMouseClicked
        String ps1 = new String(txtContra.getPassword());
        String ps2 = new String(txtConfirContra.getPassword());
        
        if (ps1.equals("Contraseña")){
            txtContra.setText("");
            if(jToggleButton1.isSelected()){
                txtContra.setEchoChar('\0');
            }
            else{
                txtContra.setEchoChar('\u2022');
            }
            normalFontinPF(txtContra);
            txtContra.setForeground(Color.BLACK);
        }
        if (ps2.equals("")){
            txtConfirContra.setText("Confirmar Contraseña");
            txtConfirContra.setEchoChar('\0');
            cursiveFontinPF(txtConfirContra);
            txtConfirContra.setForeground(Color.GRAY);
        }
        if (txtName.getText().equals("")){
            txtName.setText("Nombre");
            cursiveFontinTF(txtName);
            txtName.setForeground(Color.GRAY);
        }
        if (txtUserName.getText().equals("")){
            txtUserName.setText("User Name");
            cursiveFontinTF(txtUserName);
            txtUserName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtContraMouseClicked

    private void txtConfirContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfirContraMouseClicked
        String ps1 = new String(txtContra.getPassword());
        String ps2 = new String(txtConfirContra.getPassword());
        
        if (ps2.equals("Confirmar Contraseña")){
            txtConfirContra.setText("");
            if(jToggleButton2.isSelected()){
                txtConfirContra.setEchoChar('\0');
            }
            else{
                txtConfirContra.setEchoChar('\u2022');
            }
            normalFontinPF(txtConfirContra);
            txtConfirContra.setForeground(Color.BLACK);
        }
        if (ps1.equals("")){
            txtContra.setText("Contraseña");
            txtContra.setEchoChar('\0');
            cursiveFontinPF(txtContra);
            txtContra.setForeground(Color.GRAY);
        }
        if (txtName.getText().equals("")){
            txtName.setText("Nombre");
            cursiveFontinTF(txtName);
            txtName.setForeground(Color.GRAY);
        }
        if (txtUserName.getText().equals("")){
            txtUserName.setText("User Name");
            cursiveFontinTF(txtUserName);
            txtUserName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtConfirContraMouseClicked

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked
        //NADA
    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jToggleButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton2MouseClicked
        //No va nada
    }//GEN-LAST:event_jToggleButton2MouseClicked

    private void btnRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseClicked
        //No va nada
    }//GEN-LAST:event_btnRegisterMouseClicked
    
    
    //A partir de aqui se declaran las acciones de los botones para que se pueda ver la contraseña de la contraseña y confirmar contraseña
    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        if(jToggleButton1.isSelected()){
            putImageinTButton("/Images/Button visual_002.png", jToggleButton1);
            txtContra.setEchoChar('\0');
        }
        else{
            putImageinTButton("/Images/Button visual_001.png", jToggleButton1);
            if(new String(txtContra.getPassword()).equals("Contraseña")){

            }
            else{
                txtContra.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        if(jToggleButton2.isSelected()){
            putImageinTButton("/Images/Button visual_002.png", jToggleButton2);
            txtConfirContra.setEchoChar('\0');
        }
        else{
            putImageinTButton("/Images/Button visual_001.png", jToggleButton2);
            if(new String(txtConfirContra.getPassword()).equals("Confirmar Contraseña")){

            }
            else{
                txtConfirContra.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel absolutoPanel;
    private javax.swing.JLabel bannerRegister;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRegister;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JPasswordField txtConfirContra;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
