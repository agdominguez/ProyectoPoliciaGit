package com.api.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.OrdenTrabajo;
import com.api.rest.models.services.IOrdeTrabajoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ordenTrabajo")
public class OrdenTrabajoRestController extends CommonRestController<OrdenTrabajo, IOrdeTrabajoService> {

	@PostMapping(value = "/p_actualiza_estado_orden")
	public ResponseEntity<Map<String, Object>> p_actualiza_estado_orden(@RequestBody OrdenTrabajo ordenTrabajo) {
		return ResponseEntity.ok(service.p_actualiza_estado_orden(ordenTrabajo.getCodigo(), ordenTrabajo.getEstado()));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Map<String, Object>> update(@RequestBody OrdenTrabajo ordenTrabajo, BindingResult result,
			@PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		OrdenTrabajo ordenTrabajoActual = service.findById(id);
		if (ordenTrabajoActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}
		// ActualizaCampos
		ordenTrabajoActual.setKilometrajeMantenimiento(ordenTrabajo.getKilometrajeMantenimiento());
		OrdenTrabajo fondeoCajaUpdate = service.save(ordenTrabajoActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", fondeoCajaUpdate);
		return ResponseEntity.ok(response);
	}
}
