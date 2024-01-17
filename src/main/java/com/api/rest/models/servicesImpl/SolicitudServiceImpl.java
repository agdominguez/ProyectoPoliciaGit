package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ISolicitudDao;
import com.api.rest.models.entity.Solicitud;
import com.api.rest.models.services.ISolicitudService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class SolicitudServiceImpl extends CommonServiceImpl<Solicitud> implements ISolicitudService {

	public SolicitudServiceImpl(ISolicitudDao solicitudDao) {
		super(solicitudDao);
	}

}
