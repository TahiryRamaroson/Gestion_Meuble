<%@page import="entities.V_Employe_profil_poste"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>liste des employés</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              
              <% 
                    session = request.getSession();
                    ArrayList<V_Employe_profil_poste> ls = (ArrayList) session.getAttribute("lsEmploye");

                %>
              <!-- Table with stripped rows -->
              <table class="table datatable table-hover">
                  <thead>
                  <tr>
                    <th>Employé</th>
                    <th>Poste</th>
                    <th>Profil</th>
                    <th>Salaire</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (int idx = 0; idx < ls.size(); idx++) {
                            V_Employe_profil_poste elem = ls.get(idx); %>
                        <tr>
                            <td><% out.print(elem.getNomemploye()); %></td>
                            <td><% out.print(elem.getNomposte()); %></td>
                            <td><% out.print(elem.getNomouvrier()); %></td>
                            <td><% out.print(elem.getSalaire()); %> Ar</td>
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