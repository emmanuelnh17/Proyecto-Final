/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blog;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Emmanuel
 */
public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //Conexion.getConexion();
        //System.out.println("Conexion exitosa");
        MensajeDAO mensajeDao = new MensajeDAO();
        
        Mensaje msn = new Mensaje("hola desde main", "main");
        int registro1 = mensajeDao.insertar(msn);
        System.out.println("se inserto: "+ registro1 + " registro");
        
        Mensaje msm = new Mensaje(10, "toco detonarte", "yo mismito");
        int registro2 = mensajeDao.editar(msm);
        System.out.println("Se edito "+ registro2 + " registro");
        
        Mensaje msp = new Mensaje(9);
        int registro3 = mensajeDao.borrar(msp);
        System.out.println("Se borro "+ registro3 + " registro");
        
        List<Mensaje> mensajes = mensajeDao.seleccionar();
        
        
        for(Mensaje mensaje : mensajes){
            System.out.println(mensaje);
        }
    }
}
