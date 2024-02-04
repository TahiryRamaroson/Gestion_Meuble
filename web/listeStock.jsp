<%@page import="entities.V_Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Stock disponible</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              
              <% 
                    session = request.getSession();
                    ArrayList<V_Stock> ls = (ArrayList) session.getAttribute("lsStock");

                %>
              <!-- Table with stripped rows -->
              <table class="table datatable table-hover">
                  <thead>
                  <tr>
                    <th>Matiere</th>
                    <th>Quantite</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (int idx = 0; idx < ls.size(); idx++) {
                            V_Stock elem = ls.get(idx); %>
                        <tr>
                            <td><% out.print(elem.getNommatiere()); %></td>
                            <td><% out.print(elem.getTotalqte()); %></td>
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