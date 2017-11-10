
-- -----------------------------------------------------
-- Table `tartaros`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`usuario` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NULL COMMENT '',
  `email` VARCHAR(45) NOT NULL COMMENT '',
  `senha` VARCHAR(500) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tartaros`.`permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`permissao` (
  `id` INT NOT NULL AUTO_INCREMENT COMMENT '',
  `nome` VARCHAR(45) NOT NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tartaros`.`usuario_permissao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tartaros`.`usuario_permissao` (
  `id_usuario` INT NOT NULL COMMENT '',
  `id_permissao` INT NOT NULL COMMENT '',
  PRIMARY KEY (`id_usuario`, `id_permissao`)  COMMENT '',
  INDEX `permissao_idx` (`id_permissao` ASC)  COMMENT '',
  CONSTRAINT `usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `tartaros`.`usuario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `permissao`
    FOREIGN KEY (`id_permissao`)
    REFERENCES `tartaros`.`permissao` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

INSERT INTO usuario (id, nome, email, senha) values (1, 'Administrador', 'admin@tartaroshamburgueria.com.br', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');

INSERT INTO permissao (id, nome) values (1, 'ROLE_CADASTRAR_CLIENTES');
INSERT INTO permissao (id, nome) values (2, 'ROLE_PESQUISAR_CLIENTES');
INSERT INTO permissao (id, nome) values (3, 'ROLE_REMOVER_CLIENTES');

-- admin
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 1);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 2);
INSERT INTO usuario_permissao (id_usuario, id_permissao) values (1, 3);

