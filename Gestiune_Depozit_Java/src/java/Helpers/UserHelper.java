/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Pojo.Log;
import Pojo.User;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author papad
 */
public class UserHelper {
    
    public static ArrayList<User> getUsers(String tip){
            ArrayList<User> users = new ArrayList<User>();
            String driver = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://127.0.0.1/";
            String database = "php";
            String userid = "root";
            String password = "";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet rs = null;

            try {
                connection = DriverManager.getConnection(connectionUrl + database, userid, password);
                String sql = "select * from login where tip = ? order by id_user;";
                statement = connection.prepareStatement(sql);
                statement.setString(1, tip);
                rs = statement.executeQuery();

                while (rs.next()) {
                    User user = new User();
                    user.setIdUser(Integer.parseInt(rs.getString("id_user")));
                    user.setName(rs.getString("name"));
                    Blob blob = rs.getBlob("poza");
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
                    user.setPoza(b64);
                    user.setNrTel(rs.getString("nr_telefon"));
                    user.setEmail(rs.getString("Email"));
                    user.setSex(rs.getString("Sex"));
                    user.setTara(rs.getString("Tara"));
                    users.add(user);
                    
                 }
            } catch (Exception ex) {
                
                ex.printStackTrace();
            }
            return users;
                }
      
    public static ArrayList<User> getAllUsers(){
        ArrayList<User> users = new ArrayList<User>();
            String driver = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://127.0.0.1/";
            String database = "php";
            String userid = "root";
            String password = "";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = null;
            Statement statement = null;
            ResultSet rs = null;

            try {
                connection = DriverManager.getConnection(connectionUrl + database, userid, password);
                statement = connection.createStatement();
                String sql = "select * from login order by id_user;";
                rs = statement.executeQuery(sql);

                while (rs.next()) {
                    User user = new User();
                    user.setIdUser(Integer.parseInt(rs.getString("id_user")));
                    user.setName(rs.getString("name"));
                    Blob blob = rs.getBlob("poza");
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
                    user.setPoza(b64);
                    user.setNrTel(rs.getString("nr_telefon"));
                    user.setEmail(rs.getString("Email"));
                    user.setSex(rs.getString("Sex"));
                    user.setTara(rs.getString("Tara"));
                    users.add(user);
                 }
            } catch (Exception ex) {
                
                ex.printStackTrace();
            }
            return users;
    }
    
    public static User getCurrentUser(String nume){
            User user = new User();
            String driver = "com.mysql.jdbc.Driver";
            String connectionUrl = "jdbc:mysql://127.0.0.1/";
            String database = "php";
            String userid = "root";
            String password = "";
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            Connection connection = null;
            PreparedStatement statement = null;
            ResultSet rs = null;

            try {
                connection = DriverManager.getConnection(connectionUrl + database, userid, password);
                String sql = "select * from login where name = ? ";
                statement = connection.prepareStatement(sql);
                statement.setString(1, nume);
                rs = statement.executeQuery();

                while (rs.next()) {
                    
                    user.setIdUser(Integer.parseInt(rs.getString("id_user")));
                    user.setName(rs.getString("name"));
                    user.setPass(rs.getString("pass"));
                    Blob blob = rs.getBlob("poza");
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
                    user.setPoza(b64);
                    user.setNrTel(rs.getString("nr_telefon"));
                    user.setEmail(rs.getString("Email"));
                    user.setSex(rs.getString("Sex"));
                    user.setTara(rs.getString("Tara"));
                    user.setTip(rs.getString("Tip"));

                 }
            } catch (Exception ex) {
                
                ex.printStackTrace();
            }
            return user;
                }
    
    public static void deleteUser(String numeUser){
            
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");
           
            Statement stmt = con.createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS=0");
            stmt.close();
            
            String sql = "delete from login where name = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, numeUser);
            ps.executeUpdate();
            
            Statement stm = con.createStatement();
            stm.execute("SET FOREIGN_KEY_CHECKS=1");
            stm.close();
            
            
            ps.close();
            con.close();

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
           
                }
    
}
