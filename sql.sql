SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estado` (
  `est_id` INT NOT NULL,
  `est_uf` VARCHAR(45) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = euckr;


-- -----------------------------------------------------
-- Table `mydb`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`cidade` (
  `cid_id` INT NOT NULL,
  `cid_est-ID` INT NOT NULL,
  `cid_nome` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`cid_id`),
  INDEX `fk_cidade_estado_idx` (`cid_est-ID` ASC),
  CONSTRAINT `fk_cidade_estado`
    FOREIGN KEY (`cid_est-ID`)
    REFERENCES `mydb`.`estado` (`est_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Pessoa` (
  `ps_id` INT NOT NULL AUTO_INCREMENT,
  `ps_nome` VARCHAR(150) NOT NULL,
  `ps_datanascimento` VARCHAR(12) NOT NULL,
  `ps_logradouro` VARCHAR(100) NOT NULL,
  `ps_numero` VARCHAR(10) NOT NULL,
  `ps_bairro` VARCHAR(35) NOT NULL,
  `ps_cep` VARCHAR(10) NOT NULL,
  `ps_cid_id` INT NOT NULL,
  `ps_email_prima` VARCHAR(100) NOT NULL,
  `ps_email_segun` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ps_id`),
  INDEX `fk_pessoa_cidade1_idx` (`ps_cid_id` ASC),
  CONSTRAINT `fk_pessoa_cidade1`
    FOREIGN KEY (`ps_cid_id`)
    REFERENCES `mydb`.`cidade` (`cid_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PessoaFisica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PessoaFisica` (
  `Pessoa_ps_id` INT NOT NULL,
  `psf_cpf` VARCHAR(16) NOT NULL,
  `psf_rg` VARCHAR(16) NOT NULL,
  `psf_sexo` VARCHAR(20) NOT NULL,
  INDEX `fk_PessoaFisica_Pessoa1_idx` (`Pessoa_ps_id` ASC),
  CONSTRAINT `fk_PessoaFisica_Pessoa1`
    FOREIGN KEY (`Pessoa_ps_id`)
    REFERENCES `mydb`.`Pessoa` (`ps_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PessoaJuridica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PessoaJuridica` (
  `Pessoa_ps_id` INT NOT NULL,
  `pfj_cnpj` VARCHAR(45) NOT NULL,
  `pdj_iestadual` VARCHAR(100) NOT NULL,
  `pdj_imunicipal` VARCHAR(100) NOT NULL,
  `pdj_nfantasia` VARCHAR(100) NOT NULL,
  INDEX `fk_Pessoajuridica_Pessoa1_idx` (`Pessoa_ps_id` ASC),
  CONSTRAINT `fk_Pessoajuridica_Pessoa1`
    FOREIGN KEY (`Pessoa_ps_id`)
    REFERENCES `mydb`.`Pessoa` (`ps_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Telefone` (
  `tel_id` INT NOT NULL,
  `tel_comer` VARCHAR(45) NOT NULL,
  `tel_celu` VARCHAR(45) NOT NULL,
  `Pessoa_ps_id` INT NOT NULL,
  PRIMARY KEY (`tel_id`),
  INDEX `fk_Telefone_Pessoa1_idx` (`Pessoa_ps_id` ASC),
  CONSTRAINT `fk_Telefone_Pessoa1`
    FOREIGN KEY (`Pessoa_ps_id`)
    REFERENCES `mydb`.`Pessoa` (`ps_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
