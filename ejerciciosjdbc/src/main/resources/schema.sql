DROP TABLE IF EXISTS direccion;
DROP TABLE IF EXISTS persona;
DROP TABLE IF EXISTS telefono; 

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

CREATE TABLE telefono (
    id INT NOT NULL,
    numero VARCHAR(20),
    tipo VARCHAR(50), 
    persona_id INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_persona_tel FOREIGN KEY (persona_id) REFERENCES persona(id)
);

INSERT INTO telefono (id, numero, tipo, persona_id) VALUES (500, '+34 600 123 456', 'Móvil Personal', 1);
INSERT INTO telefono (id, numero, tipo, persona_id) VALUES (501, '+34 910 000 000', 'Trabajo', 1);
INSERT INTO telefono (id, numero, tipo, persona_id) VALUES (502, '+34 655 987 654', 'Móvil', 2);

INSERT INTO persona (id, nombre) VALUES (1, 'María');
INSERT INTO persona (id, nombre) VALUES (2, 'Carlos');

INSERT INTO direccion (id, calle, persona_id) VALUES (100, 'Calle Mayor 10, Madrid', 1);
INSERT INTO direccion (id, calle, persona_id) VALUES (101, 'Apartamento Playa, Valencia', 1);
INSERT INTO direccion (id, calle, persona_id) VALUES (102, 'Gran Vía 55, Bilbao', 2);