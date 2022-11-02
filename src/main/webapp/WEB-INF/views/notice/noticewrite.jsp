<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항 등록</h1>
    </div>
    <div class="card-body col-10" style="left: 7%">
        <form class="was-validated">
            <%--태그 선택--%>
            <div class="dropdown mb-3" style="margin-right: 15px">
                <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    태그 선택
                </button>
                <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item" href="#" type="all">전체 공지</a></li>
                    <li><a class="dropdown-item" href="#" type="emp">부서 공지</a></li>
                    <%--                    <li><a class="dropdown-item" href="#">부서</a></li>--%>
                </ul>
            </div>

            <%--제목 입력--%>
            <div class="mb-3">
                <label for="formGroupExampleInput" class="form-label">제목 입력</label>
                <input type="text" class="form-control" id="formGroupExampleInput" placeholder="제목을 입력하세요" required>
                <div class="invalid-feedback">
                    제목은 필수사항입니다.
                </div>
            </div>
            <%--내용 입력--%>
            <div class="mb-3">
                <label for="validationTextarea" class="form-label">공지사항 입력</label>
                <textarea class="form-control" id="validationTextarea" placeholder="내용을 입력하세요" required style="height: 300px"></textarea>
                <div class="invalid-feedback">
                    내용은 필수사항입니다.
                </div>
            </div>
            <%--첨부파일--%>
            <div class="mb-3">
                <input type="file" class="form-control" aria-label="file example" multiple>
            </div>
        </form>


        <%--buttons--%>
        <div class="clearfix">
            <div class="float-left">
                <button type="button" class="btn btn-primary" onclick="goNoticeMain()">목록</button>
            </div>
            <div class="float-right">
                <button type="button" class="btn btn-primary" onclick="insertNotice()">등록</button>
                <%--                <button type="button" class="btn btn-danger" onclick="">취소</button>--%>
            </div>
        </div>
    </div>
</div>

<script>
    function goNoticeMain() {
        location.href="/main";
    }
    function insertNotice() {
        location.href="/main";
        location.reload();
    }
</script>

