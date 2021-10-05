DROP DATABASE IF EXISTS blog;

CREATE DATABASE IF NOT EXISTS blog;

USE blog;

CREATE TABLE IF NOT EXISTS members (
id_user INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
first_name VARCHAR(50),
last_name VARCHAR(50),
e_mail VARCHAR(100),
user_name VARCHAR(50),
passw VARCHAR(50),
registry TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
access ENUM ('guest', 'user', 'moderator', 'admin'),
PRIMARY KEY(id_user)
);

CREATE TABLE IF NOT EXISTS blog (
id_blog INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
blog_serial INT,
blog_text VARCHAR(500),
blog_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(id_blog)
);

CREATE TABLE IF NOT EXISTS comment (
id_comment INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
comment_text VARCHAR(500),
comment_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
PRIMARY KEY(id_comment)
);

CREATE TABLE IF NOT EXISTS blog_sablon (
id_bs INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
sablon_colour VARCHAR(30),
sablon_alphabet VARCHAR (30),
style VARCHAR(30),
PRIMARY KEY(id_bs)
);

CREATE TABLE IF NOT EXISTS members2blog (
	id_mb INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    id_us INT UNSIGNED NOT NULL,
    id_blogs INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_mb),
    FOREIGN KEY (id_us) REFERENCES members(id_user), 
    FOREIGN KEY (id_blogs) REFERENCES blog(id_blog)
);

CREATE TABLE IF NOT EXISTS comment2blog (
	id_cb INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    id_com INT UNSIGNED NOT NULL,
    id_blogs INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_cb),
    FOREIGN KEY (id_com) REFERENCES comment(id_comment), 
    FOREIGN KEY (id_blogs) REFERENCES blog(id_blog)
);

CREATE TABLE IF NOT EXISTS blog2blog_sablon (
	id_bb INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
    id_sablon INT UNSIGNED NOT NULL,
    id_blogs INT UNSIGNED NOT NULL,
    PRIMARY KEY (id_bb),
    FOREIGN KEY (id_sablon) REFERENCES blog_sablon(id_bs),
    FOREIGN KEY (id_blogs) REFERENCES blog(id_blog)
);

INSERT INTO members (first_name, last_name, e_mail, user_name, passw, registry, access) VALUES
('Sári', 'Katica', 'baboca@baboca.com', 'baboca','baboca01', '2021-03-04T09:46:41', 'user'),
('Lujza', 'Pillango', 'pihe.pihe@pihe.com', 'pihe','pihe0101', '2021-03-05T09:50:41', 'admin'),
('Dezso', 'Csiga', 'bogyo@bogyo.com', 'bogyo','bogyo01', '2021-03-06T06:46:31', 'guest'),
('Baltazár', 'Méhecske', 'baltazar@baltazar.com', 'baltazár','baltazar7101', '2021-03-07T08:11:41', 'moderator');

INSERT INTO blog (blog_serial, blog_text, blog_time) VALUES
(1, 'Hello! It is the first text!', '2021-03-04T09:55:41'),
(1, 'Hello! It is the second text!', '2021-03-05T09:11:41'),
(2, 'Hello! It is the third text!', '2021-03-07T09:55:41');

INSERT INTO comment (comment_text, comment_time) VALUES
('Hello! It is the first comment!', '2021-03-04T19:55:41'),
('Hello! It is the second comment!', '2021-03-06T07:11:41'),
('Hello! It is the third comment!', '2021-03-07T09:55:41');

INSERT INTO blog_sablon (sablon_colour, sablon_alphabet, style) VALUES
('pink', 'arial', 'bold'),
('green', 'latin', 'normal'),
('grey', 'kaspersky', 'underlined');


