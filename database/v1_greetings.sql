-- 
--  Table greetings
-- 

CREATE TABLE greetings(
 id serial PRIMARY KEY,
 content VARCHAR (50) UNIQUE NOT NULL
);