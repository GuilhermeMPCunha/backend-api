-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema crud
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema crud
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crud` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `crud` ;

-- -----------------------------------------------------
-- Table `crud`.`flyway_schema_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`flyway_schema_history` (
  `installed_rank` INT NOT NULL,
  `version` VARCHAR(50) NULL DEFAULT NULL,
  `description` VARCHAR(200) NOT NULL,
  `type` VARCHAR(20) NOT NULL,
  `script` VARCHAR(1000) NOT NULL,
  `checksum` INT NULL DEFAULT NULL,
  `installed_by` VARCHAR(100) NOT NULL,
  `installed_on` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` INT NOT NULL,
  `success` TINYINT(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  INDEX `flyway_schema_history_s_idx` (`success` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`tb_cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`tb_cliente` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(8) NOT NULL,
  `cpf` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(150) NOT NULL,
  `num_cartao` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_p41dgdqdjfwm7w24h4eriix6x` (`login` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`tb_pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`tb_pedido` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `data` VARCHAR(255) NULL DEFAULT NULL,
  `numero` VARCHAR(255) NULL DEFAULT NULL,
  `quantidade` INT NOT NULL,
  `status` VARCHAR(255) NULL DEFAULT NULL,
  `total_pedido` FLOAT NOT NULL,
  `cliente_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_rut0ysgkmijaq2d48no48h322` (`numero` ASC) VISIBLE,
  INDEX `FKajo6v90obpung9h40lcain479` (`cliente_id` ASC) VISIBLE,
  CONSTRAINT `FKajo6v90obpung9h40lcain479`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `crud`.`tb_cliente` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`tb_vendedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`tb_vendedor` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(255) NULL DEFAULT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `cnpj` VARCHAR(255) NULL DEFAULT NULL,
  `conta_bancaria` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `nome` VARCHAR(150) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_hf0729cywyk1w6te1gyrjjvq6` (`login` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`tb_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`tb_produto` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(500) NOT NULL,
  `ean` VARCHAR(255) NULL DEFAULT NULL,
  `estoque` INT NULL DEFAULT NULL,
  `nome` VARCHAR(150) NOT NULL,
  `preco` FLOAT NOT NULL,
  `vendedor_id` BIGINT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKko71acawtnmtxppuygwvirdxh` (`vendedor_id` ASC) VISIBLE,
  CONSTRAINT `FKko71acawtnmtxppuygwvirdxh`
    FOREIGN KEY (`vendedor_id`)
    REFERENCES `crud`.`tb_vendedor` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`pedido_produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`pedido_produto` (
  `pedido_id` BIGINT NOT NULL,
  `produto_id` BIGINT NOT NULL,
  INDEX `FKcmm2pu6f7c9yjdi66yr1gni4y` (`produto_id` ASC) VISIBLE,
  INDEX `FK50bp58jehkpcop9igu2n65y0y` (`pedido_id` ASC) VISIBLE,
  CONSTRAINT `FK50bp58jehkpcop9igu2n65y0y`
    FOREIGN KEY (`pedido_id`)
    REFERENCES `crud`.`tb_pedido` (`id`),
  CONSTRAINT `FKcmm2pu6f7c9yjdi66yr1gni4y`
    FOREIGN KEY (`produto_id`)
    REFERENCES `crud`.`tb_produto` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `crud`.`tb_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crud`.`tb_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `login` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(150) NOT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_qht682qvopcx5f41dc2rbs5jf` (`login` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
