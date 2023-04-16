/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBContext;
import DAO.HomeController;
import DAO.HtmlHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Shared;
import model.Visit;

/**
 *
 * @author sonnhhe130366
 */
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HomeController hc = new HomeController();
        ArrayList<Shared> shareList = new ArrayList<>();
        ArrayList<Article> menuImg = new ArrayList<>();
        Article homeImg = new Article();
        Article welcome = new Article();
        Article about = new Article();
        Article sign = new Article();
        HtmlHelper help = new HtmlHelper();
        DBContext db = null;
        String page = request.getParameter("page");
        int totalrow = 0;

        int pageindex = 0;
        int pagesize = 2;
        int totalpage = 0;
        String paging = "";
        try {
            try {
                shareList = hc.getSocial();
                request.setAttribute("shareList", shareList);
                db = new DBContext();
                request.setAttribute("book", db.book);
                homeImg = hc.getAbout("999");
                request.setAttribute("homeImg", homeImg);
                welcome = hc.getAbout("0");
                request.setAttribute("welcome", welcome);
                about = hc.getAbout("998");
                request.setAttribute("about", about);
                sign = hc.getAbout("997");
                request.setAttribute("sign", sign);
                request.setAttribute("change", "home");

                if (page == null || page.equals("page")) {
                    page = "1";
                }
                pageindex = Integer.parseInt(page);

                menuImg = hc.getMenu();
                request.setAttribute("pagingList", menuImg);
                paging = help.pager(pageindex, pagesize, totalpage + 1);
                request.setAttribute("pagesize", pagesize);
                request.setAttribute("paging", paging);
                request.setAttribute("menuImg", menuImg);

            } catch (Exception e) {
                request.setAttribute("error", true);
            }
            request.getRequestDispatcher("JSP/Home.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("JSP/PageNotFound.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
