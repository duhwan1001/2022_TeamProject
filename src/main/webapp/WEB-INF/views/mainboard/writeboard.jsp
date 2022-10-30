<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 글 등록 -->


<!-- 글 작성 -->
<div class="board write">
    <form id="write-form" action="/wirteboard method="post" autocomplete="off">
        <div class="mainboard-3">
            <label for="write-input" class="form-label">작성자</label>
            <input type="text" class="form-control" id="writer-form" placeholder="이름" name="writer" maxlength="20">
        </div>
        <div class="mainboard-3">
            <label for="title-input" class="form-label">글제목</label>
            <input type="text" class="form-control" id="title-form" placeholder="제목" name="title" placeholder="제목을 입력해 주세요." required>
        </div>
        <div class="mainboard-3">
            <label for="text-input" class="form-label">내용</label>
            <input type="text" class="form-control" id="text-form" row="10" placeholder="내용을 입력해 주세요." required>
        </div>
</div>

<!-- 자유 게시판으로 돌아가기 -->
    <div>
        <button id="write-button" type="button" class="btn btn-light">작성하기</button>
        <button id="to-list" type="button" class="btn btn-primary" href="/boardmain">목록</button>
    </div>
</form>
