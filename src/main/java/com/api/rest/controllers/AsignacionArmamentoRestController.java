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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.AsignacionArmamento;
import com.api.rest.models.services.IAsignacionArmamentoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/asignacionArmamento")
public class AsignacionArmamentoRestController extends CommonRestController<AsignacionArmamento, IAsignacionArmamentoService> {

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody AsignacionArmamento asignacionArmamento,
			BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		AsignacionArmamento asignacionArmamentoActual = service.findById(id);
		if (asignacionArmamentoActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		// Actualizar campos
		asignacionArmamentoActual.setArmamento(asignacionArmamento.getArmamento());
		AsignacionArmamento asignacionArmamentoUpdate = service.save(asignacionArmamentoActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", asignacionArmamentoUpdate);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/eliminar")
	public ResponseEntity<Map<String, Object>> statusEliminado(@PathVariable Long id) {

		AsignacionArmamento asignacionArmamento = service.findById(id);

		if (asignacionArmamento == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede eliminar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		asignacionArmamento.setEliminado('S');
		AsignacionArmamento asignacionArmamentoEliminado = service.save(asignacionArmamento);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido marcado como eliminado con éxito");
		response.put("elemento", asignacionArmamentoEliminado);
		return ResponseEntity.ok(response);
	}
}
