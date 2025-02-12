INSERT INTO `cards`
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
    )
;