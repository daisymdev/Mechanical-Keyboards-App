-- table for Case, PCB, Switches, Mounting Plate, Stabilizers, Keycaps
CREATE DATABASE IF NOT EXISTS mechanical_keyboards;
USE mechanical_keyboards;

CREATE TABLE IF NOT EXISTS cases (
  case_id_pk INT AUTO_INCREMENT PRIMARY KEY,
  material VARCHAR(50) NOT NULL,
  size_percentage VARCHAR(4) NOT NULL
);

INSERT INTO cases (material, size_percentage) VALUES ('wood', '60%');

CREATE TABLE IF NOT EXISTS pcb (
  pcb_id_pk INT AUTO_INCREMENT PRIMARY KEY,
  model VARCHAR(100) NOT NULL,
  rgb_lighting VARCHAR(3) NOT NULL,
  solder_needed VARCHAR(3) NOT NULL,
  case_id_fk INT,
  FOREIGN KEY (case_id_fk) REFERENCES cases (case_id_pk) ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS switches (
  switches_id_pk INT AUTO_INCREMENT PRIMARY KEY,
  manufacturer VARCHAR(100) NOT NULL,
  terms VARCHAR(50) NOT NULL,
  name VARCHAR(100) NOT NULL,
  case_id_fk INT,
  FOREIGN KEY (case_id_fk) REFERENCES cases (case_id_pk) ON UPDATE RESTRICT ON DELETE CASCADE
);

INSERT INTO switches(manufacturer, terms, name, case_id_fk) VALUES ('Cherry', 'Tactile', 'Cherry MX Brown', 9);
CREATE TABLE IF NOT EXISTS mounting_plate (
  mounting_plate_id_pk INT AUTO_INCREMENT PRIMARY KEY,
  style VARCHAR(100) NOT NULL,
  material VARCHAR(50) NOT NULL,
  finish VARCHAR(100) NOT NULL,
  manufacturer VARCHAR(100) NOT NULL,
  case_id_fk INT,
  FOREIGN KEY (case_id_fk) REFERENCES cases (case_id_pk) ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS stabilizers (
  stabilizers_id_pk INT AUTO_INCREMENT PRIMARY KEY,
  brand VARCHAR(100) NOT NULL,
  case_id_fk INT,
  FOREIGN KEY (case_id_fk) REFERENCES cases (case_id_pk) ON UPDATE RESTRICT ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS keycaps (
  keycaps_id_pk INT AUTO_INCREMENT PRIMARY KEY,
  material VARCHAR(100) NOT NULL,
  profile VARCHAR(100) NOT NULL,
  layout VARCHAR(100) NOT NULL,
  brand VARCHAR(100) NOT NULL,
  case_id_fk INT,
  FOREIGN KEY (case_id_fk) REFERENCES cases (case_id_pk) ON UPDATE RESTRICT ON DELETE CASCADE
);
