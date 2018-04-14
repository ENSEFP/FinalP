-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 14, 2018 at 05:37 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `smarthome`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `account`, `password`) VALUES
(1, 'n@n.n', 'n'),
(2, 'davidhuocantonese@hotmail.com', '1234'),
(3, 'qwe', '123'),
(4, 'adc', '123'),
(5, 'hsjd', 'ooo'),
(6, 'h@h.h', 'h');

-- --------------------------------------------------------

--
-- Table structure for table `configuration`
--

CREATE TABLE `configuration` (
  `id` int(11) NOT NULL,
  `temperature_heat` int(11) NOT NULL,
  `temperature_cool` int(11) NOT NULL,
  `temperature_too_high` int(11) NOT NULL,
  `temperature_too_low` int(11) NOT NULL,
  `begin_time` int(11) NOT NULL,
  `end_time` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `configuration`
--

INSERT INTO `configuration` (`id`, `temperature_heat`, `temperature_cool`, `temperature_too_high`, `temperature_too_low`, `begin_time`, `end_time`) VALUES
(0, -99, 18, -99, -99, 22, 6);

-- --------------------------------------------------------

--
-- Table structure for table `smarthome`
--

CREATE TABLE `smarthome` (
  `id` int(11) NOT NULL,
  `led` int(11) NOT NULL,
  `door` int(11) NOT NULL,
  `motor` int(11) NOT NULL,
  `buzzer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `smarthome`
--

INSERT INTO `smarthome` (`id`, `led`, `door`, `motor`, `buzzer`) VALUES
(0, 1, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `smarthome_basic`
--

CREATE TABLE `smarthome_basic` (
  `id` int(11) NOT NULL,
  `bedroom_led` int(11) NOT NULL,
  `living_room_led` int(11) NOT NULL,
  `kitchen_led` int(11) NOT NULL,
  `fan` int(11) NOT NULL,
  `furnace` int(11) NOT NULL,
  `door` int(11) NOT NULL,
  `buzzer` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `smarthome_basic`
--

INSERT INTO `smarthome_basic` (`id`, `bedroom_led`, `living_room_led`, `kitchen_led`, `fan`, `furnace`, `door`, `buzzer`) VALUES
(0, 0, 0, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
