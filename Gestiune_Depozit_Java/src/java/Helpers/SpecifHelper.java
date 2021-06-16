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
import Pojo.Prod;
import Pojo.Specif;
import java.io.IOException;
import java.sql.Date;
/**
 *
 * @author papad
 */
public class SpecifHelper {
    
    public static ArrayList<Specif> getSpecifOfProd(Prod prod) {
        ArrayList<Specif> specs = new ArrayList<Specif>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select * from specif where produsID = (select produsID from prod where denumire = ?) ";

            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            ps.setString(1, prod.getDenumire());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                Specif s = new Specif();
                
                s.setSpecifID(Integer.parseInt(rs.getString("specifID")));
                s.setCuloare(rs.getString("culoare"));
                s.setMaterial(rs.getString("material"));
                s.setUtiliz(rs.getString("utiliz"));
                s.setProdusID(Integer.parseInt(rs.getString("produsID")));
                
                specs.add(s);
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {

        } catch (ClassNotFoundException ex) {

        }
        return specs;
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
    
    public static void insertSpec(String culoare, String utiliz, String material, int prodID) throws IOException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "insert into specif(culoare, utiliz, material, prodID) values(?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            
            ps.setString(1, culoare);
            ps.setString(2, utiliz);
            ps.setString(3, material);
            ps.setInt(4, prodID);
            
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
               
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        
    }
    
    
}
