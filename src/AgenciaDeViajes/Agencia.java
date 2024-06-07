/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import Interface.Inicio;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Systema
 * Se creó el método buscarReservas
 * 
 * Se creará un vector de ciudades (unas 20 ciudades), dependiendo de la ciudad de llegada o de partida, se tomará
 * las posiciones de de ambos, se restarán y se tomará el valor absoluto de ellos. Este valor será un multiplicador
 * de un precio fijo (sea por ejemplo 95 mil o 100 mil) y así se decidirá el valor del vuelo.
 * 
 * 
 */
public class Agencia {
    public static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    public static ArrayList<Vuelo> listaVuelos = new ArrayList<>();
    public static void main(String [] args){
        String[]ciudades={};
        ArrayList<String>escalas=new ArrayList<>(Arrays.asList(ciudades));
        
        
        Vuelo vuelo1 = new Vuelo(1, "Avianca", "Cartagena",escalas,"Boyaca");
        Usuario usuario1 = new Usuario("Richar", "Richar", "123", null, null);
        
        listaUsuarios.add(usuario1);
        listaVuelos.add(vuelo1);
        
        Inicio inicio=new Inicio();
        
        inicio.setVisible(true);
    }
    
    public static boolean asientoOcupado(Vuelo vuelo, int asiento) {
        for (Usuario usuario : Agencia.listaUsuarios) {
            for (Reserva reserva : usuario.getListaReserva()) {
                if (reserva.getVuelo().equals(vuelo)) {
                    for (int as : reserva.getAsientos()) {
                        if (as == asiento) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean vueloRepetido(Usuario user,Vuelo vuelo){
        boolean repetido=false;
        
        for(Reserva reserva:user.getListaReserva()){
            if(reserva.getVuelo().getIdVuelo()==vuelo.getIdVuelo()){
                repetido=true;
            }
        }
        
        return repetido;
    }
    
    public static boolean asientoOcupadoPorOtroUsuario(Vuelo vuelo, int asiento, Usuario usuario) {
        for(Usuario u : listaUsuarios){
            if(!u.equals(usuario)){
                for(Reserva reserva : u.getListaReserva()){
                    if(reserva.getVuelo().equals(vuelo)){
                        for(int as : reserva.getAsientos()){
                            if (as == asiento && vuelo.getAsientos()[asiento-1].getOcupado()){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public static void actualizarVuelos(){
        for(Vuelo vuelo:listaVuelos){
            for(Usuario usuario:listaUsuarios){
                for(Reserva reserva:usuario.getListaReserva()){
                    if(reserva.getVuelo().getIdVuelo()==vuelo.getIdVuelo()){
                        reserva.setVuelo(vuelo);
                    }
                }
            }
        }
    }
}
