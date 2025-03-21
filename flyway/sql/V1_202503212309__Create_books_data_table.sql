CREATE TABLE `literature`.`book_data` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `text` TEXT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `book_id_idx` (`book_id`),
  CONSTRAINT `book_id`
    FOREIGN KEY (`book_id`)
    REFERENCES `literature`.`books` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);