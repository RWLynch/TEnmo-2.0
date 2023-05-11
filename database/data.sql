INSERT INTO tenmo_user (username, first_name, last_name, email, phone, password_hash, role)
VALUES ('admin','David', 'Jackson', 'djackson@proton.me', '5555318008','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO account (account_id, user_id, balance)
VALUES (2001, 1001, 3500.00);
