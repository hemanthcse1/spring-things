CREATE TABLE movie_actors
(
    actors_id BIGINT NOT NULL,
    movie_id  BIGINT NOT NULL,
    PRIMARY KEY (actors_id, movie_id),
    FOREIGN KEY (movie_id) REFERENCES movie (id),
    FOREIGN KEY (actors_id) REFERENCES actor (id)
);
