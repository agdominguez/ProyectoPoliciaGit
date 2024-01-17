package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ISugerenciaDao;
import com.api.rest.models.entity.Sugerencia;
import com.api.rest.models.services.ISugerenciaService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class SugerenciaServiceImpl extends CommonServiceImpl<Sugerencia> implements ISugerenciaService {

	public SugerenciaServiceImpl(ISugerenciaDao sugerenciaDao) {
		super(sugerenciaDao);
	}
}
