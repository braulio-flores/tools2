/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools2;


import java.sql.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author 52553
 */
public class ConexionBase { 
        String usr = "root";
        String pas = "root";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dbherramientas";

        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        public ConexionBase(){}

        protected Connection crearConexionBase(){
            try{
                Class.forName(driver);
                con = DriverManager.getConnection(url,usr,pas);
                return con;
            }
            catch(Exception e){
                e.printStackTrace();
                throw new RuntimeException();
            }

        }

        public void insertarDatos(String nombre){
           try{
                crearConexionBase();
                String sql = "INSERT INTO productos (nombre)";
                sql += "VALUES(?)";
                pstm = con.prepareStatement(sql);

                pstm.setString(1, nombre);
                int rtdo = pstm.executeUpdate();
                if(rtdo == 1){
                    System.out.println("Una fila correctamente insertada");
                }else{
                    System.out.println("Un registro no insertado exitosamente");
                }
                cerrarConexion();
           }
           catch(Exception e){
               e.printStackTrace();
               throw new RuntimeException(e);
           }
        }
        public void borrarRegistro(String nombre){
            try{
                crearConexionBase();
                String sql = "DELETE FROM productos where nombre = ?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, nombre);
                int rtdo = pstm.executeUpdate();
                if (rtdo==1){
                    System.out.println("Un registro borrado exitosamente");
                }else{
                    System.out.println("Un registro no borrado exitosamente");
                }
                cerrarConexion();
            }
            catch(Exception e){
            }
        }
        public void actualizarRegistro(String nombreviejo, String nombrenuevo){
            try{
                crearConexionBase();
                String sql = "UPDATE productos SET nombre = ? where nombre = ?";
                pstm = con.prepareStatement(sql);
                pstm.setString(1, nombrenuevo);
                pstm.setString(2, nombreviejo);
                int rtdo = pstm.executeUpdate();

                if (rtdo==1){
                    System.out.println("Un registro actualizado exitosamente");
                }else{
                    System.out.println("Un registro no actualizado exitosamente");
                }
                cerrarConexion();
            }
            catch(Exception e){
            }
        }
        public void mostrarRegistros(){

            try{
                crearConexionBase();
                String sql = "SELECT * FROM productos";

                Statement st;
                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("id");
                model.addColumn("nombre");
                Interface.tabla.setModel(model);
                String dato [] = new String[1];

                st = con.createStatement();
                ResultSet result = st.executeQuery(sql);

                while(result.next()){
                    dato[0] = result.getString(1);
                    dato[1] = result.getString(2);
                    model.addRow(dato);
                }

                //----
                cerrarConexion();
            }
            catch(Exception e){
            }
        }
        public void cerrarConexion(){
                try{
                    if(rs != null) rs.close();
                    if(con != null ) con.close();
                    if(pstm != null) con.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }

}