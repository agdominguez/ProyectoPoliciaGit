package com.api.rest.models.servicesImpl;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IMantenimientoDao;
import com.api.rest.models.entity.Mantenimiento;
import com.api.rest.models.services.IMantenimientoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class MantenimientoServiceImpl extends CommonServiceImpl<Mantenimiento> implements IMantenimientoService {

	@Autowired
	IMantenimientoDao mantenimientoDao;

	public MantenimientoServiceImpl(IMantenimientoDao mantenimientoDao) {
		super(mantenimientoDao);
	}

	@Override
	public Map<String, Object> p_inserta_mantenimiento(Long p_codigo_solicitud, String p_asunto, String p_detalle,
			BigDecimal p_kilometraje_actual) {
		return mantenimientoDao.p_inserta_mantenimiento(p_codigo_solicitud, p_asunto, p_detalle, p_kilometraje_actual);
	}

}
