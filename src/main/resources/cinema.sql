CREATE DATABASE IF NOT EXISTS `cinema` /*!40100 DEFAULT CHARACTER SET latin1 */;  
USE `cinema`;
  
DROP TABLE IF EXISTS `Session`;
DROP TABLE IF EXISTS `Film`;
DROP TABLE IF EXISTS `Picture`;

CREATE TABLE IF NOT EXISTS `Picture` (
  `idPicture` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fileName` VARCHAR(45) NOT NULL,
  `uploadedName` VARCHAR(45) NOT NULL,
  `width` INT NOT NULL,
  `height` INT NOT NULL,
  PRIMARY KEY (`idPicture`),
  UNIQUE INDEX `idPicture_UNIQUE` (`idPicture` ASC)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `Picture` VALUES(1, "pic1", "pic1.jpg", 200, 200);
INSERT INTO `Picture` VALUES(2, "pic2", "pic2.jpg", 200, 200);
INSERT INTO `Picture` VALUES(3, "pic3", "pic3.jpg", 200, 200);
INSERT INTO `Picture` VALUES(4, "pic4", "pic4.jpg", 200, 200);
INSERT INTO `Picture` VALUES(5, "pic5", "pic5.jpg", 200, 200);

CREATE TABLE IF NOT EXISTS `Film` (
	`idFilm` INT UNSIGNED NOT NULL AUTO_INCREMENT,
    `nameFilm` VARCHAR(45) NOT NULL,
    `duration` TIME NOT NULL,
    `genre` VARCHAR(45) NOT NULL,
    `country` VARCHAR(45) NOT NULL,
    `year` YEAR NOT NULL,
	`idPicture` INT UNSIGNED NOT NULL,
	CONSTRAINT `idPicture` FOREIGN KEY (`idPicture`) REFERENCES `Picture` (`idPicture`) ON UPDATE CASCADE,
    UNIQUE INDEX `idFilm_UNIQUE` (`idFilm` ASC),
	UNIQUE INDEX `nameFilm_UNIQUE` (`nameFilm` ASC),
    PRIMARY KEY (`idFilm`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `Film` VALUES(1, 'ARQ', '01:27:35', 'Fantastic', 'USA', 2016, 1);
INSERT INTO `Film` VALUES(2, 'Beyond Valkyrie', '01:40:34', 'Thriller', 'USA', 2016, 2);
INSERT INTO `Film` VALUES(3, '600 mile', '01:20:28', 'Thriller', 'USA', 2016, 3);
INSERT INTO `Film` VALUES(4, 'День выборов 2', '01:44:28', 'Comedy', 'RUS', 2016, 4);
INSERT INTO `Film` VALUES(5, 'Two man in town', '01:56:28', 'Drama', 'FRA', 2015, 5);

CREATE TABLE IF NOT EXISTS `Session` (
	`idSession` INT UNSIGNED NOT NULL AUTO_INCREMENT,
	`idFilm` INT UNSIGNED NOT NULL,
    `startTime` TIME NOT NULL,
    UNIQUE INDEX `idSession_UNIQUE` (`idSession` ASC),
	CONSTRAINT `idFilm` FOREIGN KEY (`idFilm`) REFERENCES `Film` (`idFilm`) ON DELETE CASCADE ON UPDATE CASCADE,
    PRIMARY KEY (`idSession`)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

INSERT INTO `Session` VALUES(1, 1, '17:00:00');
INSERT INTO `Session` VALUES(2, 2, '13:00:00');
INSERT INTO `Session` VALUES(3, 3, '11:00:00');
INSERT INTO `Session` VALUES(4, 4, '19:00:00');
INSERT INTO `Session` VALUES(5, 5, '14:00:00');

DROP FUNCTION IF EXISTS SPLIT_STRING;

DELIMITER $

CREATE FUNCTION 
   SPLIT_STRING ( s VARCHAR(1024) , del CHAR(1) , i INT)
   RETURNS VARCHAR(1024)
   DETERMINISTIC -- always returns same results for same input parameters
    BEGIN

        DECLARE n INT ;

        -- get max number of items
        SET n = LENGTH(s) - LENGTH(REPLACE(s, del, '')) + 1;

        IF i > n THEN
            RETURN NULL ;
        ELSE
            RETURN SUBSTRING_INDEX(SUBSTRING_INDEX(s, del, i) , del , -1 ) ;        
        END IF;

    END
$

DELIMITER ;

SELECT *
FROM `Film` film
INNER JOIN `Session` sess ON film.idFilm = sess.idFilm
WHERE (film.duration BETWEEN '01:00:00' AND '03:00:00')
		AND film.genre IN(SPLIT_STRING('Fantastic,Thriller',',',1),
						  SPLIT_STRING('Fantastic,Thriller',',',2),
                          SPLIT_STRING('Fantastic,Thriller',',',3),
                          SPLIT_STRING('Fantastic,Thriller',',',4),
                          SPLIT_STRING('Fantastic,Thriller',',',5)) AND film.country = 'USA'
        AND film.year = 2016 AND (sess.startTime > '1:00:00')
