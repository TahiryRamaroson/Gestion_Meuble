<%-- 
    Document   : associationPosteSalaire
    Created on : 23 janv. 2024, 15:22:02
    Author     : tahir
--%>

<%@page import="entities.Poste"%>
<%@page import="entities.Ouvrier"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<main id="main" class="main">

          <div class="pagetitle">
                    <h1>Association un poste à un salaire de base</h1>
          </div><!-- End Page Title -->

          <div class="card">
                    <div class="card-body">
                              <%
                                        session = request.getSession();
                                        ArrayList ls = (ArrayList) session.getAttribute("lsPostes");
                              %>
                              <!-- Vertical Form -->
                              <form class="row g-3" method="post" action="InsertionAssocPosteSal">
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">Ouvrier</label>
                                                  <select name="poste" class="form-select">
                                                            <%  for (int idx = 0; idx < ls.size(); idx++) {
                                                                                Poste elem = (Poste) ls.get(idx); %>
                                                            <option  value="<% out.print(elem.getId()); %>">
                                                                      <% out.print(elem.getNomposte()); %>
                                                            </option>
                                                            <% } %>
                                                  </select>
                                                  <label for="inputNanme4" class="form-label">Salaire de base</label>
                                                  <input type="number" class="form-control" id="inputNanme4" name="salaire" min="0">
                                        </div>
                                        <br/>
                                        <div class="text-center">
                                                  <button type="submit" class="btn btn-primary">Valider</button>
                                        </div>
                              </form><!-- Vertical Form -->

                    </div>
          </div>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<%@include file="footer.jsp" %>
