--CREATE SCHEMA IF NOT EXISTS app;

--CREATE TABLE IF NOT EXISTS app.person
--(
  --  id
    --SERIAL
   -- PRIMARY
   -- KEY,
    --name
    --VARCHAR(100) NOT NULL,
    --email VARCHAR(150) UNIQUE,
    --created_at TIMESTAMP DEFAULT now
--(
--)
 --   );
CREATE SCHEMA IF NOT EXISTS plan;
CREATE TABLE IF NOT EXISTS plan.participant (
                              id serial PRIMARY KEY,
                             email VARCHAR(255) NOT NULL UNIQUE,
                             first_name VARCHAR(100) NOT NULL,
                             last_name VARCHAR(100) NOT NULL,
                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS plan.plan (
                            id serial PRIMARY KEY,
                            title varchar(255) NOT NULL UNIQUE,
                            description varchar(255) NOT NULL,
                            location varchar(255) NOT NULL,
                            created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

