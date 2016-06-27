
//CREATE SCHEMA infacademics;

CREATE TABLE book (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book` VARCHAR(200) NULL,
  `country` VARCHAR(80) NULL,
  `state` VARCHAR(20) NULL,
  `autor` VARCHAR(150) NULL,
  PRIMARY KEY (`id`));

INSERT INTO book VALUES (1,'A volta dos que não foram', 'Brasil', 'RS', 'Fulano de tal');
INSERT INTO book VALUES (2,'O regresso', 'Estados Unidos', 'NY', 'Ciclano de Sousa');
