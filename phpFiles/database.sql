-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Tempo de geração: 25-Mar-2020 às 23:56
-- Versão do servidor: 10.3.16-MariaDB
-- versão do PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `id9517233_bd_rolenoifapp`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblnotas`
--

CREATE TABLE `tblnotas` (
  `idUser` int(11) NOT NULL,
  `emailUser` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `nomeCurso` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `notaCurso` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Extraindo dados da tabela `tblnotas`
--

INSERT INTO `tblnotas` (`idUser`, `emailUser`, `nomeCurso`, `notaCurso`) VALUES
(1, 'rayanne_lima2010@hotmail.com', 'Técnico em Meio Ambiente', 4),
(2, 'rayanne_lima2010@hotmail.com', 'Técnico em Meio Ambiente', 2.5),
(3, 'rayanne_lima2010@hotmail.com', 'Técnico em Meio Ambiente', 1.5),
(4, 'rayanne_lima2010@hotmail.com', 'Técnico em Zootecnia', 3.5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblusers`
--

CREATE TABLE `tblusers` (
  `idUser` int(11) NOT NULL,
  `nomeUser` varchar(60) COLLATE utf8_bin NOT NULL,
  `emailUser` text COLLATE utf8_bin NOT NULL,
  `matriculaUser` longtext COLLATE utf8_bin NOT NULL,
  `telefoneUser` varchar(15) COLLATE utf8_bin NOT NULL,
  `cidadeUser` varchar(60) COLLATE utf8_bin NOT NULL,
  `senhaUser` varchar(200) COLLATE utf8_bin NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `tblusers`
--

INSERT INTO `tblusers` (`idUser`, `nomeUser`, `emailUser`, `matriculaUser`, `telefoneUser`, `cidadeUser`, `senhaUser`) VALUES
(27, 'Rayanne', 'rayanne_lima20108@hotmail.com', '8495849', '58498549', 'jdisjdk', '$2y$10$LmzIWF7vLwdItziCmQGeuedoOtbG1RR9lx26rDp/6lH88CDcEfc4u'),
(28, '545454', 'rayanne_lima20158@hotmail.com', '545454', '54545454', '5454545', '$2y$10$1suB1Iv4q84qrFKztUN92.4pmGB5YnrUkGGh9p/i5HiLMl8WN3pDW'),
(29, 'Rayanne B. Lima', 'rayanne_lima2010@hotmail.com', '35341605', '+5532998187070', 'Rio Pomba', '$2y$10$/l7Ph6VrQRhq/sJmyMMXa.0BIxZ4iGOh4KwD8YtSiooyFmKQY4LbC'),
(30, 'Rayanne B. Lima', 'brunonnn@gmail.com', '64646465', '+5532998187070', 'ahhajaks', '$2y$10$2535KZpZ0EJUKvzkRHEto.f9aik/bbiQkxTjSrVMlUmUiYjEZAdu6'),
(31, 'jsjsjdj', 'djdjjdkeek', '466494944', '664616162', 'jwjekeke', '$2y$10$RzpFAXhkj2KlPgta.eY68uE8hDvmLkH4.9Quxo9MUAkVm8mts0Shq'),
(32, 'Rayanne B. Lima', 'rayanne_limagg2010@hotmail.com', '35313', '6461626', 'drdetg', '$2y$10$GTYfKUNlsscm4GCeTHMeu.E4FZUTnaTesn8rsp94Q.3wZzPz1RK.2'),
(33, 'jasjjdj', 'kajaksks', '44665464', '6464949', 'jashhska', '$2y$10$Zmvhgw9.8i5i1yzzrR4CWuotfaFEzGzbABXBB7w4W4XcL1vyTHoJe'),
(34, 'gdtuho', 'ififigo', '5686839', '8386869', 'uxuvib', '$2y$10$dOA6z5HkfuxU5CHPLEdvg.7dispiFEShB869Y.DCJTGKVlAOhXSLC');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tblnotas`
--
ALTER TABLE `tblnotas`
  ADD PRIMARY KEY (`idUser`);

--
-- Índices para tabela `tblusers`
--
ALTER TABLE `tblusers`
  ADD PRIMARY KEY (`idUser`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tblnotas`
--
ALTER TABLE `tblnotas`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tblusers`
--
ALTER TABLE `tblusers`
  MODIFY `idUser` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
