<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항</h1>
    </div>
    <div class="card-body">
        <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4" style="padding-right: 0; padding-left: 0">
            <div style="height: 38px">
                <form action="/main/notice" method="get" style="float: left; height: inherit">
                    <select class="form-select float-left" name="type" id="search-type"
                            style="margin-right: 2em; height: 38px">
                        <option id="searchTitle" value="title">제목</option>
                    </select>

                    <input id="searchKeyword" type="text" class="form-control form-control-sm float-left" name="keyword"
                           placeholder="검색어 입력"
                           value="${s.keyword}" style="width: 40%; height: 38px; margin-right: 0.3em; font-size: 1.2em">

                    <button class="btn btn-primary" type="submit" style="height: 38px" onclick="noticeSearchContent()">
                        <i class="fas fa-search"></i>
                    </button>
                </form>
                <div class="float-right btn-write">
                    <button type="button" class="btn btn-primary"
                            onclick="changeContentCus('notice', 'noticewrite')">
                        글 작성
                    </button>
                    <%--                    <a class="btn btn-primary" href="/notice/write">--%>
                    <%--                        글 작성--%>
                    <%--                    </a>--%>
                </div>
            </div>
            <ol class="list-group list-group-numbered notice-content" style="color: #000000;">
                <c:forEach var="n" items="${nList}">
                    <li class="list-group-item d-flex justify-content-between align-items-start">
                        <div class="ms-2 me-auto">
                            <label>
                                    <%--                                <button data-no="${n.noticeNo}" style="font-weight: bold; font-size: 1.3em; background: inherit; border: none"--%>
                                    <%--                                        type="button"--%>
                                    <%--                                        onclick="changeContentCus('notice', 'noticeview')">${n.noticeTitle}--%>
                                    <%--&lt;%&ndash;                                        >${n.noticeTitle}&ndash;%&gt;--%>
                                    <%--                                    <i class="fa-solid fa-paperclip"></i></button>--%>
                                <button data-no="${n.noticeNo}"
                                        style="font-weight: bold; font-size: 1.3em; background: inherit; border: none"
                                        onclick="changeContent('/notice/noticeview' + ${n.noticeNo})">${n.noticeTitle}
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
                               href="/notice/list?pageNum=${pm.beginPage - 1}&type=${s.type}&keyword=${s.keyword}"
                               aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                    </c:if>

                    <c:forEach var="n" begin="${pm.beginPage}" end="${pm.endPage}" step="1">
                        <li data-page-num="${n}" class="page-item"><a class="page-link"
                                                                      href="/notice/list?pageNum=${n}&type=${s.type}&keyword=${s.keyword}">${n}</a>
                        </li>
                    </c:forEach>

                    <c:if test="${pm.next}">
                        <li class="page-item">
                            <a class="page-link"
                               href="/notice/list?pageNum=${pm.endPage + 1}&type=${s.type}&keyword${s.keyword}"
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

<script>
    function alertServerMessage() {
        const msg = '${msg}';
        // console.log('msg: ', msg);

        if (msg === 'reg-success') {
            alert('공지사항 등록 완료')
        }
    }

    <%--function detailEvent() {--%>
    <%--    // 상세보기 요청 이벤트--%>
    <%--    const $ol = document.querySelector(".notice-content");--%>

    <%--    $ol.addEventListener('click', e => {--%>
    <%--        if (!e.target.matches('.notice-content li div label button')) return;--%>

    <%--        let nn = +e.target.dataset.no;--%>
    <%--        console.log('글번호: ' + nn);--%>

    <%--        ${n.noticeNo} = nn;--%>

    <%--        &lt;%&ndash;location.href = '/notice/content/' + nn + "?pageNum=${pm.page.pageNum}";&ndash;%&gt;--%>
    <%--        location.href = '/notice/noticeview/' + nn;--%>
    <%--        // location.href = '/main/notice/content/' + nn;--%>
    <%--        // location.href = '/notice/noticeview/' + nn;--%>
    <%--    });--%>
    <%--}--%>

    // 현재 위치한 페이지에 active 스타일 부여
    function appendPageActive() {
        // 현재 내가 보고 있는 페이지 넘버
        const curPageNum = '${pm.page.pageNum}';
        // console.log("현재페이지: ", curPageNum);
        const $ul = document.querySelector('.pagination');

        for (let $li of [...$ul.children]) {
            if (curPageNum === $li.dataset.pageNum) {
                $li.classList.add('active');
                break;
            }
        }
    }

    // 옵션태그 고정
    function fixSearchOption() {
        const $select = document.getElementById('search-type');

        for (let $opt of [...$select.children]) {
            if ($opt.value === '${s.type}') {
                $opt.setAttribute('selected', 'selected');
                break;
            }
        }
    }

    (function () {
        alertServerMessage();
        detailEvent();
        appendPageActive();
        fixSearchOption();
    })();
</script>

<script type="text/javascript">
    function noticeSearchContent() {
        const title = $("#search-type").val();
        const keyword = $("#searchKeyword").val();

        alert(title);
        alert(keyword);

        $('#mainContent').children().remove();
        $('#mainContent').load("main/notice" + "?type=" + title + "&keyword=" + keyword);
    }

</script>