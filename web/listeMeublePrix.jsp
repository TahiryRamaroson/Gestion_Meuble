<%@page import="entities.V_SumPrix"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Meubles disponible pour ces prix</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              
              <% 
                    session = request.getSession();
                    ArrayList<V_SumPrix> ls = (ArrayList) session.getAttribute("lsprix");

                %>
              <!-- Table with stripped rows -->
              <table class="table datatable table-hover">
                  <thead>
                  <tr>
                    <th>Meuble</th>
                    <th>Volume</th>
                    <th>Style</th>
                    <th>Prix Total</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (int idx = 0; idx < ls.size(); idx++) {
                            V_SumPrix elem = ls.get(idx); %>
                        <tr>
                            <td><% out.print(elem.getNommeuble()); %></td>
                            <td><% out.print(elem.getNomvolume()); %></td>
                            <td><% out.print(elem.getNomstyle()); %></td>
                            <td><% out.print(elem.getPrixtotal()); %></td>
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