package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IMantenimientoDao;
import com.api.rest.models.entity.Mantenimiento;
import com.api.rest.models.services.IMantenimientoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class MantenimientoServiceImpl extends CommonServiceImpl<Mantenimiento> implements IMantenimientoService {

	public MantenimientoServiceImpl(IMantenimientoDao mantenimientoDao) {
		super(mantenimientoDao);
	}
}
