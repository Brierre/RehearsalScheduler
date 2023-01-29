DROP TABLE IF EXISTS conflict_rehearsal;
DROP TABLE IF EXISTS rehearsal;
DROP TABLE IF EXISTS conflict;
DROP TABLE IF EXISTS scene_part;
DROP TABLE IF EXISTS scene;
DROP TABLE IF EXISTS part;
DROP TABLE IF EXISTS castmember;

CREATE TABLE castmember (
castmember_id INT AUTO_INCREMENT NOT NULL,
first_name VARCHAR(128) NOT NULL,
last_name VARCHAR(128) NOT NULL,
phone_number VARCHAR(128) NOT NULL DEFAULT '555-555-5555',
tap_performer BOOLEAN DEFAULT 0,
costume_complete BOOLEAN DEFAULT 0,
new_first_name VARCHAR(128),
new_last_name VARCHAR(128),
PRIMARY KEY (castmember_id)
);

CREATE TABLE part (
part_number INT NOT NULL,
musical_name VARCHAR(128) NOT NULL,
castmember_id INT NOT NULL DEFAULT 0,
character_name VARCHAR(128) NOT NULL,
character_group VARCHAR(128),
UNIQUE KEY (part_number, musical_name)
);

CREATE TABLE scene (
musical_name VARCHAR(128) NOT NULL,
scene_number INT NOT NULL,
scene_name VARCHAR(128),
song_title VARCHAR(128),
song_id INT,
act VARCHAR(128) NOT NULL,
location VARCHAR(128),
script_page_begin INT,
script_page_end INT,
UNIQUE KEY (scene_number, musical_name)
);

CREATE TABLE scene_part (
scene_part_pk INT AUTO_INCREMENT NOT NULL,
scene_number INT,
-- castmember_id INT,
part_number INT,
musical_name VARCHAR(128),
PRIMARY KEY (scene_part_pk),
FOREIGN KEY (scene_number, musical_name) REFERENCES scene (scene_number, musical_name) ON DELETE CASCADE,
FOREIGN KEY (part_number, musical_name) REFERENCES part (part_number, musical_name) ON DELETE CASCADE
);

-- tables below this point are only implemented in database, no methods created for final project
CREATE TABLE conflict (
conflict_id INT AUTO_INCREMENT NOT NULL,
castmember_id INT NOT NULL,
day_of_week VARCHAR(128),
conflict_date DATE,
conflict_time TIME,
conflict_name VARCHAR(128) NOT NULL,
conflict_approved BOOLEAN NOT NULL DEFAULT 0,
PRIMARY KEY (conflict_id),
FOREIGN KEY (castmember_id) REFERENCES castmember (castmember_id) ON DELETE CASCADE
);

CREATE TABLE rehearsal (
rehearsal_id INT AUTO_INCREMENT NOT NULL,
scene_number INT NOT NULL,
day_of_week VARCHAR(128) NOT NULL,
rehearsal_date DATE,
rehearsal_start_time TIME,
rehearsal_end_time TIME,
PRIMARY KEY (rehearsal_id)
-- FOREIGN KEY (scene_number) REFERENCES scene (scene_number) ON DELETE CASCADE
);

CREATE TABLE conflict_rehearsal (
conflict_id INT NOT NULL,
rehearsal_id INT NOT NULL,
FOREIGN KEY (conflict_id) REFERENCES conflict (conflict_id) ON DELETE CASCADE,
FOREIGN KEY (rehearsal_id) REFERENCES rehearsal (rehearsal_id) ON DELETE CASCADE,
UNIQUE KEY (conflict_id, rehearsal_id)
);
