<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- NoticeContentView_admin -->
<div class="card shadow mb-4">
    <div class="card-header py-3">
        <h1 class="m-0 font-weight-bold text-primary" style="text-align: center">공지사항</h1>
    </div>
    <div class="col-10" style="left: 7%">
        <div class="card-title">
            <div class="title" style="margin-top: 25px">
                <h2>${n.noticeTitle}</h2>
            </div>
            <div class="subTitle clearfix">
                <div class="float-left">작성자<span style="margin-left: 15px">관리자</span></div>
                <div class="float-left" style="margin-left: 15px">조회수<span style="margin-left: 15px">${n.noticeViewCount}</span></div>
                <div class="float-right">작성일<span style="margin-left: 15px">${n.noticeRegDate}</span></div>
            </div>
        </div>
        <!-- 내용 -->
        <div style="font-size: 1.1em; margin-bottom: 1.5em">
            <p class="notice-content">${n.noticeContent}</p>
        </div>
        <!-- 첨부파일 -->
        <div style="margin-bottom: 2em">
            <div><a href="#" class="uploaded-list"><i class="fa-solid fa-download"></i></a></div>
        </div>
        <!-- 버튼 -->
        <div>
            <div class="clearfix" style="margin-bottom: 2em">
                <div class="float-left">
                    <button id="list-btn" type="button" class="btn btn-primary">목록</button>
                </div>
                <div class="float-right">
                    <button id="mod-btn" type="button" class="btn btn-warning">수정</button>
                    <button id="del-btn" type="button" class="btn btn-danger">삭제</button>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    const $listBtn = document.getElementById('list-btn');
    const $modBtn = document.getElementById('mod-btn');
    const $delBtn = document.getElementById('del-btn');

    if ($modBtn !== null) {
        // 수정버튼
        $modBtn.onclick = e => {
            location.href = '/notice/modify?noticeNo=${n.noticeNo}';
        };
    }

    if ($delBtn !== null) {
        // 삭제버튼
        $delBtn.onclick = e => {
          if (!confirm('게시물이 삭제됩니다')){
              return;
          }
          location.href = '/notice/delete?noticeNo=${n.noticeNo}';
        };
    }

    // 목록버튼
    $listBtn.onclick = e => {
      console.log('목록버튼 선택');
      location.href = '/notice/list?pageNum=${p.pageNum}';
    };

    // $(document).ready(function () {
    //     let originFileName = fileName.subString(fileName.indexOf("_") + 1);
    //
    //     const $a = document.createElement('a');
    //     $a.setAttribute('href', '/loadFile?fileName=' + fileName);
    //
    //     $a.innerHTML += '<span>' + originFileName + '<span>';
    //
    //     $('.uploaded-list').append($a);
    // })
    //
    // // 파일 목록 불러오기
    // function showFileList() {
    //     fetch('/notice/file/' + nno)
    //         .then(res => res.json())
    //         .then(fileNames => {
    //             showFileData(fileNames);
    //         });
    // }
    //
    // showFileList();
</script>
