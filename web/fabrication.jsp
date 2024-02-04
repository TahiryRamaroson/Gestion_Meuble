<%-- 
    Document   : Fabrication
    Created on : 19 déc. 2023, 15:17:55
    Author     : Amboara
--%>

<%@page import="entities.Style"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Choisissez le style</h1>
    </div><!-- End Page Title -->
    
    <% 
        session = request.getSession();
        ArrayList<Style> ls = (ArrayList) session.getAttribute("lsAllStyles");
        for (Style style : ls) {
    %>
    
    <a href="FormulaireFabrication?idstyle=<% out.print(style.getId()); %>">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title"><% out.print(style.getNomstyle());%></h5>
            </div>
      </div>
    </a>
    
    <%        
            }
    %>

    
  </main><!-- End #main -->

 <%@include file="footer.jsp" %>