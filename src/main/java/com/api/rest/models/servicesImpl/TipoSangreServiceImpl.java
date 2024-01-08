package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ITipoSangreDao;
import com.api.rest.models.entity.TipoSangre;
import com.api.rest.models.services.ITipoSangreService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class TipoSangreServiceImpl extends CommonServiceImpl<TipoSangre> implements ITipoSangreService {

	public TipoSangreServiceImpl(ITipoSangreDao tipoSangreDao) {
		super(tipoSangreDao);
	}
}
