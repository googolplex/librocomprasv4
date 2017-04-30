-- drop view vista_librocompras ;
CREATE VIEW public.vista_librocompras AS
 SELECT *   FROM ( SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lv_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lv_contribuyente as cta_codigo,
            to_char(k.lv_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lv_cliente_ruc::text || '-'::text) || q.cli_nombre::text AS proveedor,
            k.lv_montoexento AS exento,
            k.lv_totalgravada10 AS grav10,
            k.lv_montoiva10 AS iva10,
            k.lv_totalgravadas5 AS grav5,
            k.lv_montoiva5 AS iva5,
            k.lv_montototal AS total,
            to_char(k.lv_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lv_numerofactura AS lc_numerofactura,
            k.lv_tipoiva AS tiva,
            ('10-VENTAS'::text || ' ESTADO '::text) || m.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM libroventas k
             LEFT JOIN cliente q ON k.lv_cliente_ruc::text = q.cli_codigo::text
             LEFT JOIN contribuyente t ON k.lv_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
          WHERE k.tutipomov_id = 1676 AND k.tuestado_id = 1683
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lv_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lv_contribuyente  as cta_codigo ,                  
            to_char(k.lv_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lv_cliente_ruc::text || '-'::text) || q.cli_nombre::text AS proveedor,
            k.lv_montoexento AS exento,
            k.lv_totalgravada10 AS grav10,
            k.lv_montoiva10 AS iva10,
            k.lv_totalgravadas5 AS grav5,
            k.lv_montoiva5 AS iva5,
            k.lv_montototal AS total,
            to_char(k.lv_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lv_numerofactura AS lc_numerofactura,
            k.lv_tipoiva AS tiva,
            ('20-VENTAS DEDUCIBLES DE  RENTA'::text || ' ESTADO '::text) || m.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM libroventas k
             LEFT JOIN cliente q ON k.lv_cliente_ruc::text = q.cli_codigo::text
             LEFT JOIN contribuyente t ON k.lv_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
          WHERE k.tutipomov_id = 5744 AND k.tuestado_id = 1683
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            '.'::text AS contribuyente,
            k.lv_contribuyente  as cta_codigo ,                  
            to_char(k.lv_fecha,'YYYY/MM/DD') as lc_fecha,
            '.'::text AS proveedor,
            0 AS exento,
            0 AS grav10,
            0 AS iva10,
            0 AS grav5,
            0 AS iva5,
            0 AS total,
            to_char(k.lv_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lv_numerofactura AS lc_numerofactura,
            k.lv_tipoiva AS tiva,
            ('30-VENTAS'::text || ' ESTADO '::text) || m.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM libroventas k
             LEFT JOIN cliente q ON k.lv_cliente_ruc::text = q.cli_codigo::text
             LEFT JOIN contribuyente t ON k.lv_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
          WHERE k.tutipomov_id = 1676 AND k.tuestado_id = 1684
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            '.'::text AS contribuyente,
            k.lv_contribuyente  as cta_codigo ,                  
            to_char(k.lv_fecha,'YYYY/MM/DD') as lc_fecha,
            '.'::text AS proveedor,
            0 AS exento,
            0 AS grav10,
            0 AS iva10,
            0 AS grav5,
            0 AS iva5,
            0 AS total,
            to_char(k.lv_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lv_numerofactura AS lc_numerofactura,
            k.lv_tipoiva AS tiva,
            ('40-NOTA DE CREDITO'::text || ' ESTADO '::text) || m.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM libroventas k
             LEFT JOIN cliente q ON k.lv_cliente_ruc::text = q.cli_codigo::text
             LEFT JOIN contribuyente t ON k.lv_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
          WHERE k.tutipomov_id = 3536 AND k.tuestado_id = 1684
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            '.'::text AS contribuyente,
            k.lv_contribuyente  as cta_codigo ,                  
            to_char(k.lv_fecha,'YYYY/MM/DD') as lc_fecha,
            '.'::text AS proveedor,
            0 AS exento,
            0 AS grav10,
            0 AS iva10,
            0 AS grav5,
            0 AS iva5,
            0 AS total,
            to_char(k.lv_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lv_numerofactura AS lc_numerofactura,
            k.lv_tipoiva AS tiva,
            ('50-NOTA DE CREDITO'::text || ' ESTADO '::text) || m.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM libroventas k
             LEFT JOIN cliente q ON k.lv_cliente_ruc::text = q.cli_codigo::text
             LEFT JOIN contribuyente t ON k.lv_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
          WHERE k.tutipomov_id = 3536 AND k.tuestado_id = 1684
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lc_contribuyente  as cta_codigo,                  
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
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
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lc_contribuyente  as cta_codigo ,                                    
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('70-COMPRAS'::text || ' ESTADO '::text) || m.descripcion::text) || ' NO DEDUCIBLE '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 1675 AND k.tudeducible_id = 1682
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lc_contribuyente  as cta_codigo,                                    
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('90-AUTOFACTURA'::text || ' ESTADO '::text) || m.descripcion::text) || ' DEDUCIBLE '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 3535 AND k.tudeducible_id = 1681
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lc_contribuyente as cta_codigo,                                    
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('90-AUTOFACTURA'::text || ' ESTADO '::text) || m.descripcion::text) || ' NO DEDUCIBLE '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 3535 AND k.tudeducible_id = 1682
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (r.cte_codigo || '-'::text) || r.cte_nombre::text AS contribuyente,
            r.cte_codigo as cta_codigo,                                    
            to_char(k.fecha,'YYYY/MM/DD') as lc_fecha,
            (w_1.cli_codigo::text || '-'::text) || w_1.cli_nombre::text AS proveedor,
            0 AS exento,
            0 AS grav10,
            k.totalret AS iva10,
            0 AS grav5,
            0 AS iva5,
            k.montototal AS total,
            to_char(k.fecha, 'YYYY/MM'::text) AS lc_periodo,
            to_char(k.numerocomprobante, '9999999999999'::text) AS lc_numerofactura,
            1 AS tiva,
            '91-RETENCIONES'::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM retenciones k
             LEFT JOIN cliente w_1 ON k.agente_id = w_1.id
             LEFT JOIN contribuyente r ON k.contribuyente_id = r.id
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
            k.lc_contribuyente  as cta_codigo,
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('92-PAGO DE IMPUESTOS '::text || ' ESTADO '::text) || m.descripcion::text) || ' '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 5603 AND k.tudeducible_id = 1681
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
             k.lc_contribuyente  as cta_codigo,
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('93-PAGO DE TARJETAS '::text || ' ESTADO '::text) || m.descripcion::text) || ' '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 5604 AND k.tudeducible_id = 1681
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.lc_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
             k.lc_contribuyente  as cta_codigo,
            to_char(k.lc_fecha,'YYYY/MM/DD') as lc_fecha,
            (k.lc_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.lc_montoexento AS exento,
            k.lc_totalgravada10 AS grav10,
            k.lc_montoiva10 AS iva10,
            k.lc_totalgravadas5 AS grav5,
            k.lc_montoiva5 AS iva5,
            k.lc_montototal AS total,
            to_char(k.lc_fecha, 'YYYY/MM'::text) AS lc_periodo,
            k.lc_numerofactura,
            k.lc_tipoiva AS tiva,
            ((('94-PAGO DE PRESTAMOS '::text || ' ESTADO '::text) || m.descripcion::text) || ' '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM librocompras k
             LEFT JOIN proveedor q ON k.lc_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.lc_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.tuestado_id = m.id
             LEFT JOIN deducible x ON k.tudeducible_id = x.id
          WHERE k.tutipomov_id = 8104 AND k.tudeducible_id = 1681
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.cre_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
             k.cre_contribuyente  as cta_codigo,                  
            to_char(k.cre_fecha::date,'YYYY/MM/DD') AS lc_fecha,
            (k.cre_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.cre_montoexento AS exento,
            k.cre_totalgravada10 AS grav10,
            k.cre_montoiva10 AS iva10,
            k.cre_totalgravadas5 AS grav5,
            k.cre_montoiva5 AS iva5,
            k.cre_montototal AS total,
            to_char(k.cre_fecha, 'YYYY/99'::text) AS lc_periodo,
            k.cre_numerofactura AS lc_numerofactura,
            k.cre_tipoiva AS tiva,
            ((('96-COMPRAS RETRASADAS'::text || ' ESTADO '::text) || m.descripcion::text) || ' NO DEDUCIBLE '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM comprasretrasadas k
             LEFT JOIN proveedor q ON k.cre_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.cre_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.cre_tuestado_id = m.id
             LEFT JOIN deducible x ON k.cre_tudeducible_id = x.id
          WHERE k.cre_tutipomov_id = 22211 AND k.cre_tudeducible_id = 1681
        UNION ALL
         SELECT 1 AS q22,
            k.id,
            0 AS version,
            (k.cre_contribuyente || '-'::text) || t.cte_nombre::text AS contribuyente,
       k.cre_contribuyente as cta_codigo,                  
            to_char(k.cre_fecha::date,'YYYY/MM/DD') AS lc_fecha,
            (k.cre_proveedor_ruc::text || '-'::text) || q.prv_nombre::text AS proveedor,
            k.cre_montoexento AS exento,
            k.cre_totalgravada10 AS grav10,
            k.cre_montoiva10 AS iva10,
            k.cre_totalgravadas5 AS grav5,
            k.cre_montoiva5 AS iva5,
            k.cre_montototal AS total,
            to_char(k.cre_fecha, 'YYYY/99'::text) AS lc_periodo,
            k.cre_numerofactura AS lc_numerofactura,
            k.cre_tipoiva AS tiva,
            ((('96-COMPRAS RETRASADAS'::text || ' ESTADO '::text) || m.descripcion::text) || ' NO DEDUCIBLE '::text) || x.descripcion::text AS tipomov,
            k.datecreated,
            k.lastupdated,
            k.usuario,
            k.modificadopor
           FROM comprasretrasadas k
             LEFT JOIN proveedor q ON k.cre_proveedor_ruc::text = q.prv_codigo::text
             LEFT JOIN contribuyente t ON k.cre_contribuyente = t.cte_codigo
             LEFT JOIN estado m ON k.cre_tuestado_id = m.id
             LEFT JOIN deducible x ON k.cre_tudeducible_id = x.id
          WHERE k.cre_tutipomov_id = 22211 AND k.cre_tudeducible_id = 1682) narices
     JOIN vista_elultimo w ON ( narices.lc_periodo = w.yyyymm AND narices.cta_codigo = w.cte_codigo );
