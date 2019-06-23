
package gestionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class GestionBD {
    Connection conexion = null;
    Statement sentencia = null;
    ResultSet resultados = null;
    String DRIVER = "org.sqlite.JDBC" ;
    String NOMBREBD= "empresa.sqlite";
    String URL = "jdbc:sqlite: "+ NOMBREBD;
   
//public void crearBD(){
//    
//    
//        try{
//            Class.forName(DRIVER);
//            conexion = DriverManager.getConnection(URL);
//        
//        }catch (ClassNotFoundException | SQLException e){
//            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
//        }
//    }//Fin Metodo...
 public void crearTabla(){
    
                try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "CREATE TABLE CLIENTE"+
                    "(RUT TEXT  PRIMARY KEY,"+
                    "NOMBRE    TEXT NOT NULL,"+
                    "APELLIDO TEXT NOT NULL,"+
                    "DIRECCION TEXT NOT NULL,"+
                    "TELEFONO TEXT NOT NULL,"+
                    "CORREO TEXT NOT NULL)";
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Tabla Creada!!","Exito.!!",JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
        }
        
    }//Fin Metodo...
//  
public void ingresoDatos(String Rut, String Nombre,String Apellido,String Direccion,String Telefono,String Correo){
    try{
    Class.forName(DRIVER);
    conexion = DriverManager.getConnection(URL);
    sentencia = conexion.createStatement();
            String SQL = "INSERT INTO CLIENTE"+
                    "(RUT,NOMBRE, APELLIDO,DIRECCION,TELEFONO,CORREO)VALUES"+
                    "('"+Rut+"','"+Nombre+"','"+Apellido+"','"+Direccion+"','"+Telefono+"','"+Correo+"')";
            if(Rut == ""){
                JOptionPane.showMessageDialog(null, "Campo sin datos","Error!!",JOptionPane.ERROR_MESSAGE);
            }
            sentencia.executeUpdate(SQL);
            JOptionPane.showMessageDialog(null, "Datos Ingresados!!","Exito.!!",JOptionPane.INFORMATION_MESSAGE);
            sentencia.close();
            conexion.close();
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
        }

    }//Fin Metodo
    public void mostrarDatos(JTable tablaCliente){
        
        try{
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL);
            sentencia = conexion.createStatement();
            String SQL = "SELECT * FROM CLIENTE";
            resultados = sentencia.executeQuery(SQL);
            int fila = 0;
            while(resultados.next()){
                
                tablaCliente.setValueAt(resultados.getString("RUT"), fila, 0);
                tablaCliente.setValueAt(resultados.getString("NOMBRE"), fila, 1);
                tablaCliente.setValueAt(resultados.getString("APELLIDO"), fila, 2);
                tablaCliente.setValueAt(resultados.getString("DIRECCION"), fila, 3);
                tablaCliente.setValueAt(resultados.getString("TELEFONO"), fila, 4);
                tablaCliente.setValueAt(resultados.getString("CORREO"), fila, 5);
                fila++;
            }

            resultados.close();
            sentencia.close();
            conexion.close();
            
        }catch (ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Error : "+ e,"Error!! ",JOptionPane.ERROR_MESSAGE);
        }
    
    }//Fin Metodo
    
public void crearTablaAutos(){
    
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
    public void mostrarDatosAutos(JTable tablaAuto){
        
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


    
    
    // este es un clase para gestionar la base de datos
}
