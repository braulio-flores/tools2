/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author 52553
 */
public class EscuchaBoton implements ActionListener{

    public void actionPerformed(ActionEvent e) {


        if(e.getActionCommand() == "agregar"){
            System.out.println("Boton de agregar registro");
            ConexionBase cb = new ConexionBase();
            cb.insertarDatos(InterfaceAgregar.obtenerNombre());
            JOptionPane.showMessageDialog(null, "Operación realizada correctamente");

        }
        if(e.getActionCommand() == "Consultar"){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    tablaa t = new tablaa();
                    t.setVisible(true);
                    t.setLocation(200, 200);


                }
            });
            System.out.println("Consultando Registros");
        }
        else{
            System.out.println("BOTON DE ABRIR VENTANA");
            InterfaceAgregar i = new InterfaceAgregar();
            System.out.println(e.getActionCommand());
        }


    }

}