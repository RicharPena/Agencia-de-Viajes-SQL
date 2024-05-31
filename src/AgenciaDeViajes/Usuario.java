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
 * Se modificó el tipo de retorno al método cancelarReserva y se le añadió un parámetro
 */
public class Usuario {
    private String userName;
    private String password;
    private String nombre;
    private ArrayList<Reserva> listaReserva = new ArrayList<>();
    private String tarjeta;
    //no existe lista boletos porque ya tenemos la reserva que actua como la de boletos
    
    //INSERT CONSTRUCTOR HERE
    
    //PARA CUANDO DECIDE AÑADIR LA TARJETA
    public Usuario(String nombre, String userName, String password, String tarjeta, ArrayList<Reserva> listaReserva) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.listaReserva = listaReserva;
    }
    
    
    
    public boolean login(String userName, String password){
        if (this.userName.equals(userName)){
            if (this.password.equals(password)){
                return true;
            }
        }
        return false;
    }
    
    //Se modificó los parámetros
    public void pagoBoleto(String nombreReserva, String tarjeta){
        Reserva reserva = Agencia.buscarReservas();
        
        if (reserva != null){
            if (tarjeta.length() == 10){
                reserva.setPago(true);
            }
        }
    }
    
    public void crearReserva(String idReserva,int idVuelo, String aereolinea, String origen, String destino, String estadoVuelo){
        listaReserva.add(new Reserva(idReserva,idVuelo, aereolinea, origen, destino, estadoVuelo));
    }
    
    //Se cambió de void a boolean
    public boolean cancelarReserva(String idReserva, Reserva reservaTomada){
        if (reservaTomada.getIdReserva().equals(idReserva)){
            listaReserva.remove(reservaTomada);
            return true;
        }
        return false;
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
        if (tarjeta.length() == 10){
            this.tarjeta = tarjeta;
            return true;
        }
        return false;
    }
    
    
    
}
