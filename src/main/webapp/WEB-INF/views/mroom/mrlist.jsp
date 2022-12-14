<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Begin Page Content 오른쪽 가운데 안에 들어가는 내용들의 전체 박스-->
<!-- Page Heading 회의실관리 목록 제목 설정-->
<div class="d-sm-flex align-items-center justify-content-between mb-4">
    <div class="border-bottom-1">
        <h1 class="h3 mb-2 text-gray-700">회의실 목록</h1>
    </div>
</div>
<!-- 구분 선 속성-->
<hr class="sidebar-divider d-none d-md-block">

<div class="input-group mb-4">
    <form action="list" method="get">

        <select class="form-select" name="type" id="search-type">
            <option value="title">제목</option>
            <%--            <option value="content">내용</option>--%>
            <%--            <option value="writer">작성자</option>--%>
            <%--            <option value="tc">제목+내용</option>--%>
        </select>

        <input style="width: 100%; padding: 10px 20px; margin: 5px 0; box-sizing: border-box;" type="text" class="form-control" name="keyword" placeholder="입력해주세요!" value="${s.keyword}">

        <div class="input-group-append">
            <button class="btn btn-primary" type="submit">
                <i class="fas fa-search"></i>
            </button>
        </div>
    </form>
</div>
<%--<div class="input-group mb-4">--%>
<%--    <form action="list" method="get">--%>
<%--        <select class="form-select" name="type" id="search-type">--%>
<%--            <option value="title">제목</option>--%>
<%--            &lt;%&ndash;            <option value="content">내용</option>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <option value="writer">작성자</option>&ndash;%&gt;--%>
<%--            &lt;%&ndash;            <option value="tc">제목+내용</option>&ndash;%&gt;--%>
<%--        </select>--%>

<%--        <input type="text" class="form-control bg-white border-0 small" placeholder="내용을 입력하세요."--%>
<%--               aria-label="Search" aria-describedby="basic-addon2" name="keyword" value="${s.keyword}">--%>

<%--        <div class="input-group-append">--%>
<%--            <button class="btn btn-primary" type="button">--%>
<%--                <i class="fas fa-search fa-sm"></i>--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </form>--%>
<%--</div>--%>
<!-- Content Row 회의실관리 목록 내용 담고있는 전체 박스-->
<div class="row">
    <!-- Earnings (Monthly) Card Example -->
    <div class="col-xl-12">
        <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
                <div class="row no-gutters align-items-center">
                    <div class="col mr-2">
                        <div class="f-s text-xs font-weight-bold text-primary text-uppercase mb-1">
                            <table class="table" style="margin-bottom: 5%">
                                <thead>
                                <tr>
                                    <th scope="col">번호</th>
                                    <th scope="col">회의실명</th>
                                    <th scope="col">최대인원</th>
                                    <th scope="col">예약자명</th>
                                    <th scope="col">사용시간</th>
                                    <th scope="col">작성시간</th>
                                </tr>
                                </thead>
                                <tbody class="table-group-divider">
                                <c:forEach var="m" items="${mList}">
                                    <tr>
                                        <td>${m.mrNo}</td>
                                        <td><a href="/mrmain/mrdetail" onclick="changeContentCus('mrmain', 'mrdetail')">
                                                ${m.mrTitle}
                                                <%--                                                ${m.shortTitle}--%>
                                            <c:if test="${m.mrNewArticle}">
                                                <span class="badge rounded-pill bg-danger">new</span>
                                            </c:if></a>
                                        </td>
                                        <td>${m.mrMax}</td>
                                        <td>${m.mrUsers}</td>
                                        <td>${m.mrTime}</td>
                                        <td>${m.mrRegDate}</td>
                                    </tr>
                                </c:forEach>
                                <%--                                    <tr>--%>
                                <%--                                        <th scope="row">1</th> mrNo - 글 작성 번호--%>
                                <%--                                        <td><a href="#" onclick="changeContentCus('mrmain', 'mrdetail')">A 회의실</a></td>--%>
                                <%--                                        <td>5명</td>--%>
                                <%--                                        <td>김동철</td>--%>
                                <%--                                        <td>사용 시간</td>--%>
                                <%--                                    </tr>--%>
                                </tbody>
                            </table>
                            <nav aria-label="Page navigation example">
                                <button type="button" class="btn btn-primary float-right clearfix" onclick="changeContentCus('mrmain', 'mrwrite')">예약</button>
                                <ul class="pagination justify-content-center">
                                    <c:if test="${pm.prev}">
                                        <li class="page-item">
                                            <a class="page-link" href="/mrmain/list?pageNum=${pm.beginPage - 1}&amount=${pm.page.amount}&type=${s.type}&keyword=${s.keyword}">prev</a>
                                        </li>
                                    </c:if>

                                    <c:forEach var="n" begin="${pm.beginPage}" end="${pm.endPage}" step="1">
                                        <li data-page-num="${n}" class="page-item">
                                            <a class="page-link" href="/mrmain/list?pageNum=${n}&amount=${pm.page.amount}&type=${s.type}&keyword=${s.keyword}">${n}</a>
                                        </li>
                                    </c:forEach>

                                    <c:if test="${pm.next}">
                                        <li class="page-item">
                                            <a class="page-link" href="/main/mrmain?pageNum=${pm.endPage + 1}&amount=${pm.page.amount}&type=${s.type}&keyword=${s.keyword}">next</a>
                                        </li>
                                    </c:if>
                                </ul>
                            </nav>
                            <%--                            <nav aria-label="Page navigation example">--%>
                            <%--                                <button type="button" class="btn btn-primary float-right clearfix" onclick="changeContentCus('mrmain', 'mrwrite')">예약</button>--%>
                            <%--                                <ul class="pagination justify-content-center">--%>
                            <%--                                    <li class="page-item">--%>
                            <%--                                        <a class="page-link" href="#" aria-label="Previous">--%>
                            <%--                                            <span aria-hidden="true">&laquo;</span>--%>
                            <%--                                        </a>--%>
                            <%--                                    </li>--%>
                            <%--                                    <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
                            <%--                                    <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
                            <%--                                    <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                            <%--                                    <li class="page-item">--%>
                            <%--                                        <a class="page-link" href="#" aria-label="Next">--%>
                            <%--                                            <span aria-hidden="true">&raquo;</span>--%>
                            <%--                                        </a>--%>
                            <%--                                    </li>--%>
                            <%--                                </ul>--%>
                            <%--                            </nav>--%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<!-- Begin Page Content 오른쪽 가운데 안에 들어가는 내용들의 전체 박스-->--%>
