/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.pucp.musicalstore.main;

import pe.edu.pucp.musicalstore.dao.GuitarraDAO;
import pe.edu.pucp.musicalstore.mysql.GuitarraMySQL;
import productos.cuerda.Guitarra;
import productos.importadoras.Marca;

/**
 *
 * @author FERNANDO
 */
public class Principal {
    public static void main(String[] args){
        Marca marca1 = new Marca(1,"Fender");
        Marca marca2 = new Marca(2,"Gibson");
        Guitarra gui1= new Guitarra("Squier",
                marca1,"Roja","Maple",3,true,710.00);
        Guitarra gui2= new Guitarra("Les Paul",
                marca2,"Vintage Sunburst","Caboa",4,false,2640.00);
        GuitarraDAO daoGuitarra = new GuitarraMySQL();
        daoGuitarra.insertar(gui1);daoGuitarra.insertar(gui2);
    }
}
