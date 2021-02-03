DROP database if exists Papers;
CREATE database Papers;
USE Papers;

CREATE TABLE Contents (
	id INT NOT NULL AUTO_INCREMENT,
    IndexVal bigint(30) NOT NULL,
    Author varchar(50) NOT NULL,
    PaperTitle varChar(100) NOT NULL,
    Abstract varchar(500) NOT NULL,
    Contents varchar(1000) NOT NULL,
    Datum date NOT NULL,
    primary key (id)
);

ALTER TABLE Contents
MODIFY COLUMN IndexVal DOUBLE NOT NULL;

INSERT INTO Contents VALUES (
	default, '13.5', 'Me Author', 'Me Important Paper', 'This is a really really really
    really really really really really really really really really really really really
    really really really really really really really really really really really really
    really really really really really really really really really boring abstract', 'This is a really really really
    really really really really really really really really really really really really really really really really 
    really really really really really really really really really really really really really really really
    really really really really really really really really really really really really really really really
    really really really really really really really really really really really really really really really
    boring contents section of a paper.', '2020-10-22'
);