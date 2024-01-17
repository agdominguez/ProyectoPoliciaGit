package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IVinculacionFlotaSubcircuitoDao;
import com.api.rest.models.entity.VinculacionFlotaSubcircuito;
import com.api.rest.models.services.IVinculacionFlotaSubcircuitoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class VinculacionFlotaSubcircuitoServiceImpl extends CommonServiceImpl<VinculacionFlotaSubcircuito>
		implements IVinculacionFlotaSubcircuitoService {

	public VinculacionFlotaSubcircuitoServiceImpl(
			IVinculacionFlotaSubcircuitoDao vinculacionFlotaSubcircuitoDao) {
		super(vinculacionFlotaSubcircuitoDao);
	}
}
