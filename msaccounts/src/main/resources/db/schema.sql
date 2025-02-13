DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS accounts;

-- CREATE TABLE `customer`
-- (
--     customer_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
--     name VARCHAR(100) NOT NULL,
--     email VARCHAR(100) NOT NULL,
--     mobile_number VARCHAR(20) NOT NULL,
--     create_dt DATE DEFAULT NULL
-- );
--
-- CREATE TABLE `accounts`
-- (
--     customer_id INT,
--     account_number INT AUTO_INCREMENT PRIMARY KEY,
--     account_type VARCHAR(100) NOT NULL,
--     bank_address VARCHAR(200) NOT NULL,
--     create_dt DATE DEFAULT NULL
-- );