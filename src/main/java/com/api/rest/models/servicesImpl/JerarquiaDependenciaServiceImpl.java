package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IJerarquiaDependenciaDao;
import com.api.rest.models.entity.JerarquiaDependencia;
import com.api.rest.models.services.IJerarquiaDependenciaService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class JerarquiaDependenciaServiceImpl extends CommonServiceImpl<JerarquiaDependencia>
		implements IJerarquiaDependenciaService {

	public JerarquiaDependenciaServiceImpl(IJerarquiaDependenciaDao jerarquiaDependenciaDao) {
		super(jerarquiaDependenciaDao);
	}

}
