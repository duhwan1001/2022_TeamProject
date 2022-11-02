<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 자유 게시판 -->
<table class="board table">
    <thead>
        <tr>
            <th id="board_num" scope="col">게시물 번호</th>
            <th scope="col">제목</th>
            <th scope="col">작성자</th>
            <th id="read_board_count" scope="col">조회수</th>
            <th scope="col">작성일</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <th scope="row">1</th>
                <td><a href="#" onclick="changeContentCus('mainboard', 'readboard')">프로젝트</a></td>
                <td>홍길동</td>
                <td>11</td>
                <td>2022-10-26</td>
            </tr>
            <tr>
                <th scope="row">2</th>
                <td><a href="#" onclick="changeContentCus('mainboard', 'readboard')">html</a></td>
                <td>이순신</td>
                <td>9</td>
                <td>2022-10-27</td>
            </tr>
            <tr>
                <th scope="row">3</th>
                <td><a href="#" onclick="changeContentCus('mainboard', 'readboard')">jsp</a></td>
                <td >호날두</td>
                <td >3</td>
                <td>2022-10-28</td>
            </tr>
        </tbody>
</table>


<!-- 게시판 페이지(번호) -->



<!-- 글 추가 -->
<div class="create writing">
    <button type="button" class="btn btn-success" onclick="changeContentCus('mainboard', 'writeboard')">글쓰기</button>
</div>


<!-- 하단 -->


<!-- 검색창 -->
<div id="search box">

</div>
