<%-- 
    Document   : insertionOuvrier
    Created on : Jan 16, 2024, 2:44:32 PM
    Author     : Amboara
--%>

<%@include file="header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Insertion des profils</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">

              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionOuvrier">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Nom</label>
                  <input type="text" class="form-control" id="inputNanme4" name="nom">
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

