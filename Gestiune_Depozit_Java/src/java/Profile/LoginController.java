package Profile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Helpers.CategHelper;
import com.twistedmatrix.AllJUnitTests;
import com.twistedmatrix.amp.TestAMP;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import junit.framework.Test;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userName = request.getParameter("uname");
        String pass = request.getParameter("pass");

        HttpSession ses = request.getSession();
        
        
        String userNameDB = "";
        String passwordDB = "";
        String typeDB = "";
        BufferedImage img = null;

        // validate given input
        if (userName.isEmpty() || pass.isEmpty()) {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            out.println("<font color=red>Completati toate campurile</font>");
            rd.include(request, response);
        } else {
            
            int flag = 0;
            
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root","");
           
                String query = "select * from login where name= ?";

                PreparedStatement ps = con.prepareStatement(query); // generates sql query

                ps.setString(1, userName);
                //ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();
                
                
                
                while (rs.next()) {
                    flag = 1;
                    userNameDB = rs.getString("name");
                    //passwordDB = rs.getString("pass");
                }
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(userNameDB != "")
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root","");
           
                String query = "select * from login where name= ? and pass = ?";

                PreparedStatement ps = con.prepareStatement(query); // generates sql query

                ps.setString(1, userNameDB);
                ps.setString(2, pass);

                ResultSet rs = ps.executeQuery();
                
                
                
                while (rs.next()) {
                    flag = 2;
                    //userNameDB = rs.getString("name");
                    passwordDB = rs.getString("pass");
                    typeDB = rs.getString("tip");
                    Blob blob = rs.getBlob("poza");
                    byte[] data = blob.getBytes(1, (int) blob.length());
                    
                    try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException e) {
                    e.printStackTrace();}
                }
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(flag == 0){
                
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                out.println("<font color=red>Utilizator incorect</font>");
                rd.include(request, response);
                
                out.close();
            }
            
            else if(flag == 1){
                
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                out.println("<font color=red>Parola incorecta</font>");
                rd.include(request, response);
                
                out.close();
            }
            else if (flag == 2) {
                
                ses.setAttribute("SES_NAME", userNameDB);
                ses.setAttribute("SES_TYPE", typeDB);
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( (BufferedImage) img, "jpg", baos );
                baos.flush();
                byte[] imageInByteArray = baos.toByteArray();
                baos.close();
                String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
                ses.setAttribute("SES_IMG", b64);

                response.sendRedirect(request.getContextPath() + "/ACASA.jsp");
            }
        }
    }
}
