package com.api.rest.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.RangoPolicial;
import com.api.rest.models.services.IRangoPolicialService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rangoPolicial")
public class RangoPolicialRestController extends CommonRestController<RangoPolicial, IRangoPolicialService> {

}
