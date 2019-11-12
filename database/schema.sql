BEGIN TRANSACTION;

DROP TABLE IF EXISTS song;

CREATE TABLE song (
    id serial,
    artist varchar(255) NOT NULL,
    title varchar(255) NOT NULL,
    album varchar(255) NULL,
    known boolean NOT NULL,

    constraint pk_song primary key (id),
    unique(artist, title)
);

COMMIT;