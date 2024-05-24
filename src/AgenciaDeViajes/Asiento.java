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
    private boolean estado;
    
    public Asiento(int idAsiento, boolean estado) {
        this.idAsiento = idAsiento;
        this.estado = estado;
    }
    
    public abstract void calcularTarifa();
    
    //Este es el mismo setEstado
    public void cambiarEstado(boolean estado) {
        this.estado = estado;
    }
    
    

    public int getIdAsiento() {
        return idAsiento;
    }

    public boolean isEstado() {
        return estado;
    }

    

    public void setIdAsiento(int idAsiento) {
        this.idAsiento = idAsiento;
    }
}
