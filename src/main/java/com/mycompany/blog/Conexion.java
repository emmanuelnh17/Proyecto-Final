/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blog;
import java.sql.*;

/**
 *
 * @author Emmanuel
 */
public class Conexion {
    private static final String URL =  "jdbc:mysql://localhost/mensajes?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "654321";
    
    public static Connection getConexion() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL,USER,PASS);
    }
    
    public static void desconectar(ResultSet rs) throws SQLException{
            rs.close();
        }
    public static void desconectar(PreparedStatement ps) throws SQLException{
            ps.close();
        }
    public static void desconectar(Connection con) throws SQLException{
            con.close();
        }
}
