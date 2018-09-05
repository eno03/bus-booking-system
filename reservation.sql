-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2018 at 06:45 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `reservation`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `id` int(11) NOT NULL,
  `company_name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `company_name`) VALUES
(1, 'Srbija Tours Internationa'),
(2, 'Terra Travel'),
(3, 'Belvi travel'),
(4, 'Euroturs Niš'),
(5, 'Lasta'),
(6, 'Luki Reisen - Sana trans'),
(7, 'Stup Vršac'),
(8, 'Vitosprint prevoz'),
(9, 'TopLine'),
(10, 'Simplon');

-- --------------------------------------------------------

--
-- Table structure for table `date`
--

CREATE TABLE `date` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `date`
--

INSERT INTO `date` (`id`, `date`) VALUES
(3, '2017-07-02'),
(4, '2017-07-03'),
(5, '2017-07-04'),
(6, '2017-07-05'),
(7, '2017-07-06'),
(8, '2017-07-07'),
(9, '2017-07-08'),
(10, '2017-07-09'),
(11, '2017-07-10'),
(12, '2017-07-11'),
(13, '2017-07-12'),
(14, '2017-07-13'),
(15, '2017-07-14'),
(16, '2017-07-15'),
(17, '2017-07-16'),
(18, '2017-07-17'),
(19, '2017-07-18'),
(20, '2017-07-19'),
(21, '2017-07-20'),
(22, '2017-07-21'),
(23, '2017-07-22'),
(24, '2017-07-23'),
(25, '2017-07-24'),
(26, '2017-07-25'),
(27, '2017-07-26'),
(28, '2017-07-27'),
(29, '2017-07-28'),
(30, '2017-07-29'),
(31, '2017-07-30'),
(32, '2017-07-31'),
(33, '2017-08-01'),
(34, '2017-08-02'),
(35, '2017-08-03'),
(36, '2017-08-04'),
(37, '2017-08-05'),
(38, '2017-08-06'),
(39, '2017-08-07'),
(40, '2017-08-08'),
(41, '2017-08-09'),
(42, '2017-08-10'),
(43, '2017-08-11'),
(44, '2017-08-12'),
(45, '2017-08-13'),
(46, '2017-08-14'),
(47, '2017-08-15'),
(48, '2017-08-16'),
(49, '2017-08-17'),
(50, '2017-08-18'),
(51, '2017-08-19'),
(52, '2017-08-20'),
(53, '2017-08-21'),
(54, '2017-08-22'),
(55, '2017-08-23'),
(56, '2017-08-24'),
(57, '2017-08-25'),
(58, '2017-08-26'),
(59, '2017-08-27'),
(60, '2017-08-28'),
(61, '2017-08-29'),
(62, '2017-08-30');

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `location` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `location`) VALUES
(1, 'Beograd'),
(2, 'Nis'),
(3, 'Kragujevac'),
(4, 'Subotica'),
(5, 'Nova Varos'),
(6, 'Podgorica'),
(7, 'Bec'),
(8, 'Prag'),
(9, 'Budimpesta'),
(10, 'Minhen'),
(11, 'Drezden'),
(12, 'Keln');

-- --------------------------------------------------------

--
-- Table structure for table `purchased`
--

CREATE TABLE `purchased` (
  `id` int(11) NOT NULL,
  `ime` varchar(20) NOT NULL,
  `prezime` varchar(20) NOT NULL,
  `locationA` varchar(20) NOT NULL,
  `locationB` varchar(20) NOT NULL,
  `date` varchar(10) NOT NULL,
  `time` varchar(5) NOT NULL,
  `company` varchar(50) NOT NULL,
  `type` varchar(15) NOT NULL,
  `price` int(11) NOT NULL,
  `discount` varchar(15) NOT NULL,
  `luggage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `purchased`
--

