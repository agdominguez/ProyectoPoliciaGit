package com.api.rest.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.Solicitud;
import com.api.rest.models.services.ISolicitudService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/solicitud")
public class SolicitudRestController extends CommonRestController<Solicitud, ISolicitudService>  {

	@PostMapping(value = "/p_actualiza_estado")
	public ResponseEntity<Map<String, Object>> p_actualiza_estado(@RequestBody Solicitud solicitud) {
		return ResponseEntity.ok(service.p_actualiza_estado(
				solicitud.getCodigo(), 
				solicitud.getEstado()));
	}
}
