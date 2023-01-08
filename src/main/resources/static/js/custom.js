$('#mainContent').load("/main/dashboard");

function changeContent(name){
    
    $('#mainContent').children().remove();
    $('#mainContent').load("/main/"+name);
}

function changeContentCus(path, name){
    
    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/"+name);
}

function changeContentCuswriter(path, name){

    const $faqTtile = $('#faqTitle');
    const $faqContent = $('#faqContent');
    const $userUserId = $('#userUserId');

    if($faqTtile.val() ===''|| $faqTtile.val() === null){
        alert('제목은 필수사항입니다.');
        return;
    }

    if($faqContent.val() ==='' || $faqContent.val() === null){
        alert('내용은 필수 사항입니다.');
        return;

    }

    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/"+name+"?faqTitle="+$faqTtile.val()+"&faqContent="+$faqContent.val() + "&userUserId=" + $userUserId.val());

}

function changeContentCusdelete(path, name) {

    // console.log(name);

    $.ajax({
        type:"get",
        url:"/main/faqdelete",
        data: {
            faqNo : $('#faqNo').val(),
            userUserId : $('#userUserId').val(),
        },
        // $getdata : '${okdata}',

        success: function(get){
            console.log('전달받은값확인:', get);
            alert('삭제에 성공 했습니다.!');
            changeContentCus(path, name);
        },

        error: function(data){
            alert('삭제에 실패 했습니다.!');
            return;
        }
    })

    // $('#mainContent').children().remove();
    // $('#mainContent').load("/" + path + "/" + name);

}

function changeContentCusmodify(path, name) {

    const $userUserId = $('#userUserId');
    const $faqTtile = $('#faqTitle');
    const $faqContent = $('#faqContent');
    const $faqNo = $('#faqNo');

    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/" + name + "?faqTitle=" + $faqTtile.val() + "&faqContent=" + $faqContent.val() + "&faqNo=" + $faqNo.val());
}

function changeContentN(name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/notice/" + name);
}

function changeContentM(name){
    console.log(name)
    alert(name);
    $('#mainContent').children().remove();
    $('#mainContent').load("/mrmain/" + name);
}

function changeContentCusSearch(path, name){

    const $searchtype = $('#search-type');
    const $searchkeword = $('#faqkeyword');

    $('#mainContent').children().remove();
    $('#mainContent').load("/" + path + "/"+name+"?faqtype=" + $searchtype.val() + "&faqkeyword=" + $searchkeword.val());

}