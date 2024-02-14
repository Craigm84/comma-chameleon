DROP TABLE `booking` CASCADE;
DROP TABLE `property`;
DROP TABLE `buyer` ;
DROP TABLE `seller`;

CREATE TABLE `buyer`(
>>>>>>> 60d75a91f8ecfab47a52c5cff8f8091c53294ba0
`id` INT PRIMARY KEY AUTO_INCREMENT,
`first_name` VARCHAR,
`last_name` VARCHAR
);

CREATE TABLE `seller`(
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
`buyer_id` INT, FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`),
`date` DATE,
`property_id` INT, FOREIGN KEY (`property_id`) REFERENCES `property` (`id`),
`time` TIME
);

