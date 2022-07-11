-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-07-2022 a las 07:33:13
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sistemadeventas`
--
CREATE DATABASE IF NOT EXISTS `sistemadeventas` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sistemadeventas`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `codigo` int(3) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `nit` int(10) NOT NULL,
  `correo` varchar(70) NOT NULL,
  `genero` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`codigo`, `nombre`, `nit`, `correo`, `genero`) VALUES
(1, 'Abramo', 100001, 'adahill0@mail.ru', 'm'),
(2, 'Paxon', 100002, 'pgambrell1@walmart.com', 'f'),
(3, 'Codi', 100003, 'cjervois2@joomla.org', 'm'),
(4, 'Margaretha', 100004, 'mfawdrey3@indiegogo.com', 'f'),
(5, 'Jamie', 100005, 'jbrosi4@redcross.org', 'f'),
(6, 'Giles', 100006, 'gcraydon5@surveymonkey.com', 'm'),
(7, 'Joye', 100007, 'jgrange6@disqus.com', 'm'),
(8, 'Amos', 100008, 'arulf7@ow.ly', 'f'),
(9, 'Karney', 100009, 'kfilyukov8@elpais.com', 'm'),
(10, 'Tasia', 100010, 'tmiklem9@seattletimes.com', 'f'),
(11, 'Adham', 100011, 'afoyea@a8.net', 'm'),
(12, 'Stephannie', 100012, 'sdrinnanb@reuters.com', 'm'),
(13, 'Steve', 100013, 'sstillyc@auda.org.au', 'f'),
(14, 'Anabel', 100014, 'ashoweringd@list-manage.com', 'f'),
(15, 'Mignon', 100015, 'mpatmoree@prnewswire.com', 'm'),
(16, 'Madelena', 100016, 'mtimmisf@stanford.edu', 'f'),
(17, 'Guillermo', 100017, 'gpondg@blogspot.com', 'f'),
(18, 'Marijo', 100018, 'mvardieh@dailymotion.com', 'm'),
(19, 'Zora', 100019, 'zbinesteadi@hhs.gov', 'm'),
(20, 'Tamra', 100020, 'tcotterellj@abc.net.au', 'f'),
(21, 'Helen', 100021, 'hsedenk@engadget.com', 'm'),
(22, 'Goldy', 100022, 'gbettlesonl@about.me', 'f'),
(23, 'Leila', 100023, 'ledworthyem@hibu.com', 'm'),
(24, 'Allx', 100024, 'abaudoun@aol.com', 'm'),
(25, 'Everett', 100025, 'ekunzeo@nba.com', 'f'),
(26, 'Ruthi', 100026, 'rsumblerp@shareasale.com', 'm'),
(27, 'Karlens', 100027, 'kdenizetq@loc.gov', 'm'),
(28, 'Rachel', 100028, 'rfurlowr@examiner.com', 'm'),
(29, 'Junia', 100029, 'jgrovess@va.gov', 'm'),
(30, 'Caprice', 100030, 'cthoulesst@bloglines.com', 'm'),
(31, 'Kass', 100031, 'klambdeanu@dion.ne.jp', 'm'),
(32, 'Cleveland', 100032, 'cscreechv@tinyurl.com', 'f'),
(33, 'Ludwig', 100033, 'lirnysw@unicef.org', 'f'),
(34, 'Remy', 100034, 'rbauducciox@geocities.jp', 'm'),
(35, 'Kathi', 100035, 'ksnelley@google.it', 'm'),
(36, 'Erny', 100036, 'efassumz@cisco.com', 'm'),
(37, 'Barry', 100037, 'bpenberthy10@nsw.gov.au', 'm'),
(38, 'Ryan', 100038, 'rbrunone11@harvard.edu', 'm'),
(39, 'Korie', 100039, 'klies12@t.co', 'f'),
(40, 'Darbie', 100040, 'ddibartolomeo13@bloglines.com', 'm'),
(41, 'Galen', 100041, 'gfranciskiewicz14@myspace.com', 'm'),
(42, 'Obidiah', 100042, 'ocurtiss15@usa.gov', 'm'),
(43, 'Errol', 100043, 'emessam16@cdbaby.com', 'm'),
(44, 'Demetris', 100044, 'ddeal17@vistaprint.com', 'm'),
(45, 'Ahmad', 100045, 'aitzig18@mapquest.com', 'm'),
(46, 'Rodrique', 100046, 'rhawksby19@odnoklassniki.ru', 'm'),
(47, 'Woodie', 100047, 'wpotapczuk1a@blinklist.com', 'f'),
(48, 'Kattie', 100048, 'krunnalls1b@unblog.fr', 'm'),
(49, 'Breena', 100049, 'bmiltonwhite1c@seattletimes.com', 'm'),
(50, 'Jere', 100050, 'jseamon1d@slideshare.net', 'f'),
(51, 'Eveline', 100051, 'eomarkey1e@ask.com', 'f');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `codigo` int(3) NOT NULL,
  `nombre` varchar(70) NOT NULL,
  `descripcion` varchar(70) NOT NULL,
  `cantidad` int(6) NOT NULL,
  `precio` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`codigo`, `nombre`, `descripcion`, `cantidad`, `precio`) VALUES
