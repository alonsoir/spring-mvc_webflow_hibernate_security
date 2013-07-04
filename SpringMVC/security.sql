#pass are generated using sha256 and the seed is the username. Do a google search using "sha256 online"

INSERT INTO users(
            user_id, created_on, enabled, password, username)
    VALUES (1, current_timestamp, true, '30ddcf8aeb67e84ba8dc6792fcc6991703759d4686603413e975c18075e455ed', 'alonsoir');

INSERT INTO users(
            user_id, created_on, enabled, password, username)
    VALUES (2, current_timestamp, true, '56e7d31c5847c36414a7188f3170673ab1b82db94c93a29ca8ff90c1f78aa3eb', 'jocalons');


INSERT INTO users(
            user_id, created_on, enabled, password, username)
    VALUES (3, current_timestamp, true, 'ae87211efc6f28f4a0de16fcdae93fc08581a0c7a0df14309edb44d7c78eb941', 'abogado');

INSERT INTO user_roles(
            user_role_id, authority, user_user_id)
    VALUES (1, 'ROLE_FINCA', 1);
INSERT INTO user_roles(
            user_role_id, authority, user_user_id)
    VALUES (2, 'ROLE_ABOGADO', 3);
INSERT INTO user_roles(
            user_role_id, authority, user_user_id)
    VALUES (3, 'ROLE_ADMIN', 2);

# other useful sentences ;)

select * from moroso;
select * from juntas_ordinarias;

select * from comunidadvecinos;

select * from moroso;

select * from viviendascondeudas;
select * 
from users u, user_roles ur
where u.user_id=ur.user_user_id;

select * from viviendascondeudas;

select h.rutafisicademanda,
	viv.direccion_viv_deudora as direccion_vivienda,
       viv.montante,
       mor.nombre as nombre_moroso,
       mor.telefono as telefono_moroso,d.tipo as estado_demanda, u.username as usuario_logado
from demandas d, historico_demandas_viviendas h,viviendascondeudas viv,comunidadvecinos com,moroso mor,users u
where d.iddemanda = h.demanda_iddemanda 
  AND viv.iddeuda=h.deudora_iddeuda
  AND viv.comunidad_idcomunidad=com.idcomunidad
  AND viv.moroso_idmoroso = mor.idmoroso
  AND d.usuario_user_id = u.user_id
  AND u.username = 'alonsoir';

select * from historico_demandas_viviendas ;

select * from moroso where nifcif='80060898J';
