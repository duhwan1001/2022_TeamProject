<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="card-title">
    <!-- Page Heading 회의실관리 등록 제목 설정-->
    <div class="d-sm-flex align-items-center justify-content-between mb-4" style="margin-left: 15px;">
        <div class="border-bottom-1">
            <h1 class="h3 mb-2 text-gray-700">회의실 관리 등록</h1>
        </div>
    </div>
</div>
<!-- 구분 선 속성-->
<hr class="sidebar-divider d-none d-md-block">
<div style="background:#ffffff; border-radius: 5px">
    <form action="" name="signup" id="signUpForm" method="post" style="margin-bottom: 0;">

        <table style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 80%">
            <tr>
                <td style="text-align: left">
                    <p><strong>회의실 명 :</strong>&nbsp;&nbsp;&nbsp;
                        <span id="idChk"></span></p>
                </td>
            </tr>
                <tr>
                    <td><input type="text" name="account" id="user_id"
                               class="form-control tooltipstered" maxlength="14" required="required"
                               aria-required="true"
                               style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
                               placeholder="회의실 명을 입력해주세요.">
                    </td>
                </tr>
            <tr>
                <td style="text-align: left">
                    <p><strong>입장가능 인원 :</strong>&nbsp;&nbsp;&nbsp;<span id="pwChk"></span></p>
                </td>
            </tr>
            <tr>
                <td><input type="text" size="17" maxlength="20" id="password" name="password"
                           class="form-control tooltipstered" maxlength="20" required="required"
                           aria-required="true"
                           style="ime-mode: inactive; margin-bottom: 25px; height: 40px; border: 1px solid #d9d9de"
                           placeholder="입장 가능 인원을 적어주세요."></td>
            </tr>
            <tr>
                <td style="text-align: left">
                    <p><strong>예약자명 :</strong>&nbsp;&nbsp;&nbsp;<span id="nameChk"></span></p>
                </td>
            </tr>
            <tr>
                <td><input type="text" name="name" id="user_name" class="form-control tooltipstered"
                           maxlength="6" required="required" aria-required="true"
                           style="margin-bottom: 25px; width: 100%; height: 40px; border: 1px solid #d9d9de"
                           placeholder="예약자명을 적어주세요."></td>
            </tr>
            <tr>
                <td style="text-align: left; width: 100%; height: 50vh">
                    <label>
                        <textarea>
                            회의실 설명 :
                            입실 가능 인원 :
                            예약자명 :
                            회의실 설명 :
                            사용여부 :
                            등록자 :
                        </textarea>
                    </label>&nbsp;&nbsp;&nbsp;
                </td>
            </tr>
            <tr>
                <td style="text-align: left">
                    <div>
                        <p>사용여부</p>
                        <input type="radio" id="yes" name="drone" value="Yes" checked>
                        <label for="yes">Yes</label>
                        <input type="radio" id="no" name="drone" value="No" checked>
                        <label for="no">No</label>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
<div style="float: right">
    <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">저장</button>
    <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">목록</button>
</div>



