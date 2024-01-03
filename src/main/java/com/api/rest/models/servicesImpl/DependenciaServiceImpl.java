package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IDependenciaDao;
import com.api.rest.models.entity.Dependencia;
import com.api.rest.models.services.IDependenciaService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class DependenciaServiceImpl extends CommonServiceImpl<Dependencia> implements IDependenciaService {

	public DependenciaServiceImpl(IDependenciaDao dependenciaDao) {
		super(dependenciaDao);
	}
}
