package com.api.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.Sugerencia;
import com.api.rest.models.services.ISugerenciaService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/sugerencia")
public class SugerenciaRestController extends CommonRestController<Sugerencia, ISugerenciaService> {

	@PostMapping("/nuevo")
	@PreAuthorize("admin")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody Sugerencia entity, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			return ResponseEntity.badRequest().body(errors);
		}
		try {
			service.save(entity);
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje", "El elemento ha sido creado con éxito");
			response.put("elemento", entity);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		} catch (DuplicateKeyException e) {
			// Manejar la excepción de conflicto (HTTP 409)
			String errorMessage = "El elemento ya existe en la base de datos.";
			// Puedes loggear el error, registrar el error o realizar alguna acción de
			// manejo de errores
			return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
		} catch (DataAccessException e) {
			// Otras excepciones de acceso a datos
			String errorMessage = "Error al realizar la operación en la base de datos.";
			// Puedes loggear el error, registrar el error o realizar alguna acción de
			// manejo de errores
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} catch (Exception e) {
			// Captura cualquier otra excepción que no sea DuplicateKeyException ni
			// DataAccessException
			String errorMessage = "Ocurrió un error inesperado.";
			// Puedes loggear el error, registrar el error o realizar alguna acción de
			// manejo de errores
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}
	}
}
