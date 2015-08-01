CREATE DATABASE `xy-inc` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `poi` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `coordenadaX` int(11) DEFAULT NULL,
  `coordenadaY` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

INSERT INTO `xy-inc`.`poi`
(`nome`,
`coordenadaX`,
`coordenadaY`)
VALUES
("Lanchonete",27,12),
("Posto",31,18),
("Joalheria",15,12),
("Floricultura",19,21),
("Pub",12,8),
("Supermercado",23,6),
("Churrascaria",28,2);

