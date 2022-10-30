<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>login</title>

        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

        <!-- Custom styles for this template-->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">
        <jsp:include page="../../tiles/layouts/include.jsp" />
    </head>

    <body class="bg-gradient-primary">

        <div class="container">

            <!--Outet row-->
            <div class="row justify-content-center">
                <!--login page-->
                <div class="col-xl-6 col-lg-12 col-md-9">

                    <div class="card o-hidden border-0 shadow-lg my-5">
                        <div class="card-body p-0">
                            <!-- Nested Row within Card Body -->
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="p-5">
                                        <div class="text-center">
                                            <h1 class="h4 text-gray-900 mb-4">로그인</h1>
                                        </div>
                                        <form class="user">
                                            <div class="form-group">
                                                <input type="email" class="form-control form-control-user"
                                                    name="user_id" id="user_id" aria-describedby="emailHelp"
                                                    placeholder="아이디 입력:">
                                            </div>
                                            <div class="form-group">
                                                <input type="password" name="user_pw"
                                                    class="form-control form-control-user" id="user_pw"
                                                    placeholder="비밀번호 입력">
                                            </div>

                                            <a href="index.html" class="btn btn-primary btn-user btn-block">
                                                로그인
                                            </a>
                                            <hr>
                                            <a href="idfind" class="btn btn-google btn-user btn-block">
                                                 아이디 찾기
                                            </a>
                                            <a href="passwordfind" class="btn btn-facebook btn-user btn-block">
                                                 비밀번호 찾기
                                            </a>
                                            <a href="membership" class="btn btn-facebook btn-user btn-block">
                                                 아이디 생성
                                            </a>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!--/login page-->
                


            </div>


        </div>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>