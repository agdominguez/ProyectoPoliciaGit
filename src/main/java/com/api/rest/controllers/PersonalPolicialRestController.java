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

import com.api.rest.models.entity.PersonalPolicial;
import com.api.rest.models.services.IPersonalPolicialService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/personalPolicial")
public class PersonalPolicialRestController extends CommonRestController<PersonalPolicial, IPersonalPolicialService> {

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody PersonalPolicial personalPolicial, BindingResult result,
			@PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		PersonalPolicial personalPolicialActual = service.findById(id);
		if (personalPolicialActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		// Actualizar campos
		personalPolicialActual.setIdentificacion(personalPolicial.getIdentificacion());
		personalPolicialActual.setNombreCompleto(personalPolicial.getNombreCompleto());
		personalPolicialActual.setFechaNacimiento(personalPolicial.getFechaNacimiento());
		personalPolicialActual.setTipoSangre(personalPolicial.getTipoSangre());
		personalPolicialActual.setCiudadNacimiento(personalPolicial.getCiudadNacimiento());
		personalPolicialActual.setTelefonoCelular(personalPolicial.getTelefonoCelular());
		personalPolicialActual.setRango(personalPolicial.getRango());
		PersonalPolicial personalPolicialUpdate = service.save(personalPolicialActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", personalPolicialUpdate);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/eliminar")
	public ResponseEntity<Map<String, Object>> statusEliminado(@PathVariable Long id) {

		PersonalPolicial personalPolicial = service.findById(id);

		if (personalPolicial == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede eliminar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		personalPolicial.setEliminado('S');
		PersonalPolicial personalPolicialEliminado = service.save(personalPolicial);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido marcado como eliminado con éxito");
		response.put("elemento", personalPolicialEliminado);
		return ResponseEntity.ok(response);
	}

}
