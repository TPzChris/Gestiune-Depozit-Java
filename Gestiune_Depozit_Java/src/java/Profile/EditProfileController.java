/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

//import Helpers.UserHelper;
import Helpers.UserHelper;
import Pojo.User;
import com.mysql.jdbc.StringUtils;

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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author papad
 */
@WebServlet(name = "EditProfileExecuter", urlPatterns = {"/EditProfileExecuter"})
public class EditProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // TODO Auto-generated method stub
  
  HttpSession session = request.getSession();
  String sesName = session.getAttribute("SES_NAME").toString();
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();
  String userName = request.getParameter("Pname");
  String pass = request.getParameter("Ppass");
  String pass1 = request.getParameter("Ppass1");
  String email = request.getParameter("Pemail");
  String tel = request.getParameter("PTel");
  String gender = request.getParameter("gender");
  String tara = request.getParameter("country-select");
  


  if ((pass != "" || pass1 != "") && !pass.equals(pass1)){
    RequestDispatcher rd = request.getRequestDispatcher("PROFIL.jsp");
    out.println("<font color=red>Parolele nu coincid</font>");
    rd.include(request, response);       
    out.close();
    //session.setAttribute("a", 1 + pass + pass1);
    
  }else if(pass == "" || pass1 == ""){
    //session.setAttribute("a", 2 + userName + email + tel + gender + tara + sesName + pass);
    try {
       
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root",""); 

    String query = "update login set name = ?, email = ?, nr_telefon = ?, sex = ?, tara = ? where name = ?";

    PreparedStatement ps = con.prepareStatement(query); // generates sql query

    ps.setString(1, userName);
    ps.setString(2, email);
    ps.setString(3, tel);
    ps.setString(4, gender);
    ps.setString(5, tara);
    ps.setString(6, sesName);

    //session.setAttribute("b", ps.toString());
    
    ps.executeUpdate(); 
   
    ps.close();
    con.close();
    
    session.setAttribute("SES_NAME", userName);
   }catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
      }
   response.sendRedirect(request.getContextPath() + "/PROFIL.jsp");
   out.println("<font color=red>Cont actualizat cu succes</font>");  
  }else {
   //session.setAttribute("a", 3 + userName + email + tel + gender + tara + sesName + pass);
   try {
       
    Class.forName("com.mysql.jdbc.Driver");
    // loads mysql driver

    Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/php","root",""); 

    String query = "update login set name = ?, pass = ?, email = ?, nr_telefon = ?, sex = ?, tara = ? where name = ?";

    PreparedStatement ps = con.prepareStatement(query); // generates sql query

    ps.setString(1, userName);
    ps.setString(2, pass);
    ps.setString(3, email);
    ps.setString(4, tel);
    ps.setString(5, gender);
    ps.setString(6, tara);
    ps.setString(7, sesName);
    
    
    ps.executeUpdate(); 
   
    ps.close();
    con.close();
    session.setAttribute("SES_NAME", userName);
   }catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
      }
   response.sendRedirect(request.getContextPath() + "/PROFIL.jsp");
   out.println("<font color=red>Cont actualizat cu succes</font>");
   }
   
  }
}
