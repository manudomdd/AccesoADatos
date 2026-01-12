DROP TABLE IF EXISTS direccion;
DROP TABLE IF EXISTS persona;

CREATE TABLE persona (
    id INT NOT NULL,
    nombre VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE direccion (
    id INT NOT NULL,
    calle VARCHAR(255),
    persona_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_persona FOREIGN KEY (persona_id) REFERENCES persona(id)
);

INSERT INTO persona (id, nombre) VALUES (1, 'María');
INSERT INTO persona (id, nombre) VALUES (2, 'Carlos');

INSERT INTO direccion (id, calle, persona_id) VALUES (100, 'Calle Mayor 10, Madrid', 1);
INSERT INTO direccion (id, calle, persona_id) VALUES (101, 'Apartamento Playa, Valencia', 1);
INSERT INTO direccion (id, calle, persona_id) VALUES (102, 'Gran Vía 55, Bilbao', 2);