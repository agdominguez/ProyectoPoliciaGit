package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IMantenimientoTipoDao;
import com.api.rest.models.entity.MantenimientoTipo;
import com.api.rest.models.services.IMantenimientoTipoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class MantenimientoTipoServiceImpl extends CommonServiceImpl<MantenimientoTipo> implements IMantenimientoTipoService {

	public MantenimientoTipoServiceImpl(IMantenimientoTipoDao mantenimientoTipoDao) {
		super(mantenimientoTipoDao);
	}
}
