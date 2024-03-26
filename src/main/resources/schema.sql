CREATE TABLE Product (
    productId INTEGER PRIMARY KEY AUTO_INCREMENT,
    productName TEXT,
    price DOUBLE
);


CREATE TABLE Review (
    reviewId INTEGER PRIMARY KEY AUTO_INCREMENT,
    reviewContent TEXT,
    rating INTEGER,
    productId INTEGER,
    FOREIGN KEY (productId) REFERENCES Product(productId)
);
