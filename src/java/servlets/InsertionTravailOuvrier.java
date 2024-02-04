/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import base.ConnexionDb;
import entities.FormuleOuvrier;
import entities.Ouvrier;
import entities.Poste;
import entities.TravailOuvrier;
import entities.Volume;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tahir
 */
public class InsertionTravailOuvrier extends HttpServlet {

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
                    
                    String idstyle = request.getParameter("style");
                    String idmeuble = request.getParameter("meuble");
                    String idvolume = request.getParameter("volume");
                    
                    

                    java.sql.Connection c = null;
                    try {
                              c = new ConnexionDb("postgres", "meuble").getConnection();
                              ArrayList<Ouvrier> lsOuvriers = Ouvrier.selectAll(c);
                              ArrayList<Poste> lsPostes = Poste.selectAll(c);
                              int nbouvrier = FormuleOuvrier.getNbouvrierbyIdvolume(c, Integer.parseInt(idvolume));
                              
                              int nbform = 0;
                              
                              for(Ouvrier ouv : lsOuvriers){
                                        for(Poste po : lsPostes){
                                        nbform = nbform + Integer.parseInt(request.getParameter("nb"+ouv.getNomouvrier()+"_"+po.getNomposte()));
                                        }
                              }
                              
                              if(nbform != nbouvrier) throw new Exception("total de nombre d'ouvrier invalide");
                              
                              for(Ouvrier ouv : lsOuvriers){
                                        for(Poste po : lsPostes){
                                                  if(Integer.parseInt(request.getParameter("nb"+ouv.getNomouvrier()+"_"+po.getNomposte())) == 0 || Double.parseDouble(request.getParameter("duree"+ouv.getNomouvrier()+"_"+po.getNomposte())) == 0) continue;
                                                  TravailOuvrier trav = new TravailOuvrier("0", idmeuble, idstyle, idvolume, ""+ouv.getId(), ""+po.getId(), request.getParameter("nb"+ouv.getNomouvrier()+"_"+po.getNomposte()), request.getParameter("duree"+ouv.getNomouvrier()+"_"+po.getNomposte()), LocalDateTime.now().toString());
                                                  trav.insert(c); 
                                        }
                              }
                              
                              response.sendRedirect("formuleouvrier.jsp");
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
