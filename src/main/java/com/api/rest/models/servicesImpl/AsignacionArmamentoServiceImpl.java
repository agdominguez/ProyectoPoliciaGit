package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IAsignacionArmamentoDao;
import com.api.rest.models.entity.AsignacionArmamento;
import com.api.rest.models.services.IAsignacionArmamentoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;


@Service
public class AsignacionArmamentoServiceImpl extends CommonServiceImpl<AsignacionArmamento> implements IAsignacionArmamentoService {

	public AsignacionArmamentoServiceImpl(IAsignacionArmamentoDao asignacionArmamentoDao) {
		super(asignacionArmamentoDao);
	}
}
