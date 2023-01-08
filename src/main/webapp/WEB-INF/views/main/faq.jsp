<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

        <style>
            .bottom-section {
                margin-top: 50px;
                margin-bottom: 30px;
                display: flex;
            }

            .bottom-section nav {
                flex: 9;
                display: flex;
                justify-content: center;
            }

            .bottom-section .btn-write {
                flex: 1;
            }
        </style>

        <h2 align="center">자주 묻는 질문 FAQ</h2>
        <hr>
        <div class="input-group mb-4">
            <form action="list" method="get">

                <select class="form-select" name="faqtype" id="search-type">
                    <option value="faqtitle">제목</option>
                    <option value="faqcontent">내용</option>
                </select><br>
                <div class="input-group" style="margin-left: auto;">
                    <input type="text" style="margin-right: 10px;" class="form-control" id="faqkeyword"
                        name="faqkeyword" placeholder="입력해주세요" />
                    <a class="btn btn-primary" href="#" onclick="changeContentCusSearch('main', 'faq')">검색</a>
                </div>

            </form>
        </div>
        <table class="boardDTO table">
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
                        <td><a href="#"
                             onClick="changeContentCus('main', 'faqdetaile?faqNo=${list.faqNo}&userflag=${faq.userflag}&userUserId=${list.userUserId}')">${list.faqTitle}</a>
                        </td>
                        <td>${list.faqViewcount}</td>
                        <td>${list.strRegdate}</td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>

        <!-- 글 추가 -->

        <!-- 게시글 목록 하단 영역 -->
        <div class="bottom-section">

            <!-- 글쓰기 버튼 영역 -->
            <c:if test="${faq.userflag eq '관리자'}">

                <div class="create writing" align="left">
                    <a class="btn btn-success" href="#"
                        onClick="changeContent('writer?userflag=${faq.userflag}&userUserId=${faq.userUserId}');">글쓰기</a>
                </div>
            </c:if>
            <!-- 페이지 버튼 영역 -->
            <nav aria-label="Page navigation example">
                <ul class="pagination pagination-lg pagination-custom">

                    <c:if test="${fpage.prev}">
                        <li class="page-item">
                            <a class="page-link" href="#" onclick="changeContent('faq?pageNum=${fpage.beginPage - 1}&amount=${fpage.page.amount}&faqtype=${s.faqtype}&faqkeyword=${s.faqkeyword}')">prev</a>
                        </li>
                    </c:if>

                    <c:forEach var="n" begin="${fpage.beginPage}" end="${fpage.endPage}" step="1">
                        <li data-page-num="${n}" class="btn page-item">
                            <a href="#" onclick="changeContent('faq?pageNum=${n}&amount=${fpage.page.amount}&faqtype=${s.faqtype}&faqkeyword=${s.faqkeyword}')">${n}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${fpage.next}">
                        <li class="page-item">
                        <a class="page-link" href="#" onclick="changeContent('faq?pageNum=${fpage.endPage + 1}&amount=${fpage.page.amount}&faqtype=${s.faqtype}&faqkeyword=${s.faqkeyword}')">next</a>
                        </li>
                    </c:if>

                </ul>
            </nav>
        </div>

        <div id="search box" align="right">
            <a href="javascript:openfrm('/faq/Precautions');">주의사항</a>
        </div>
        <div class="input-group mb-4" align="center">
            <a href="#" onclick="changeContentCus('main', 'path')">화면이동</a>
        </div>

        <!-- 하단 -->


        <!-- 주의사항 -->


        <script>
            // const total = 2;

            // (function (total) {
            //     console.log('전달받은값:', total);

            // })

            function openfrm(path) {
                faqpop_auth = window.open(path, '주의사항 화면 띄우기', 'top=100, left=200, width=500, height=500')
                faqpop_auth.focus();
            }

        </script>