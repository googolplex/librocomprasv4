drop view vista_ultimo_inversionesinforme ;
create view vista_ultimo_inversionesinforme as 
select cast(inv_yyyy as  text)  as inv_yyyy,idcontrib_id,cte_codigo from inversionesinforme k
LEFT JOIN contribuyente t ON k.idcontrib_id = t.id
where k.lastupdated in (select max(lastupdated) from inversionesinforme w)
