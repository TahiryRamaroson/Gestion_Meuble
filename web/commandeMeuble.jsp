<%@page import="entities.Client"%>
<%@page import="entities.Style"%>
<%@page import="entities.Volume"%>
<%@page import="entities.Meuble"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Commande de Meubles</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                <% 
                    session = request.getSession();
                    ArrayList lsMeubles = (ArrayList) session.getAttribute("lsMeubles");
                    ArrayList lsTailles = (ArrayList) session.getAttribute("lsTailles");
                    ArrayList lsStyles = (ArrayList) session.getAttribute("lsStyles");
                    ArrayList lsClients = (ArrayList) session.getAttribute("lsClients");
                %>
              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionCommandeMeuble">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Meuble</label>
                  <select name="meuble" class="form-select">
                      <% for (int idx = 0; idx < lsMeubles.size(); idx++) {
                                  Meuble elem = (Meuble) lsMeubles.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNommeuble()); %>
                                  </option>
                      <% } %>
                  </select>
                  <label for="inputNanme4" class="form-label">Taille</label>
                  <select name="volume" class="form-select">
                      <% for (int idx = 0; idx < lsTailles.size(); idx++) {
                                  Volume elem = (Volume) lsTailles.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNomvolume()); %>
                                  </option>
                      <% } %>
                  </select>
                  <label for="inputNanme4" class="form-label">Style</label>
                  <select name="style" class="form-select">
                      <% for (int idx = 0; idx < lsStyles.size(); idx++) {
                                  Style elem = (Style) lsStyles.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNomstyle()); %>
                                  </option>
                      <% } %>
                  </select>
                  <label for="inputNanme4" class="form-label">Client</label>
                  <select name="client" class="form-select">
                      <% for (int idx = 0; idx < lsClients.size(); idx++) {
                                  Client elem = (Client) lsClients.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNomclient()); %>
                                  </option>
                      <% } %>
                  </select>
                  <label for="inputNanme5" class="form-label">Quantite</label>
                  <input type="number" class="form-control" id="inputNanme5" name="qte" min="0">
                   <label for="inputNanme5" class="form-label">Date</label>
                   <input type="datetime-local" class="form-control" id="inputNanme5" name="date" >
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
