# Database schema for Knob
# Database type: MySQL 5.x

# Note: for MySQL, please use DELETE TABLE IF EXISTS and CREATE TABLE IF NOT EXISTS whenever possible!

# Run the following queries as root
#DROP DATABASE knob;
#CREATE DATABASE knob CHARACTER SET = utf8 COLLATE = utf8_general_ci;
#GRANT ALL PRIVILEGES ON knob.* TO 'knob'@'localhost' IDENTIFIED BY 'knob';

# Drop existing tables
DROP TABLE IF EXISTS knob_app_config;

# Create tables
CREATE TABLE IF NOT EXISTS knob_app_config (
	config_domain					VARCHAR(32),
	config_key						VARCHAR(64),
	config_long						BIGINT,
	config_double					DOUBLE,
	config_string					MEDIUMTEXT,
	config_boolean					CHAR(1),
	config_date						TIMESTAMP,
	config_binary					MEDIUMBLOB,
	INDEX (config_key),
	PRIMARY KEY (config_domain, config_key)
) Engine = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci;
INSERT INTO knob_app_config (config_domain, config_key, config_string) VALUES ('SITE', 'NAME', 'Knob');
INSERT INTO knob_app_config (config_domain, config_key, config_string) VALUES ('SITE', 'TITLE', 'Knob');
INSERT INTO knob_app_config (config_domain, config_key, config_string) VALUES ('SITE', 'KEYWORDS', 'Knob, CMS, Content Management System');
INSERT INTO knob_app_config (config_domain, config_key, config_string) VALUES ('SITE', 'DESCRIPTION', 'Knob - Content Management System');
