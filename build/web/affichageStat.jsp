<%-- 
    Document   : affichageStat
    Created on : 25 janv. 2024, 16:13:34
    Author     : tahir
--%>

<%@page import="entities.V_stat_complet"%>
<%@page import="entities.V_Employe_profil_poste"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Statistique</h1>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              
              <% 
                    session = request.getSession();
                    ArrayList<V_stat_complet> ls = (ArrayList) session.getAttribute("lsstat");
                    ArrayList<Integer> data = (ArrayList) session.getAttribute("data");
                    ArrayList<String> label = (ArrayList) session.getAttribute("label");

                %>
              <!-- Table with stripped rows -->
              <table class="table datatable table-hover">
                  <thead>
                  <tr>
                    <th>nombre de vente</th>
                    <th>meuble</th>
                    <th>style</th>
                    <th>volume</th>
                    <th>genre</th>
                  </tr>
                </thead>
                <tbody>
                  <% for (int idx = 0; idx < ls.size(); idx++) {
                            V_stat_complet elem = ls.get(idx); %>
                        <tr>
                            <td><% out.print(elem.getNbvente()); %></td>
                            <td><% out.print(elem.getNommeuble()); %></td>
                            <td><% out.print(elem.getNomstyle()); %></td>
                            <td><% out.print(elem.getNomvolume()); %> </td>
                            <td><% out.print(elem.getNomgenre()); %> </td>
                        </tr>       
                  <% } %>
                </tbody>
              </table>
              <!-- End Table with stripped rows -->

            </div>
          </div>

        </div>
      </div>
                
                <div class="col-12">
              <div class="card">

                <div class="filter">
                  <a class="icon" href="#" data-bs-toggle="dropdown"><i class="bi bi-three-dots"></i></a>
                  <ul class="dropdown-menu dropdown-menu-end dropdown-menu-arrow">
                    <li class="dropdown-header text-start">
                      <h6>Filter</h6>
                    </li>

                    <li><a class="dropdown-item" href="#">Today</a></li>
                    <li><a class="dropdown-item" href="#">This Month</a></li>
                    <li><a class="dropdown-item" href="#">This Year</a></li>
                  </ul>
                </div>

                <div class="card-body">
                  <h5 class="card-title">Chart</h5>

                  <canvas id="barChart" style="max-height: 400px;"></canvas>
              <script>
                document.addEventListener("DOMContentLoaded", () => {
                  new Chart(document.querySelector('#barChart'), {
                    type: 'bar',
                    data: {
                      labels: [
                        <% for(String lb : label){
                           out.print("'"+lb+"',");
                        }%>
                      ],
                      datasets: [{
                        label: 'Bar Chart',
                        data:[
                        <% for(int dt : data){
                              out.print(dt+",");
                        }%>
                        ],
                        backgroundColor: [
                          'rgba(255, 99, 132, 0.2)',
                          'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                          'rgb(255, 99, 132)',
                          'rgb(255, 159, 64)'
                        ],
                        borderWidth: 1
                      }]
                    },
                    options: {
                      scales: {
                        y: {
                          beginAtZero: true
                        }
                      }
                    }
                  });
                });
              </script>
              <!-- End Bar CHart -->
    </section>


  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
  <%@include file="footer.jsp" %>
