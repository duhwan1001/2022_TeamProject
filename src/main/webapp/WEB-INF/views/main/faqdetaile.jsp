<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <div class="col-lg-12 col-md-6" align="center">
            <c:set var="users" value="${user}"></c:set>

            <h1>FAQ 글 상세 목록</h1>
            <form action="fiss/up" method="post">
                <input type="hidden" id="faqNo" name="faqNo" value="${list.faqNo }">
                <table>
                    <tr>
                        <td>제목</td>
                        <td><input type="text" id="faqTitle" name="faqTitle" value="${list.faqTitle }"></td>
                    </tr>
                    <tr>
                        <td>내용</td>
                        <td><textarea id="faqContent" name="faqContent">${list.faqContent }</textarea></td>
                    </tr>
                    <tr>
                        <td>등록일</td>
                        <td>${list.faqRegdate }</td>
                    </tr>
                    <tr>
                        <td>조회수</td>
                        <td>${list.faqViewcount }</td>
                    </tr>
                </table>
            </form>

            <c:if test="${users eq '관리자'}">
                        <tr>
                            <td colspan="2"><input type="button" href="#" class="btn btn-primary"
                                    onclick="changeContentCusmodify('main', 'faqmodify')" value="글수정" /></td>
                        </tr>
            </c:if>
            
            <a href="/main/faq">글등록</a>&nbsp;&nbsp;&nbsp;
            <c:if test="${users eq '관리자'}">
                <a href="#" class="btn btn-primary" onclick="changeContentCusdelete('main', 'faqdelete')">글삭제</a>
            </c:if>
            &nbsp;&nbsp;&nbsp;
            <button id="to-list" type="button" class="btn btn-primary"
                onclick="changeContentCus('main', 'faq')">목록</button>
        </div>

        <script>

            function changeContentCusdelete(path, name) {
                const $faqNo = $('#faqNo');

                console.log(name);

                $('#mainContent').children().remove();
                $('#mainContent').load("/" + path + "/" + name + "?faqno=" + $faqNo.val());

            }

            function changeContentCusmodify(path, name) {

                const $faqTtile = $('#faqTitle');
                const $faqContent = $('#faqContent');
                const $faqNo = $('#faqNo');

                $('#mainContent').children().remove();
                $('#mainContent').load("/" + path + "/" + name + "?faqTitle=" + $faqTtile.val() + "&faqContent=" + $faqContent.val() + "&faqNo=" + $faqNo.val());
            }

        </script>