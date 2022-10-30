<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <!-- header js, css, CDN -->
  <%--  <tiles:insertAttribute name="include"/>--%>
  <jsp:include page="../../tiles/layouts/include.jsp"/>
</head>
<body id="page-top">
<div id="wrapper">
  <!-- side -->
  <!-- Sidebar -->
  <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="#" onClick="changeContent('dashboard');">
      <div class="sidebar-brand-icon rotate-n-15">
        <i class="fas fa-laugh-wink"></i>
      </div>
      <div class="sidebar-brand-text mx-3">ERP Project</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
      <a class="nav-link" href="#">
        <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
        <span>김두환</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">MyArea</div>

    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('editinfo');" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
        <i class="fas fa-fw fa-cog"></i>
        <span>내 정보 수정</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('mywrite');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-pen"></i>
        <span>내가 쓴 글</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('todo');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-list"></i>
        <span>To-Do</span>
      </a>
    </li>


    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
      Common
    </div>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('notice');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-bell"></i>
        <span>공지사항</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('mainboard');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-clipboard"></i>
        <span>자유 게시판</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('mrmain');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-handshake"></i>
        <span>회의실 예약</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('sharedata');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-share"></i>
        <span>자료 공유</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('cocalender');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-calendar-days"></i>
        <span>사내 일정</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('qna');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-question"></i>
        <span>Q&A</span>
      </a>
    </li>
    <li class="nav-item">
      <a class="nav-link collapsed" href="#" onClick="changeContent('faq');" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
        <i class="fa-solid fa-list"></i>
        <span>FAQ</span>
      </a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- 관리자 영역 -->

    <!-- 관리자 영역 끝 -->
  </ul>
  <!-- End of Sidebar -->
  <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
      <!-- Topbar -->
      <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
          <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

          <!-- 채팅 아이콘 -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-comments fa-2x"></i>
              <!-- Counter - Alerts -->
              <span class="badge badge-danger badge-counter">3+</span>
            </a>
          </li>

          <!-- 메일 아이콘 -->
          <li class="nav-item dropdown no-arrow mx-1">
            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              <i class="fas fa-envelope fa-2x"></i>
              <!-- Counter - Messages -->
              <span class="badge badge-danger badge-counter">7</span>
            </a>
          </li>
        </ul>

      </nav>
      <!-- End of Topbar -->
      <div id="mainContent" class="container-fluid">
        <%--        <tiles:insertAttribute name="body"/>--%>
      </div>
    </div>
    <!-- footer -->
    <footer class="sticky-footer bg-white">
      <div class="container my-auto">
        <div class="copyright text-center my-auto">
          <span>Copyright &copy; Your Website 2021</span>
        </div>
      </div>
    </footer>
  </div>
  <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<jsp:include page="../../tiles/layouts/includeUnderJS.jsp"/>
</body>
</html>