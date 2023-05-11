SELECT * FROM tenmo_user;

SELECT * FROM account;

SELECT tenmo_user.user_id, tenmo_user.username, account.balance 
FROM tenmo_user 
JOIN account ON tenmo_user.user_id = account.user_id;

SELECT account_id, user_id, balance FROM account WHERE user_id = 1001
