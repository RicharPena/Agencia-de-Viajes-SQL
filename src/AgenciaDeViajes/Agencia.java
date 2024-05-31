/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import Interface.Inicio;
import java.util.ArrayList;

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
    
    public static void main(String [] args){
        
        ArrayList <Reserva> listaReserva = new ArrayList<>();
        
        Vuelo vuelo1 = new Vuelo(1, "Avianca", "Cartagena", "Bogota", "Prueba");
        Usuario usuario1 = new Usuario("Richar", "Richar", "123", null, listaReserva);
        
        listaUsuarios.add(usuario1);
        
        Inicio inicio=new Inicio();
        
        inicio.setVisible(true);
    }
    
    public static Reserva buscarReservas(){
        //En el main, luego de seleccionar la reserva, se debe guardar el objeto de la reserva
        //ya que posteriormente se va a pasar a un metodo de usuario y se corroborará
        return null;
    }
    
}
