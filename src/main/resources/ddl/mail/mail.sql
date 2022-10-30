insert into mail(mail_no, mail_content, mail_title, mail_receiver, mail_sender, mail_flag, mail_regdate, user_user_id, allFiles_file_no)
values (1, '메일 내용', '메일 제목', '수신자1', '수신자2', 0, sysdate(), 'kdhz1001', null);

insert into user(user_id, user_pw, user_name, user_no, user_addr, user_hp, user_dep, user_rank, user_flag, user_regdate)
values ('kdhz1001', '1234', '김두환', '1', '주소1',  '010-0000-1111', '부서', '직급', '일반', sysdate());

select *
from mail;