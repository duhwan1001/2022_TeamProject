<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.teamProject.erp.dto.MailDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../../tiles/layouts/include.jsp"/>
<style>
  /*input 화살표 없애주는 css*/
  input::-webkit-outer-spin-button,
  input::-webkit-inner-spin-button {
    -webkit-appearance: none;
  }
</style>
<div class="container-xl px-4 mt-4">
  <div class="row">
    <div class="col-xl-8">
      <!-- Account details card-->
      <div class="card mb-4">
        <div class="card-header">메일 작성</div>
        <div class="card-body">
          <form action="/mailSubmit" method="post" id="info">
            <div class="mb-3">
              <label class="small mb-1" for="mailTitle">제목</label>
              <input class="form-control" id="mailTitle" name="mailTitle" type="text" placeholder="제목을 입력하세요" value="">
            </div>
            <div class="mb-3">
              <label class="small mb-1" for="mailReceiver">받는 사람</label>
              <input class="form-control" id="mailReceiver" name="mailReceiver" type="text" placeholder="받는 사람의 메일 주소를 입력하세요" value="">
            </div>
            <div class="mb-3">
              <label class="small mb-1" for="mailContent">내용</label>
              <textarea class="form-control" id="mailContent" name="mailContent" type="text" placeholder="내용를 입력하세요" value="" style="height: 300px;"></textarea>
            </div>
            <!-- Save changes button-->
            <div class="mb-3">
              <button class="btn btn-primary" type="button" onclick="submit(info)">전송</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript">

</script>