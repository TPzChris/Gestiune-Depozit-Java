package pack;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author papad
 */
public class DB_Con {
    
     public static Connection getConnection()
    {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root","");
            JOptionPane.showMessageDialog(null, "Conectat");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Con.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Neconectat");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DB_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return con;
    }
  /*  public ArrayList<login> getLogin()
    {
            ArrayList<login> ListaLogin  = new ArrayList<login>();
            Connection con = getConnection();
            String query = "SELECT * FROM login";
            
            Statement st;
            ResultSet rs;
            
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            login login;
            
            while(rs.next())
            {
                login = new login(rs.getInt("id"),rs.getString("name"),rs.getString("pass"));
                ListaLogin.add(login);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Con.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ListaLogin; 
                
    }*/
}
