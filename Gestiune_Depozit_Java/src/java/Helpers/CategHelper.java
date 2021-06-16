/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Categ;
/**
 *
 * @author papad
 */
public class CategHelper {
    
    public static ArrayList<String> getCateg(ArrayList<String> categ) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select distinct den from categ";

            PreparedStatement ps = con.prepareStatement(query); // generates sql query

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                categ.add(rs.getString("den"));
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
        return categ;
    }
    
    
    public static Categ getCategDetails(String categ) {
        Categ c = new Categ();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select * from categ where den = ?";
            
            PreparedStatement ps = con.prepareStatement(query); // generates sql query

            ps.setString(1, categ);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                c.setIdCateg(rs.getInt("categID"));
                c.setDen(rs.getString("den"));
                c.setIdParinte(rs.getInt("idParinte"));
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
        return c;
    }
    
    public static ArrayList<Categ> getCategsOf(Categ categ) {
        ArrayList<Categ> categs = new ArrayList<Categ>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");
            
            String query;
            
            if(categ.getIdCateg() != 0)
                query = "select * from categ where idParent = ?";
            else
                query = "select * from categ where idParent is null";
                
            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            if(categ.getIdCateg() != 0) ps.setString(1, Integer.toString(categ.getIdCateg()));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Categ c = new Categ();
                c.setIdCateg(rs.getInt("categID"));
                c.setDen(rs.getString("den"));
                c.setIdParinte(rs.getInt("idParent"));
                categs.add(c);
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
        return categs;
    }
 
    
    public static Boolean isLeaf(Categ categ){
        
        Boolean itIs = true;

        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select * from categ where den = ? and categID in (select idParent from categ where idParent is not null)";

            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            ps.setString(1, categ.getDen());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               itIs = false;
            }
            
            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
        
        return itIs;
    }
    
}