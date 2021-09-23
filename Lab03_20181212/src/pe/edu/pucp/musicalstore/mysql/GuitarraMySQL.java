/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.musicalstore.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import pe.edu.pucp.musicalstore.config.DBManager;
import pe.edu.pucp.musicalstore.dao.GuitarraDAO;
import productos.cuerda.Guitarra;

/**
 *
 * @author FERNANDO
 */
public class GuitarraMySQL implements GuitarraDAO{
    Connection con;
    Statement st;
    
    @Override
    public int insertar(Guitarra guitarra) {
        int resultado = 0;
        try{
            //Registrando el Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Conexion
            con = DriverManager.getConnection(DBManager.url, 
                    DBManager.user, DBManager.password);
            //Instruccion SQL
            st = con.createStatement();
            String instruccion = 
                    "INSERT INTO guitarra(nombre,activo) VALUES("
                    + "'"+guitarra.getNombre()+"',1)";
            //Ejecutamos la instruccion
            resultado = st.executeUpdate(instruccion);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{st.close();}catch(Exception ex){System.out.println(ex.getMessage());}
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }
        return resultado;
    }

    @Override
    public int modificar(Guitarra guitarra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(int idGuitarra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Guitarra> listarTodas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
