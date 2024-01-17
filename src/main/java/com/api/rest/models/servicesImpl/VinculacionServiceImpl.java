package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IVinculacionDao;
import com.api.rest.models.entity.Vinculacion;
import com.api.rest.models.services.IVinculacionService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class VinculacionServiceImpl extends CommonServiceImpl<Vinculacion>
		implements IVinculacionService {

	public VinculacionServiceImpl(IVinculacionDao vinculacionFlotaPersonalDao) {
		super(vinculacionFlotaPersonalDao);
	}
}
