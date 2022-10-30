<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="card-title">
    <button onclick="changeContentCus('main', 'mrmain')" style="float: left; font-size: 24px; border: none; background: inherit">
        <i class="fa-solid fa-arrow-left"></i></button>
    <!-- Page Heading 회의실관리 상세 제목 설정-->
    <div class="d-sm-flex align-items-center justify-content-between mb-4" style="margin-left: 15px;">
        <div class="border-bottom-1">
            <h1 class="h3 mb-2 text-gray-700">회의실 관리 상세</h1>
        </div>
    </div>
</div>
<!-- 구분 선 속성-->
<hr class="sidebar-divider d-none d-md-block">
<!-- 이미지 속성 -->
<div style="text-align: center; margin-bottom: 0.7em">
    <img src="${pageContext.request.contextPath}/img/mrimg/mr1.jpg" alt="A 회의실"/>
</div>
<div style="text-align: center; margin-bottom: 0.7em">
    <img src="${pageContext.request.contextPath}/img/mrimg/mr2.jpg" alt="B 회의실"/>
</div>
<div style="text-align: center; margin-bottom: 0.7em">
    <img src="${pageContext.request.contextPath}/img/mrimg/mr3.png" alt="C 회의실"/>
</div>
<br>
<div class="col-10" style="background:#ffffff; border-radius: 5px; left: 7%">
    공무원의 신분과 정치적 중립성은 법률이 정하는 바에 의하여 보장된다. 모든 국민은 행위시의 법률에 의하여 범죄를 구성하지 아니하는 행위로 소추되지 아니하며, 동일한 범죄에 대하여 거듭 처벌받지 아니한다.
    대통령의 임기연장 또는 중임변경을 위한 헌법개정은 그 헌법개정 제안 당시의 대통령에 대하여는 효력이 없다. 대통령은 국가의 원수이며, 외국에 대하여 국가를 대표한다.
</div>
<br>
<div>
    <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'mrmain')">목록</button>
    <button type="button" class="btn btn-danger" style="float: right; margin-left: 10px" onclick="cancelRes()">예약취소</button>
    <button type="button" class="btn btn-warning" style="float: right; color: #ffffff"
            onclick="changeContentCus('mrdetail', 'mrupdate')">수정</button>
</div>
<script>
    function cancelRes() {
        var delConfirm = confirm('예약을 쥐소하시겠습니까?');

        if(delConfirm){
            alert('예약 취소되었습니다.');
            changeContentCus('main', 'mrmain');
        }
        else{

        }
    }
</script>

