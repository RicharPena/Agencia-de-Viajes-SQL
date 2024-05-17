/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import java.util.ArrayList;

/**
 *
 * @author Systema
 * 
 * Se modificó la relación de los asientos en la Reserva, debido a que puede un usuario tener varios asientos
 * Se eliminó los métodos setAsiento y getAsiento
 * Se añadió un nuevo método llamado agregarAsientos
 * Se añadió un nuevo método llamado eliminarAsientos
 */
public class Reserva {
    private String idReserva; //idReserva va con String porque el usuario le puede dar un nombre
    private Vuelo vuelo;
    private ArrayList<Asiento> asientos = new ArrayList<Asiento>();
    //fecha que deberia ser de tipo date
    private boolean pago;

    
    public Reserva(String idReserva,int idVuelo, String aereolinea, String origen, String destino, String estadoVuelo){
        this.idReserva = idReserva;
        vuelo = new Vuelo(idVuelo,aereolinea, origen, destino, estadoVuelo);
        asientos.add(vuelo.asignarAsiento(0));//POR AHORA QUEDA CON 0, YA QUE ESO SE DEFINE CON LA INTERFACE GRÁFICA
    }
    
    //Con la interfase, se elije el idAsiento
    public void agregarAsientos(int idAsiento){
        asientos.add(vuelo.asignarAsiento(idAsiento));
    }
    
    //Con la interfase, se elije el idAsiento
    public boolean eliminarAsiento(int idAsiento){
        vuelo.liberarAsiento(idAsiento); //ESTO PUEDE CAMBIAR SI CAMBIA EL METODO A BOOLEAN
        
        for ( Asiento asiento:asientos){
            if (asiento.getIdAsiento() == idAsiento){
                if (asientos.remove(asiento)){
                    return true;
                }//aquí estoy eliminando el asiento de la reserva
            }
        }
        return false;
    }
    
    public String getIdReserva() {
        return idReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public boolean getPago() {
        return pago;
    }
    
}
