package Profile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UserDataServlet
 */
@MultipartConfig
public class RegistrationController extends HttpServlet {

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String userName = request.getParameter("uname");
  String pass = request.getParameter("pass");
  String pass1 = request.getParameter("pass1");
  String email = request.getParameter("email");
  String tel = request.getParameter("Tel");
  String gender = request.getParameter("gender");
  String tara = request.getParameter("country");
  
  Part filePart = request.getPart("avatar"); // Retrieves <input type="file" name="file">
  String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
  InputStream fileContent = filePart.getInputStream();
  
  //FileInputStream fin = new FileInputStream(filePart);
 int flag = 0;
  try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root","");

        String query = "select * from login where name= ?";

        PreparedStatement ps = con.prepareStatement(query); // generates sql query

        ps.setString(1, userName);
        
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            flag = 1;
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  try{
    Class.forName("com.mysql.jdbc.Driver");
    Connection con =  DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root","");

        String query = "select * from login where email= ?";

        PreparedStatement ps = con.prepareStatement(query); // generates sql query

        ps.setString(1, email);
        
        ResultSet rs = ps.executeQuery();

        if(rs.next()) {
            flag = 2;
        }
        rs.close();
        ps.close();
        con.close();
    } catch (SQLException ex) {
        Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    }
  
  
  // validate given input
  if (userName.isEmpty() || pass.isEmpty() || email.isEmpty() || tel.isEmpty() || gender.isEmpty() || tara.isEmpty()) {
   RequestDispatcher rd = request.getRequestDispatcher("register.html");
   out.println("<font color=red>Completati toate campurile</font>");
   rd.include(request, response);
  }else if (!pass.equals(pass1)){
    RequestDispatcher rd = request.getRequestDispatcher("register.html");
    out.println("<font color=red>Parolele nu coincid</font>");
    rd.include(request, response);       
  } else if(flag == 1){
                RequestDispatcher rd = request.getRequestDispatcher("register.html");
                out.println("<font color=red>Utilizator deja existent</font>");
                rd.include(request, response);  
          
                out.close();  
  }else if(flag == 2){
                RequestDispatcher rd = request.getRequestDispatcher("register.html");
                out.println("<font color=red>Email utilizat</font>");
                rd.include(request, response);
                
                out.close();  
  }else {
   
   try {
       
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root",""); 

    String query = "insert into login(name, pass, email, nr_telefon, sex, tara, tip, poza) values(?,?,?,?,?,?,'user',?)";

    PreparedStatement ps = con.prepareStatement(query); // generates sql query

    ps.setString(1, userName);
    ps.setString(2, pass);
    ps.setString(3, email);
    ps.setString(4, tel);
    ps.setString(5, gender);
    ps.setString(6, tara);
    ps.setBlob(7, fileContent);
    
    
    ps.executeUpdate(); 
   
    ps.close();
    con.close();
   }catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
      }
   response.sendRedirect(request.getContextPath() + "/login.html");
   out.println("<font color=red>Cont creat cu succes</font>");
   }
   
  }
 }

