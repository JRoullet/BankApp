
INSERT INTO `customer` (name, email, mobile_number, create_dt)
VALUES ('john','john@gmail.com','514-552-5555', CURRENT_DATE());


INSERT INTO `account` (customer_id, account_number, account_type, bank_address, create_dt)
VALUES (1 ,'12341646','Savings','123 Main Street', CURRENT_DATE());
