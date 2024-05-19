-- 1. Mostrar el nombre y partido (concatenados por coma) de los senadores que hayan pedido 
--    cita para votar el día 9 de marzo de 2025, ordenados alfabéticamente por su partido.

-- Explícita
SELECT DISTINCT CONCAT (nom_comp,', ', partido) AS politico 
FROM senador S 
INNER JOIN votante V ON S.dni=V.dni
INNER JOIN pide_c ON V.dni=dni_votante 
WHERE dia='2025-03-09'
ORDER BY 1;

-- Implícita
SELECT DISTINCT CONCAT (nom_comp,', ', partido) AS politico 
FROM senador S,votante V, pide_c 
WHERE S.dni=V.dni AND V.dni=dni_votante AND dia='2025-03-09'
ORDER BY 1;

-- 2. Mostrar el nombre del centro y número de interventores asignados a ese centro para 
--    los centros con más de un interventor asignado, ordenados de mayor a menor número de 
--    interventores y por el nombre alfabético del centro.

-- GROUP BY
SELECT nombre_centro, COUNT(*) AS num_interventores
FROM centro, interventor
WHERE id_centro=centro_asignado
GROUP BY id_centro
HAVING COUNT(*)>1
ORDER BY 2 DESC, nombre_centro;

-- Tabla derivada y GROUP BY
SELECT nombre_centro, num_interventores
FROM centro, (SELECT centro_asignado, COUNT(*) AS num_interventores
              FROM interventor
              GROUP BY centro_asignado
              HAVING COUNT(*)>1) NI
WHERE id_centro=centro_asignado
ORDER BY 2 DESC, nombre_centro;

-- Subconsulta
SELECT nombre_centro, (SELECT COUNT(*) FROM interventor 
                       WHERE centro_asignado=id_centro) AS num_interventores
FROM centro
WHERE (SELECT COUNT(*) FROM interventor WHERE centro_asignado=id_centro)>1
ORDER BY 2 DESC, nombre_centro;

-- 3. Mostrar las id_digitales que no han votado y su circunscripción, para las 
--    circunscripciones que contengan la cadena 'Ladron' o que tengan exactamente 9 letras 
--    y empiecen por I, ordenadas por circunscripción. Realizar la consulta mediante:

-- IN. Con DISTINCT
SELECT id, circunscripcion
FROM id_digital
WHERE (circunscripcion LIKE '%Ladron%' 
   OR circunscripcion LIKE 'I________')
AND id NOT IN  (SELECT DISTINCT id_voto
                FROM vota_sen)
ORDER BY circunscripcion;

-- IN. Con GROUP BY
SELECT id, circunscripcion
FROM id_digital
WHERE (circunscripcion LIKE '%Ladron%' 
   OR circunscripcion LIKE 'I________')
AND id NOT IN  (SELECT id_voto
                FROM vota_sen
                GROUP BY id_voto)
ORDER BY circunscripcion;

-- EXISTS
SELECT id, circunscripcion
FROM id_digital
WHERE (circunscripcion LIKE '%Ladron%' 
   OR circunscripcion LIKE 'I________')
AND NOT EXISTS (SELECT 1
                FROM vota_sen
                WHERE id=id_voto)
ORDER BY circunscripcion;

-- 4. Muestra el nombre y el sueldo de los interventores asignados al centro donde 
--    esté el interventor con el sueldo más bajo, solo los otros interventores, 
--    no el que tiene el sueldo más bajo. Ordena por sueldo de menor a mayor.

-- >=ALL
SELECT nom_comp, sueldo 
FROM votante V, interventor I
WHERE V.dni=I.dni
AND centro_asignado = (SELECT centro_asignado 
                       FROM interventor 
                       WHERE sueldo<=ALL (SELECT sueldo FROM interventor))
AND I.dni <> (SELECT dni 
                       FROM interventor 
                       WHERE sueldo<=ALL (SELECT sueldo FROM interventor))
ORDER BY sueldo;

-- MAX
SELECT nom_comp, sueldo 
FROM votante V, interventor I
WHERE V.dni=I.dni
AND centro_asignado = (SELECT centro_asignado 
                       FROM interventor 
                       WHERE sueldo = (SELECT MIN(sueldo) FROM interventor))
AND I.dni <> (SELECT dni 
                       FROM interventor 
                       WHERE sueldo = (SELECT MIN(sueldo) FROM interventor))
ORDER BY sueldo;

--Tabla derivada
SELECT nom_comp, sueldo 
FROM votante V, interventor I, 
    (SELECT centro_asignado, dni 
     FROM interventor 
     WHERE sueldo = (SELECT MIN(sueldo) FROM interventor)) SB
WHERE V.dni=I.dni
    AND I.dni <> SB.dni AND I.centro_asignado=SB.centro_asignado
ORDER BY sueldo;

