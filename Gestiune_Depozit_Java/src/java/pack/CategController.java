/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import Helpers.CategHelper;
import Helpers.ProdHelper;
import Helpers.UserHelper;
import Pojo.Categ;
import Pojo.Prod;
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
@WebServlet(name = "CategController", urlPatterns = {"/CategController"})
public class CategController extends HttpServlet {

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
        //ArrayList<String> categ = new ArrayList<String>();
        String categ = request.getParameter("submit");
        out.println("categ = "+categ);
        //categ = Helpers.CategHelper.getCateg(categ);
        
        Categ c;
        Boolean test;
        ArrayList<Categ> categs;
        ArrayList<Prod> prods;
        out.println("categ = "+categ);
        if(!"menu".equals(categ)){
            c = CategHelper.getCategDetails(categ);
            test = CategHelper.isLeaf(c);
            categs = CategHelper.getCategsOf(c);
            prods = ProdHelper.getProdsOfCateg(categ);
        
        }else{
            c = new Categ();
            test = false;
            categs = CategHelper.getCategsOf(c);
            prods = ProdHelper.getProdsOfCateg(categ);
            
        }
        
        session.setAttribute("prods", prods);
        session.setAttribute("categs", categs);
        session.setAttribute("categ", categ);
        session.setAttribute("test", test);
        
        for(Categ i : categs)
        out.println(i.getDen());
        response.sendRedirect(request.getContextPath() + "/CATEG.jsp?categ="+categ);
    }
}
