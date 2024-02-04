<%-- 
    Document   : insertionMatiere
    Created on : 12 déc. 2023, 15:59:22
    Author     : tahir
--%>

 <%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Insertion des matières</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">

              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="InsertionMatiereServlet">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Nom</label>
                  <input type="text" class="form-control" id="inputNanme4" name="nomMatiere">
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
