<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 삭제 페이지 -->

<div>
    글번호 : ${board_num}
</div>
    을 정말로 삭제하시겠습니까?

<div>
    <!-- <form action="" method="post"> -->
    <!--  <a><button type="button" class="btn btn-danger"></button></a> -->
    <!-- </form> -->
        <button type="button" class="btn btn-danger" onclick="changeContentCus('mainboard', 'mainboard')">삭제</button>
        <button type="button" class="btn btn-info" onclick="changeContentCus('mainboard', 'readboard')">취소</button>
</div>