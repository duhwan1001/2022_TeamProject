
$(document).ready(function() {

    const $idfindbtn = $('#idfindbtn');
    const $userName = $('#userName');
    const $userDep = $('#userDep');

    $idfindbtn.on('click', function(e){
        

        if($userName.val() === '' || $userName.val() === null){
            alert('이름을 입력하세요.');
            return;
        }

        if($userDep.val() === '' || $userDep.val() === null){
            alert('부서를 입력하세요.');
            return;
        }
        
        document.userfrm.submit();

    })


});