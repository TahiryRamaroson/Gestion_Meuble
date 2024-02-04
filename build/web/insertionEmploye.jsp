<%-- 
    Document   : insertionEmploye
    Created on : 23 janv. 2024, 15:33:09
    Author     : tahir
--%>

<%@page import="entities.Poste"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Insertion des employés</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                      
                       <%
                                        session = request.getSession();
                                        ArrayList ls = (ArrayList) session.getAttribute("lsPostes");
                              %>

              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionEmploye">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Nom</label>
                  <input type="text" class="form-control" id="inputNanme4" name="nom">
                </div>
                  <div class="col-12">
                        <label for="inputNanme4" class="form-label">Poste</label>
                        <select name="poste" class="form-select">
                              <%  for (int idx = 0; idx < ls.size(); idx++) {
                                   Poste elem = (Poste) ls.get(idx); %>
                                   <option  value="<% out.print(elem.getId()); %>">
                                         <% out.print(elem.getNomposte()); %>
                                   </option>
                             <% } %>
                        </select>
                       <label for="inputNanme4" class="form-label">Date Embauche</label>
                       <input type="datetime-local" class="form-control" id="inputNanme4" name="embauche">
                  </div>
                                        <br/>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form><!-- Vertical Form -->

            </div>
          </div>
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
<%@include file="footer.jsp" %>
