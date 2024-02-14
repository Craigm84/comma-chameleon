DROP TABLE `booking` CASCADE;
DROP TABLE `property` CASCADE;
DROP TABLE `buyer` CASCADE;
DROP TABLE `seller` CASCADE;

CREATE TABLE `seller (
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR,
`last_name` VARCHAR
);

CREATE TABLE `buyer`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR,
`last_name` VARCHAR
);

CREATE TABLE `property`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`bathroom` INT,
`bedroom` INT,
`price` FLOAT,
`address` VARCHAR,
`city` VARCHAR,
`garden` VARCHAR,
`image` VARCHAR,
`status` VARCHAR,
`type` VARCHAR
);

CREATE TABLE `booking`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`buyer_id` INT FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`),
`date` DATE,
`property_id` FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
`time` TIME
);