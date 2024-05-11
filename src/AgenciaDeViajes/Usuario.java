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
public class Usuario {
    private String userName;
    private String password;
    private String nombre;
    private ArrayList<Reserva> listaReserva = new ArrayList<Reserva>();
    private String tarjeta;
    //no existe lista boletos porque ya tenemos la reserva que actua como la de boletos
    
    //INSERT CONSTRUCTOR HERE
    
    
    public boolean login(String userName, String password){
        
        //POR AHORA
        return true;
    }
    
    public void pagoBoleto(){
        //INSERT CODE HERE
    }
    
    public void crearReserva(){
        //INSER CODE HERE
    }
    
    public void cancelarReserva(){
        //INSERT CODE HERE
    }
    
    
    public String getame() {
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

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }
    
    
    
}
