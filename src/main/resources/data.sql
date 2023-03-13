
-- Cargar datos en la tabla clientes
INSERT INTO clientes (id, nombre) VALUES (1, 'Bar Pepe');
INSERT INTO clientes (id, nombre) VALUES (2, 'cliente 2');
INSERT INTO clientes (id, nombre) VALUES (3, 'cliente 3');

-- Cargar datos en la tabla maquinas
INSERT INTO maquinas (id, cliente_id, nombre) VALUES (1, 1, 'supermaquina');
INSERT INTO maquinas (id, cliente_id, nombre) VALUES (2, 2, 'Maquina 1');
INSERT INTO maquinas (id, cliente_id, nombre) VALUES (3, 3, 'Maquina 2');
INSERT INTO maquinas (id, cliente_id, nombre) VALUES (4, 1, 'Maquina 3');

-- Cargar datos en la tabla contadores_manuales
INSERT INTO contadores_manuales (id, maquina_id, entradas_manuales, salidas_manuales, fecha) 
VALUES (						  1,  1,            100,              99,             FORMATDATETIME(TIMESTAMP '2023-01-21 10:00:00','yyyy-MM-dd hh:mm:ss'));
INSERT INTO contadores_manuales (id, maquina_id, entradas_manuales, salidas_manuales, fecha) 
VALUES (2, 2, 100, 99, FORMATDATETIME(TIMESTAMP '2023-03-01 10:00:00','yyyy-MM-dd hh:mm:ss'));



-- Cargar datos en la tabla contadores_automaticos
INSERT INTO contadores_automaticos (id, maquina_id, entradas_automaticas, salidas_automaticas, fecha) VALUES
(1, 1, 80, 90, FORMATDATETIME(TIMESTAMP '2023-01-21 09:46:00','yyyy-MM-dd hh:mm:ss')),
(2, 1, 85, 91, FORMATDATETIME(TIMESTAMP '2023-01-21 09:51:00','yyyy-MM-dd hh:mm:ss')),
(3, 1, 100, 98, FORMATDATETIME(TIMESTAMP '2023-01-21 09:56:00','yyyy-MM-dd hh:mm:ss')),
(4, 1, 100, 99, FORMATDATETIME(TIMESTAMP '2023-01-21 10:01:00','yyyy-MM-dd hh:mm:ss')),
(5, 1, 101, 100, FORMATDATETIME(TIMESTAMP '2023-01-21 10:06:00','yyyy-MM-dd hh:mm:ss')),
(6, 1, 102, 101, FORMATDATETIME(TIMESTAMP '2023-01-21 10:11:00','yyyy-MM-dd hh:mm:ss')),
(7, 1, 103, 102, FORMATDATETIME(TIMESTAMP '2023-01-21 10:16:00','yyyy-MM-dd hh:mm:ss')),
(8, 1, 104, 103, FORMATDATETIME(TIMESTAMP '2023-01-21 10:21:00','yyyy-MM-dd hh:mm:ss'));

-- Cargar datos en la tabla recaudaciones
INSERT INTO recaudaciones (id, maquina_id, fecha, importe, contadores_manuales_id, cliente_id) 
VALUES (1, 1, '2023-01-21', 5, 1, 1);
INSERT INTO recaudaciones (id, maquina_id, fecha, importe, contadores_manuales_id, cliente_id) 
VALUES (2, 2, '2023-03-01', 10, 1, 2);

