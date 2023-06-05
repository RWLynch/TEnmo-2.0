START TRANSACTION;
UPDATE account SET balance = balance - 100
WHERE user_id = 1001;
UPDATE account SET balance = balance + 100
WHERE user_id = 1002;
INSERT INTO transfer (transfer_type, transfer_status, account_from, account_to, amount, note)
VALUES ('Send', 'Approved', (SELECT account_id FROM account WHERE user_id = 1001), (SELECT account_id FROM account WHERE user_id = 1002), 100, 'asdfjkl;');
COMMIT;

