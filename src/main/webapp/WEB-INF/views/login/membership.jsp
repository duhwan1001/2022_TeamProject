<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>membership</title>

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
                <!--membership page-->
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-800 mb-4">회원가입!</h1>
                                    </div>
                                    <form class="user">
                                        <div class="form-group row">

                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="email" class="form-control form-control-user"
                                                    name="user_id" id="user_id" placeholder="아이디 입력:">
                                            </div>

                                            <div class="col-sm-6">
                                                <input type="password" class="form-control form-control-user"
                                                    name="user_pw" id="user_pw" placeholder="비밀번호 입력:">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="password" class="form-control form-control-user"
                                                    name="user_pwconcheck" id="user_pwconcheck" placeholder="비밀번호 확인:">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="text" class="form-control form-control-user" id="user_name"
                                                    name="user_name" placeholder="이름 입력:">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user"
                                                    name="user_dep" id="user_dep" placeholder="부서:">
                                            </div>
                                            <div class="col-sm-6">
                                                <input type="password" class="form-control form-control-user"
                                                    name="user_rank" id="user_rank" placeholder="직급:">
                                            </div>
                                        </div>

                                        <div class="form-group row">

                                            <div class="col-sm-6 mb-3 mb-sm-0">
                                                <input type="text" class="form-control form-control-user" name="user_hp"
                                                    id="user_hp" placeholder="전화번호:">
                                            </div>

                                            <div class="col-sm-6">
                                                <div class="input-group">
                                                    <input type="text"
                                                        class="form-control form-control-user bg-light border-1 small"
                                                        name="user_addr" id="user_addr" placeholder="주소 입력:"
                                                        aria-label="Search" aria-describedby="basic-addon2">
                                                    <div class="input-group-append">
                                                        <button class="btn btn-primary" type="button">
                                                            <i class="fas fa-search fa-sm"></i>
                                                        </button>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                        <div class="form-group">
                                            <div class="input-group">
                                                <input type="text" class="form-control form-control-user"
                                                    name="user_addr2" id="user_addr2" placeholder="상세주소 입력:"
                                                    aria-label="Search" aria-describedby="basic-addon2">
                                            </div>
                                        </div>
                                        <button type="button" onclick="check()" class="btn btn-primary btn-user btn-block">회원가입</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--/membership-->
            </div>


        </div>

        <!-- <script>
        //회원가입검증
        const getIdCheck = RegExp(/^[a-zA-Z0-9]{4,14}$/);
                    const getPwCheck = RegExp(
                        /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/);
                    const getName = RegExp(/^[가-힣]+$/);
                    const getMail = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
        function check(){

        }
        </script> -->

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

    </body>