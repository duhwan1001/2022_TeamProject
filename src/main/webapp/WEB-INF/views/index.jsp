<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="kr">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>KDC</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- fontAweosome CDN -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" />

    <style>
        .col {
            height: 100vh;
        }

        .f-s {
             text-align: center;
             font-size: 16px;
         }
    </style>

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar 왼쪽 테두리 부분에 작성할 전체 박스-->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand 왼쪽 테두리 맨 위 상단의 ERP PROJECT 부분-->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
                <!-- 이모티콘 -->
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <!-- 이모티콘 옆 ERP PROJECT 제목 -->
                <div class="sidebar-brand-text mx-3">ERP Project</div>
            </a>

            <!-- Divider 제일 윗상단과 프로필 사이에 구분 선 속성-->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard  프로필 설정하는 전체 박스-->
            <li class="nav-item active">
                <!-- 프로필 사용자 설정하는 박스 -->
                <a class="nav-link" href="#">
                    <!-- 프로필 사진 옆에 있는 이모티콘 설정 -->
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <!-- 프로필 이미지 설정 -->
                    <img class="img-profile rounded-circle" src="img/undraw_profile.svg">
                    <span>김동철</span></a>
            </li>

            <!-- Divider MYAREA와 프로필 사이에 구분 선 속성-->
            <hr class="sidebar-divider">

            <!-- Heading 내정보수정, 내가쓴글, To-Do 리스트가 들어간 박스 제목-->
            <div class="sidebar-heading">MyArea</div>

            <!-- 내 정보 수정를 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 내 정보 수정 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
                    <!-- 내 정보 수정 왼쪽 톱니바퀴 이모티콘 -->
                    <i class="fas fa-fw fa-cog"></i>
                    <span>내 정보 수정</span>
                </a>
            </li>
            <!-- 내가 쓴 글를 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 내가 쓴 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- 내가 쓴 글 왼쪽 연필 이모티콘 -->
                    <i class="fa-solid fa-pen"></i>
                    <span>내가 쓴 글</span>
                </a>
            </li>
            <!-- To-Do를 담는 전체 박스 -->
            <li class="nav-item">
                <!-- To-Do 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- To-Do 글 왼쪽 햄버거 이모티콘 -->
                    <i class="fa-solid fa-list"></i>
                    <span>To-Do</span>
                </a>
            </li>


            <!-- Divider MYAREA와 COMMON 사이의 구분 선 속성-->
            <hr class="sidebar-divider">

            <!-- Heading 공지사항,자유게시판,회의실예약,자료공유,사내일정,Q&A,FAQ를 담는 리스트 박스 제목-->
            <div class="sidebar-heading">
                Common
            </div>
            <!-- 공지사항을 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 공지사항 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- 공지사항 글 왼쪽 종모양 이모티콘 -->
                    <i class="fa-solid fa-bell"></i>
                    <span>공지사항</span>
                </a>
            </li>
            <!-- 자유 게시판을 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 자유게시판 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- 자유게시판 글 왼쪽 노트 이모티콘 -->
                    <i class="fa-solid fa-clipboard"></i>
                    <span>자유 게시판</span>
                </a>
            </li>
            <!-- 회의실 예약을 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 회의실예약 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- 회의실예약 글 왼쪽 악수 이모티콘 -->
                    <i class="fa-solid fa-handshake"></i>
                    <span>회의실 예약</span>
                </a>
            </li>
            <!-- 자료 공유를 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 자료공유 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- 자료공유 글 왼쪽 화살표 이모티콘 -->
                    <i class="fa-solid fa-share"></i>
                    <span>자료 공유</span>
                </a>
            </li>
            <!-- 사내 일정을 담는 전체 박스 -->
            <li class="nav-item">
                <!-- 사내일정 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- 사내일정 글 왼쪽 달력 이모티콘 -->
                    <i class="fa-solid fa-calendar-days"></i>
                    <span>사내 일정</span>
                </a>
            </li>
            <!-- Q&A을 담는 전체 박스 -->
            <li class="nav-item">
                <!-- Q&A 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- Q&A 글 왼쪽 물음표 이모티콘 -->
                    <i class="fa-solid fa-question"></i>
                    <span>Q&A</span>
                </a>
            </li>
            <!-- FAQ를 담는 전체 박스 -->
            <li class="nav-item">
                <!-- FAQ 글 박스 -->
                <a class="nav-link collapsed" href="#" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                    <!-- FAQ 글 왼쪽 햄버거 이모티콘 -->
                    <i class="fa-solid fa-list"></i>
                    <span>FAQ</span>
                </a>
            </li>

            <!-- Divider 맨 밑에 구분 선 속성-->
            <hr class="sidebar-divider d-none d-md-block">
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper 오른쪽에 들어가는 모든 내용의 전체 박스-->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content 오른쪽 전체 박스-->
            <div id="content">

                <!-- Topbar 맨 위 상단부에 있는 채팅, 이메일 이모티콘 부분-->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) 토글 버튼 부분-->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Navbar 맨 위 상단의 채팅, 메일 이모티콘 박스-->
                    <ul class="navbar-nav ml-auto">

                        <!-- 채팅 아이콘 -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <!-- 채팅 아이콘 클릭하는 토글 버튼 속성-->
                            <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-comments fa-2x"></i>
                                <!-- Counter - Alerts 채팅이 몇개왔는지 표현-->
                                <span class="badge badge-danger badge-counter">3+</span>
                            </a>
                        </li>

                        <!-- 메일 아이콘 -->
                        <li class="nav-item dropdown no-arrow mx-1">
                            <!-- 메일 아이콘 클릭하는 토글 버튼 속성 -->
                            <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-envelope fa-2x"></i>
                                <!-- Counter - Messages 메일이 몇개왔는지 표현-->
                                <span class="badge badge-danger badge-counter">7</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content 오른쪽 가운데 안에 들어가는 내용들의 전체 박스-->
                <div class="container-fluid">
                    <div class="input-group mb-5">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="내용을 입력하세요."
                               aria-label="Search" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                    <!-- 구분 선 속성-->
                    <hr class="sidebar-divider d-none d-md-block">
                    <!-- Page Heading 회의실관리 목록 제목 설정-->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <div class="border-bottom-1">
                            <h1 class="h3 mb-2 text-gray-700">회의실 관리 목록</h1>
                        </div>
                    </div>

                    <!-- Content Row 회의실관리 목록 내용 담고있는 전체 박스-->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-12">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="f-s text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                <table class="table">
                                                    <thead>
                                                    <tr>
                                                        <th scope="col">순번</th>
                                                        <th scope="col">회의실명</th>
                                                        <th scope="col">입장가능인원</th>
                                                        <th scope="col">예약자명</th>
                                                        <th scope="col">사용여부</th>
                                                    </tr>
                                                    </thead>
                                                    <tbody class="table-group-divider">
                                                    <tr>
                                                        <th scope="row">1</th>
                                                        <td>A 회의실</td>
                                                        <td>5명</td>
                                                        <td>김동철</td>
                                                        <td>Yes</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">2</th>
                                                        <td>B 회의실</td>
                                                        <td>20명</td>
                                                        <td>김두환</td>
                                                        <td>Yes</td>
                                                    </tr>
                                                    <tr>
                                                        <th scope="row">3</th>
                                                        <td>C 회의실</td>
                                                        <td>10명</td>
                                                        <td>김두환</td>
                                                        <td>No</td>
                                                    </tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->

            <!-- Footer 맨 밑 부분에 들어가는 전체 박스-->
            <footer class="sticky-footer bg-white">
                <!-- footer의 들어가는 글 전체 박스 -->
                <div class="container my-auto">
                    <!-- footer의 들어가는 글 전체 박스 안에 있는 글 박스 -->
                    <div class="copyright text-center my-auto">
                        <span>JAVA Web Project - 김두환, 김영우, 김동철, 홍승보, 변의준</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/chart-area-demo.js"></script>
    <script src="js/demo/chart-pie-demo.js"></script>

</body>

</html>