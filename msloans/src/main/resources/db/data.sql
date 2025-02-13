INSERT INTO `loan`
    (
                customer_id, start_dt,
                loan_type, total_loan, amount_paid,
                outstanding_amount, create_dt
    )
VALUES
    (
    '1',CURRENT_DATE()-2000,
    'RealEstate','300000', '10000',
    '290000',CURRENT_DATE()
    ),
    (
    '2',CURRENT_DATE()-550,
    'Furniture','10000', '5000',
    '5000',CURRENT_DATE()
    ),
    (
    '1',CURRENT_DATE()-700,
    'Car','20000', '5000',
    '15000',CURRENT_DATE()
    ),
    (
    '3',CURRENT_DATE()-500,
    'Car','100000', '2000',
    '98000',CURRENT_DATE()
    )
;