<%--<div class="container-fluid">--%>
<%--    <!-- Page Heading 회의실관리 목록 제목 설정-->--%>
<%--    <div class="d-sm-flex align-items-center justify-content-between mb-4">--%>
<%--        <div class="border-bottom-1">--%>
<%--            <h1 class="h3 mb-2 text-gray-700">회의실 목록</h1>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!-- 구분 선 속성-->--%>
<%--    <hr class="sidebar-divider d-none d-md-block">--%>

<%--    <div class="input-group mb-4">--%>
<%--        <input type="text" class="form-control bg-white border-0 small" placeholder="내용을 입력하세요."--%>
<%--               aria-label="Search" aria-describedby="basic-addon2">--%>
<%--        <div class="input-group-append">--%>
<%--            <button class="btn btn-primary" type="button">--%>
<%--                <i class="fas fa-search fa-sm"></i>--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <!-- Content Row 회의실관리 목록 내용 담고있는 전체 박스-->--%>
<%--    <div class="row">--%>
<%--        <!-- Earnings (Monthly) Card Example -->--%>
<%--        <div class="col-xl-12">--%>
<%--            <div class="card border-left-primary shadow h-100 py-2">--%>
<%--                <div class="card-body">--%>
<%--                    <div class="row no-gutters align-items-center">--%>
<%--                        <div class="col mr-2">--%>
<%--                            <div class="f-s text-xs font-weight-bold text-primary text-uppercase mb-1">--%>
<%--                                <table class="table" style="margin-bottom: 5%">--%>
<%--                                    <thead>--%>
<%--                                    <tr>--%>
<%--                                        <th scope="col">순번</th>--%>
<%--                                        <th scope="col">회의실명</th>--%>
<%--                                        <th scope="col">입장가능인원</th>--%>
<%--                                        <th scope="col">예약자명</th>--%>
<%--                                        <th scope="col">사용여부</th>--%>
<%--                                    </tr>--%>
<%--                                    </thead>--%>
<%--                                    <tbody class="table-group-divider">--%>
<%--                                    <tr>--%>
<%--                                        <th scope="row">1</th>--%>
<%--                                        <td><a href="#" onclick="changeContentCus('main', 'mrdetail')">A 회의실</a></td>--%>
<%--                                        <td>5명</td>--%>
<%--                                        <td>김동철</td>--%>
<%--                                        <td>AM8:00-AM10:00</td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <th scope="row">2</th>--%>
<%--                                        <td><a href="#" onclick="changeContentCus('main', 'mrdetail')">B 회의실</a></td>--%>
<%--                                        <td>20명</td>--%>
<%--                                        <td>김영우</td>--%>
<%--                                        <td>AM11:00-PM13:00</td>--%>
<%--                                    </tr>--%>
<%--                                    <tr>--%>
<%--                                        <th scope="row">3</th>--%>
<%--                                        <td><a href="#" onclick="changeContentCus('main', 'mrdetail')">C 회의실</a></td>--%>
<%--                                        <td>10명</td>--%>
<%--                                        <td>김두환</td>--%>
<%--                                        <td>PM16:00-PM20:00</td>--%>
<%--                                    </tr>--%>
<%--                                    </tbody>--%>
<%--                                </table>--%>
<%--                                <nav aria-label="Page navigation example">--%>
<%--                                    <!-- 등록 버튼 -->--%>
<%--                                    <button type="button" class="btn btn-primary float-right clearfix"--%>
<%--                                            onclick="changeContentCus('mrlist', 'mrregistration')">예약</button>--%>
<%--                                    <!-- Pagination 속성 설정 -->--%>
<%--                                    <ul class="pagination justify-content-center">--%>
<%--                                        <li class="page-item">--%>
<%--                                            <a class="page-link" href="#" aria-label="Previous">--%>
<%--                                                <span aria-hidden="true">&laquo;</span>--%>
<%--                                            </a>--%>
<%--                                        </li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">1</a></li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">2</a></li>--%>
<%--                                        <li class="page-item"><a class="page-link" href="#">3</a></li>--%>
<%--                                        <li class="page-item">--%>
<%--                                            <a class="page-link" href="#" aria-label="Next">--%>
<%--                                                <span aria-hidden="true">&raquo;</span>--%>
<%--                                            </a>--%>
<%--                                        </li>--%>
<%--                                    </ul>--%>
<%--                                </nav>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
