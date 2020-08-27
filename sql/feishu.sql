/*
Navicat MySQL Data Transfer

Source Server         : like
Source Server Version : 50622
Source Host           : localhost:3306
Source Database       : feishu

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2020-08-25 16:30:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chatinfo`
-- ----------------------------
DROP TABLE IF EXISTS `chatinfo`;
CREATE TABLE `chatinfo` (
  `cno` int(11) NOT NULL,
  `u_id` varchar(32) DEFAULT NULL,
  `Csendid` varchar(32) DEFAULT NULL,
  `Creceiveid` varchar(32) DEFAULT NULL,
  `Context` varchar(255) DEFAULT NULL,
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间(发送时间)',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`cno`),
  KEY `FK_Relationship_4` (`u_id`),
  CONSTRAINT `FK_Relationship_4` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�����¼��';

-- ----------------------------
-- Records of chatinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `company`
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `companyid` varchar(32) NOT NULL COMMENT '公司id',
  `company` varchar(50) DEFAULT NULL COMMENT '公司名',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`companyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��˾';

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for `dynamic`
-- ----------------------------
DROP TABLE IF EXISTS `dynamic`;
CREATE TABLE `dynamic` (
  `Don` int(11) NOT NULL COMMENT '动态编号',
  `u_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `img` varchar(20) DEFAULT NULL COMMENT '动态图片',
  `video` varchar(20) DEFAULT NULL COMMENT '动态视频',
  `context` varchar(255) DEFAULT NULL COMMENT '动态类容',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Don`),
  KEY `FK_Relationship_6` (`u_id`),
  CONSTRAINT `FK_Relationship_6` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��̬';

-- ----------------------------
-- Records of dynamic
-- ----------------------------

-- ----------------------------
-- Table structure for `friends`
-- ----------------------------
DROP TABLE IF EXISTS `friends`;
CREATE TABLE `friends` (
  `Fno` int(11) NOT NULL COMMENT '编号',
  `u_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `Fid` varchar(32) DEFAULT NULL COMMENT '好友id',
  `Fremarks` varchar(10) DEFAULT NULL COMMENT '备注',
  `gid` varchar(32) DEFAULT NULL COMMENT '好友分组id',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Fno`),
  KEY `FK_uid` (`u_id`),
  KEY `fk_gid` (`gid`),
  CONSTRAINT `FK_uid` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `fk_gid` FOREIGN KEY (`gid`) REFERENCES `group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ϣ��';

-- ----------------------------
-- Records of friends
-- ----------------------------

-- ----------------------------
-- Table structure for `group`
-- ----------------------------
DROP TABLE IF EXISTS `group`;
CREATE TABLE `group` (
  `id` varchar(32) NOT NULL DEFAULT '0' COMMENT '分组编号',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户id',
  `name` varchar(50) DEFAULT NULL COMMENT '分组名字',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `fk_userid` (`userid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group
-- ----------------------------

-- ----------------------------
-- Table structure for `groupchatinfo`
-- ----------------------------
DROP TABLE IF EXISTS `groupchatinfo`;
CREATE TABLE `groupchatinfo` (
  `gcno` int(11) NOT NULL COMMENT '群聊记录编号',
  `gCreceiveid` varchar(32) DEFAULT NULL COMMENT '发送者id',
  `Context` varchar(255) DEFAULT NULL COMMENT '内容',
  `gon` varchar(32) DEFAULT NULL COMMENT '群编号',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间(发送时间)',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`gcno`),
  KEY `fk_ggon` (`gon`),
  CONSTRAINT `fk_ggon` FOREIGN KEY (`gon`) REFERENCES `grouptable` (`Gon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of groupchatinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `grouptable`
-- ----------------------------
DROP TABLE IF EXISTS `grouptable`;
CREATE TABLE `grouptable` (
  `Gon` varchar(32) NOT NULL COMMENT '群编号',
  `Gname` varchar(32) DEFAULT NULL COMMENT '群名称',
  `Gavater` varchar(50) DEFAULT NULL COMMENT '群头像',
  `master` varchar(32) DEFAULT NULL COMMENT '群主',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT NULL COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Gon`),
  KEY `fk_master` (`master`),
  CONSTRAINT `fk_master` FOREIGN KEY (`master`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ⱥ��Ϣ';

-- ----------------------------
-- Records of grouptable
-- ----------------------------

-- ----------------------------
-- Table structure for `login`
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `Lon` int(11) NOT NULL COMMENT '登录编号',
  `u_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `Lip` varchar(20) DEFAULT NULL COMMENT '登录ip',
  `Lport` varchar(10) DEFAULT NULL COMMENT '端口号',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间（登录时间）',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`Lon`),
  KEY `FK_Relationship_5` (`u_id`),
  CONSTRAINT `FK_Relationship_5` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��¼��Ϣ��';

-- ----------------------------
-- Records of login
-- ----------------------------

-- ----------------------------
-- Table structure for `t_friend_circle_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_friend_circle_comment`;
CREATE TABLE `t_friend_circle_comment` (
  `fcc_id` int(11) NOT NULL AUTO_INCREMENT,
  `fcc_uid` varchar(32) DEFAULT NULL COMMENT '用户id',
  `fcmid` int(11) DEFAULT NULL COMMENT '朋友圈信息id',
  `context` varchar(255) DEFAULT NULL COMMENT '内容',
  `like_count` int(11) DEFAULT NULL COMMENT '点赞数',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`fcc_id`),
  KEY `fk_fcc_uid` (`fcc_uid`),
  KEY `fk_fcm_id` (`fcmid`),
  CONSTRAINT `fk_fcc_uid` FOREIGN KEY (`fcc_uid`) REFERENCES `user` (`u_id`),
  CONSTRAINT `fk_fcm_id` FOREIGN KEY (`fcmid`) REFERENCES `t_friend_circle_message` (`FcmId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friend_circle_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_friend_circle_message`
-- ----------------------------
DROP TABLE IF EXISTS `t_friend_circle_message`;
CREATE TABLE `t_friend_circle_message` (
  `FcmId` int(11) NOT NULL AUTO_INCREMENT,
  `uid` varchar(32) DEFAULT NULL COMMENT '用户id',
  `context` varchar(255) DEFAULT NULL COMMENT '内容',
  `picture` varchar(100) DEFAULT NULL COMMENT '照片',
  `video` varchar(100) DEFAULT NULL COMMENT '视频',
  `deteled` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`FcmId`),
  KEY `fk_fcm_uid` (`uid`),
  CONSTRAINT `fk_fcm_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_friend_circle_message
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` varchar(32) NOT NULL COMMENT '用户id',
  `companyid` varchar(32) DEFAULT NULL COMMENT '公司',
  `u_name` varchar(12) DEFAULT NULL COMMENT '用户名',
  `u_pwd` varchar(16) DEFAULT NULL COMMENT '用户密码',
  `u_email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `u_phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `avatar` varchar(50) DEFAULT NULL COMMENT '头像',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '创建时间',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`u_id`),
  KEY `FK_Relationship_7` (`companyid`),
  CONSTRAINT `FK_Relationship_7` FOREIGN KEY (`companyid`) REFERENCES `company` (`companyid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���';

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for `user_group`
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `ugno` int(11) NOT NULL COMMENT '关系编号',
  `Gon` varchar(32) DEFAULT NULL COMMENT '群编号',
  `u_id` varchar(32) DEFAULT NULL COMMENT '用户id',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除',
  `version` int(1) DEFAULT '0' COMMENT '乐观锁',
  `gtm_create` datetime DEFAULT NULL COMMENT '入群时间（创建时间）',
  `gtm_modified` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ugno`),
  KEY `FK_Relationship_1` (`u_id`),
  KEY `fk_gon` (`Gon`),
  CONSTRAINT `FK_Relationship_1` FOREIGN KEY (`u_id`) REFERENCES `user` (`u_id`),
  CONSTRAINT `fk_gon` FOREIGN KEY (`Gon`) REFERENCES `grouptable` (`Gon`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���Ⱥ��ϵ';

-- ----------------------------
-- Records of user_group
-- ----------------------------
