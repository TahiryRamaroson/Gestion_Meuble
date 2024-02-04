<%-- 
    Document   : insertionStyle
    Created on : 12 déc. 2023, 16:05:21
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Insertion des volumes</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">

              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionVolServlet">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Nom</label>
                  <input type="text" class="form-control" id="inputNanme4" name="nomVolume">
                </div>
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Coeff</label>
                  <input type="number" class="form-control" id="inputNanme4" name="coeff">
                </div>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form><!-- Vertical Form -->

            </div>
          </div>
  </main><!-- End #main -->

  <!-- ======= Footer ======= -->
<%@include file="footer.jsp" %>
