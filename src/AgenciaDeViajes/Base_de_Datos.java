/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Systema
 */
public class Base_de_Datos {
    private static Map<Integer, Vuelo> vuelosMap = new HashMap<>();
    private static Map<Integer, Usuario> usuariosMap = new HashMap<>();
    
    public static Connection conectar(String pass){
        String url = "jdbc:mysql://localhost:3306/agencia_de_viajes";
        String user = "root";
        
        Connection con=null;
        try{
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("CONEXIÓN EXITOSA");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

        return con;
    }
    
    public static void desconectar(Connection con){
        try{
            if (con != null && !con.isClosed()){
                con.close();
            }
        }
        catch (SQLException e){
            System.out.println("NO SE PUDO CERRAR LA CONEXION");
            e.printStackTrace();
        }
    }
    
    public static void CargarVuelos(Connection con){
        String query1 = "SELECT * FROM vuelos";
        String query2 = "SELECT vuelos.id, escalas.ciudad FROM escalasxvuelo JOIN escalas ON escalas.id = escalasxvuelo.id_escala JOIN vuelos ON vuelos.id = escalasxvuelo.id_vuelo;";
        String query3 = "SELECT asientos.id_vuelo, asientos.id_asiento AS idAsiento FROM asientos JOIN vuelos ON vuelos.id = asientos.id_vuelo;";
        
        try{
            PreparedStatement ps1 = con.prepareStatement(query1);
            PreparedStatement ps2 = con.prepareStatement(query2);
            PreparedStatement ps3 = con.prepareStatement(query3);
            
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs3 = ps3.executeQuery();
            
            //Aquí se llena la información de los vuelos menos el arrayList de las escalas
            while (rs1.next()){
                int id = rs1.getInt("id");
                String aereolinea = rs1.getString("aereolinea");
                //int asientos_disponibles = rs.getInt("asientos_disponibles");
                String origen = rs1.getString("origen");
                String destino = rs1.getString("destino");
                
                Date fsalida = rs1.getDate("fecha_salida");
                LocalDate fecha_salida = fsalida.toLocalDate();
                
                //int estado_vuelo = rs.getInt("estado_vuelo");
                int tarifa_general = rs1.getInt("tarifa_general");
                
                Vuelo vuelo = new Vuelo(aereolinea, origen, new ArrayList<>(), destino, tarifa_general, fecha_salida);
                //Solo hacen referencia al objeto como tal, no se "duplica" el objeto
                Agencia.listaVuelos.add(vuelo);
                vuelosMap.put(id, vuelo);
            }
            Agencia.actualizarIDVuelo();
            
            //Aquí se llena los arrayList de las escalas de los distintos vuelos
            while (rs2.next()){
                int id = rs2.getInt("id");
                String ciudad = rs2.getString("ciudad");
                
                Vuelo vuelo = vuelosMap.get(id);
                if (vuelo != null){
                    vuelo.getEscalas().add(ciudad);
                }
                
                /* este método también puede servir, pero es mejor el HashMap
                for (Vuelo vuelo : Agencia.listaVuelos ){
                    if (vuelo.getIdVuelo() == id){
                        vuelo.getEscalas().add(ciudad);
                        break;
                    }
                }
                */
            }
            
            //Aquí se cambian los estados de los asientos de los distintos vuelos
            while (rs3.next()){
                int id_vuelo = rs3.getInt("id_vuelo");
                int id_asiento = rs3.getInt("idAsiento");
                
                Vuelo vuelo = vuelosMap.get(id_vuelo);
                if (vuelo != null){
                    vuelo.asignarAsiento(id_asiento);
                }
            }
        }
        catch (SQLException e){
            System.out.println("Error al leer dato");
            e.printStackTrace();
        }
    }
    
    public static void CargarUsuarios(Connection con){
        String query1 = "SELECT cuenta.id, datos_usuarios.nombre, cuenta.usuario, cuenta.contrasena, datos_usuarios.tarjeta FROM datos_usuarios JOIN cuenta ON datos_usuarios.id = cuenta.id;";
        String query2 = "SELECT reservas.id, reservas.id_usuario, reservas.id_vuelo, reservas.pago, asientos.id_asiento AS idAsiento FROM reservas JOIN asientos ON reservas.id = asientos.id_reserva;";
        
        try{
            PreparedStatement ps1 = con.prepareStatement(query1);
            PreparedStatement ps2 = con.prepareStatement(query2);
            
            ResultSet rs1 = ps1.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            
            while (rs1.next()){
                int id = rs1.getInt("id");
                String name = rs1.getString("nombre");
                String userName = rs1.getString("usuario");
                String password = rs1.getString("contrasena");
                String tarjeta = Integer.toString(rs1.getInt("tarjeta"));
                
                //Se crean todos los usuarios menos su lista de reservas
                Usuario usuario = new Usuario(name, userName, password, tarjeta, new ArrayList<>());
                Agencia.listaUsuarios.add(usuario);
                usuariosMap.put(id, usuario);
            }
            
            int auxId=0;
            //Aquí se cargan las reservas de cada usuario
            while (rs2.next()){
                
                int id = rs2.getInt("id");//identificador propio de las reservas
                int id_usuario = rs2.getInt("id_usuario");
                int id_vuelo = rs2.getInt("id_vuelo");
                int auxPago = rs2.getInt("pago");
                boolean pago = (auxPago != 0);
                                
                Vuelo vuelo = vuelosMap.get(id_vuelo);
                Usuario usuario = usuariosMap.get(id_usuario);
                
                if (auxId != id){
                    usuario.crearReserva(vuelo, buscarAsientos(con, id_vuelo, id));
                    usuario.getListaReserva().get(id-1).setPago(pago);
                    auxId = id;
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    //Complemento para la función CargarUsuarios
    public static ArrayList<Integer> buscarAsientos(Connection con, int id_vuelo, int id_reserva){
        String query = "SELECT * FROM asientos";
        ArrayList<Integer> asientos = new ArrayList<>();
        
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                int id_asiento = rs.getInt("id_asiento");
                int id_vuelo1 = rs.getInt("id_vuelo");
                int id_reserva1 = rs.getInt("id_reserva");
                
                if (id_vuelo1 == id_vuelo && id_reserva1 == id_reserva){
                    asientos.add(id_asiento);
                }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        
        return asientos;
    }
    
    public static boolean usuariosNuevos(Connection con,String user_name, String name, String password){
        String query1 = "INSERT INTO datos_usuarios (nombre) VALUES (?)";
        String query2 = "INSERT INTO cuenta (usuario, contrasena) VALUES (?,?)";
        
        try{
            //No permite que se ejecute primero una query y después la otra. Esta función manda todas estas instrucciones de una vez
            con.setAutoCommit(false);
            
            PreparedStatement ps1 = con.prepareStatement(query1);
            
            ps1.setString(1, user_name);
            ps1.executeUpdate();
            
            PreparedStatement ps2 = con.prepareStatement(query2);
            
            ps2.setString(1, user_name);
            ps2.setString(2, password);
            ps2.executeUpdate();
            
            con.commit();
        }
        catch (SQLException e){
            //En caso de un error, para no tener una tabla con inconsistencias, se utiliza el rollback()
            try{
                con.rollback();
                return false;
            }
            catch (SQLException rollbackE){
                rollbackE.printStackTrace();
            }
        }
        finally{
            try{
                //De cualquier manera, el programa volverá a ejecutar una query después de otra, por ello vuelve a ser true
                con.setAutoCommit(true);
            }
            catch (SQLException autoCommitE){
                autoCommitE.printStackTrace();
            }
        }
        return true;
    }
}
