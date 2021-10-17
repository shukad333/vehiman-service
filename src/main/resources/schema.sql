CREATE TABLE IF NOT EXISTS `owner` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `vehicles` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `owner_id` int(11) unsigned DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `brand` varchar(50) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `owner_fk` (`owner_id`),
  CONSTRAINT `owner_fk` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `service_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `service_type` varchar(50) NOT NULL DEFAULT '',
  `is_done` tinyint(1) NOT NULL,
  `service_date` datetime NOT NULL,
  `vehicle_id` int(11) unsigned NOT NULL,
  `current_odo` bigint(20) DEFAULT NULL,
  `next_service_odo` bigint(20) DEFAULT NULL,
  `next_service_date` datetime DEFAULT NULL,
  `owner_id` int(11) unsigned NOT NULL,
  `service_center` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `vehicle_id` (`vehicle_id`),
  KEY `owner_id` (`owner_id`),
  CONSTRAINT `owner_id` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`id`),
  CONSTRAINT `vehicle_id` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `service_types`;
CREATE TABLE `service_types` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
