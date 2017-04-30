 DROP VIEW public.vista_inversiones_periodos_contribuyentes;

CREATE OR REPLACE VIEW public.vista_inversiones_periodos_contribuyentes AS

SELECT btrim(w.inv_yyyy) AS yyyy,
    narices.contribuyente,
    narices.cta_codigo,
    narices.lc_fecha,
    narices.proveedor,
    narices.exento,
    narices.grav10,
    narices.iva10,
    narices.grav5,
    narices.iva5,
    narices.total,
    narices.lc_numerofactura,
    narices.tipomov
   FROM ( SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lc_contribuyente AS cta_codigo,
            to_char(k.lc_fecha, 'YYYY/MM/DD'::text) AS lc_fecha,
            k.idprov_id, 
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('70-COMPRAS'::text || ' ESTADO '::text) || m.descripcion::text) || ' DEDUCIBLE '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 1675 AND k.tudeducible_id = 1681
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.cre_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.cre_contribuyente AS cta_codigo,
            to_char(k.cre_fecha::date::timestamp with time zone, 'YYYY/MM/DD'::text) AS lc_fecha,
            k.cre_idprov_id as idprov_id, 
            (k.cre_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.cre_montoexento AS exento,
            k.cre_totalgravada10 AS grav10,
            k.cre_montoiva10 AS iva10,
            k.cre_totalgravadas5 AS grav5,
            k.cre_montoiva5 AS iva5,
            k.cre_montototal AS total,
            to_char(k.cre_fecha, 'YYYY'::text) AS lc_periodo,
            k.cre_numerofactura AS lc_numerofactura,
            k.cre_tipoiva AS tiva,
            ((('96-COMPRAS RETRASADAS'::text || ' ESTADO '::text) || m.descripcion::text) || ' DEDUCIBLE RENTA'::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM comprasretrasadas k
             LEFT JOIN proveedor q ON k.cre_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.cre_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.cre_tuestado_id = m.id
             LEFT JOIN deducible x ON k.cre_tudeducible_id = x.id
          WHERE k.cre_tutipomov_id = 22211 AND k.cre_tudeducible_id = 1681) narices
     INNER JOIN vista_ultimo_inversiones w ON narices.lc_periodo = w.inv_yyyy AND narices.cta_codigo = w.cte_codigo
                  and narices.idprov_id = w.idprov_id 
  ORDER BY narices.lc_fecha;

