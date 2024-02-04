<%-- 
    Document   : formuleouvrier
    Created on : 23 janv. 2024, 09:14:04
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>

<main id="main" class="main">

          <div class="pagetitle">
                    <h1>Formule du nombre d'ouvrier</h1>
          </div><!-- End Page Title -->

          <div class="card">
                    <div class="card-body">
                              <!-- Vertical Form -->
                              <form class="row g-3" method="post" action="InsertionFormuleOuvrier">
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">nombre d'ouvrier minimal</label>
                                                  <input type="number" class="form-control" id="inputNanme4" name="nbouvrier" min="0">
                                        </div>
                                        <br/>
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">ecart</label>
                                                  <input type="number" class="form-control" id="inputNanme4" name="ecart" min="0">
                                        </div>
                                        <br/>
                                        <div class="col-12">
                                                  <label for="inputNanme4" class="form-label">Date</label>
                                                  <input type="datetime-local" class="form-control" id="inputNanme4" name="dateinsertion" min="0">
                                        </div>
                                        <br/>
                                        <div class="text-center">
                                                  <button type="submit" class="btn btn-primary">Valider</button>
                                        </div>
                              </form><!-- Vertical Form -->

                    </div>
          </div>
</main><!-- End #main -->

<!-- ======= Footer ======= -->
<%@include file="footer.jsp" %>
