
package metodos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Metodos {
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String DRIVER = "org.sqlite.JDBC" ;
    String NOMBREBD= "empresa.sqlite";
    String URL = "jdbc:sqlite: "+ NOMBREBD;
     



}
