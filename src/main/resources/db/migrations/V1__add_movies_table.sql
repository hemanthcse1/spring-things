CREATE TYPE rating_enum AS ENUM ('G', 'PG', 'PG13', 'R', 'NC17');

CREATE TABLE movie
(
    id        SERIAL PRIMARY KEY,
    title     VARCHAR(255) DEFAULT NULL,
    headline  VARCHAR(255) DEFAULT NULL,
    language  VARCHAR(255) DEFAULT NULL,
    region    VARCHAR(255) DEFAULT NULL,
    thumbnail VARCHAR(255) DEFAULT NULL,
    rating    rating_enum DEFAULT NULL
);
