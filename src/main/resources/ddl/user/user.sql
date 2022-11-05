alter table user add file_no int(100);

alter table user add file_path varchar(500);

alter table user
    add constraint user_allfiles_null_fk
        foreign key (file_no) references allfiles (file_no);

