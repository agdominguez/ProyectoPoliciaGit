package com.api.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.MantenimientoTipo;
import com.api.rest.models.services.IMantenimientoTipoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mantenimientoTipo")
public class MantenimientoTipoRestController extends CommonRestController<MantenimientoTipo, IMantenimientoTipoService> {

}
