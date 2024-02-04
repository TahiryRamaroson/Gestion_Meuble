<%--<%@page import="entities.V_Stock"%>--%>
<%@page import="entities.V_benefice_affichage"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Benefices</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              
              <% 
                    session = request.getSession();
                    ArrayList<V_benefice_affichage> ls = (ArrayList) session.getAttribute("lsbenefice");

                %>
              <!-- Table with stripped rows -->
              <table class="table datatable table-hover">
                  <thead>
                  <tr>
                    <th>Meuble</th>
                    <th>Style</th>
                    <th>Volume</th>
                    <th>Prix de vente</th>
                    <th>Salaire des employés</th>
                    <th>Prix des matières</th>
                    <th>Benefices</th>

                  </tr>
                </thead>
                <tbody>
                  <% for (int idx = 0; idx < ls.size(); idx++) {
                            V_benefice_affichage elem = ls.get(idx); %>
                        <tr>
                            <td><% out.print(elem.getNommeuble()); %></td>
                            <td><% out.print(elem.getNomstyle()); %></td>
                            <td><% out.print(elem.getNomvolume()); %></td>
                            <td><% out.print(elem.getPrixvente()); %> Ar</td>
                            <td><% out.print(elem.getSalairetotal()); %> Ar</td>
                            <td><% out.print(elem.getPrixmatiere()); %> Ar</td>
                            <td><% out.print(elem.getBenefice()); %> Ar</td>
                        </tr>       
                  <% } %>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
    </section>


  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@include file="footer.jsp" %>