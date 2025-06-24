CREATE TABLE payment_record(
    id BIGINT NOT NULL AUTO_INCREMENT,
    transaction_id VARCHAR(255) NOT NULL,
    order_id VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    payment_method VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY (transaction_id)
);