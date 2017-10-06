-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 28, 2017 at 02:28 PM
-- Server version: 5.7.17-0ubuntu0.16.04.1
-- PHP Version: 7.0.13-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dahouet`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `DistanceMoyenneSaison` (IN `p_saison` INT)  BEGIN
SELECT AVG(distance_regate) AS DistanceMoyenne, c.saison AS Saison FROM Regate r
INNER JOIN Challenge c ON r.id_challenge=c.id_challenge
WHERE c.id_challenge = p_saison;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `InterventionCommissaire` (IN `p_challenge` INT, IN `p_date_debut` DATE, IN `p_date_fin` DATE)  BEGIN
SELECT nom_personne AS NomCommissaire, prenom_personne AS PrenomCommissaire, comite AS Comité, date_regate AS DateRégate FROM Regate r
INNER JOIN Challenge cha ON r.id_challenge=cha.id_challenge
INNER JOIN Commissaire com ON r.id_commissaire=com.id_commissaire
INNER JOIN Personne per ON com.id_personne=per.id_personne
WHERE p_challenge = cha.id_challenge AND p_date_debut < date_regate AND p_date_fin > date_regate;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `ListeEquipageVoilierParRegate` (IN `p_voilier` INT, IN `p_regate` INT)  BEGIN
SELECT nom_personne AS Nom, prenom_personne AS Prénom, v.nom_voilier AS Voilier, r.nom_regate AS Regate FROM Personne per
INNER JOIN Proprietaire pro ON per.id_personne=pro.id_personne
INNER JOIN Voilier v ON pro.id_proprietaire=v.id_proprietaire
INNER JOIN PARTICIPER par ON v.id_voilier=par.id_voilier
INNER JOIN Regate r ON par.id_regate=r.id_regate
WHERE r.num_regate = p_regate AND v.num_voile = p_voilier;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `CodeGen` (`v_id_regate` INT) RETURNS VARCHAR(11) CHARSET latin1 BEGIN

DECLARE v_code_challenge VARCHAR(20);
DECLARE v_mois_date INT;
DECLARE v_ajout INT;
DECLARE CodeGen VARCHAR(20);

SELECT code_challenge INTO v_code_challenge FROM Challenge cha INNER JOIN Regate r ON cha.id_challenge=r.id_challenge WHERE r.id_regate=v_id_regate;
SELECT MONTH(date_regate) INTO v_mois_date FROM Regate r INNER JOIN Challenge cha ON r.id_challenge=cha.id_challenge WHERE r.id_regate=v_id_regate;
SELECT COUNT(id_regate) INTO v_ajout FROM Regate;

SET CodeGen = CONCAT(v_code_challenge,"-",v_mois_date,"-", v_ajout+1);

RETURN CodeGen;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Challenge`
--

