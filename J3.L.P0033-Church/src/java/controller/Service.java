/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBContext;
import DAO.HomeController;
import DAO.HtmlHelper;
import DAO.MenuController;
import DAO.ServiceController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Serviced;
import model.Shared;

/**
 *
 * @author sonnhhe130366
 */
public class Service extends HttpServlet {

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
        ServiceController mc = new ServiceController();
        HtmlHelper help = new HtmlHelper();
        HomeController hc = new HomeController();
        String page = request.getParameter("page");
        ArrayList<Shared> shareList = new ArrayList<>();
        ArrayList<Serviced> pagingList = new ArrayList<>();
        DBContext db = null;
        int totalrow = 0;

        int pageindex = 0;
        int pagesize = 3;
        int totalpage = 0;
        String paging = "";
        try {
            try {
                shareList = hc.getSocial();
                request.setAttribute("shareList", shareList);
                db = new DBContext();
                request.setAttribute("book", db.book);
                if (page == null || page.equals("page")) {
                    page = "1";
                } else if (!page.matches("[0-9]+")) {
                    request.setAttribute("error", true);
                }
                pageindex = Integer.parseInt(page);
                totalrow = mc.count();
                totalpage = (totalrow + pagesize - 1) / pagesize;
                if (pageindex > totalpage) {
                    request.setAttribute("error", true);
                } else {
                    pagingList = mc.getServiceList(pageindex, pagesize);
                    request.setAttribute("pagingList", pagingList);
                    paging = help.pager(pageindex, pagesize, totalpage + 1);
                    request.setAttribute("pagesize", pagesize);
                    request.setAttribute("paging", paging);
                }
            } catch (Exception e) {
                request.setAttribute("error", true);
            }
            request.setAttribute("change", "service");
            request.getRequestDispatcher("JSP/Service.jsp").forward(request, response);
        } catch (Exception e) {
            e.getMessage();
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
