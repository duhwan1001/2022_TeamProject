<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항</h1>
    </div>
    <div class="card-body">
        <div class="table-responsive" style="padding-right: 0; padding-left: 0">
            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                <div style="padding-right: 0; padding-left: 0">
                    <div style="height: 50px">
                        <div class="dropdown float-left" style="margin-right: 15px">
                            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                태그 선택
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <li><a class="dropdown-item" href="#" type="title">제목</a></li>
                                <li><a class="dropdown-item" href="#" type="emp">부서</a></li>
                            </ul>
                        </div>
                        <div id="dataTable_filter" class="dataTables_filter float-left">
                            <label>
                                <input type="search" class="form-control form-control-sm" placeholder="검색어 입력"
                                       aria-controls="dataTable" style="font-size: 1.2em;">
                            </label>
                        </div>
                        <div class="float-right">
                            <button type="button" class="btn btn-primary"
                                    onclick="changeContentCus('main', 'noticewrite')">
                                글 작성
                            </button>
                        </div>
                    </div>
                    <ol class="list-group list-group-numbered" style="color: #000000;">
                        <c:forEach var="n" items="${nList}">
                            <li class="list-group-item d-flex justify-content-between align-items-start">
                                <div class="ms-2 me-auto">
                                    <label>
                                        <button style="font-weight: bold; font-size: 1.3em; background: inherit; border: none"
                                                type="button"
                                                onclick="changeContentCus('notice', 'noticeview')">${n.noticeTitle}
                                            <i class="fa-solid fa-paperclip"></i></button>
                                    </label>
                                    <div>
                                        <span class="badge bg-primary rounded-pill"
                                              style="color: #ffffff; margin-right: 20px; font-size: 0.9em">전체 공지</span>
                                        <span style="margin-right: 20px">관리자</span>
                                        <span style="margin-right: 20px">${n.noticeRegDate}</span>
                                        <span class="badge bg-primary rounded-pill"
                                              style="color: #ffffff">${n.noticeViewCount}</span>
                                        <c:if test="${n.noticeNewArticle}">
                                            <span class="badge rounded-pill bg-danger">new</span>
                                        </c:if>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>

                    </ol>
                    <%-- 페이지 버튼 영역 --%>
                    <nav aria-label="Page navigation example" style="text-align: center">
                        <ul class="pagination" style="display: inline-block">

                            <c:if test="${pm.prev}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="/main/notice?pageNum=${pm.beginPage - 1}&type=${s.type}&keyword=${s.keyword}"
                                       aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                    </a>
                                </li>
                            </c:if>

                            <c:forEach var="n" begin="${pm.beginPage}" end="${pm.endPage}" step="1">
                                <li data-page-num="${n}" class="page-item"><a class="page-link"
                                                                              href="/main/notice?pageNum=${n}&type=${s.type}&keyword=${s.keyword}">${n}</a>
                                </li>
                            </c:forEach>

                            <c:if test="${pm.next}">
                                <li class="page-item">
                                    <a class="page-link"
                                       href="/main/notice?pageNum=${pm.endPage + 1}&type=${s.type}&keyword${s.keyword}"
                                       aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                    </a>
                                </li>
                            </c:if>

                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>