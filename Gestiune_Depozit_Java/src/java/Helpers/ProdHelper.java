/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Pojo.Categ;
import Pojo.Prod;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author papad
 */
public class ProdHelper {
    
    public static Prod getProd(String den) throws IOException{
        Prod p = new Prod();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select * from prod where denumire = ?";

            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            ps.setString(1, den);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p.setProdusID(Integer.parseInt(rs.getString("produsID")));
                p.setDenumire(den);
                p.setStoc(Float.parseFloat(rs.getString("stoc")));
                p.setDataAparitiei(rs.getDate("dataAparitiei"));
                p.setDescriere(rs.getString("descriere"));
                p.setPret(Float.parseFloat(rs.getString("pret")));
                Blob blob = rs.getBlob("imagine");
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write((BufferedImage) img, "jpg", baos);
                    baos.flush();
                    byte[] imageInByteArray = baos.toByteArray();
                    baos.close();
                    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
                p.setImagine(b64);
                p.setCategID(Integer.parseInt(rs.getString("categID")));  
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return p;
    }
 
    public static ArrayList<Prod> getProdsOfCateg(String categ) throws IOException{
        ArrayList<Prod> prods = new ArrayList<Prod>();
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select * from prod where categID = (select categID from categ where den = ?)";

            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            ps.setString(1, categ);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prod p = new Prod();
                p.setProdusID(Integer.parseInt(rs.getString("produsID")));
                p.setDenumire(rs.getString("denumire"));
                p.setStoc(Float.parseFloat(rs.getString("stoc")));
                p.setDataAparitiei(rs.getDate("dataAparitiei"));
                p.setDescriere(rs.getString("descriere"));
                p.setPret(Float.parseFloat(rs.getString("pret")));
                Blob blob = rs.getBlob("imagine");
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write((BufferedImage) img, "jpg", baos);
                    baos.flush();
                    byte[] imageInByteArray = baos.toByteArray();
                    baos.close();
                    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
                p.setImagine(b64);
                p.setCategID(Integer.parseInt(rs.getString("categID"))); 
                prods.add(p);
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return prods;
    }
    
   public static ArrayList<Prod> getProdsFiltered(String categ, int min, int max) throws IOException{
        ArrayList<Prod> prods = new ArrayList<Prod>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "select * from prod where categID = (select categID from categ where den = ?) and pret between ? and ?";

            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            ps.setString(1, categ);
            ps.setString(2, Integer.toString(min));
            ps.setString(3, Integer.toString(max));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Prod p = new Prod();
                p.setProdusID(Integer.parseInt(rs.getString("produsID")));
                p.setDenumire(rs.getString("denumire"));
                p.setStoc(Float.parseFloat(rs.getString("stoc")));
                p.setDataAparitiei(rs.getDate("dataAparitiei"));
                p.setDescriere(rs.getString("descriere"));
                p.setPret(Float.parseFloat(rs.getString("pret")));
                Blob blob = rs.getBlob("imagine");
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    BufferedImage img = null;
                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write((BufferedImage) img, "jpg", baos);
                    baos.flush();
                    byte[] imageInByteArray = baos.toByteArray();
                    baos.close();
                    String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
                p.setImagine(b64);
                p.setCategID(Integer.parseInt(rs.getString("categID")));
                
                prods.add(p);
            }
            //out.println(rs.getString("den")+pagina);

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        return prods;
    }
   
   public static void insertProd(String den, float stoc, Date dataAparitiei, String descriere, float pret, String img, int categID) throws IOException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "insert into prod(denumire, stoc, dataAparitiei, descriere, pret, imagine, categID) values(?,?,?,?,?,?,?)";
            
            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            
            ps.setString(1, den);
            ps.setFloat(2, stoc);
            ps.setDate(3, dataAparitiei);
            ps.setString(4, descriere);
            ps.setFloat(5, pret);
            ps.setString(6, img);
            ps.setInt(7, categID);
            
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
