/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Pojo.Log;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author papad
 */
public class LogHelper {
    
    
    public static void insertLog(Log log, String name, String date) throws IOException{
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

            String query = "insert into logs(operation, Date, idLogin) values(?, ?, (select id_user from login where name = ?))";
            
            PreparedStatement ps = con.prepareStatement(query); // generates sql query
            
            
            ps.setString(1, log.getOperation());
            ps.setString(2, date);
            ps.setString(3, name);
            
            
            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException ex) {
        } catch (ClassNotFoundException ex) {
        }
        
    }
    
}
