package com.api.rest.models.servicesImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IOrdenTrabajoDao;
import com.api.rest.models.entity.OrdenTrabajo;
import com.api.rest.models.services.IOrdeTrabajoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class OrdenTrabajoServiceImpl extends CommonServiceImpl<OrdenTrabajo> implements IOrdeTrabajoService {

	@Autowired
	IOrdenTrabajoDao ordenTrabajoDao;

	public OrdenTrabajoServiceImpl(IOrdenTrabajoDao ordenTrabajoDao) {
		super(ordenTrabajoDao);
	}

	@Override
	public Map<String, Object> p_actualiza_estado_orden(Long p_codigo_orden, Character p_estado) {
		return ordenTrabajoDao.p_actualiza_estado_orden(p_codigo_orden, p_estado);
	}

}
