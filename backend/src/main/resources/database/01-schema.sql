CREATE TABLE
    IF NOT EXISTS city_postal_code (
        code VARCHAR(10) NOT NULL PRIMARY KEY,
        city VARCHAR(100) NOT NULL
    );