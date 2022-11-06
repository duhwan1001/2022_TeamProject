<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

            <div class="boardDTO write">
                <h2 align="center">FAQ 글 작성</h2>
                <form name="savefrm" action="/main/faqsave" method="post">
                <input type="hidden" id="userUserId" name="userUserId" value="${list.userUserId}">
                    <div class="mainboard-3">
                        <label for="write_title" class="form-label">글제목</label>
                        <input type="text" class="form-control" id="faqTitle" placeholder="제목" name="faqTitle" placeholder="제목을 입력해 주세요." required>
                    </div>
                    <div class="mainboard-3">
                        <label for="write_text" class="form-label">내용</label>
                        <input type="text" class="form-control" name="faqContent" id="faqContent" row="10" placeholder="내용을 입력해 주세요." required>
                    </div>
            </div>

                <div>
                                                <c:if test="${user eq '관리자'}">
                    <button type="button" class="btn btn-primary" onclick="changeContentCuswriter('main', 'faqsave')">등록</button>
                                                    </c:if>
                    <button id="to-list" type="button" class="btn btn-primary" onclick="changeContentCus('main', 'faq')">목록</button>
                </div>
            </form>


            <script>

            </script>
