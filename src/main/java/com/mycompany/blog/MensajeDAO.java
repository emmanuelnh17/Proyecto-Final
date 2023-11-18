/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blog;
import java.sql.*;
import java.util.*;
import static com.mycompany.blog.Conexion.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Emmanuel
 */
public class MensajeDAO {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Mensaje mensaje;
    
    public List<Mensaje> seleccionar() throws ClassNotFoundException{
        String sql = "SELECT * FROM mensaje_per";
        List<Mensaje> mensajes = new ArrayList<>();
        
        try {
            this.con = getConexion();
            this.ps = this.con.prepareStatement(sql);
            this.rs = this.ps.executeQuery();
            
            while(this.rs.next()){
                int id = this.rs.getInt("id");
                String msn = this.rs.getString("mensaje");
                String autor = this.rs.getString("autor");
                String fecha = this.rs.getString("fecha");
                
                this.mensaje = new Mensaje(id, msn, autor, fecha);
                mensajes.add(this.mensaje);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                desconectar(this.rs);
                desconectar(this.ps);
                desconectar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return mensajes;
    }
    
    public int insertar(Mensaje mensaje) throws ClassNotFoundException{
        String sql = "INSERT INTO mensaje_per(mensaje,autor,fecha) VALUES (?,?,CURRENT_TIME())";
        int registros = 0;
         
        try {
            this.con = getConexion();
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setString(1, mensaje.getMensaje() );
            this.ps.setString(2, mensaje.getAutor() );
            registros = this.ps.executeUpdate();
            
                
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                
                desconectar(this.ps);
                desconectar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int editar(Mensaje mensaje) throws ClassNotFoundException{
        String sql = "UPDATE mensaje_per SET mensaje=?, autor=? WHERE id = ?";
        int registros = 0;
         
        try {
            this.con = getConexion();
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setString(1, mensaje.getMensaje() );
            this.ps.setString(2, mensaje.getAutor() );
            this.ps.setInt(3, mensaje.getId());
            registros = this.ps.executeUpdate();
            
                
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                
                desconectar(this.ps);
                desconectar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int borrar(Mensaje mensaje) throws ClassNotFoundException{
        String sql = "DELETE FROM mensaje_per WHERE id = ?";
        int registros = 0;
         
        try {
            this.con = getConexion();
            this.ps = this.con.prepareStatement(sql);
            
            this.ps.setInt(1, mensaje.getId() );
            
            registros = this.ps.executeUpdate();
            
                
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            try {
                
                desconectar(this.ps);
                desconectar(this.con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
}
