ALTER TABLE horse RENAME TO horse_old;
ALTER TABLE race RENAME TO race_old;
ALTER TABLE race_day RENAME TO race_day_old;

CREATE TABLE race_day (
	id Serial NOT NULL PRIMARY KEY, 
    race_date date NOT NULL
    );

CREATE TABLE race (
	id Serial NOT NULL PRIMARY KEY, 
    race_day_id integer NOT NULL REFERENCES race_day(id),
    number_of_runners integer NOT NULL,
    time character varying(255) NOT NULL,
    venue character varying(255) NOT NULL
    );

CREATE TABLE horse (
	id Serial NOT NULL PRIMARY KEY,
    race_id integer NOT NULL REFERENCES race(id),
    tips integer NOT NULL,
    odds character varying(255) NOT NULL,
    name character varying(255) NOT NULL
    );
