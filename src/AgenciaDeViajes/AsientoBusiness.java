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
    public int calcularTarifa() {
        return 0;
    }
    
}
