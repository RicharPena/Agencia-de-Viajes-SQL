/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Systema
 * 
 * 
 */
public class Reserva implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int idReserva;
    private Vuelo vuelo;
    private ArrayList<Integer> asientos = new ArrayList<>();
    private boolean pago;

    //CONSTRUCTOR DE RESERVA PARA INICIALIZAR RESERVAS QUE YA HAY
    public Reserva(int idReserva, Vuelo vuelo, ArrayList<Integer>asientos, boolean pago){
        this.idReserva=idReserva;
        this.vuelo=vuelo;
        this.asientos=asientos;
        this.pago=pago;
    }
    
    //CONSTRUCTOR DE RESERVA PARA CREAR NUEVAS RESERVAS
    public Reserva(int idReserva,Vuelo vuelo, ArrayList<Integer>asientos){
        this.idReserva=idReserva;
        for(int i=0;i<asientos.size();i++){
            Agencia.listaVuelos.get(vuelo.getIdVuelo()-1).asignarAsiento(asientos.get(i));
        }
        this.vuelo=Agencia.listaVuelos.get(vuelo.getIdVuelo()-1);
        this.asientos=asientos;
        Agencia.actualizarVuelos();
    }
    
    //Con la interfase, se elije el idAsiento y se agrega directamente a los vuelos y también a la lista de asientos que tiene el usuario en la reserva
    public void agregarAsientos(ArrayList<Integer>asientos){
        if(asientos.isEmpty()){
            
        }else{
            for(int i=0;i<asientos.size();i++){
                Agencia.listaVuelos.get(vuelo.getIdVuelo()-1).asignarAsiento(asientos.get(i));
            }
            this.vuelo=Agencia.listaVuelos.get(vuelo.getIdVuelo()-1);
            
            for(int i=0;i<asientos.size();i++){
                this.asientos.add(asientos.get(i));
            }
            Agencia.actualizarVuelos();
        }
    }
    
    //Con la interfase, se elimina que el usuario escogió ese asiento en la reserva y  en la lista de vuelos general, además de que se actualiza los vuelos.
    public void eliminarAsientos(ArrayList<Integer>asientos){
        if(asientos.isEmpty()){
            
        }
        else{
            for(int i=0;i<asientos.size();i++){
                Agencia.listaVuelos.get(vuelo.getIdVuelo()-1).liberarAsiento(asientos.get(i));
            }
            this.vuelo=Agencia.listaVuelos.get(vuelo.getIdVuelo()-1);
            for(int i=0;i<this.asientos.size();i++){
                for(int j=0;j<asientos.size();j++){
                    if(this.asientos.get(i).equals(asientos.get(j))){
                        this.asientos.remove(i);
                    }
                }
            }
            Agencia.actualizarVuelos();
        }
    }
    
    //Aquí se verifica cuanto dinero se debe por la cantidad de asientos reservados
    public int getPagoTotal(){
        int pagoTotal=0;
        
        for(Integer asiento : this.asientos){
            pagoTotal+=vuelo.getAsientos()[asiento-1].calcularTarifa(vuelo.getTarifaGeneral());
        }
        
        return pagoTotal;
    }
    
    public String toStringAsientos(){
        String sits="";
        
        for(int i=0;i<asientos.size();i++){
            if(i==asientos.size()-1){
                sits+=Integer.toString(asientos.get(i));
            }else{
                sits+=Integer.toString(asientos.get(i))+", ";
            }
        }
        
        return sits;
    }
    
    //MÉTODOS GETTER Y SETTER
    public int getIdReserva() {
        return idReserva;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }
    
    public ArrayList<Integer> getAsientos() {
        return asientos;
    }
    
    public boolean getPago() {
        return pago;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    public void setAsientos(ArrayList<Integer> asientos) {
        this.asientos = asientos;
    }
    
    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
