<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항 수정</h1>
    </div>
    <div class="card-body">
        <form action="#" method="get">

        </form>

        <%--태그 선택--%>
        <div class="mb-3">
            <select class="form-select" required aria-label="select example">
                <option value="">태그 선택</option>
                <option value="allNotice">전체 공지</option>
                <option value="empNotice">부서 공지</option>
            </select>
            <div class="invalid-feedback">태그를 선택하세요</div>
        </div>

        <%--첨부파일--%>
<%--        <div class="mb-3">--%>
<%--            <input type="file" class="form-control" aria-label="file example" required>--%>
<%--            <div class="invalid-feedback">Example invalid form file feedback</div>--%>
<%--        </div>--%>
    <%--buttons--%>
    </div>
</div>

