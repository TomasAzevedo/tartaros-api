-- -----------------------------------------------------
-- Table `tartaros`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `telefone` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(85) NULL COMMENT '',
  `cpf` VARCHAR(45) NULL COMMENT '',
  `data_nascimento` DATETIME NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tartaros`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `bairro` VARCHAR(45) NULL COMMENT '',
  `Rua` VARCHAR(100) NULL COMMENT '',
  `numero` VARCHAR(25) NULL COMMENT '',
  `complemento` VARCHAR(45) NULL COMMENT '',
  `cep` VARCHAR(10) NULL COMMENT '',
  `referencia` VARCHAR(200) NULL COMMENT '',
  `cidade` VARCHAR(100) NULL COMMENT '',
  `uf` VARCHAR(2) NULL COMMENT '',
  `id_cliente` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `cliente_idx` (`id_cliente` ASC)  COMMENT '',
  CONSTRAINT `cliente_endereco`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `tartaros`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


INSERT INTO `cliente` VALUES (2,'Tomás Azevedo','99874-9751','tomas.az@gmail.com','116.121.037-74', NULL),
                             (3,'Nara Natal','99810-3838','narinha.az@gmail.com','116.121.037-74', NULL),
                             (5,'Flávia Azevedo','99999-99999','flavia@gmail.com','999.999.999-99', NULL),
                             (6,'João Bosco','99999-99999','joao@gmail.com','999.999.999-99', NULL),
                             (9,'Felipe Ribeiro','(21) 9714-28115','feliperibeiro_RJ@hotmail.com',NULL, NULL),
                             (10,'ana cristiba','(21) 9959-29942',NULL,NULL,NULL),
                             (11,'valquiria','(21) 9884-05709',NULL,NULL,NULL),
                             (12,'Mariana','(21) 9976-41138','',NULL,NULL),
                             (13,'Juliana','(21) 9670-02903',NULL,NULL,NULL),
                             (14,'Paula','(21) 3268-5118',NULL,NULL,NULL),
                             (15,'Carolina','(21) 3627-0770',NULL,NULL,NULL),
                             (16,'Luiz Felipe','(21) 9987-58853',NULL,NULL,NULL),
                             (17,'maria clara','(21) 9812-06671',NULL,NULL,NULL),
                             (18,'Carmem costa ','(21) 3899-1814',NULL,NULL,NULL),
                             (19,'robert','(21) 9969-81031',NULL,NULL,NULL),
                             (20,'gisele','(21) 9992-55367',NULL,NULL,NULL),
                             (21,'lilian','(21) 9641-48383',NULL,NULL,NULL),
                             (22,'fernanda ','(21) 2235-4301',NULL,NULL,NULL),
                             (23,'Renata','(21) 9927-58991',NULL,NULL,NULL),
                             (24,'Tales','(21) 2238-5722',NULL,NULL,NULL),
                             (25,'André','(21) 9881-76544',NULL,NULL,NULL),
                             (26,'Fred','(21) 9887-93889',NULL,NULL,NULL),
                             (27,'Daniele','(21) 9764-88058',NULL,NULL,NULL),
                             (28,'Lucas','(21) 9858-55311',NULL,NULL,NULL),
                             (29,'Eduardo','(21) 3734-5261',NULL,NULL,NULL),
                             (30,'Tatiana','(21) 9933-32728',NULL,NULL,NULL),
                             (31,'Daniele','(21) 9764-88058',NULL,NULL,NULL);


INSERT INTO `endereco` VALUES (2,'Copacabana','Rua Domingos Ferreira','95','302','22050-011',NULL,'Rio de Janeiro','RJ',2),
                              (3,'Copacabana','Rua Domingos Ferreira','95','302','22050-011',NULL,'Rio de Janeiro','RJ',3),
                              (5,'Grajaú','Rua Grajaú','2','305','20561-011',NULL,'Rio de Janeiro','RJ',5),
                              (6,'Grajaú','Rua Gurupi','70','501','20561-100',NULL,'Rio de Janeiro','RJ',6),
                              (9,'Grajaú','Rua Grajau','2','Apto. 305','20561-146',NULL,'Rio de Janeiro','RJ',9),
                              (10,'Tijuca','Rua Carvalho Alvim','125','apto.403',NULL,NULL,'Rio de Janeiro','RJ',10),
                              (11,'Tijuca','Rua Barão de Itapagipe','448','apto. 201',NULL,NULL,'Rio de Janeiro','RJ',11),
                              (12,'Grajaú','Rua Jose Vicente','50','Apto. 603',NULL,NULL,'Rio de janeiro','RJ',12),
                              (13,'Tijuca','Rua Juparanã','53','Bl. A Apto. 301',NULL,NULL,'Rio de Janeiro','RJ',13),
                              (14,'Grajaú','Rua Grajaú','40','apto. 101',NULL,NULL,'Rio de Janeiro','RJ',14),
                              (15,'Grajaú','Rua Marechal Jofre','110','apto. 301',NULL,NULL,'Rio de Janeiro','RJ',15),
                              (16,'Tijuca','Rua Carvalho Alvim','499','Apto.103',NULL,NULL,'Rio de Janeiro','RJ',16),
                              (17,'Tijuca','Rua Moura Brito','209','505',NULL,NULL,NULL,NULL,17),
                              (18,'Tijuca','Rua Visconde de Cabo Frio','53','201',NULL,NULL,NULL,NULL,18),
                              (19,'Tijuca','Rua Carvalho Alvim','654','504  bl-b',NULL,NULL,NULL,NULL,19),
                              (20,NULL,'Rua Ju Parana','53','403',NULL,NULL,NULL,NULL,20),
                              (21,'Vila Isabel','Av. 28 de setembro','172','101',NULL,NULL,NULL,NULL,21),
                              (22,NULL,'Rua Farias Brito','8','303',NULL,NULL,NULL,NULL,22),
                              (23,'Tijuca','Rua Félix da Cunha','10','apto. 302','22620171',NULL,'Rio de Janeiro','RJ',23),
                              (24,'Andaraí','Rua Paula Brito','305','Apto. 101','22620171',NULL,'Rio de Janeiro','RJ',24),
                              (25,'Andaraí','Rua Ferreira Pontes','430','Bl. 3 Apto. 901','22620171',NULL,'Rio de Janeiro','RJ',25),
                              (26,'Andaraí','Travessa Sá Albuquerque','25','Casa','22620171',NULL,'Rio de Janeiro','RJ',26),
                              (27,'Andaraí','Gastão Penalva','43','Apto. 401','22620171',NULL,'Rio de Janeiro','RJ',27),
                              (28,'Tijuca','Rua General Roca','408','Apto. 303','22620171',NULL,'Rio de Janeiro','RJ',28),
                              (29,'Grajaú','Rua Canavieiras','700','Apto. 601','22620171',NULL,'Rio de Janeiro','RJ',29),
                              (30,'Maracanâ','Rua Visconde de Itamarati','60','apto.201','22620171',NULL,'Rio de Janeiro','RJ',30),
                              (31,'Andaraí','Rua Gastão Penalva','43','Apto. 401','22620171',NULL,'Rio de Janeiro','RJ',31);


