/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import base.ConnexionDb;
import entities.Client;
import entities.Employe;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tahir
 */
public class InsertionClient extends HttpServlet {

          /**
           * Processes requests for both HTTP <code>GET</code> and
           * <code>POST</code> methods.
           *
           * @param request servlet request
           * @param response servlet response
           * @throws ServletException if a servlet-specific error occurs
           * @throws IOException if an I/O error occurs
           */
          protected void processRequest(HttpServletRequest request, HttpServletResponse response)
                  throws ServletException, IOException {
                    response.setContentType("text/html;charset=UTF-8");
                    String nom = request.getParameter("nom");
                    String idgenre = request.getParameter("genre");

                    java.sql.Connection c = null;
                    try {
                              c = new ConnexionDb("postgres", "meuble").getConnection();
                              Client cli = new Client("0", nom, idgenre);
                              cli.insert(c);
                              
                              
                              
                              response.sendRedirect("insertionClient.jsp");
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
