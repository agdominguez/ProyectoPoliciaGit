package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IArmamentoDao;
import com.api.rest.models.entity.Armamento;
import com.api.rest.models.services.IArmamentoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;


@Service
public class ArmamentoServiceImpl extends CommonServiceImpl<Armamento> implements IArmamentoService {

	public ArmamentoServiceImpl(IArmamentoDao armamentoDao) {
		super(armamentoDao);
	}
}
