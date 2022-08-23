DROP DATABASE IF EXISTS ticket;

CREATE DATABASE ticket;

USE ticket;

CREATE TABLE admins(
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL,
	`password` VARCHAR(255) NOT NULL
);

CREATE TABLE `events` (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	location VARCHAR(50) NOT NULL,
	started_at DATETIME NOT NULL,
	finished_at DATETIME NOT NULL
);

CREATE TABLE stages (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	event_id INT UNSIGNED NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	`number` TINYINT NOT NULL,
	location VARCHAR(50) NOT NULL,
	started_at DATETIME NOT NULL,
	finished_at DATETIME NOT NULL
);

ALTER TABLE stages ADD FOREIGN KEY (event_id) REFERENCES `events` (id);

CREATE TABLE performances (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL
);

CREATE TABLE event_stage_performances (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	event_id INT UNSIGNED NOT NULL,
	stage_id INT UNSIGNED NOT NULL,
	performance_id INT UNSIGNED NOT NULL
);

ALTER TABLE event_stage_performances ADD FOREIGN KEY (event_id) REFERENCES `events` (id);
ALTER TABLE event_stage_performances ADD FOREIGN KEY (stage_id) REFERENCES `stages` (id);
ALTER TABLE event_stage_performances ADD FOREIGN KEY (performance_id) REFERENCES `performances` (id);

CREATE TABLE ticket_categories (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	event_id INT UNSIGNED NOT NULL,
	stage_id INT UNSIGNED NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	category ENUM('full-day', 'daily') NOT NULL,
	`type` ENUM('regular', 'vip') NOT NULL,
	price INT NOT NULL,
	quota SMALLINT NOT NULL
);

ALTER TABLE ticket_categories ADD FOREIGN KEY (event_id) REFERENCES `events` (id);
ALTER TABLE ticket_categories ADD FOREIGN KEY (stage_id) REFERENCES `stages` (id);

CREATE TABLE event_sponsors (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	event_id INT UNSIGNED,
	`name` VARCHAR(50) NOT NULL,
	tier TINYINT(1) NOT NULL
);

ALTER TABLE event_sponsors ADD FOREIGN KEY (event_id) REFERENCES `events` (id);

CREATE TABLE ticket_registrations (
	id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
	event_id INT UNSIGNED NOT NULL,
	stage_id INT UNSIGNED NOT NULL,
	ticket_category_id INT UNSIGNED NOT NULL,
	`name` VARCHAR(50) NOT NULL,
	address VARCHAR(100) NOT NULL,
	email VARCHAR(50) NOT NULL,
	ticket_total TINYINT NOT NULL,
	price_total INT NOT NULL,
	ordered_at DATETIME NOT NULL
);

ALTER TABLE ticket_registrations ADD FOREIGN KEY (event_id) REFERENCES `events` (id);
ALTER TABLE ticket_registrations ADD FOREIGN KEY (stage_id) REFERENCES `stages` (id);