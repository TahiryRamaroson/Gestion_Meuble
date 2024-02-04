<%-- 
    Document   : associationMatiereStyle
    Created on : 12 déc. 2023, 16:06:25
    Author     : tahir
--%>

<%@page import="entities.V_MatiereStyle"%>
<%@page import="entities.Meuble"%>
<%@page import="entities.Volume"%>
<%@page import="entities.Style"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Insertion Prix de vente</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                <% 
                    session = request.getSession();
                    ArrayList lsStyles = (ArrayList) session.getAttribute("lsStyles");
                    ArrayList lsVolumes = (ArrayList) session.getAttribute("lsVol");
                    ArrayList lsMeubles = (ArrayList) session.getAttribute("lsMeub");

                %>
              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionPrixVente">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Volumes</label>
                  <select name="volume" class="form-select">
                      <% for (int idx = 0; idx < lsVolumes.size(); idx++) {
                                  Volume elem = (Volume) lsVolumes.get(idx); %>
                                  <option value="<% out.print(elem.getId()); %>" >
                                      <% out.print(elem.getNomvolume()); %>
                                  </option>
                      <% } %>
                  </select >
                  <label for="inputNanme4" class="form-label">Styles</label>
                  <select name="style" class="form-select">
                      <% for (int idx = 0; idx < lsStyles.size(); idx++) {
                                  Style elem = (Style) lsStyles.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNomstyle() ); %>
                                  </option>
                      <% } %>
                  </select>
                  <label for="inputNanme4" class="form-label">Meubles</label>
                  <select name="meuble" class="form-select">
                      <% for (int idx = 0; idx < lsMeubles.size(); idx++) {
                                  Meuble elem = (Meuble) lsMeubles.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNommeuble()); %>
                                  </option>
                      <% } %>
                  </select>
                  
                  <label for="inputNanme4" class="form-label">Prix</label>
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

