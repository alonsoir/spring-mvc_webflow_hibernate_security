package com.aironman.core.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.ComunidadesDao;
import com.aironman.core.dao.UserDao;
import com.aironman.core.pojos.ComunidadVecinos;
import com.aironman.core.pojos.JuntasOrdinarias;
import com.aironman.core.pojos.Users;

@Service("comunidadService")
@Transactional(readOnly = true)
public class ComunidadServiceImpl implements ComunidadService {

	private static final Logger LOG = LoggerFactory
			.getLogger(ComunidadServiceImpl.class);
	@Autowired
	private ComunidadesDao comunidadesDao;

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional(readOnly = false)
	public boolean addComunidadVecinos(ComunidadVecinos comunidad,
			JuntasOrdinarias juntas, Users users, String username) {

		LOG.info("addComunidadVecinos. username: " + username);
		boolean retorno = true;
		ComunidadVecinos comunidadVecinosExistente = getComunidadVecinosByCriterion(
				comunidad.getRefCatastral(), comunidad.getDireccion());
		if (comunidadVecinosExistente != null) {
			LOG.info("addComunidadVecinos. Comunidad existente en el sistema. Hay una comunidad con esa refCatastral o con esa direccion. Vamos a actualizarla. "
					+ comunidadVecinosExistente.toString());
			comunidad
					.setIdComunidad(comunidadVecinosExistente.getIdComunidad());
			retorno = false;
		}

		if (juntas != null && juntas.getIdJunta() != null) {
			LOG.info("addComunidadVecinos. junta: " + juntas.toString());
			comunidad.setJunta(juntas);
		}
		// me traigo el usuario logado en el contexto de spring security, esto
		// me gustaria tenerlo en un aspecto
		List<Users> listaUsers = userDao.findUsers(username);
		Users userTraido = listaUsers.get(0);
		users.setUserName(username);
		users.setUserId(userTraido.getUserId());
		comunidad.setUsuario(users);

		comunidadesDao.addComunidadVecinos(comunidad);
		return retorno;
	}

	@Override
	public ComunidadVecinos getComunidadVecinosByDireccion(String direccion) {
		// TODO Auto-generated method stub
		ComunidadVecinos comunidadVecinos = comunidadesDao
				.getComunidadVecinosByDireccion(direccion);
		LOG.info(comunidadVecinos.toString());
		return comunidadVecinos;
	}

	@Override
	public boolean existsComunidad(String key) {
		// TODO Auto-generated method stub
		return comunidadesDao.findById(key) != null ? true : false;
	}

	@Override
	public ComunidadVecinos getComunidadVecinosByCriterion(String refCatastral,
			String direccion) {
		ComunidadVecinos comunidadVecinos = comunidadesDao
				.getComunidadVecinosByCriterion(refCatastral, direccion);
		return comunidadVecinos;
	}

}
