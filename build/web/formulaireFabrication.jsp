<%-- 
    Document   : associationMatiereStyle
    Created on : 12 déc. 2023, 16:06:25
    Author     : tahir
--%>

<%@page import="entities.V_MatiereStyle"%>
<%@page import="entities.Meuble"%>
<%@page import="entities.Volume"%>
<%@page import="entities.Matiere"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Fabrication</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                <% 
                    session = request.getSession();
                    ArrayList lsMatieres = (ArrayList) session.getAttribute("lsMatSt");
                    ArrayList lsVolumes = (ArrayList) session.getAttribute("lsVol");
                    ArrayList lsMeubles = (ArrayList) session.getAttribute("lsMeub");

                %>
              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionFabrication">
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
                  <label for="inputNanme4" class="form-label">Matieres</label>
                  <select name="matiere" class="form-select">
                      <% for (int idx = 0; idx < lsMatieres.size(); idx++) {
                                  V_MatiereStyle elem = (V_MatiereStyle) lsMatieres.get(idx); %>
                                  <option  value="<% out.print(elem.getIdmatiere()); %>">
                                      <% out.print(elem.getNommatiere() ); %>
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
                  
                  <label for="inputNanme4" class="form-label">Quantite</label>
                  <input type="number" class="form-control" id="inputNanme4" name="qte" min="0">
                  <input type="hidden" class="form-control" id="inputNanme4" name="style" value="<% out.print(session.getAttribute("style")); %>">
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
