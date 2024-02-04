 <%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Fourchette de Benefices</h1>
    </div><!-- End Page Title -->

    <div class="card">
            <div class="card-body">

              <!-- Vertical Form -->
              <form class="row g-3" method="post" action="ListBenefice">
                <div class="col-12">
                  <label for="inputNanme4" class="form-label">Minimum</label>
                  <input type="number" class="form-control" id="inputNanme4" name="min">
                </div>
                <div class="col-12">
                  <label for="inputNanme5" class="form-label">Maximum</label>
                  <input type="number" class="form-control" id="inputNanme5" name="max">
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

