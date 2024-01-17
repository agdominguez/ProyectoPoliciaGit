package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ITipoMantenimientoDao;
import com.api.rest.models.entity.TipoMantenimiento;
import com.api.rest.models.services.ITipoMantenimientoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class TipoMantenimientoServiceImpl extends CommonServiceImpl<TipoMantenimiento> implements ITipoMantenimientoService {

	public TipoMantenimientoServiceImpl(ITipoMantenimientoDao tipoMantenimientoDao) {
		super(tipoMantenimientoDao);
	}
}
