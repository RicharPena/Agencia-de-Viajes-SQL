/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interface;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Systema
 */

/*ESTA CLASE NOS PERMITE RENDERIZAR LOS OBJETOS (CUALQUIERA) QUE QUERRAMOS AÑADIR A LA TABLA
YA QUE COMO TAL, SI AÑADIMOS UN BOTÓN, DICHO BOTÓN ESTARÁ EN LA TABLA PERO NO TENDRÁ APARIENCIA DE BOTÓN
POR LO QUE ESTA CLASE SE ENCARGA DE RENDERIZARLO Y MOSTRARLO EN PANTALLA
*/
public class RenderBoton extends DefaultTableCellRenderer{
    
    //ESTE MÉTODO PERMITE DIBUJAR EL "CONTROL" O SU ESTRUCTURA VISUAL
    @Override
    public Component getTableCellRendererComponent(JTable table, Object objeto, boolean isSelected, boolean hasFocus, int row, int column) {
        if (objeto instanceof JButton){
            return (JButton)objeto;
        }
        
        return super.getTableCellRendererComponent(table, objeto, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
