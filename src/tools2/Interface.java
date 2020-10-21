/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools2;

/**
 *
 * @author 52553
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.*;
import javax.swing.ImageIcon;
import java.awt.Graphics;

public class Interface extends JFrame {
    private Border border;
    private JButton bAgregar, bEliminar, bModificar, bConsultar;
    public static JTable tabla;

    public Interface(){
        super ("LA POBLANITA");


        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());

        border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        JPanel pNorth = _crearNorte();
        contenedor.add(pNorth, BorderLayout.NORTH);

        JPanel pCenter = _crearCentro();
        contenedor.add(pCenter, BorderLayout.CENTER);

        JPanel pSouth = _crearSur();
        contenedor.add(pSouth, BorderLayout.SOUTH);

        setSize(400, 350);
        setVisible(true);
        setLocation(500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JPanel _crearNorte() {
        JPanel p = new JPanel (new FlowLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border,"");
        JLabel etiqueta = new JLabel("INVENTARIO LA POBLANITA");
        p.add(etiqueta);
        return p;
    }

    private JPanel _crearCentro() {
        JPanel p = new JPanel ();
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border,"Inventario");
        //INTENTO DE INSERTAR IMAGEN
        JLabel img = new JLabel(" ");

            ImageIcon image = new ImageIcon("src\\Imagenes\\pp.png");

            p.add(img); // "dibujar" es mi panel ok...

            //Propiedades de la etiqueta
            img.setIcon(image);
            img.setSize(5,5);
            img.setLocation(550,0);
            img.setVisible(true);
        //INTENTO 
        //p.add(tabla);
        return p;
    }



    private JPanel _crearSur() {
        JPanel p = new JPanel(new FlowLayout());
        TitledBorder titleBorder = BorderFactory.createTitledBorder(border,"Opciones");
        bConsultar = new JButton("Consultar");
        bConsultar.addActionListener(new EscuchaBoton());
        p.add(bConsultar);
        bAgregar = new JButton("Agregar");
        bAgregar.addActionListener(new EscuchaBoton());
        p.add(bAgregar);
        bModificar = new JButton("Modificar");
        p.add(bModificar);
        bEliminar = new JButton("Eliminar");
        p.add(bEliminar);
        return p;
    }
}