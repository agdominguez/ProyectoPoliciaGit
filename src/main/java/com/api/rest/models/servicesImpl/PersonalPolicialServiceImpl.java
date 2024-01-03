package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.IPersonalPolicialDao;
import com.api.rest.models.entity.PersonalPolicial;
import com.api.rest.models.services.IPersonalPolicialService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class PersonalPolicialServiceImpl extends CommonServiceImpl<PersonalPolicial>
		implements IPersonalPolicialService {

	public PersonalPolicialServiceImpl(IPersonalPolicialDao personalPolicialDao) {
		super(personalPolicialDao);
	}
}
