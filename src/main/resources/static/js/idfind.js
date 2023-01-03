
$(document).ready(function() {

    const $idfindbtn = $('#idfindbtn');

    $idfindbtn.on('click', function(e){
        
        const $userName = $('#userName');
        const $userDep = $('#userDep');

        console.log('아이디 확인:'+$userName.val());

        if($userName.val() === '' || $userName.val() === null){
            alert('이름을 입력하세요.');
            return;
        }

        if($userDep.val() === '' || $userDep.val() === null){
            alert('부서를 입력하세요.');
            return;
        }
        
        $.ajax({
            type: "post",
            url:"/idfind/checkfind",
            data:({
                userName:$userName.val(),
                userDep:$userDep.val()
            }),
            success: function(data){
                
                if(data === 'Y'){
                    alert('회원조회성공!!');
                    document.userfrm.submit();
                }else if(data ==='N'){
                    alert('해당유저가 존재하지않습니다. 다시 확인해주세요.');
                    
                }
            },
            error: function(xhr, status){
                alert('조회실패');
            }



        })

    })


});