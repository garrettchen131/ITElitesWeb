DROP DATABASE IF EXISTS `itelites`;
CREATE DATABASE `itelites` CHARACTER SET UTF8;
USE `itelites`;
CREATE TABLE `tb_first_head`
(
    `first_head_id` INT AUTO_INCREMENT  ,
    `first_head_name` VARCHAR(20) NOT NULL UNIQUE ,
    `first_head_url` varchar (30) DEFAULT NULL,
    `create_time` DATETIME DEFAULT NULL,
    `valid` SMALLINT DEFAULT 1 ,
    `priority` INT NOT NULL UNIQUE ,
    PRIMARY KEY(`first_head_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_second_head`
(
    `second_head_id` INT AUTO_INCREMENT  ,
    `second_head_name` VARCHAR(20) NOT NULL UNIQUE ,
    `second_head_url` varchar (30) DEFAULT NULL,
    `first_head_id` INT ,
    `create_time` DATETIME DEFAULT NULL,
    `valid` SMALLINT DEFAULT 1 ,
    `priority` INT NOT NULL UNIQUE ,
    PRIMARY KEY(`second_head_id`) ,
    CONSTRAINT `pk_shead_fhead` FOREIGN KEY (`first_head_id`) REFERENCES `tb_first_head`(`first_head_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_team`(
    `team_id` INT AUTO_INCREMENT,
    `team_name` VARCHAR(20) NOT NULL UNIQUE,
    `create_time` DATETIME DEFAULT NULL,
    `last_edit_time` DATETIME DEFAULT NULL,
    `team_desc` VARCHAR(1024) DEFAULT NULL,
    PRIMARY KEY(`team_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_group`(
    `group_id` INT AUTO_INCREMENT,
    `group_name` VARCHAR(20) NOT NULL UNIQUE,
    `create_time` DATETIME DEFAULT NULL,
    `last_edit_time` DATETIME DEFAULT NULL,
    `group_img` VARCHAR(1024) DEFAULT NULL,
    `group_desc` VARCHAR(1024) DEFAULT NULL,
    PRIMARY KEY(`group_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_stu_register`(
    `student_id` INT AUTO_INCREMENT,
    `student_num` BIGINT NOT NULL UNIQUE ,
    `student_name` varchar(16) NOT NULL,
    `phone` VARCHAR (128) DEFAULT NULL,
    `qq` varchar (16) DEFAULT NULL ,
    `team_pass` INT DEFAULT NULL ,
    `team_one` INT NOT NULL,
    `team_two` INT NOT NULL,
    `validate` INT NOT NULL DEFAULT 0 COMMENT '1表示当前可以选择小组，0表示大组考核中，-1表示不通过',
    `group_pass` INT DEFAULT NULL ,
    `group_one` INT DEFAULT NULL ,
    `group_two` INT DEFAULT NULL ,
    PRIMARY KEY(`student_id`),
    CONSTRAINT `pk_stu_teamone` FOREIGN KEY(`team_one`) REFERENCES `tb_team`(`team_id`),
    CONSTRAINT `pk_stu_teamtwo` FOREIGN KEY(`team_two`) REFERENCES `tb_team`(`team_id`),
    CONSTRAINT `pk_stu_teampass` FOREIGN KEY(`team_pass`) REFERENCES `tb_team`(`team_id`),
    CONSTRAINT `pk_stu_groupone` FOREIGN KEY(`group_one`) REFERENCES `tb_group`(`group_id`),
    CONSTRAINT `pk_stu_grouptwo` FOREIGN KEY(`group_two`) REFERENCES `tb_group`(`group_id`),
    CONSTRAINT `pk_stu_group_pass` FOREIGN KEY(`group_pass`) REFERENCES `tb_group`(`group_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_exhibition`(
    `exhibition_id` INT AUTO_INCREMENT,
    `exhibition_name` VARCHAR(50) NOT NULL,
    `create_time` DATETIME DEFAULT NULL,
    `last_edit_time` DATETIME DEFAULT NULL,
    `exhibition_img` VARCHAR(1024) DEFAULT NULL,
    `exhibition_desc` VARCHAR(2048) DEFAULT NULL,
    PRIMARY KEY(`exhibition_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
use itelites;
INSERT INTO tb_first_head(`first_head_name`,`priority`) VALUES('首页',999);
INSERT INTO tb_first_head(`first_head_name`,`priority`) VALUES('概况',998);
INSERT INTO tb_first_head(`first_head_name`,`priority`) VALUES('招新',997);
INSERT INTO tb_first_head(`first_head_name`,`priority`) VALUES('培训',996);
INSERT INTO tb_first_head(`first_head_name`,`priority`) VALUES('公告',995);
INSERT INTO tb_first_head(`first_head_name`,`priority`) VALUES('疑难解答',994);
COMMIT;