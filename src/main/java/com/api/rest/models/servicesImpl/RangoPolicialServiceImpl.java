package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IRangoPolicialDao;
import com.api.rest.models.entity.RangoPolicial;
import com.api.rest.models.services.IRangoPolicialService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;


@Service
public class RangoPolicialServiceImpl extends CommonServiceImpl<RangoPolicial> implements IRangoPolicialService {

	public RangoPolicialServiceImpl(IRangoPolicialDao rangoPolicialDao) {
		super(rangoPolicialDao);
	}
}
