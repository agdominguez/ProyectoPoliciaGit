package com.api.rest.models.servicesImpl;

import org.springframework.stereotype.Service;

import com.api.rest.models.dao.ITipoVehiculoDao;
import com.api.rest.models.entity.TipoVehiculo;
import com.api.rest.models.services.ITipoVehiculoService;
import com.bst.app.commons.servicesImpl.CommonServiceImpl;

@Service
public class TipoVehiculoServiceImpl extends CommonServiceImpl<TipoVehiculo> implements ITipoVehiculoService {

	public TipoVehiculoServiceImpl(ITipoVehiculoDao tipoVehiculoDao) {
		super(tipoVehiculoDao);
	}

}
