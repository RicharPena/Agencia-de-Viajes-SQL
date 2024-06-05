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
    private ArrayList<String> escalas;
    private String destino;
    //aquí iria la hora de salida
    //aquí iria la hora de llegada
    private boolean estadoVuelo;
    
    public Vuelo(int idVuelo, String aereolinea, String origen, ArrayList<String> escalas, String destino) {
        this.idVuelo = idVuelo;
        this.aereolinea = aereolinea;
        
        if (aereolinea.equals("Avianca")) {
            //BOEING 737-800
            //Avianca
            //Business class: 16
            //Premien Economy Class: 48
            //Economy Class: 102
            
            asientos = new Asiento[166];
            
            for (int i = 0; i < 166; i++) {
                if (i < 16) {
                    asientos[i] = new AsientoBusiness(i+1, false);
                } else {
                    if (i >= 16 && i < 64) {
                        asientos[i] = new AsientoEconomicoPremium(i+1, false);
                    } else {
                        if (i >= 64 && i < 166) {
                            asientos[i] = new AsientoEconomico(i+1, false);
                        }
                    }
                }
            }
            this.asientosDisponibles = 166;
        }
        else{
            if(aereolinea.equals("Fly Emirates")){
                //BOEING 777-200ER
                //Fly Emirates
                //Business class 32
                //Premium Economy Class: 42
                //Economy Class: 258
            
                asientos = new Asiento[332];
            
                for (int i = 0; i < 332; i++) {
                    if (i < 32) {
                        asientos[i] = new AsientoBusiness(i+1, false);
                    } else {
                        if (i >= 32 && i < 74) {
                            asientos[i] = new AsientoEconomicoPremium(i+1, false);
                        } else {
                            if (i >= 74 && i < 332) {
                                asientos[i] = new AsientoEconomico(i+1, false);
                            }
                        }
                    }
                }
            
                this.asientosDisponibles = 332;
            }
            else{
                if(aereolinea.equals("Latam Airlanes")){
                    //BOEING 767-300ER
                    //Latam Airlanes
                    //Business Class: 24
                    //Premium Economy Class: 30
                    //Economy Class: 156
                    
                    asientos = new Asiento[210];
                    
                    for (int i = 0; i < 210; i++) {
                        if (i < 24) {
                            asientos[i] = new AsientoBusiness(i+1, false);
                        } else {
                            if (i >= 24 && i < 54) {
                                asientos[i] = new AsientoEconomicoPremium(i+1, false);
                            } else {
                                if (i >= 54 && i < 210) {
                                    asientos[i] = new AsientoEconomico(i+1, false);
                                }
                            }
                        }
                    }
                    
                    this.asientosDisponibles = 332;
                }
            }
        }
        
        this.origen = origen;
        this.escalas = escalas;
        this.destino = destino;
        this.estadoVuelo = true;
    }
    
    public Vuelo(int idVuelo, String aereolinea, Asiento[] asientos, int asientosDisponibles, String origen, ArrayList<String> escalas, String destino, boolean estadoVuelo) {
        this.idVuelo = idVuelo;
        this.aereolinea = aereolinea;
        this.asientos = asientos;
        this.asientosDisponibles = asientosDisponibles;
        this.origen = origen;
        this.escalas = escalas;
        this.destino = destino;
        this.estadoVuelo = estadoVuelo;
    }

    //se cambió el tipo de dato de String a int, al igual que lo que va a devolver el metodo
    public void asignarAsiento(int idAsiento) {
        for (Asiento asiento : asientos) {
            if (asiento.getIdAsiento() == idAsiento) {
                asiento.setOcupado(true); //true para indicar que el asiento ya está tomado
                asientosDisponibles--;
            }
        }
    }

    //ESTE PUEDE SER UN BOOLEAN y se cambió de String a int
    public void liberarAsiento(int idAsiento) {
        for (Asiento asiento : asientos) {
            if (asiento.getIdAsiento() == idAsiento) {
                asiento.setOcupado(false); //false para indicar que el asiento ya está libre
                asientosDisponibles++;
            }
        }
    }

    /*Esta función verifica la distancia que hay entre la ciudad de origen y el destino
    tomando como referencia el vector (después en LA INTERFASE, SE VERIFICA QUE SI ES 0,
    SIGNIFICA QUE NO SE PUEDE TOMAR LA MISMA CIUDAD DE ORIGEN Y DESTINO) 
     */
    //funcion aquí si se le ve utilidad
    /*Esta función verificará si existe en un determinado vuelo, las ciudades de origen y destino
    que el usuario ha ingresado. La cuestión es que los vuelos son en 1 solo sentido, recorriendo
    el vector de izquierda a derecha (de 0 a 4) por lo que la ciudad de origen debe estar antes
    que la ciudad de destino
     */
    public boolean verificarEscalas(String origen, String destino) {
        for (int i = 0; i < 5; i++) {
            if (escalas.get(i).equals(origen)) {
                for (int j = i; j < 5; j++) {
                    if (escalas.get(j).equals(destino)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public Asiento[] getAsientos() {
        return asientos;
    }
    
    public int getIdVuelo() {
        return idVuelo;
    }
    
    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }
}
