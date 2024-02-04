<%-- 
    Document   : associationOuvrierExp
    Created on : 23 janv. 2024, 16:06:57
    Author     : tahir
--%>

<%@page import="entities.Ouvrier"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<main id="main" class="main">

          <div class="pagetitle">
                    <h1>Association profil et experience</h1>
          </div><!-- End Page Title -->

          <div class="card">
                    <div class="card-body">
                              <%
                                        session = request.getSession();
                                        ArrayList ls = (ArrayList) session.getAttribute("lsOuvriers");
                              %>
                              <!-- Vertical Form -->
                              <form class="row g-3" method="post" action="InsertionAssocOuvrierExp">
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">Profil</label>
                                                  <select name="ouvrier" class="form-select">
                                                            <%  for (int idx = 0; idx < ls.size(); idx++) {
                                                                                Ouvrier elem = (Ouvrier) ls.get(idx); %>
                                                            <option  value="<% out.print(elem.getId()); %>">
                                                                      <% out.print(elem.getNomouvrier()); %>
                                                            </option>
                                                            <% } %>
                                                  </select>
                                                  <label for="inputNanme4" class="form-label">Expérience debut</label>
                                                  <input type="number" class="form-control" id="inputNanme4" name="expdebut" min="0">
                                                  
                                                  <label for="inputNanme4" class="form-label">Expérience fin</label>
                                                  <input type="number" class="form-control" id="inputNanme4" name="expfin" min="0">
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