/*
SQLyog Ultimate v8.32 
MySQL - 8.0.13 : Database - hw_task
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hw_task` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hw_task`;

/*Table structure for table `tb_fit` */

DROP TABLE IF EXISTS `tb_fit`;

CREATE TABLE `tb_fit` (
  `fit_id` int(11) NOT NULL AUTO_INCREMENT,
  `fit_no` varchar(20) DEFAULT NULL COMMENT '编号',
  `fit_name` varchar(20) DEFAULT NULL COMMENT '名称',
  `fit_qty` int(11) DEFAULT NULL COMMENT '数量',
  `fit_city` varchar(20) DEFAULT NULL COMMENT '产地',
  PRIMARY KEY (`fit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_fit` */

insert  into `tb_fit`(`fit_id`,`fit_no`,`fit_name`,`fit_qty`,`fit_city`) values (1,'f001','电池',10,'上海'),(2,'f002','外屏',20,'杭州'),(3,'f003','内屏',29,'浙江'),(4,'f004','主板',40,'广州'),(5,'f005','摄像头',50,'武汉');

/*Table structure for table `tb_task` */

DROP TABLE IF EXISTS `tb_task`;

CREATE TABLE `tb_task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `task_no` varchar(20) DEFAULT NULL,
  `task_item` varchar(20) DEFAULT NULL,
  `cus_name` varchar(20) DEFAULT NULL,
  `cus_phone` varchar(20) DEFAULT NULL,
  `task_status` int(11) DEFAULT NULL,
  PRIMARY KEY (`task_id`),
  UNIQUE KEY `task_no` (`task_no`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `tb_task` */

insert  into `tb_task`(`task_id`,`task_no`,`task_item`,`cus_name`,`cus_phone`,`task_status`) values (1,'T001','换手机','张三','1232156484',2),(2,'T002','换电池','李四','1654484215',1),(3,'T-1804962','内屏','王五','13512345678',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
