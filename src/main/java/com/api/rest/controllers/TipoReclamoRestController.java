package com.api.rest.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.TipoReclamo;
import com.api.rest.models.services.ITipoReclamoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipoReclamo")
public class TipoReclamoRestController extends CommonRestController<TipoReclamo, ITipoReclamoService> {

	@GetMapping("/listado")
	@PreAuthorize("admin")
	public ResponseEntity<List<TipoReclamo>> indexNotDeleted() {
		List<TipoReclamo> entities = service.findAllNotDeleted();

		if (entities.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(entities);
		}
	}
}
