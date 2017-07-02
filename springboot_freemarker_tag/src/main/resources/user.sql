/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.22 : Database - liutao
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`liutao` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `liutao`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `is_delete` tinyint(4) NOT NULL DEFAULT '0',
  `type` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `user` */

insert  into `user`(`name`,`age`,`password`,`id`,`email`,`is_delete`,`type`) values ('张飞',26,'zf123',1,'zhangfei@126.com',0,'中'),('关羽',45,'guanyu123',2,'guanyu@126.com',0,'老'),('赵云',45,'gua23nyu123',3,'guansayu@126.com',0,'青'),('刘备',15,'guaewnyu123',4,'guansayu@126.com',0,'少'),('刘禅',35,'guawnyu123',5,'guanyu@126.com',0,'幼'),('诸葛亮',55,'gewquanyu123',6,'guaAnyu@126.com',0,'中'),('孙尚香',41,'guanyu123',7,'guanyu@126.com',0,'中'),('关平',42,'guaewqnyu123',8,'guanyASu@126.com',0,'中'),('星彩',43,'guaewqnyu123',9,'guXCanyu@126.com',0,'中'),('马超',46,'guanyu123',10,'guCXZanyu@126.com',0,'中'),('庞德',25,'guanwyu123',11,'guaASnyu@126.com',0,'中'),('黄忠',55,'guanyu123',12,'guZXCanyu@126.com',0,'中'),('刘思',55,'guanyu123',13,'guaaSnyu@126.com',0,'中'),('胡汉三',45,'gueqwanyu123',14,'gAsuanyu@126.com',0,'中'),('宋江',45,'guanyu123',15,'guazcxznyu@126.com',0,'中'),('刘青云',45,'guewqanyu123',16,'gvbuanyu@126.com',0,'青'),('马云',45,'guanyu123',17,'guacvxnyu@126.com',0,'青'),('官运',45,'guanyqweu123',18,'guaXnyu@126.com',0,'青'),('长留',45,'guanyu123',19,'guazXnyu@126.com',0,'青'),('云我',45,'guanyu123',20,'guazxnyu@126.com',0,'青'),('犯得上',45,'guawqenyu123',21,'gvcuanyu@126.com',0,'青'),('士大夫',45,'guanyu123',22,'gvczuanyu@126.com',0,'青'),('打算',45,'guanywqeu123',23,'guadanyu@126.com',0,'老'),('倒萨',45,'guanyu123',24,'guaasdfnyu@126.com',0,'老'),('打算',45,'guanyqweu123',25,'gasduanyu@126.com',0,'老'),('萨达',45,'guanyqwu123',26,'guasdanyu@126.com',0,'老'),('但是达',45,'guaeqwnyu123',27,'12guanyu@126.com',0,'老'),('撒打发',45,'guaneqwyu123',28,'gu21anyu@126.com',0,'老'),('萨丢斯',45,'guanyu123',29,'gu213anyu@126.com',0,'老');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
