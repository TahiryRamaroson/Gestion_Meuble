<%-- 
    Document   : error
    Created on : 19 déc. 2023, 09:06:14
    Author     : Amboara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>

  <main id="main" class="main">
      
<div class="alert alert-danger" role="alert">
  <% out.print(request.getAttribute("error")); %>
</div>
    
  </main><!-- End #main -->

 <%@include file="footer.jsp" %>
