CREATE TABLE IF NOT EXISTS `project_db`.`notice` (
    `notice_no` INT AUTO_INCREMENT NOT NULL,
    `notice_title` VARCHAR(45) NULL,
    `notice_content` VARCHAR(500) NULL,
    `notice_viewcount` INT NULL DEFAULT 0,
    `notice_regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
--     `user_user_id` VARCHAR(20) NOT NULL,
    `user_user_id` VARCHAR(20) NULL,
    `allFiles_file_no` INT,
    PRIMARY KEY (`notice_no`),
    INDEX `fk_notice_user1_idx` (`user_user_id` ASC) VISIBLE,
    INDEX `fk_notice_allFiles1_idx` (`allFiles_file_no` ASC) VISIBLE,
    CONSTRAINT `fk_notice_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `project_db`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    CONSTRAINT `fk_notice_allFiles1`
    FOREIGN KEY (`allFiles_file_no`)
    REFERENCES `project_db`.`allFiles` (`file_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;