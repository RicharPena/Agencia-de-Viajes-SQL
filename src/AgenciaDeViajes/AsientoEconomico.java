/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

/**
 *
 * @author Systema
 */
public class AsientoEconomico extends Asiento{
    
    public AsientoEconomico(int idAsiento, boolean estado) {
        super(idAsiento, estado);
    }

    @Override
    public int calcularTarifa(int tarifaGeneral) {
        //Este si queda igual, ya que esta es la base para los demás
        return tarifaGeneral;
    }
    
}
