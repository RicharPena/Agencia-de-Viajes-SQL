/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

/**
 *
 * @author Systema
 */
public class Reserva {
    private String idReserva;
    private Vuelo vuelo;
    private Asiento asiento;
    //fecha que deberia ser de tipo date
    
    //INSERT CONSTRUCTOR HERE
    
    public String getIdReserva() {
        return idReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
    
    
}
