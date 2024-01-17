package com.api.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.Dependencia;
import com.api.rest.models.services.IDependenciaService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dependencia")
public class DependenciaRestController extends CommonRestController<Dependencia, IDependenciaService> {

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody Dependencia dependencia, BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		Dependencia dependenciaActual = service.findById(id);
		if (dependenciaActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		// Actualizar campos
		dependenciaActual.setNombre(dependencia.getNombre());
		dependenciaActual.setSiglas(dependencia.getSiglas());
		dependenciaActual.setCodigoCircuitoSubcircuito(dependencia.getCodigoCircuitoSubcircuito());
		Dependencia dependenciaUpdate = service.save(dependenciaActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", dependenciaUpdate);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/eliminar")
	public ResponseEntity<Map<String, Object>> statusEliminado(@PathVariable Long id) {

		Dependencia dependencia = service.findById(id);

		if (dependencia == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede eliminar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		dependencia.setEliminado('S');
		Dependencia dependenciaEliminado = service.save(dependencia);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido marcado como eliminado con éxito");
		response.put("elemento", dependenciaEliminado);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/listado")
	@PreAuthorize("admin")
	public ResponseEntity<List<Dependencia>> indexNotDeleted() {
		List<Dependencia> entities = service.findAllNotDeleted();

		if (entities.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(entities);
		}
	}

}
