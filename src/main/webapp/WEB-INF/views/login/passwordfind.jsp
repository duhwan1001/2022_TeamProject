<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <head>

            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>passwordfind</title>
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
                    <!--passwordfind-->

                    <div class="col-xl-6 col-lg-12 col-md-9">

                        <div class="card o-hidden border-0 shadow-lg my-5">
                            <div class="card-body p-0">
                                <!-- Nested Row within Card Body -->
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="p-5">
                                            <div class="text-center">
                                                <h1 class="h4 text-gray-900 mb-4">비밀번호 찾기</h1>
                                            </div>
                                            <form action="/idfind/checkfindpath" method="post">
                                            <input type="hidden" id="userPw" name="userPw" value="${getpassword}">
                                            <input type="hidden" id="pass" name="pass" value="${pass}">
                                            <div class="form-group">
                                                <input type="text" class="form-control form-control-user" name="userId"
                                                    id="userId" aria-describedby="emailHelp" placeholder="아이디 입력:">
                                            </div>
                                            <div class="form-group">
                                                <div class="input-group">
                                                    <input type="text" class="form-control form-control-user"
                                                        name="userName" id="userName" placeholder="이름 입력:"
                                                        aria-label="Search" aria-describedby="basic-addon2">
                                                </div>
                                            </div>
                                            <button type="button" onclick="pwfindbtn();" class="btn btn-primary btn-user btn-block">
                                                확인
                                            </button>
                                            <a href="/" class="btn btn-primary btn-user btn-block">
                                                로그인화면이동
                                            </a>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!--/passwordfind-->

                </div>


            </div>

            <script src="js/passwordfind.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="/js/sb-admin-2.min.js"></script>

        </body>