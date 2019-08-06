-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 05, 2019 at 04:19 PM
-- Server version: 10.1.40-MariaDB
-- PHP Version: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `telesrb`
--

-- --------------------------------------------------------

--
-- Table structure for table `broj_telefona`
--

CREATE TABLE `broj_telefona` (
  `id_broj_telefona` int(11) NOT NULL,
  `numeracija` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `paket`
--

CREATE TABLE `paket` (
  `id_paket` int(11) NOT NULL,
  `tip` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `naziv` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `opis` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `cena` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pripajd_dodatna_oprema`
--

CREATE TABLE `pripajd_dodatna_oprema` (
  `id_pripejd_oprema` int(11) NOT NULL,
  `naziv` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `cena` float NOT NULL,
  `tip` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `opis` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `racun`
--

CREATE TABLE `racun` (
  `id_racun` int(11) NOT NULL,
  `datum` date NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_ugovor` int(11) NOT NULL,
  `status_racuna` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `stavke`
--

CREATE TABLE `stavke` (
  `id_stavke` int(11) NOT NULL,
  `id_racun` int(11) NOT NULL,
  `id_pripejd_opreme` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `ugovor_postpejd`
--

CREATE TABLE `ugovor_postpejd` (
  `id_udovor` int(11) NOT NULL,
  `datum_pocetka` date NOT NULL,
  `datum_isteka` date NOT NULL,
  `id_uredjaj` int(11) NOT NULL,
  `id_paket` int(11) NOT NULL,
  `id_broj_telefona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `uredjaj`
--

CREATE TABLE `uredjaj` (
  `id_uredjaj` int(11) NOT NULL,
  `id_paket` int(11) NOT NULL,
  `tip` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `naziv` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `opis` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `cena` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `ime` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prezime` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `broj_telefona` int(11) NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_tip` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adresa` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `broj_telefona`
--
ALTER TABLE `broj_telefona`
  ADD PRIMARY KEY (`id_broj_telefona`);

--
-- Indexes for table `paket`
--
ALTER TABLE `paket`
  ADD PRIMARY KEY (`id_paket`);

--
-- Indexes for table `pripajd_dodatna_oprema`
--
ALTER TABLE `pripajd_dodatna_oprema`
  ADD PRIMARY KEY (`id_pripejd_oprema`);

--
-- Indexes for table `racun`
--
ALTER TABLE `racun`
  ADD PRIMARY KEY (`id_racun`),
  ADD KEY `id_user` (`id_user`,`id_ugovor`),
  ADD KEY `id_ugovor` (`id_ugovor`);

--
-- Indexes for table `stavke`
--
ALTER TABLE `stavke`
  ADD PRIMARY KEY (`id_stavke`,`id_racun`),
  ADD KEY `id_racun` (`id_racun`),
  ADD KEY `id_pripejd_opreme` (`id_pripejd_opreme`);

--
-- Indexes for table `ugovor_postpejd`
--
ALTER TABLE `ugovor_postpejd`
  ADD PRIMARY KEY (`id_udovor`),
  ADD KEY `id_uredjaj` (`id_uredjaj`,`id_paket`,`id_broj_telefona`),
  ADD KEY `id_paket` (`id_paket`),
  ADD KEY `id_broj_telefona` (`id_broj_telefona`);

--
-- Indexes for table `uredjaj`
--
ALTER TABLE `uredjaj`
  ADD PRIMARY KEY (`id_uredjaj`,`id_paket`),
  ADD KEY `id_paket` (`id_paket`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `broj_telefona`
--
ALTER TABLE `broj_telefona`
  MODIFY `id_broj_telefona` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paket`
--
ALTER TABLE `paket`
  MODIFY `id_paket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pripajd_dodatna_oprema`
--
ALTER TABLE `pripajd_dodatna_oprema`
  MODIFY `id_pripejd_oprema` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `racun`
--
ALTER TABLE `racun`
  MODIFY `id_racun` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stavke`
--
ALTER TABLE `stavke`
  MODIFY `id_stavke` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `ugovor_postpejd`
--
ALTER TABLE `ugovor_postpejd`
  MODIFY `id_udovor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `uredjaj`
--
ALTER TABLE `uredjaj`
  MODIFY `id_uredjaj` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `racun`
--
ALTER TABLE `racun`
  ADD CONSTRAINT `racun_ibfk_2` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `racun_ibfk_3` FOREIGN KEY (`id_ugovor`) REFERENCES `ugovor_postpejd` (`id_udovor`);

--
-- Constraints for table `stavke`
--
ALTER TABLE `stavke`
  ADD CONSTRAINT `stavke_ibfk_3` FOREIGN KEY (`id_pripejd_opreme`) REFERENCES `pripajd_dodatna_oprema` (`id_pripejd_oprema`),
  ADD CONSTRAINT `stavke_ibfk_4` FOREIGN KEY (`id_racun`) REFERENCES `racun` (`id_racun`);

--
-- Constraints for table `ugovor_postpejd`
--
ALTER TABLE `ugovor_postpejd`
  ADD CONSTRAINT `ugovor_postpejd_ibfk_3` FOREIGN KEY (`id_broj_telefona`) REFERENCES `broj_telefona` (`id_broj_telefona`),
  ADD CONSTRAINT `ugovor_postpejd_ibfk_4` FOREIGN KEY (`id_paket`) REFERENCES `uredjaj` (`id_paket`),
  ADD CONSTRAINT `ugovor_postpejd_ibfk_5` FOREIGN KEY (`id_uredjaj`) REFERENCES `uredjaj` (`id_uredjaj`);

--
-- Constraints for table `uredjaj`
--
ALTER TABLE `uredjaj`
  ADD CONSTRAINT `uredjaj_ibfk_1` FOREIGN KEY (`id_paket`) REFERENCES `paket` (`id_paket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
