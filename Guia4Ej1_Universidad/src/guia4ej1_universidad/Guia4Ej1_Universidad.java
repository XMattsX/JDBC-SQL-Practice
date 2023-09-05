package guia4ej1_universidad;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Guia4Ej1_Universidad {

    public static void main(String[] args) {
        try {
            //cargar drivers de conexion

            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp", "root", "");

            System.out.println("se ha conectado al servidor con exito");

            /*cargarAlumno(conn);*/
            /*cargarMateria(conn);*/
            //cargarInscripcion(conn);
            DesinscribirAlumno(conn);

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "error de conexion con la libreria Mariadb \n" + ex.getMessage());

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error en la conexion con la base de datos");
        }

    }

    /*public static void cargarAlumno(Connection conn) {
        ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "insert INTO alumno (dni, apellido, nombre, fechaNacimiento, estado) VALUE (33592184, 'mia', 'Sosa','1995-06-20',1)";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej1_Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

    /*public static void cargarMateria(Connection conn) {
        ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "insert INTO materia (nombre, año, estado) VALUE ('Ingles', '2010-05-13', 1)";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej1_Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    /*public static void cargarInscripcion(Connection conn) {
        ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "insert INTO inscripcion (idInscripto, nota, idAlumno, idMateria) VALUE (6, 10, 3, 4)";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej1_Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    public static void DesinscribirAlumno(Connection conn) {
    ResultSet resultConsulta;
        PreparedStatement Ps;
        String sentenciasql = "DELETE FROM inscripcion WHERE idAlumno = 3 AND idMateria = 2";
        try {
            //preparar la linea sql para ser ejecutada
            Ps = conn.prepareStatement(sentenciasql);

            //ejecutar la consulta 
            Ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Guia4Ej1_Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
