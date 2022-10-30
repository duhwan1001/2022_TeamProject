<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="card-title">
    <!-- Page Heading 회의실관리 수정-->
    <div class="d-sm-flex align-items-center justify-content-between mb-4" style="margin-left: 15px;">
        <div class="border-bottom-1">
            <h1 class="h3 mb-2 text-gray-700">회의실 수정</h1>
        </div>
    </div>
</div>
<!-- 구분 선 속성-->
<hr class="sidebar-divider d-none d-md-block">
<div style="background:#ffffff; border-radius: 5px; margin-top: 30px">
    <div class="default">
        <form action="" name="signup" id="signUpForm" method="get" style="margin-bottom: 0;">
            <div style="cellpadding: 0; cellspacing: 0; margin: 0 auto; width: 80%">
                <div>
                    <div class="input-group input-group-lg" style="margin-bottom: 30px">
                        <span class="input-group-text" id="inputGroup-sizing-lg">회의실 명:</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" readonly>
                    </div>
                </div>
                <div>
                    <div class="input-group input-group-lg" style="margin-bottom: 30px">
                        <span class="input-group-text" id="inputGroup-sizing-lg1">최대 인원:</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" readonly>
                    </div>
                </div>
                <div>
                    <div class="input-group input-group-lg" style="margin-bottom: 30px">
                        <span class="input-group-text" id="inputGroup-sizing-lg2">예약자 명:</span>
                        <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg" readonly>
                    </div>
                </div>
                <div style="text-align: left; margin-bottom: 1.5em">
                    <div class="mb-5">
                        <div class="input-group" style="margin-bottom: 30px">
                            <span class="input-group-text">회의실 설명:</span>
                            <textarea class="form-control" aria-label="With textarea" rows="5" placeholder="사용하실 품목들을 입력해주세요."></textarea>
                        </div>
                    </div>
                </div>
                <div class="form-floating" style="margin-bottom: 30px">
                    <select class="form-select" aria-label="Disabled select example">
                        <option selected>사용여부</option>
                        <option value="1">Yes</option>
                        <option value="2">No</option>
                    </select>
                </div>
                <div>
                    <button style="float: right" type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">저장</button>
                    <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">목록</button>
                </div>
            </div>
        </form>
    </div>
</div>



