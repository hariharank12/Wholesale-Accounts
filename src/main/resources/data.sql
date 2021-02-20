INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(1, 'anztest','100001','Account AU','Saving',SYSDATE-20, 'AUD', 100);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(2, 'anztest','100002','Account US','Current',SYSDATE-19, 'USD', 200);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(3, 'anztest','100003','Account IN','Saving',SYSDATE-18, 'IND', 300);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(4, 'anztest','100004','Account AU','Saving',SYSDATE-20, 'AUD', 400);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(5, 'anztest','100005','Account US','Current',SYSDATE-19, 'USD', 500);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(6, 'anztest','100006','Account IN','Saving',SYSDATE-18, 'IND', 600);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(7, 'anztest','100007','Account AU','Saving',SYSDATE-20, 'AUD', 700);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(8, 'anztest','100008','Account US','Current',SYSDATE-19, 'USD', 800);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(9, 'anztest','100009','Account IN','Saving',SYSDATE-18, 'IND', 900);

INSERT INTO ACCOUNTS(id, user_id, account_number, account_name, account_type, balance_date, currency, opening_available_balance)
VALUES(10, 'anztest','100010','Account AU','Saving',SYSDATE-20, 'AUD', 100);

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(1, 1,SYSDATE-19,'AUD',100,null,'Debit', '10001001','TXN 10001001');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(2, 2,SYSDATE-18,'AUD',null,200,'Credit', '10001002','TXN 10001002');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(3, 3,SYSDATE-17,'AUD',null,150,'Credit', '10001003','TXN 10001003');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(4, 4,SYSDATE-19,'AUD',250,null,'Debit', '10001004','TXN 10001004');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(5, 5,SYSDATE-18,'AUD',null,150,'Credit', '10001005','TXN 10001005');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(6, 6,SYSDATE-17,'AUD',null,50,'Credit', '10001006','TXN 10001006');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(7, 7,SYSDATE-19,'AUD',450,null,'Debit', '10001007','TXN 10001007');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(8, 8,SYSDATE-18,'AUD',null,100,'Credit', '10001008','TXN 10001008');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(9, 9,SYSDATE-17,'AUD',null,50,'Credit', '10001009','TXN 10001009');

INSERT INTO TRANSACTIONS(id, account_id, value_date, currency, debit_amount, credit_amount, debit_credit, transaction_number,transaction_narrative)
VALUES(10, 10,SYSDATE-19,'AUD',50,null,'Debit', '10001010','TXN 10001010');