-- 5. Obtener cuánto dinero ha gastado cada senador comprando votos. 
--    Mostrarlo junto a su dni y partido, ordenado de mayor gasto a menor.
SELECT dni, partido, COUNT(*)*pago_compra_voto AS gastos_electorales
FROM senador, id_digital
WHERE dni=senador_corrupto
GROUP BY dni, partido
ORDER BY 3 DESC;

--    Crea otra consulta que muestre el total gastado por cada partido
--    en comprar votos. Ordena ahora de menor a mayor gasto. Deben aparecer
--    todos los partidos.
SELECT partido, SUM(gastos) AS gastos_electorales
FROM senador S1 LEFT JOIN (SELECT dni, COUNT(*)*pago_compra_voto AS gastos
                           FROM senador S2, id_digital
                           WHERE S2.dni=senador_corrupto
                           GROUP BY dni) CV 
ON CV.dni=S1.dni
GROUP BY partido
ORDER BY 2;

-- 6. Vista que cuenta los votos que ha obtenido cada senador en la circunscripción
--    de 'Impunícia' guardando el dni y sus votos obtenidos.
CREATE OR REPLACE VIEW resultados_imp AS
SELECT dni_senador, COUNT(dni_senador) AS votos
FROM vota_sen, senador
WHERE dni_senador=dni AND circ_presenta='Impunícia' 
GROUP BY dni_senador;

-- Crea otra consulta que muestre el nombre y el número de votos del senador o los
-- senadores más votados en esa circunscripción.  

-- CON VISTA

-- Subconsulta con >= ALL en el WHERE
SELECT nom_comp, votos 
FROM resultados_imp, votante
WHERE dni_senador = dni
    AND votos >= ALL (SELECT votos
                      FROM resultados_imp);


-- Subconsulta con MAX en el WHERE
SELECT nom_comp, votos 
FROM resultados_imp, votante
WHERE dni_senador = dni
    AND votos = (SELECT MAX(votos)
                 FROM resultados_imp);

-- Tablas derivadas
SELECT nom_comp, RI.votos 
FROM resultados_imp RI, votante V, (SELECT MAX(votos) AS votos
                                  FROM resultados_imp) MX
WHERE RI.dni_senador = V.dni AND RI.votos = MX.votos;
 
-- SIN VISTA

-- Subconsulta con >= ALL en el HAVING
SELECT nom_comp, COUNT(dni_senador) AS votos
FROM vota_sen, senador S,votante V
WHERE dni_senador=S.dni AND S.dni=V.dni 
    AND circ_presenta='Impunícia'
GROUP BY dni_senador
HAVING COUNT(dni_senador)>= ALL (SELECT COUNT(dni_senador)
                                 FROM vota_sen, senador
                                 WHERE dni_senador=dni 
                                     AND circ_presenta='Impunícia' 
                                 GROUP BY dni_senador);

-- Subconsulta con MAX en el HAVING
SELECT nom_comp, COUNT(dni_senador) AS votos
FROM vota_sen, senador S,votante V
WHERE dni_senador=S.dni AND S.dni=V.dni 
    AND circ_presenta='Impunícia'
GROUP BY dni_senador
HAVING COUNT(dni_senador)=(SELECT MAX(voto) 
                           FROM (SELECT COUNT(dni_senador) AS voto
                                 FROM vota_sen, senador
                                 WHERE dni_senador=dni 
                                     AND circ_presenta='Impunícia' 
                                 GROUP BY dni_senador) VS);

-- Tabla derivada
SELECT nom_comp, COUNT(dni_senador) AS votos
FROM vota_sen, senador S,votante V, (SELECT MAX(voto) as maximo
                                     FROM (SELECT COUNT(dni_senador) AS voto
                                           FROM vota_sen, senador
                                           WHERE dni_senador=dni 
                                           AND circ_presenta='Impunícia' 
                                           GROUP BY dni_senador) VS) MX
WHERE dni_senador=S.dni AND S.dni=V.dni 
    AND circ_presenta='Impunícia'
GROUP BY dni_senador, maximo
HAVING COUNT(dni_senador)=maximo;

-- Tablas derivadas. Es la misma consulta del apartado con la VISTA
-- Es una mala praxis mezclar nomenclaturas implícita y explicita,
-- se ha cambiado la consulta principal a explícita para una mejor comprensión
-- de los JOINs y se mantiene la implícita en las subconsultas para que se vea
-- claro que es literalmente la consulta usada para crear la VISTA
SELECT nom_comp, votos
FROM votante V
INNER JOIN (SELECT dni_senador, COUNT(dni_senador) AS votos
            FROM vota_sen, senador
            WHERE dni_senador=dni 
               AND circ_presenta='Impunícia' 
            GROUP BY dni_senador) RI
ON V.dni=RI.dni_senador
CROSS JOIN (SELECT MAX(voto) as maximo
            FROM (SELECT COUNT(dni_senador) AS voto
                  FROM vota_sen, senador
                  WHERE dni_senador=dni 
                      AND circ_presenta='Impunícia' 
                  GROUP BY dni_senador) VS) MX           
WHERE RI.votos=MX.maximo;
