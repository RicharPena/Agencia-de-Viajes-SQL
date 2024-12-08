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
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String userName;
    private String password;
    private String nombre;
    private String direccion;
    private String correo;
    private String apellido;
    private String cedula;
    private ArrayList<Reserva> listaReserva = new ArrayList<>();
    private String tarjeta=null;
    
    //Este constructor es alternativo
    public Usuario(String nombre, String userName, String password, String tarjeta, ArrayList<Reserva> listaReserva, String direccion, String correo, String apellido, String cedula) {
        this.userName = userName;
        this.password = password;
        this.nombre = nombre;
        this.tarjeta = tarjeta;
        this.listaReserva = listaReserva;
        this.direccion = direccion;
        this.correo = correo;
        this.apellido = apellido;
        this.cedula = cedula;
    }
    
    //Este constructor crea como tal a todos los usuarios
    public Usuario(String nombre,String userName,String password, String direccion, String correo, String apellido, String cedula){
        this.userName=userName;
        this.password=password;
        this.nombre=nombre;
        this.direccion=direccion;
        this.correo=correo;
        this.apellido=apellido;
        this.cedula=cedula;
    }
    
    //Este método verifica que el userName coincida con su respectiva contraseña
    public boolean login(String userName, String password){
        if (this.userName.equals(userName)){
            if (this.password.equals(password)){
                return true;
            }
        }
        return false;
        //return this.userName.equals(userName) && this.password.equals(password);
    }
    
    //Aquí se crean las reservas dependiendo del vuelo y de la lista de asientos que el usuario haya escogido en el panel de Vuelos
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
    
    //Aquí se cancela la reserva dependiendo del id que se escoja en la interfase
    public void cancelarReserva(int idReserva){
        listaReserva.get(idReserva-1).eliminarAsientos(listaReserva.get(idReserva-1).getAsientos());
        
        listaReserva.remove(idReserva-1);
        
        actualizarReservas();
    }
    
    //cada vez que se realice un cambio en la reserva, debe ser cambiado
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

    public ArrayList<Reserva> getListaReserva() {
        return listaReserva;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    
}
