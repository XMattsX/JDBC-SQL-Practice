
package guia4ej2_construirsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class Guia4Ej2_ConstruirSA {

   
    public static void main(String[] args) {
        try {
            //cargar drivers de conexion

            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/construirsa", "root", "");

            System.out.println("se ha conectado al servidor con exito");

            //cargarEmpleado(conn);
            //cargarHerramienta(conn);
            //DebajaEmpleado(conn);
            ListadoHerramientas(conn);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error de conexion con la libreria Mariadb \n" + ex.getMessage());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en la conexion con la base de datos");
        }

    }
    
    /*public static void cargarEmpleado(Connection conn) {
        ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "insert INTO empleado (dni, apellido, nombre, acceso, estado) VALUE (39237617, 'Argento', 'Guillermo',3,1)";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej2_ConstruirSA.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    
    /*public static void cargarHerramienta(Connection conn) {
        ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "insert INTO herramienta (nombre, descripcion, stock ,estado) VALUE ('Soldadora', 'La máquina de soldar es una máquina que se utiliza para la fijación de materiales',30,1)";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej2_ConstruirSA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/
    
    public static void DebajaEmpleado(Connection conn) {
    ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "DELETE FROM empleado WHERE idEmpleado = 1";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej2_ConstruirSA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ListadoHerramientas(Connection conn) {
    ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "SELECT * FROM `herramienta` WHERE stock > 10";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            resultConsulta=Ps.executeQuery();
            while(resultConsulta.next()){
            System.out.println("IdHerramienta: " + resultConsulta.getInt("idHerramienta"));
            System.out.println("IdHerramienta: " + resultConsulta.getString("nombre"));
            System.out.println("IdHerramienta: " + resultConsulta.getInt("stock"));
            System.out.println("IdHerramienta: " + resultConsulta.getInt("estado"));
            System.out.println("-----------------------------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej2_ConstruirSA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

