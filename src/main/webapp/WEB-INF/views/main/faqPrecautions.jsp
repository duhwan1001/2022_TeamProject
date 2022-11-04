<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<style type="text/css">
	.headBox {
		margin-top : 0px;
		background: #CA394F;
		text-align:center;
		height: 75px;
	}
	.boxAll {
		margin : 0px;
		background: #F3EEE8;
		text-align:center;
	}
	.boxTwo{
		margin : 25px;
	}
	.boxTwo button{
		width: 250px;
		height: 60px;
		font-size:20px;
		font-weight:bold;
	}
	.boxTwo table{
		background: #ffffff;
		width: 100%;
		height: 400px;
	} 
	.boxTwo td{
		text-align: left;
		border : 1px solid black;
		margin : 10px;
	}
	.boxTwo th{
		text-align: center;
		border : 1px solid black;
		margin : 10px;
	}
	input {
  		width:50px;
  		font-size:20px;
  		margin : 10px;
	}
	select {
		width:85px;
  		height:35px;
  		font-size:20px;
  		margin : 10px;
	}	
</style>

<body>
    <div class="boxAll">
    <div class="headBox">
    <div style="text-align:center">
    <h1 style="color: ffffff;">FAQ 게시판 주의사항</h1>
    </div>
    </div>
    <div class="boxTwo">
        <p>이 자주묻는 질문 게시판에서는 관리자 이외의 일반 사용자가 게시물을 추가, 삭제, 수정<br>
            등이 불가능하며 관리자만이 권한을 갖고 있습니다. 일반 사용자께서는 
            게시물 조회 <br>및 상세내역 보기만 권한을 갖고 계십니다. 이점을 유의해 주시기 바랍니다.
            감사합니다.

        </p>
    
    <br/>
    </div>
    </div>
</body>