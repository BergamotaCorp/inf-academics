SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT;
SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS;
SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION;
SET @OLD_TIME_ZONE=@@TIME_ZONE;
SET TIME_ZONE='-03:00';
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';
SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0;

--
-- Use latin1 when you have accented words even if the database is UTF-8
--
SET NAMES latin1;
--

CREATE SCHEMA IF NOT EXISTS infacademics COLLATE utf8_general_ci ;

ALTER DATABASE infacademics
	DEFAULT CHARACTER SET utf8
	DEFAULT COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `infacademics`.`pesquisador` (
  `idpesquisador` INT NOT NULL AUTO_INCREMENT,
  `nomepesquisador` VARCHAR(45) NOT NULL,
  `datacadastro` DATETIME NULL,
  PRIMARY KEY (`idpesquisador`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `infacademics`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `infacademics`.`usuario` (
  `nomeusuario` VARCHAR(50) NOT NULL,
  `senha` VARCHAR(50) NOT NULL,
  `ativo` TINYINT(1) NULL,
  `datacriacao` DATETIME NULL,
  `idpesquisador` INT NOT NULL,
  UNIQUE INDEX `NomeUsuario_UNIQUE` (`nomeusuario` ASC),
  INDEX `fk_Usuario_Pesquisador_idx` (`idpesquisador` ASC),
  PRIMARY KEY (`idpesquisador`),
  CONSTRAINT `fk_Usuario_pesquisador`
    FOREIGN KEY (`idpesquisador`)
    REFERENCES `infacademics`.`pesquisador` (`idpesquisador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `infacademics`.`TipoPublicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `infacademics`.`tipopublicacao` (
  `idtipopublicacao` INT NOT NULL,
  `nometipopublicacao` VARCHAR(45) NULL,
  PRIMARY KEY (`idtipopublicacao`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `infacademics`.`Publicacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `infacademics`.`publicacao` (
  `idpublicacao` INT NOT NULL,
  `idtipopublicacao` INT NOT NULL,
  `nomepublicacao` VARCHAR(400) NULL,
  `datacadastro` DATETIME NULL,
  `atributos` TEXT NULL,
  `ano` INT NULL,
  `publicador` VARCHAR(400) NULL,
  PRIMARY KEY (`idpublicacao`),
  INDEX `fk_publicacao_tipopublicacao1_idx` (`idtipopublicacao` ASC),
  CONSTRAINT `fk_Publicacao_TipoPublicacao1`
    FOREIGN KEY (`idtipopublicacao`)
    REFERENCES `infacademics`.`tipopublicacao` (`idtipopublicacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `infacademics`.`PublicacaoCampos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `infacademics`.`publicacaocampos` (
  `idtpublicacaocampos` INT NOT NULL,
  `nomecampo` TEXT NULL,
  `idpublicacao` INT NOT NULL,
  PRIMARY KEY (`idtpublicacaocampos`),
  INDEX `fk_publicacaocampos_publicacao1_idx` (`idpublicacao` ASC),
  CONSTRAINT `fk_publicacaocampos_publicacao1`
    FOREIGN KEY (`idpublicacao`)
    REFERENCES `infacademics`.`publicacao` (`idpublicacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `infacademics`.`PublicacaoPesquisador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `infacademics`.`publicacaopesquisador` (
  `idpublicacao` INT NOT NULL,
  `idpesquisador` INT NOT NULL,
  PRIMARY KEY (`idpublicacao`, `idpesquisador`),
  INDEX `fk_publicacao_has_pesquisador_pesquisador1_idx` (`idpesquisador` ASC),
  INDEX `fk_publicacao_has_pesquisador_publicacao1_idx` (`idpublicacao` ASC),
  CONSTRAINT `fk_Publicacao_has_pesquisador_publicacao1`
    FOREIGN KEY (`idpublicacao`)
    REFERENCES `infacademics`.`publicacao` (`idpublicacao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_publicacao_has_pesquisador_pesquisador1`
    FOREIGN KEY (`idpesquisador`)
    REFERENCES `infacademics`.`pesquisador` (`idpesquisador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
