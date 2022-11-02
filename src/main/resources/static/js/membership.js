//회원가입 폼 유효성검사
            $(document).ready(function () {

                const getusername = RegExp(/^[가-힣]+$/);
                const getuserid = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z\-]+\.[A-Za-z0-9\-]+/);
                const getphone = /\d{2,3}-\d{3,4}-\d{4}/;
                const checkbtn = [false, false, false, false, false, false, false];
                //입력값 검증
                const $userId = $('#userId');
                const $btn = $('.btn-user');
                const $userPw = $('#userPw');
                const $userPwcheck = $('#userpwconcheck');
                
                //console.log('버튼:', $btn);
                //console.log('아이디 값:', $userid.value);

                $btn.on('click', e => {

                    //   console.log($userId.val());
                    if ($userId.val() === '' || $userId.val() === null) {
                        alert('아이디는 필수사항입니다.');
                        checkbtn[0] = false;
                        return;

                    }

                    if (!getuserid.test($userId.val())) {
                        alert('10자리부터 20자리까지 이메일형식에 맞춰 입력해주세요.');
                        
                        return;

                    }

                    //console.log('순서확인!');
                    fetch('/membership/check?type=id&value=' + $userId.val()).then(res => res.text()).then(flag => {
                        // console.log('값확인:', flag);
                        if (flag === 'true') {
                            alert('중복된 아이디입니다.');
                            return;
                        }

                        checkbtn[0] = true;
                        

                        if ($userPw.val() === '' || $userPw.val() === null) {
                            alert('비밀번호를 입력하세요.');
                            return;
                        }

                        fetch('/membership/check?type=pw&value=' + $userPw.val()).then(res => res.text()).then(flag => {
                            //alert('순서1');
                            if (flag === 'true') {
                                alert('중복된 비밀번호입니다.');
                                return;
                            }else{
                                checkbtn[1] = true;
                            }

                            if($userPwcheck.val() ===''||$userPwcheck.val()===null ){
                                alert('비밀번호확인란을 확인해주세요.');
                                return;
                            }
                            
                            if ($userPwcheck.val() !== $userPw.val()) {
                                alert('비밀번호가 일치하지 않습니다.');
                                return;
                            }

                            if ($('#userName').val() === "" || $('#userName').val() === null) {
                                alert('이름을 입력하세요.');
                                return;
                            }

                            if (!getusername.test($('#userName').val())) {
                                alert('이름형식에 맞게 입력하세요.');
                                return;

                            }
                            checkbtn[2] = true;

                            if ($('#userDep').val() === "" || $('#userName').val() === null) {
                                alert('부서를 입력 하세요.');
                                return;
                            }
                            checkbtn[3] = true;

                            if ($('#userRank').val() === "" || $('#userRank').val() === null) {
                                alert('직급을 입력 하세요.');
                                return;
                            }
                            checkbtn[4] = true;

                            if ($('#userHp').val() === "" || $('#userHp').val() === null) {
                                alert('핸드폰번호를 입력 하세요.');
                                return;
                            }

                            if (!getphone.test($('#userHp').val())) {
                                alert('핸드폰번호 형식에 맞게 작성하세요.');
                                return;
                                
                            }
                            checkbtn[5] = true;

                            if ($('#userAddr').val() === "" || $('#userAddr').val() === null) {
                                alert('주소를 입력하세요.');
                                return;
                            }

                            if ($('#userAddr2').val() === '' || $('#userAddr2').val() === null) {
                                alert('상세주소를 입력하세요.');
                                return;
                            }
                            checkbtn[6] = true;

                            
                            if(!checkbtn.includes(false)){
                         //       alert('유효성성공!');
                                document.userfrm.submit();
                            }
                            
                            

                        });


                    });
                   // console.log('값확인함:', checkbtn[0]);

                    // for(let i=0; i<checkbtn.length; i++){
                    //     if(checkbtn[i])
                    // }
                });

            });