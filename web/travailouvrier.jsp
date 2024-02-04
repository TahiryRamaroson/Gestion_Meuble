<%-- 
    Document   : travailouvrier
    Created on : 23 janv. 2024, 11:12:14
    Author     : tahir
--%>

<%@page import="entities.Volume"%>
<%@page import="java.util.ArrayList"%>
<%@include file="header.jsp" %>

  <main id="main" class="main">
      
    <div class="pagetitle">
      <h1>Choisissez le volume</h1>
    </div><!-- End Page Title -->
    
    <% 
        session = request.getSession();
        ArrayList<Volume> ls = (ArrayList) session.getAttribute("lsAllVolumes");
        for (Volume volume : ls) {
    %>
    
    <a href="FormulaireTravailOuvrier?idvolume=<% out.print(volume.getId()); %>">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title"><% out.print(volume.getNomvolume());%></h5>
            </div>
      </div>
    </a>
    
    <%        
            }
    %>

    
  </main><!-- End #main -->

 <%@include file="footer.jsp" %>
