/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import base.ConnexionDb;
import entities.Client;
import entities.Meuble;
import entities.Style;
import entities.Volume;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Amboara
 */
public class LsMeubleCommande extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        java.sql.Connection c = null;
                    try {
                              c = new ConnexionDb("postgres", "meuble").getConnection();

                              ArrayList ls = Meuble.selectAll(c);
                              ArrayList lst = Volume.selectAll(c);
                              ArrayList lstl = Style.selectAll(c);
                              ArrayList lstc = Client.selectAll(c);

                              HttpSession session = request.getSession();
                              session.setAttribute("lsMeubles", ls);
                              session.setAttribute("lsTailles", lst);
                              session.setAttribute("lsStyles", lstl);
                              session.setAttribute("lsClients", lstc);

//            RequestDispatcher rqd = request.getRequestDispatcher("associationMatiereStyle.jsp");
//            rqd.forward(request, response);
                              response.sendRedirect("commandeMeuble.jsp");
                    } catch (Exception e) {
                              e.printStackTrace();
                              request.setAttribute("error", e.getMessage());
                              RequestDispatcher dispatch = request.getRequestDispatcher("error.jsp");
                              dispatch.forward(request, response);
                    } finally {
                              try {
                                        c.close();
                              } catch (Exception ex) {
                                        ex.printStackTrace();
                              }
                    }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
