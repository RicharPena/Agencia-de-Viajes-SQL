/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AgenciaDeViajes.Agencia;
import AgenciaDeViajes.Asiento;
import AgenciaDeViajes.AsientoBusiness;
import AgenciaDeViajes.AsientoEconomico;
import AgenciaDeViajes.AsientoEconomicoPremium;
import AgenciaDeViajes.Usuario;
import AgenciaDeViajes.Vuelo;
import java.awt.Color;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JToggleButton;

/**
 *
 * @author LAB_REDES_B
 */
public class FlyEmirates extends javax.swing.JFrame {
    private int posVuelo;
    private int posReserva;

    /**
     * Creates new form Avion
     */
    public FlyEmirates(){
        
    }
    /*Para tener en cuenta, tanto Avianca como FlyEmirates o LatamAirlanes utilizan los mismos métodos o similares
    debido a que su estructura es la misma (todo el código explicado en la clase Avianca)
    */
    
    public FlyEmirates(int posVuelo,int posReserva) {
        this.posVuelo=posVuelo;
        this.posReserva=posReserva;//Si es -1 es para crear una reserva
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
        FlyEmiratesLogo = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        avionModel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        absolutePanel.setPreferredSize(new java.awt.Dimension(1280, 546));
        absolutePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAsientos1.setOpaque(false);

        javax.swing.GroupLayout panelAsientos1Layout = new javax.swing.GroupLayout(panelAsientos1);
        panelAsientos1.setLayout(panelAsientos1Layout);
        panelAsientos1Layout.setHorizontalGroup(
            panelAsientos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );
        panelAsientos1Layout.setVerticalGroup(
            panelAsientos1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        absolutePanel.add(panelAsientos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 180, 116));

        panelAsientos2.setOpaque(false);

        javax.swing.GroupLayout panelAsientos2Layout = new javax.swing.GroupLayout(panelAsientos2);
        panelAsientos2.setLayout(panelAsientos2Layout);
        panelAsientos2Layout.setHorizontalGroup(
            panelAsientos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        panelAsientos2Layout.setVerticalGroup(
            panelAsientos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );

        absolutePanel.add(panelAsientos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 600, 116));

        colorPremium.setBackground(new java.awt.Color(255, 204, 0));

        javax.swing.GroupLayout colorPremiumLayout = new javax.swing.GroupLayout(colorPremium);
        colorPremium.setLayout(colorPremiumLayout);
        colorPremiumLayout.setHorizontalGroup(
            colorPremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorPremiumLayout.setVerticalGroup(
            colorPremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        absolutePanel.add(colorPremium, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 40, 40));

        colorEconomicopremium.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout colorEconomicopremiumLayout = new javax.swing.GroupLayout(colorEconomicopremium);
        colorEconomicopremium.setLayout(colorEconomicopremiumLayout);
        colorEconomicopremiumLayout.setHorizontalGroup(
            colorEconomicopremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorEconomicopremiumLayout.setVerticalGroup(
            colorEconomicopremiumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        absolutePanel.add(colorEconomicopremium, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 40, 40));

        colorEconomico.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout colorEconomicoLayout = new javax.swing.GroupLayout(colorEconomico);
        colorEconomico.setLayout(colorEconomicoLayout);
        colorEconomicoLayout.setHorizontalGroup(
            colorEconomicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorEconomicoLayout.setVerticalGroup(
            colorEconomicoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        absolutePanel.add(colorEconomico, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 40, 40));

        colorOcupado.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout colorOcupadoLayout = new javax.swing.GroupLayout(colorOcupado);
        colorOcupado.setLayout(colorOcupadoLayout);
        colorOcupadoLayout.setHorizontalGroup(
            colorOcupadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorOcupadoLayout.setVerticalGroup(
            colorOcupadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        absolutePanel.add(colorOcupado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 420, 40, 40));

        colorReservado.setBackground(new java.awt.Color(184, 207, 229));

        javax.swing.GroupLayout colorReservadoLayout = new javax.swing.GroupLayout(colorReservado);
        colorReservado.setLayout(colorReservadoLayout);
        colorReservadoLayout.setHorizontalGroup(
            colorReservadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        colorReservadoLayout.setVerticalGroup(
            colorReservadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        absolutePanel.add(colorReservado, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, 40, 40));

        txtPremium.setFont(new java.awt.Font("Lucida Sans", 1, 18)); // NOI18N
        txtPremium.setText("Business");
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

        FlyEmiratesLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/flyemirates.png"))); // NOI18N
        absolutePanel.add(FlyEmiratesLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 360, 125));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        absolutePanel.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 450, 130, 40));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        absolutePanel.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 450, 130, 40));

        avionModel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FlyEmiratesAvionModel.png"))); // NOI18N
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        if(posReserva==-1){
            Sesion sesion = new Sesion(1);
            sesion.setVisible(true);
        }else{
            Sesion sesion = new Sesion(2);
            sesion.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        if(posReserva==-1){
            ArrayList <Integer> asientos = new ArrayList<>();
            for(int j=0;j<columnas1;j++){
                for(int i=0;i<filas1;i++){
                    if(asientos1[i][j].isSelected()){
                        asientos.add(Integer.valueOf(asientos1[i][j].getText()));
                    }
                }
            }
            for(int j=0;j<columnas2;j++){
                for(int i=0;i<filas2;i++){
                    if(asientos2[i][j].isSelected()){
                        asientos.add(Integer.valueOf(asientos2[i][j].getText()));
                    }
                }
            }
            Agencia.listaUsuarios.get(Inicio.posicionUsuario).crearReserva(Agencia.listaVuelos.get(posVuelo),asientos);
            
            Sesion sesion = new Sesion(1);
            sesion.setVisible(true);
        }else{
            ArrayList <Integer> actual = Agencia.listaUsuarios.get(Inicio.posicionUsuario).getListaReserva().get(posReserva).getAsientos();
            ArrayList <Integer> nuevo = new ArrayList<>();
            
            for(int j=0;j<columnas1;j++){
                for(int i=0;i<filas1;i++){
                    if(asientos1[i][j].isSelected()){
                        nuevo.add(Integer.valueOf(asientos1[i][j].getText()));
                    }
                }
            }
            for(int j=0;j<columnas2;j++){
                for(int i=0;i<filas2;i++){
                    if(asientos2[i][j].isSelected()){
                        nuevo.add(Integer.valueOf(asientos2[i][j].getText()));
                    }
                }
            }
            
            if(nuevo.equals(actual)){
                
            }else{
                if(nuevo.isEmpty()){
                    Agencia.listaUsuarios.get(Inicio.posicionUsuario).cancelarReserva(posReserva+1);
                }else{
                    ArrayList <Integer> agregar = new ArrayList<>();
                    ArrayList <Integer> quitar = new ArrayList<>();
                    
                    Agencia.listaUsuarios.get(Inicio.posicionUsuario).getListaReserva().get(posReserva).setPago(false);
                    
                    for (Integer num : nuevo) {
                        if (!actual.contains(num)) {
                            agregar.add(num);
                        }
                    }

                    for (Integer num : actual) {
                        if (!nuevo.contains(num)) {
                            quitar.add(num);
                        }
                    }
                    
                    Agencia.listaUsuarios.get(Inicio.posicionUsuario).getListaReserva().get(posReserva).agregarAsientos(agregar);
                    Agencia.listaUsuarios.get(Inicio.posicionUsuario).getListaReserva().get(posReserva).eliminarAsientos(quitar);
                }
            }
            Sesion sesion = new Sesion(2);
            sesion.setVisible(true);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    int ancho1=20;
    int altura1=26;
    int filas1=4;
    int columnas1=8;
    int x1=0;//posicion inicial en x
    int y1=1;//posicion inicial en y
    int count=1;//inicio para enumerar los asientos
    JToggleButton [][] asientos1;//creo una matriz de JToggleButton que hacen las veces de asiento
    private void asIentos1(){
        asientos1 = new JToggleButton[filas1][columnas1];//instancio la matriz
        for(int j=0;j<columnas1;j++){//instancio primero las columnas
            for(int i=0;i<filas1;i++){//luego las filas, para que se imprima de forma vertical
                asientos1[i][j] = new JToggleButton();//instancio cada boton
                asientos1[i][j].setText(""+count);//enumera los asientos
                asientos1[i][j].setBounds(x1,y1,ancho1,altura1);//se les da posicion y tamaño
                initAsientos1(i,j,count-1);
                panelAsientos1.add(asientos1[i][j]);//se añaden al jPanel
                y1+=altura1;//el proximo boton estará abajo de este, pero pegado
                count++;//aumento para enumerar los botones
                if(((filas1/2)-1)==i){//cuando las filas van por la mitad
                    y1+=11;//añade la altura para que se separe, así hace el efecto de pasillo
                }
            }
            y1=1;//vuelve a su valor original para añadir la siguiente columna
            x1+=ancho1;//se rueda la posicion de los JTbotones de la siguiente columna
        }
    }
    
    public class Accion1 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<filas1;i++){
                for(int j=0;j<columnas1;j++){
                    if(e.getSource().equals(asientos1[i][j])){
                        if(asientos1[i][j].isSelected()){
                            asientos1[i][j].setBackground(reserva);
                            asientos1[i][j].setForeground(reserva);
                        }
                        else{
                            if(Agencia.listaVuelos.get(posVuelo).getAsientos()[Integer.parseInt(asientos1[i][j].getText())-1] instanceof AsientoBusiness){
                                asientos1[i][j].setBackground(business);
                                asientos1[i][j].setForeground(business);
                            }else{
                                if(Agencia.listaVuelos.get(posVuelo).getAsientos()[Integer.parseInt(asientos1[i][j].getText())-1] instanceof AsientoEconomicoPremium){
                                    asientos1[i][j].setBackground(econopremium);
                                    asientos1[i][j].setForeground(econopremium);
                                }else{
                                    asientos1[i][j].setBackground(econo);
                                    asientos1[i][j].setForeground(econo);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    int ancho2=12;
    int altura2=18;
    int filas2=6;
    int columnas2=50;
    int x2=0;//posicion inicial en x
    int y2=1;//posicion inicial en y
    JToggleButton [][] asientos2;//creo una matriz de JToggleButton que hacen las veces de asiento
    private void asIentos2(){
        asientos2 = new JToggleButton[filas2][columnas2];//instancio la matriz
        for(int j=0;j<columnas2;j++){//instancio primero las columnas
            for(int i=0;i<filas2;i++){//luego las filas, para que se imprima de forma vertical
                asientos2[i][j] = new JToggleButton();//instancio cada boton
                asientos2[i][j].setText(""+count);//enumera los asientos
                asientos2[i][j].setBounds(x2,y2,ancho2,altura2);//se les da posicion y tamaño
                initAsientos2(i,j,count-1);
                panelAsientos2.add(asientos2[i][j]);//se añaden al jPanel
                y2+=altura2;//el proximo boton estará abajo de este, pero pegado
                count++;//aumento para enumerar los botones
                if(((filas2/2)-1)==i){//cuando las filas van por la mitad
                    y2+=7;//añade la altura para que se separe, así hace el efecto de pasillo
                }
            }
            y2=1;//vuelve a su valor original para añadir la siguiente columna
            x2+=ancho2;//se rueda la posicion de los JTbotones de la siguiente columna
        }
    }
    
    public class Accion2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            for(int i=0;i<filas2;i++){
                for(int j=0;j<columnas2;j++){
                    if(e.getSource().equals(asientos2[i][j])){
                        if(asientos2[i][j].isSelected()){
                            asientos2[i][j].setBackground(reserva);
                            asientos2[i][j].setForeground(reserva);
                        }
                        else{
                            if(Agencia.listaVuelos.get(posVuelo).getAsientos()[Integer.parseInt(asientos2[i][j].getText())-1] instanceof AsientoBusiness){
                                asientos2[i][j].setBackground(business);
                                asientos2[i][j].setForeground(business);
                            }else{
                                if(Agencia.listaVuelos.get(posVuelo).getAsientos()[Integer.parseInt(asientos2[i][j].getText())-1] instanceof AsientoEconomicoPremium){
                                    asientos2[i][j].setBackground(econopremium);
                                    asientos2[i][j].setForeground(econopremium);
                                }else{
                                    asientos2[i][j].setBackground(econo);
                                    asientos2[i][j].setForeground(econo);
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
    
    Color business=new Color(255,204,0),econopremium=new Color(51,153,255),econo=new Color(0,153,0),ocupado=new Color(255,0,0),reserva=new Color(184,207,229);
    
    public void initAsientos1(int i,int j,int posAsiento){
        Vuelo vuelo = Agencia.listaVuelos.get(posVuelo);
        Asiento asiento = vuelo.getAsientos()[posAsiento];
        Usuario usuarioActual = Agencia.listaUsuarios.get(Inicio.posicionUsuario);
        Accion1 action = new Accion1();

        if(Agencia.asientoOcupadoPorOtroUsuario(posVuelo, posAsiento, usuarioActual)){
            asientos1[i][j].setBackground(ocupado);
            asientos1[i][j].setForeground(ocupado);
            asientos1[i][j].setEnabled(false);
        }else{
            if(asiento.getOcupado()){
                asientos1[i][j].setBackground(reserva);
                asientos1[i][j].setForeground(reserva);
                asientos1[i][j].setSelected(true);
                asientos1[i][j].addActionListener(action);
            }else{
                if(asiento instanceof AsientoBusiness){
                    asientos1[i][j].setBackground(business);
                    asientos1[i][j].setForeground(business);
                    asientos1[i][j].addActionListener(action);
                }else{
                    if(asiento instanceof AsientoEconomicoPremium){
                        asientos1[i][j].setBackground(econopremium);
                        asientos1[i][j].setForeground(econopremium);
                        asientos1[i][j].addActionListener(action);
                    }else{
                        if(asiento instanceof AsientoEconomico){
                            asientos1[i][j].setBackground(econo);
                            asientos1[i][j].setForeground(econo);
                            asientos1[i][j].addActionListener(action);
                        }
                    }
                }
            }
        }
    }
    
    public void initAsientos2(int i,int j,int posAsiento){
        Vuelo vuelo = Agencia.listaVuelos.get(posVuelo);
        Asiento asiento = vuelo.getAsientos()[posAsiento];
        Usuario usuarioActual = Agencia.listaUsuarios.get(Inicio.posicionUsuario);
        Accion2 action = new Accion2();

        if(Agencia.asientoOcupadoPorOtroUsuario(posVuelo, posAsiento, usuarioActual)){
            asientos2[i][j].setBackground(ocupado);
            asientos2[i][j].setForeground(ocupado);
            asientos2[i][j].setEnabled(false);
        }else{
            if(asiento.getOcupado()){
                asientos2[i][j].setBackground(reserva);
                asientos2[i][j].setForeground(reserva);
                asientos2[i][j].setSelected(true);
                asientos2[i][j].addActionListener(action);
            }else{
                if(asiento instanceof AsientoBusiness){
                    asientos2[i][j].setBackground(business);
                    asientos2[i][j].setForeground(business);
                    asientos2[i][j].addActionListener(action);
                }else{
                    if(asiento instanceof AsientoEconomicoPremium){
                        asientos2[i][j].setBackground(econopremium);
                        asientos2[i][j].setForeground(econopremium);
                        asientos2[i][j].addActionListener(action);
                    }else{
                        if(asiento instanceof AsientoEconomico){
                            asientos2[i][j].setBackground(econo);
                            asientos2[i][j].setForeground(econo);
                            asientos2[i][j].addActionListener(action);
                        }
                    }
                }
            }
        }
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
            java.util.logging.Logger.getLogger(FlyEmirates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlyEmirates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlyEmirates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlyEmirates.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new FlyEmirates().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FlyEmiratesLogo;
    private javax.swing.JPanel absolutePanel;
    private javax.swing.JLabel avionModel;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel colorEconomico;
    private javax.swing.JPanel colorEconomicopremium;
    private javax.swing.JPanel colorOcupado;
    private javax.swing.JPanel colorPremium;
    private javax.swing.JPanel colorReservado;
    private javax.swing.JPanel panelAsientos1;
    private javax.swing.JPanel panelAsientos2;
    private javax.swing.JLabel txtEcono;
    private javax.swing.JLabel txtEconoPremium;
    private javax.swing.JLabel txtOcupado;
    private javax.swing.JLabel txtPremium;
    private javax.swing.JLabel txtReservado;
    // End of variables declaration//GEN-END:variables
}