CREATE TABLE `Challenge` (
  `id_challenge` int(11) NOT NULL,
  `code_challenge` varchar(10) NOT NULL,
  `saison` varchar(25) DEFAULT NULL,
  `debut_challenge` date DEFAULT NULL,
  `fin_challenge` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Challenge`
--

INSERT INTO `Challenge` (`id_challenge`, `code_challenge`, `saison`, `debut_challenge`, `fin_challenge`) VALUES
(1, 'CHAHIV', 'Hiver', '2016-11-01', '2017-03-31'),
(2, 'CHAETE', 'Ete', '2017-05-01', '2017-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `Classe`
--

CREATE TABLE `Classe` (
  `id_classe` int(11) NOT NULL,
  `nom_classe` varchar(25) NOT NULL,
  `coef` int(11) NOT NULL,
  `id_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Classe`
--

INSERT INTO `Classe` (`id_classe`, `nom_classe`, `coef`, `id_serie`) VALUES
(1, 'Corsaire', 5, 1),
(2, 'Surprise', 6, 1),
(3, '8 metres', 8, 1),
(4, 'Maraudeur', 3, 1),
(5, 'Figaro', 9, 1),
(6, 'Flying Fifteen', 7, 2),
(7, 'Soling', 4, 2),
(8, 'Star', 3, 2),
(9, 'Tempest', 2, 2),
(10, 'Yngling', 6, 2),
(11, '5.5', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `Commissaire`
--

CREATE TABLE `Commissaire` (
  `id_commissaire` int(11) NOT NULL,
  `comite` varchar(25) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Commissaire`
--

INSERT INTO `Commissaire` (`id_commissaire`, `comite`, `id_personne`) VALUES
(1, 'Idf', 6),
(2, 'Est', 9),
(3, 'Ouest', 11),
(4, 'Sud', 19);

-- --------------------------------------------------------

--
-- Table structure for table `Concurrent`
--

CREATE TABLE `Concurrent` (
  `id_concurrent` int(11) NOT NULL,
  `id_personne` int(11) DEFAULT NULL,
  `id_voilier` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Concurrent`
--

INSERT INTO `Concurrent` (`id_concurrent`, `id_personne`, `id_voilier`) VALUES
(1, 7, 1),
(2, 8, 1),
(3, 5, 1),
(4, 1, 2),
(5, 3, 2),
(6, 4, 2),
(7, 10, 3),
(8, 11, 3),
(9, 12, 4),
(10, 13, 5),
(11, 16, 6),
(12, 17, 7),
(13, 17, 8);

-- --------------------------------------------------------

--
-- Table structure for table `PARTICIPER`
--

CREATE TABLE `PARTICIPER` (
  `tps_reel` int(11) DEFAULT NULL,
  `tps_compense` int(11) DEFAULT NULL,
  `place` int(10) DEFAULT NULL,
  `id_voilier` int(11) NOT NULL,
  `id_regate` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `PARTICIPER`
--

INSERT INTO `PARTICIPER` (`tps_reel`, `tps_compense`, `place`, `id_voilier`, `id_regate`) VALUES
(NULL, NULL, NULL, 1, 49),
(NULL, NULL, NULL, 2, 55),
(NULL, NULL, NULL, 3, 49),
(NULL, NULL, NULL, 5, 49),
(NULL, NULL, NULL, 6, 49),
(NULL, NULL, NULL, 7, 49),
(NULL, NULL, NULL, 8, 55);

--
-- Triggers `PARTICIPER`
--
DELIMITER $$
CREATE TRIGGER `verif_place` BEFORE INSERT ON `PARTICIPER` FOR EACH ROW BEGIN

DECLARE v_place INT;
DECLARE v_nb_participant INT;

SELECT COUNT(place) INTO v_place FROM PARTICIPER PAR INNER JOIN Regate r ON PAR.id_regate=r.id_regate;
SELECT COUNT(PAR.id_regate) INTO v_nb_participant FROM PARTICIPER PAR INNER JOIN Regate r ON PAR.id_regate=r.id_regate;

IF v_place < v_nb_participant THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur !';
END IF;

END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Personne`
--

CREATE TABLE `Personne` (
  `id_personne` int(11) NOT NULL,
  `nom_personne` varchar(25) DEFAULT NULL,
  `prenom_personne` varchar(25) DEFAULT NULL,
  `email_personne` varchar(25) DEFAULT NULL,
  `num_licence` int(11) DEFAULT NULL,
  `annee_licence` int(11) DEFAULT NULL,
  `nom_club` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Personne`
--

INSERT INTO `Personne` (`id_personne`, `nom_personne`, `prenom_personne`, `email_personne`, `num_licence`, `annee_licence`, `nom_club`) VALUES
(1, 'Callec', 'Yoann', 'pouet@pouet.fr', 34856, 2017, 'Club Mx'),
(2, 'Balcon', 'Yoann', 'prout@prout.prout', 45687, 2014, 'Club Brest'),
(3, 'LeGrall', 'Jérome', 'jeje@jeje.je', 84314, 1998, 'Club Santec'),
(4, 'Fournier', 'Lucas', 'lulu@lulu.lu', 98459, 2011, 'Club Lorient'),
(5, 'Lopez', 'Richard', 'zer@ezr.ezr', 84645, 2015, 'Club St Pol'),
(6, 'Duval', 'Jean-Luc', 'uuu@uuu.uu', 98754, 2016, 'Club Santec'),
(7, 'Kertruc', 'Martine', 'dd@ddd.dd', 36985, 2010, 'Club Plouenan'),
(8, 'Lotus', 'Louis', 'eee@ee.ee', 95874, 2007, 'Club Mespaul'),
(9, 'Kiev', 'Daniel', 'df@df.df', 98547, 2015, 'Club Moscou'),
(10, 'Le Henaff', 'Gwenolé', 'sdf@sdf.sdf', 65487, 2017, 'Club Mx'),
(11, 'Langaine', 'Nicolas', 'dd@dd.dd', 98754, 2016, 'Club Landivisiau'),
(12, 'Simon', 'Christophe', 'zz@zz.zz', 50654, 1991, 'Club Landivisiau'),
(13, 'Chenier', 'Tanguy', 'dfg@sdf.er', 10984, 2010, 'Club AFPA'),
(14, 'Vanel', 'Rémi', 'hh@hh.hh', 25654, 2012, 'Club Lesneven'),
(15, 'Lefèbvre', 'Christiane', 'cleb@sdf.sdf', 68546, 2015, 'Club Paris'),
(16, 'Laframboise', 'Amedee', 'sdf@dfg.ee', 12654, 2000, 'Club Rennes'),
(17, 'Faubert', 'Lea', 'lf@lf.lf', 32165, 2001, 'Club Marseille'),
(18, 'Bisson', 'Thierry', 'bt@bt.bt', 65487, 2016, 'Club Lille'),
(19, 'Bisaillon', 'Noël', 'rgdfg@dfgdfg.df', 54562, 2017, 'Club Rennes'),
(20, 'Dupuis', 'Marcel', 'sdfsdf@ggg.gg', 98451, 2014, 'Club Lille');

-- --------------------------------------------------------

--
-- Table structure for table `Proprietaire`
--

CREATE TABLE `Proprietaire` (
  `id_proprietaire` int(11) NOT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Proprietaire`
--

INSERT INTO `Proprietaire` (`id_proprietaire`, `id_personne`) VALUES
(1, 2),
(2, 3),
(3, 10),
(4, 11),
(5, 14),
(6, 15),
(7, 18),
(8, 20);

-- --------------------------------------------------------

--
-- Table structure for table `Regate`
--

CREATE TABLE `Regate` (
  `id_regate` int(11) NOT NULL,
  `nom_regate` varchar(25) DEFAULT NULL,
  `num_regate` int(11) DEFAULT NULL,
  `date_regate` date DEFAULT NULL,
  `distance_regate` int(11) DEFAULT NULL,
  `id_challenge` int(11) DEFAULT NULL,
  `id_commissaire` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Regate`
--

INSERT INTO `Regate` (`id_regate`, `nom_regate`, `num_regate`, `date_regate`, `distance_regate`, `id_challenge`, `id_commissaire`) VALUES
(36, 'LaNoyade', 8754, '2017-01-16', 3256, 1, 3),
(48, 'LesFlotteurs', 3215, '2017-03-12', 2847, 1, 1),
(49, 'Perte', 1254, '2016-12-13', 3057, 1, 2),
(50, 'Echec', 6875, '2016-12-01', 2076, 1, 4),
(51, 'Destruction', 6874, '2017-02-22', 356, 1, 1),
(52, 'Ruine', 3332, '2017-01-13', 7741, 1, 2),
(53, 'Englouti', 8845, '2017-03-08', 3211, 1, 3),
(54, 'Egaré', 6754, '2017-02-06', 9475, 1, 2),
(55, 'Sinistré', 8953, '2017-02-19', 3621, 1, 4),
(56, 'Naufrage', 1124, '2017-02-09', 2147, 1, 1),
(57, 'Perdition', 6685, '2016-12-07', 3331, 1, 1),
(58, 'Echec', 3547, '2016-11-18', 5847, 1, 2),
(59, 'Paix', 4441, '2017-05-18', 3220, 2, 4),
(60, 'Chance', 9958, '2017-06-14', 4488, 2, 2),
(61, 'Douceur', 9965, '2017-06-05', 5566, 2, 3),
(62, 'Plaisir', 5546, '2017-05-24', 3321, 2, 1),
(63, 'Succès', 2222, '2017-09-13', 8521, 2, 1),
(64, 'Fortune', 5487, '2017-08-31', 984, 2, 3),
(65, 'Joie', 3579, '2017-06-03', 741, 2, 4),
(66, 'Veine', 3541, '2017-08-01', 9514, 2, 2),
(67, 'Réussite', 9996, '2017-09-13', 4242, 2, 1),
(68, 'Satisfaction', 9993, '2017-07-19', 1478, 2, 4);

--
-- Triggers `Regate`
--
DELIMITER $$
CREATE TRIGGER `verif_date_challenge` BEFORE INSERT ON `Regate` FOR EACH ROW BEGIN
DECLARE date_debut_challenge DATE;
DECLARE date_fin_challenge DATE;


SELECT debut_challenge INTO date_debut_challenge FROM Challenge WHERE id_challenge=NEW.id_challenge;
SELECT fin_challenge INTO date_fin_challenge FROM Challenge WHERE id_challenge=NEW.id_challenge;

IF (NEW.date_regate < date_debut_challenge OR NEW.date_regate > date_fin_challenge)
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Erreur ! La date est incorrecte !';
END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `verif_regate_challenge` BEFORE DELETE ON `Regate` FOR EACH ROW BEGIN

DECLARE v_datefin_challenge DATE;
SELECT fin_challenge INTO v_datefin_challenge FROM Challenge WHERE id_challenge=OLD.id_challenge;

IF CURDATE() < v_datefin_challenge
	THEN SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Impossible de supprimer la régate ! La saison nest pas terminé !';
END IF;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `Serie`
--

CREATE TABLE `Serie` (
  `id_serie` int(11) NOT NULL,
  `nom_serie` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Serie`
--

INSERT INTO `Serie` (`id_serie`, `nom_serie`) VALUES
(1, 'Habitables'),
(2, 'Quillards de sport');

-- --------------------------------------------------------

--
-- Table structure for table `Skipper`
--

CREATE TABLE `Skipper` (
  `id_skipper` int(11) NOT NULL,
  `num_skipper` int(11) DEFAULT NULL,
  `id_voilier` int(11) DEFAULT NULL,
  `id_personne` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Skipper`
--

INSERT INTO `Skipper` (`id_skipper`, `num_skipper`, `id_voilier`, `id_personne`) VALUES
(1, 1836, 1, 1),
(2, 666, 2, 4),
(3, 547, 3, 10);

-- --------------------------------------------------------

--
-- Table structure for table `Voilier`
--

CREATE TABLE `Voilier` (
  `id_voilier` int(11) NOT NULL,
  `nom_voilier` varchar(25) DEFAULT NULL,
  `num_voile` int(11) DEFAULT NULL,
  `id_proprietaire` int(11) DEFAULT NULL,
  `id_classe` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Voilier`
--

INSERT INTO `Voilier` (`id_voilier`, `nom_voilier`, `num_voile`, `id_proprietaire`, `id_classe`) VALUES
(1, 'LePtitMouchoir', 159, 1, 5),
(2, 'LeGrandDuc', 201, 2, 2),
(3, 'LeSharp', 654, 3, 9),
(4, 'LeMalou', 1485, 4, 11),
(5, 'Bootstrap', 554, 5, 7),
(6, 'Symfony', 9874, 6, 6),
(7, 'Github', 2141, 7, 10),
(8, 'Cordova', 1117, 8, 3),
(9, 'PHP', 65487, 1, 1),
(10, 'test', 111, 1, 4),
(11, 'fhgfhg', 545645, 1, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Challenge`
--
ALTER TABLE `Challenge`
  ADD PRIMARY KEY (`id_challenge`);

--
-- Indexes for table `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`id_classe`),
  ADD KEY `id_serie` (`id_serie`);

--
-- Indexes for table `Commissaire`
--
ALTER TABLE `Commissaire`
  ADD PRIMARY KEY (`id_commissaire`),
  ADD KEY `FK_Commissaire_id_personne` (`id_personne`);

--
-- Indexes for table `Concurrent`
--
ALTER TABLE `Concurrent`
  ADD PRIMARY KEY (`id_concurrent`),
  ADD KEY `FK_Concurrent_id_personne` (`id_personne`),
  ADD KEY `FK_Concurrent_id_voilier` (`id_voilier`);

--
-- Indexes for table `PARTICIPER`
--
ALTER TABLE `PARTICIPER`
  ADD PRIMARY KEY (`id_voilier`,`id_regate`),
  ADD KEY `FK_PARTICIPER_id_regate` (`id_regate`);

--
-- Indexes for table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`id_personne`);

--
-- Indexes for table `Proprietaire`
--
ALTER TABLE `Proprietaire`
  ADD PRIMARY KEY (`id_proprietaire`),
  ADD KEY `FK_Proprietaire_id_personne` (`id_personne`);

--
-- Indexes for table `Regate`
--
ALTER TABLE `Regate`
  ADD PRIMARY KEY (`id_regate`),
  ADD KEY `FK_Regate_id_challenge` (`id_challenge`),
  ADD KEY `FK_Regate_id_commissaire` (`id_commissaire`);

--
-- Indexes for table `Serie`
--
ALTER TABLE `Serie`
  ADD PRIMARY KEY (`id_serie`);

--
-- Indexes for table `Skipper`
--
ALTER TABLE `Skipper`
  ADD PRIMARY KEY (`id_skipper`),
  ADD KEY `FK_Skipper_id_voilier` (`id_voilier`),
  ADD KEY `FK_Skipper_id_personne` (`id_personne`);

--
-- Indexes for table `Voilier`
--
ALTER TABLE `Voilier`
  ADD PRIMARY KEY (`id_voilier`),
  ADD KEY `FK_Voilier_id_proprietaire` (`id_proprietaire`),
  ADD KEY `FK_Voilier_id_serie` (`id_classe`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Challenge`
--
ALTER TABLE `Challenge`
  MODIFY `id_challenge` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Classe`
--
ALTER TABLE `Classe`
  MODIFY `id_classe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `Commissaire`
--
ALTER TABLE `Commissaire`
  MODIFY `id_commissaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `Concurrent`
--
ALTER TABLE `Concurrent`
  MODIFY `id_concurrent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `id_personne` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `Proprietaire`
--
ALTER TABLE `Proprietaire`
  MODIFY `id_proprietaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `Regate`
--
ALTER TABLE `Regate`
  MODIFY `id_regate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;
--
-- AUTO_INCREMENT for table `Serie`
--
ALTER TABLE `Serie`
  MODIFY `id_serie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `Skipper`
--
ALTER TABLE `Skipper`
  MODIFY `id_skipper` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Voilier`
--
ALTER TABLE `Voilier`
  MODIFY `id_voilier` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Classe`
--
ALTER TABLE `Classe`
  ADD CONSTRAINT `Classe_ibfk_1` FOREIGN KEY (`id_serie`) REFERENCES `Serie` (`id_serie`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Commissaire`
--
ALTER TABLE `Commissaire`
  ADD CONSTRAINT `FK_Commissaire_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `Personne` (`id_personne`);

--
-- Constraints for table `Concurrent`
--
ALTER TABLE `Concurrent`
  ADD CONSTRAINT `FK_Concurrent_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `Personne` (`id_personne`),
  ADD CONSTRAINT `FK_Concurrent_id_voilier` FOREIGN KEY (`id_voilier`) REFERENCES `Voilier` (`id_voilier`);

--
-- Constraints for table `PARTICIPER`
--
ALTER TABLE `PARTICIPER`
  ADD CONSTRAINT `FK_PARTICIPER_id_regate` FOREIGN KEY (`id_regate`) REFERENCES `Regate` (`id_regate`),
  ADD CONSTRAINT `FK_PARTICIPER_id_voilier` FOREIGN KEY (`id_voilier`) REFERENCES `Voilier` (`id_voilier`);

--
-- Constraints for table `Proprietaire`
--
ALTER TABLE `Proprietaire`
  ADD CONSTRAINT `FK_Proprietaire_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `Personne` (`id_personne`);

--
-- Constraints for table `Regate`
--
ALTER TABLE `Regate`
  ADD CONSTRAINT `FK_Regate_id_challenge` FOREIGN KEY (`id_challenge`) REFERENCES `Challenge` (`id_challenge`),
  ADD CONSTRAINT `FK_Regate_id_commissaire` FOREIGN KEY (`id_commissaire`) REFERENCES `Commissaire` (`id_commissaire`);

--
-- Constraints for table `Skipper`
--
ALTER TABLE `Skipper`
  ADD CONSTRAINT `FK_Skipper_id_personne` FOREIGN KEY (`id_personne`) REFERENCES `Personne` (`id_personne`),
  ADD CONSTRAINT `FK_Skipper_id_voilier` FOREIGN KEY (`id_voilier`) REFERENCES `Voilier` (`id_voilier`);

--
-- Constraints for table `Voilier`
--
ALTER TABLE `Voilier`
  ADD CONSTRAINT `FK_Voilier_id_proprietaire` FOREIGN KEY (`id_proprietaire`) REFERENCES `Proprietaire` (`id_proprietaire`),
  ADD CONSTRAINT `Voilier_ibfk_1` FOREIGN KEY (`id_classe`) REFERENCES `Classe` (`id_classe`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
