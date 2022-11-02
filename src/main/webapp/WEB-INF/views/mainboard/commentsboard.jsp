<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 댓글 페이지 -->

<!-- 댓글 쓰기 -->
<div id="comment_body">
    <label for="comment_text" >댓글내용</label>
    <textareaa roew="3" id="comment_text" name="cmtext" class="cm-form-control" placeholder="댓글응 입력해주세요."></textareaa>

    <div>
        <label for="comment_writer">댓글 작성자</label>
        <input id="comment_writer" name="cmwriter" type="text" class="cm-form-control" placeholder="작성자 이름">
        <button id="comment_btn" type="button" class="btn btn-info cm-form-control" >등록</button>
    </div>
</div>

<!-- 댓글 내용 -->
<div>

    <!-- 댓글 헤더 -->
    <div>
        <div>댓글(<span id="comment_count">0</span>)</div>
    </div>

    <!-- 댓글 바디 -->
    <div id="comment_text">
        <div id="comment_data">
            <!-- 댓글 정보 -->
        </div>
    </div>

    <!-- 댓글 페이징 -->

    <!-- 요기는 동철씨한테 받아서 넣을 곳 -->

    <!-- 댓글 수정 -->
    <div id=comment_revise_modal>

        <!-- 모달 헤더 -->
        <div class="modal-header">
            <h3 class="modal-title">댓글 수정하기</h3>
            <button type="button" class="btn btn-light" data-bs-dismiss="modal">X</button>
        </div>

        <!-- 모달 바디 -->
        <div class="modal-body">
            <div class="form-gruop">
                <input id="mod_comment" type="hidden">
                <label for="mod_comment_text" hidden>댓글내용</label>
                <textareaa id="mod_comment_text" class="cm-form-control" placeholder="수정할 댓글 내용을 입력하세요." row="3"></textarea>
            </div>
        </div>

        <!-- 모달 푸터 -->
        <div class="modal-footer">
            <button id="comment_mod_btn" type="button" class="btn btn-warning">수정</button>
            <button id="modal_close" type="button" class="btn btn-light" data-bs-dismiss>닫기</button>
        </div>

    </div>
</div>