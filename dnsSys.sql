-- Create the database
CREATE DATABASE dns_management_sys;

-- Show existing databases (just for verification)
SHOW DATABASES;

-- Use the created database
USE dns_management_sys;

-- Create a table for user login
CREATE TABLE login (
    username VARCHAR(25),
    password VARCHAR(25)
);

-- Insert sample login data
INSERT INTO login VALUES ('ahmad', 'mas03');
INSERT INTO login VALUES ('admin', '1122');

-- Create a table for DNS information
CREATE TABLE dnsSys (
    infokey INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    dnsName VARCHAR(255) NOT NULL UNIQUE,
    class VARCHAR(255),
    ipAddress VARCHAR(255) NOT NULL UNIQUE
);

-- Select all records from the dnsSys table
SELECT * FROM dnsSys;

-- Select all records from the login table
SELECT * FROM login;

INSERT INTO dnsSys (infokey, name, dnsName, class, ipAddress)
VALUES
    (1, 'Google', 'www.google.com', 'Class A', '8.8.8.8'),
    (2, 'YouTube', 'www.youtube.com', 'Class C', '199.223.239.255'),
    (3, 'Instagram', 'www.instagram.com', 'Class B', '157.240.208.174'),
    (4, 'LinkedIn', 'www.linkedin.com', 'Class B', '144.2.238.024'),
    (5, 'WhatsApp', 'www.whatsapp.com', 'Class A', '66.111.50.12'),
    (6, 'FaceBook', 'www.facebook.com', 'Class B', '157.240.192.018'),
    (7, 'Canva', 'www.canva.com', 'Class A', '104.16.226.10');

