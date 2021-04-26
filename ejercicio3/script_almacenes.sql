CREATE DATABASE almacenesDB
WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;


-- CREACION DE LAS TABLAS
CREATE TABLE public.cajeros
(
    cajero integer NOT NULL,
    "nomApels" character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cajeros_pkey PRIMARY KEY (cajero)
);

ALTER TABLE public.cajeros
    OWNER to postgres;

CREATE TABLE public.productos
(
    producto integer NOT NULL,
    nombre character varying(100) COLLATE pg_catalog."default",
    precio money,
    CONSTRAINT productos_pkey PRIMARY KEY (producto)
);

ALTER TABLE public.productos
    OWNER to postgres;

CREATE TABLE public.maquinas_registradoras
(
    maquina integer NOT NULL,
    piso integer,
    CONSTRAINT maquinas_registradoras_pkey PRIMARY KEY (maquina)
);

ALTER TABLE public.maquinas_registradoras
    OWNER to postgres;

CREATE TABLE public.venta
(
    cajero integer,
    maquina integer,
    producto integer,
    CONSTRAINT fk_cajero FOREIGN KEY (cajero)
        REFERENCES public.cajeros (cajero) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_maquina FOREIGN KEY (maquina)
        REFERENCES public.maquinas_registradoras (maquina) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT fk_producto FOREIGN KEY (cajero)
        REFERENCES public.productos (producto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.venta
    OWNER to postgres;

-- CREACION DE SCRIPT LLENADO DE TABLAS
INSERT INTO public.cajeros(
	cajero, "nomApels")
	VALUES 
	(1, 'Joaquín Lopez'),
	(2, 'Mateo Prereida'),
	(3, 'Carlos Hernandez'),
	(4, 'Luis Jimenez');

INSERT INTO public.maquinas_registradoras(
	maquina, piso)
	VALUES 
	(1, 101),
	(2, 102),
	(3, 103);

INSERT INTO public.productos(
	producto, nombre, precio)
	VALUES 
	(1, 'producto1', 15.5),
	(2, 'producto2', 20),
	(3, 'producto3', 10.9),
	(4, 'producto4', 5.5),
	(5, 'producto5', 2.4);

INSERT INTO public.venta(
	cajero, maquina, producto)
	VALUES 
	(1, 3, 4),
	(1, 3, 4),
	(1, 3, 3),
	(1, 3, 1),
	(1, 3, 5),
	(2, 1, 2),
	(2, 1, 4),
	(2, 1, 3),
	(2, 1, 1),
	(2, 1, 3),
	(3, 2, 1),
	(3, 2, 2),
	(3, 2, 4),
	(4, 2, 5),
	(4, 2, 3);

-- número de ventas de cada producto, ordenado de más a menos ventas.
SELECT COUNT(v.producto) AS numero_ventas, nombre, precio FROM venta v
INNER JOIN productos p ON p.producto = v.producto
GROUP BY v.producto, nombre, precio 
ORDER BY numero_ventas DESC;

-- informe completo de ventas
SELECT "nomApels" AS nombre_cajero, nombre AS producto, precio, piso 
FROM venta v
 JOIN productos p ON p.producto = v.producto
 JOIN cajeros c ON c.cajero = v.cajero
 JOIN maquinas_registradoras mr ON mr.maquina = v.maquina
 ORDER BY nombre;

-- ventas totales realizadas en cada piso.
SELECT COUNT(v.maquina) AS numero_ventas, piso FROM venta v
INNER JOIN maquinas_registradoras mr ON mr.maquina = v.maquina
GROUP BY v.maquina, piso
ORDER BY numero_ventas DESC;

-- código y nombre de cada cajero junto con el importe total de sus ventas.
SELECT c.cajero AS codigo, "nomApels" AS nombre_cajero, SUM(p.precio) as total_vendido 
FROM venta v
INNER JOIN cajeros c ON c.cajero = v.cajero
INNER JOIN productos p ON p.producto = v.producto
GROUP BY c.cajero
ORDER BY nombre_cajero;

-- código y nombre de aquellos cajeros que hayan realizado ventas < 5000
SELECT COUNT(v.cajero), "nomApels" AS nom, SUM(p.precio) AS total_vendido, mr.piso from cajeros c
INNER JOIN venta v ON v.cajero = c.cajero
INNER JOIN productos p ON p.producto = v.producto
INNER JOIN maquinas_registradoras mr ON mr.maquina = v.maquina
GROUP BY v.cajero, nom, mr.piso
HAVING CAST(SUM(p.precio) AS DECIMAL) < 5000;