INSERT INTO `purchased` (`id`, `ime`, `prezime`, `locationA`, `locationB`, `date`, `time`, `company`, `type`, `price`, `discount`, `luggage`) VALUES
(2, 'Nikola', 'Obucina', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Double-decker', 1960, 'Student', 3),
(3, 'Matej', 'Petrovic', 'Beograd', 'Bec', '2017-07-05', '03:30', 'Simplon', 'Standard', 4040, 'Retiree', 2),
(4, 'Miki', 'Peric', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1800, 'Student', 3),
(5, 'Sasa', 'Salipurovic', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Double-decker', 2480, 'Without', 4),
(6, 'Jovan', 'Jovicic', 'Prag', 'Minhen', '2017-07-08', '03:00', 'Stup Vršac', 'Minibus', 2640, 'Student', 2),
(7, 'Malisa', 'Jovic', 'Prag', 'Minhen', '2017-07-08', '03:00', 'Stup Vršac', 'Minibus', 2640, 'Student', 2),
(8, 'Savo', 'Bacic', 'Bec', 'Keln', '2017-07-15', '05:30', 'Vitosprint prevoz', 'Minibus', 2260, 'Retiree', 3),
(9, 'Proba', 'Test', 'Subotica', 'Podgorica', '2017-07-19', '18:00', 'Srbija Tours Internationa', 'Minibus', 5200, 'Without', 0),
(10, 'Petar', 'Mitic', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1800, 'Without', 0),
(11, 'Stanko', 'Milekic', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1800, 'Student', 3),
(12, 'Marinko', 'Seljek', 'Bec', 'Keln', '2017-07-15', '05:30', 'Vitosprint prevoz', 'Minibus', 2140, 'Retiree', 2),
(13, 'Mima', 'Mima', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1680, 'Student', 2),
(14, 'Suza', 'Bjelanovic', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Double-decker', 1960, 'Student', 3),
(15, 'Proba', 'Test', 'Podgorica', 'Minhen', '2017-07-04', '18:30', 'Luki Reisen - Sana trans', 'Minibus', 3680, 'Student', 2),
(16, 'Malomir', 'Sekeljic', 'Podgorica', 'Minhen', '2017-07-04', '18:30', 'Luki Reisen - Sana trans', 'Minibus', 4300, 'Without', 0),
(17, 'Maki', 'Makic', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1680, 'Student', 2),
(18, 'Dsad', 'dsad', 'Minhen', 'Prag', '2017-07-02', '18:30', 'Terra Travel', 'Standard', 3560, 'Student', 3),
(19, 'dsadsa', 'dsadsa', 'Minhen', 'Prag', '2017-07-02', '18:30', 'Terra Travel', 'Standard', 4160, 'Retiree', 3),
(20, 'dsadsa', 'dsa', 'Minhen', 'Prag', '2017-07-02', '18:30', 'Terra Travel', 'Standard', 4120, 'Without', 1),
(21, 'Nikola', 'Obucina', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1920, 'Student', 4),
(22, 'Marko', 'Maric', 'Minhen', 'Prag', '2017-07-02', '18:30', 'Terra Travel', 'Standard', 4160, 'Retiree', 3),
(23, 'Nikola', 'Obucina', 'Beograd', 'Nova Varos', '2017-07-02', '07:30', 'Stup Vršac', 'Standard', 1680, 'Student', 2);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `id_locationA` int(11) NOT NULL,
  `id_locationB` int(11) NOT NULL,
  `id_date` int(11) NOT NULL,
  `id_time` int(11) NOT NULL,
  `id_company` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `tickets` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `id_locationA`, `id_locationB`, `id_date`, `id_time`, `id_company`, `id_type`, `price`, `tickets`) VALUES
(21, 1, 5, 3, 16, 7, 2, 1800, 39),
(22, 8, 10, 9, 7, 7, 1, 3000, 29),
(23, 3, 5, 16, 11, 9, 2, 4000, 40),
(24, 1, 7, 6, 8, 10, 2, 4000, 40),
(25, 11, 2, 10, 15, 7, 3, 4200, 60),
(26, 1, 5, 3, 16, 7, 3, 2000, 65),
(27, 5, 4, 23, 5, 4, 2, 2000, 40),
(28, 7, 12, 16, 12, 8, 1, 2000, 28),
(29, 4, 6, 20, 37, 1, 1, 5200, 0),
(30, 6, 10, 5, 38, 6, 1, 4300, 0),
(31, 10, 8, 3, 38, 2, 2, 4000, 0);

-- --------------------------------------------------------

--
-- Table structure for table `time`
--

CREATE TABLE `time` (
  `id` int(11) NOT NULL,
  `time` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `time`
--

INSERT INTO `time` (`id`, `time`) VALUES
(1, '00:00'),
(2, '00:30'),
(3, '01:00'),
(4, '01:30'),
(5, '02:00'),
(6, '02:30'),
(7, '03:00'),
(8, '03:30'),
(9, '04:00'),
(10, '04:30'),
(11, '05:00'),
(12, '05:30'),
(13, '06:00'),
(14, '06:30'),
(15, '07:00'),
(16, '07:30'),
(17, '08:00'),
(18, '08:30'),
(19, '09:00'),
(20, '09:30'),
(21, '10:00'),
(22, '10:30'),
(23, '11:00'),
(24, '11:30'),
(25, '12:00'),
(26, '12:30'),
(27, '13:00'),
(28, '13:30'),
(29, '14:00'),
(30, '14:30'),
(31, '15:00'),
(32, '15:30'),
(33, '16:00'),
(34, '16:30'),
(35, '17:00'),
(36, '17:30'),
(37, '18:00'),
(38, '18:30'),
(39, '19:00'),
(40, '19:30'),
(41, '20:00'),
(42, '20:30'),
(43, '21:00'),
(44, '21:30'),
(45, '22:00'),
(46, '22:30'),
(47, '23:00'),
(48, '23:30');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `id` int(11) NOT NULL,
  `bus_type` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`id`, `bus_type`) VALUES
(1, 'Minibus'),
(2, 'Standard'),
(3, 'Double-decker');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `date`
--
ALTER TABLE `date`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchased`
--
ALTER TABLE `purchased`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `time`
--
ALTER TABLE `time`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `date`
--
ALTER TABLE `date`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `purchased`
--
ALTER TABLE `purchased`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `time`
--
ALTER TABLE `time`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
