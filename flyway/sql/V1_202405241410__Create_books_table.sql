CREATE TABLE `literature`.`books` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(2000) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
