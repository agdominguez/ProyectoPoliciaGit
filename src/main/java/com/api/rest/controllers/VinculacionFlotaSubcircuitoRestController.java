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

import com.api.rest.models.entity.VinculacionFlotaSubcircuito;
import com.api.rest.models.services.IVinculacionFlotaSubcircuitoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vinculacionFlotaSubcircuito")
public class VinculacionFlotaSubcircuitoRestController
		extends CommonRestController<VinculacionFlotaSubcircuito, IVinculacionFlotaSubcircuitoService> {

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody VinculacionFlotaSubcircuito vinculacionFlotaSubcircuito,
			BindingResult result, @PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		VinculacionFlotaSubcircuito vinculacionActual = service.findById(id);
		if (vinculacionActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		// Actualizar campos
		vinculacionActual.setDependencia(vinculacionFlotaSubcircuito.getDependencia());
		VinculacionFlotaSubcircuito vinculacionUpdate = service.save(vinculacionActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", vinculacionUpdate);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/eliminar")
	public ResponseEntity<Map<String, Object>> statusEliminado(@PathVariable Long id) {

		VinculacionFlotaSubcircuito vinculacionFlotaSubcircuito = service.findById(id);

		if (vinculacionFlotaSubcircuito == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede eliminar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		vinculacionFlotaSubcircuito.setEliminado('S');
		VinculacionFlotaSubcircuito vinculacionEliminado = service.save(vinculacionFlotaSubcircuito);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido marcado como eliminado con éxito");
		response.put("elemento", vinculacionEliminado);
		return ResponseEntity.ok(response);
	}

}
