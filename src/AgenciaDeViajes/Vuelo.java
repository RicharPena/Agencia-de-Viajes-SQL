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

//BOEING 737-800
            //Business class: 16
            //Premien Economy Class: 48
            //Economy Class: 102
//BOEING 777-200ER
                //Business class 34
                //Premium Economy Class: 40
                //Economy Class: 258
//BOEING 767-300ER
                    //Business Class: 24
                    //Premium Economy Class: 30
                    //Economy Class: 157

public class Vuelo {
    private int idVuelo;
    private String aereolinea;
    private Asiento asientos[];
    private int asientosDisponibles;
    private String origen;
    private ArrayList <String> escalas = new ArrayList<String>();
    private String destino;
    //aquí iria la hora de salida
    //aquí iria la hora de llegada
    private String estadoVuelo;
    
    public Vuelo (int id,String aereolinea, String origen, String destino, String estadoVuelo){
        idVuelo = id;
        this.aereolinea = aereolinea;
        asientos = new Asiento[166];
        asientosDisponibles = 166;
        for (int i=0; i<166; i++){
            if (i<16){
                asientos[i]=new AsientoBusiness(i,true);
            }
            else{
                if (i>=16 && i<64){
                    asientos[i]=new AsientoEconomicoPremium(i,true);
                }
                else{
                    if (i>=64 && i<166){
                        asientos[i]=new AsientoEconomico(i,true);
                    }
                }
            }
        }
        this.origen = origen;
        //POR DEFINIR LA PARTE DE ESCALAS
        this.destino = destino;
        this.estadoVuelo = estadoVuelo;
    }
    
    //se cambió el tipo de dato de String a int, al igual que lo que va a devolver el metodo
    public Asiento asignarAsiento(int idAsiento){
        for (Asiento asiento:asientos){
            if (asiento.getIdAsiento() == idAsiento){
                asiento.cambiarEstado(false); //false para indicar que el asiento ya está tomado
                return asiento;
            }
        }
        
        return null;
    }
    
    //ESTE PUEDE SER UN BOOLEAN y se cambió de String a int
    public void liberarAsiento(int idAsiento){
       for (Asiento asiento:asientos){
            if (asiento.getIdAsiento() == idAsiento){
                asiento.cambiarEstado(true); //TRUE para indicar que el asiento ya está libre
            }
        }
    }

    public Asiento[] getAsientos() {
        return asientos;
    }
    
    
}
