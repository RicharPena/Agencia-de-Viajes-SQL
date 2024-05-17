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
        //Discutir el tema de las aereolineas (cuantas van a ser)
        //Por ejemplo, la de United tiene 166 pasajeros (asientos)
        if (aereolinea.equals("Avianca")){
            //BOEING 737-800
            //Business class: 16
            //Premien Economy Class: 48
            //Economy Class: 102
            asientos = new Asiento[166];
            asientosDisponibles = 166;
            for (int i=0; i<166; i++){
                if (i<16){
                    asientos[i]=new Asiento(1,i,true);
                }
                else{
                    if (i>=16 && i<64){
                        asientos[i]=new Asiento(2,i,true);
                    }
                    else{
                        if (i>=64 && i<166){
                            asientos[i]=new Asiento(3,i,true);
                        }
                    }
                }
            }
        }
        else{
            if (aereolinea.equals("Fly Emirates")){
                //BOEING 777-200ER
                //Business class 34
                //Premium Economy Class: 40
                //Economy Class: 258
                asientos = new Asiento[330];
                asientosDisponibles = 330;
                for (int i=0; i<330; i++){
                    if (i<34){
                        asientos[i]=new Asiento(1,i,true);
                    }
                    else{
                        if (i>=34 && i<74){
                            asientos[i]=new Asiento(2,i,true);
                        }
                        else{
                            if (i>=74 && i<330){
                                asientos[i]=new Asiento(3,i,true);
                            }
                        }
                    }
                }
            }
            else{
                if (aereolinea.equals("Latam")){
                    //BOEING 767-300ER
                    //Business Class: 24
                    //Premium Economy Class: 30
                    //Economy Class: 157
                    asientos = new Asiento[211];
                    asientosDisponibles = 211;
                    for (int i=0; i<211; i++){
                        if (i<24){
                            asientos[i]=new Asiento(1,i,true);
                        }
                        else{
                            if (i>=24 && i<54){
                                asientos[i]=new Asiento(2,i,true);
                            }
                            else{
                                if (i>=54 && i<211){
                                    asientos[i]=new Asiento(3,i,true);
                                }
                            }
                        }
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
