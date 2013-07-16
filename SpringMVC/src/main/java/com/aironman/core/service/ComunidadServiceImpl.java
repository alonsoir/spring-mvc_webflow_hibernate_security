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
import com.aironman.core.pojos.ServiceResponse;
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
	public ServiceResponse addComunidadVecinos(ComunidadVecinos comunidad,
			Long idJunta, String username) {

		LOG.info("addComunidadVecinos. username: " + username);

		StringBuilder sbMensajeComResponse = new StringBuilder();

		ServiceResponse comunidadResponse = new ServiceResponse();
		boolean retorno = true;
		ComunidadVecinos comunidadVecinosExistente = this
				.getComunidadVecinosByCriterion(comunidad.getRefCatastral(),
						comunidad.getDireccion());
		if (comunidadVecinosExistente != null) {
			LOG.info("addComunidadVecinos. Comunidad existente en el sistema. Hay una comunidad con esa refCatastral o con esa direccion. "
					+ "refCatastral: "
					+ comunidadVecinosExistente.getRefCatastral()
					+ "dir: "
					+ comunidadVecinosExistente.getDireccion());
			sbMensajeComResponse
					.append("Existe una comunidad con esa referencia catastral.Actualizando.");
			comunidad
					.setIdComunidad(comunidadVecinosExistente.getIdComunidad());
		}
		if (idJunta == null) {
			LOG.info("ATENCION. addComunidadVecinos. junta viene vacio. "
					+ "No se podr‡ generar el certificado si no se actualiza la junta en comunidades.");
			retorno = false;
			comunidadResponse.setEstado(retorno);
			sbMensajeComResponse
					.append("ATENCION. No se podr‡ generar el certificado si no se Introduce los datos de la junta de vecinos.");
		}
		if (idJunta != null) {
			LOG.info("addComunidadVecinos. idJunta: " + idJunta);
			JuntasOrdinarias juntas = new JuntasOrdinarias();
			juntas.setIdJunta(idJunta);
			comunidad.setJunta(juntas);
		}
		// me traigo el usuario logado en el contexto de spring security, esto
		// me gustaria tenerlo en un aspecto
		if (username != null) {
			List<Users> listaUsers = userDao.findUsers(username);
			if (listaUsers == null) {
				retorno = false;
				comunidadResponse.setEstado(retorno);
				sbMensajeComResponse.append("ATENCION. Ud ");
				sbMensajeComResponse.append(username);
				sbMensajeComResponse
						.append(" no tiene permiso para ejecutar esta accion. La accion ha sido reportada al administrador");
			} else if (listaUsers != null && listaUsers.size() == 1) {
				Users userTraido = listaUsers.get(0);
				comunidad.setUsuario(userTraido);
				ComunidadVecinos comunidadInsertada = comunidadesDao
						.addComunidadVecinos(comunidad);
				comunidadResponse.setEstado(comunidadInsertada != null ? true
						: false);
				// guardo el idcomunidad para cuando haya que guardar
				// viviendascondeudas, que es hija de comunidad y moroso
				comunidadResponse
						.setIdGenerado(comunidadInsertada != null ? comunidadInsertada
								.getIdComunidad() : null);
				sbMensajeComResponse
						.append(comunidadInsertada != null ? "Comunidad guardada."
								: "Error al guardar la comunidad!.");
			}
		}
		LOG.info("sbMensajeComResponse: " + sbMensajeComResponse);
		comunidadResponse.setMensaje(sbMensajeComResponse.toString());
		return comunidadResponse;
	}

	@Override
	public ComunidadVecinos getComunidadVecinosByDireccion(String direccion) {
		// TODO Auto-generated method stub
		ComunidadVecinos comunidadVecinos = comunidadesDao
				.getComunidadVecinosByDireccion(direccion);
		LOG.info(comunidadVecinos != null ? "NombreComunidad: "
				+ comunidadVecinos.getNombreComunidad()
				: "COMUNIDAD DADA POR LA DIRECCION " + direccion
						+ " NO EXISTE!");
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
