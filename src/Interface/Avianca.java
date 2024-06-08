/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JToggleButton;

/**
 *
 * @author LAB_REDES_B
 */
public class Avianca extends javax.swing.JFrame {

    /**
     * Creates new form Avion
     */
    public Avianca() {
        initComponents();
        asIentos1();
        asIentos2();
        this.setLocationRelativeTo(null);
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
        panelAsientos1 = new javax.swing.JPanel();
        panelAsientos2 = new javax.swing.JPanel();
        colorPremium = new javax.swing.JPanel();
        colorEconomicopremium = new javax.swing.JPanel();
        colorEconomico = new javax.swing.JPanel();
        colorOcupado = new javax.swing.JPanel();
        colorReservado = new javax.swing.JPanel();
        txtPremium = new javax.swing.JLabel();
        txtEconoPremium = new javax.swing.JLabel();
        txtEcono = new javax.swing.JLabel();
        txtOcupado = new javax.swing.JLabel();
        txtReservado = new javax.swing.JLabel();
        AviancaLogo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        avionModel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        absolutePanel.setPreferredSize(new java.awt.Dimension(1280, 546));
        absolutePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAsientos1.setOpaque(false);

        javax.swing.GroupLayout panelAsientos1Layout = new javax.swing.GroupLayout(panelAsientos1);
        panelAsientos1.setLayout(panelAsientos1Layout);
        panelAsientos1Layout.setHorizontalGroup(
            panelAsientos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        panelAsientos1Layout.setVerticalGroup(
            panelAsientos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        absolutePanel.add(panelAsientos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 171, 160, 149));

        panelAsientos2.setOpaque(false);

        javax.swing.GroupLayout panelAsientos2Layout = new javax.swing.GroupLayout(panelAsientos2);
        panelAsientos2.setLayout(panelAsientos2Layout);
        panelAsientos2Layout.setHorizontalGroup(
            panelAsientos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        panelAsientos2Layout.setVerticalGroup(
            panelAsientos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 149, Short.MAX_VALUE)
        );

        absolutePanel.add(panelAsientos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 171, 710, 149));

        colorPremium.setBackground(new java.awt.Color(255, 204, 0));
        colorPremium.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout colorPremiumLayout = new javax.swing.GroupLayout(colorPremium);
        colorPremium.setLayout(colorPremiumLayout);
        colorPremiumLayout.setHorizontalGroup(
            colorPremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        colorPremiumLayout.setVerticalGroup(
            colorPremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        absolutePanel.add(colorPremium, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 40, 40));

        colorEconomicopremium.setBackground(new java.awt.Color(51, 153, 255));
        colorEconomicopremium.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout colorEconomicopremiumLayout = new javax.swing.GroupLayout(colorEconomicopremium);
        colorEconomicopremium.setLayout(colorEconomicopremiumLayout);
        colorEconomicopremiumLayout.setHorizontalGroup(
            colorEconomicopremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        colorEconomicopremiumLayout.setVerticalGroup(
            colorEconomicopremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        absolutePanel.add(colorEconomicopremium, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 40, 40));

        colorEconomico.setBackground(new java.awt.Color(204, 204, 204));
        colorEconomico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout colorEconomicoLayout = new javax.swing.GroupLayout(colorEconomico);
        colorEconomico.setLayout(colorEconomicoLayout);
        colorEconomicoLayout.setHorizontalGroup(
            colorEconomicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        colorEconomicoLayout.setVerticalGroup(
            colorEconomicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        absolutePanel.add(colorEconomico, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 40, 40));

        colorOcupado.setBackground(new java.awt.Color(255, 0, 0));
        colorOcupado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout colorOcupadoLayout = new javax.swing.GroupLayout(colorOcupado);
        colorOcupado.setLayout(colorOcupadoLayout);
        colorOcupadoLayout.setHorizontalGroup(
            colorOcupadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        colorOcupadoLayout.setVerticalGroup(
            colorOcupadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        absolutePanel.add(colorOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 40, 40));

        colorReservado.setBackground(new java.awt.Color(0, 255, 0));
        colorReservado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout colorReservadoLayout = new javax.swing.GroupLayout(colorReservado);
        colorReservado.setLayout(colorReservadoLayout);
        colorReservadoLayout.setHorizontalGroup(
            colorReservadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
        colorReservadoLayout.setVerticalGroup(
            colorReservadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        absolutePanel.add(colorReservado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 40, 40));

        txtPremium.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        txtPremium.setText("Premium");
        absolutePanel.add(txtPremium, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, -1, 40));

        txtEconoPremium.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        txtEconoPremium.setText("Economico Premium");
        absolutePanel.add(txtEconoPremium, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, -1, 40));

        txtEcono.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        txtEcono.setText("Economico");
        txtEcono.setToolTipText("");
        absolutePanel.add(txtEcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, -1, 40));

        txtOcupado.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        txtOcupado.setText("Ocupado");
        txtOcupado.setToolTipText("");
        absolutePanel.add(txtOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, -1, 40));

        txtReservado.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        txtReservado.setText("Reservado");
        txtReservado.setToolTipText("");
        absolutePanel.add(txtReservado, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 490, -1, 40));

        AviancaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/avianca.png"))); // NOI18N
        absolutePanel.add(AviancaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 440, 100));

