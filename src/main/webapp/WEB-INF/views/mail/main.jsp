<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.teamProject.erp.dto.MailDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../tiles/layouts/include.jsp"/>
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">메일</h1>
    </div>
    <div class="card-body" style="height: 726px;">
        <div class="table-responsive">
            <div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
                <div class="col-sm-12" style="padding-left:1.5rem;">
                    <div class="col-md-12" style="height: 50px; padding-left: 0; padding-right: 0;">
                        <div class="dropdown float-left" style="margin-right: 15px">
                            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                태그 선택
                            </button>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <li><a class="dropdown-item" href="send">보낸 메일</a></li>
                                <li><a class="dropdown-item" href="receive">받은 메일</a></li>
                            </ul>
                        </div>
                        <div id="dataTable_filter" class="dataTables_filter float-left">
                            <label style="width: 390px;">
                                <input type="search" class="form-control form-control-sm" placeholder="검색어 입력" aria-controls="dataTable" style="font-size: 1.2em;height: 38px;">
                            </label>
                        </div>
                        <div class="float-right">
                            <button type="button" class="btn btn-primary">
                                <a href="/mailForm" style="color: #ffffff; outline: none; text-decoration: none">메일 작성</a></button>
                        </div>
                    </div>
                    <hr class="sidebar-divider">
                    <div id="mainContent" >
                        <ol class="list-group list-group-numbered col-md-12" style="color: #000000">
                            <c:choose>
                                <c:when test="${empty mList}">
                                    <h3>해당 내용이 존재하지 않습니다.</h3>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="m" items="${mList}">
                                        <li class="list-group-item d-flex justify-content-between align-items-start">
                                            <div class="ms-2 me-auto">
                                                <label>
                                                    <span class="fw-bold" style="font-weight: bold; font-size: 1.3em"><a href="/mailDetail/${m.mailNo}">${m.mailTitle}</a></span>
                                                </label>
                                                <div>
                                                    <span style="margin-right: 20px">${m.mailSender}</span>
                                                    <span style="margin-right: 20px">${m.mailRegdate}</span>
                                                </div>
                                            </div>
                                        </li>
                                        <br>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </ol>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">
    function changeContent(name){
        console.log(name)
        alert(name);
        $('#mainContent').children().remove();
        $('#mainContent').load("/mail/"+name);
    }
</script>

