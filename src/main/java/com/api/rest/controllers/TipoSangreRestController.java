package com.api.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.TipoSangre;
import com.api.rest.models.services.ITipoSangreService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipoSangre")
public class TipoSangreRestController extends CommonRestController<TipoSangre, ITipoSangreService> {

}
