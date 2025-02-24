DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS card;

CREATE TABLE `card`
(
    card_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    card_number VARCHAR(50) NOT NULL,
    card_type   VARCHAR(25) NOT NULL,
    total_limit INT NOT NULL,
    amount_used INT NOT NULL,
    available_amount INT NOT NULL,
    create_dt DATE DEFAULT NULL
);