/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AgenciaDeViajes.Vuelo;
import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Systema
 */
public class Sesion extends javax.swing.JFrame {

    /**
     * Creates new form Sesion
     */
    //private Fuentes fuente = new Fuentes();
    DefaultTableModel tb = new DefaultTableModel();
    private JButton btnReservar = new JButton("Reservar");
    //Con el fin de guardar la columna y la fila donde está ubicado el botón de registro
    private int columna, fila;
    
    public Sesion() {
        initComponents();
        setLocationRelativeTo(null);
        putImageInJL("/Images/logo_agencia_002.png", imgLogo);
        putImageInJL("/Images/nombreAgencia_002.png", imgNombreAgencia);
        putImageInJL("/Images/slogan_002.png", imgSlogan);
        putImageInJL("/Images/Panel Inicio.png", BGinicio);
        
        Fuentes tipoFuente = new Fuentes();
        
        txtShowUserName.setFont(tipoFuente.fuente(tipoFuente.OSB, 0, 70));
        txtShowUserName.setText(AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getUserName());
        
        shadowVuelos.setVisible(false);
        shadowReservas.setVisible(false);
        shadowConfig.setVisible(false);
        shadowCS.setVisible(false);
        
        //A partir de aquí se inicia el panel de configuración
        parametroJTextFiel(txtCambioNombre);
        parametroJTextFiel(txtCambioUserName);
        parametroJTextFiel(txtTarjeta);
        
        if (AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getTarjeta() == null){
            //El textField queda así, sin nada.
        }
        else{
            txtTarjeta.setText(AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getTarjeta());
        }
        
        parametroJPassword(txtCambioContra);
        parametroJPassword(txtConfCamContra);
        
        //A partir de aquí se inicia el panel de Vuelos
        actualizarTabla(0);
        
        putImageInTButton("/images/Button visual_001.png", TbtnVisual1);
        putImageInTButton("/images/Button visual_001.png", TbtnVisual2);
    }
    
