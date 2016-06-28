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

-- Pesquisadores
INSERT INTO pesquisador VALUES(1, 'Fabrizio Marmitt', '2016-06-28 08:48:32');
INSERT INTO pesquisador VALUES(2, 'Júnior Alves', '2016-06-28 08:48:32');
INSERT INTO pesquisador VALUES(3, 'Robson Segoa', '2016-06-28 08:48:32');
INSERT INTO pesquisador VALUES(4, 'Tiago Steiner', '2016-06-28 08:48:32');

-- Usuários
INSERT INTO usuario VALUES('fabriziomarmitt','123456', 1, '2016-06-28 08:48:32', 1);

-- Tipo de Publicação
INSERT INTO tipopublicacao VALUES (1, 'ARTICLE');

-- Publicações
INSERT INTO publicacao VALUES(1,1,'Sample Publication', '2016-06-28 16:13:32', '', '2016', 'LUME');

-- Publicacao Pequisador
INSERT INTO  publicacaopesquisador VALUES(1,1);
INSERT INTO  publicacaopesquisador VALUES(1,2);

-- Campos Publicação
INSERT INTO publicacaocampos VALUES(1,'Local','Porto Alegre',1);
