/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CakeAbout;
import model.DBContext;
import model.Product;

/**
 *
 * @author Nam Bui
 */
public class LoadProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        CakeAbout cakeAbout;
        if (request.getParameter("ID")!=null){
            int id = Integer.parseInt(request.getParameter("ID"));
            Product product = DBContext.getProduct(id);
            cakeAbout = new CakeAbout(product.getEntryName(), product.getEntryContent(), this.getServletContext().getContextPath() + "/images/" + product.getImage()); 
        }
        else {
            cakeAbout = DBContext.getCakeAbout();
            cakeAbout.setImage(this.getServletContext().getContextPath() + "/images/" + cakeAbout.getImage());
        }
        request.setAttribute("cakeAbout", cakeAbout);
        request.getRequestDispatcher("AboutMyCake.jsp").forward(request, response);
    }

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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoadProduct.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "Website are under mainternance");
            request.getRequestDispatcher("error.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(LoadProduct.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "Website are under mainternance");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
