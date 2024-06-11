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
 * Se modificó el tipo de retorno al método cancelarReserva y se le añadió un parámetro
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String password;
    private String nombre;
    private ArrayList<Reserva> listaReserva = new ArrayList<>();
    private String tarjeta=null;
    //no existe lista boletos porque ya tenemos la reserva que actua como la de boletos
    
    //INSERT CONSTRUCTOR HERE
    
    //PARA CUANDO SE LEAN LOS ARCHIVOS
    public Usuario(String nombre, String userName, String password, String tarjeta, ArrayList<Reserva> listaReserva) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.listaReserva = listaReserva;
    }
    
    public Usuario(String nombre,String userName,String password){
        this.userName=userName;
        this.password=password;
        this.nombre=nombre;
    }
    
    public boolean login(String userName, String password){
        if (this.userName.equals(userName)){
            if (this.password.equals(password)){
                return true;
            }
        }
        return false;
        //return this.userName.equals(userName) && this.password.equals(password);
    }
    
    public void crearReserva(Vuelo vuelo, ArrayList<Integer>asientos){
        int id;
        if(listaReserva.isEmpty()){
            id=0;
        }else{
            id=listaReserva.size();
        }
        
        if(asientos.isEmpty()){
            
        }else{
            listaReserva.add(new Reserva(id+1,vuelo,asientos));
        }
    }
    
    public void cancelarReserva(int idReserva){
        listaReserva.get(idReserva-1).eliminarAsientos(listaReserva.get(idReserva-1).getAsientos());
        
        listaReserva.remove(idReserva-1);
        
        actualizarReservas();
    }
    
    private void actualizarReservas(){
        if(listaReserva.isEmpty()){
            
        }else{
            for(int i=0;i<listaReserva.size();i++){
                listaReserva.get(i).setIdReserva(i+1);
            }
        }
    }
    
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Se modificó de void a boolean
    public boolean setTarjeta(String tarjeta) {
        if (tarjeta.length() == 10){//Condicion para que la tarjeta sea valida
            this.tarjeta = tarjeta;
            return true;
        }
        return false;
    }
    
    //Este metodo hace las veces de pagar la reserva
    public boolean pagarReserva(int idReserva){
        if(this.tarjeta!=null){
            listaReserva.get(idReserva-1).setPago(true);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean tieneReservaEnAsiento(Vuelo vuelo, int numeroAsiento) {
        for (Reserva reserva : listaReserva) {
            if (reserva.getVuelo().equals(vuelo) && reserva.getAsientos().contains(numeroAsiento)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }
}
