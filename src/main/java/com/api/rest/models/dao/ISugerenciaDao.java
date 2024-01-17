package com.api.rest.models.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.api.rest.models.entity.Sugerencia;
import com.bst.app.commons.dao.ICommonDao;

public interface ISugerenciaDao extends ICommonDao<Sugerencia, Object> {

	@Query("SELECT s FROM Sugerencia s WHERE CONCAT(s.codigo, s.dependencia.dependenciaPadre.nombre, s.dependencia.nombre, apellidos, nombres, contacto, tipoReclamo.nombre) LIKE %?1% AND s.eliminado = 'N'")
	Page<Sugerencia> searchList(String search, Pageable pageable);

	@Query("SELECT s FROM Sugerencia s WHERE s.eliminado = 'N'")
	List<Sugerencia> findAllNotDeleted();

	@Query("SELECT s FROM Sugerencia s WHERE s.eliminado = 'N'")
	Page<Sugerencia> findAllNotDeleted(Pageable pageable);

	@Query("SELECT s FROM Sugerencia s WHERE s.eliminado = 'S'")
	Page<Sugerencia> findAllDeleted(Pageable pageable);

	@Query("SELECT s FROM Sugerencia s WHERE s.fecha BETWEEN ?1 AND ?2")
	List<Sugerencia> findByFechaBetween(String fechaInicio, String fechaFin);
}
