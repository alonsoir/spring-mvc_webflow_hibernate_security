#a nice sentence :)

select mor.cp as CP_MOROSO, 
       mor.direccion as DIRECCION_MOROSO,
       mor.nifcif as NIFCIF_MOROSO,
       mor.nombre AS NOMBRE_MOROSO,
       mor.telefono AS TLF_MOROSO,
       mor.ciudad AS CIUDAD_MOROSO,
       comunidad.ciudad AS CIUDAD_COMUNIDAD,
       comunidad.nombrecomunidad AS NOMBRE_COMUNIDAD,
       comunidad.direccion AS DIRECCION_COMUNIDAD,
       comunidad.adminfincas AS ADMIN_COMUNIDAD,
       comunidad.presidente AS PRESI_COMUNIDAD,
       juntas.fechacelebracion AS FECHA_CELEBRACION_JUNTAS,
       juntas.textolibre AS TEXTO_LIBRE_JUNTAS
from users as u, comunidadvecinos as comunidad, viviendascondeudas as vivi,moroso as mor,juntas_ordinarias as juntas
where u.user_id=comunidad.usuario_user_id				AND
	  comunidad.junta_idjunta = juntas.idjunta              AND
      comunidad.idcomunidad  = vivi.comunidad_idcomunidad AND
      mor.idmoroso = vivi.moroso_idmoroso                   AND
      u.username=$P{USERNAME}								AND
      vivi.iddeuda=$P{IDDEUDA}
      
      

