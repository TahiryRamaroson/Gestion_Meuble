<%-- 
    Document   : associationOuvrierSalaire
    Created on : Jan 16, 2024, 2:48:11 PM
    Author     : Amboara
--%>

<%@page import="entities.Ouvrier"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<main id="main" class="main">

          <div class="pagetitle">
                    <h1>Association un ouvrier a un salaire</h1>
          </div><!-- End Page Title -->

          <div class="card">
                    <div class="card-body">
                              <%
                                        session = request.getSession();
                                        ArrayList ls = (ArrayList) session.getAttribute("lsOuvriers");
                              %>
                              <!-- Vertical Form -->
                              <form class="row g-3" method="post" action="InsertionAssocOuvrierSal">
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">Ouvrier</label>
                                                  <select name="ouvrier" class="form-select">
                                                            <%  for (int idx = 0; idx < ls.size(); idx++) {
                                                                                Ouvrier elem = (Ouvrier) ls.get(idx); %>
                                                            <option  value="<% out.print(elem.getId()); %>">
                                                                      <% out.print(elem.getNomouvrier()); %>
                                                            </option>
                                                            <% } %>
                                                  </select>
                                                  <label for="inputNanme4" class="form-label">Salaire</label>
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
