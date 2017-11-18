BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS `user` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT,
	`userType`	BLOB,
	`identity`	TEXT,
	`email`	TEXT,
	`phone`	TEXT,
	`pass`	TEXT,
	`status`	INTEGER
);
CREATE TABLE IF NOT EXISTS `Category` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`name`	TEXT
);
CREATE TABLE IF NOT EXISTS `Adsense` (
	`id`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`userId`	INTEGER,
	`categoryId`	INTEGER,
	`created_at`	TEXT,
	`price`	REAL,
	`location`	TEXT,
	`details`	TEXT
);
COMMIT;
