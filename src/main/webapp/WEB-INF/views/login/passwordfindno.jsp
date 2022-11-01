<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>idfind</title>

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
            <!--idfind-->

            <div class="col-xl-6 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h2 class="h4 text-gray-900 mb-4">회원님의 비밀번호를 찾을 수 없습니다.</h2>
                                    </div>
                                    <a href="passwordfind" class="btn btn-primary btn-user btn-block">
                                        비밀번호찾기
                                    </a>
                                        <a href="/" class="btn btn-primary btn-user btn-block">
                                            로그인
                                        </a>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <!--idfind-->

        </div>


    </div>

</body>