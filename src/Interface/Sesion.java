/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AgenciaDeViajes.Agencia;
import AgenciaDeViajes.Base_de_Datos;
import AgenciaDeViajes.Vuelo;
import Tipografias.Fuentes;
import java.awt.Color;
import java.awt.Image;
import java.text.Normalizer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    DefaultTableModel tb = new DefaultTableModel();
    DefaultTableModel tbr = new DefaultTableModel();
    //Con el fin de guardar la columna y la fila donde está ubicado el botón de registro
    private int columna, fila;
    
    public Sesion(int op) {
        initComponents();
        setLocationRelativeTo(null);
        putImageInJL("/Images/logo_agencia_002.png", imgLogo);
        putImageInJL("/Images/nombreAgencia_002.png", imgNombreAgencia);
        putImageInJL("/Images/slogan_002.png", imgSlogan);
        titleFont(txtShowUserName);
        txtShowUserName.setText(AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getNombre());
        
        if(op==0){
            tbtnHome.setEnabled(false);
            shadowHome.setVisible(true);
            shadowVuelos.setVisible(false);
            shadowReservas.setVisible(false);
            shadowConfig.setVisible(false);
            shadowCS.setVisible(false);
            opciones.setSelectedIndex(0);
        }else{
            if(op==1){
                tbtnVuelos.setEnabled(false);
                shadowVuelos.setVisible(true);
                shadowHome.setVisible(false);
                shadowReservas.setVisible(false);
                shadowConfig.setVisible(false);
                shadowCS.setVisible(false);
                opciones.setSelectedIndex(1);
            }else{
                tbtnReservas.setEnabled(false);
                shadowReservas.setVisible(true);
                shadowHome.setVisible(false);
                shadowVuelos.setVisible(false);
                shadowConfig.setVisible(false);
                shadowCS.setVisible(false);
                opciones.setSelectedIndex(2);
            }
        }
        
        //A partir de aquí se inicia el panel de configuración
        parametroJTextFiel(txtCambioNombre);
        parametroJTextFiel(txtCambioUserName);
        parametroJTextFiel(txtTarjeta);
        parametroJTextFiel(txtDireccion);
        parametroJTextFiel(txtCorreo);
        parametroJTextFiel(txtApellido);
        parametroJTextFiel(txtCedula);
        
        if (AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getTarjeta() == null){
            //El textField queda así, sin nada.
        }
        else{
            txtTarjeta.setText(AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getTarjeta());
        }
        
        parametroJPassword(txtCambioContra);
        parametroJPassword(txtConfCamContra);
        
        //Antes de iniciar todas las tablas, debo comprobar la fecha de los vuelos
        comprobarFecha();
        
        //A partir de aquí se inicia el panel de Vuelos
        actualizarTablaVuelos(0);
        
        //A partir de aquí se inicia el panel de Reservas
        actualizarTablaReservas();
        
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
        jLabel.setFont(tipoFuente.fuente(tipoFuente.ITROMATRIC,0,48));
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
    
    private void comprobarFecha(){
        LocalDate fechaActual = LocalDate.now();
        for (Vuelo vuelo : AgenciaDeViajes.Agencia.listaVuelos){
            if (fechaActual.isBefore(vuelo.getFechaSalida())){
                if(vuelo.getAsientosDisponibles()==0){
                    
                }else{
                    vuelo.setEstadoVuelo(true);
                }
            }
            else{
                if (fechaActual.isAfter(vuelo.getFechaSalida())){
                    vuelo.setEstadoVuelo(false);
                    Agencia.eliminarVuelo(vuelo.getIdVuelo());
                }
                else{
                    vuelo.setEstadoVuelo(true);
                }
            }
        }
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
        jpanelFiltro = new javax.swing.JPanel();
        comboOrdenar = new javax.swing.JComboBox<>();
        destinotxt = new javax.swing.JTextField();
        origentxt = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtOrigin = new javax.swing.JLabel();
        txtDestino = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnReservar = new javax.swing.JButton();
        Reservas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        btnEditarReserva = new javax.swing.JButton();
        btnPagarReserva = new javax.swing.JButton();
        Config = new javax.swing.JPanel();
        txtCambioNombre = new javax.swing.JTextField();
        txtCambioUserName = new javax.swing.JTextField();
        txtCambioContra = new javax.swing.JPasswordField();
        txtConfCamContra = new javax.swing.JPasswordField();
        txtTarjeta = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
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

        txtShowUserName.setBackground(new java.awt.Color(88, 88, 88));
        txtShowUserName.setFont(new java.awt.Font("Maiandra GD", 0, 58)); // NOI18N
        txtShowUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtShowUserName.setOpaque(true);
        Inicio.add(txtShowUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, 440, 60));

        BGinicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Panelnicio2.png"))); // NOI18N
        BGinicio.setToolTipText("");
        Inicio.add(BGinicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 804, 590));

        opciones.addTab("Inicio", Inicio);

        Vuelos.setBackground(new java.awt.Color(255, 255, 255));
        Vuelos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblVuelos = new javax.swing.JTable(){
            public boolean isCellEditable(int fila, int colum){
                return false;
            }
        };
        tblVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        tblVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVuelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblVuelos);

        Vuelos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 800, 420));

        jpanelFiltro.setBackground(new java.awt.Color(153, 153, 255));
        jpanelFiltro.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordenar por"));
        jpanelFiltro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        comboOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrar Todos", "Horario", "Tarifa Business", "Tarifa Eco Premium", "Tarifa Economica", "Estado Vuelo" }));
        comboOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboOrdenarActionPerformed(evt);
            }
        });
        jpanelFiltro.add(comboOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 220, 20));

        destinotxt.setToolTipText("");
        destinotxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinotxtActionPerformed(evt);
            }
        });
        jpanelFiltro.add(destinotxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 190, 30));

        origentxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                origentxtActionPerformed(evt);
            }
        });
        jpanelFiltro.add(origentxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 190, 30));

        btnBuscar.setText("Buscar");
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jpanelFiltro.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 85, 30));

        txtOrigin.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        txtOrigin.setText("Origen");
        jpanelFiltro.add(txtOrigin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 77, 28));

        txtDestino.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        txtDestino.setText("Destino");
        jpanelFiltro.add(txtDestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 77, 28));

        Vuelos.add(jpanelFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 540, 110));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("Todos nuestros vuelos");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel3.setText("se encuentran aquí:");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        Vuelos.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 120));

        btnReservar.setText("Reservar");
        btnReservar.setToolTipText("");
        btnReservar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        Vuelos.add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 120, 30));

        opciones.addTab("Vuelos", Vuelos);

        Reservas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel2.setText("Todas sus Reservas se encuentran aquí: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        Reservas.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 580, 70));

        jPanel4.setBackground(new java.awt.Color(124, 0, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        Reservas.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 230, 70));

        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        tblReservas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReservasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblReservas);

        Reservas.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, -1));

        btnEditarReserva.setText("Editar");
        btnEditarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarReservaActionPerformed(evt);
            }
        });
        Reservas.add(btnEditarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 140, 50));

        btnPagarReserva.setText("Pagar");
        btnPagarReserva.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPagarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarReservaActionPerformed(evt);
            }
        });
        Reservas.add(btnPagarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 120, 50));

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
        Config.add(txtCambioNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 730, 30));

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
        Config.add(txtCambioUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 730, 30));

        txtCambioContra.setText("Contraseña Nueva");
        txtCambioContra.setBorder(null);
        txtCambioContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCambioContraMouseClicked(evt);
            }
        });
        txtCambioContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCambioContraActionPerformed(evt);
            }
        });
        Config.add(txtCambioContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 300, 30));

        txtConfCamContra.setText("Confirmar Contraseña");
        txtConfCamContra.setBorder(null);
        txtConfCamContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtConfCamContraMouseClicked(evt);
            }
        });
        Config.add(txtConfCamContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 300, 30));

        txtTarjeta.setText("Agregar / Cambiar Tarjeta");
        txtTarjeta.setBorder(null);
        txtTarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTarjetaMouseClicked(evt);
            }
        });
        Config.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 340, 30));

        txtCorreo.setText("Nuevo Correo Electronico");
        txtCorreo.setBorder(null);
        txtCorreo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCorreoMouseClicked(evt);
            }
        });
        Config.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 370, 340, 30));

        txtApellido.setText("Nuevo Apellido");
        txtApellido.setBorder(null);
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtApellidoMouseClicked(evt);
            }
        });
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        Config.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 360, 30));

        txtDireccion.setText("Nueva Dirección");
        txtDireccion.setBorder(null);
        txtDireccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDireccionMouseClicked(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        Config.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 360, 30));

        txtCedula.setText("Nueva Cedula");
        txtCedula.setBorder(null);
        txtCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCedulaMouseClicked(evt);
            }
        });
        Config.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 440, 340, 30));

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
        Config.add(TbtnVisual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, -1));

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
        Config.add(TbtnVisual2, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, -1, -1));

        btnEditAddTarjet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnEdit-Addtarjet.png"))); // NOI18N
        btnEditAddTarjet.setToolTipText("");
        btnEditAddTarjet.setBorder(null);
        btnEditAddTarjet.setBorderPainted(false);
        btnEditAddTarjet.setContentAreaFilled(false);
        btnEditAddTarjet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditAddTarjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAddTarjetActionPerformed(evt);
            }
        });
        Config.add(btnEditAddTarjet, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 226, 56));

        btnSaveChanges.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btnSaveChanges.png"))); // NOI18N
        btnSaveChanges.setBorder(null);
        btnSaveChanges.setBorderPainted(false);
        btnSaveChanges.setContentAreaFilled(false);
        btnSaveChanges.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSaveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangesActionPerformed(evt);
            }
        });
        Config.add(btnSaveChanges, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 226, 56));

        txtMensaje.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        txtMensaje.setForeground(new java.awt.Color(255, 51, 51));
        Config.add(txtMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 730, 30));

        BGConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/BGPanelConfig New.png"))); // NOI18N
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
        //NADA
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
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtCambioNombre.getText(), "nombre", Interface.Inicio.posicionUsuario);
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
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtCambioUserName.getText(), "usuario", Interface.Inicio.posicionUsuario);
            }
        }
        
        if (txtDireccion.getText().equals("Nueva Dirección")){
            //NADA
        }
        else{
            if (txtDireccion.getText().equals("")){
                txtMensaje.setText("No se ha escrito ninguna Dirección!!!");
                timer.start();
            }
            else{
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setDireccion(txtDireccion.getText());
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtDireccion.getText(), "direccion", Interface.Inicio.posicionUsuario);
            }
        }
        
        if (txtCorreo.getText().equals("Nuevo Correo Electronico")){
            //NADA
        }
        else{
            if (txtCorreo.getText().equals("")){
                txtMensaje.setText("No se ha escrito ningún Correo!!!");
                timer.start();
            }
            else{
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setCorreo(txtCorreo.getText());
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtCorreo.getText(), "correo", Interface.Inicio.posicionUsuario);
            }
        }
        
        if (txtApellido.getText().equals("Nuevo Apellido")){
            //NADA
        }
        else{
            if (txtApellido.getText().equals("")){
                txtMensaje.setText("No se ha escrito ningún Apellido!!!");
                timer.start();
            }
            else{
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setApellido(txtApellido.getText());
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtApellido.getText(), "apellido", Interface.Inicio.posicionUsuario);
            }
        }
        
        if (txtCedula.getText().equals("Nueva Cedula")){
            //NADA
        }
        else{
            if (txtCedula.getText().equals("")){
                txtMensaje.setText("No se ha escrito ninguna Cédula!!!");
                timer.start();
            }
            else{
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setCedula(txtCedula.getText());
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtCedula.getText(), "cedula", Interface.Inicio.posicionUsuario);
            }
        }
        
        if (c1.equals("Contraseña Nueva") && c2.equals("Confirmar Contraseña")){
            //NADA
        }
        else{
            if (c1.equals(c2)){
                AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).setPassword(c1);
                Base_de_Datos.configuracionUsuarios(Agencia.con, c1, "contrasena", Interface.Inicio.posicionUsuario);
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
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtTarjeta.getText(), "tarjeta", Interface.Inicio.posicionUsuario);
            }
            else{
                txtMensaje.setText("Tarjeta Inválida");
                timer.start();
            }
        }
        
        if (txtCambioUserName.getText().equals("Nuevo User Name") && txtCambioNombre.getText().equals("Nuevo Nombre") && c1.equals("Contraseña Nueva") && c2.equals("Confirmar Contraseña") && txtTarjeta.getText().equals("Agregar / Cambiar Tarjeta") && txtDireccion.getText().equals("Nueva Dirección") && txtCorreo.getText().equals("Nuevo Correo Electronico") && txtApellido.getText().equals("Nuevo Apellido") && txtCedula.getText().equals("Nueva Cedula")){
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

    
    //EL BLOQUE DE CÓDIGO SIGUIENTE TIENE COMO PROPOSITO CAMBIAR LAS LETRAS Y PONERLAS DEPENDIENDO DE SI EL USUARIO SALE DE UN TEXTFIELD E INGRESA A OTRO.
    //EN TOTAL SON 8 FUNCIONES DE AQUÍ PARA ABAJO
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
        if (txtDireccion.getText().equals("")){
            txtDireccion.setText("Nueva Dirección");
            cursiveFontinTF(txtDireccion);
            txtDireccion.setForeground(Color.GRAY);
        }
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
        if (txtDireccion.getText().equals("")){
            txtDireccion.setText("Nueva Dirección");
            cursiveFontinTF(txtDireccion);
            txtDireccion.setForeground(Color.GRAY);
        }
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
        if (txtDireccion.getText().equals("")){
            txtDireccion.setText("Nueva Dirección");
            cursiveFontinTF(txtDireccion);
            txtDireccion.setForeground(Color.GRAY);
        }
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
        if (txtDireccion.getText().equals("")){
            txtDireccion.setText("Nueva Dirección");
            cursiveFontinTF(txtDireccion);
            txtDireccion.setForeground(Color.GRAY);
        }
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
                Base_de_Datos.configuracionUsuarios(Agencia.con, txtTarjeta.getText(), "tarjeta", Interface.Inicio.posicionUsuario);
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
        if (txtDireccion.getText().equals("")){
            txtDireccion.setText("Nueva Dirección");
            cursiveFontinTF(txtDireccion);
            txtDireccion.setForeground(Color.GRAY);
        }
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
        //NADA
    }//GEN-LAST:event_tblVuelosMouseClicked

    //AQUÍ SE HACE TODO LO CORRESPONDIENTE CUANDO EL USUARIO LE DE CLICK A ALGUNA OPCIÓN EN EL JCOMBOBOX
    private void comboOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboOrdenarActionPerformed
        int op = comboOrdenar.getSelectedIndex();
        actualizarTablaVuelos(op);
    }//GEN-LAST:event_comboOrdenarActionPerformed

    private void tblReservasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReservasMouseClicked
        //NADA
    }//GEN-LAST:event_tblReservasMouseClicked

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed
        // Obtener el número de filas seleccionadas
        int selectedRowCount = tblVuelos.getSelectedRowCount();
    
        if (selectedRowCount == 1) {
            // Obtener la fila seleccionada
            int selectedRow = tblVuelos.getSelectedRow();
        
            // Obtener el valor de la primera columna como String y luego convertirlo a Integer
            int idVuelo = (int)tblVuelos.getValueAt(selectedRow,0);
        
            // Verificar si el vuelo ya está reservado
            if (Agencia.vueloRepetido(Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario), Agencia.listaVuelos.get(idVuelo - 1))) {
                JOptionPane.showMessageDialog(null, "El vuelo ya está reservado", "VUELO REPETIDO", JOptionPane.INFORMATION_MESSAGE);
            } else {
                if(!Agencia.listaVuelos.get(idVuelo-1).getEstadoVuelo()){
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un vuelo disponible", "VUELO NO DISPONIBLE", JOptionPane.WARNING_MESSAGE);
                }else{
                    // Obtener el nombre de la aerolínea de la segunda columna
                    String aerolinea = (String) tblVuelos.getValueAt(selectedRow, 1);

                    // Cerrar la ventana actual
                    this.dispose();

                    // Abrir la ventana correspondiente según la aerolínea
                    if (aerolinea.equals("Avianca")){
                        Avianca aereo = new Avianca(idVuelo-1,-1);
                        aereo.setVisible(true);
                    }else{
                        if (aerolinea.equals("Fly Emirates")){
                            FlyEmirates aereo = new FlyEmirates(idVuelo-1,-1);
                            aereo.setVisible(true);
                        }else{
                            LatamAirlanes aereo = new LatamAirlanes(idVuelo-1,-1);
                            aereo.setVisible(true);
                        }
                    }
                }
            }
        } else {
            // Mostrar un mensaje si no hay ninguna fila seleccionada o si hay más de una fila seleccionada
            if (selectedRowCount == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione un vuelo de la tabla", "SELECCIÓN REQUERIDA", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione solo un vuelo", "MULTIPLE SELECCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnEditarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarReservaActionPerformed
        // Obtener el número de filas seleccionadas
        int selectedRowCount = tblReservas.getSelectedRowCount();
    
        if (selectedRowCount == 1) {
            // Obtener la fila seleccionada
            int selectedRow = tblReservas.getSelectedRow();
            // Obtener el valor del idReserva de la primera columna
            int idReserva = (int) tblReservas.getValueAt(selectedRow, 0);
            // Obtener el valor del idVuelo de la segunda columna
            int idVuelo = (int)tblReservas.getValueAt(selectedRow,1);
            // Obtener el nombre de la aerolínea de la tercera columna
            String aerolinea = (String) tblReservas.getValueAt(selectedRow, 2);
            
            // Cerrar la ventana actual
            this.dispose();
                
            // Abrir la ventana correspondiente según la aerolínea
            if (aerolinea.equals("Avianca")){
                Avianca aereo = new Avianca(idVuelo-1,idReserva-1);
                aereo.setVisible(true);
            }else{
                if (aerolinea.equals("Fly Emirates")){
                    FlyEmirates aereo = new FlyEmirates(idVuelo-1,idReserva-1);
                    aereo.setVisible(true);
                }else{
                    LatamAirlanes aereo = new LatamAirlanes(idVuelo-1,idReserva-1);
                    aereo.setVisible(true);
                }
            }
        } else {
            // Mostrar un mensaje si no hay ninguna fila seleccionada o si hay más de una fila seleccionada
            if (selectedRowCount == 0) {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione una reserva de la tabla", "SELECCIÓN REQUERIDA", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Por favor, seleccione solo una reserva", "MULTIPLE SELECCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarReservaActionPerformed

    private void btnPagarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarReservaActionPerformed
        // Este método corresponde a cuando queremos pagar, básicamente debemos seleccionar una fila y después darle al botón de pagar
        //Y dependiendo de si el usuario tiene registrada una targeta o no, se tomarán las debidas acciones
        int [] selectedRows = tblReservas.getSelectedRows();
        
        ArrayList <Integer> selectedFilas = new ArrayList <>();
        
        for(int selectedRow:selectedRows){
            selectedFilas.add(selectedRow);
        }
        if(selectedFilas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, seleccione una reserva de la tabla", "SELECCIÓN REQUERIDA", JOptionPane.WARNING_MESSAGE);
        }else{
            for(int selectedRow:selectedFilas){
                int idReserva=(int)tblReservas.getValueAt(selectedRow,0);
                if(Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).pagarReserva(idReserva)){
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Por favor, agregue una tarjeta de crédito válida", "TARJETA REQUERIDA", JOptionPane.WARNING_MESSAGE);
                }
            }
            actualizarTablaReservas();
        }
    }//GEN-LAST:event_btnPagarReservaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        actualizarTablaVuelos(6);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void origentxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_origentxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_origentxtActionPerformed

    private void destinotxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinotxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_destinotxtActionPerformed

    private void txtCambioContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCambioContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCambioContraActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtDireccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDireccionMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtDireccion.getText().equals("Nueva Dirección")){
            txtDireccion.setText("");
            normalFontinTF(txtDireccion);
            txtDireccion.setForeground(Color.BLACK);
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
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
    }//GEN-LAST:event_txtDireccionMouseClicked

    private void txtCorreoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCorreoMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtCorreo.getText().equals("Nuevo Correo Electronico")){
            txtCorreo.setText("");
            normalFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.BLACK);
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
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
    }//GEN-LAST:event_txtCorreoMouseClicked

    private void txtApellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtApellido.getText().equals("Nuevo Apellido")){
            txtApellido.setText("");
            normalFontinTF(txtApellido);
            txtApellido.setForeground(Color.BLACK);
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
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtCedula.getText().equals("")){
            txtCedula.setText("Nueva Cedula");
            cursiveFontinTF(txtCedula);
            txtCedula.setForeground(Color.GRAY);
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
    }//GEN-LAST:event_txtApellidoMouseClicked

    private void txtCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCedulaMouseClicked
        String c1 = new String(txtCambioContra.getPassword());
        String c2 = new String(txtConfCamContra.getPassword());
        
        if (txtCedula.getText().equals("Nueva Cedula")){
            txtCedula.setText("");
            normalFontinTF(txtCedula);
            txtCedula.setForeground(Color.BLACK);
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
        if (txtCorreo.getText().equals("")){
            txtCorreo.setText("Nuevo Correo Electronico");
            cursiveFontinTF(txtCorreo);
            txtCorreo.setForeground(Color.GRAY);
        }
        if (txtApellido.getText().equals("")){
            txtApellido.setText("Nuevo Apellido");
            cursiveFontinTF(txtApellido);
            txtApellido.setForeground(Color.GRAY);
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
    }//GEN-LAST:event_txtCedulaMouseClicked
    
    //**************************************************************************************************************************************************************************
    //AQUÍ SE ACTUALIZA LA TABLA DE VUELOS AL MOMENTO DE SELECCIONAR UN BOTÓN PARA ORDENARLA SEGUN LAS PREFERENCIAS DLE USUARIO
    private void actualizarTablaVuelos(int op){
        //Creo una matriz llamada ids que es la que va a tener los encabezados de las columnas de las tablas
        String ids[] ={"ID","Aereolinea","Origen", "Escalas", "Destino", "Fecha Salida", "Business", "Eco Premium", "Economico", "Estado Vuelo"};
        tb.setColumnIdentifiers(ids); //Aquí se establece los encabezados en la tabla
        tblVuelos.setModel(tb);//Y por último, como las tablas se basan en modelos, debemos añadir dicho modelo
        
        //Creo este nuevo arrayList que es el que va a tener los filtos que el usuario quiera poner. Este arrayList es clonado del de listaVuelos
        ArrayList<Vuelo> posBus = new ArrayList<>();
        posBus = (ArrayList<Vuelo>) AgenciaDeViajes.Agencia.listaVuelos.clone();
        
        //Aquí reinicio la tabla para que pueda volver a dibujarse con datos nuevos
        eliminarDatosTabla(tblVuelos);
        if (op == 0){
            actualizarDatosTabla(posBus, op, 0);
        }
        else{
            if (op == 1){
                //ORGANIZACIÓN POR HORARIO
                actualizarDatosTabla(posBus, op, 0);
            }
            else{
                if (op == 2){
                    //TARIFA BUSINESS DE MENOR A MAYOR
                    actualizarDatosTabla(posBus, op, 1);
                }
                else{
                    if (op == 3){
                        //TARIFA ECO PREMIUM DE MENOR A MAYOR
                        actualizarDatosTabla(posBus, op, 32);
                    }
                    else{
                        if (op == 4){
                            //TARIFA ECO PREMIUM DE MENOR A MAYOR
                            actualizarDatosTabla(posBus, op, 75);
                        }
                        else{
                            if(op == 5){
                                //ORGANIZACIÓN POR ESTADO VUELO
                                actualizarDatosTabla(posBus, op, 0);
                            }else{
                                actualizarDatosTabla(posBus,op,0);
                            }
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
        String aereolinea, origen,escalas, destino, estadoVuelo;
        int idVuelo, business, ecoPremium, eco;
        LocalDate horario;
        
        if (op>= 2 && op<5){
            //Aquí lo se que hace es comparar los distintos vuelos dependiendo de la tarifa
            Collections.sort(posBus, new Comparator<Vuelo>(){
                @Override
                public int compare(Vuelo v1, Vuelo v2){
                    // el Integer.compare compara dos enteros que dependiendo de cual es mayor o menor, lo pondrá primero en el vector
                    return Integer.compare(v1.getAsientos()[posAsiento].calcularTarifa(v1.getTarifaGeneral()), v2.getAsientos()[posAsiento].calcularTarifa(v2.getTarifaGeneral()));
                }
            });
        }
        else{
            if (op == 1){
                //Aquí se comparan las fechas
                Collections.sort(posBus, new Comparator<Vuelo>(){
                    @Override
                    public int compare(Vuelo v1, Vuelo v2){
                        //el .compareTo devuelve los valores específicos para ver en el vector cual va primero
                        return v1.getFechaSalida().compareTo(v2.getFechaSalida());
                    }
                });
            }
            else{
                if (op  == 5){
                    //Aquí se compara el estado del vuelo
                    Collections.sort(posBus, new Comparator<Vuelo>(){
                        @Override
                        public int compare(Vuelo v1, Vuelo v2){
                            // Comparar por estadoVuelo primero
                            if (v1.getEstadoVuelo() != v2.getEstadoVuelo()) {
                                /*El "? valorSiEsVerdadero : valorSiEsFalso" es un operador ternario, que nos permite
                                realizar una diferenciación rápida entre si el valor es verdadero, se pondrá el valor de -1 y si es
                                falso, se pondrá el valor de 1. Esto es así porque el método sort de Collections toma estos valores:
                                
                                -1 : Si debe aparecer antes que otroVuelo
                                0 : Si los valores son iguales, por lo que no importa moverlos
                                1: Si debe aparecer después que otroVuelo
                                */
                                return v1.getEstadoVuelo() ? -1 : 1; // Vuelos con estado true vienen primero
                            }
                            // Si estadoVuelo es igual, no pasa nada
                            return v1.getEstadoVuelo() ? 0: 0;
                        }
                    });
                }else{
                    if(op==6){
                        //Aquí se filtra por origen y destino
                        String origin = origentxt.getText();
                        String destiny = destinotxt.getText();
                        if(origin.equals("")){
                            if(destiny.equals("")){
                                
                            }else{
                                posBus.clear();
                                for(Vuelo vuelo : Agencia.listaVuelos){
                                    if(normalizeString(vuelo.getDestino()).contains(normalizeString(destiny))){
                                        posBus.add(vuelo);
                                    }
                                }
                            }
                        }else{
                            posBus.clear();
                            if(destiny.equals("")){
                                for(Vuelo vuelo : Agencia.listaVuelos){
                                    if(normalizeString(vuelo.getOrigen()).contains(normalizeString(origin))){
                                        posBus.add(vuelo);
                                    }
                                }
                            }else{
                                for(Vuelo vuelo : Agencia.listaVuelos){
                                    if(normalizeString(vuelo.getOrigen()).contains(normalizeString(origin)) && normalizeString(vuelo.getDestino()).contains(normalizeString(destiny))){
                                        posBus.add(vuelo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        //Como es la opción sin filtro, todo se deja igual y se capturan los datos para posteriormente mostrarlos en la interfase
        
        if(posBus.isEmpty()){
            
        }else{
            for (int i=0; i< posBus.size(); i++){
                idVuelo = posBus.get(i).getIdVuelo();
                aereolinea = posBus.get(i).getAereolinea();
                escalas = posBus.get(i).toStringescalas();
                origen = posBus.get(i).getOrigen();
                destino = posBus.get(i).getDestino();
                business = posBus.get(i).getAsientos()[1].calcularTarifa(posBus.get(i).getTarifaGeneral());//Saco la tarifa para el asiento en la posición 1 (business)
                ecoPremium = posBus.get(i).getAsientos()[32].calcularTarifa(posBus.get(i).getTarifaGeneral());//Saco la tarifa para el asiento en la posición 32 (economico premium)
                eco = posBus.get(i).getAsientos()[75].calcularTarifa(posBus.get(i).getTarifaGeneral());//Saco la tarifa para el asiento en la posición 75 (economico)
                horario = posBus.get(i).getFechaSalida();//Extraigo la fecha de salida del vuelo
                
                //Aquí verifico si el estadoVuelo es true o si todavía hay asientos disponibles para reservar
                if (posBus.get(i).getEstadoVuelo()){
                    estadoVuelo = "Habilitado";
                    //Aquí añado los elementos a la tabla
                    tb.addRow(new Object[]{ idVuelo, aereolinea, origen, escalas, destino, horario, business, ecoPremium, eco, estadoVuelo});
                }
                else{
                    estadoVuelo = "No Disponible";
                }
            }
        }
        //Aquí lo que se hace es cambiar el tamaño de las filas
        this.tblVuelos.setRowHeight(30);
        //Ocultar columna de idVuelo para que el usuario no lo vea
        ocultarColumna(tblVuelos,0);
    }
    
    //***********************************************************************************************************************************************************
    //AQUÍ SE EMPIEZA A TRABAJAR CON LA TABLA DE RESERVAS
    
    private void actualizarTablaReservas(){
        
        eliminarDatosTabla(tblReservas);
        //Creo una matriz llamada ids que es la que va a tener los encabezados de las columnas de las tablas
        String ids[] ={"ID Reserva","ID Vuelo","Aereolinea", "Origen","Escalas","Destino","Fecha Salida", "PagoTotal","Asientos","Estado"};
        tbr.setColumnIdentifiers(ids); //Aquí se establece los encabezados en la tabla
        tblReservas.setModel(tbr);//Y por último, como las tablas se basan en modelos, debemos añadir dicho modelo
        
        int idReserva,idVuelo,pagoTotal;
        String estadoPago;
        String aerolinea;
        String origen;
        String escalas;
        String destino;
        String asientos;
        LocalDate fechaSalida;
        
        //Aquí se carga toda la información de las reservas para posteriormente mostrarlas
        for (int i=0; i < AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().size(); i++){
            idReserva = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getIdReserva();
            idVuelo = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getVuelo().getIdVuelo();
            aerolinea = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getVuelo().getAereolinea();
            origen = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getVuelo().getOrigen();
            escalas = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getVuelo().toStringescalas();
            destino = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getVuelo().getDestino();
            fechaSalida = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getVuelo().getFechaSalida();
            pagoTotal = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getPagoTotal();
            asientos = AgenciaDeViajes.Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).toStringAsientos();
            
            if(Agencia.listaUsuarios.get(Interface.Inicio.posicionUsuario).getListaReserva().get(i).getPago()){
                estadoPago="Pagado";
            }else{
                estadoPago="No Pagado";
            }
            tbr.addRow(new Object[]{idReserva,idVuelo,aerolinea,origen,escalas,destino,fechaSalida,pagoTotal,asientos,estadoPago});
        }
        //Aquí lo que se hace es cambiar el tamaño de las filas
        this.tblReservas.setRowHeight(30);
        //Ocultar columna de idReserva
        ocultarColumna(tblReservas,0);
        //Ocultar columna de idVuelo
        ocultarColumna(tblReservas,1);
    }
    
    //Esta funcion normaliza los string
    public static String normalizeString(String chain) {
        // Convertir a minúsculas
        String normalized = chain.toLowerCase();

        // Eliminar caracteres especiales usando expresión regular
        
        // Aquí se reemplazan á, é, etc. por a, e, respectivamente
        normalized = Normalizer.normalize(normalized, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("[^a-zA-Z0-9 ]", ""); // eliminar caracteres especiales como $/%7&

        return normalized;
    }
    
    //esta función nos permite ocultar la columna de idReserva o de idVuelo, debido a que se necesita trabajar con la misma pero que el usuario
    //no vea su existencia
    public void ocultarColumna(JTable table, int columnIndex) {
        table.getColumnModel().getColumn(columnIndex).setMinWidth(0);
        table.getColumnModel().getColumn(columnIndex).setMaxWidth(0);
        table.getColumnModel().getColumn(columnIndex).setWidth(0);
        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(0);
        table.getColumnModel().getColumn(columnIndex).setResizable(false);
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
                new Sesion(0).setVisible(true);
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
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditAddTarjet;
    private javax.swing.JButton btnEditarReserva;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnPagarReserva;
    private javax.swing.JButton btnReservar;
    private javax.swing.JButton btnSaveChanges;
    private javax.swing.JComboBox<String> comboOrdenar;
    private javax.swing.JTextField destinotxt;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanelFiltro;
    private javax.swing.JTabbedPane opciones;
    private javax.swing.JTextField origentxt;
    private javax.swing.JLabel shadowCS;
    private javax.swing.JLabel shadowConfig;
    private javax.swing.JLabel shadowHome;
    private javax.swing.JLabel shadowReservas;
    private javax.swing.JLabel shadowVuelos;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTable tblVuelos;
    private javax.swing.JToggleButton tbtnConfig;
    private javax.swing.JToggleButton tbtnHome;
    private javax.swing.JToggleButton tbtnReservas;
    private javax.swing.JToggleButton tbtnVuelos;
    private javax.swing.JLabel topMove;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtCambioContra;
    private javax.swing.JTextField txtCambioNombre;
    private javax.swing.JTextField txtCambioUserName;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JPasswordField txtConfCamContra;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JLabel txtDestino;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JLabel txtMensaje;
    private javax.swing.JLabel txtOrigin;
    private javax.swing.JLabel txtShowUserName;
    private javax.swing.JTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
