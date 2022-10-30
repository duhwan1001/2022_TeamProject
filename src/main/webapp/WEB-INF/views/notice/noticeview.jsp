<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- NoticeContentView_admin -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항</h1>
    </div>
    <div class="col-10" style="left: 7%">
        <div class="card-title">
            <div class="title" style="margin-top: 25px">
                <h2>제목</h2>
            </div>
            <div class="subTitle clearfix">
                <div class="float-left">작성자 김영우</div>
                <div class="float-left" style="margin-left: 15px">조회수 30000000</div>
                <div class="float-right">작성일 2022-10-28</div>
            </div>
        </div>
        <!-- 내용 -->
        <div style="font-size: 1.1em; margin-bottom: 1.5em">
            행정각부의 설치·조직과 직무범위는 법률로 정한다.
            대한민국의 영토는 한반도와 그 부속도서로 한다.
            각급 선거관리위원회의 조직·직무범위 기타 필요한 사항은 법률로 정한다.

            대통령은 헌법과 법률이 정하는 바에 의하여 국군을 통수한다.
            군인은 현역을 면한 후가 아니면 국무위원으로 임명될 수 없다.
            모든 국민은 주거의 자유를 침해받지 아니한다.
            주거에 대한 압수나 수색을 할 때에는 검사의 신청에 의하여 법관이 발부한 영장을 제시하여야 한다.

            제1항의 해임건의는 국회재적의원 3분의 1 이상의 발의에 의하여 국회재적의원 과반수의 찬성이 있어야 한다.
            대통령은 국회에 출석하여 발언하거나 서한으로 의견을 표시할 수 있다.
        </div>
        <!-- 첨부파일 -->
        <div style="margin-bottom: 2em">
            <div>첨부파일<a href="#"></a></div>
        </div>
        <!-- 버튼 -->
        <div>
            <div class="clearfix" style="margin-bottom: 2em">
                <div class="float-left">
                    <button type="button" class="btn btn-primary" onclick="changeContentCus('main', 'notice')">목록</button>
                </div>
                <div class="float-right">
                    <button type="button" class="btn btn-warning" onclick="changeContentCus('notice', 'noticemodify')">
                        수정
                    </button>
                    <button type="button" class="btn btn-danger" onclick="">
                        삭제
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