(1, 'Energy Drink', 'Cremin and Sons', 36, 291),
(2, 'Oil - Grapeseed Oil', 'Bednar, King and Kilback', 94, 698),
(3, 'Tuna - Salad Premix', 'Green and Sons', 44, 693),
(4, 'Pails With Lids', 'Jakubowski-Kling', 37, 906),
(5, 'Sparkling Wine - Rose, Freixenet', 'Schowalter-Morissette', 46, 443),
(6, 'Milk - Skim', 'Graham, Miller and Weissnat', 100, 260),
(7, 'Herb Du Provence - Primerba', 'Emard, Haag and Larkin', 39, 100),
(8, 'Cookies - Englishbay Wht', 'Keebler, Bogisich and Mann', 56, 622),
(9, 'Coffee Cup 8oz 5338cd', 'Simonis-Mohr', 2, 777),
(10, 'Lettuce - Boston Bib', 'Cremin-Hintz', 11, 987),
(11, 'Noodles - Cellophane, Thin', 'Skiles, Block and Konopelski', 66, 571),
(12, 'Mushroom - King Eryingii', 'Kilback, Goyette and Padberg', 64, 6),
(13, 'Tortillas - Flour, 8', 'Mohr and Sons', 38, 775),
(14, 'Chevere Logs', 'Macejkovic, Heathcote and Keeling', 37, 402),
(15, 'Tea - Decaf Lipton', 'Ledner-Abshire', 2, 364),
(16, 'Lettuce - Iceberg', 'Osinski-Runolfsdottir', 9, 83),
(17, 'Chips Potato Salt Vinegar 43g', 'Mueller, Moen and Kirlin', 41, 979),
(18, 'Mushroom - Oyster, Fresh', 'Hudson-Beahan', 44, 962),
(19, 'Peas - Pigeon, Dry', 'Jakubowski, Morissette and Kulas', 35, 878),
(20, 'Gatorade - Xfactor Berry', 'Kassulke-Hand', 79, 840),
(21, 'Smoked Tongue', 'Haley LLC', 30, 667),
(22, 'Carrots - Mini, Stem On', 'Gislason, Runolfsson and Murazik', 35, 193),
(23, 'Cake - Pancake', 'Barrows Inc', 53, 501),
(24, 'Sauce - Vodka Blush', 'Torp, Howe and Daniel', 30, 382),
(25, 'Rice - Wild', 'Grant-Leffler', 13, 970),
(26, 'Rolled Oats', 'Ward and Sons', 26, 348),
(27, 'Miso - Soy Bean Paste', 'Leffler Inc', 28, 527),
(28, 'Parsley Italian - Fresh', 'McCullough-Trantow', 86, 950),
(29, 'Carroway Seed', 'Cummerata and Sons', 32, 993),
(30, 'Beef - Bresaola', 'Jones LLC', 79, 789),
(31, 'Sausage - Blood Pudding', 'Bailey, Powlowski and Hermiston', 53, 288),
(32, 'Sausage - Blood Pudding', 'Morissette and Sons', 27, 905),
(33, 'Appetizer - Mango Chevre', 'Bruen LLC', 73, 859),
(34, 'Squeeze Bottle', 'Barton and Sons', 27, 692),
(35, 'Ham - Virginia', 'Schowalter-Anderson', 62, 393),
(36, 'Wine - Riesling Dr. Pauly', 'Wyman-Ritchie', 40, 634),
(37, 'Pastrami', 'Kutch, Roberts and Koelpin', 92, 145),
(38, 'Mince Meat - Filling', 'Crooks-Olson', 75, 598),
(39, 'Mushroom - Crimini', 'Lockman, Hansen and Maggio', 20, 973),
(40, 'Cookie Double Choco', 'Ryan LLC', 93, 130),
(41, 'Pear - Packum', 'Ledner Inc', 2, 540),
(42, 'Peach - Halves', 'VonRueden, Langworth and Ebert', 42, 604),
(43, 'Radish - Black, Winter, Organic', 'Stiedemann, Jerde and Kilback', 45, 88),
(44, 'Beets - Candy Cane, Organic', 'Walsh-Walter', 13, 314),
(45, 'Juice - Propel Sport', 'Jast-Bogan', 2, 862),
(46, 'Island Oasis - Banana Daiquiri', 'Kessler Inc', 33, 491),
(47, 'Bread - White, Unsliced', 'Morar, Leuschke and Lehner', 77, 931),
(48, 'Wine - Pinot Noir Stoneleigh', 'Keebler Inc', 83, 635),
(49, 'Cake - Dulce De Leche', 'Daniel-Glover', 15, 348),
(50, 'Bay Leaf Fresh', 'Koelpin Group', 19, 393);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sucursales`
--

CREATE TABLE `sucursales` (
  `codigo` int(4) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` int(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `sucursales`
--

INSERT INTO `sucursales` (`codigo`, `nombre`, `direccion`, `correo`, `telefono`) VALUES
(1, 'Wisoky-Bergnaum', '71818 Meadow Vale Way', 'swoodeson0@imgur.com', 2462328),
(2, 'Douglas-Larson', '044 Independence Alley', 'rmadge1@newyorker.com', 2456609),
(3, 'Metz-Reinger', '279 Larry Lane', 'jitskovitz2@friendfeed.com', 2495630),
(4, 'Kreiger and Sons', '8 Novick Lane', 'eboraston3@apache.org', 2400192),
(5, 'Jaskolski Inc', '333 Bartelt Circle', 'rheinreich4@nsw.gov.au', 2495829),
(6, 'Dickinson-Schoen', '34 Delaware Way', 'afuster5@unblog.fr', 2402859),
(7, 'Hermiston-Brekke', '47391 Rowland Road', 'bsegot6@abc.net.au', 2415390),
(8, 'Schamberger, Shields and Corwin', '9552 Sommers Point', 'ehartburn7@about.me', 2433697),
(9, 'Harvey Group', '3730 Sundown Plaza', 'ctrees8@fema.gov', 2442938),
(10, 'Deckow-Walter', '62 Troy Street', 'jpim9@altervista.org', 2463599),
(11, 'Bednar and Sons', '07 Texas Pass', 'clevisa@linkedin.com', 2452281),
(12, 'McCullough Group', 'bancuber xdxd', 'dtronib@dailymail.co.uk', 2437791),
(13, 'Harris, McKenzie and Hintz', '66403 Morningstar Hill', 'gfoldc@amazonaws.com', 2480766),
(14, 'Volkman-Kuphal', '29 Leroy Alley', 'wdayleyd@tinypic.com', 2467424),
(15, 'Rogahn, Bins and Wintheiser', '80988 Ridgeview Hill', 'fjanoute@ycombinator.com', 2414941),
(16, 'Collier-Kulas', '86 Heath Plaza', 'jyounglovef@nymag.com', 2446769),
(17, 'Johnston and Sons', '0261 Nancy Trail', 'pharlingg@tinypic.com', 2479013),
(18, 'Macejkovic-VonRueden', '09 Lillian Hill', 'mespinhah@jiathis.com', 2429016),
(19, 'Bailey Group', '3586 Amoth Crossing', 'wgerriti@bloomberg.com', 2495423),
(20, 'Shields-Dickens', '64597 Walton Center', 'lwishamj@google.com.au', 2480490),
(21, 'Mayer, Roob and Wiza', '0 Manitowish Way', 'pbernardeschik@dion.ne.jp', 2421944),
(22, 'O\'Reilly LLC', '516 Forest Dale Crossing', 'sbirkinshawl@geocities.jp', 2498929),
(23, 'Stokes-Aufderhar', '8370 Texas Hill', 'mpykem@clickbank.net', 2460801),
(24, 'Hettinger-Erdman', '400 Pankratz Circle', 'pciobutaron@virginia.edu', 2489219),
(25, 'Schinner and Sons', '6114 Marquette Trail', 'ciacoboo@studiopress.com', 2451359),
(26, 'Abshire and Sons', '76776 Service Avenue', 'hwillersonp@list-manage.com', 2471588),
(27, 'Kautzer, Parker and Parker', '3 Thompson Avenue', 'jbalsdoneq@cornell.edu', 2422883),
(28, 'Greenfelder-Gerhold', '63383 Stoughton Terrace', 'ialdenr@omniture.com', 2415828),
(29, 'Daniel Group', '792 Golf Court', 'sbailes@bloglovin.com', 2400128),
(30, 'Waelchi, Johnston and King', '07014 Pepper Wood Terrace', 'kroskellyt@icq.com', 2473716),
(31, 'Weimann-Gutmann', '4815 Florence Way', 'avinnicombeu@nps.gov', 2421796),
(32, 'Runte-Jacobs', '98 Oxford Pass', 'bdumbletonv@amazon.com', 2413952),
(33, 'Gutmann LLC', '71 Bultman Place', 'bsawneyw@mozilla.org', 2402369),
(34, 'Harris-Heaney', '6 Leroy Alley', 'eocarranx@facebook.com', 2464910),
(35, 'Dach LLC', '5736 Chive Lane', 'ccurtissy@google.de', 2477835),
(36, 'Bogisich, Torphy and Lakin', '37 Service Avenue', 'blauxmannz@prweb.com', 2472322),
(37, 'Kuhn, Douglas and Davis', '20 Lotheville Court', 'erenachowski10@networkadvertising.org', 2489525),
(40, 'Reilly, Hansen and DuBuque', '6282 Swallow Parkway', 'goscollee13@xinhuanet.com', 2491745);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedores`
--

CREATE TABLE `vendedores` (
  `codigo` int(5) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `caja` int(5) NOT NULL,
  `ventas` int(100) NOT NULL,
  `genero` varchar(5) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vendedores`
--

INSERT INTO `vendedores` (`codigo`, `nombre`, `caja`, `ventas`, `genero`, `password`) VALUES
(1, 'Katrinka', 101, 0, 'm', 'af579a200b74797b3e78822bf28c2985'),
(2, 'Katleen', 102, 0, 'm', 'e3699d375ded04880e3166dc55f89fde'),
(3, 'Felizio', 103, 0, 'm', '379094cd2c69562f8b8305439b49a613'),
(4, 'Arnie', 104, 0, 'f', '808cb3e29688a78c56610d2a457e5ee4'),
(5, 'Edwin', 105, 0, 'f', '4a562ffc4813726d83d0acdd854fc87d'),
(6, 'Laurens', 106, 0, 'f', '1a7417ff18ee9bfe6f04233dd7ec6908'),
(7, 'Allianora', 107, 0, 'm', '3910f2c2fc6b5bce7ed4d739ae576928'),
(8, 'Johnnie', 108, 0, 'f', 'e1d6c5af6076cb6f1d21833b017f7acf'),
(9, 'Kala', 109, 0, 'm', '08621114b828e2910eb45cc0f1d5c11e'),
(10, 'Terrijo', 110, 0, 'm', '5713177c9d4678186b4f52fc58adfca7'),
(11, 'Broderick', 111, 0, 'f', 'f00c4e0dbd8e53f198d650fc877d51c5'),
(12, 'Junia', 112, 0, 'm', '8623116fdaf6cec4a6f34cfdf33e8875'),
(13, 'Myrah', 113, 0, 'm', 'e6ce0d8beebbcb4a35ceeb81d0fa993a'),
(14, 'Wendeline', 114, 0, 'm', 'bebbd8a4c3b2f1498bf9ccd567e9390c'),
(15, 'Malcolm', 115, 0, 'm', 'b24449675845d066d0b8b0823c8125e7'),
(16, 'Otis', 116, 0, 'm', 'cc75ca180881baa4d6fa02673e247891'),
(17, 'Sanford', 117, 0, 'm', '47a30d30bcbe2a852751dbcc6f846a48'),
(18, 'Bar', 118, 0, 'm', 'c635b159445bf65eaf68805aafbfe449'),
(19, 'Dulcia', 119, 0, 'm', '971203006ee3988df71c8dce120ed62d'),
(20, 'Lynelle', 120, 0, 'm', 'e380d864596c236b46e7e9297598bd91'),
(21, 'Thane', 121, 0, 'f', '12802dee624dc4382cc761ee16e9049c'),
(22, 'Hadria', 122, 0, 'f', '7b633fbc7a79639ca0ed9e86b3d7b850'),
(23, 'Jeth', 123, 0, 'm', 'dbf829de0fc6d960acf642256df6f1c8'),
(24, 'Ax', 124, 0, 'm', '81bf16e8e61c76f20631f228b5d6401a'),
(25, 'Ray', 125, 0, 'm', '0b618c0b08706e9a9d772681cc2b3dc6'),
(26, 'Saree', 126, 0, 'f', '658d752708031c70773697d141142449'),
(27, 'Milton', 127, 0, 'f', 'dc5fc071ee4b9ba79be9bea97caddd07'),
(28, 'Brietta', 128, 0, 'm', '3a7297da824766aa2c82ec069f26a010'),
(29, 'Edgardo', 129, 0, 'm', 'd3a54d3e32661d11afa91973eef2722d'),
(30, 'Celle', 130, 0, 'f', '90f2c3b376c855119f2811c7b6dee4b8'),
(31, 'Vonni', 131, 0, 'f', '537a4aa90cb5d278383dc20480b50ff3'),
(32, 'Audry', 132, 0, 'f', '1b12e7f99a35c37335faa6e5741f5c90'),
(33, 'Quintus', 133, 0, 'm', '4047a9a71734daf75cb41224bbbc1a19'),
(34, 'Jammie', 134, 0, 'f', '3ec9f4dfec574f3f635d732154039a6c'),
(35, 'Sigismondo', 135, 0, 'm', 'da1355be7bdc9425517ad8538a482f46'),
(36, 'Woodrow', 136, 0, 'f', 'c2eb78603e380ffcbf0497769bc98dc3'),
(37, 'Armand', 137, 0, 'm', '355051380edb5c9244f554838c9f4a89'),
(38, 'Carce', 138, 0, 'm', '78a95632af796ae18e14fcf1fdd11d66'),
(39, 'Damaris', 139, 0, 'm', 'e53a099f23001a619d25b2a9b599f959'),
(40, 'Libbi', 140, 0, 'm', 'd9cf17bb063d02833d29ff57b758b390'),
(41, 'Graham', 141, 0, 'f', '3aff260ed01bffcba608c6c257ff00d0'),
(42, 'Ollie', 142, 0, 'f', '3783fae4fdd6a76d89d0b5447005e398'),
(43, 'Beilul', 143, 0, 'f', '9a6975c26306024b52ef9bdc424d3762'),
(44, 'Carolee', 144, 0, 'm', 'ae4aa109f05d219f8bd850bf9935804f'),
(45, 'Valery', 145, 0, 'm', '4c34647a7ed1a7b28cc562ab6dd20462'),
(46, 'Alicia', 146, 0, 'm', '9c5708196bbd77fe1ba8537c4f10549f'),
(47, 'Selle', 147, 0, 'f', '4938e4734869370fff8d8bc45b5724ab'),
(49, 'Loni', 149, 0, 'm', '8cb0fa8a996dcc419d26ff6ce93d930d');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `codigo` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `codigo` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT de la tabla `sucursales`
--
ALTER TABLE `sucursales`
  MODIFY `codigo` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `vendedores`
--
ALTER TABLE `vendedores`
  MODIFY `codigo` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
