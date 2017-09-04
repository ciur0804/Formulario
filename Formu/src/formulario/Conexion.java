
package formulario;

/**
 * IMPORT
 */
import java.sql.*;

/**
 * Descripción: Permite hacer la conexión y actualización de la base de datos. 
 */
public class Conexion {
        //VARIABLES DE INSTANCIA
        static Statement stm = null;
        
        /**
         * Método getConexion
         */
        public static Connection getConexion(){
            Connection cn = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost/practicaformulario", "root", "n0m3l0");
                stm = cn.createStatement();
                System.out.print("Conexion Satisfactoria");
            }
            catch (Exception e){
                System.out.print("Error de conexion: "+e);
            }
            return cn;
        } 
        
        /**
         * Método SubirNombre
         */
        public void SubirDatos(String Nombre, String APP, String APM, String Escuela){
            try{                
                stm.executeUpdate("INSERT INTO datosformulario (Nombre, App, Apm, Escuela) VALUES (" + 
                    "'" + Nombre + "', '" + APP + "', '" + APM + "', '" + Escuela + "');");
            }catch(SQLException error)
            {
                System.out.println(error.toString());
            }
        }      
}
