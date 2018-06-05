SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS guitars (
  id int PRIMARY KEY auto_increment,
  type VARCHAR,
  manufacturer VARCHAR,
  model VARCHAR,
  year INTEGER,
  imageUrl VARCHAR,
  color VARCHAR,
  finish VARCHAR
);