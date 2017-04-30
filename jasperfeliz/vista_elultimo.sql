CREATE OR REPLACE VIEW public.vista_elultimo AS
 SELECT (w.per_yyyy || '/'::text) || lpad(btrim(to_char(w.per_mm, '99'::text)), 2, '0'::text) AS yyyymm
 		, w.cte_codigo
   FROM periodos w
  WHERE (w.lastupdated IN ( SELECT max(k.lastupdated) AS ultimo
           FROM periodos k))
UNION ALL
 SELECT w.per_yyyy || '/99'::text AS yyyymm
 	 		, w.cte_codigo
   FROM periodos w
  WHERE (w.lastupdated IN ( SELECT max(k.lastupdated) AS ultimo
           FROM periodos k));
