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

import com.api.rest.models.entity.FlotaVehicular;
import com.api.rest.models.services.IFlotaVehicularService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flotaVehicular")
public class FlotaVehicularRestController extends CommonRestController<FlotaVehicular, IFlotaVehicularService> {

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@RequestBody FlotaVehicular flotaVehicular, BindingResult result,
			@PathVariable Long id) {

		if (result.hasErrors()) {
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			Map<String, Object> response = new HashMap<>();
			response.put("errors", errors);
			return ResponseEntity.badRequest().body(response);
		}

		FlotaVehicular flotaVehicularActual = service.findById(id);
		if (flotaVehicularActual == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede editar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		// Actualizar campos
		flotaVehicularActual.setTipoVehiculo(flotaVehicular.getTipoVehiculo());
		flotaVehicularActual.setPlaca(flotaVehicular.getPlaca());
		flotaVehicularActual.setChasis(flotaVehicular.getChasis());
		flotaVehicularActual.setMarca(flotaVehicular.getMarca());
		flotaVehicularActual.setChasis(flotaVehicular.getChasis());
		flotaVehicularActual.setModelo(flotaVehicular.getModelo());
		flotaVehicularActual.setMotor(flotaVehicular.getMotor());
		flotaVehicularActual.setKilometraje(flotaVehicular.getKilometraje());
		flotaVehicularActual.setCilindraje(flotaVehicular.getCilindraje());
		flotaVehicularActual.setCapacidadCarga(flotaVehicular.getCapacidadCarga());
		flotaVehicularActual.setCapacidadPasajeros(flotaVehicular.getCapacidadPasajeros());
		FlotaVehicular flotaVehicularUpdate = service.save(flotaVehicularActual);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido actualizado con éxito");
		response.put("elemento", flotaVehicularUpdate);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/{id}/eliminar")
	public ResponseEntity<Map<String, Object>> statusEliminado(@PathVariable Long id) {
		FlotaVehicular flotaVehicular = service.findById(id);

		if (flotaVehicular == null) {
			Map<String, Object> response = new HashMap<>();
			response.put("mensaje",
					"Error: No se puede eliminar, el elemento con el id: " + id + " no existe en la base de datos");
			return ((BodyBuilder) ResponseEntity.notFound()).body(response);
		}

		flotaVehicular.setEliminado('S');
		FlotaVehicular flotaVehicularEliminado = service.save(flotaVehicular);

		Map<String, Object> response = new HashMap<>();
		response.put("mensaje", "El elemento ha sido marcado como eliminado con éxito");
		response.put("elemento", flotaVehicularEliminado);
		return ResponseEntity.ok(response);
	}

}
