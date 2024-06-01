/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import Interface.Inicio;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
        
        Vuelo vuelo1 = new Vuelo(1, "Avianca", "Cartagena", "Boyaca", "Prueba");
        vuelo1.asignarEscalas("Cartagena", "Barranquilla", "Santa Marta", "Bogota", "Boyaca");
        Usuario usuario1 = new Usuario("Richar", "Richar", "123", null, null);
        
        listaUsuarios.add(usuario1);
        listaVuelos.add(vuelo1);
        
        for (Vuelo vuelo : listaVuelos){
            if (vuelo.verificarEscalas("Cartagena", "Bogota") == true){
                usuario1.crearReserva("Viaje a Bogota", 1, "Cartagena", "Bogota", 0);
                break;
            }
        }
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite 1"));
        if (op ==1 ){
            for (Reserva reserva: usuario1.getListaReserva()){
                if (reserva.getIdReserva().equals("Viaje a Bogota")){
                    reserva.agregarAsientos(1, 1);
                    break;
                }
            }
        }
        
        Inicio inicio=new Inicio();
        
        inicio.setVisible(true);
    }
    
    public static Reserva buscarReservas(){
        //En el main, luego de seleccionar la reserva, se debe guardar el objeto de la reserva
        //ya que posteriormente se va a pasar a un metodo de usuario y se corroborará
        return null;
    }
    
}
