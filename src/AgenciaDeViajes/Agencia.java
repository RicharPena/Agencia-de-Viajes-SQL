/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import Interface.Inicio;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        //ESTO SOLO ES PARA CREAR VUELOS Y CUENTAS DE PRUEBA
        String[]ciudades1={""};
        ArrayList<String>escalas1=new ArrayList<>(Arrays.asList(ciudades1));
        String[]ciudades2={"Madrid","Paris"};
        ArrayList<String>escalas2=new ArrayList<>(Arrays.asList(ciudades2));
        LocalDate fecha1 = LocalDate.of(2024, 9, 8), fecha2 = LocalDate.of(2024, 7, 5);
        
        
        Vuelo vuelo1 = new Vuelo("Avianca", "Cartagena",escalas1,"Boyaca", 650000, fecha1);
        Vuelo vuelo2 = new Vuelo("Fly Emirates", "Bogota", escalas2, "Munich", 500000, fecha2);
        Usuario usuario1 = new Usuario("Richar", "Richar", "123");
        
        listaUsuarios.add(usuario1);
        listaVuelos.add(vuelo1);
        listaVuelos.add(vuelo2);
        
        actualizarIDVuelo();
        
        String archivoVuelos = "Vuelos.dat", archivoUsuarios = "Usuarios.dat";
        File fileVuelos  = new File(archivoVuelos);
        File fileUsuarios = new File(archivoUsuarios);
        if (fileVuelos.exists()){
            cargarDesdeArchivoVuelos(archivoVuelos);
        }
        else{
            guardarEnArchivos(listaVuelos, archivoVuelos);
        }
        
        if (fileUsuarios.exists()){
            cargarDesdeArchivoUsuarios(archivoUsuarios);
        }
        else{
            guardarEnArchivos(listaUsuarios, archivoUsuarios);
        }
        Inicio inicio=new Inicio();
        
        inicio.setVisible(true);
    }
    
    public static void actualizarIDVuelo(){
        for(int i=0;i<listaVuelos.size();i++){
            listaVuelos.get(i).setIdVuelo(i+1);
        }
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
    
    public static boolean asientoOcupadoPorOtroUsuario(int posVuelo, int posAsiento, Usuario usuarioActual) {
        Vuelo vuelo = listaVuelos.get(posVuelo);
        
        for (Usuario usuario : listaUsuarios) {
            if (!usuario.equals(usuarioActual)) {
                for (Reserva reserva : usuario.getListaReserva()) {
                    if (reserva.getVuelo().equals(vuelo)) {
                        if (reserva.getAsientos().contains(posAsiento + 1)) {
                            return true;
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
    
    public static void guardarEnArchivos(ArrayList guardarLista, String nombre){
        try (FileOutputStream fileOut = new FileOutputStream(nombre);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

           out.writeObject(guardarLista);
           System.out.println("Guardado de archivos hecho correctamente.");

       } catch (IOException i) {
           i.printStackTrace();
       }
    }
    
    public static void cargarDesdeArchivoVuelos(String nombre){
        try (FileInputStream fileIn = new FileInputStream(nombre);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {

           ArrayList<Vuelo> listaVuelosLeida = (ArrayList<Vuelo>) in.readObject();
           listaVuelos = listaVuelosLeida;
           System.out.println("Archivo Vuelos cargado correctamente.");
           // Aquí puedes usar el objeto listaVuelosLeida

       } catch (IOException | ClassNotFoundException i) {
           i.printStackTrace();
       }
    }
    
    public static void cargarDesdeArchivoUsuarios(String nombre){
        try (FileInputStream fileIn = new FileInputStream(nombre);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {

           ArrayList<Usuario> listaUsuarioLeida = (ArrayList<Usuario>) in.readObject();
           listaUsuarios = listaUsuarioLeida;
           System.out.println("Archivo Usuario cargado correctamente.");
           // Aquí puedes usar el objeto listaVuelosLeida

       } catch (IOException | ClassNotFoundException i) {
           i.printStackTrace();
       }
    }
}
