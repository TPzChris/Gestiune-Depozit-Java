/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import Helpers.UserHelper;
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
@WebServlet(name = "ClientExecuter", urlPatterns = {"/ClientExecuter"})
public class ClientController extends HttpServlet {

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
        
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            session.setAttribute("clients", UserHelper.getUsers("user"));
            response.sendRedirect(request.getContextPath() + "/CLIENTI.jsp");
        }else {
            //session = request.getSession(false);
            response.sendRedirect("login.html");
        }
    }
}
