<%-- 
    Document   : associationMatiereStyle
    Created on : 12 déc. 2023, 16:06:25
    Author     : tahir
--%>

<%@page import="entities.Matiere"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<main id="main" class="main">

          <div class="pagetitle">
                    <h1>Association un prix à une matière</h1>
          </div><!-- End Page Title -->

          <div class="card">
                    <div class="card-body">
                              <%
                                        session = request.getSession();
                                        ArrayList lsMatieres = (ArrayList) session.getAttribute("lsMatieres");
                                        ArrayList lsStyles = (ArrayList) session.getAttribute("lsStyles");

                              %>
                              <!-- Vertical Form -->
                              <form class="row g-3" method="post" action="InsertionAssocPrixMatiere">
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">Matiere</label>
                                                  <select name="matiere" class="form-select">
                                                            <% for (int idx = 0; idx < lsMatieres.size(); idx++) {
                                                                                Matiere elem = (Matiere) lsMatieres.get(idx); %>
                                                            <option  value="<% out.print(elem.getId()); %>">
                                                                      <% out.print(elem.getNommatiere()); %>
                                                            </option>
                                                            <% }%>
                                                  </select>
                                                  <label for="inputNanme4" class="form-label">prix</label>
                                                  <input type="number" class="form-control" id="inputNanme4" name="prix" min="0">
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
