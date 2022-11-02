<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 글 수정 -->
<div id="revise boardDTO">
    <form id="form data" method="post">
        <table class ="revise table boardDTO">

            <div class="mainboard-3">
                <label for="write_user" class="form-label">작성자</label>
                <input type="text" class="form-control" id="writer_user" placeholder="이름" name="writer" maxlength="20">
            </div>
            <div class="mainboard-3">
                <label for="write_title" class="form-label">글제목</label>
                <input type="text" class="form-control" id="write_title" placeholder="제목" name="title" placeholder="제목을 입력해 주세요." required>
            </div>
            <div class="mainboard-3">
                <label for="write_text" class="form-label">내용</label>
            <input style="table-layout: fixed;  height: 300px; white-space: pre-line; word-break: break-all" id="write_text" type="text" placeholder="전에 적었던 내용이 보이게" >
        </table>
        <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mainboard')">목록</button>
        <button type="button" class="btn btn-warning" onclick="changeContentCus('mainboard', 'readboard')">수정완료</button>
    </form>
</div>

</nav>
