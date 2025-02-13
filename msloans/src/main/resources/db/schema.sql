DROP TABLE IF EXISTS loan;

CREATE TABLE `loan`
(
    loan_number INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    start_dt    DATE DEFAULT NULL,
    loan_type   VARCHAR(50) NOT NULL,
    total_loan  INT NOT NULL,
    amount_paid INT NOT NULL,
    outstanding_amount INT NOT NULL,
    create_dt DATE DEFAULT NULL
);