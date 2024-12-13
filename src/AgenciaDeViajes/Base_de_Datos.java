/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AgenciaDeViajes;

import java.sql.*;
import java.time.LocalDate;
import java.sql.Date;
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
    private static Map<String, Integer> ciudadesMap = new HashMap<>();
    public static ArrayList<Vuelo> historialVuelos = new ArrayList<>();
    
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
        String call1 = "{CALL verificar_vuelo()}";
        
        try {
            PreparedStatement ps1 = con.prepareStatement(query1);
            PreparedStatement ps2 = con.prepareStatement(query2);
            PreparedStatement ps3 = con.prepareStatement(query3);
            CallableStatement cs1 = con.prepareCall(call1);
            
            cs1.execute();
            
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
                
                int estado_vuelo = rs1.getInt("estado_vuelo");
                int tarifa_general = rs1.getInt("tarifa_general");
                
                Vuelo vuelo = new Vuelo(aereolinea, origen, new ArrayList<>(), destino, tarifa_general, fecha_salida);
                //Solo hacen referencia al objeto como tal, no se "duplica" el objeto
                Agencia.listaVuelos.add(vuelo);
                vuelosMap.put(id, vuelo);
                
                if(estado_vuelo != 1){
                    historialVuelos.add(vuelo);
                }
            }
            Agencia.actualizarIDVuelo();
            
            //Aquí se llena los arrayList de las escalas de los distintos vuelos
            while (rs2.next()){
                int id = rs2.getInt("id");
                String ciudad = rs2.getString("ciudad");
                
                Vuelo vuelo = vuelosMap.get(id);
                if (vuelo != null){
                    vuelo.getEscalas().add(ciudad);
                    for (Vuelo vueloHistorial : historialVuelos) {
                        if (vueloHistorial.equals(vuelo)) {
                            vueloHistorial.getEscalas().add(ciudad);
                            break;
                        }
                    }
                }
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
        String query1 = "SELECT cuenta.id, datos_usuarios.nombre, cuenta.usuario, cuenta.contrasena, datos_usuarios.tarjeta, datos_usuarios.apellido, datos_usuarios.correo, datos_usuarios.direccion, datos_usuarios.cedula FROM datos_usuarios JOIN cuenta ON datos_usuarios.id = cuenta.id;";
        String query2 = "SELECT reservas.id, reservas.id_usuario, reservas.id_vuelo, reservas.pago, asientos.id_asiento AS idAsiento FROM reservas JOIN asientos ON reservas.id = asientos.id_reserva ORDER BY reservas.id;";
        
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
                String apellido = rs1.getString("apellido");
                String correo = rs1.getString("correo");
                String direccion = rs1.getString("direccion");
                String cedula = Integer.toString(rs1.getInt("cedula"));
                
                //Se crean todos los usuarios menos su lista de reservas
                Usuario usuario = new Usuario(name, userName, password, tarjeta, new ArrayList<>(), direccion, correo, apellido, cedula);
                Agencia.listaUsuarios.add(usuario);
                usuariosMap.put(id, usuario);
            }
            
            int auxId=0, aux_long=0;
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
                    aux_long = usuario.getListaReserva().size();
                    usuario.getListaReserva().get(aux_long-1).setPago(pago);
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
    
    public static boolean usuariosNuevos(Connection con,String user_name, String name, String password, String direccion, String email, String apellido, String cedula){
        String call1 = "{CALL agregar_usuario(?,?,?,?,?)}";
        String call2 = "{CALL agregar_cuenta(?,?)}";
        
        try{
            //No permite que se ejecute primero una query y después la otra. Esta función manda todas estas instrucciones de una vez
            con.setAutoCommit(false);
            
            CallableStatement cs1 = con.prepareCall(call1);
            CallableStatement cs2 = con.prepareCall(call2);
            
            cs1.setString(1, name);
            cs1.setString(2, apellido);
            cs1.setString(3, email);
            cs1.setString(4, direccion);
            cs1.setString(5, cedula);
            cs1.execute();
            
            cs2.setString(1, user_name);
            cs2.setString(2, password);
            cs2.execute();
            
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
    
    public static void reservarVuelo(Connection con, int pos_usuario, int pos_vuelo, ArrayList asientos){
        String query1 = "INSERT INTO reservas (id_usuario, id_vuelo, pago) VALUES (?,?,0)"; //NO AÑADO LA FECHA RESERVA PORQUE ESO ES UN TRIGGER
        String query2 = "INSERT INTO asientos (id_asiento, id_vuelo, id_reserva, ocupado) VALUES (?,?,?,1)";
        String query3 = "SELECT asientos_disponibles FROM vuelos WHERE (id = ?)";
        String query4 = "UPDATE vuelos SET asientos_disponibles = ? WHERE (id = ?);";
        int id_reserva = 0, asientos_disp=0;
        
        try{
            con.setAutoCommit(false);
            
            PreparedStatement ps1 = con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS); //necesito que me de el id, por lo que le indico que lo guarde
            ps1.setInt(1, pos_usuario);
            ps1.setInt(2, pos_vuelo);
            
            ps1.executeUpdate();
            
            ResultSet rs = ps1.getGeneratedKeys();//luego de ejecutar el codigo, guardo todas las claves que guardó de ese statement
            //recorro los resultados que generó
            if(rs.next()){
                id_reserva = rs.getInt(1);//tomo el primero que hace referencia al id
            }
            rs.close();
            
            /******************************************************************************/
            //Traigo los asientos disponibles del vuelo y elimino la cantidad de asientos que el usuario escoja
            PreparedStatement ps3 = con.prepareStatement(query3);
            ps3.setInt(1, pos_vuelo);
            
            ResultSet rs3 = ps3.executeQuery();
            
            while (rs3.next()){
                asientos_disp = rs3.getInt("asientos_disponibles");
            }
            rs3.close();
            
            //Aquí si añado los asientos a la tabla de asientos
            PreparedStatement ps2 = con.prepareStatement(query2);
            for (int i=0; i < asientos.size(); i++){
                ps2.setInt(1, (int) asientos.get(i));
                ps2.setInt(2, pos_vuelo);
                ps2.setInt(3, id_reserva);
                
                asientos_disp--;
                ps2.addBatch();//ejecuta todas las insercciones de una vez
            }
            ps2.executeBatch();   
            
            /*******************************************************************************/
            PreparedStatement ps4 = con.prepareStatement(query4);
            ps4.setInt(1, asientos_disp);
            ps4.setInt(2, pos_vuelo);
            
            ps4.executeUpdate();            
            con.commit();
        }
        catch (SQLException e){
            try{
                con.rollback();
            }
            catch (SQLException rollback){
                rollback.printStackTrace();
            }
            System.out.println("Error al insertar dato");
            e.printStackTrace();
        }
        finally{
            try {
                con.setAutoCommit(true); // Restaurar autocommit
            }
            catch (SQLException autoC) {
                autoC.printStackTrace();
            }
        }
    }
    
    public static void modificarReserva(Connection con, ArrayList agregar, ArrayList eliminar, int id_vuelo, int id_reserva){
        String query1 = "INSERT INTO asientos (id_asiento, id_vuelo, id_reserva, ocupado) VALUES (?,?,?,1);";
        String query2 = "DELETE FROM asientos WHERE id_asiento = ? AND id_reserva = ?;";
        
        try{
            con.setAutoCommit(false);
            //Operación para agregar asientos
            try (PreparedStatement ps1 = con.prepareStatement(query1)){
                for (int i=0; i<agregar.size(); i++){
                    ps1.setInt(1, (int) agregar.get(i));
                    ps1.setInt(2, id_vuelo);
                    ps1.setInt(3, id_reserva);

                    ps1.addBatch();
                }
                ps1.executeBatch();
            }
            
            //operación para eliminar asientos
            try (PreparedStatement ps2 = con.prepareStatement(query2)){
                for (int i=0; i<eliminar.size(); i++){
                    ps2.setInt(1, (int) eliminar.get(i));
                    ps2.setInt(2, id_reserva);

                    ps2.addBatch();
                }
                ps2.executeBatch();
            }
            
            con.commit();
        }
        catch (SQLException E){
            try {
                con.rollback();
                System.out.println("Transaccion revertida gracias a un error");
            }
            catch (SQLException roll){
                roll.printStackTrace();
            }
            E.printStackTrace();
        }
        
        finally{
            try {
                con.setAutoCommit(true); // Restaurar autocommit
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public static void eliminarReserva(Connection con, int id_reserva){
        String query = "DELETE FROM reservas WHERE id = ?;";
        
        try (PreparedStatement ps = con.prepareStatement(query)){
            //Lo que solo hace es eliminar la fila donde se encuentre ese id, además de que los asientos
            //se eliminarán con un trigger
            ps.setInt(1, id_reserva);
            
            ps.executeUpdate();
        }
        catch (SQLException e){
            System.out.println("Error al eliminar reserva");
            e.getStackTrace();
        }
    }
    
    //*********************************************************************************************************************
    //RANGO DE SOLO ADMINISTRADOR
    public static void añadirVuelos(Connection con, String aereo, String origen, String destino, LocalDate fechaSalida, int tarifa, ArrayList<String> escalas){
        String query1 = "INSERT INTO vuelos (aereolinea, asientos_disponibles, origen, destino, fecha_salida, estado_vuelo, tarifa_general) VALUES (?,?,?,?,?,?,?);";
        String query2 = "INSERT INTO escalasxvuelo (id_vuelo, id_escala) VALUES (?,?)";
        Date cast_fechaSalida = Date.valueOf(fechaSalida);
        int id_vuelo =0;
        
        verificarEscalas(con, escalas);
        
        try (PreparedStatement ps1 = con.prepareStatement(query1, Statement.RETURN_GENERATED_KEYS)){
            ps1.setString(1, aereo);
            
            if (aereo.equals("Avianca")){
                ps1.setInt(2, 166);
            }
            else{
                if (aereo.equals("Fly Emirates")){
                    ps1.setInt(2, 332);
                }
                else{
                    ps1.setInt(2, 210);
                }
            }
            
            ps1.setString(3, origen);
            ps1.setString(4, destino);
            ps1.setDate(5, cast_fechaSalida);
            ps1.setInt(6, 1);
            ps1.setInt(7, tarifa);
            
            ps1.executeUpdate();
            
            try (ResultSet rs1 = ps1.getGeneratedKeys()){//luego de ejecutar el codigo, guardo todas las claves que guardó de ese statement
                //recorro los resultados que generó
                if(rs1.next()){
                    id_vuelo= rs1.getInt(1);//tomo el primero que hace referencia al id
                }
            }
            catch (SQLException E){
                System.out.println("ERROR AL RETOMAR EL ID_VUELO");
                E.printStackTrace();
            }
        }
        catch (SQLException e){
            System.out.println("Error al insertar un vuelo");
            e.printStackTrace();
        }
        
        //aquí verifico si existen escalas a añadir. Si no existen se crea el vuelo solo
        if (escalas != null && !escalas.isEmpty()){
            try (PreparedStatement ps2 = con.prepareStatement(query2)){
                for (String escala : escalas){
                    Integer id_escala = ciudadesMap.get(escala);
                    if(id_escala != null){
                        ps2.setInt(1, id_vuelo);
                        ps2.setInt(2, id_escala);

                        ps2.addBatch();
                    }
                }
                ps2.executeBatch();
            }
            catch (SQLException e){
                System.out.println("Error al insertar un vuelo");
                e.printStackTrace();
            }
        }
        
        ciudadesMap.clear();
    }
    
    //Complemento añadirVuelos
    public static void verificarEscalas(Connection con, ArrayList<String> escalas){
        //Verifico si existen escalas, si no existen pues se sale y no ejecuta el código
        if (escalas == null || escalas.isEmpty()){
            return;
        }
        
        String query1 = "SELECT id, ciudad FROM escalas;";
        String query2 = "INSERT INTO escalas (ciudad) VALUES (?);";
        
        try (PreparedStatement ps1 = con.prepareStatement(query1)){
            
            ResultSet rs1 = ps1.executeQuery();
            
            //Guardo todas las distintas escalas en un hashMap
            while (rs1.next()){
                int id = rs1.getInt("id");
                String ciudad = rs1.getNString("ciudad");
                ciudadesMap.put(ciudad, id);
            }
            
            //aquí verifico que si en el arrayList de escalas están sino, se agregan a la tabla
            try (PreparedStatement ps2 = con.prepareStatement(query2, Statement.RETURN_GENERATED_KEYS)){
                for (String escala : escalas){
                    if (!ciudadesMap.containsKey(escala)){
                        ps2.setString(1, escala);
                        
                        try{
                            ps2.executeUpdate();
                        }
                        catch (SQLException e){
                            System.out.println("Error al ejecutar la inserción para la escala "+escala);
                            e.printStackTrace();
                        }
                        
                        //Obtiene la clave generada de la inserción
                        try (ResultSet rs2 = ps2.getGeneratedKeys()){
                            if (rs2.next()){
                                ciudadesMap.put(escala, rs2.getInt(1));
                            }
                        }
                        catch (SQLException E){
                            System.out.println("ERROR AL OBTENER LA CLAVE GENERADA POR LA INSERCION");
                            E.printStackTrace();
                        }
                    }
                }
            }
            catch (SQLException E){
                System.out.println("ERROR AL INSERTAR NUEVAS ESCALAS EN LA TABLA");
                E.printStackTrace();
            }
            
        }
        catch (SQLException e){
            System.out.println("Error al leer dato");
            e.getStackTrace();
        }
    }
    
    public static void eliminarVuelos(Connection con, int id_vuelo){
        String query = "DELETE FROM vuelos WHERE id = ?;";
        
        try (PreparedStatement ps = con.prepareStatement(query)){
            con.setAutoCommit(false);
            //Lo que solo hace es eliminar la fila donde se encuentre ese id
            //la eliminación de las reservas de los usuarios con ese id (incluido los asientos) son triggers
            ps.setInt(1, id_vuelo);
            
            ps.executeUpdate();
            
            con.commit();
        }
        catch (SQLException e){
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Error al eliminar el vuelo con id "+id_vuelo);
            e.printStackTrace();
        }
        finally{
            try{
                con.setAutoCommit(true);
            }
            catch (SQLException E){
                System.out.println("Error al setAutoCommit");
                E.printStackTrace();
            }
        }
    }
    
    //***********************************************************************************************************************
    //ESPACIO SOLO PARA MODIFICACIONES DE LOS USUARIOS
    
    public static void configuracionUsuarios (Connection con, String modificacion, String columna, int id_usuario){
        String query;
        
        if (!columna.equals("usuario") && !columna.equals("contrasena")){
            query = "UPDATE datos_usuarios SET " + columna + " = ? WHERE (id = ?);";
        }
        else{
            query = "UPDATE cuenta SET "+ columna + " = ? WHERE (id = ?);";
        }
        
        try (PreparedStatement ps1 = con.prepareStatement(query)) {
            ps1.setString(1, modificacion);
            ps1.setInt(2, id_usuario+1);

            ps1.executeUpdate();

        }
        catch (SQLException e){
            System.out.println("Error al actualizar dato");
            e.printStackTrace();
        }
    }
}
