-- -----------------------------------------------------
-- Table `tartaros`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`cliente` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `telefone` VARCHAR(45) NOT NULL COMMENT '',
  `email` VARCHAR(85) NULL COMMENT '',
  `cpf` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tartaros`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`endereco` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `bairro` VARCHAR(45) NULL COMMENT '',
  `rua` VARCHAR(100) NULL COMMENT '',
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


INSERT INTO `cliente` (`id`,`nome`,`telefone`,`email`,`cpf`) VALUES (2,'Tomás Azevedo','99874-9751','tomas.az@gmail.com','116.121.037-74');
INSERT INTO `cliente` (`id`,`nome`,`telefone`,`email`,`cpf`) VALUES (3,'Nara Natal','99810-3838','narinha.az@gmail.com','116.121.037-74');
INSERT INTO `cliente` (`id`,`nome`,`telefone`,`email`,`cpf`) VALUES (4,'Pedro Natal','99810-3838','pedro.az@gmail.com','999.999.999-99');
INSERT INTO `cliente` (`id`,`nome`,`telefone`,`email`,`cpf`) VALUES (5,'Flávia Azevedo','99999-99999','flavia@gmail.com','999.999.999-99');
INSERT INTO `cliente` (`id`,`nome`,`telefone`,`email`,`cpf`) VALUES (6,'João Bosco','99999-99999','joao@gmail.com','999.999.999-99');

INSERT INTO `endereco` (`id`,`bairro`,`rua`,`numero`,`complemento`,`cep`,`referencia`,`cidade`,`uf`,`id_cliente`) VALUES (2,'Copacabana','Rua Domingos Ferreira','95','302','22050-011',NULL,'Rio de Janeiro','RJ',2);
INSERT INTO `endereco` (`id`,`bairro`,`rua`,`numero`,`complemento`,`cep`,`referencia`,`cidade`,`uf`,`id_cliente`) VALUES (3,'Copacabana','Rua Domingos Ferreira','95','302','22050-011',NULL,'Rio de Janeiro','RJ',3);
INSERT INTO `endereco` (`id`,`bairro`,`rua`,`numero`,`complemento`,`cep`,`referencia`,`cidade`,`uf`,`id_cliente`) VALUES (4,'Copacabana','Rua Domingos Ferreira','95','302','22050-011',NULL,'Rio de Janeiro','RJ',4);
INSERT INTO `endereco` (`id`,`bairro`,`rua`,`numero`,`complemento`,`cep`,`referencia`,`cidade`,`uf`,`id_cliente`) VALUES (5,'Grajaú','Rua Grajaú','2','305','20561-011',NULL,'Rio de Janeiro','RJ',5);
INSERT INTO `endereco` (`id`,`bairro`,`rua`,`numero`,`complemento`,`cep`,`referencia`,`cidade`,`uf`,`id_cliente`) VALUES (6,'Grajaú','Rua Gurupi','70','501','20561-100',NULL,'Rio de Janeiro','RJ',6);



