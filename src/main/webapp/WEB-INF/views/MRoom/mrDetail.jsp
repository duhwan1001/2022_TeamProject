<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <div class="card-title">
        <button onclick="history.back()" style="float: left; font-size: 24px; border: none; background: inherit">
            <i class="fa-solid fa-arrow-left"></i></button>
        <!-- Page Heading 회의실관리 목록 제목 설정-->
        <div class="d-sm-flex align-items-center justify-content-between mb-4" style="margin-left: 15px;">
            <div class="border-bottom-1">
                <h1 class="h3 mb-2 text-gray-700">회의실 관리 상세</h1>
            </div>
        </div>
    </div>
    <!-- 구분 선 속성-->
    <hr class="sidebar-divider d-none d-md-block">
    <!-- 이미지 속성 -->
    <div style="text-align: center; margin-bottom: 0.7em">
        <img src="${pageContext.request.contextPath}/img/mrimg/mr1.jpg" alt="A 회의실"/>
    </div>
    <div style="text-align: center; margin-bottom: 0.7em">
        <img src="${pageContext.request.contextPath}/img/mrimg/mr2.jpg" alt="B 회의실"/>
    </div>
    <div style="text-align: center; margin-bottom: 0.7em">
        <img src="${pageContext.request.contextPath}/img/mrimg/mr3.png" alt="C 회의실"/>
    </div>
    <div>
        <!-- summernote 수정 예정 -->
    </div>
    <div>
        <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">목록</button>
        <button type="button" class="btn btn-danger" style="float: right; margin-left: 10px">삭제</button>
        <button type="button" class="btn btn-warning" style="float: right; color: #ffffff">수정</button>
    </div>
</div>
