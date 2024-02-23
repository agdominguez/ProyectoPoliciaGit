package com.api.rest.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.MantenimientoTipo;
import com.api.rest.models.services.IMantenimientoTipoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mantenimientoTipo")
public class MantenimientoTipoRestController
		extends CommonRestController<MantenimientoTipo, IMantenimientoTipoService> {

	@PostMapping(value = "/p_inserta_detalle_mantenimiento")
	public ResponseEntity<Map<String, Object>> p_inserta_mantenimiento(
			@RequestBody List<MantenimientoTipo> mantenimientoTipoList) {

		Map<String, Object> response = new HashMap<>();
		List<String> errores = new ArrayList<>();

		for (MantenimientoTipo item : mantenimientoTipoList) {
			try {
				service.save(item);
			} catch (Exception e) {
				errores.add("Error al guardar el elemento: " + e.getMessage());
			}
		}
		if (errores.isEmpty()) {
			response.put("mensaje", "Los elementos han sido creados con éxito");
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} else {
			response.put("error", errores);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

}
