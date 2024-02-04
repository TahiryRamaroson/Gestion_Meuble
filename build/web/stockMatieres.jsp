<%@page import="entities.Matiere"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Voir le Stock des Matières</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                <% 
                    session = request.getSession();
                    ArrayList lsMatieres = (ArrayList) session.getAttribute("lsMatieres");

                %>
              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Matiere</label>
                  <select name="matiere" class="form-select">
                      <% for (int idx = 0; idx < lsMatieres.size(); idx++) {
                                  Matiere elem = (Matiere) lsMatieres.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNommatiere() ); %>
                                  </option>
                      <% } %>
                  </select>
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
