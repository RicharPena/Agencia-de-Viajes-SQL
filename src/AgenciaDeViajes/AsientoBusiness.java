/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

/**
 *
 * @author Systema
 */
public class AsientoBusiness extends Asiento{
    
    public AsientoBusiness(int idAsiento, boolean estado) {
        super(idAsiento, estado);
    }

    @Override
    public int calcularTarifa(int tarifaGeneral) {
        //Lo que se hace aquí es hacer un casting de float, que pasa de long a int y redondea dependiendo de los decimales
        return (int) Math.round(tarifaGeneral*1.25);
    }
    
}
