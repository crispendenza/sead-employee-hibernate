CREATE DATABASE  IF NOT EXISTS sead_employee;
USE sead_employee;

--
-- Table structure for table employee
-- @crispendenza
--

DROP TABLE IF EXISTS employee;

CREATE TABLE employee (
  id int(11) NOT NULL AUTO_INCREMENT,
  first_name varchar(45) DEFAULT NULL,
  last_name varchar(45) DEFAULT NULL,
  company varchar(45) DEFAULT NULL,
  admission_date datetime DEFAULT NULL,
  dismissal_date datetime DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

