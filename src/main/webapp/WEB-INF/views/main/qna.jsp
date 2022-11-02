<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<h1>QNA</h1>

<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항</h1>
    </div>
    <div class="card-body">
        <div class="table-responsive">
            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                <div class="row col-sm-12">
                    <div class="col-md-12" style="height: 50px">
                        <div class="dropdown float-left" style="margin-right: 15px">
                            <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                태그 선택
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">제목</a></li>
                                <li><a class="dropdown-item" href="#">작성자</a></li>
                                <li><a class="dropdown-item" href="#">부서</a></li>
                            </ul>
                        </div>
                        <div id="dataTable_filter" class="dataTables_filter float-left">
                            <label>
                                <input type="search" class="form-control form-control-sm" placeholder="검색어 입력"
                                       aria-controls="dataTable" style="font-size: 1.2em;">
                            </label>
                        </div>
                        <div class="float-right">
                            <button type="button" class="btn btn-primary">
                                <a href="#" style="color: #ffffff; outline: none; text-decoration: none">글 작성</a></button>
                        </div>
                    </div>
                    <ol class="list-group list-group-numbered col-md-12" style="color: #000000">
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <div class="ms-2 me-auto">
                                <label>
                                    <button style="font-weight: bold; font-size: 1.3em; background: inherit; border: none"
                                            type="button" onclick="changeContentCus('notice', 'noticeview')">제목
                                        <i class="fa-solid fa-paperclip"></i></button>
                                </label>
                                <div>
                                    <span class="badge bg-primary rounded-pill"
                                          style="color: #ffffff; margin-right: 20px; font-size: 0.9em">전체 공지</span>
                                    <span style="margin-right: 20px">작성자</span>
                                    <span style="margin-right: 20px">작성일</span>
                                    <span class="badge bg-primary rounded-pill" style="color: #ffffff">14</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <div class="ms-2 me-auto">
                                <label>
                                    <button style="font-weight: bold; font-size: 1.3em; background: inherit; border: none"
                                            type="button" onclick="changeContentCus('notice', 'noticeview')">제목
                                        <i class="fa-solid fa-paperclip"></i></button>
                                </label>
                                <div>
                                    <span class="badge bg-primary rounded-pill"
                                          style="color: #ffffff; margin-right: 20px; font-size: 0.9em">전체 공지</span>
                                    <span style="margin-right: 20px">작성자</span>
                                    <span style="margin-right: 20px">작성일</span>
                                    <span class="badge bg-primary rounded-pill" style="color: #ffffff">14</span>
                                </div>
                            </div>
                        </li>
                        <li class="list-group-item d-flex justify-content-between align-items-start">
                            <div class="ms-2 me-auto">
                                <label>
                                    <button style="font-weight: bold; font-size: 1.3em; background: inherit; border: none"
                                            type="button" onclick="changeContentCus('notice', 'noticeview')">제목
                                        <i class="fa-solid fa-paperclip"></i></button>
                                </label>
                                <div>
                                    <span class="badge bg-primary rounded-pill"
                                          style="color: #ffffff; margin-right: 20px; font-size: 0.9em">전체 공지</span>
                                    <span style="margin-right: 20px">작성자</span>
                                    <span style="margin-right: 20px">작성일</span>
                                    <span class="badge bg-primary rounded-pill" style="color: #ffffff">14</span>
                                </div>
                            </div>
                        </li>
                    </ol>
                </div>
            </div>
        </div>
    </div>
</div>