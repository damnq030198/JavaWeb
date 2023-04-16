/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DBContext;
import DAO.FindUsController;
import DAO.HomeController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ContactInfor;
import model.Infor;
import model.Shared;

/**
 *
 * @author sonnhhe130366
 */
public class FindUs extends HttpServlet {

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
        FindUsController fc = new FindUsController();
        ArrayList<Shared> shareList = new ArrayList<>();
        ArrayList<Infor> inforOPList = new ArrayList<>();
        ArrayList<Infor> inforADList = new ArrayList<>();
        ArrayList<ContactInfor> contactInforList = new ArrayList<>();
        DBContext db = null;
        try {
            shareList = hc.getSocial();
            request.setAttribute("shareList", shareList);

            db = new DBContext();
            request.setAttribute("book", db.book);

            inforOPList = fc.getFindUs("op");
            request.setAttribute("inforOPList", inforOPList);

            inforADList = fc.getFindUs("ad");
            request.setAttribute("inforADList", inforADList);

            contactInforList = fc.getContactInfor();
            request.setAttribute("contactInforList", contactInforList);

            request.setAttribute("change", "findus");
            request.getRequestDispatcher("JSP/FindUs.jsp").forward(request, response);
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
