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
@WebServlet(name = "FilterController", urlPatterns = {"/FilterController"})
public class FilterController extends HttpServlet {

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
        
        int min = Integer.parseInt(request.getParameter("one"));
        int max = Integer.parseInt(request.getParameter("two"));
        
        String path = request.getParameter("hid");
        String categ = session.getAttribute("categ").toString();
        
        ArrayList<Prod> prods = ProdHelper.getProdsFiltered(categ, min, max);
        
        session.setAttribute("prods", prods); 
        session.setAttribute("max", max);
        session.setAttribute("min", min);
        
        response.sendRedirect(request.getContextPath() + "/CATEG.jsp?categ="+path);
        
    }
}
