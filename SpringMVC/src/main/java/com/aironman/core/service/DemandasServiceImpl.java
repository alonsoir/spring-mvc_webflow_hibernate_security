package com.aironman.core.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aironman.core.dao.DemandasDao;
import com.aironman.core.dao.HistoricoDemandasDao;
import com.aironman.core.pojos.Abogados;
import com.aironman.core.pojos.Demandas;
import com.aironman.core.pojos.Demandas.ESTADO_DEMANDA;
import com.aironman.core.pojos.HistoricoDemandasViviendasAdeudadas;
import com.aironman.core.pojos.Users;
import com.aironman.core.pojos.ViviendasConDeudas;

@Service("demandasService")
@Transactional(readOnly = true)
public class DemandasServiceImpl implements DemandasService {

	private static final Logger LOG = LoggerFactory
			.getLogger(DemandasServiceImpl.class);

	@Autowired
	private UserService userService;

	@Autowired
	private DemandasDao demandasDao;

	@Autowired
	private HistoricoDemandasDao historicoDemandasDao;

	@Override
	@Transactional(readOnly = false)
	public boolean asignarAbogadoADemanda(Demandas demanda, Abogados abogado) {

		return demandasDao.asignarAbogadoADemanda(demanda, abogado);
	}

	@Override
	@Transactional(readOnly = false)
	public Long crearDemandaYAsociarAUsuario(String username,
			String rutaFisicaDemanda, Long idDeuda) {

		List<Users> listaUsuarioLogado = userService.findUsers(username);
		Users userLogado = null;
		if (listaUsuarioLogado != null && listaUsuarioLogado.size() > 0) {
			userLogado = listaUsuarioLogado.get(0);
			LOG.info("Usuario logado: " + userLogado.getUserName());
		}
		Demandas demanda = new Demandas();
		demanda.setUsuario(userLogado);
		demanda.setEstado(ESTADO_DEMANDA.ENVIADA_A_JURIDIA);
		demanda.setFechaInicio(Calendar.getInstance().getTime());
		Long o = (Long) demandasDao.generarDemanda(demanda);
		LOG.info("idDemanda: " + o);
		return o;
	}

	@Override
	@Transactional(readOnly = false)
	public void crearHistoricoDemanda(String rutaFisicaDemanda, Long idDeuda,
			Long idDemanda) {

		// dependencias para crear la demanda SE CREAN DESPUES DE CREAR EL PADRE
		Collection<HistoricoDemandasViviendasAdeudadas> colhistoricoDemanda = new ArrayList<HistoricoDemandasViviendasAdeudadas>();

		HistoricoDemandasViviendasAdeudadas historicoDemandasViviendasAdeudadas = new HistoricoDemandasViviendasAdeudadas();

		Demandas demanda = new Demandas();
		demanda.setIdDemanda(idDemanda);
		historicoDemandasViviendasAdeudadas.setDemanda(demanda);

		ViviendasConDeudas pojoFincas = new ViviendasConDeudas();
		pojoFincas.setIdDeuda(idDeuda);
		historicoDemandasViviendasAdeudadas.setDeudora(pojoFincas);

		historicoDemandasViviendasAdeudadas
				.setRutaFisicaDemanda(rutaFisicaDemanda);

		colhistoricoDemanda.add(historicoDemandasViviendasAdeudadas);

		historicoDemandasDao
				.crearHistoricoDemanda(historicoDemandasViviendasAdeudadas);
	}

	@Override
	@Secured("ROLE_ADMIN")
	public Demandas traerDemanda(Long idDemanda) {
		// TODO Auto-generated method stub
		return demandasDao.findById(idDemanda);
	}
}
