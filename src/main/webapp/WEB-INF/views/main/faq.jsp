<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

            <h2 align="center">자주 묻는 질문 FAQ</h2>
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
                                    onClick="changeContent('faqdetaile?faqno=${list.faqNo}');">${list.faqTitle}</a></td>
                            <td>${list.faqViewcount}</td>
                            <td>${list.faqRegdate}</td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>

        <!-- 게시판 페이지(번호) -->

        <!-- 글 추가 -->
        <c:if test="${getuserflag eq '관리자'}">
            <div class="create writing">
                <a class="btn btn-success" href="#" onClick="changeContent('writer');">글쓰기</a>
            </div>
        </c:if>


        <!-- 하단 -->


        <!-- 검색창 -->
        <div id="search box">

        </div>