
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
     
public void crearTabla(){
    
                try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE AUTOS"+
                    "(ID INT  PRIMARY KEY,"+
                    "PPU    TEXT NOT NULL,"+
                    "MARCA TEXT NOT NULL,"+
                    "MODELO TEXT NOT NULL,"+
                    "COLOR TEXT NOT NULL,"+
                    "AÑO TEXT NOT NULL,"+
                    "VALOR_ARRIENDO INT NOT NULL)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Tabla Creada!!","Exito.!!",JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
        }
        
    }//Fin Metodo..

public void ingresoDatos(int ID, String PPU,String Marca,String Modelo,String Color,String Año,String ValorArriendo){
    try{
    Class.forName(DRIVER);
    conexion = DriverManager.getConnection(URL);
    sentencia = conexion.createStatement();
            String SQL = "INSERT INTO AUTOS"+
                    "(ID,PPU,MARCA,MODELO,COLOR,AÑO,VALOR_ARRIENDO)VALUES"+
                    "('"+ID+"','"+PPU+"','"+Marca+"','"+Modelo+"','"+Color+"','"+Año+"','"+ValorArriendo+"')";
          
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Datos Ingresados!!","Exito.!!",JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
        }

    }//Fin Metodo
    public void mostrarDatos(JTable tablaAuto){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "SELECT * FROM AUTOS";
            resultados = sentencia.executeQuery(SQL);
            int fila = 0;
            while(resultados.next()){
                
                tablaAuto.setValueAt(resultados.getString("ID"), fila, 0);
                tablaAuto.setValueAt(resultados.getString("PPU"), fila, 1);
                tablaAuto.setValueAt(resultados.getString("MARCA"), fila, 2);
                tablaAuto.setValueAt(resultados.getString("MODELO"), fila, 3);
                tablaAuto.setValueAt(resultados.getString("COLOR"), fila, 4);
                tablaAuto.setValueAt(resultados.getString("AÑO"), fila, 5);
                tablaAuto.setValueAt(resultados.getString("VALOR_ARRIENDO"), fila, 6);
                fila++;
            }
            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
        }
    
    }//Fin Metodo

public static void main(String[] args) {
      Metodos cl = new Metodos();
   cl.crearTabla();
    }
}
