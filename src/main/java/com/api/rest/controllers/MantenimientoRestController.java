package com.api.rest.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.Mantenimiento;
import com.api.rest.models.services.IMantenimientoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mantenimiento")
public class MantenimientoRestController extends CommonRestController<Mantenimiento, IMantenimientoService> {
	
	@PostMapping(value = "/p_inserta_mantenimiento")
	public ResponseEntity<Map<String, Object>> p_inserta_mantenimiento(
			@RequestBody Mantenimiento mantenimiento) {
		return ResponseEntity.ok(service.p_inserta_mantenimiento(
				mantenimiento.getSolicitud().getCodigo(), 
				mantenimiento.getAsunto(), 
				mantenimiento.getDetalle(), 
				mantenimiento.getKilometrajeActual()));
	}

}
