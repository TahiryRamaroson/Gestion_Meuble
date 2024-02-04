<%-- 
    Document   : choixStat
    Created on : 25 janv. 2024, 16:05:25
    Author     : tahir
--%>

<%@page import="entities.Volume"%>
<%@page import="entities.Style"%>
<%@page import="entities.Meuble"%>
<%@page import="entities.Poste"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Filtre</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">
                      
                       <%
                                        session = request.getSession();
                                        ArrayList ls = (ArrayList) session.getAttribute("lsStyles");
                                        ArrayList lsv = (ArrayList) session.getAttribute("lsVolumes");
                                        ArrayList lsm = (ArrayList) session.getAttribute("lsMeubles");
                              %>

              <!-- Vertical Form -->
              <br/>
              <a href="FiltreTous"> Tous les produits</a>
              <form class="row g-3" method="post" action="FiltrePrecis">
                  <div class="col-12">
                            <br/>
                        <label for="inputNanme4" class="form-label">Meuble</label>
                        <select name="meuble" class="form-select">
                              <%  for (int idx = 0; idx < lsm.size(); idx++) {
                                   Meuble elem = (Meuble) lsm.get(idx); %>
                                   <option  value="<% out.print(elem.getId()); %>">
                                         <% out.print(elem.getNommeuble()); %>
                                   </option>
                             <% } %>
                        </select>
                        <label for="inputNanme4" class="form-label">Style</label>
                        <select name="style" class="form-select">
                              <%  for (int idx = 0; idx < ls.size(); idx++) {
                                   Style elem = (Style) ls.get(idx); %>
                                   <option  value="<% out.print(elem.getId()); %>">
                                         <% out.print(elem.getNomstyle()); %>
                                   </option>
                             <% } %>
                        </select>
                        <label for="inputNanme4" class="form-label">Volume</label>
                        <select name="volume" class="form-select">
                              <%  for (int idx = 0; idx < lsv.size(); idx++) {
                                   Volume elem = (Volume) lsv.get(idx); %>
                                   <option  value="<% out.print(elem.getId()); %>">
                                         <% out.print(elem.getNomvolume()); %>
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
