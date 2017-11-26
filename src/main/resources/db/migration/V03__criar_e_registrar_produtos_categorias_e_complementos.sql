-- -----------------------------------------------------
-- Table `tartaros`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`categoria` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

INSERT INTO `tartaros`.`categoria` (`id`, `nome`) VALUES ('1', 'Lanches');
INSERT INTO `tartaros`.`categoria` (`id`, `nome`) VALUES ('2', 'Bebidas');
INSERT INTO `tartaros`.`categoria` (`id`, `nome`) VALUES ('3', 'Sobremesas');

-- -----------------------------------------------------
-- Table `tartaros`.`produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`produto` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(500) NULL COMMENT '',
  `valor` DECIMAL NULL COMMENT '',
  `em_falta` TINYINT(1) NULL COMMENT '',
  `id_categoria` INT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `produto_categoria_idx` (`id_categoria` ASC)  COMMENT '',
  CONSTRAINT `produto_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `tartaros`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('1', 'Tartaros Costela', '180g de costela bovina, queijo cheddar, alho torrado, salada de agrião fresco, molho barbecue mais um molho a escolha no pão de abóbora.', '20.0', '0', '1');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('2', 'Costela Duplo', '180g de costela bovina, queijo cheddar, alho torrado, salada de agrião fresco, molho barbecue mais um molho a escolha no pão de abóbora. + 1 carne de costela bovina 180gr + acompanhamentos em dobro.', '28.0', '0', '1');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('3', 'Tártaros Gorgonzola', '160g de carne bovina, creme de gorgonzola, cebolas caramelizadas e mais um molho a escolha no pão australiano.', '20.0', '0', '1');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('4', 'Tártaros Gorgonzola Duplo', '160g de carne bovina, creme de gorgonzola, cebolas caramelizadas e mais um molho a escolha no pão australiano.+ 1 carne bovina 160gr + acompanhamentos em dobro. ', '28.0', '0', '1');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('5', 'Tártaros Cogumelo', '160g de carne bovina, queijo mussarela, champignon reduzido no shoyo, molho barbecue e mais um molho a escolha no pão australiano.', '18.0', '0', '1');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('6', 'Tártaros Cogumelo Duplo', '160g de carne bovina, queijo mussarela, champignon reduzido no shoyo, molho barbecue e mais um molho a escolha no pão australiano. + 1 carne bovina 160gr + acompanhamentos em dobro.', '26.0', '0', '1');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('7', 'Cerveja Artesanal American Ipa - ', '500ml (6,8 vol. alc.)', '22.0', '0', '2');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `descricao`, `valor`, `em_falta`, `id_categoria`) VALUES ('8', 'Mate', '300ml', '5.0', '0', '2');
INSERT INTO `tartaros`.`produto` (`id`, `nome`, `valor`, `em_falta`, `id_categoria`) VALUES ('9', 'Luck Brownie - Tradicional', '5.0', '0', '3');


CREATE TABLE IF NOT EXISTS `tartaros`.`tipo_complemento` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;

INSERT INTO `tartaros`.`tipo_complemento` (`id`, `nome`) VALUES ('1', 'Molho');
INSERT INTO `tartaros`.`tipo_complemento` (`id`, `nome`) VALUES ('2', 'Adicional');

-- -----------------------------------------------------
-- Table `tartaros`.`complemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`complemento` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(400) NULL COMMENT '',
  `valor` DECIMAL NULL COMMENT '',
  `id_tipo_complemento` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `tipo_complemento_idx` (`id_tipo_complemento` ASC)  COMMENT '',
  CONSTRAINT `tipo_complemento`
    FOREIGN KEY (`id_tipo_complemento`)
    REFERENCES `tartaros`.`tipo_complemento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `tartaros`.`complemento` (`id`, `nome`, `valor`, `id_tipo_complemento`) VALUES ('1', 'Maionese Temperada', '0', '1');
INSERT INTO `tartaros`.`complemento` (`id`, `nome`, `valor`, `id_tipo_complemento`) VALUES ('2', 'Ketchup de Goiabada', '0', '1');
INSERT INTO `tartaros`.`complemento` (`id`, `nome`, `valor`, `id_tipo_complemento`) VALUES ('3', 'Mostarda de Manga', '0', '1');
INSERT INTO `tartaros`.`complemento` (`id`, `nome`, `valor`, `id_tipo_complemento`) VALUES ('4', 'Barbecue', '0', '1');
INSERT INTO `tartaros`.`complemento` (`id`, `nome`, `valor`, `id_tipo_complemento`) VALUES ('5', 'Bacon', '2', '2');

-- -----------------------------------------------------
-- Table `tartaros`.`produto_complemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`produto_complemento` (
  `id_produto` INT NOT NULL COMMENT '',
  `id_complemento` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_produto`, `id_complemento`)  COMMENT '',
  INDEX `compl_idx` (`id_complemento` ASC)  COMMENT '',
  CONSTRAINT `prod`
    FOREIGN KEY (`id_produto`)
    REFERENCES `tartaros`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `compl`
    FOREIGN KEY (`id_complemento`)
    REFERENCES `tartaros`.`complemento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('1', '1');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('1', '2');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('1', '3');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('1', '4');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('1', '5');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('2', '1');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('2', '2');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('2', '3');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('2', '4');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('2', '5');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('3', '1');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('3', '2');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('3', '3');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('3', '4');
INSERT INTO `tartaros`.`produto_complemento` (`id_produto`, `id_complemento`) VALUES ('3', '5');


