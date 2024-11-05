-- it can be part of the docker-compose init sql.

CREATE TABLE client (
   id SERIAL PRIMARY KEY,
   prenom VARCHAR(100),
   nom VARCHAR(50),
   email VARCHAR(255)
);

INSERT INTO client (prenom, nom, email)
SELECT 'prenom' || '-' || numero, 'nom' || '-' || numero, 'nom.prenom' || numero || '@gmail.com'
FROM generate_series(1, 10000000) AS numero;