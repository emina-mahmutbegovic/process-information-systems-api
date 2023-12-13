--liquibase formatted sql

--changeset emina.mahmutbegovic:load_test_data

COPY urednik FROM '/test-data/tv-editor-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY vrsta_emisije FROM '/test-data/tv-genre-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY gost FROM '/test-data/tv-guest-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY voditelj FROM '/test-data/tv-host-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY emisija FROM '/test-data/tv-show-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY gostuje FROM '/test-data/tv-is-guest-of-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY epizoda FROM '/test-data/tv-episode-test-data.csv' WITH CSV HEADER DELIMITER ',';
COPY termin_emitovanja FROM '/test-data/tv-date-test-data.csv' WITH CSV HEADER;
