<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="utf-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <meta name="description" content="">
            <meta name="author" content="">

            <title>FAQ</title>

            <!-- Custom fonts for this template-->
            <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
            <link
                href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
                rel="stylesheet">

            <!-- Custom styles for this template-->
            <link href="css/sb-admin-2.min.css" rel="stylesheet">

            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
                crossorigin="anonymous">
            <jsp:include page="../../tiles/layouts/include.jsp" />
        </head>

        <body>
            <!-- 자주묻는 질문 게시판 FAQ -->
            <h2>자주 묻는 질문 FAQ</h2>
            <table class="boardDTO table" border="1">
                <thead>
                    <tr>
                        <th id="board_num" scope="col">게시물 번호</th>
                        <th scope="col">제목</th>
                        <th id="read_board_count" scope="col">조회수</th>
                        <th scope="col">작성일</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="list" items="${faqList}">
                        <tr>
                            <th scope="row">${list.faqNo}</th>
                            <td><a href="/main/faqdetaile?faqno=${list.faqNo}">${list.faqTitle}</a></td>
                            <td>${list.faqViewcount}</td>
                            <td>${list.faqRegdate}</td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>


            <!-- 게시판 페이지(번호) -->

            <!-- 글 추가 -->
            <div class="create writing">
            <c:if test="${}">
                <a class="btn btn-success" href="/main/writer">글쓰기</a>
            </c:if>
            </div>


            <!-- 하단 -->


            <!-- 검색창 -->
            <div id="search box">

            </div>

            <!-- Bootstrap core JavaScript-->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

            <!-- Core plugin JavaScript-->
            <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

            <!-- Custom scripts for all pages-->
            <script src="js/sb-admin-2.min.js"></script>
        </body>

        </html>