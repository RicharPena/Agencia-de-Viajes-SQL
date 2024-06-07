/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

/**
 *
 * @author Systema
 */
public abstract class Asiento {
    /*Para la categoría se tiene lo siguiente:
    1. Business
    2. Premium Economic Class
    3. Economic Class
    */
    private int idAsiento; //Se cambió de String a int
    private boolean ocupado;//para estado 
    
    public Asiento(int idAsiento, boolean estado) {
        this.idAsiento = idAsiento;
        this.ocupado = estado;
    }
    
    //Este es el mismo setEstado
    
    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }
    
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public int getIdAsiento() {
        return idAsiento;
    }

    public boolean getOcupado() {
        return ocupado;
    }
    
    public abstract int calcularTarifa();
}
