<%-- 
    Document   : formulairetravailouvrier
    Created on : 23 janv. 2024, 11:22:02
    Author     : tahir
--%>

<%@page import="entities.Poste"%>
<%@page import="entities.Ouvrier"%>
<%@page import="entities.Style"%>
<%@page import="entities.V_MatiereStyle"%>
<%@page import="entities.Meuble"%>
<%@page import="entities.Volume"%>
<%@page import="entities.Matiere"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Travail des ouvriers</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                      <br/>
                <% 
                    session = request.getSession();
                    ArrayList lsOuvriers = (ArrayList) session.getAttribute("lsOuvriers");
                    ArrayList lsStyles = (ArrayList) session.getAttribute("lsStyles");
                    ArrayList lsMeubles = (ArrayList) session.getAttribute("lsMeubles");
                    ArrayList lsVolumes = (ArrayList) session.getAttribute("lsVolumes");
                    ArrayList lsPostes = (ArrayList) session.getAttribute("lsposte");
                %>
              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionTravailOuvrier">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Styles</label>
                  <select name="style" class="form-select">
                      <% for (int idx = 0; idx < lsStyles.size(); idx++) {
                                  Style elem = (Style) lsStyles.get(idx); %>
                                  <option value="<% out.print(elem.getId()); %>" >
                                      <% out.print(elem.getNomstyle()); %>
                                  </option>
                      <% } %>
                  </select >
                  <br/>
                  <label for="inputNanme4" class="form-label">Meubles</label>
                  <select name="meuble" class="form-select">
                      <% for (int idx = 0; idx < lsMeubles.size(); idx++) {
                                  Meuble elem = (Meuble) lsMeubles.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNommeuble()); %>
                                  </option>
                      <% } %>
                  </select>
                  <br/>
                  <label for="inputNanme4" class="form-label">Volumes</label>
                  <select name="volume" class="form-select">
                      <% for (int idx = 0; idx < lsVolumes.size(); idx++) {
                                  Volume elem = (Volume) lsVolumes.get(idx); %>
                                  <option  value="<% out.print(elem.getId()); %>">
                                      <% out.print(elem.getNomvolume()); %>
                                  </option>
                      <% } %>
                  </select>
                  <br/>
            
                  
                  <% for (int idx = 0; idx < lsOuvriers.size(); idx++) {
                                  Ouvrier elem = (Ouvrier) lsOuvriers.get(idx); %>
                                  <% for (int idy = 0; idy < lsPostes.size(); idy++) {
                                        Poste elemp = (Poste) lsPostes.get(idy); %>
                                  
                   <div class='row'>
                             <div class='col-4'>
                                      <label for="inputNanme4" class="form-label"> <% out.print(elemp.getNomposte()); %> <% out.print(elem.getNomouvrier()); %></label>
                            </div>
                            <div class='col-4'>
                                      <label for="inputNanme4" class="form-label">Nombre</label>
                                      <input type="number" class="form-control" id="inputNanme4" name="nb<% out.print(elem.getNomouvrier()); %>_<% out.print(elemp.getNomposte()); %>" min="0" value='0'>
                            </div>
                            <div class='col-4'>
                                      <label for="inputNanme4" class="form-label">Durée de travail (h)</label>
                                      <input type="number" class="form-control" id="inputNanme4" name="duree<% out.print(elem.getNomouvrier()); %>_<% out.print(elemp.getNomposte()); %>" min="0" value='0'>
                            </div>
                  </div>
                            <br/>
                              
                  <% }} %>
                  
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
