package Profile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Helpers.CategHelper;
import Helpers.UserHelper;
import Pojo.User;
import com.twistedmatrix.AllJUnitTests;
import com.twistedmatrix.amp.TestAMP;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.websocket.Session;
import junit.framework.Test;
import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class LoginController
 */
@MultipartConfig
public class ImageController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession ses = request.getSession();
        PrintWriter out = response.getWriter();

        Part filePart = request.getPart("fpic"); // Retrieves <input type="file" name="file">
        String name = (String) ses.getAttribute("SES_NAME");
        BufferedImage img = null;

        // validate given input
        if (filePart == null) {
            response.sendRedirect(request.getContextPath() + "/PROFIL.jsp");
            out.println("nu");
        } else {
            InputStream fileContent = filePart.getInputStream();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php", "root", "");

                
                String query = "update login set poza = ? where name =";
                query += "'" + name + "'";
                PreparedStatement ps = con.prepareStatement(query); // generates sql query

                ps.setBlob(1, fileContent);
                //ps.setString(2, pass);

                ps.executeUpdate();
                

                ps.close();
                con.close();
                
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ImageController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            /*
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root","");
           
                String query = "select poza from login where name= ?";

                PreparedStatement ps = con.prepareStatement(query); // generates sql query

                ps.setString(1, name);

                ResultSet rs = ps.executeQuery();
                
                
                
                while (rs.next()) {
                   
                    
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
                
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write( (BufferedImage) img, "jpg", baos );
                baos.flush();
                byte[] imageInByteArray = baos.toByteArray();
                baos.close();
                String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
                ses.setAttribute("SES_IMG", b64);

                response.sendRedirect(request.getContextPath() + "/PROFIL.jsp");
                out.println("<script>alert('Poza de profil a fost schimbata cu succes!');</script>");
       
                
            } catch (SQLException ex) {
                
            } catch (ClassNotFoundException ex) {
               
            }*/
            
            String n = ses.getAttribute("SES_NAME").toString();
            User user = UserHelper.getCurrentUser(n);
            ses.setAttribute("currentPic", user);
            ses.setAttribute("SES_IMG", user.getPoza());
            response.sendRedirect(request.getContextPath() + "/PROFIL.jsp");
            out.println("<script>alert('Poza de profil a fost schimbata cu succes!');</script>");
       
        }

        out.close();
    }

}
