package com.api.rest.models.services;

import java.math.BigDecimal;
import java.util.Map;

import com.api.rest.models.entity.Mantenimiento;
import com.bst.app.commons.services.ICommonService;

public interface IMantenimientoService extends ICommonService<Mantenimiento> {

	public Map<String, Object> p_inserta_mantenimiento(Long p_codigo_solicitud, String p_asunto, String p_detalle,
			BigDecimal p_kilometraje_actual);

}
