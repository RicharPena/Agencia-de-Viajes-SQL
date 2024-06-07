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
    private int idReserva; //idReserva va con String porque el usuario le puede dar un nombre
    private Vuelo vuelo;
    private ArrayList<Integer> asientos = new ArrayList<>();
    //fecha que deberia ser de tipo date
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
    
    //Con la interfase, se elije el idAsiento
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
    
    //Con la interfase, se elije el idAsiento
    public boolean eliminarAsientos(ArrayList<Integer>asientos){
        if(asientos.isEmpty()){
            return false;
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
            if(this.asientos.isEmpty()){
                return true;
            }
            else{
                return false;
            }
        }
    }
    
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
