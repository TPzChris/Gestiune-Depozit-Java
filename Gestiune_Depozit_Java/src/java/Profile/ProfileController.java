/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Profile;

//import Helpers.UserHelper;
import Helpers.UserHelper;
import Pojo.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author papad
 */
@WebServlet(name = "ProfileExecuter", urlPatterns = {"/ProfileExecuter"})
public class ProfileController extends HttpServlet {

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
        
        HttpSession session = request.getSession();
            //session.setAttribute("clients", UserHelper.getUsers("user"));
            //response.sendRedirect(request.getContextPath() + "/CLIENTI.jsp");
  
            //session = request.getSession(false);
        String name = session.getAttribute("SES_NAME").toString();
        User user = UserHelper.getCurrentUser(name);
        session.setAttribute("current", user);
        response.sendRedirect(request.getContextPath() + "/PROFIL.jsp");
        
    }
}
