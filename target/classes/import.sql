
INSERT INTO users (email,password, username) VALUES ('prueba@prueba.com','$2y$10$PslwpsphUaBOh1FYrzjS3ubn2HhVYlkv9AaYK9iTwMNbH0aQqQa9O','admin');

INSERT INTO `accounts` (`balance`, `opneng_date`) VALUES ('2000', '2023-07-11');

INSERT INTO `bankAPI`.`addresses` (`number`, `street`, `zip`) VALUES ('200', 'libertad', '1814');

INSERT INTO `bankAPI`.`client` (`dni`, `civil_status`, `date_of_bith`, `gender`, `last_name`, `name`, `nationality`, `account`, `user_id`,`address`) VALUES ('44393222', '1', '2002-06-29', '1', 'fuentes', 'gonzalo', 'ar', '1', '1','1');

INSERT INTO `bankAPI`.`credit_cards` (`number`, `cvv`, `expiration_date`, `credit_limit`, `cutoff_date`, `payment_date`, `associated_account`) VALUES ('4455417598627162', '960', '2025-05-29', '90000', '2023-08-10', '2023-08-01', '1');

INSERT INTO `bankAPI`.`debit_cars` (`number`, `cvv`, `expiration_date`, `available_balance`, `daily_limit`, `associated_account`) VALUES ('4746904354071635', '289', '2026-10-13', '120000', '60000', '1');




INSERT INTO users (email,password, username) VALUES ('prueba2@prueba.com','$2y$10$PslwpsphUaBOh1FYrzjS3ubn2HhVYlkv9AaYK9iTwMNbH0aQqQa9O','admin2');

INSERT INTO `accounts` (`balance`, `opneng_date`) VALUES ('2000', '2023-07-11');

INSERT INTO `bankAPI`.`addresses` (`number`, `street`, `zip`) VALUES ('250', 'chile', '1819');

INSERT INTO `bankAPI`.`client` (`dni`, `civil_status`, `date_of_bith`, `gender`, `last_name`, `name`, `nationality`, `account`, `user_id`,`address`) VALUES ('40323222', '2', '2002-06-29', '2', 'Lopez', 'Maria', 'ar', '2', '2','2');

INSERT INTO `bankAPI`.`credit_cards` (`number`, `cvv`, `expiration_date`, `credit_limit`, `cutoff_date`, `payment_date`, `associated_account`) VALUES ('4455417598627163', '960', '2025-05-29', '90000', '2023-08-10', '2023-08-01', '2');

INSERT INTO `bankAPI`.`debit_cars` (`number`, `cvv`, `expiration_date`, `available_balance`, `daily_limit`, `associated_account`) VALUES ('4746904354071632', '289', '2026-10-13', '120000', '60000', '2');
