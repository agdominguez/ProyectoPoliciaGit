package com.api.rest.models.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ISolicitudDao;
import com.api.rest.models.entity.Solicitud;
import com.api.rest.models.services.ISolicitudService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class SolicitudServiceImpl extends CommonServiceImpl<Solicitud> implements ISolicitudService {

	@Autowired
	ISolicitudDao solicitudDao;
	
	public SolicitudServiceImpl(ISolicitudDao solicitudDao) {
		super(solicitudDao);
	}

	@Override
	public Map<String, Object> p_actualiza_estado(Long p_codigo_solicitud, Character p_estado) {
		return solicitudDao.p_actualiza_estado(p_codigo_solicitud, p_estado);
	}

}
