--liquibase formatted sql

--changeset emina.mahmutbegovic:create_tables

-- Create 'Vrsta emisije' Table
CREATE TABLE vrsta_emisije
(
    id_vrste_emisije    CHAR(36) PRIMARY KEY,
    naziv_vrste_emisije VARCHAR(50) UNIQUE NOT NULL
);

-- Create 'Urednik' Table
CREATE TABLE urednik
(
    id_urednika              CHAR(36) PRIMARY KEY,
    ime_urednika             VARCHAR(50) NOT NULL,
    prezime_urednika         VARCHAR(50) NOT NULL,
    kontakt_telefon_urednika VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT jedinstven_ime_prezime_telefon_urednik_set
        UNIQUE (ime_urednika, prezime_urednika, kontakt_telefon_urednika)
);

-- Create 'Voditelj' Table
CREATE TABLE voditelj
(
    id_voditelja              CHAR(36) PRIMARY KEY,
    ime_voditelja             VARCHAR(50) NOT NULL,
    prezime_voditelja         VARCHAR(50) NOT NULL,
    kontakt_telefon_voditelja VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT jedinstven_ime_prezime_telefon_voditelj_set
        UNIQUE (ime_voditelja, prezime_voditelja, kontakt_telefon_voditelja)
);

-- Create 'Gost' Table
CREATE TABLE gost
(
    id_gosta              CHAR(36) PRIMARY KEY,
    ime_gosta             VARCHAR(50)  NOT NULL,
    prezime_gosta         VARCHAR(50)  NOT NULL,
    biografija_gosta      VARCHAR(500) NOT NULL,
    kontakt_telefon_gosta VARCHAR(50) UNIQUE NOT NULL,
    CONSTRAINT jedinstven_ime_prezime_telefon_gost_set
        UNIQUE (ime_gosta, prezime_gosta, kontakt_telefon_gosta)
);

-- Create 'Emisija' Table
CREATE TABLE emisija
(
    id_emisije       CHAR(36) PRIMARY KEY,
    naziv_emisije    VARCHAR(50) UNIQUE NOT NULL,
    opis_emisije     VARCHAR(500),
    trajanje_emisije INT                NOT NULL,
    ocjena_emisije   INT CHECK (ocjena_emisije BETWEEN 1 AND 10),
    id_vrste_emisije CHAR(36) NOT NULL,
    id_voditelja     CHAR(36) NOT NULL,
    id_urednika      CHAR(36) NOT NULL,
    id_gosta         CHAR(36),
    FOREIGN KEY (id_vrste_emisije) REFERENCES vrsta_emisije (id_vrste_emisije),
    FOREIGN KEY (id_voditelja) REFERENCES voditelj (id_voditelja),
    FOREIGN KEY (id_urednika) REFERENCES urednik (id_urednika),
    FOREIGN KEY (id_gosta) REFERENCES gost (id_gosta)
);

-- Create 'Epizoda' Table
CREATE TABLE epizoda
(
    id_epizode    CHAR(36) PRIMARY KEY,
    naziv_epizode VARCHAR(50) UNIQUE NOT NULL,
    broj_epizode  INT         NOT NULL,
    broj_sezone   INT         NOT NULL,
    opis_epizode  VARCHAR(500),
    id_emisije VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_emisije) REFERENCES emisija(id_emisije) ON DELETE CASCADE
);

-- Create 'Termin' Table
CREATE TABLE termin_emitovanja
(
    vrijeme_pocetka       TIME(0) UNIQUE NOT NULL,
    vrijeme_zavrsetka     TIME(0) UNIQUE NOT NULL,
    datum_emitovanja      DATE           NOT NULL,
    id_epizode VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_epizode) REFERENCES epizoda(id_epizode) ON DELETE CASCADE,
    PRIMARY KEY (vrijeme_pocetka, id_epizode)
);