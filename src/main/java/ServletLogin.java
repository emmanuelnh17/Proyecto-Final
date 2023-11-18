/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import static com.mycompany.blog.Conexion.desconectar;
import static com.mycompany.blog.Conexion.getConexion;
import com.mycompany.blog.Mensaje;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycompany.blog.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mycompany.blog.Autor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emmanuel
 */
@WebServlet(urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Autor autor;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        try {
            if (validarLogin(email, password)){
                response.sendRedirect("index.jsp?email="+email);
            }else{
                response.sendRedirect("login.jsp");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServletLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }   

    private boolean validarLogin(String email, String password) throws ClassNotFoundException {
        
        String sql = "SELECT * FROM usuarios WHERE email=? and password=?";
        try {           
            this.con = getConexion();
            this.ps = this.con.prepareStatement(sql);
            
            while(this.rs.next()){
                
                String e= this.rs.getString("email");
                String p = this.rs.getString("password");
                
                if (e == email && p == password){
                    return true;
                }else{
                    return false;
                }
                
                
            }
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
        return false;
    }
        
    }



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

