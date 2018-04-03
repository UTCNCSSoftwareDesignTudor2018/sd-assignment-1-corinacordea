SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema studentsdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema studentsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentsdb` DEFAULT CHARACTER SET utf8 ;
USE `studentsdb` ;

-- -----------------------------------------------------
-- Table `studentsdb`.`teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`teachers` (
  `idteachers` INT(11) NOT NULL,
  `teachers_name` VARCHAR(45) NULL DEFAULT NULL,
  `teachers_username` VARCHAR(45) NULL DEFAULT NULL,
  `teachers_password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idteachers`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentsdb`.`courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`courses` (
  `idcourses` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `teachers_idteachers` INT(11) NOT NULL,
  PRIMARY KEY (`idcourses`, `teachers_idteachers`),
  INDEX `fk_courses_teachers1_idx` (`teachers_idteachers` ASC),
  CONSTRAINT `fk_courses_teachers1`
    FOREIGN KEY (`teachers_idteachers`)
    REFERENCES `studentsdb`.`teachers` (`idteachers`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentsdb`.`students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`students` (
  `idstudents` INT(11) NOT NULL,
  `students_name` VARCHAR(45) NULL DEFAULT NULL,
  `students_card_number` VARCHAR(45) NULL DEFAULT NULL,
  `students_personal_numerical_code` VARCHAR(45) NULL DEFAULT NULL,
  `students_address` VARCHAR(45) NULL DEFAULT NULL,
  `students_group` VARCHAR(45) NULL DEFAULT NULL,
  `students_username` VARCHAR(45) NULL DEFAULT NULL,
  `students_password` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idstudents`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentsdb`.`exams`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`exams` (
  `idexams` INT(11) NOT NULL,
  `grade` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idexams`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentsdb`.`enrolments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentsdb`.`enrolments` (
  `courses_idcourses` INT(11) NOT NULL,
  `students_idstudents` INT(11) NOT NULL,
  `exams_idexams` INT(11) NOT NULL,
  PRIMARY KEY (`courses_idcourses`, `students_idstudents`, `exams_idexams`),
  INDEX `fk_courses_has_students_students1_idx` (`students_idstudents` ASC),
  INDEX `fk_courses_has_students_courses_idx` (`courses_idcourses` ASC),
  INDEX `fk_enrolments_exams1_idx` (`exams_idexams` ASC),
  CONSTRAINT `fk_courses_has_students_courses`
    FOREIGN KEY (`courses_idcourses`)
    REFERENCES `studentsdb`.`courses` (`idcourses`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_courses_has_students_students1`
    FOREIGN KEY (`students_idstudents`)
    REFERENCES `studentsdb`.`students` (`idstudents`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_enrolments_exams1`
    FOREIGN KEY (`exams_idexams`)
    REFERENCES `studentsdb`.`exams` (`idexams`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
