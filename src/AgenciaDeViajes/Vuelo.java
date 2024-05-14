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
    private int cont = 0; //SU ÚNICO PROPÓSITO ES LLEVAR EL CONTEO DEL ID DEL VUELO
    private int cont1 = 0; //SU PROÓSITO ES LLEVAR EL CONTEO DE LAS SILLAS (ID) DE LAS AEREOLINEAS
    
    public Vuelo (String aereolinea, String origen, String destino, String estadoVuelo){
        idVuelo = cont;
        this.aereolinea = aereolinea;
        //Discutir el tema de las aereolineas (cuantas van a ser)
        //Por ejemplo, la de United tiene 166 pasajeros (asientos)
        if (aereolinea.equals("Avianca")){
            //BOEING 737-800
            //Business class: 16
            //Premien Economy Class: 48
            //Economy Class: 102
            asientos = new Asiento[166];
            for (int i=0; i<166; i++){
                if (i<16){
                    asientos[i].setCategoria(1);
                    asientos[i].setIdAsiento(cont1);
                    asientos[i].cambiarEstado(true);
                    cont1++;
                }
                else{
                    if (i>=16 && i<64){
                        asientos[i].setCategoria(2);
                        asientos[i].setIdAsiento(cont1);
                        asientos[i].cambiarEstado(true);
                        cont1++;
                    }
                    else{
                        if (i>=64 && i<166){
                            asientos[i].setCategoria(3);
                            asientos[i].setIdAsiento(cont1);
                            asientos[i].cambiarEstado(true);
                            cont1++;
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
                for (int i=0; i<166; i++){
                    if (i<16){
                        asientos[i].setCategoria(1);
                        asientos[i].setIdAsiento(cont1);
                        asientos[i].cambiarEstado(true);
                        cont1++;
                    }
                    else{
                        if (i>=16 && i<64){
                            asientos[i].setCategoria(2);
                            asientos[i].setIdAsiento(cont1);
                            asientos[i].cambiarEstado(true);
                            cont1++;
                        }
                        else{
                            if (i>=64 && i<166){
                                asientos[i].setCategoria(3);
                                asientos[i].setIdAsiento(cont1);
                                asientos[i].cambiarEstado(true);
                                cont1++;
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
                    for (int i=0; i<166; i++){
                        if (i<16){
                            asientos[i].setCategoria(1);
                            asientos[i].setIdAsiento(cont1);
                            asientos[i].cambiarEstado(true);
                            cont1++;
                        }
                        else{
                            if (i>=16 && i<64){
                                asientos[i].setCategoria(2);
                                asientos[i].setIdAsiento(cont1);
                                asientos[i].cambiarEstado(true);
                                cont1++;
                            }
                            else{
                                if (i>=64 && i<166){
                                    asientos[i].setCategoria(3);
                                    asientos[i].setIdAsiento(cont1);
                                    asientos[i].cambiarEstado(true);
                                    cont1++;
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
        
        cont++;
    }
    
    public boolean asignarAsiento(String idAsiento){
        //INSERT CODE HERE
        
        // solo para que se quite el error
        return true;
    }
    
    public void liberarAsiento(String idAsiento){
        //INSERT CODE HERE
    }
    
    
    
}
