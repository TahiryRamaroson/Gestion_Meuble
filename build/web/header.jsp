<%-- 
    Document   : header
    Created on : 18 déc. 2023, 08:42:49
    Author     : tahir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Dashboard - NiceAdmin Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets_bootstrap/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets_bootstrap/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets_bootstrap/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets_bootstrap/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="assets_bootstrap/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="assets_bootstrap/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets_bootstrap/vendor/simple-datatables/style.css" rel="stylesheet">

  <!-- Template Main CSS File -->
  <link href="assets_bootstrap/css/style.css" rel="stylesheet">
  
  <link href="assets/css/main.css" rel="stylesheet">

</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="header fixed-top d-flex align-items-center">

    <div class="d-flex align-items-center justify-content-between">
      <a href="index.html" class="logo d-flex align-items-center">
        <img src="assets/img/logo.svg" alt="">
        <span class="d-none d-lg-block">Fanaka</span>
      </a>
        <i class="bi bi-list toggle-sidebar-btn"></i>
    </div><!-- End Logo -->

  </header><!-- End Header -->

  <!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">
        
        <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>Insertions</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="components-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="index.jsp">
              <i class="bi bi-circle"></i><span>Matière</span>
            </a>
          </li>
          
          <li>
            <a href="insertionStyle.jsp">
              <i class="bi bi-circle"></i><span>Style</span>
            </a>
          </li>
          
          <li>
            <a href="insertionVolume.jsp">
              <i class="bi bi-circle"></i><span>Volume</span>
            </a>
          </li>
          
          <li>
            <a href="insertionMeuble.jsp">
              <i class="bi bi-circle"></i><span>Meuble</span>
            </a>
          </li>
          
          <li>
            <a href="insertionOuvrier.jsp">
              <i class="bi bi-circle"></i><span>Profil</span>
            </a>
          </li>
          
          <li>
            <a href="insertionPoste.jsp">
              <i class="bi bi-circle"></i><span>Poste</span>
            </a>
          </li>
          
          <li>
            <a href="EmployeServlet">
              <i class="bi bi-circle"></i><span>Employe</span>
            </a>
          </li>
          
          <li>
            <a href="insertionGenre.jsp">
              <i class="bi bi-circle"></i><span>Genre</span>
            </a>
          </li>
          
          <li>
            <a href="FormulaireClient">
              <i class="bi bi-circle"></i><span>Client</span>
            </a>
          </li>
          
          <li>
            <a href="PrixVenteServlet">
              <i class="bi bi-circle"></i><span>Prix de Vente</span>
            </a>
          </li>
          
          <li>
            <a href="formuleouvrier.jsp">
              <i class="bi bi-circle"></i><span>Formule des nombres d'ouvriers</span>
            </a>
          </li>
          
          <li>
            <a href="AssocServlet">
              <i class="bi bi-circle"></i><span>Association Matière et style</span>
            </a>
          </li>
          
          <li>
            <a href="AssocPrixMatiere">
              <i class="bi bi-circle"></i><span>Association Matière et prix</span>
            </a>
          </li>
          
          <li>
            <a href="AssocOuvrierSal">
              <i class="bi bi-circle"></i><span>Association Ouvrier et coeffsalaire</span>
            </a>
          </li>
          
          <li>
            <a href="AssocPosteSal">
              <i class="bi bi-circle"></i><span>Association Poste et salaire</span>
            </a>
          </li>
          
          <li>
            <a href="AssocOuvrierExp">
              <i class="bi bi-circle"></i><span>Association Profil et experience</span>
            </a>
          </li>
          
        </ul>
      </li><!-- End Components Nav -->
      
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#components-nav1" data-bs-toggle="collapse" href="#">
          <i class="bi bi-menu-button-wide"></i><span>Recherche</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="components-nav1" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="ChoixMatiere">
              <i class="bi bi-circle"></i><span>Choix matière</span>
            </a>
          </li>
          
          <li>
            <a href="ChoixServlet">
              <i class="bi bi-circle"></i><span>Choix style</span>
            </a>
          </li>
          
          <li>
            <a href="choixPrix.jsp">
              <i class="bi bi-circle"></i><span>Choix prix</span>
            </a>
          </li>
          
          <li>
            <a href="ChoixStat">
              <i class="bi bi-circle"></i><span>Statistique</span>
            </a>
          </li>
          
          <li>
            <a href="choixBenef.jsp">
              <i class="bi bi-circle"></i><span>Benefices</span>
            </a>
          </li>
          
        </ul>
      </li><!-- End Components Nav -->

      <li class="nav-item">
        <a class="nav-link " href="ListStyleServlet">
          <i class="bi bi-grid"></i>
          <span>Fabrication</span>
        </a>
      </li><!-- End Dashboard Nav -->

      <li class="nav-item">
        <a class="nav-link " href="LsMatieresAchat">
          <i class="bi bi-grid"></i>
          <span>Achat Matière</span>
        </a>
      </li><!-- End Dashboard Nav -->
      
      <li class="nav-item">
        <a class="nav-link " href="LsMeubleCommande">
          <i class="bi bi-grid"></i>
          <span>Commande Meuble</span>
        </a>
      </li><!-- End Dashboard Nav -->
      
      <li class="nav-item">
        <a class="nav-link " href="VoirStock">
          <i class="bi bi-grid"></i>
          <span>Voir Stock Matieres</span>
        </a>
      </li><!-- End Dashboard Nav -->
      
      <li class="nav-item">
        <a class="nav-link " href="FormulaireTravailOuvrier">
          <i class="bi bi-grid"></i>
          <span>Travail ouvrier</span>
        </a>
      </li><!-- End Dashboard Nav -->
      
      <li class="nav-item">
        <a class="nav-link " href="VoirEmploye">
          <i class="bi bi-grid"></i>
          <span>Voir les employés</span>
        </a>
      </li><!-- End Dashboard Nav -->

    </ul>

  </aside><!-- End Sidebar-->
