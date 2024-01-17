package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ITipoContratoDao;
import com.api.rest.models.entity.TipoContrato;
import com.api.rest.models.services.ITipoContratoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class TipoContratoServiceImpl extends CommonServiceImpl<TipoContrato> implements ITipoContratoService {

	public TipoContratoServiceImpl(ITipoContratoDao tipoContratoDao) {
		super(tipoContratoDao);
	}
}
