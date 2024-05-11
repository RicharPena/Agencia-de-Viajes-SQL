/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import java.util.ArrayList;

/**
 *
 * @author Systema
 */
public class Vuelo {
    private int idVuelo;
    private String aereolinea;
    private ArrayList <Asiento> asientos = new ArrayList<Asiento>();
    private int asientosDisponibles;
    private String origen;
    private ArrayList <String> escalas = new ArrayList<String>();
    private String destino;
    //aquí iria la hora de salida
    //aquí iria la hora de llegada
    private String estadoVuelo;
    
    public boolean asignarAsiento(String idAsiento){
        //INSERT CODE HERE
        
        // solo para que se quite el error
        return true;
    }
    
    public void liberarAsiento(String idAsiento){
        //INSERT CODE HERE
    }
    
    
    
}
