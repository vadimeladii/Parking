CREATE TABLE user_security (
    id SERIAL,
    username VARCHAR NOT NULL ,
    password VARCHAR NOT NULL ,
    id_parking_lot INT,
    PRIMARY KEY (id)
);

