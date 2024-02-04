/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import base.ConnexionDb;
import entities.CommandeMeuble;
import entities.Fabrication;
import entities.Matiere;
import entities.StockMatiere;
import entities.V_Stock;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Amboara
 */
public class InsertionCommandeMeuble extends HttpServlet {

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
        int qteInseree = Integer.parseInt(request.getParameter("qte"));
        java.sql.Connection c = null;
                    try {
                            c = new ConnexionDb("postgres", "meuble").getConnection();
                              
                              ArrayList<Fabrication> ls = Fabrication.getListById(c, request.getParameter("volume"), 
                                      request.getParameter("meuble"), request.getParameter("style"));
                              
                              /*for (Fabrication l : ls) {
                                  if (!V_Stock.checkQte(c, qteInseree*l.getQte(), l.getIdmatiere())) {
                                      throw new Exception("Quantité en stock insuffisant");
                                  }
                              }*/
                              HashMap<String, Integer> insuffisant = new HashMap<String, Integer>();
                              
                              for (Fabrication l : ls) {
                                  int qtestock = V_Stock.getQte(c, l.getIdmatiere());
                                  if ( qtestock < qteInseree*l.getQte()) {
                                      insuffisant.put(Matiere.getNom(c, l.getIdmatiere()), (qteInseree*l.getQte()) - qtestock);
                                  }
                              }
                              
                              if(insuffisant.isEmpty() == false){
                                        String erreur = "Quantité en stock insuffisant";
                                        for (Map.Entry<String, Integer> entry : insuffisant.entrySet()) {
                                                  erreur = erreur + " " + entry.getKey() + ":" + entry.getValue() + ",";
                                        }
                                        throw new Exception(erreur);
                              }
                              
                              for (Fabrication l : ls) {
                                  StockMatiere stm = new StockMatiere("0", ""+l.getIdmatiere(), "0", ""+qteInseree*l.getQte(), LocalDateTime.now().toString());
                                  stm.insert(c);
                              }
                              
                              if (ls.size()==0) {
                                  throw new Exception("Nous ne fabriquons pas encore le meuble que vous avez commandé");
                              } 
                              
                              CommandeMeuble cm = new CommandeMeuble("0", request.getParameter("meuble"),
                              request.getParameter("style"), request.getParameter("volume"), LocalDateTime.now().toString() ,""+qteInseree, request.getParameter("client"));
                              
                              cm.insert(c);
                              
                              c.close();
                              response.sendRedirect("LsMeubleCommande");
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
