DROP TABLE IF EXISTS recaudaciones;
DROP TABLE IF EXISTS contadores_automaticos;
DROP TABLE IF EXISTS contadores_manuales;
DROP TABLE IF EXISTS maquinas;
DROP TABLE IF EXISTS clientes;

CREATE TABLE clientes (
    id INT PRIMARY KEY,
    nombre VARCHAR(255)
);

CREATE TABLE maquinas (
    id INT PRIMARY KEY,
    cliente_id INT,
    nombre VARCHAR(255),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id)
);


CREATE TABLE contadores_manuales (
    id INT PRIMARY KEY,
    maquina_id INT,
    entradas_manuales INT,
    salidas_manuales INT,
    fecha TIMESTAMP,
    FOREIGN KEY (maquina_id) REFERENCES maquinas(id)
);

CREATE TABLE contadores_automaticos (
    id INT PRIMARY KEY,
    maquina_id INT,
    entradas_automaticas INT,
    salidas_automaticas INT,
    fecha TIMESTAMP,
    FOREIGN KEY (maquina_id) REFERENCES maquinas(id)
);

CREATE TABLE recaudaciones (
    id INT PRIMARY KEY,
    importe DECIMAL(10,2),
	fecha DATE,
	maquina_id INT,
    contadores_manuales_id INT,
    cliente_id INT,
    FOREIGN KEY (maquina_id) REFERENCES maquinas(id),
    FOREIGN KEY (cliente_id) REFERENCES clientes(id),
	FOREIGN KEY (contadores_manuales_id) REFERENCES contadores_manuales(id)
);