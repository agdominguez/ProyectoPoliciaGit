package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IFlotaVehicularDao;
import com.api.rest.models.entity.FlotaVehicular;
import com.api.rest.models.services.IFlotaVehicularService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class FlotaVehicularServiceImpl extends CommonServiceImpl<FlotaVehicular>
		implements IFlotaVehicularService {

	public FlotaVehicularServiceImpl(IFlotaVehicularDao flotaVehicularDao) {
		super(flotaVehicularDao);
	}

}
