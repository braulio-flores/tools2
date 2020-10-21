/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools2;

import java.awt.*;
import javax.swing.*;
import javax.swing.JTextField;
import javax.swing.border.*;

/**
 *
 * @author 52553
 */
public class InterfaceAgregar extends JFrame {
    private static JTextField nombre;   
    private JButton bAgregar2;
    private final Border border;

    public static String obtenerNombre(){
        String devolver = nombre.getText();
        return devolver;
    }

    public InterfaceAgregar(){
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        JPanel pNorth = _crearNorte();
        contenedor.add(pNorth, BorderLayout.NORTH);

        JPanel pCenter = _crearCentro();
        contenedor.add(pCenter, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setLocation(500, 200);
    }

    private JPanel _crearNorte() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border);
        p.setBorder(titleBorder);

        JLabel etiqueta = new JLabel("AGREGAR PRODUCTO");
        p.add(etiqueta);
        return p;
    }

    private JPanel _crearCentro() {
        JPanel p = new JPanel(new BorderLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border);
        p.setBorder(titleBorder);
        JPanel ppp = crearNortedelCentro();
        p.add(ppp,BorderLayout.NORTH);

        JPanel pp = crearCentrodelCentro();
        p.add(pp,BorderLayout.CENTER);
        return p;
    }

    private JPanel crearCentrodelCentro() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border,"");
        p.add(new JLabel("Nombre: "));
        nombre = new JTextField(10);
        p.add(nombre);
        bAgregar2 = new JButton("agregar");
        bAgregar2.addActionListener(new EscuchaBoton());
        p.add(bAgregar2);
        return p;
    }

    private JPanel crearNortedelCentro() {
        JPanel p = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel etiqueta = new JLabel("Ingresa informacion del producto para agregar");
        p.add(etiqueta);
        return p;
    }
}