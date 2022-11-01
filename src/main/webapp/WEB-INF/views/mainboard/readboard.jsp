<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 게시물 읽기 -->
<div>
    <h2>번 게시물</h2>

    <div class="mainboard-3">
        <label for="write_user" class="form-label">작성자</label>
        <input type="text" id="write_user" placeholder="이름" name="writer" value="${b.writer}" disabled>
    </div>

    <div class="mainboard-3">
        <label for="write_title" class="form-label">글제목</label>
        <input type="text" id="write_title" placeholder="제목" name="title" value="${b.title}" disabled>
    </div>

    <div class="mainboard-3">
        <label for="write_text" class="form-label">내용</label>
        <input type="text" id="write_text" placeholder="내용"  name="write text" disabled>
    </div>



<!-- 자유 게시판으로 돌아가기 -->
    <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mainboard')">목록</button>
    <button type="button" class="btn btn-info" onclick="changeContentCus('mainboard', 'commentsboard')">댓글달기</button>
    <button type="button" class="btn btn-danger" onclick="changeContentCus('mainboard', 'deleteboard')">삭제</button>
    <button type="button" class="btn btn-warning" onclick="changeContentCus('mainboard', 'reviseboard')">수정</button>
</div>