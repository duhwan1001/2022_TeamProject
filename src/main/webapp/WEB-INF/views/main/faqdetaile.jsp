<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>FAQ 게시판</title>

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

    <div class="col-lg-12 col-md-6">

    <h1>글 상세 목록</h1>
    <a href="logout.do">Log Out</a>
    <hr>
    <form action="/main/faqmodify" method="post">
        <input type="hidden" name="faqNo" value="${list.faqNo }">
        <table border="1">
            <tr>
                <td>제목</td>
                <td><input type="text" name="faqTitle" value="${list.faqTitle }"></td>
            </tr>
            <tr>
                <td>내용</td>
                <td><textarea name="faqContent">${list.faqContent }</textarea></td>
            </tr>
            <tr>
                <td>등록일</td>
                <td>${list.faqRegdate }</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${list.faqViewcount }</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="글수정" /></td>
            </tr>
        </table>
    </form>
    <hr>
    <a href="/main/faq">글등록</a>&nbsp;&nbsp;&nbsp;
    <a href="/main/delete?faqno=${list.faqNo }">글삭제</a>&nbsp;&nbsp;&nbsp;
    <a href="/main/faq">글목록</a>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    </div>

</body>

</html>