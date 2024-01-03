package com.api.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.TipoVehiculo;
import com.api.rest.models.services.ITipoVehiculoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipoVehiculo")
public class TipoVehiculoRestController extends CommonRestController<TipoVehiculo, ITipoVehiculoService> {

}
