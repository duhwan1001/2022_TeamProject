
function pwfindbtn() {
                    
    const $userId = $('#userId');
    const $userName = $('#userName');

    if ($userId.val() === '' || $userId.val() === null) {
        alert('아이디를 입력 하세요.');
        return;
    }

    if ($userName.val() === '' || $userName.val() === null) {
        alert('이름을 입력 하세요.');
        return;
    }

    $.ajax({
        type: "post",
        url: "/passwordfind/passfind",
        data: ({
            userId: $userId.val(),
            userName: $userName.val(),
        }),
        success: function (getdata) {
            console.log('받은 데이터:', getdata);
            if (getdata === 'success') {
                alert('임시비밀번호6자리를 생성합니다.');
                location.href='/passwordfind/pwfindpath';
            }
        },
        error: function(xhr, status){
            alert('잘못된 유저 정보입니다. 다시 확인해주세요.');
        }
    });
}