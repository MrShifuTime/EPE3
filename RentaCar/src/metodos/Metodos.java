/*
EPE3, RentaCar v1.0
    Copyright (C) 2019  Ricardo Lucero
                        Sebastian Quiroga
                        Ernesto Díaz
                        Diego Arancibia
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
RentaCar  Copyright (C) 2019  Ricardo Lucero
                        Sebastian Quiroga
                        Ernesto Díaz
                        Diego Arancibia
    This program comes with ABSOLUTELY NO WARRANTY.
    This is free software, and you are welcome to redistribute it
*/
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
