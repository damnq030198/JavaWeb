/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBContext;
import DAO.HomeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Shared;

/**
 *
 * @author sonnhhe130366
 */
public class MenuItem extends HttpServlet {

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
        String id = request.getParameter("id");
        HomeController hc = new HomeController();
        ArrayList<Shared> shareList = new ArrayList<>();
        Article artMenuItem = new Article();
        DBContext db = null;
        try {
            try {
                shareList = hc.getSocial();
                request.setAttribute("shareList", shareList);
                db = new DBContext();
                request.setAttribute("book", db.book);
                if (!id.matches("[0-9]+")) {
                    request.setAttribute("error", true);
                }
                int idInt = Integer.parseInt(id);
                artMenuItem = hc.getDetail(idInt+ "");
                if (artMenuItem.getId() == null) {
                    request.setAttribute("error", true);
                }
                request.setAttribute("artMenuItem", artMenuItem);
            } catch (Exception e) {
                request.setAttribute("error", true);
            }
            request.getRequestDispatcher("JSP/MenuItem.jsp").forward(request, response);
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
