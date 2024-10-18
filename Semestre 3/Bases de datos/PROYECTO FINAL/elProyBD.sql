-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema torneosfc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema torneosfc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `torneosfc` DEFAULT CHARACTER SET utf8mb4 ;
USE `torneosfc` ;

-- -----------------------------------------------------
-- Table `torneosfc`.`award`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`award` (
  `award_id` INT(11) NOT NULL AUTO_INCREMENT,
  `award_name` VARCHAR(255) NOT NULL,
  `award_description` TEXT NOT NULL,
  `year_introduced` INT(11) NOT NULL,
  PRIMARY KEY (`award_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`player` (
  `player_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `birth_date` DATE NOT NULL,
  `nationality` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`player_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`award_winner`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`award_winner` (
  `award_winner_id` INT(11) NOT NULL AUTO_INCREMENT,
  `player_id` INT(11) NOT NULL,
  `award_id` INT(11) NOT NULL,
  `year` INT(11) NOT NULL,
  PRIMARY KEY (`award_winner_id`, `player_id`, `award_id`),
  INDEX `player_id` (`player_id` ASC) VISIBLE,
  INDEX `award_id` (`award_id` ASC) VISIBLE,
  CONSTRAINT `award_winner_ibfk_1`
    FOREIGN KEY (`player_id`)
    REFERENCES `torneosfc`.`player` (`player_id`),
  CONSTRAINT `award_winner_ibfk_2`
    FOREIGN KEY (`award_id`)
    REFERENCES `torneosfc`.`award` (`award_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`confederation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`confederation` (
  `confederation_id` INT(11) NOT NULL AUTO_INCREMENT,
  `confederation_name` VARCHAR(255) NOT NULL,
  `confederation_code` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`confederation_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`country`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`country` (
  `country_id` INT(11) NOT NULL AUTO_INCREMENT,
  `country_name` VARCHAR(255) NOT NULL,
  `confederation_id` INT(11) NOT NULL,
  PRIMARY KEY (`country_id`, `confederation_id`),
  INDEX `confederation_id` (`confederation_id` ASC) VISIBLE,
  CONSTRAINT `country_ibfk_1`
    FOREIGN KEY (`confederation_id`)
    REFERENCES `torneosfc`.`confederation` (`confederation_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`city`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`city` (
  `city_id` INT(11) NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(255) NOT NULL,
  `country_id` INT(11) NOT NULL,
  PRIMARY KEY (`city_id`, `country_id`),
  INDEX `country_id` (`country_id` ASC) VISIBLE,
  CONSTRAINT `city_ibfk_1`
    FOREIGN KEY (`country_id`)
    REFERENCES `torneosfc`.`country` (`country_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`tournament`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`tournament` (
  `tournament_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tournament_name` VARCHAR(255) NOT NULL,
  `year` INT(11) NOT NULL,
  `host_country` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`tournament_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`stadium`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`stadium` (
  `stadium_id` INT(11) NOT NULL AUTO_INCREMENT,
  `stadium_name` VARCHAR(255) NOT NULL,
  `city_id` INT(11) NOT NULL,
  `capacity` INT(11) NOT NULL,
  PRIMARY KEY (`stadium_id`, `city_id`),
  INDEX `city_id` (`city_id` ASC) VISIBLE,
  CONSTRAINT `stadium_ibfk_1`
    FOREIGN KEY (`city_id`)
    REFERENCES `torneosfc`.`city` (`city_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`team`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`team` (
  `team_id` INT(11) NOT NULL AUTO_INCREMENT,
  `team_name` VARCHAR(255) NOT NULL,
  `confederation_id` INT(11) NOT NULL,
  PRIMARY KEY (`team_id`, `confederation_id`),
  INDEX `confederation_id` (`confederation_id` ASC) VISIBLE,
  CONSTRAINT `team_ibfk_1`
    FOREIGN KEY (`confederation_id`)
    REFERENCES `torneosfc`.`confederation` (`confederation_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`matches`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`matches` (
  `match_id` INT(11) NOT NULL AUTO_INCREMENT,
  `tournament_id` INT(11) NOT NULL,
  `stadium_id` INT(11) NOT NULL,
  `match_date` DATE NOT NULL,
  `home_team_id` INT(11) NOT NULL,
  `away_team_id` INT(11) NOT NULL,
  `score_home_team` INT(11) NOT NULL,
  `score_away_team` INT(11) NOT NULL,
  PRIMARY KEY (`match_id`, `stadium_id`, `home_team_id`, `away_team_id`, `tournament_id`),
  INDEX `tournament_id` (`tournament_id` ASC) VISIBLE,
  INDEX `stadium_id` (`stadium_id` ASC) VISIBLE,
  INDEX `home_team_id` (`home_team_id` ASC) VISIBLE,
  INDEX `away_team_id` (`away_team_id` ASC) VISIBLE,
  CONSTRAINT `matches_ibfk_1`
    FOREIGN KEY (`tournament_id`)
    REFERENCES `torneosfc`.`tournament` (`tournament_id`),
  CONSTRAINT `matches_ibfk_2`
    FOREIGN KEY (`stadium_id`)
    REFERENCES `torneosfc`.`stadium` (`stadium_id`),
  CONSTRAINT `matches_ibfk_3`
    FOREIGN KEY (`home_team_id`)
    REFERENCES `torneosfc`.`team` (`team_id`),
  CONSTRAINT `matches_ibfk_4`
    FOREIGN KEY (`away_team_id`)
    REFERENCES `torneosfc`.`team` (`team_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`goal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`goal` (
  `goal_id` INT(11) NOT NULL AUTO_INCREMENT,
  `match_id` INT(11) NOT NULL,
  `player_id` INT(11) NOT NULL,
  `time_scored` TIME NOT NULL,
  `goal_type` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`goal_id`, `match_id`, `player_id`),
  INDEX `match_id` (`match_id` ASC) VISIBLE,
  INDEX `player_id` (`player_id` ASC) VISIBLE,
  CONSTRAINT `goal_ibfk_1`
    FOREIGN KEY (`match_id`)
    REFERENCES `torneosfc`.`matches` (`match_id`),
  CONSTRAINT `goal_ibfk_2`
    FOREIGN KEY (`player_id`)
    REFERENCES `torneosfc`.`player` (`player_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `torneosfc`.`player_appearance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `torneosfc`.`player_appearance` (
  `appearance_id` INT(11) NOT NULL AUTO_INCREMENT,
  `player_id` INT(11) NOT NULL,
  `match_id` INT(11) NOT NULL,
  `tournament_id` INT(11) NOT NULL,
  `minutes_played` INT(11) NOT NULL,
  `goals_scored` INT(11) NOT NULL,
  `assists` INT(11) NOT NULL,
  `yellow_cards` INT(11) NOT NULL,
  `red_cards` INT(11) NOT NULL,
  PRIMARY KEY (`appearance_id`, `match_id`, `tournament_id`, `player_id`),
  INDEX `player_id` (`player_id` ASC) VISIBLE,
  INDEX `match_id` (`match_id` ASC) VISIBLE,
  INDEX `tournament_id` (`tournament_id` ASC) VISIBLE,
  CONSTRAINT `player_appearance_ibfk_1`
    FOREIGN KEY (`player_id`)
    REFERENCES `torneosfc`.`player` (`player_id`),
  CONSTRAINT `player_appearance_ibfk_2`
    FOREIGN KEY (`match_id`)
    REFERENCES `torneosfc`.`matches` (`match_id`),
  CONSTRAINT `player_appearance_ibfk_3`
    FOREIGN KEY (`tournament_id`)
    REFERENCES `torneosfc`.`tournament` (`tournament_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