    private void putImageInJL(String ruta, JLabel jlabel){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(jlabel.getWidth(), jlabel.getHeight(), Image.SCALE_SMOOTH));
        jlabel.setIcon(imageIcon);
    }
    
    private void putImageInButton(String ruta, JButton btn){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH));
        btn.setIcon(imageIcon);
    }
    
    private void putImageInTButton(String ruta, JToggleButton Tbtn){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(Tbtn.getWidth(), Tbtn.getHeight(), Image.SCALE_SMOOTH));
        Tbtn.setIcon(imageIcon);
    }
    
    Fuentes tipoFuente=new Fuentes();
    
    private void titleFont(JLabel jLabel){
        jLabel.setFont(tipoFuente.fuente(tipoFuente.ITROMATRIC,0,18));
    }
    
    private void normalFont(JLabel jLabel){
        jLabel.setFont(tipoFuente.fuente(tipoFuente.BPR,0,18));
    }
    
    private void normalFontinTF(JTextField jtext){
        jtext.setFont(tipoFuente.fuente(tipoFuente.BPR,0,12));
    }
    
    private void cursiveFontinTF(JTextField jtext){
        jtext.setFont(tipoFuente.fuente(tipoFuente.RIO,0,12));
    }
    
    private void cursiveFontinPF(JPasswordField jpass){
        jpass.setFont(tipoFuente.fuente(tipoFuente.RIO,0,12));
    }
    
    private void normalFontinPF(JPasswordField jpass){
        jpass.setFont(tipoFuente.fuente(tipoFuente.BPR,0,12));
    }
    
    private void parametroJTextFiel(JTextField jtext){
        jtext.setFont(tipoFuente.fuente(tipoFuente.RIO,0,12));
        jtext.setForeground(Color.GRAY);
    }
    
    private void parametroJPassword(JPasswordField jpass){
        jpass.setEchoChar('\0');
        jpass.setFont(tipoFuente.fuente(tipoFuente.RIO,0,12));
        jpass.setForeground(Color.GRAY);
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
        encabezado = new javax.swing.JLabel();
        barraButtons = new javax.swing.JPanel();
        tbtnHome = new javax.swing.JToggleButton();
        tbtnVuelos = new javax.swing.JToggleButton();
        tbtnReservas = new javax.swing.JToggleButton();
        tbtnConfig = new javax.swing.JToggleButton();
        btnLogOut = new javax.swing.JButton();
        iconHome = new javax.swing.JLabel();
        iconVuelos = new javax.swing.JLabel();
        iconReservas = new javax.swing.JLabel();
        iconConfig = new javax.swing.JLabel();
        iconLogOut = new javax.swing.JLabel();
        shadowHome = new javax.swing.JLabel();
        shadowVuelos = new javax.swing.JLabel();
        shadowReservas = new javax.swing.JLabel();
        shadowConfig = new javax.swing.JLabel();
        shadowCS = new javax.swing.JLabel();
        BGSC = new javax.swing.JLabel();
        opciones = new javax.swing.JTabbedPane();
        Inicio = new javax.swing.JPanel();
        txtShowUserName = new javax.swing.JLabel();
        BGinicio = new javax.swing.JLabel();
        Vuelos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVuelos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        comboOrdenar = new javax.swing.JComboBox<>();
        Reservas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Config = new javax.swing.JPanel();
        txtCambioNombre = new javax.swing.JTextField();
        txtCambioUserName = new javax.swing.JTextField();
        txtCambioContra = new javax.swing.JPasswordField();
        txtConfCamContra = new javax.swing.JPasswordField();
        txtTarjeta = new javax.swing.JTextField();
        TbtnVisual1 = new javax.swing.JToggleButton();
        TbtnVisual2 = new javax.swing.JToggleButton();
        btnEditAddTarjet = new javax.swing.JButton();
        btnSaveChanges = new javax.swing.JButton();
        txtMensaje = new javax.swing.JLabel();
        BGConfig = new javax.swing.JLabel();
        backgraund = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        absolutePanel.setBackground(new java.awt.Color(0, 0, 0));
        absolutePanel.setOpaque(false);
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
        absolutePanel.add(topMove, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1064, 40));

        empresaLogo.setBackground(new java.awt.Color(0, 102, 204));
        empresaLogo.setOpaque(false);
        empresaLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        empresaLogo.add(imgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 68, 80));
        empresaLogo.add(imgNombreAgencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 30, 134, 29));
        empresaLogo.add(imgSlogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 60, 134, 17));

        absolutePanel.add(empresaLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 120));

        encabezado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/heading.png"))); // NOI18N
        absolutePanel.add(encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1064, 40));

        barraButtons.setBackground(new java.awt.Color(0, 102, 204));
        barraButtons.setOpaque(false);
        barraButtons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbtnHome.setSelected(true);
        tbtnHome.setBorder(null);
        tbtnHome.setBorderPainted(false);
        tbtnHome.setContentAreaFilled(false);
        tbtnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbtnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbtnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbtnHomeMouseExited(evt);
            }
        });
        tbtnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnHomeActionPerformed(evt);
            }
        });
        barraButtons.add(tbtnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 60));

        tbtnVuelos.setBorder(null);
        tbtnVuelos.setBorderPainted(false);
        tbtnVuelos.setContentAreaFilled(false);
        tbtnVuelos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbtnVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbtnVuelosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbtnVuelosMouseExited(evt);
            }
        });
        tbtnVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnVuelosActionPerformed(evt);
            }
        });
        barraButtons.add(tbtnVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 240, 60));

        tbtnReservas.setBorder(null);
        tbtnReservas.setBorderPainted(false);
        tbtnReservas.setContentAreaFilled(false);
        tbtnReservas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbtnReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbtnReservasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbtnReservasMouseExited(evt);
            }
        });
        tbtnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnReservasActionPerformed(evt);
            }
        });
        barraButtons.add(tbtnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 240, 60));

        tbtnConfig.setBorder(null);
        tbtnConfig.setBorderPainted(false);
        tbtnConfig.setContentAreaFilled(false);
        tbtnConfig.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbtnConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbtnConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tbtnConfigMouseExited(evt);
            }
        });
        tbtnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbtnConfigActionPerformed(evt);
            }
        });
        barraButtons.add(tbtnConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 240, 60));

        btnLogOut.setBorder(null);
        btnLogOut.setBorderPainted(false);
        btnLogOut.setContentAreaFilled(false);
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        barraButtons.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 60));

        iconHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnHome.png"))); // NOI18N
        iconHome.setToolTipText("");
        barraButtons.add(iconHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 60));

        iconVuelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnVuelos.png"))); // NOI18N
        iconVuelos.setToolTipText("");
        barraButtons.add(iconVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 240, 60));

        iconReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnReservas.png"))); // NOI18N
        iconReservas.setToolTipText("");
        barraButtons.add(iconReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 240, 60));

        iconConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnConfig.png"))); // NOI18N
        iconConfig.setToolTipText("");
        barraButtons.add(iconConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 240, 60));

        iconLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BtnCS.png"))); // NOI18N
        iconLogOut.setToolTipText("");
        barraButtons.add(iconLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 60));

        shadowHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shadow.png"))); // NOI18N
        shadowHome.setToolTipText("");
        barraButtons.add(shadowHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 240, 60));

        shadowVuelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shadow.png"))); // NOI18N
        shadowVuelos.setToolTipText("");
        barraButtons.add(shadowVuelos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 240, 60));
        shadowVuelos.getAccessibleContext().setAccessibleName("");

        shadowReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shadow.png"))); // NOI18N
        shadowReservas.setToolTipText("");
        barraButtons.add(shadowReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 240, 60));

        shadowConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shadow.png"))); // NOI18N
        shadowConfig.setToolTipText("");
        barraButtons.add(shadowConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 240, 60));

        shadowCS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/shadow.png"))); // NOI18N
        shadowCS.setToolTipText("");
        barraButtons.add(shadowCS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 60));

        BGSC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BGCS.png"))); // NOI18N
        barraButtons.add(BGSC, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 240, 60));

        absolutePanel.add(barraButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 260, 510));

        Inicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtShowUserName.setFont(new java.awt.Font("Maiandra GD", 0, 58)); // NOI18N
        Inicio.add(txtShowUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 440, 70));

        BGinicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Panel Inicio.png"))); // NOI18N
        BGinicio.setToolTipText("");
        Inicio.add(BGinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 600));

        opciones.addTab("Inicio", Inicio);

        Vuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVuelos = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int colum){
                return false;
            }
        };
        tblVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        tblVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVuelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVuelos);

        Vuelos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, 360));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ordenar Por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Semibold", 1, 36))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 10)); // NOI18N
        jLabel1.setText("Ordenar por: (tamaño 36)");

        jButton1.setText("Horario");

        jButton2.setText("Business");

        jButton3.setText("Estado Vuelo");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setText("Tarifa Asientos");

        jButton4.setText("Eco Premium");

        jButton5.setText("Economica");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(jButton3))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        Vuelos.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por"));

        comboOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todos", "Horario", "Tarifa Business", "Tarifa Eco Premium", "Tarifa Economica", "Estado Vuelo" }));
        comboOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrdenarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Vuelos.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 220, 70));

        opciones.addTab("Vuelos", Vuelos);

        Reservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Reservas");
        Reservas.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 224, -1, -1));

        opciones.addTab("Reservas", Reservas);

        Config.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCambioNombre.setText("Nuevo Nombre");
        txtCambioNombre.setBorder(null);
        txtCambioNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCambioNombreMouseClicked(evt);
            }
        });
        txtCambioNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioNombreActionPerformed(evt);
            }
        });
        Config.add(txtCambioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 710, 40));

        txtCambioUserName.setText("Nuevo User Name");
        txtCambioUserName.setBorder(null);
        txtCambioUserName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCambioUserNameMouseClicked(evt);
            }
        });
        txtCambioUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioUserNameActionPerformed(evt);
            }
        });
        Config.add(txtCambioUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 195, 710, 40));

        txtCambioContra.setText("Contraseña Nueva");
        txtCambioContra.setBorder(null);
        txtCambioContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCambioContraMouseClicked(evt);
            }
        });
        Config.add(txtCambioContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 285, 300, 45));

        txtConfCamContra.setText("Confirmar Contraseña");
        txtConfCamContra.setBorder(null);
        txtConfCamContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfCamContraMouseClicked(evt);
            }
        });
        Config.add(txtConfCamContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 285, 300, 45));

        txtTarjeta.setText("Agregar / Cambiar Tarjeta");
        txtTarjeta.setBorder(null);
        txtTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTarjetaMouseClicked(evt);
            }
        });
        Config.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 380, 375, 42));

        TbtnVisual1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button visual_001.png"))); // NOI18N
        TbtnVisual1.setBorder(null);
        TbtnVisual1.setBorderPainted(false);
        TbtnVisual1.setContentAreaFilled(false);
        TbtnVisual1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TbtnVisual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TbtnVisual1ActionPerformed(evt);
            }
        });
        Config.add(TbtnVisual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        TbtnVisual2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button visual_001.png"))); // NOI18N
        TbtnVisual2.setBorder(null);
        TbtnVisual2.setBorderPainted(false);
        TbtnVisual2.setContentAreaFilled(false);
        TbtnVisual2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        TbtnVisual2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TbtnVisual2ActionPerformed(evt);
            }
        });
        Config.add(TbtnVisual2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 290, -1, -1));

        btnEditAddTarjet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnEdit-Addtarjet.png"))); // NOI18N
        btnEditAddTarjet.setToolTipText("");
        btnEditAddTarjet.setBorder(null);
        btnEditAddTarjet.setBorderPainted(false);
        btnEditAddTarjet.setContentAreaFilled(false);
        btnEditAddTarjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAddTarjetActionPerformed(evt);
            }
        });
        Config.add(btnEditAddTarjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 370, 226, 56));

        btnSaveChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnSaveChanges.png"))); // NOI18N
        btnSaveChanges.setBorder(null);
        btnSaveChanges.setBorderPainted(false);
        btnSaveChanges.setContentAreaFilled(false);
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });
        Config.add(btnSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, 226, 56));

        txtMensaje.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(255, 51, 51));
        Config.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 730, 30));

        BGConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BGPanelConfig.png"))); // NOI18N
        BGConfig.setToolTipText("");
        Config.add(BGConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 590));

        opciones.addTab("Configuracion", Config);

        absolutePanel.add(opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 5, 804, 625));

        backgraund.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BackGround.png"))); // NOI18N
        absolutePanel.add(backgraund, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1064, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(absolutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(absolutePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tbtnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnHomeActionPerformed
        // TODO add your handling code here:
        if(tbtnHome.isSelected()){
            shadowHome.setVisible(true);
            
            tbtnHome.setEnabled(false);
            
            opciones.setSelectedIndex(0);
            tbtnVuelos.setSelected(false);
            tbtnReservas.setSelected(false);
            tbtnConfig.setSelected(false);
            tbtnVuelos.setEnabled(true);
            tbtnReservas.setEnabled(true);
            tbtnConfig.setEnabled(true);
            shadowVuelos.setVisible(false);
            shadowReservas.setVisible(false);
            shadowConfig.setVisible(false);
        }
    }//GEN-LAST:event_tbtnHomeActionPerformed

    private void tbtnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnHomeMouseEntered
        // TODO add your handling code here:
        if(tbtnHome.isSelected()){
            
        }
        else{
            shadowHome.setVisible(true);
        }
    }//GEN-LAST:event_tbtnHomeMouseEntered

    private void tbtnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnHomeMouseExited
        // TODO add your handling code here:
        if(tbtnHome.isSelected()){
            
        }
        else{
            shadowHome.setVisible(false);
        }
    }//GEN-LAST:event_tbtnHomeMouseExited

    private void tbtnVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnVuelosActionPerformed
        // TODO add your handling code here:
        if(tbtnVuelos.isSelected()){
            shadowVuelos.setVisible(true);
            
            tbtnVuelos.setEnabled(false);
            
            opciones.setSelectedIndex(1);
            tbtnHome.setSelected(false);
            tbtnReservas.setSelected(false);
            tbtnConfig.setSelected(false);
            tbtnHome.setEnabled(true);
            tbtnReservas.setEnabled(true);
            tbtnConfig.setEnabled(true);
            shadowHome.setVisible(false);
            shadowReservas.setVisible(false);
            shadowConfig.setVisible(false);
        }
    }//GEN-LAST:event_tbtnVuelosActionPerformed

    private void tbtnVuelosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnVuelosMouseEntered
        // TODO add your handling code here:
        if(tbtnVuelos.isSelected()){
            
        }
        else{
            shadowVuelos.setVisible(true);
        }
    }//GEN-LAST:event_tbtnVuelosMouseEntered

    private void tbtnVuelosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnVuelosMouseExited
        // TODO add your handling code here:
        if(tbtnVuelos.isSelected()){
            
        }
        else{
            shadowVuelos.setVisible(false);
        }
    }//GEN-LAST:event_tbtnVuelosMouseExited

    private void tbtnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnReservasActionPerformed
        // TODO add your handling code here:
        if(tbtnReservas.isSelected()){
            shadowReservas.setVisible(true);
            
            tbtnReservas.setEnabled(false);
            
            opciones.setSelectedIndex(2);
            tbtnHome.setSelected(false);
            tbtnVuelos.setSelected(false);
            tbtnConfig.setSelected(false);
            tbtnHome.setEnabled(true);
            tbtnVuelos.setEnabled(true);
            tbtnConfig.setEnabled(true);
            shadowHome.setVisible(false);
            shadowVuelos.setVisible(false);
            shadowConfig.setVisible(false);
        }
    }//GEN-LAST:event_tbtnReservasActionPerformed

    private void tbtnReservasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnReservasMouseEntered
        // TODO add your handling code here:
        if(tbtnReservas.isSelected()){
            
        }
        else{
            shadowReservas.setVisible(true);
        }
    }//GEN-LAST:event_tbtnReservasMouseEntered

    private void tbtnReservasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnReservasMouseExited
        // TODO add your handling code here:
        if(tbtnReservas.isSelected()){
            
        }
        else{
            shadowReservas.setVisible(false);
        }
    }//GEN-LAST:event_tbtnReservasMouseExited

    private void tbtnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbtnConfigActionPerformed
        // TODO add your handling code here:
        if(tbtnConfig.isSelected()){
            shadowConfig.setVisible(true);
            
            tbtnConfig.setEnabled(false);
            
            opciones.setSelectedIndex(3);
            tbtnHome.setSelected(false);
            tbtnVuelos.setSelected(false);
            tbtnReservas.setSelected(false);
            tbtnHome.setEnabled(true);
            tbtnVuelos.setEnabled(true);
            tbtnReservas.setEnabled(true);
            shadowHome.setVisible(false);
            shadowVuelos.setVisible(false);
            shadowReservas.setVisible(false);
        }
    }//GEN-LAST:event_tbtnConfigActionPerformed

    private void tbtnConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnConfigMouseEntered
        // TODO add your handling code here:
        if(tbtnConfig.isSelected()){
            
        }
        else{
            shadowConfig.setVisible(true);
        }
    }//GEN-LAST:event_tbtnConfigMouseEntered

    private void tbtnConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtnConfigMouseExited
        // TODO add your handling code here:
        if(tbtnConfig.isSelected()){
            
        }
        else{
            shadowConfig.setVisible(false);
        }
    }//GEN-LAST:event_tbtnConfigMouseExited

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        // TODO add your handling code here:
        Inicio inicio=new Inicio();
        this.dispose();
        inicio.setVisible(true);
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered
        // TODO add your handling code here:
        shadowCS.setVisible(true);
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        // TODO add your handling code here:
        shadowCS.setVisible(false);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void txtCambioUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioUserNameActionPerformed
        //NADA
    }//GEN-LAST:event_txtCambioUserNameActionPerformed

    private void btnSaveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveChangesActionPerformed
        txtMensaje.setForeground(Color.RED);
        
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        Timer timer = new Timer(2000, (e) -> {txtMensaje.setText("");});
        
        timer.setRepeats(false);  
        if(txtCambioNombre.getText().equals("Nuevo Nombre")){
            //NADA
        }
        else{
            if (txtCambioNombre.getText().equals("")){
                txtMensaje.setText("No se ha escrito ningún Nombre!!!");
                timer.start();
            }
            else{
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setNombre(txtCambioNombre.getText());
            }
        }
        
        if (txtCambioUserName.getText().equals("Nuevo User Name")){
            //NADA
        }
        else{
            if (txtCambioUserName.getText().equals("")){
                txtMensaje.setText("No se ha escrito ningún UserName!!!");
                timer.start();
            }
            else{
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setUserName(txtCambioUserName.getText());
            }
        }
        
        if (c1.equals("Contraseña Nueva") && c2.equals("Confirmar Contraseña")){
            //NADA
        }
        else{
            if (c1.equals(c2)){
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setPassword(c1);
            }
            else{
                if(txtCambioUserName.getText().equals("") || txtCambioNombre.getText().equals("")){
                    //NADA
                }
                else{
                txtMensaje.setText("Las contraseñas no coinciden!!!");
                timer.start();
                }
            }
        }
        
        if(txtTarjeta.getText().equals("Agregar / Cambiar Tarjeta")){
            //NADA
        }
        else{
            if (txtTarjeta.getText().length() == 10){
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setTarjeta(txtTarjeta.getText());
            }
            else{
                txtMensaje.setText("Tarjeta Inválida");
                timer.start();
            }
        }
        
        if (txtCambioUserName.getText().equals("Nuevo User Name") && txtCambioNombre.getText().equals("Nuevo Nombre") && c1.equals("Contraseña Nueva") && c2.equals("Confirmar Contraseña") && txtTarjeta.getText().equals("Agregar / Cambiar Tarjeta")){
            txtMensaje.setText("Ningún cambio se ha realizado!!!");
            timer.start();
        }
        else{
            txtMensaje.setForeground(Color.GREEN);
            txtMensaje.setText("Cambios Realizados con Éxito");
            timer.start();
        }
    }//GEN-LAST:event_btnSaveChangesActionPerformed

    private void txtCambioNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioNombreActionPerformed
        //NADA
    }//GEN-LAST:event_txtCambioNombreActionPerformed

    private void txtCambioNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCambioNombreMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtCambioNombre.getText().equals("Nuevo Nombre")){
            txtCambioNombre.setText("");
            normalFontinTF(txtCambioNombre);
            txtCambioNombre.setForeground(Color.BLACK);
        }
        if (txtCambioUserName.getText().equals("")){
            txtCambioUserName.setText("Nuevo User Name");
            cursiveFontinTF(txtCambioUserName);
            txtCambioUserName.setForeground(Color.GRAY);
        }
        if (txtTarjeta.getText().equals("")){
            txtTarjeta.setText("Agregar / Cambiar Tarjeta");
            cursiveFontinTF(txtTarjeta);
            txtTarjeta.setForeground(Color.GRAY);
        }
        if (c1.equals("")){
            txtCambioContra.setText("Contraseña Nueva");
            txtCambioContra.setEchoChar('\0');
            cursiveFontinPF(txtCambioContra);
            txtCambioContra.setForeground(Color.GRAY);
        }
        if (c2.equals("")){
            txtConfCamContra.setText("Confirmar Contraseña");
            txtConfCamContra.setEchoChar('\0');
            cursiveFontinPF(txtConfCamContra);
            txtConfCamContra.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCambioNombreMouseClicked

    private void txtCambioUserNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCambioUserNameMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtCambioNombre.getText().equals("")){
            txtCambioNombre.setText("Nuevo Nombre");
            cursiveFontinTF(txtCambioNombre);
            txtCambioNombre.setForeground(Color.GRAY);
        }
        if (txtCambioUserName.getText().equals("Nuevo User Name")){
            txtCambioUserName.setText("");
            normalFontinTF(txtCambioUserName);
            txtCambioUserName.setForeground(Color.BLACK);
        }
        if (txtTarjeta.getText().equals("")){
            txtTarjeta.setText("Agregar / Cambiar Tarjeta");
            cursiveFontinTF(txtTarjeta);
            txtTarjeta.setForeground(Color.GRAY);
        }
        if (c1.equals("")){
            txtCambioContra.setText("Contraseña Nueva");
            txtCambioContra.setEchoChar('\0');
            cursiveFontinPF(txtCambioContra);
            txtCambioContra.setForeground(Color.GRAY);
        }
        if (c2.equals("")){
            txtConfCamContra.setText("Confirmar Contraseña");
            txtConfCamContra.setEchoChar('\0');
            cursiveFontinPF(txtConfCamContra);
            txtConfCamContra.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCambioUserNameMouseClicked

    private void txtCambioContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCambioContraMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (c1.equals("Contraseña Nueva")){
            txtCambioContra.setText("");
            if(TbtnVisual1.isSelected()){
                txtCambioContra.setEchoChar('\0');
            }
            else{
                txtCambioContra.setEchoChar('\u2022');
            }
            normalFontinPF(txtCambioContra);
            txtCambioContra.setForeground(Color.BLACK);
        }
        if (c2.equals("")){
            txtConfCamContra.setText("Confirmar Contraseña");
            txtConfCamContra.setEchoChar('\0');
            cursiveFontinPF(txtConfCamContra);
            txtConfCamContra.setForeground(Color.GRAY);
        }
        if (txtTarjeta.getText().equals("")){
            txtTarjeta.setText("Agregar / Cambiar Tarjeta");
            cursiveFontinTF(txtTarjeta);
            txtTarjeta.setForeground(Color.GRAY);
        }
        if (txtCambioNombre.getText().equals("")){
            txtCambioNombre.setText("Nuevo Nombre");
            cursiveFontinTF(txtCambioNombre);
            txtCambioNombre.setForeground(Color.GRAY);
        }
        if (txtCambioUserName.getText().equals("")){
            txtCambioUserName.setText("Nuevo User Name");
            cursiveFontinTF(txtCambioUserName);
            txtCambioUserName.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtCambioContraMouseClicked

    private void txtConfCamContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtConfCamContraMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (c2.equals("Confirmar Contraseña")){
            txtConfCamContra.setText("");
            if(TbtnVisual2.isSelected()){
                txtConfCamContra.setEchoChar('\0');
            }
            else{
                txtConfCamContra.setEchoChar('\u2022');
            }
            normalFontinPF(txtConfCamContra);
            txtConfCamContra.setForeground(Color.BLACK);
        }
        if (c1.equals("")){
            txtCambioContra.setText("Contraseña Nueva");
            txtCambioContra.setEchoChar('\0');
            cursiveFontinPF(txtCambioContra);
            txtCambioContra.setForeground(Color.GRAY);
        }
        if (txtCambioNombre.getText().equals("")){
            txtCambioNombre.setText("Nuevo Nombre");
            cursiveFontinTF(txtCambioNombre);
            txtCambioNombre.setForeground(Color.GRAY);
        }
        if (txtCambioUserName.getText().equals("")){
            txtCambioUserName.setText("Nuevo User Name");
            cursiveFontinTF(txtCambioUserName);
            txtCambioUserName.setForeground(Color.GRAY);
        }
        if (txtTarjeta.getText().equals("")){
            txtTarjeta.setText("Agregar / Cambiar Tarjeta");
            cursiveFontinTF(txtTarjeta);
            txtTarjeta.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtConfCamContraMouseClicked

    private void TbtnVisual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TbtnVisual1ActionPerformed
        if(TbtnVisual1.isSelected()){
            putImageInTButton("/Images/Button visual_002.png", TbtnVisual1);
            txtCambioContra.setEchoChar('\0');
        }
        else{
            putImageInTButton("/Images/Button visual_001.png", TbtnVisual1);
            if(new String(txtCambioContra.getPassword()).equals("Contraseña Nueva")){

            }
            else{
                txtCambioContra.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_TbtnVisual1ActionPerformed

    private void TbtnVisual2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TbtnVisual2ActionPerformed
        if(TbtnVisual2.isSelected()){
            putImageInTButton("/Images/Button visual_002.png", TbtnVisual2);
            txtConfCamContra.setEchoChar('\0');
        }
        else{
            putImageInTButton("/Images/Button visual_001.png", TbtnVisual2);
            if(new String(txtConfCamContra.getPassword()).equals("Confirmar Contraseña")){

            }
            else{
                txtConfCamContra.setEchoChar('\u2022');
            }
        }
    }//GEN-LAST:event_TbtnVisual2ActionPerformed

    private void btnEditAddTarjetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAddTarjetActionPerformed
        txtMensaje.setForeground(Color.RED);
        Timer timer = new Timer(2000, (e) -> {txtMensaje.setText("");});
        
        timer.setRepeats(false); 
        
        if(txtTarjeta.getText().equals("Agregar / Cambiar Tarjeta")){
            txtMensaje.setText("No se ha realizado ningún cambio en la Tarjeta!!!");
            timer.start();
        }
        else{
            if (txtTarjeta.getText().length() == 10){
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setTarjeta(txtTarjeta.getText());
                txtMensaje.setForeground(Color.GREEN);
                txtMensaje.setText("Tarjeta Agregada / Cambiada con éxito");
                timer.start();
            }
            else{
                txtMensaje.setText("Tarjeta Inválida");
                timer.start();
            }
        }
        
    }//GEN-LAST:event_btnEditAddTarjetActionPerformed

    private void txtTarjetaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTarjetaMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtCambioNombre.getText().equals("")){
            txtCambioNombre.setText("Nuevo Nombre");
            cursiveFontinTF(txtCambioNombre);
            txtCambioNombre.setForeground(Color.GRAY);
        }
        if (txtCambioUserName.getText().equals("")){
            txtCambioUserName.setText("Nuevo User Name");
            cursiveFontinTF(txtCambioUserName);
            txtCambioUserName.setForeground(Color.GRAY);
        }
        if (txtTarjeta.getText().equals("Agregar / Cambiar Tarjeta")){
            txtTarjeta.setText("");
            normalFontinTF(txtTarjeta);
            txtTarjeta.setForeground(Color.BLACK);
        }
        if (c1.equals("")){
            txtCambioContra.setText("Contraseña Nueva");
            txtCambioContra.setEchoChar('\0');
            cursiveFontinPF(txtCambioContra);
            txtCambioContra.setForeground(Color.GRAY);
        }
        if (c2.equals("")){
            txtConfCamContra.setText("Confirmar Contraseña");
            txtConfCamContra.setEchoChar('\0');
            cursiveFontinPF(txtConfCamContra);
            txtConfCamContra.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txtTarjetaMouseClicked

    private void tblVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVuelosMouseClicked
        //Primero, necesito obtener las coordenadas de la columna donde el usuario hace click
        //para posteriormente calcular cual es la columna a la que se le hace click
        columna = tblVuelos.getColumnModel().getColumnIndexAtX(evt.getX());
        //Ya teniendo la columna, necesito las coordenadas de la fila dividiendo la coordenada del click
        //entre la altura de las filas de la tabla que me da como resultado la fila a la que se le hace click
        fila = evt.getY()/tblVuelos.getRowHeight();
        
        //Aquí se comprueba que el índice de la columna esté entre 0 y el número total de columnas, al igual que pasa con las filas
        if(columna <= tblVuelos.getColumnCount() && columna >= 0 && fila <= tblVuelos.getRowCount() && fila >= 0){
            //Aquí obtengo el valor de la celda (por filas y columnas), que obtengo el valor de la celda
            Object objeto = tblVuelos.getValueAt(fila, columna);
            // y aquí comparo que si ese objeto que está ubicado en la celda es un botton, se pasa a la pestaña para reservar el asiento
            if (objeto instanceof JButton){
                JOptionPane.showMessageDialog(null, "Aquí se abre el avion");
            }
        }
    }//GEN-LAST:event_tblVuelosMouseClicked

    //AQUÍ SE HACE TODO LO CORRESPONDIENTE CUANDO EL USUARIO LE DE CLICK A ALGUNA OPCIÓN EN EL JCOMBOBOX
    private void comboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrdenarActionPerformed
        int op = comboOrdenar.getSelectedIndex();
        actualizarTabla(op);
    }//GEN-LAST:event_comboOrdenarActionPerformed
    
    //AQUÍ SE ACTUALIZA LA TABLA AL MOMENTO DE SELECCIONAR UN BOTÓN PARA ORDENARLA SEGUN LAS PREFERENCIAS DLE USUARIO
    private void actualizarTabla(int op){
        //Creo una matriz llamada ids que es la que va a tener los encabezados de las columnas de las tablas
        String ids[] ={"Aereolinea","Origen", "Destino", "Horario", "Business", "Eco Premium", "Economico", "Estado Vuelo", "¿Reservas?"};
        tb.setColumnIdentifiers(ids); //Aquí se establece los encabezados en la tabla
        tblVuelos.setModel(tb);//Y por último, como las tablas se basan en modelos, debemos añadir dicho modelo
        
        //Estas variables son las que van a almacenar los datos de las tablas
        String aereolinea, origen, destino, horario, estadoVuelo;
        int business, ecoPremium, eco;
        btnReservar.setText("Reservar");
        //DEFINIR EL HORARIO
        horario = "h";
        
        //Creo este nuevo arrayList que es el que va a tener los filtos que el usuario quiera poner. Este arrayList es clonado del de listaVuelos
        ArrayList<Vuelo> posBus = new ArrayList<>();
        posBus = (ArrayList<Vuelo>) AgenciaDeViajes.Agencia.listaVuelos.clone();
        
        if (op == 0){
            //Aquí reinicio la tabla para que pueda volver a dibujarse con datos nuevos
            eliminarDatosTabla(tblVuelos);
            
            actualizarDatosTabla(posBus, op, 0);
        }
        else{
            if (op == 1){
                //FALTA DEFINIR EL HORARIO
                actualizarDatosTabla(posBus, op, 0);
            }
            else{
                if (op == 2){
                    //TARIFA BUSINESS
                    eliminarDatosTabla(tblVuelos);
                    actualizarDatosTabla(posBus, op, 1);
                }
                else{
                    if (op == 3){
                        //TARIFA ECO PREMIUM
                        eliminarDatosTabla(tblVuelos);
                        actualizarDatosTabla(posBus, op, 32);
                    }
                    else{
                        if (op == 4){
                            //TARIFA ECO PREMIUM
                            eliminarDatosTabla(tblVuelos);
                            actualizarDatosTabla(posBus, op, 75);
                        }
                    }
                }
            }
        }
    }
    
    private void eliminarDatosTabla(JTable tabla){
        DefaultTableModel vacio = (DefaultTableModel) tabla.getModel();
        vacio.setRowCount(0);
    }
    
    private void actualizarDatosTabla(ArrayList<Vuelo> posBus, int op, int posAsiento){
        //Estas variables son las que van a almacenar los datos de las tablas
        String aereolinea, origen, destino, horario, estadoVuelo;
        int business, ecoPremium, eco;
        btnReservar.setText("Reservar");
        //DEFINIR EL HORARIO
        horario = "h";
        
        if (op>= 2){
            //Aquí lo se que hace es comparar los distintos vuelos dependiendo de la tarifa
            Collections.sort(posBus, new Comparator<Vuelo>(){
                @Override
                public int compare(Vuelo v1, Vuelo v2){
                    return Integer.compare(v1.getAsientos()[posAsiento].getTarifa(), v2.getAsientos()[posAsiento].getTarifa());
                }
            });
        }
        
        //Como es la opción sin filtro, todo se deja igual y se capturan los datos para posteriormente mostrarlos en la interfase
        for (int i=0; i< AgenciaDeViajes.Agencia.listaVuelos.size(); i++){
            aereolinea = posBus.get(i).getAereolinea();
            origen = posBus.get(i).getOrigen();
            destino = posBus.get(i).getDestino();
            business = posBus.get(i).getAsientos()[1].getTarifa();
            ecoPremium = posBus.get(i).getAsientos()[32].getTarifa();
            eco = posBus.get(i).getAsientos()[75].getTarifa();

            if (posBus.get(i).getEstadoVuelo() == true){
                estadoVuelo = "Habilitado";
            }
            else{
                estadoVuelo = "No Disponible";
            }
            //Aquí añado los elementos a la tabla
            tb.addRow(new Object[]{ aereolinea, origen, destino, horario, business, ecoPremium, eco, estadoVuelo, btnReservar});
        }
        //Aquí estoy renderizando o mostrando el botón para la reserva
        this.tblVuelos.setDefaultRenderer(Object.class, new RenderBoton());
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
    private javax.swing.JLabel BGConfig;
    private javax.swing.JLabel BGSC;
    private javax.swing.JLabel BGinicio;
    private javax.swing.JPanel Config;
    private javax.swing.JPanel Inicio;
    private javax.swing.JPanel Reservas;
    private javax.swing.JToggleButton TbtnVisual1;
    private javax.swing.JToggleButton TbtnVisual2;
    private javax.swing.JPanel Vuelos;
    private javax.swing.JPanel absolutePanel;
    private javax.swing.JLabel backgraund;
    private javax.swing.JPanel barraButtons;
    private javax.swing.JButton btnEditAddTarjet;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<String> comboOrdenar;
    private javax.swing.JPanel empresaLogo;
    private javax.swing.JLabel encabezado;
    private javax.swing.JLabel iconConfig;
    private javax.swing.JLabel iconHome;
    private javax.swing.JLabel iconLogOut;
    private javax.swing.JLabel iconReservas;
    private javax.swing.JLabel iconVuelos;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JLabel imgNombreAgencia;
    private javax.swing.JLabel imgSlogan;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane opciones;
    private javax.swing.JLabel shadowCS;
    private javax.swing.JLabel shadowConfig;
    private javax.swing.JLabel shadowHome;
    private javax.swing.JLabel shadowReservas;
    private javax.swing.JLabel shadowVuelos;
    private javax.swing.JTable tblVuelos;
    private javax.swing.JToggleButton tbtnConfig;
    private javax.swing.JToggleButton tbtnHome;
    private javax.swing.JToggleButton tbtnReservas;
    private javax.swing.JToggleButton tbtnVuelos;
    private javax.swing.JLabel topMove;
    private javax.swing.JPasswordField txtCambioContra;
    private javax.swing.JTextField txtCambioNombre;
    private javax.swing.JTextField txtCambioUserName;
    private javax.swing.JPasswordField txtConfCamContra;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JLabel txtShowUserName;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
