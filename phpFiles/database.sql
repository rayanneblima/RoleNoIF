-- phpMyAdmin SQL Dump
-- version 3.5.8.2
-- http://www.phpmyadmin.net
--
-- Servidor: sql112.epizy.com
-- Tempo de Geração: 04/05/2019 às 11:35:44
-- Versão do Servidor: 5.6.41-84.1
-- Versão do PHP: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `epiz_23848714_bdrolenoifapp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblusers`
--

CREATE TABLE IF NOT EXISTS `tblusers` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `nomeUser` varchar(60) COLLATE utf8_bin NOT NULL,
  `emailUser` text COLLATE utf8_bin NOT NULL,
  `matriculaUser` longtext COLLATE utf8_bin NOT NULL,
  `telefoneUser` varchar(15) COLLATE utf8_bin NOT NULL,
  `cidadeUser` varchar(60) COLLATE utf8_bin NOT NULL,
  `senhaUser` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idUser`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
