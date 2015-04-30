-- Structure de la table `doubletgenre`

CREATE TABLE IF NOT EXISTS `doubletgenre` (
  `idGenre` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  PRIMARY KEY (`idGenre`,`idUtilisateur`),
  KEY `idGenre_fk` (`idGenre`),
  KEY `idUtilisateur_fk` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `doubletlangue`
--

CREATE TABLE IF NOT EXISTS `doubletlangue` (
  `idUtilisateur` int(11) NOT NULL,
  `idLangue` int(11) NOT NULL,
  PRIMARY KEY (`idUtilisateur`,`idLangue`),
  KEY `idUtilisateur_fk` (`idUtilisateur`),
  KEY `idLangue_fk` (`idLangue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `doubletvote`
--

CREATE TABLE IF NOT EXISTS `doubletvote` (
  `idActivite` int(11) NOT NULL,
  `idUtilisateur` int(11) NOT NULL,
  `valeurVote` tinyint(1) NOT NULL,
  PRIMARY KEY (`idActivite`,`idUtilisateur`),
   KEY `idActivite_fk` (`idActivite`),
  KEY `idUtilisateur_fk` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `genreactivite`
--

CREATE TABLE IF NOT EXISTS `genreactivite` (
  `idGenre` int(11) NOT NULL,
  `nomGenre` varchar(50) NOT NULL,
  PRIMARY KEY (`idGenre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `langues`
--

CREATE TABLE IF NOT EXISTS `langues` (
  `idLangue` int(11) NOT NULL AUTO_INCREMENT,
  `nomLangue` varchar(50) NOT NULL,
  PRIMARY KEY (`idLangue`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `idUtilisateur` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) NOT NULL,
  `pseudo` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sexe` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `regionOrigine` varchar(50) NOT NULL,
  `position` varchar(50) NOT NULL,
  `image` varchar(100) NOT NULL,
  `communication` tinyint(1) NOT NULL,
  PRIMARY KEY (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
-- --------------------------------------------------------

--
-- Structure de la table `activite`
--

CREATE TABLE IF NOT EXISTS `activite` (
  `idActivite` int(11) NOT NULL AUTO_INCREMENT,
  `libelleActivite` varchar(50) NOT NULL,
  `idGenre` int(11) NOT NULL,
  `lieu` varchar(50) NOT NULL,
  `voteOui` int(11) NOT NULL,
  `voteNon` int(11) NOT NULL,
  PRIMARY KEY (`idActivite`,`idGenre`),
  KEY `idGenre` (`idGenre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ;

