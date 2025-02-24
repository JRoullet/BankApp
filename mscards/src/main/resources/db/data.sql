INSERT INTO `card`
    (
                customer_id, card_number,
                card_type, total_limit, amount_used,
                available_amount, create_dt
    )
VALUES
    (
    '1','4040 4040 4040 4040',
    'credit','10000', '150000',
    '500',CURRENT_DATE()
    ),
    (
    '1','2020 3030 4040 5050',
    'debit','10000', '150000',
    '850000',CURRENT_DATE()
    ),
    (
    '1','5040 5040 5040 5040',
    'savings','10000', '62',
    '0',CURRENT_DATE()
    )
;