        jButton1.setText("Reservar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        absolutePanel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 450, 130, 40));

        avionModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/AviancaAvionModel.png"))); // NOI18N
        absolutePanel.add(avionModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 546));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(absolutePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(absolutePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    int ancho1=34;
    int altura1=34;
    int filas1=4;
    int columnas1=4;
    int x1=0;//posicion inicial en x
    int y1=0;//posicion inicial en y
    int count=1;//inicio para enumerar los asientos
    JToggleButton [][] asientos1;//creo una matriz de JToggleButton que hacen las veces de asiento
    private void asIentos1(){
        asientos1 = new JToggleButton[filas1][columnas1];//instancio la matriz
        for(int j=0;j<columnas1;j++){//instancio primero las columnas
            for(int i=0;i<filas1;i++){//luego las filas, para que se imprima de forma vertical
                asientos1[i][j] = new JToggleButton();//instancio cada boton
                asientos1[i][j].setText(""+count);//enumera los asientos
                asientos1[i][j].setBounds(x1,y1,ancho1,altura1);//se les da posicion y tamaño
                panelAsientos1.add(asientos1[i][j]);//se añaden al jPanel
                initAsientos(Integer.parseInt(asientos1[i][j].getText()));
                asientos1[i][j].addActionListener(action1);//se le añade la accion a cada JTougleButton
                y1+=altura1;//el proximo boton estará abajo de este, pero pegado
                count++;//aumento para enumerar los botones
                if(((filas1/2)-1)==i){//cuando las filas van por la mitad
                    y1+=13;//añade la altura para que se separe, así hace el efecto de pasillo
                }
            }
            y1=0;//vuelve a su valor original para añadir la siguiente columna
            x1+=ancho1+8;//se rueda la posicion de los JTbotones de la siguiente columna
        }
    }
    
    ActionListener action1 = new ActionListener() {//Esta es la accion que harán los botones
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<filas1;i++){
                for(int j=0;j<columnas1;j++){
                    if(e.getSource().equals(asientos1[i][j])){
                        if(asientos1[i][j].isSelected()){
                            
                        }
                        else{
                            
                        }
                    }
                }
            }
            
        }
    };
    
    int ancho2=28;
    int altura2=24;
    int filas2=6;
    int columnas2=25;
    int x2=0;//posicion inicial en x
    int y2=0;//posicion inicial en y
    JToggleButton [][] asientos2;//creo una matriz de JToggleButton que hacen las veces de asiento
    private void asIentos2(){
        asientos2 = new JToggleButton[filas2][columnas2];//instancio la matriz
        for(int j=0;j<columnas2;j++){//instancio primero las columnas
            for(int i=0;i<filas2;i++){//luego las filas, para que se imprima de forma vertical
                asientos2[i][j] = new JToggleButton();//instancio cada boton
                asientos2[i][j].setText(""+count);//enumera los asientos
                asientos2[i][j].setBounds(x2,y2,ancho2,altura2);//se les da posicion y tamaño
                panelAsientos2.add(asientos2[i][j]);//se añaden al jPanel
                initAsientos(Integer.parseInt(asientos2[i][j].getText()));
                asientos2[i][j].addActionListener(action2);//se le añade la accion a cada JTougleButton
                y2+=altura2;//el proximo boton estará abajo de este, pero pegado
                count++;//aumento para enumerar los botones
                if(((filas2/2)-1)==i){//cuando las filas van por la mitad
                    y2+=5;//añade la altura para que se separe, así hace el efecto de pasillo
                }
            }
            y2=0;//vuelve a su valor original para añadir la siguiente columna
            x2+=ancho2;//se rueda la posicion de los JTbotones de la siguiente columna
        }
    }
    
    ActionListener action2 = new ActionListener() {//Esta es la accion que harán los botones
        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<filas2;i++){
                for(int j=0;j<columnas2;j++){
                    if(e.getSource().equals(asientos2[i][j])){
                        if(asientos2[i][j].isSelected()){
                            
                        }
                        else{
                            
                        }
                    }
                }
            }
            
        }
    };
    
    public void initAsientos(int idAsiento){
        
    }
    
    
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
            java.util.logging.Logger.getLogger(Avianca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Avianca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Avianca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Avianca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Avianca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AviancaLogo;
    private javax.swing.JPanel absolutePanel;
    private javax.swing.JLabel avionModel;
    private javax.swing.JPanel colorEconomico;
    private javax.swing.JPanel colorEconomicopremium;
    private javax.swing.JPanel colorOcupado;
    private javax.swing.JPanel colorPremium;
    private javax.swing.JPanel colorReservado;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel panelAsientos1;
    private javax.swing.JPanel panelAsientos2;
    private javax.swing.JLabel txtEcono;
    private javax.swing.JLabel txtEconoPremium;
    private javax.swing.JLabel txtOcupado;
    private javax.swing.JLabel txtPremium;
    private javax.swing.JLabel txtReservado;
    // End of variables declaration//GEN-END:variables
}
