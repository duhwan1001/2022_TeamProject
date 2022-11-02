
$(document).ready(function(){

    const $pwbtn = $('#pwfindbtn');
    const $userId =$('#userId');
    const $userDep =$('#userDep');

    $pwbtn.on('click', e => {
        
        if($userId.val()==='' || $userId.val() === null){
            alert('아이디를 입력 하세요.');
            return;
        }

        if($userDep.val() === '' || $userDep.val() ===null){
            alert('부서를 입력 하세요.');
            return;
        }
        document.pwfrm.submit();

    });
});