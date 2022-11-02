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
        <div class="col-xl-4">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">프로필 이미지</div>
                <div class="card-body text-center">
                    <!-- Profile picture image-->
                    <img class="img-account-profile rounded-circle mb-2" src="http://bootdey.com/img/Content/avatar/avatar1.png" alt="" style="height: 74px;">
                    <!-- Profile picture help block-->
                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 10 MB</div>
                    <!-- Profile picture upload button-->
                    <form action="upload_ok" method="post" enctype="multipart/form-data">
                        <input type="file" name="file"><br><br>
                        <input class="btn btn-primary" type="submit" value="이미지 업로드">
                    </form>
                </div>
            </div>
        </div>
        <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">계정 정보</div>
                <div class="card-body">
                    <form>
                        <div class="mb-3">
                            <label class="small mb-1" for="userPw">비밀번호 수정</label>
                            <input class="form-control" id="userPw" type="password" placeholder="비밀번호를 입력하세요" value="">
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="userPhone">휴대폰 번호</label>
                            <input class="form-control" id="userPhone" type="number" placeholder="휴대폰 번호를 입력하세요" value="">
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="userAddr">주소</label>
                            <input class="form-control" id="userAddr" type="text" placeholder="주소를 입력하세요" value="">
                        </div>
                        <div class="mb-3">
                            <label class="small mb-1" for="userName">이름</label>
                            <input class="form-control" id="userName" type="text" placeholder="이름을 입력하세요" value="">
                        </div>
                        <!-- Save changes button-->
                        <div class="mb-3">
                            <button class="btn btn-primary" type="button">정보 저장</button>
                        </div>
                    </form>
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