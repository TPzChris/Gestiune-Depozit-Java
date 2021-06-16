/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import Helpers.CategHelper;
import Helpers.ProdHelper;
import Helpers.SpecifHelper;
import Helpers.UserHelper;
import Pojo.Categ;
import Pojo.Prod;
import Pojo.Specif;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "SearchController", urlPatterns = {"/SearchController"})
public class SearchController extends HttpServlet {

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
        
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        
        String search = request.getParameter("search");
        Prod p = ProdHelper.getProd(search);
        ArrayList<Specif> specs = SpecifHelper.getSpecifOfProd(p);
        
        session.setAttribute("prod", p);
        session.setAttribute("search", search);
        session.setAttribute("specs", specs);
        session.setAttribute("culoare", specs.get(0).getCuloare());
        
        response.sendRedirect(request.getContextPath() + "/PROD.jsp?prod="+search+"&culoare="+specs.get(0).getCuloare());
    }
}
