-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema crypto_basket
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema crypto_basket
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crypto_basket` DEFAULT CHARACTER SET utf8 ;
USE `crypto_basket` ;

-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_meta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_meta` (
  `cryptoId` INT(11) NOT NULL AUTO_INCREMENT,
  `nameId` VARCHAR(100) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `symbol` VARCHAR(20) NOT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`cryptoId`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_ticker_history_day`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_ticker_history_day` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameId` VARCHAR(100) NULL DEFAULT NULL,
  `rank` INT(11) NULL DEFAULT NULL,
  `priceUSD` DECIMAL(18,10) NULL DEFAULT NULL,
  `priceBTC` DECIMAL(13,10) NULL DEFAULT NULL,
  `volume24hUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `marketCapUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `availableSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `totalSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `percentChange1h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange24h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange7d` DECIMAL(8,3) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_ticker_history_hour`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_ticker_history_hour` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameId` VARCHAR(100) NULL DEFAULT NULL,
  `rank` INT(11) NULL DEFAULT NULL,
  `priceUSD` DECIMAL(18,10) NULL DEFAULT NULL,
  `priceBTC` DECIMAL(13,10) NULL DEFAULT NULL,
  `volume24hUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `marketCapUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `availableSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `totalSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `percentChange1h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange24h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange7d` DECIMAL(8,3) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `name_index` (`nameId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_ticker_history_min`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_ticker_history_min` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameId` VARCHAR(100) NULL DEFAULT NULL,
  `rank` INT(11) NULL DEFAULT NULL,
  `priceUSD` DECIMAL(18,10) NULL DEFAULT NULL,
  `priceBTC` DECIMAL(13,10) NULL DEFAULT NULL,
  `volume24hUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `marketCapUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `availableSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `totalSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `percentChange1h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange24h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange7d` DECIMAL(8,3) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `name_index` (`nameId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_ticker_history_month`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_ticker_history_month` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameId` VARCHAR(100) NULL DEFAULT NULL,
  `rank` INT(11) NULL DEFAULT NULL,
  `priceUSD` DECIMAL(18,10) NULL DEFAULT NULL,
  `priceBTC` DECIMAL(13,10) NULL DEFAULT NULL,
  `volume24hUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `marketCapUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `availableSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `totalSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `percentChange1h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange24h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange7d` DECIMAL(8,3) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `name_index` (`nameId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_ticker_latest`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_ticker_latest` (
  `id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameId` VARCHAR(100) NULL DEFAULT NULL,
  `rank` INT(11) NULL DEFAULT NULL,
  `priceUSD` DECIMAL(18,10) NULL DEFAULT NULL,
  `priceBTC` DECIMAL(13,10) NULL DEFAULT NULL,
  `volume24hUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `marketCapUSD` DECIMAL(17,2) NULL DEFAULT NULL,
  `availableSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `totalSupply` DECIMAL(15,0) NULL DEFAULT NULL,
  `percentChange1h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange24h` DECIMAL(8,3) NULL DEFAULT NULL,
  `percentChange7d` DECIMAL(8,3) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `name_index` (`nameId` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_user` (
  `userId` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `email` VARCHAR(100) NULL DEFAULT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `crypto_basket`.`crypto_user_asset`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crypto_basket`.`crypto_user_asset` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NULL DEFAULT NULL,
  `cryptoId` INT(11) NULL DEFAULT NULL,
  `amount` DECIMAL(18,8) NULL DEFAULT NULL,
  `costUSD` DECIMAL(12,2) NULL DEFAULT NULL,
  `createTime` TIMESTAMP NULL DEFAULT NULL,
  `modifyTime` TIMESTAMP NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_fk_idx` (`userId` ASC),
  INDEX `crypto_fk_idx` (`cryptoId` ASC),
  CONSTRAINT `crypto_fk`
    FOREIGN KEY (`cryptoId`)
    REFERENCES `crypto_basket`.`crypto_meta` (`cryptoId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_fk`
    FOREIGN KEY (`userId`)
    REFERENCES `crypto_basket`.`crypto_user` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
