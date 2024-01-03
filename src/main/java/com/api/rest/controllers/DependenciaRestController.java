package com.api.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.Dependencia;
import com.api.rest.models.services.IDependenciaService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dependencia")
public class DependenciaRestController extends CommonRestController<Dependencia, IDependenciaService> {

}
