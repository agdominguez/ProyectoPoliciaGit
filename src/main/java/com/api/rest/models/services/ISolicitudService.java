package com.api.rest.models.services;

import java.util.Map;

import com.api.rest.models.entity.Solicitud;
import com.bst.app.commons.services.ICommonService;

public interface ISolicitudService extends ICommonService<Solicitud> {

	public Map<String, Object> p_actualiza_estado(Long p_codigo_solicitud, Character p_estado);
}
