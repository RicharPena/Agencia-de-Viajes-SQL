/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import AgenciaDeViajes.Agencia;
import AgenciaDeViajes.Vuelo;
import java.awt.Image;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Systema
 */
public class DisposeVuelos extends javax.swing.JFrame {

    /**
     * Creates new form DisposeVuelos
     */
    DefaultTableModel tb = new DefaultTableModel();
    
    public DisposeVuelos() {
        initComponents();
        actualizarDatosTabla(AgenciaDeViajes.Agencia.listaVuelos);
        this.setLocationRelativeTo(null);
        putImageinButton("/images/Back_Button_01.png",btnDevolver);
    }
    private void putImageinButton(String ruta, JButton btn){
        ImageIcon image = new ImageIcon(getClass().getResource(ruta));
        Icon imageIcon = new ImageIcon(image.getImage().getScaledInstance(btn.getWidth(), btn.getHeight(), Image.SCALE_SMOOTH));
        btn.setIcon(imageIcon);
    }
    
    private void actualizarDatosTabla(ArrayList<Vuelo> posBus){
        //Creo una matriz llamada ids que es la que va a tener los encabezados de las columnas de las tablas
        String ids[] ={"ID","Aereolinea","Origen", "Escalas", "Destino", "Fecha Salida", "Business", "Eco Premium", "Economico", "Estado Vuelo"};
        tb.setColumnIdentifiers(ids); //Aquí se establece los encabezados en la tabla
        tblVuelos.setModel(tb);//Y por último, como las tablas se basan en modelos, debemos añadir dicho modelo
        
        //Estas variables son las que van a almacenar los datos de las tablas
        String aereolinea, origen,escalas, destino, estadoVuelo;
        int idVuelo, business, ecoPremium, eco;
        LocalDate horario;
        
        //Como es la opción sin filtro, todo se deja igual y se capturan los datos para posteriormente mostrarlos en la interfase
        for (int i=0; i< AgenciaDeViajes.Agencia.listaVuelos.size(); i++){
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
            }
            else{
                estadoVuelo = "No Disponible";
            }
            //Aquí añado los elementos a la tabla
            tb.addRow(new Object[]{ idVuelo, aereolinea, origen, escalas, destino, horario, business, ecoPremium, eco, estadoVuelo});
        }
        //Aquí lo que se hace es cambiar el tamaño de las filas
        this.tblVuelos.setRowHeight(30);
        //Ocultar columna de idVuelo para que el usuario no lo vea
        ocultarColumna(tblVuelos,0);
    }
    
    public void ocultarColumna(JTable table, int columnIndex) {
        table.getColumnModel().getColumn(columnIndex).setMinWidth(0);
        table.getColumnModel().getColumn(columnIndex).setMaxWidth(0);
        table.getColumnModel().getColumn(columnIndex).setWidth(0);
        table.getColumnModel().getColumn(columnIndex).setPreferredWidth(0);
        table.getColumnModel().getColumn(columnIndex).setResizable(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVuelos = new javax.swing.JTable();
        btnEliminarVuelo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 36)); // NOI18N
        jLabel1.setText("Eliminar Vuelos");

        btnDevolver.setBorder(null);
        btnDevolver.setBorderPainted(false);
        btnDevolver.setContentAreaFilled(false);
        btnDevolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(364, 364, 364))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDevolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

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
        jScrollPane1.setViewportView(tblVuelos);

        btnEliminarVuelo.setText("ELIMINAR VUELO");
        btnEliminarVuelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVuelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarVueloMouseClicked(evt);
            }
        });
        btnEliminarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarVuelo)
                .addGap(429, 429, 429))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnEliminarVuelo)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        dispose();
        Admin admin = new Admin();
        admin.setVisible(true);
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnEliminarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVueloActionPerformed
        // TODO add your handling code here:
        // Este método corresponde a cuando queremos pagar, básicamente debemos seleccionar una fila y después darle al botón de pagar
        //Y dependiendo de si el usuario tiene registrada una targeta o no, se tomarán las debidas acciones
        int [] selectedRows = tblVuelos.getSelectedRows();
        
        ArrayList <Integer> selectedFilas = new ArrayList <>();
        
        for(int selectedRow:selectedRows){
            selectedFilas.add(selectedRow);
        }
        if(selectedFilas.isEmpty()){
            
        }else{
            for(int selectedRow:selectedFilas){
                int idVuelo=(int)tblVuelos.getValueAt(selectedRow,0);
                Agencia.eliminarVuelo(idVuelo,0);
            }
            actualizarDatosTabla(AgenciaDeViajes.Agencia.listaVuelos);
        }
    }//GEN-LAST:event_btnEliminarVueloActionPerformed

    private void btnEliminarVueloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarVueloMouseClicked
        //NADA
    }//GEN-LAST:event_btnEliminarVueloMouseClicked

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
            java.util.logging.Logger.getLogger(DisposeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisposeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisposeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisposeVuelos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisposeVuelos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnEliminarVuelo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVuelos;
    // End of variables declaration//GEN-END:variables
}
