package com.api.rest.models.services;

import java.util.Map;


import com.api.rest.models.entity.OrdenTrabajo;
import com.bst.app.commons.services.ICommonService;

public interface IOrdeTrabajoService extends ICommonService<OrdenTrabajo> {

	public Map<String, Object> p_actualiza_estado_orden(Long p_codigo_orden, Character p_estado);
}
