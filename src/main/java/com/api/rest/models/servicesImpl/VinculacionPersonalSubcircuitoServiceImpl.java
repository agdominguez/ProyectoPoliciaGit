package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IVinculacionPersonalSubcircuitoDao;
import com.api.rest.models.entity.VinculacionPersonalSubcircuito;
import com.api.rest.models.services.IVinculacionPersonalSubcircuitoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class VinculacionPersonalSubcircuitoServiceImpl extends CommonServiceImpl<VinculacionPersonalSubcircuito>
		implements IVinculacionPersonalSubcircuitoService {

	public VinculacionPersonalSubcircuitoServiceImpl(
			IVinculacionPersonalSubcircuitoDao vinculacionPersonalSubcircuitoDao) {
		super(vinculacionPersonalSubcircuitoDao);
	}
}
