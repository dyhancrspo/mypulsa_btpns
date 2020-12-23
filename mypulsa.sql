-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2020 at 09:48 AM
-- Server version: 10.4.16-MariaDB
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mypulsa`
--

-- --------------------------------------------------------

--
-- Table structure for table `pulsa_indosat`
--

CREATE TABLE `pulsa_indosat` (
  `phone_number` varchar(255) NOT NULL,
  `mobile_billing` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pulsa_indosat`
--

INSERT INTO `pulsa_indosat` (`phone_number`, `mobile_billing`, `status`) VALUES
('085824241234', 125750, 'Waiting for Payment'),
('085899447654', 0, 'Paid Off');

-- --------------------------------------------------------

--
-- Table structure for table `pulsa_telkomsel`
--

CREATE TABLE `pulsa_telkomsel` (
  `phone_number` varchar(255) NOT NULL,
  `mobile_billing` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pulsa_telkomsel`
--

INSERT INTO `pulsa_telkomsel` (`phone_number`, `mobile_billing`, `status`) VALUES
('081119993333', 0, 'Paid Off'),
('082293936565', 75000, 'Waiting for Payment');

-- --------------------------------------------------------

--
-- Table structure for table `pulsa_xl`
--

CREATE TABLE `pulsa_xl` (
  `phone_number` varchar(255) NOT NULL,
  `mobile_billing` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pulsa_xl`
--

INSERT INTO `pulsa_xl` (`phone_number`, `mobile_billing`, `status`) VALUES
('087754546789', 65776, 'Waiting for Payment'),
('087783877455', 63500, 'Waiting for Payment');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pulsa_indosat`
--
ALTER TABLE `pulsa_indosat`
  ADD PRIMARY KEY (`phone_number`);

--
-- Indexes for table `pulsa_telkomsel`
--
ALTER TABLE `pulsa_telkomsel`
  ADD PRIMARY KEY (`phone_number`);

--
-- Indexes for table `pulsa_xl`
--
ALTER TABLE `pulsa_xl`
  ADD PRIMARY KEY (`phone_number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
