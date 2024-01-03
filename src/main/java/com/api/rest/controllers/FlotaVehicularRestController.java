package com.api.rest.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.rest.models.entity.FlotaVehicular;
import com.api.rest.models.services.IFlotaVehicularService;
import com.bst.app.commons.controllers.CommonRestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/flotaVehicular")
public class FlotaVehicularRestController extends CommonRestController<FlotaVehicular, IFlotaVehicularService> {
	
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
