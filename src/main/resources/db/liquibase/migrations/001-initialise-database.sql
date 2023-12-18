--liquibase formatted sql

--changeset emina.mahmutbegovic:create_tables

-- Create 'Vrsta emisije' Table
CREATE TABLE vrsta_emisije
(
    id_vrste_emisije    VARCHAR(36) PRIMARY KEY,
    naziv_vrste_emisije VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX unique_naziv_vrste_emisije_column_index ON vrsta_emisije (naziv_vrste_emisije);

-- Create 'Urednik' Table
CREATE TABLE urednik
(
    id_urednika              VARCHAR(36) PRIMARY KEY,
    ime_urednika             VARCHAR(50) NOT NULL,
    prezime_urednika         VARCHAR(50) NOT NULL,
    kontakt_telefon_urednika VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX unique_kontakt_telefon_urednika_column_index ON urednik (kontakt_telefon_urednika);
CREATE UNIQUE INDEX unique_urednik_set_index ON urednik (ime_urednika, prezime_urednika, kontakt_telefon_urednika);

-- Create 'Voditelj' Table
CREATE TABLE voditelj
(
    id_voditelja              VARCHAR(36) PRIMARY KEY,
    ime_voditelja             VARCHAR(50) NOT NULL,
    prezime_voditelja         VARCHAR(50) NOT NULL,
    kontakt_telefon_voditelja VARCHAR(50) NOT NULL
);

CREATE UNIQUE INDEX unique_kontakt_telefon_voditelja_column_index ON voditelj (kontakt_telefon_voditelja);
CREATE UNIQUE INDEX unique_voditelj_set_index ON voditelj (ime_voditelja, prezime_voditelja, kontakt_telefon_voditelja);

-- Create 'Gost' Table
CREATE TABLE gost
(
    id_gosta              VARCHAR(36) PRIMARY KEY ,
    ime_gosta             VARCHAR(50)  NOT NULL,
    prezime_gosta         VARCHAR(50)  NOT NULL,
    biografija_gosta      VARCHAR(500) NOT NULL,
    kontakt_telefon_gosta VARCHAR(50)  NOT NULL
);

CREATE UNIQUE INDEX unique_kontakt_telefon_gosta_column_index ON gost (kontakt_telefon_gosta);
CREATE UNIQUE INDEX unique_gost_set_index ON gost (ime_gosta, prezime_gosta, kontakt_telefon_gosta);

-- Create 'Emisija' Table
CREATE TABLE emisija
(
    id_emisije       VARCHAR(36) PRIMARY KEY,
    naziv_emisije    VARCHAR(50) NOT NULL,
    opis_emisije     VARCHAR(500),
    trajanje_emisije INT                NOT NULL,
    ocjena_emisije   INT CHECK (ocjena_emisije BETWEEN 1 AND 10),
    id_vrste_emisije VARCHAR(36) NOT NULL,
    id_voditelja     VARCHAR(36) NOT NULL,
    id_urednika      VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_vrste_emisije) REFERENCES vrsta_emisije (id_vrste_emisije),
    FOREIGN KEY (id_voditelja) REFERENCES voditelj (id_voditelja),
    FOREIGN KEY (id_urednika) REFERENCES urednik (id_urednika)
);

CREATE UNIQUE INDEX unique_naziv_emisije_column_index ON emisija (naziv_emisije);

-- Create 'Gostuje' Table
CREATE TABLE gostuje
(
    id_gosta              VARCHAR(36) NOT NULL,
    id_emisije            VARCHAR(36) NOT NULL,
    PRIMARY KEY (id_gosta, id_emisije),
    FOREIGN KEY (id_emisije) REFERENCES emisija(id_emisije),
    FOREIGN KEY (id_gosta) REFERENCES gost(id_gosta)
);

-- Create 'Epizoda' Table
CREATE TABLE epizoda
(
    id_epizode    VARCHAR(36) PRIMARY KEY,
    naziv_epizode VARCHAR(50) NOT NULL,
    broj_epizode  INT         NOT NULL,
    broj_sezone   INT         NOT NULL,
    opis_epizode  VARCHAR(500),
    id_emisije VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_emisije) REFERENCES emisija(id_emisije) ON DELETE CASCADE
);

CREATE UNIQUE INDEX unique_naziv_epizode_column_index ON epizoda (naziv_epizode);

-- Create 'Termin' Table
CREATE TABLE termin_emitovanja
(
    vrijeme_pocetka       timestamp NOT NULL,
    vrijeme_zavrsetka     timestamp NOT NULL,
    datum_emitovanja      DATE           NOT NULL,
    id_epizode VARCHAR(36) NOT NULL,
    FOREIGN KEY (id_epizode) REFERENCES epizoda(id_epizode) ON DELETE CASCADE,
    PRIMARY KEY (datum_emitovanja, vrijeme_pocetka, id_epizode)
);

CREATE UNIQUE INDEX unique_vrijeme_pocetka_column_index ON termin_emitovanja (vrijeme_pocetka);
CREATE UNIQUE INDEX unique_vrijeme_zavrsetka_column_index ON termin_emitovanja (vrijeme_zavrsetka);