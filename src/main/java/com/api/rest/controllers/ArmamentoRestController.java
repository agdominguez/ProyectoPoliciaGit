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

import com.api.rest.models.entity.Armamento;
import com.api.rest.models.services.IArmamentoService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/armamento")
public class ArmamentoRestController extends CommonRestController<Armamento, IArmamentoService> {

	@PutMapping(value = "/{id}")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Armamento armamento, BindingResult result,
			@PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		Armamento armamentoActual = service.findById(id);
		if (armamentoActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}
		// ActualizaCampos
		armamentoActual.setDependencia(armamento.getDependencia());
		armamentoActual.setNombre(armamento.getNombre());
		armamentoActual.setDescripcion(armamento.getDescripcion());
		armamentoActual.setTipoArma(armamento.getTipoArma());
		armamentoActual.setCodigoArma(armamento.getCodigoArma());
		Armamento armamentoUpdate = service.save(armamentoActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", armamentoUpdate);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/{id}/eliminar")
	public ResponseEntity<Map<String, Object>> statusEliminado(@PathVariable Long id) {
		Armamento armamento = service.findById(id);

		if (armamento == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede eliminar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		armamento.setEliminado('S');
		Armamento armamentoEliminado = service.save(armamento);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido marcado como eliminado con Ã©xito");
		response.put("elemento", armamentoEliminado);
		return ResponseEntity.ok(response);
	}
}
