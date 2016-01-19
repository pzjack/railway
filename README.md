# railway
spring boot data jpa tiles thymeleaf

完全采用Spring boot实现
配置采用java Configure的方式，安全使用spring security，持久层使用spring data jpa，页面布局采用tiles，模板使用Thymeleaf。前端简单采用jquery和bootstrap

数据库采用mysql，表结构变化如下：

1. mysql 
		create database railway;
		create user  railway   IDENTIFIED by 'railway';
		grant ALL on  railway.* to railway;
		grant ALL on railway.* to railway@'%'
		flush  privileges;
	
2. table schema sql
CREATE  TABLE `railway`.`T_ORG` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(80) NULL ,
  `describer` VARCHAR(300) NULL ,
  `type` INT NULL ,
  `code` VARCHAR(22) NULL ,
  `parent_id` BIGINT NULL ,
  `createtime` DATETIME NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
COMMENT = '组织机构';

CREATE  TABLE `railway`.`T_USER` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(60) NULL ,
  `role` INT NULL ,
  `email` VARCHAR(60) NULL ,
  `phone` VARCHAR(20) NULL ,
  `baiduid` VARCHAR(40) NULL ,
  `account` VARCHAR(60) NULL ,
  `org_id` BIGINT NULL ,
  `createtime` DATETIME NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
COMMENT = '用户信息';

CREATE  TABLE `railway`.`T_ACCOUNT` (
  `ID` BIGINT NOT NULL AUTO_INCREMENT,
  `account` VARCHAR(60) NULL ,
  `salt` VARCHAR(60) NULL ,
  `password` VARCHAR(20) NULL ,
  `state` INT NULL ,
  `baiduid` VARCHAR(40) NULL ,
  `role` INT NULL ,
  `user_id` BIGINT NULL ,
  `createtime` DATETIME NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `ID_UNIQUE` (`ID` ASC) )
COMMENT = '账号信息';