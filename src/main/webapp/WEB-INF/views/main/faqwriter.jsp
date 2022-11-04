<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

            <div class="boardDTO write">
                <h2 align="center">FAQ 글 작성</h2>
                <form name="savefrm" action="/main/faqsave" method="post">
                    <div class="mainboard-3">
                        <label for="write_title" class="form-label">글제목</label>
                        <input type="text" class="form-control" id="faqTitle" placeholder="제목" name="faqTitle" placeholder="제목을 입력해 주세요." required>
                    </div>
                    <div class="mainboard-3">
                        <label for="write_text" class="form-label">내용</label>
                        <input type="text" class="form-control" name="faqContent" id="faqContent" row="10" placeholder="내용을 입력해 주세요." required>
                    </div>
            </div>

                <div>
                    <button type="button" class="btn btn-primary" onclick="changeContentCusd('main', 'faqsave')">등록</button>
                    <button id="to-list" type="button" class="btn btn-primary" onclick="changeContentCus('main', 'faq')">목록</button>
                </div>
            </form>


            <script>

                function changeContentCusd(path, name){

                    const $faqTtile = $('#faqTitle');
                    const $faqContent = $('#faqContent');

                    if($faqTtile.val() ===''|| $faqTtile.val() === null){
                        alert('제목은 필수사항입니다.');
                        return;
                    }

                    if($faqContent.val() ==='' || $faqContent.val() === null){
                        alert('내용은 필수 사항입니다.');
                        return;

                    }

                    $('#mainContent').children().remove();
                    $('#mainContent').load("/" + path + "/"+name+"?faqTitle="+$faqTtile.val()+"&faqContent="+$faqContent.val());

                }
            </script>
