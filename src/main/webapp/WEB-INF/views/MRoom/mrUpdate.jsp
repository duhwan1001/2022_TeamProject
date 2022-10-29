<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
    <div class="card-title">
        <!-- Page Heading 회의실관리 목록 수정 설정-->
        <div class="d-sm-flex align-items-center justify-content-between mb-4" style="margin-left: 15px;">
            <div class="border-bottom-1">
                <h1 class="h3 mb-2 text-gray-700">회의실 관리 수정</h1>
            </div>
        </div>
    </div>
    <!-- 구분 선 속성-->
    <hr class="sidebar-divider d-none d-md-block">
    <div style="background:#ffffff; border-radius: 5px">
        <form action="" name="signup" id="signUpForm" method="post"
              style="margin-bottom: 0;">

            <table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 100%">
                <tr>
                    <td style="text-align: left">
                        <p><strong>회의실 명:</strong>&nbsp;&nbsp;&nbsp;
                            <span id="idChk"></span></p>
                    </td>
                </tr>
                <%--                <tr>--%>
                <%--                    <td><input type="text" name="account" id="user_id"--%>
                <%--                               class="form-control tooltipstered" maxlength="14" required="required"--%>
                <%--                               aria-required="true"--%>
                <%--                               style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"--%>
                <%--                               placeholder="숫자와 영어로 4-14자">--%>
                <%--                    </td>--%>

                <%--                </tr>--%>

                <tr>
                    <td style="text-align: left">
                        <p><strong>비밀번호를 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk"></span></p>
                    </td>
                </tr>
                <tr>
                    <td><input type="password" size="17" maxlength="20" id="password" name="password"
                               class="form-control tooltipstered" maxlength="20" required="required"
                               aria-required="true"
                               style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
                               placeholder="영문과 특수문자를 포함한 최소 8자"></td>
                </tr>
                <tr>
                    <td style="text-align: left">
                        <p><strong>비밀번호를 재확인해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk2"></span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><input type="password" size="17" maxlength="20" id="password_check"
                               name="pw_check" class="form-control tooltipstered" maxlength="20"
                               required="required" aria-required="true"
                               style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
                               placeholder="비밀번호가 일치해야합니다."></td>
                </tr>

                <tr>
                    <td style="text-align: left">
                        <p><strong>이름을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="nameChk"></span></p>
                    </td>
                </tr>
                <tr>
                    <td><input type="text" name="name" id="user_name" class="form-control tooltipstered"
                               maxlength="6" required="required" aria-required="true"
                               style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
                               placeholder="한글로 최대 6자"></td>
                </tr>


                <tr>
                    <td style="text-align: left">
                        <p><strong>이메일을 입력해주세요.</strong>&nbsp;&nbsp;&nbsp;<span id="emailChk"></span>
                        </p>
                    </td>
                </tr>
                <tr>
                    <td><input type="email" name="email" id="user_email"
                               class="form-control tooltipstered" required="required" aria-required="true"
                               style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
                               placeholder="ex) abc@mvc.com"></td>
                </tr>


                <tr>
                    <td style="padding-top: 10px; text-align: center">
                        <p><strong>회원가입하셔서 더 많은 서비스를 사용하세요~~!</strong></p>
                    </td>
                </tr>
                <tr>
                    <td style="width: 100%; text-align: center; colspan: 2;">
                        <input type="button" value="회원가입" class="btn form-control tooltipstered"
                               id="signup-btn"
                               style="background: gray; margin-top: 0; height: 40px; color: white; border: 0px solid #388E3C; opacity: 0.8">
                    </td>
                </tr>

            </table>
        </form>
        <!-- summernote 수정 예정 -->
        <%--        <form action="">--%>
        <%--            회의실 명:<br>--%>
        <%--            <label>--%>
        <%--                <input type="text" name="firstname">--%>
        <%--            </label>--%>
        <%--            <br>--%>
        <%--            입실 가능 인원:<br>--%>
        <%--            <label>--%>
        <%--                <input type="text" name="human">--%>
        <%--            </label>--%>
        <%--            <br>--%>
        <%--            예약자명:<br>--%>
        <%--            <label>--%>
        <%--                <input type="text" name="name">--%>
        <%--            </label>--%>
        <%--            <br>--%>
        <%--            회의실 설명:<br>--%>
        <%--            <label>--%>
        <%--                <input type="text" name="content">--%>
        <%--            </label>--%>
        <%--            <br>--%>
        <%--            사용여부:<br>--%>
        <%--            <label>--%>
        <%--                <input type="text" name="yo">--%>
        <%--            </label>--%>
        <%--            <br>--%>
        <%--            등록일자:<br>--%>
        <%--            <label>--%>
        <%--                <input type="text" name="day">--%>
        <%--            </label>--%>
        <%--        </form>--%>
    </div>
    <div>
        <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrdetail')">저장</button>
        <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">목록</button>
    </div>
</div>


