<%-- 
    Document   : insertionClient
    Created on : 25 janv. 2024, 14:55:59
    Author     : tahir
--%>

<%@page import="entities.Genre"%>
<%@page import="entities.Poste"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Insertion des clients</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                      
                       <%
                                        session = request.getSession();
                                        ArrayList ls = (ArrayList) session.getAttribute("lsGenres");
                              %>

              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionClient">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Nom</label>
                  <input type="text" class="form-control" id="inputNanme4" name="nom">
                </div>
                  <div class="col-12">
                        <label for="inputNanme4" class="form-label">Genre</label>
                        <select name="genre" class="form-select">
                              <%  for (int idx = 0; idx < ls.size(); idx++) {
                                   Genre elem = (Genre) ls.get(idx); %>
                                   <option  value="<% out.print(elem.getId()); %>">
                                         <% out.print(elem.getNomgenre()); %>
                                   </option>
                             <% } %>
                        </select>
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
