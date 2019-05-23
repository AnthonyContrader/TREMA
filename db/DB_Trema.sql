-- MySQL Script generated by MySQL Workbench
-- Thu May 23 14:17:22 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema trema
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema trema
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS `trema` DEFAULT CHARACTER SET utf8mb4 ;
USE `trema` ;

-- -----------------------------------------------------
-- Table `trema`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trema`.`user` (
  `iduser` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `usertype` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trema`.`humanresource`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trema`.`humanresource` (
  `idHR` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `surname` VARCHAR(45) NULL,
  `user_iduser` INT NOT NULL,
  PRIMARY KEY (`idHR`),
  INDEX `fk_HumanResource_User1_idx` (`user_iduser` ASC) VISIBLE,
  CONSTRAINT `fk_HumanResource_User1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `trema`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `trema`.`material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `trema`.`material` (
  `idmaterial` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NULL,
  `humanresource_idHR` INT(11) NOT NULL,
  PRIMARY KEY (`idmaterial`),
  INDEX `fk_Material_HumanResource1_idx` (`humanresource_idHR` ASC) VISIBLE,
  CONSTRAINT `fk_Material_HumanResource1`
    FOREIGN KEY (`humanresource_idHR`)
    REFERENCES `trema`.`humanresource` (`idHR`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
