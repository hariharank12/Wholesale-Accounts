CREATE TABLE ACCOUNTS (
    id INT NOT NULL,
    user_id VARCHAR(50) NOT NULL,
    account_number VARCHAR(100) NOT NULL,
    account_name VARCHAR(100) NOT NULL,
    account_type VARCHAR(50) NOT NULL,
    balance_date DATE,
    currency VARCHAR(50) NOT NULL,
    opening_available_balance DOUBLE NOT NULL,
    PRIMARY KEY (account_number),
    UNIQUE (account_number)
);

CREATE TABLE TRANSACTIONS (
    id INT NOT NULL,
    account_id INT NOT NULL,
    value_date DATE,
    currency VARCHAR(50) NOT NULL,
    debit_amount DOUBLE,
    credit_amount DOUBLE,
    debit_credit VARCHAR(50) NOT NULL,
    transaction_number VARCHAR(100) NOT NULL,
    transaction_narrative VARCHAR (200),
    FOREIGN KEY (account_id) REFERENCES ACCOUNTS (id)
);