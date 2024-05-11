/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

/**
 *
 * @author Systema
 */
public class Asiento {
    private int categoria;
    private String idAsiento;
    private boolean estado;

    public Asiento(int categoria, String idAsiento, boolean estado) {
        this.categoria = categoria;
        this.idAsiento = idAsiento;
        this.estado = estado;
    }
    
    public void calcularTarifa(){
        //INSERT CODE HERE
    }
    
    //Este es el mismo setEstado
    public void cambiarEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    public int getCategoria() {
        return categoria;
    }

    public String getIdAsiento() {
        return idAsiento;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setIdAsiento(String idAsiento) {
        this.idAsiento = idAsiento;
    }
}
