CREATE TABLE users (
                       id IDENTITY PRIMARY KEY,
                       first_name VARCHAR(50) NOT NULL,
                       last_name VARCHAR(50) NOT NULL,
                       pesel VARCHAR(11) UNIQUE NOT NULL,
                       role VARCHAR(10) CHECK (role IN ('ADMIN', 'USER')) NOT NULL
);