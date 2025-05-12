-- Création de la base de données
CREATE DATABASE IF NOT EXISTS webdb;

-- Sélection de la base de données
USE webdb;

-- Création de la table user
CREATE TABLE IF NOT EXISTS user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL
);

-- Insertion de quelques exemples de données (facultatif)
INSERT INTO user (nom, prenom) VALUES ('imad', 'Aouinti');
INSERT INTO user (nom, prenom) VALUES ('yahya', 'El Amri');
INSERT INTO user (nom, prenom) VALUES ('Ahmad', 'Douhi');
