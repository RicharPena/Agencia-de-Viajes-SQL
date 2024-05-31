/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Systema
 */
public class Sesion extends javax.swing.JFrame {

    /**
     * Creates new form Sesion
     */
    //private Fuentes fuente = new Fuentes();
    public Sesion() {
        initComponents();
        setLocationRelativeTo(null);
        putImage("/Images/logo_agencia_002.png", imgLogo);
        putImage("/Images/nombreAgencia_002.png", imgNombreAgencia);
        putImage("/Images/slogan_002.png", imgSlogan);
        
    }
    
    private void putImage(String ruta, JLabel jlabel){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_SMOOTH));
        jlabel.setIcon(imageIcon);
    }
    
    Fuentes tipoFuente=new Fuentes();
    
    private void titleFont(JLabel jLabel){
        jLabel.setFont(tipoFuente.fuente(tipoFuente.ITROMATRIC,0,18));
    }
    
    private void normalFont(JLabel jLabel){
        jLabel.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        absolutePanel = new javax.swing.JPanel();
        topMove = new javax.swing.JLabel();
        empresaLogo = new javax.swing.JPanel();
        imgLogo = new javax.swing.JLabel();
        imgNombreAgencia = new javax.swing.JLabel();
        imgSlogan = new javax.swing.JLabel();
        barraButtons = new javax.swing.JPanel();
        encabezado = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        panelInicio = new javax.swing.JPanel();
        textopanelInicio = new javax.swing.JLabel();
        panelVuelos = new javax.swing.JPanel();
        panelReserva = new javax.swing.JPanel();
        txtFechaSalida = new javax.swing.JTextField();
        panelConfig = new javax.swing.JPanel();
        backGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        absolutePanel.setBackground(new java.awt.Color(0, 0, 0));
        absolutePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topMove.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topMoveMouseDragged(evt);
            }
        });
        topMove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                topMoveMousePressed(evt);
            }
        });
        absolutePanel.add(topMove, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 40));

        empresaLogo.setBackground(new java.awt.Color(0, 102, 204));
        empresaLogo.setOpaque(false);
        empresaLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        empresaLogo.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 85, 100));
        empresaLogo.add(imgNombreAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 30, 134, 29));
        empresaLogo.add(imgSlogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 60, 134, 17));

        absolutePanel.add(empresaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 120));

        barraButtons.setBackground(new java.awt.Color(0, 102, 204));
        barraButtons.setOpaque(false);
        barraButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        absolutePanel.add(barraButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 240, 500));

        encabezado.setBackground(new java.awt.Color(0, 153, 255));
        encabezado.setOpaque(false);
        encabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        absolutePanel.add(encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 784, 40));

        cardPanel.setLayout(new java.awt.CardLayout());

        panelInicio.setBackground(new java.awt.Color(204, 204, 255));

        textopanelInicio.setText("INICIO");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addComponent(textopanelInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(textopanelInicio)
                .addContainerGap(435, Short.MAX_VALUE))
        );

        cardPanel.add(panelInicio, "card2");

        panelVuelos.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout panelVuelosLayout = new javax.swing.GroupLayout(panelVuelos);
        panelVuelos.setLayout(panelVuelosLayout);
        panelVuelosLayout.setHorizontalGroup(
            panelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        panelVuelosLayout.setVerticalGroup(
            panelVuelosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        cardPanel.add(panelVuelos, "card4");

        panelReserva.setBackground(new java.awt.Color(204, 255, 255));

        javax.swing.GroupLayout panelReservaLayout = new javax.swing.GroupLayout(panelReserva);
        panelReserva.setLayout(panelReservaLayout);
        panelReservaLayout.setHorizontalGroup(
            panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservaLayout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );
        panelReservaLayout.setVerticalGroup(
            panelReservaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReservaLayout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(txtFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(331, Short.MAX_VALUE))
        );

        cardPanel.add(panelReserva, "card3");

        panelConfig.setBackground(new java.awt.Color(255, 255, 204));

        javax.swing.GroupLayout panelConfigLayout = new javax.swing.GroupLayout(panelConfig);
        panelConfig.setLayout(panelConfigLayout);
        panelConfigLayout.setHorizontalGroup(
            panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 784, Short.MAX_VALUE)
        );
        panelConfigLayout.setVerticalGroup(
            panelConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        cardPanel.add(panelConfig, "card6");

        absolutePanel.add(cardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 784, 580));
        cardPanel.getAccessibleContext().setAccessibleName("");

        backGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/backgraund gradiente.png"))); // NOI18N
        backGround.setToolTipText("");
        absolutePanel.add(backGround, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(absolutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(absolutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    //Comenté esta parte porque hay como un error ahí en jCalendar1
    /*
    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        if(evt.getOldValue()!= null){
            SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
            txtFechaSalida.setText(ff.format(jCalendar1.getCalendar().getTime()));
        }
    }//GEN-LAST:event_jCalendar1PropertyChange
    */
    
    int xMouse,yMouse;
    private void topMoveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topMoveMousePressed
        // TODO add your handling code here:
        xMouse=evt.getX();
        yMouse=evt.getY();
    }//GEN-LAST:event_topMoveMousePressed

    private void topMoveMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topMoveMouseDragged
        // TODO add your handling code here:
        int x=evt.getXOnScreen(),y=evt.getYOnScreen();
        
        setLocation(x-xMouse, y-yMouse);
    }//GEN-LAST:event_topMoveMouseDragged
    
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
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel absolutePanel;
    private javax.swing.JLabel backGround;
    private javax.swing.JPanel barraButtons;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JPanel empresaLogo;
    private javax.swing.JPanel encabezado;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgNombreAgencia;
    private javax.swing.JLabel imgSlogan;
    private javax.swing.JPanel panelConfig;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelReserva;
    private javax.swing.JPanel panelVuelos;
    private javax.swing.JLabel textopanelInicio;
    private javax.swing.JLabel topMove;
    private javax.swing.JTextField txtFechaSalida;
    // End of variables declaration//GEN-END:variables
}
