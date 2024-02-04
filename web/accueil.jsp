<%-- 
    Document   : accueil
    Created on : 12 déc. 2023, 01:32:25
    Author     : tahir
--%>

<%@page import="entities.V_MatiereStyle"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Matière disponible pour ce style</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              
              <% 
                    session = request.getSession();
                    ArrayList<V_MatiereStyle> ls = (ArrayList) session.getAttribute("ls");

                %>
              <!-- Table with stripped rows -->
              <table class="table datatable table-hover">
                  <thead>
                  <tr>
                    <th>Nom Matiere</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (int idx = 0; idx < ls.size(); idx++) {
//                        V_MatiereStyle elem = ls.get(idx); %>
                        <tr>
                            <td><% out.print(ls.get(idx).getNommatiere()); %></td>
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