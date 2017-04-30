drop view vista_ultimo_inversiones ;
CREATE OR REPLACE VIEW public.vista_ultimo_inversiones as
select cast(g.inv_yyyy as text) as inv_yyyy,g.idprov_id, j.cte_codigo
from inversionesyyyy g 
inner join vista_ultimo_inversionesinforme j on g.idcontrib_id  = j.idcontrib_id 
		and cast(g.inv_yyyy as text) = j.inv_yyyy
