package com.api.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.TipoMantenimiento;
import com.api.rest.models.services.ITipoMantenimientoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipoMantenimiento")
public class TipoMantenimientoRestController extends CommonRestController<TipoMantenimiento, ITipoMantenimientoService> {

}
