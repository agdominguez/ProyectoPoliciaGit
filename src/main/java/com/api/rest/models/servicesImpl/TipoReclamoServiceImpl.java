package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ITipoReclamoDao;
import com.api.rest.models.entity.TipoReclamo;
import com.api.rest.models.services.ITipoReclamoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class TipoReclamoServiceImpl extends CommonServiceImpl<TipoReclamo> implements ITipoReclamoService {

	public TipoReclamoServiceImpl(ITipoReclamoDao tipoReclamoDao) {
		super(tipoReclamoDao);
	}
}
