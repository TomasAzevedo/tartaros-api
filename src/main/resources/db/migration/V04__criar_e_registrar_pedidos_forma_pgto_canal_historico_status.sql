


-- -----------------------------------------------------
-- Table `tartaros`.`forma_pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`forma_pagamento` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `tartaros`.`canal_venda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`canal_venda` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tartaros`.`promocao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`promocao` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  `descricao` VARCHAR(400) NULL COMMENT '',
  `data_inicio` DATE NOT NULL COMMENT '',
  `data_fim` DATE NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tartaros`.`pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`pedido` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `data` DATETIME NOT NULL COMMENT '',
  `valor_itens` DECIMAL NULL COMMENT '',
  `valor_taxa_entrega` DECIMAL NULL COMMENT '',
  `valor_total` DECIMAL NULL COMMENT '',
  `status` VARCHAR(45) NULL COMMENT '',
  `valor_pago` DECIMAL NULL COMMENT '',
  `valor_troco` DECIMAL NULL COMMENT '',
  `observacao` VARCHAR(300) NULL COMMENT '',
  `id_forma_pagamento` INT NULL COMMENT '',
  `id_promocao` INT NULL COMMENT '',
  `id_canal_venda` INT NULL COMMENT '',
  `id_cliente` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `forma_pagamento_idx` (`id_forma_pagamento` ASC)  COMMENT '',
  INDEX `promocao_idx` (`id_promocao` ASC)  COMMENT '',
  INDEX `canal_venda_idx` (`id_canal_venda` ASC)  COMMENT '',
  INDEX `cliente_idx` (`id_cliente` ASC)  COMMENT '',
  CONSTRAINT `forma_pagamento`
    FOREIGN KEY (`id_forma_pagamento`)
    REFERENCES `tartaros`.`forma_pagamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `promocao`
    FOREIGN KEY (`id_promocao`)
    REFERENCES `tartaros`.`promocao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `canal_venda`
    FOREIGN KEY (`id_canal_venda`)
    REFERENCES `tartaros`.`canal_venda` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `cliente_pedido`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `tartaros`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;





-- -----------------------------------------------------
-- Table `tartaros`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valor` DECIMAL NOT NULL COMMENT '',
  `observacao` VARCHAR(300) NULL COMMENT '',
  `id_produto` INT NOT NULL COMMENT '',
  `id_pedido` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `pedido_idx` (`id_pedido` ASC)  COMMENT '',
  INDEX `item_produto_idx` (`id_produto` ASC)  COMMENT '',
  CONSTRAINT `pedido_item`
    FOREIGN KEY (`id_pedido`)
    REFERENCES `tartaros`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `item_produto`
    FOREIGN KEY (`id_produto`)
    REFERENCES `tartaros`.`produto` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `tartaros`.`sub_item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`sub_item` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `valor` DECIMAL NOT NULL COMMENT '',
  `id_complemento` INT NULL COMMENT '',
  `id_item` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `sub_item_item_idx` (`id_item` ASC)  COMMENT '',
  INDEX `sub_item_complemento_idx` (`id_complemento` ASC)  COMMENT '',
  CONSTRAINT `sub_item_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `tartaros`.`item` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `sub_item_complemento`
    FOREIGN KEY (`id_complemento`)
    REFERENCES `tartaros`.`complemento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `tartaros`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`status` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tartaros`.`historico_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`historico_pedido` (
  `id` INT NOT NULL COMMENT '',
  `dataHora` DATETIME NOT NULL COMMENT '',
  `idStatus` INT NOT NULL COMMENT '',
  `idPedido` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '',
  INDEX `status_idx` (`idStatus` ASC)  COMMENT '',
  INDEX `pedido_historico_idx` (`idPedido` ASC)  COMMENT '',
  CONSTRAINT `status`
    FOREIGN KEY (`idStatus`)
    REFERENCES `tartaros`.`status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `pedido_historico`
    FOREIGN KEY (`idPedido`)
    REFERENCES `tartaros`.`pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



INSERT INTO `tartaros`.`forma_pagamento` (`id`, `nome`) VALUES ('1', 'Cartão de Crédito');
INSERT INTO `tartaros`.`forma_pagamento` (`id`, `nome`) VALUES ('2', 'Cartão de Débito');
INSERT INTO `tartaros`.`forma_pagamento` (`id`, `nome`) VALUES ('3', 'Dinheiro');


INSERT INTO `tartaros`.`canal_venda` (`id`, `nome`) VALUES ('1', 'Telefone');
INSERT INTO `tartaros`.`canal_venda` (`id`, `nome`) VALUES ('2', 'Site');
INSERT INTO `tartaros`.`canal_venda` (`id`, `nome`) VALUES ('3', 'iFood');


INSERT INTO `tartaros`.`status` (`id`, `nome`) VALUES ('1', 'Pedido recebido.');
INSERT INTO `tartaros`.`status` (`id`, `nome`) VALUES ('2', 'Pedido sendo preparado.');
INSERT INTO `tartaros`.`status` (`id`, `nome`) VALUES ('3', 'Pedido pronto para entrega.');
INSERT INTO `tartaros`.`status` (`id`, `nome`) VALUES ('4', 'Pedido em transito.');
INSERT INTO `tartaros`.`status` (`id`, `nome`) VALUES ('5', 'Pedido entregue.');





