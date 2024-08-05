-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- ホスト: 127.0.0.1
-- 生成日時: 2024-08-05 07:00:16
-- サーバのバージョン： 10.4.28-MariaDB
-- PHP のバージョン: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- データベース: `testdb`
--

-- --------------------------------------------------------

--
-- テーブルの構造 `teams`
--

CREATE TABLE `teams` (
  `id` int(11) NOT NULL COMMENT 'チームID',
  `name` varchar(50) DEFAULT NULL COMMENT 'チーム名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- テーブルのデータのダンプ `teams`
--

INSERT INTO `teams` (`id`, `name`) VALUES
(1, 'チームＡ'),
(2, 'チームＢ'),
(3, 'チームＣ'),
(4, 'チームＤ');

-- --------------------------------------------------------

--
-- テーブルの構造 `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL COMMENT 'ユーザID',
  `team_id` int(11) DEFAULT NULL COMMENT 'チームID（teamsテーブルの外部キー）',
  `name` varchar(50) DEFAULT NULL COMMENT 'ユーザ名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- テーブルのデータのダンプ `users`
--

INSERT INTO `users` (`id`, `team_id`, `name`) VALUES
(1, 1, '山田'),
(2, 1, '鈴木'),
(3, 2, '中村'),
(4, 2, '田中'),
(5, 3, '加藤');

--
-- ダンプしたテーブルのインデックス
--

--
-- テーブルのインデックス `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`id`);

--
-- テーブルのインデックス `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- ダンプしたテーブルの AUTO_INCREMENT
--

--
-- テーブルの AUTO_INCREMENT `teams`
--
ALTER TABLE `teams`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'チームID', AUTO_INCREMENT=5;

--
-- テーブルの AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ユーザID', AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
