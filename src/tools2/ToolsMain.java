/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author 52553
 */
public class ToolsMain {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws Exception {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
            Interface i = new Interface();
            ConexionBase cb = new ConexionBase();
            cb.mostrarRegistros();
            //ConexionBase con = new ConexionBase();
            //con.insertarDatos(8, "nombre8");
            //con.insertarDatos(9, "nombre9");
            //con.borrarRegistro("nombre6");
            //con.actualizarRegistro("nombre9", "actualizado");
            //con.cerrarCconexion();
        }
    }
