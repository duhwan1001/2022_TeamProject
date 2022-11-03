<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

        <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>ERP FAQ detalie</title>

            <!-- Custom fonts for this template-->
            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet">

            <!-- Custom styles for this template-->
            <link href="css/sb-admin-2.min.css" rel="stylesheet">
            <jsp:include page="../../tiles/layouts/include.jsp" />
        </head>

        <body>

            <div class="col-lg-12">
                <h1>내 글 등록</h1>
                <hr>
                <form name="savefrm" action="faqsave" method="post">
                    <table border="1">
                        <tr>
                            <td>제목</td>
                            <td><input type="text" id="faqTtile" name="faqTitle" /></td>
                        </tr>
                        <tr>
                            <td>내용</td>
                            <td><textarea id="faqContent" name="faqContent"></textarea></td>
                        </tr>
                        <tr>
                            <td colspan="2"><button type="button" id="btn" onclick="writercheck();" class="btn btn-primary btn-user">글등록</button></td>
                        </tr>
                    </table>
                </form>
                <hr>
                <a href="/main/faq" class="btn btn-primary btn-user">
                    글 목록
                </a>
            </div>


            <script>

                const $faqTtile = $('#faqTtile');
                const $faqContent = $('#faqContent');
                function writercheck(){
                    
                    if($faqTtile.val() ===''|| $faqTtile.val() === null){
                        alert('제목은 필수사항입니다.');
                        return;
                    }

                    if($faqContent.val() ==='' || $faqContent.val() === null){
                        alert('내용은 필수 사항입니다.');
                        return;

                    }

                    document.savefrm.submit();
                    
                }
            </script>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>

        </body>
